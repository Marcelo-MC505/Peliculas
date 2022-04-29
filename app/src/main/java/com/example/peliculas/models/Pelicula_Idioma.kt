package com.example.peliculas.models

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class Pelicula_Idioma(
    @Embedded val pelicula: Pelicula,
    @Relation(
        parentColumn = "id_Pelicula",
        entityColumn = "id_Idioma",
        associateBy = Junction(PI::class)
    )
    val idioma:List<Idioma>
)

