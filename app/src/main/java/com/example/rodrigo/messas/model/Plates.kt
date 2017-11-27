package com.example.rodrigo.messas.model

import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg
import org.json.JSONObject
import java.io.Serializable
import java.net.URL
import java.util.*



object Plates: Serializable {
    /*private var plates: List<Plate> = listOf(
            Plate("Macarrones", 10.5f),
            Plate("Hamburguesa", 4.50f),
            Plate("Croquetas", 3.25f),
            Plate("Pizza", 9f),
            Plate("Perrito", 1.50f),
            Plate("Lasaña", 12f),
            Plate("Paella", 24.50f),
            Plate("Carne", 13.50f),
            Plate("Pescado", 8.20f)
    )*/

    var plates: MutableList<Plate> = mutableListOf()
    //lateinit var plates: MutableList<Plate>

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