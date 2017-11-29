package com.example.rodrigo.messas.activity

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuInflater
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
    lateinit var totalBill: MutableList<Float>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_table)


        // PENDIENTE: LIST<PLATE> debería o no ser (?) en el modelo?
        val position = intent.getSerializableExtra(EXTRA_POSITION) as Int
        table = Tables.get(position)
        tablePlates = table.plates
        totalBill = table.totalBill

        supportActionBar?.title = table.name
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        platesList = findViewById(R.id.table_plates_list)
        platesList.adapter = ArrayAdapter<Plate>(this, android.R.layout.simple_list_item_1, tablePlates.toTypedArray())
        platesList.setOnItemClickListener { parent, view, position, id ->
            val plate = tablePlates.get(position)
            startActivity(PlateDetailActivity.intent(this, plate, position))
        }


        findViewById<FloatingActionButton>(R.id.add_plate_button)?.setOnClickListener {
            startActivityForResult(PlatesActivity.intent(this), 1)
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK) {
            val resultPlate = data?.getSerializableExtra("EXTRA_PLATE_RESULT") as Plate
            tablePlates.add(resultPlate)
            totalBill.add(resultPlate.price)
            platesList.adapter = ArrayAdapter<Plate>(this, android.R.layout.simple_list_item_1, tablePlates.toTypedArray())
        }
    }

    /*fun updateBill() {
        for (plateIndex in 0..tablePlates.size-1) {
            val plate = tablePlates.get(plateIndex)
            val platePrice = plate.price
            table.totalBill = table.totalBill + platePrice
        }
    }*/


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater.inflate(R.menu.menu_bill, menu)
        return true
    }


    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        val billButton = menu?.findItem(R.id.bill_button)
        val title = getString(R.string.bill_button_text, totalBill.sum())
        billButton?.setTitle(title)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem?) = when (item?.itemId){
        R.id.bill_button -> {


            true
        }
        android.R.id.home -> {
            finish()
            true
        }
        else -> super.onOptionsItemSelected(item)
        }
}
