package com.example.peliculas.models

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class Genero_Peliculas (
    @Embedded val genero: Genero,
    @Relation(
        parentColumn = "idGenero",
        entityColumn = "idPelicula",
        associateBy = Junction(PG::class)
    )
    val peliculas:List<Pelicula>
)