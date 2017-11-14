package com.example.rodrigo.messas.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.rodrigo.messas.R
import com.example.rodrigo.messas.model.Plate
import com.example.rodrigo.messas.model.Plates
import com.example.rodrigo.messas.model.Table
import com.example.rodrigo.messas.model.Tables

class TablesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tables)

        val list = findViewById<ListView>(R.id.tables_list)
        val adapter = ArrayAdapter<Table>(this, android.R.layout.simple_list_item_1, Tables.toArray())
        list.adapter = adapter


    }
}
