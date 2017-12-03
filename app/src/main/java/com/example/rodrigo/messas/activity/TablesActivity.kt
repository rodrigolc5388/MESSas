package com.example.rodrigo.messas.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.rodrigo.messas.R
import com.example.rodrigo.messas.fragments.TablesFragment
import com.example.rodrigo.messas.model.Table

class TablesActivity : AppCompatActivity(), TablesFragment.OnTableSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tables)
    }


    override fun onTableSelected(table: Table, position: Int) {
        startActivity(TableActivity.intent(this, table, position))
    }

}
