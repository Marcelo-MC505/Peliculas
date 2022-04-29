package com.example.peliculas.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.peliculas.dao.Nacionalidad_dao
import com.example.peliculas.models.Nacionalidad


interface MainDataBaseProviderNacionalidad {
    fun nacionalidadDao() : Nacionalidad_dao
}

@Database(entities = [Nacionalidad::class,],
    version = 4
)
abstract class dbNacionalidad: RoomDatabase(), MainDataBaseProviderNacionalidad {
    abstract override fun nacionalidadDao(): Nacionalidad_dao

    companion object{
        @Volatile
        private var INSTANCE: dbNacionalidad? = null
        fun getInstace(context: Context): dbNacionalidad {
            synchronized(this){
                var instance = INSTANCE
                if (instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        dbNacionalidad::class.java,
                        "dbNacionalidad"
                    ).fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}
