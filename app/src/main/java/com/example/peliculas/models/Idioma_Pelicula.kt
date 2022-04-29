package com.example.peliculas.models

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class Idioma_Pelicula(
    @Embedded val idioma: Idioma,
    @Relation(
        parentColumn = "id_Idioma",
        entityColumn = "id_Pelicula",
        associateBy = Junction(PI::class)
    )
    val peliculas:List<Pelicula>
)
