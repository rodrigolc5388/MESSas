package com.example.rodrigo.messas.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.rodrigo.messas.R

class TableActivity : AppCompatActivity() {

    lateinit var tablePlatesList: RecyclerView
    // ESTO RECIBE UN `plates: List<Plate> = null`
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_table)

        tablePlatesList = findViewById(R.id.table_plates_list)
        tablePlatesList.layoutManager = GridLayoutManager(this, 2)
        tablePlatesList.itemAnimator = DefaultItemAnimator()



    }
}
