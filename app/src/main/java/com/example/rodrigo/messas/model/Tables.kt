package com.example.rodrigo.messas.model

import java.io.Serializable


object Tables: Serializable {

    private var tables: List<Table> = listOf(
            Table("Mesa 1"),
            Table("Mesa 2"),
            Table("Mesa 3"),
            Table("Mesa 4"),
            Table("Mesa 5")
    )

    val count
        get() = tables.size

    fun toArray() = tables.toTypedArray()
}