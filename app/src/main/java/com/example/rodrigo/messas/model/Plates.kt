package com.example.rodrigo.messas.model

import org.json.JSONObject
import java.io.Serializable
import java.net.URL
import java.util.*


object Plates: Serializable {

    var plates: MutableList<Plate> = mutableListOf()

    val count
        get() = plates?.size


    operator fun get(i: Int) = plates?.get(i)


    fun toList() = plates?.toList()


    fun downloadPlates(): MutableList<Plate> {
            val url = URL("http://www.mocky.io/v2/5a17e00d2c0000091a596c60")
            val jsonString = Scanner(url.openStream(), "UTF-8").useDelimiter("\\A").next()

            val jsonRoot = JSONObject(jsonString)
            val menu = jsonRoot.getJSONArray("plates")

            var platesList = mutableListOf<Plate>()

            for (plateIndex in 0..menu.length() - 1) {
                val plate = menu.getJSONObject(plateIndex)
                val name = plate.getString("name")
                val price = plate.getDouble("price").toFloat()
                val image = plate.getString("image")

                platesList.add(Plate(name, price))
            }
            return platesList
    }
}