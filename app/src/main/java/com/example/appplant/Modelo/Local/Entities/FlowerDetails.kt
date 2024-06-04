package com.example.appplant.Modelo.Local.Entities

import androidx.room.Entity
import androidx.room.PrimaryKey




@Entity(tableName = "Details_Flowers")
data class FlowerDetails(
    @PrimaryKey
    val id: Int,
    val nombre: String,
    val tipo: String,
    val imagen: String,
    val descripcion : String)