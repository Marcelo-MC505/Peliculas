package com.example.peliculas.models.entities

import androidx.room.Entity

@Entity(primaryKeys = ["idIdioma","idPelicula"])
data class PI(
    val idIdioma:Int,
    val idPelicula:Int
)