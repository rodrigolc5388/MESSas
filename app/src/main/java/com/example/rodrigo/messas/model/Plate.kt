package com.example.rodrigo.messas.model

import java.io.Serializable

data class Plate(var name: String, var requests: String?, var allergens: List<Allergen>?, var price:Float, var image: Int?): Serializable {

    //constructor(name: String) : this(name, null, null, null, null)
    //constructor(name: String, image: Int) : this(name, null, null, null, image)
    constructor(name: String, price: Float) : this(name, null, null, price, null)

    override fun toString() = name
}