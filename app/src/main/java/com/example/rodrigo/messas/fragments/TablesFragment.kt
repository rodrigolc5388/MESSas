package com.example.rodrigo.messas.fragments


import android.app.Activity
import android.app.Fragment
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.rodrigo.messas.R
import com.example.rodrigo.messas.model.Table
import com.example.rodrigo.messas.model.Tables


class TablesFragment: Fragment() {

    lateinit var root: View
    private var onTableSelectedListener: OnTableSelectedListener? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)

        inflater?.let{
            root = it.inflate(R.layout.fragment_tables, container, false)
            val list = root.findViewById<ListView>(R.id.tables_list)
            val adapter = ArrayAdapter<Table>(activity, android.R.layout.simple_list_item_1, Tables.toArray())
            list.adapter = adapter
            list.setOnItemClickListener { parent, view, position, id ->
                val table = Tables.get(position)
                onTableSelectedListener?.onTableSelected(table, position)
            }
        }
        return root
    }


    override fun onAttach(context: Context?) {
        super.onAttach(context)
        commonAttach(context)
    }

    override fun onAttach(activity: Activity?) {
        super.onAttach(activity)
        commonAttach(activity)
    }

    override fun onDetach() {
        super.onDetach()
        onTableSelectedListener = null
    }

    fun commonAttach(listener: Any?) {
        if (listener is OnTableSelectedListener) {
            onTableSelectedListener = listener
        }
    }


    interface OnTableSelectedListener{
        fun onTableSelected(table: Table, position: Int)
    }
}