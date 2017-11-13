package com.example.rodrigo.messas.model

import java.io.Serializable

data class Plate(var name: String, var requests: String, var allergens: List<Allergen>, var price: Int, var image: Int): Serializable