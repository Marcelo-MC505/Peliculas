package com.example.peliculas.models

import androidx.room.Entity

@Entity(primaryKeys = ["idIdioma","idPelicula"])
data class PI(
    val idIdioma:Int,
    val idPelicula:Int
)