package com.example.peliculas.repository

import androidx.lifecycle.LiveData
import com.example.peliculas.dao.Idioma_dao
import com.example.peliculas.models.entities.Idioma

class IdiomaRepository(private val dao: Idioma_dao) {
    val listado : LiveData<List<Idioma>> = dao.getAllIdioma()

    suspend fun addIdioma(idioma: Idioma){
        dao.insertIdioma(idioma)
    }
    suspend fun updateIdioma(idioma: Idioma){
        dao.updateIdioma(idioma)
    }
    suspend fun deleteIdioma(idioma: Idioma){
        dao.deleteIdioma(idioma)
    }
    suspend fun deleteAllI(){
        dao.deleteAllIdioma()
    }
}