package com.example.peliculas.models

import androidx.room.Entity

@Entity(primaryKeys = ["idGenero","idPelicula"])
data class PG(
    val idGenero:Int,
    val idPelicula:Int
)