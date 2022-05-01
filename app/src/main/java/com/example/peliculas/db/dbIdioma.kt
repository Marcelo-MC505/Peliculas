package com.example.peliculas.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.peliculas.dao.Idioma_dao
import com.example.peliculas.models.entities.Idioma

interface MainDataBaseProviderIdioma {
    fun idiomaDao() : Idioma_dao
}

@Database(entities = [Idioma::class,],
    version = 1
)
abstract class dbIdioma: RoomDatabase(), MainDataBaseProviderIdioma {
    abstract override fun idiomaDao(): Idioma_dao

    companion object{
        @Volatile
        private var INSTANCE: dbIdioma? = null
        fun getIdiomaBD(context: Context): dbIdioma {
            synchronized(this){
                var instance = INSTANCE
                if (instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        dbIdioma::class.java,
                        "dbIdioma"
                    ).fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}