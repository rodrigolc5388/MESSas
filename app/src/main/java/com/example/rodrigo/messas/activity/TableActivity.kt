package com.example.rodrigo.messas.activity

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import com.example.rodrigo.messas.R

class TableActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_table)

        findViewById<FloatingActionButton>(R.id.add_plate_button)?.setOnClickListener {
            startActivityForResult(PlatesActivity.intent(this), 1)
        }
    }
}
