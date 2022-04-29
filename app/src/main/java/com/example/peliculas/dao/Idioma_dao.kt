package com.example.peliculas.dao

import androidx.room.*
import com.example.peliculas.models.Idioma

@Dao
interface Idioma_dao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertIdioma(usuario: Idioma)

    @Query("SELECT * FROM Idioma")
    suspend fun getAllIdioma(): List<Idioma>

    @Query("SELECT * FROM Idioma where id_Idioma= :id")
    suspend fun getById_Idioma(id: Int): Idioma

    @Update
    fun updateIdioma(usuario: Idioma)

    @Query("Delete from Idioma")
    suspend fun deleteAll()
}