package com.example.peliculas.repository

import androidx.lifecycle.LiveData
import com.example.peliculas.dao.Nacionalidad_dao
import com.example.peliculas.models.entities.Nacionalidad

class NacionalidadRepository(private val dao: Nacionalidad_dao) {
    val listado : LiveData<List<Nacionalidad>> = dao.getAllNacionalidad()

    suspend fun addNacionalidad(nacionalidad: Nacionalidad){
        dao.insertNacionalidad(nacionalidad)
    }
    suspend fun updateNacionalidad(nacionalidad: Nacionalidad){
        dao.updateNacionalidad(nacionalidad)
    }
    suspend fun deleteNacionalidad(nacionalidad: Nacionalidad){
        dao.deleteNacionalidad(nacionalidad)
    }
    suspend fun deleteAllN(){
        dao.deleteAllNacionalidad()
    }
}