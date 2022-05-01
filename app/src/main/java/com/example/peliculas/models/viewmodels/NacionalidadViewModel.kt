package com.example.peliculas.models.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.peliculas.db.dbNacionalidad
import com.example.peliculas.models.entities.Nacionalidad
import com.example.peliculas.repository.NacionalidadRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NacionalidadViewModel(application: Application):AndroidViewModel(application) {
    val listaN : LiveData<List<Nacionalidad>>
    private val repository: NacionalidadRepository

    init {
        val nacionalidadDao = dbNacionalidad.getNacionalidadBD(application).nacionalidadDao()
        repository = NacionalidadRepository(nacionalidadDao)
        listaN = repository.listado
    }

    fun agregarNacionalidad(nacionalidad: Nacionalidad) {
        viewModelScope.launch(Dispatchers.IO)
        {
            repository.addNacionalidad(nacionalidad)
        }
    }

    fun actualizarNacionalidad(nacionalidad: Nacionalidad) {
        viewModelScope.launch(Dispatchers.IO)
        {
            repository.updateNacionalidad(nacionalidad)
        }
    }

    fun eliminarNacionalidad(nacionalidad: Nacionalidad) {
        viewModelScope.launch(Dispatchers.IO)
        {
            repository.deleteNacionalidad(nacionalidad)
        }
    }

    fun eliminarTodoNacionalidad() {
        viewModelScope.launch(Dispatchers.IO)
        {
            repository.deleteAllN()
        }
    }
}