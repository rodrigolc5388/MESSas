package com.example.rodrigo.messas.model

import java.io.Serializable

data class Plate(var name: String, var requests: String?, var allergens: List<Allergen>?, var price: Int?, var image: Int?): Serializable {

    constructor(name: String, image: Int) : this(name, null, null, null, image)
    constructor(name: String) : this(name, null, null, null, null)

    override fun toString() = name
}