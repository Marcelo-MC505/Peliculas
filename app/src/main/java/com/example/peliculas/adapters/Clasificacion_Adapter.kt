package com.example.peliculas.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.peliculas.databinding.ItemClasificacionBinding
import com.example.peliculas.models.entities.Clasificacion_Item

class Clasificacion_Adapter(val clasificacion_list: List<Clasificacion_Item>): RecyclerView.Adapter<Clasificacion_Adapter.ClasificacionHolder>() {
    inner class ClasificacionHolder(val binding: ItemClasificacionBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(clasificacion: Clasificacion_Item){
            with(binding){
                TxtAbreviacion.text = clasificacion.abreviacion
                TxtId.text = clasificacion.idClasificacion.toString()
                TxtNombre.text = clasificacion.nombre
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): ClasificacionHolder {
        val binding = ItemClasificacionBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ClasificacionHolder(binding)
    }

    override fun onBindViewHolder(holder: ClasificacionHolder, position: Int) {
        holder.bind(clasificacion_list[position])
    }

    override fun getItemCount(): Int = clasificacion_list.size
}