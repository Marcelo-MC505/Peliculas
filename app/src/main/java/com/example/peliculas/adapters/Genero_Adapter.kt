package com.example.peliculas.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.peliculas.databinding.ItemGeneroBinding
import com.example.peliculas.models.entities.Genero_Item

class Genero_Adapter(val genero_list: List<Genero_Item>): RecyclerView.Adapter<Genero_Adapter.GeneroHolder>() {
    inner class GeneroHolder(val binding: ItemGeneroBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(genero: Genero_Item){
            with(binding){
                TxtNombre.text = genero.nombre
                TxtId.text = genero.idGenero.toString()
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): GeneroHolder {
        val binding = ItemGeneroBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return GeneroHolder(binding)
    }

    override fun onBindViewHolder(holder: GeneroHolder, position: Int) {
        holder.bind(genero_list[position])
    }

    override fun getItemCount(): Int = genero_list.size
}