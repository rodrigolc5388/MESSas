package com.example.rodrigo.messas.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.MenuItem
import com.example.rodrigo.messas.R
import com.example.rodrigo.messas.adapter.TableRecyclerViewAdapter
import com.example.rodrigo.messas.model.Plate

class PlatesActivity : AppCompatActivity() {

    //ESTO DEBERÁ DESCARGAR SUS DATOS
    var plates: List<Plate>? = listOf(
            Plate("Macarrones"),
            Plate("Pizza"),
            Plate("Paella"),
            Plate("Hamburguesa"),
            Plate("Quiche"),
            Plate("Majadito")
    )
    /*set(value) {
            val adapter = TableRecyclerViewAdapter(value)
            platesList.adapter = adapter

        }*/

    lateinit var platesList: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plates)

        // TITLE AL CENTRO; NOMBRE A UN RECURSO
        supportActionBar?.title = "Platos"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        platesList = findViewById(R.id.plates_list)
        platesList.layoutManager = GridLayoutManager(this, 2)
        platesList.itemAnimator = DefaultItemAnimator()
        val adapter = TableRecyclerViewAdapter(plates)
        platesList.adapter = adapter
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
