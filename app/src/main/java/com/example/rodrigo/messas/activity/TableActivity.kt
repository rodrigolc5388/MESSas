package com.example.rodrigo.messas.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.rodrigo.messas.R
import com.example.rodrigo.messas.fragments.TableFragment
import com.example.rodrigo.messas.model.Table
import com.example.rodrigo.messas.model.Tables

class TableActivity : AppCompatActivity(), TableFragment.OnAddPlateButtonListener {

    companion object {

        private val EXTRA_TABLE = "EXTRA_TABLE"
        private val EXTRA_POSITION = "EXTRA_POSITION"

        fun intent(context: Context, table: Table, position: Int): Intent {
            val intent = Intent(context, TableActivity::class.java)
            intent.putExtra(EXTRA_TABLE, table)
            intent.putExtra(EXTRA_POSITION, position)
            return intent
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_table)

        val position = intent.getSerializableExtra(EXTRA_POSITION) as Int
        val table = Tables.get(position)
        supportActionBar?.title = table.name
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

            if(fragmentManager.findFragmentById(R.id.table_fragment) == null){
                val fragment = TableFragment.newInstance(table, position)
                fragmentManager.beginTransaction()
                        .add(R.id.table_fragment, fragment)
                        .commit()
            }

        /*findViewById<FloatingActionButton>(R.id.add_plate_button)?.setOnClickListener {
            startActivityForResult(PlatesActivity.intent(this), 1)
        }*/
    }

    override fun onAddPlateButton() {
        startActivityForResult(PlatesActivity.intent(this), 1)
    }
}
