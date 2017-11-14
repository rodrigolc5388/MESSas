package com.example.rodrigo.messas.model

import java.io.Serializable

data class Table(var name: String, var plates: List<Plate>?, var totalBill: Int?): Serializable {
    constructor(name: String) : this(name, null, null)
}