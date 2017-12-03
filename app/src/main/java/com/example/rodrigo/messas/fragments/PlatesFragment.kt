package com.example.rodrigo.messas.fragments

import android.app.Activity
import android.app.Fragment
import android.content.Context
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rodrigo.messas.R
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
    private var onSelectedPlateListener: OnSelectedPlateListener? = null

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
            onSelectedPlateListener?.onSelectedPlate(plate, position)
            activity.finish()
        }
        platesList.adapter = adapter
    }


    override fun onAttach(context: Context?) {
        super.onAttach(context)
        commonAttach(context)
    }

    override fun onAttach(activity: Activity?) {
        super.onAttach(activity)
        commonAttach(activity)
    }

    override fun onDetach() {
        super.onDetach()
        onSelectedPlateListener = null
    }

    fun commonAttach(listener: Any?) {
        if (listener is OnSelectedPlateListener) {
            onSelectedPlateListener = listener
        }
    }

    interface OnSelectedPlateListener {
        fun onSelectedPlate(plate: Plate, position: Int)
    }
}