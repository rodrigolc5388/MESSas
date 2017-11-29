package com.example.rodrigo.messas.model

import java.io.Serializable


object Tables: Serializable {

    private var tables: List<Table> = listOf(
            Table("Mesa 1", mutableListOf(), mutableListOf()),
            Table("Mesa 2", mutableListOf(),mutableListOf()),
            Table("Mesa 3", mutableListOf(),mutableListOf()),
            Table("Mesa 4", mutableListOf(),mutableListOf()),
            Table("Mesa 5", mutableListOf(),mutableListOf())
    )

    val count
        get() = tables.size

    operator fun get(i: Int) = tables[i]

    fun toArray() = tables.toTypedArray()
}