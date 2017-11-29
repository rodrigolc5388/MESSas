package com.example.rodrigo.messas.model

import java.io.Serializable

data class Table(var name: String, var plates: MutableList<Plate>, var totalBill: MutableList<Float>): Serializable {

    override fun toString() = name

    fun platesToArray() = plates?.toTypedArray()

    fun addPlate(plate: Plate) {
        plates.add(plate)
    }
}