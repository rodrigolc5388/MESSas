package com.example.rodrigo.messas.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.rodrigo.messas.R
import com.example.rodrigo.messas.model.Plate
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
    lateinit var table: Table
    lateinit var tablePlates: MutableList<Plate>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_table)


        // PENDIENTE: LIST<PLATE> debería o no ser (?) en el modelo?
        val position = intent.getSerializableExtra(EXTRA_POSITION) as Int
        table = Tables.get(position)
        tablePlates = table.plates

        // PENDIENE AÑADIR "TOTAL MESA : €€€" A LA ACTION BAR"
        supportActionBar?.title = table.name
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        platesList = findViewById(R.id.table_plates_list)
        platesList.adapter = ArrayAdapter<Plate>(this, android.R.layout.simple_list_item_1, tablePlates.toTypedArray())


        findViewById<FloatingActionButton>(R.id.add_plate_button)?.setOnClickListener {
            startActivityForResult(PlatesActivity.intent(this), 1)
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val resultPlate = data?.getSerializableExtra("EXTRA_PLATE_RESULT") as Plate
        tablePlates.add(resultPlate)
        platesList.adapter = ArrayAdapter<Plate>(this, android.R.layout.simple_list_item_1, tablePlates.toTypedArray())
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
