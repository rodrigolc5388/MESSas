package com.example.rodrigo.messas.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.design.widget.TabLayout
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
import com.example.rodrigo.messas.model.Table
import com.example.rodrigo.messas.model.Tables

class TableActivity : AppCompatActivity() {

    companion object {

        private val EXTRA_TABLE = "EXTRA_TABLE"
        private val EXTRA_POSITION = "EXTRA_POSITION"

        fun intent(context: Context, table: Table, position: Int): Intent{
            val intent = Intent(context, TableActivity::class.java)
            intent.putExtra(EXTRA_TABLE, table)
            intent.putExtra(EXTRA_POSITION, position)
            return intent
        }
    }


    lateinit var platesList: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_table)

        // PENDIENE AÑADIR "TOTAL MESA : €€€" A LA ACTION BAR"

        val table = intent.getSerializableExtra(EXTRA_TABLE) as Table

        supportActionBar?.title = table.name
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        platesList = findViewById(R.id.plates_list)
        val adapter = ArrayAdapter<Plate>(this, android.R.layout.simple_list_item_1, table.platesToArray())
        platesList.adapter = adapter



        findViewById<FloatingActionButton>(R.id.add_plate_button)?.setOnClickListener { v: View ->

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
