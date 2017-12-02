package com.example.rodrigo.messas.fragments


import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.rodrigo.messas.R
import com.example.rodrigo.messas.activity.TableActivity
import com.example.rodrigo.messas.model.Table
import com.example.rodrigo.messas.model.Tables


class TablesFragment: Fragment() {

    lateinit var root: View

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)

        inflater?.let{
            root = inflater.inflate(R.layout.fragment_tables, container, false)
            val list = root.findViewById<ListView>(R.id.tables_list)
            val adapter = ArrayAdapter<Table>(activity, android.R.layout.simple_list_item_1, Tables.toArray())
            list.adapter = adapter
            list.setOnItemClickListener { parent, view, position, id ->
                val table = Tables.get(position)
                val intent = TableActivity.intent(activity, table, position )
                startActivity(intent)
            }

        }
        return root
    }
}