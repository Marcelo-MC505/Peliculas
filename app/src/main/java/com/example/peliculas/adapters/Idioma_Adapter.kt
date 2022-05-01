package com.example.peliculas.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.peliculas.models.entities.Idioma
import com.example.peliculas.databinding.ListaIdiomaBinding

class Idioma_Adapter : RecyclerView.Adapter<Idioma_Adapter.IdiomaHolder>() {

    private var listadoIdioma = emptyList<Idioma>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IdiomaHolder {
        val binding = ListaIdiomaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return IdiomaHolder(binding)
    }

    override fun onBindViewHolder(holder: IdiomaHolder, position: Int) {
        holder.bind( listadoIdioma[position] )
    }

    override fun getItemCount(): Int = listadoIdioma.size

    fun setData(languages: List<Idioma>) {
        this.listadoIdioma = languages
        notifyDataSetChanged()
    }

    inner class IdiomaHolder(val binding: ListaIdiomaBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(idioma: Idioma) {
            with(binding)
            {
                TvIdIdioma.text = idioma.id_Idioma.toString()
                TvIdioma.text = idioma.nombreI

                ClFilaI.setOnClickListener {
                    val action = IdiomaFragmentDirections.editarIdioma(idioma)
                    it.findNavController().navigate(action)
                }
            }
        }
    }
}