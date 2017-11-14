package com.example.rodrigo.messas.model

import java.io.Serializable


object Plates: Serializable {
    private var plates: List<Plate> = listOf(
            Plate("Macarrones"),
            Plate("Pizza"),
            Plate("Paella")
    )

    val count
        get() = plates.size

    fun toArray() = plates.toTypedArray()
}