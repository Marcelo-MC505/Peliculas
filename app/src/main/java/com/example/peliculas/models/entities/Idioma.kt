package com.example.peliculas.models.entities

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName="Idioma")
data class Idioma (
    @PrimaryKey(autoGenerate = true)
    val id_Idioma:Int,
    @ColumnInfo(name = "nombre")
    val nombreI:String
): Parcelable