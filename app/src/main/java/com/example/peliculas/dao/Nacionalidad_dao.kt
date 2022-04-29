package com.example.peliculas.dao

import androidx.room.*
import com.example.peliculas.models.Nacionalidad

@Dao
interface Nacionalidad_dao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNacionalidad(usuario: Nacionalidad)

    @Query("SELECT * FROM Nacionalidad")
    suspend fun getAllNacionalidad(): List<Nacionalidad>

    @Query("SELECT * FROM Nacionalidad where id_Nacionalidad= :id")
    suspend fun getById_Nacionalidad(id: Int): Nacionalidad

    @Update
    fun updateNacionalidad(usuario: Nacionalidad)

    @Query("Delete from Nacionalidad")
    suspend fun deleteAll()
}