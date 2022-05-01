package com.example.peliculas.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.peliculas.models.entities.Idioma
import com.example.peliculas.models.entities.Nacionalidad

@Dao
interface Nacionalidad_dao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNacionalidad(usuario: Nacionalidad)

    @Query("SELECT * FROM Nacionalidad")
    fun getAllNacionalidad(): LiveData<List<Nacionalidad>>

    @Query("SELECT * FROM Nacionalidad where id_Nacionalidad= :id")
    suspend fun getById_Nacionalidad(id: Int): Nacionalidad

    @Update
    fun updateNacionalidad(usuario: Nacionalidad)

    @Delete
    suspend fun deleteNacionalidad(nacionalidad: Nacionalidad)

    @Query("Delete from Nacionalidad")
    suspend fun deleteAllNacionalidad()
}