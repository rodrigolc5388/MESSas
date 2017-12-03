package com.example.rodrigo.messas.fragments

import android.app.Fragment
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rodrigo.messas.R
import com.example.rodrigo.messas.activity.PlateDetailActivity
import com.example.rodrigo.messas.adapter.PlatesRecyclerViewAdapter
import com.example.rodrigo.messas.model.Plate
import com.example.rodrigo.messas.model.Plates
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg


class PlatesFragment: Fragment() {

    companion object {
        fun newInstance() = PlatesFragment()
    }

    lateinit var root: View
    lateinit var platesList: RecyclerView
    lateinit var adapter: PlatesRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)

        inflater?.let{
            root = it.inflate(R.layout.fragment_plates, container, false)

            if (Plates.plates.isEmpty()) {
                updatePlates()
            } else {
                platesListSetter()
            }
        }
        return root
    }

    fun updatePlates() {
        async(UI){
            val newPlates: Deferred<MutableList<Plate>> = bg {
                Plates.downloadPlates()
            }

            Plates.plates = newPlates.await()
            platesListSetter()
        }

    }

    fun platesListSetter() {
        platesList = root.findViewById(R.id.plates_list)
        platesList.layoutManager = GridLayoutManager(activity, 2)
        platesList.itemAnimator = DefaultItemAnimator()
        adapter = PlatesRecyclerViewAdapter(Plates.plates)
        adapter.onClickListener = View.OnClickListener { v: View ->
            val position = platesList.getChildAdapterPosition(v)
            val plate = Plates.get(position)
            val intent = PlateDetailActivity.intent(activity, plate, position)
            intent.addFlags(Intent.FLAG_ACTIVITY_FORWARD_RESULT)
            startActivity(intent)
            activity.finish()
        }
        platesList.adapter = adapter
    }
}