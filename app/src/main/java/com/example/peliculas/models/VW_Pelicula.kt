package com.example.peliculas.models

import androidx.room.DatabaseView

@DatabaseView("Select " +
        "p.id_Pelicula," +
        "p.titulo," +
        "p.tipoMetraje," +
        "p.duracion," +
        "p.sinopsis," +
        "c.nombre as clasificacion," +
        "n.nombre as nacionalidad " +
        "from Pelicula as p " +
        "inner join Nacionalidad as n on n.id_Nacionalidad=p.idNacionalidad " +
        "inner join Clasificacion as c on c.id_Clasificacion=p.idClasificacion")
data class VW_Pelicula(
    val idPelicula: Int,
    val titulo: String,
    val tipoMetraje: String,
    val nacionalidad: String,
    val clasificacion: String,
    val duracion: String,
    val sinopsis: String
)

