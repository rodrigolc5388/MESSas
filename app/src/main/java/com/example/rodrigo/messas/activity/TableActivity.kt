package com.example.rodrigo.messas.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.rodrigo.messas.R
import com.example.rodrigo.messas.TableRecyclerViewAdapter
import com.example.rodrigo.messas.model.Plate

class TableActivity : AppCompatActivity() {

    var plates: List<Plate>? = null
        set(value) {
            val adapter = TableRecyclerViewAdapter(value)
            tablePlatesList.adapter = adapter

        }

    lateinit var tablePlatesList: RecyclerView
    // ESTO RECIBE UN `plates: List<Plate> = null`

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_table)

        tablePlatesList = findViewById(R.id.table_plates_list)
        tablePlatesList.layoutManager = GridLayoutManager(this, 2)
        tablePlatesList.itemAnimator = DefaultItemAnimator()

        findViewById<FloatingActionButton>(R.id.add_plate_button)?.setOnClickListener { v: View ->
            Snackbar.make(
                    v,
                    "Aquí lanzaré la actividad de detalle de plato",
                    Snackbar.LENGTH_LONG)
                    .show()
        }
    }
}
