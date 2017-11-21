package com.example.rodrigo.messas.model

import java.io.Serializable


object Plates: Serializable {
    private var plates: List<Plate> = listOf(
            Plate("Macarrones", 10.5f),
            Plate("Hamburguesa", 4.50f),
            Plate("Croquetas", 3.25f),
            Plate("Pizza", 9f),
            Plate("Perrito", 1.50f),
            Plate("Lasaña", 12f),
            Plate("Paella", 24.50f),
            Plate("Carne", 13.50f),
            Plate("Pescado", 8.20f)
    )

    val count
        get() = plates.size

    operator fun get(i: Int) = plates[i]

    fun toList() = plates.toList()
}