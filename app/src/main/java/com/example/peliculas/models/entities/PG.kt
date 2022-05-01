package com.example.peliculas.models.entities

import androidx.room.Entity

@Entity(primaryKeys = ["idGenero","idPelicula"])
data class PG(
    val idGenero:Int,
    val idPelicula:Int
)