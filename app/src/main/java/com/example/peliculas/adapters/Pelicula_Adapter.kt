package com.example.peliculas.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.peliculas.databinding.ItemPeliculaBinding
import com.example.peliculas.models.entities.Pelicula_Item

class Pelicula_Adapter(val pelicula_list: List<Pelicula_Item>): RecyclerView.Adapter<Pelicula_Adapter.PeliculaHolder>() {
    inner class PeliculaHolder(val binding: ItemPeliculaBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(pelicula: Pelicula_Item){
            with(binding){
                TxtTitulo.text = pelicula.titulo
                TxtTipoMetraje.text = pelicula.tipoMetraje
                TxtNacionalidad.text = pelicula.nacionalidad.toString()
                TxtClasificacion.text = pelicula.clasificacion.toString()
                TxtDuracion.text = pelicula.duracion
                TxtSinopsis.text = pelicula.sinopsis
                TxtId.text = pelicula.idPelicula.toString()
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): PeliculaHolder {
        val binding = ItemPeliculaBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return PeliculaHolder(binding)
    }

    override fun onBindViewHolder(holder: PeliculaHolder, position: Int) {
        holder.bind(pelicula_list[position])
    }

    override fun getItemCount(): Int = pelicula_list.size
}