package com.example.appplant.Modelo.Local.Entities

import androidx.resourceinspection.annotation.Attribute.IntMap
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "List_Flowers")
data class FlowerList(
    @PrimaryKey
    val id: Int,
    val nombre: String,
    val tipo: String,
    val imagen: String,
    val descripcion : String)