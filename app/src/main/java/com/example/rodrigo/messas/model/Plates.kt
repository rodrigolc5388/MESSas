package com.example.rodrigo.messas.model

import java.io.Serializable


object Plates: Serializable {
    private var plates: List<Plate> = listOf(
            Plate("Macarrones"),
            Plate("Hamburguesa"),
            Plate("Croquetas"),
            Plate("Pizza"),
            Plate("Perrito"),
            Plate("Lasaña"),
            Plate("Paella"),
            Plate("Carne"),
            Plate("Pescado")
    )

    val count
        get() = plates.size

    fun toArray() = plates.toTypedArray()
}