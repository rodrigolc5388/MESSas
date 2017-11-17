package com.example.rodrigo.messas.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.rodrigo.messas.R
import com.example.rodrigo.messas.model.Plate

// PLATES PODRÍA SER NULL, POR LO QUE HABRÍA QUE USAR ? ALLÁ DONDE SE USE
class PlatesRecyclerViewAdapter(val plates: List<Plate>?): RecyclerView.Adapter<PlatesRecyclerViewAdapter.TableViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): TableViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.content_plate, parent, false)
        return TableViewHolder(view)
    }

    override fun onBindViewHolder(holder: TableViewHolder?, position: Int) {
        if (plates != null){
            holder?.bindPlate(plates[position])
        }
    }

    override fun getItemCount(): Int = plates?.size ?: 0



    inner class TableViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val plateName = itemView.findViewById<TextView>(R.id.content_plateName)
        val platePhoto = itemView.findViewById<ImageView>(R.id.content_plateView)

        fun bindPlate(plate: Plate) {
            val context = platePhoto.context

            plateName.text = plate.name
            //Ver de solucionar luego el uso de esto -> !!
            //platePhoto.setImageResource(plate.image!!)
        }
    }
}