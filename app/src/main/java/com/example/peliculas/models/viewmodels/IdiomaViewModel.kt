package com.example.peliculas.models.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.peliculas.db.dbIdioma
import com.example.peliculas.models.entities.Idioma
import com.example.peliculas.repository.IdiomaRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class IdiomaViewModel(application: Application):AndroidViewModel(application) {
    val listaI : LiveData<List<Idioma>>
    private val repository: IdiomaRepository

    init {
        val idiomaDao = dbIdioma.getIdiomaBD(application).idiomaDao()
        repository = IdiomaRepository(idiomaDao)
        listaI = repository.listado
    }

    fun agregarIdioma(idioma: Idioma) {
        viewModelScope.launch(Dispatchers.IO)
        {
            repository.addIdioma(idioma)
        }
    }

    fun actualizarIdioma(idioma: Idioma) {
        viewModelScope.launch(Dispatchers.IO)
        {
            repository.updateIdioma(idioma)
        }
    }

    fun eliminarIdioma(idioma: Idioma) {
        viewModelScope.launch(Dispatchers.IO)
        {
            repository.deleteIdioma(idioma)
        }
    }

    fun eliminarTodoIdioma() {
        viewModelScope.launch(Dispatchers.IO)
        {
            repository.deleteAllI()
        }
    }
}