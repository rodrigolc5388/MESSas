package com.example.rodrigo.messas.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.rodrigo.messas.R
import com.example.rodrigo.messas.adapter.PlatesRecyclerViewAdapter
import com.example.rodrigo.messas.model.Plate
import com.example.rodrigo.messas.model.Plates

class TableActivity : AppCompatActivity() {

    /*var plates: List<Plate> = mutableListOf(
            Plate("Macarrones"),
            Plate("Hamburguesa"),
            Plate("Croquetas"),
            Plate("Pizza"),
            Plate("Perrito"),
            Plate("Lasaña"),
            Plate("Paella"),
            Plate("Carne"),
            Plate("Pescado")
    )*/
        /*set(value) {
            val adapter = PlatesRecyclerViewAdapter(value)
            tablePlatesList.adapter = adapter

        }*/

    lateinit var platesList: ListView
    // ESTO RECIBE UN `plates: List<Plate> = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_table)

        // PENDIENE AÑADIR "TOTAL MESA : €€€" A LA ACTION BAR"

        supportActionBar?.title = "Mesa 3"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        platesList = findViewById(R.id.plates_list)
        val adapter = ArrayAdapter<Plate>(this, android.R.layout.simple_list_item_1, Plates.toArray())
        platesList.adapter = adapter
        platesList.



        findViewById<FloatingActionButton>(R.id.add_plate_button)?.setOnClickListener { v: View ->
            Snackbar.make(
                    v,
                    "Aquí lanzaré la actividad de detalle de platos",
                    Snackbar.LENGTH_LONG)
                    .show()
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
}
