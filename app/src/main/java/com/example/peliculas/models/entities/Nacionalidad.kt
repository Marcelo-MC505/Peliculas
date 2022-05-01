package com.example.peliculas.models.entities

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName="Nacionalidad")
data class Nacionalidad (
    @PrimaryKey(autoGenerate = true)
    val id_Nacionalidad:Int,
    @ColumnInfo(name = "nombre")
    val nombreN:String
): Parcelable