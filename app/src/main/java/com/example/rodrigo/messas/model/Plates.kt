package com.example.rodrigo.messas.model

import com.example.rodrigo.messas.R
import org.json.JSONObject
import java.io.Serializable
import java.net.URL
import java.util.*


object Plates: Serializable {

    var plates: MutableList<Plate> = mutableListOf()

    val count
        get() = plates.size


    operator fun get(i: Int) = plates.get(i)


    fun downloadPlates(): MutableList<Plate> {
            val url = URL("http://www.mocky.io/v2/5a17e00d2c0000091a596c60")
            val jsonString = Scanner(url.openStream(), "UTF-8").useDelimiter("\\A").next()

            val jsonRoot = JSONObject(jsonString)
            val menu = jsonRoot.getJSONArray("plates")

            var platesList = mutableListOf<Plate>()

            for (plateIndex in 0..menu.length() - 1) {
                val plate = menu.getJSONObject(plateIndex)
                val name = plate.getString("name").capitalize()
                val price = plate.getDouble("price").toFloat()
                val imageName = plate.getString("image")
                val allergensJson = plate.getJSONObject("allergens")
                val allergens = mutableListOf<Allergen>()
                val egg = allergensJson.getBoolean("egg")
                allergens.add(Allergen("egg", egg))
                val fish = allergensJson.getBoolean("fish")
                allergens.add(Allergen("fish", fish))
                val gluten = allergensJson.getBoolean("gluten")
                allergens.add(Allergen("gluten", gluten))
                val milk = allergensJson.getBoolean("milk")
                allergens.add(Allergen("milk", milk))
                val peanut = allergensJson.getBoolean("peanut")
                allergens.add(Allergen("peanut", peanut))
                val image = when (imageName){
                    "bacalao" -> R.drawable.bacalao
                    "hamburguesa" -> R.drawable.hamburguesa
                    "paella" -> R.drawable.paella
                    "pizza" -> R.drawable.pizza
                    "quiche" -> R.drawable.quiche
                    else -> R.drawable.foods
                }

                platesList.add(Plate(name, allergens, price, image))
            }
            return platesList
    }
}