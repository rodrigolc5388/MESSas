package com.example.rodrigo.messas.model

import java.io.Serializable

data class Plate(var name: String, var requests: String?, var allergens: MutableList<Allergen>, var price:Float, var image: Int): Serializable {

    //constructor(name: String) : this(name, null, null, null, null)
    //constructor(name: String, image: Int) : this(name, null, null, null, image)
    constructor(name: String, allergens: MutableList<Allergen>, price: Float, image: Int) : this(name, null, allergens, price, image)

    override fun toString() = name
}