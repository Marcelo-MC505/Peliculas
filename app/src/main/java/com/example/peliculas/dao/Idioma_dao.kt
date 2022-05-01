package com.example.peliculas.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.peliculas.models.entities.Idioma

@Dao
interface Idioma_dao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertIdioma(idioma: Idioma)

    @Query("SELECT * FROM Idioma")
    fun getAllIdioma(): LiveData<List<Idioma>>

    @Query("SELECT * FROM Idioma where id_Idioma= :id")
    suspend fun getById_Idioma(id: Int): Idioma

    @Update
    fun updateIdioma(idioma: Idioma)

    @Delete
    suspend fun deleteIdioma(idioma: Idioma)

    @Query("Delete from Idioma")
    suspend fun deleteAllIdioma()
}