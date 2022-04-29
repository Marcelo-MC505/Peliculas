package com.example.peliculas.models

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Junction
import androidx.room.Relation

data class Pelicula_Genero(
    @Embedded val pelicula: Pelicula,
    @Relation(
        parentColumn = "id_Pelicula",
        entityColumn = "id_Idioma",
        associateBy = Junction(PG::class)
    )
    val genero:List<Genero>
)
