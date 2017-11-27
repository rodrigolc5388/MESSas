package com.example.rodrigo.messas.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.MenuItem
import android.view.View
import com.example.rodrigo.messas.R
import com.example.rodrigo.messas.adapter.PlatesRecyclerViewAdapter
import com.example.rodrigo.messas.model.Plate
import com.example.rodrigo.messas.model.Plates
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg

class PlatesActivity : AppCompatActivity() {

    companion object {

        fun intent(context: Context): Intent {
            val intent = Intent(context, PlatesActivity::class.java)
            return intent
        }
    }

    lateinit var platesList: RecyclerView
    lateinit var adapter: PlatesRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plates)

        // TITLE AL CENTRO; NOMBRE A UN RECURSO
        supportActionBar?.title = "Platos"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        if (Plates.plates.isEmpty()) {
            updatePlates()
        } else {
            platesListSetter()
        }

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home) {
            // Sabemos que se ha pulsado la flecha de 'back'
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
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
        platesList = findViewById(R.id.plates_list)
        platesList.layoutManager = GridLayoutManager(this, 2)
        platesList.itemAnimator = DefaultItemAnimator()
        adapter = PlatesRecyclerViewAdapter(Plates.plates)
        adapter.onClickListener = View.OnClickListener { v: View ->
            val position = platesList.getChildAdapterPosition(v)
            val plate = Plates.get(position)
            val intent = PlateDetailActivity.intent(this, plate, position)
            intent.addFlags(Intent.FLAG_ACTIVITY_FORWARD_RESULT)
            startActivity(intent)
            finish()
        }
        platesList.adapter = adapter
    }
}
