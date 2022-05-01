package com.example.peliculas.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.peliculas.models.entities.Nacionalidad
import com.example.peliculas.databinding.ListaNacionalidadBinding

class Nacionalidad_Adapter : RecyclerView.Adapter<Nacionalidad_Adapter.NacionalidadHolder>() {

    private var listadoNacionalidad = emptyList<Nacionalidad>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NacionalidadHolder {
        val binding = ListaNacionalidadBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NacionalidadHolder(binding)
    }

    override fun onBindViewHolder(holder: NacionalidadHolder, position: Int) {
        holder.bind( listadoNacionalidad[position] )
    }

    override fun getItemCount(): Int = listadoNacionalidad.size

    fun setData(nations: List<Nacionalidad>) {
        this.listadoNacionalidad = nations
        notifyDataSetChanged()
    }

    inner class NacionalidadHolder(val binding: ListaNacionalidadBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(nacionalidad: Nacionalidad) {
            with(binding)
            {
                TvIdNacionalidad.text = nacionalidad.id_Nacionalidad.toString()
                TvNacionalidad.text = nacionalidad.nombreN

                ClFilaN.setOnClickListener {
                    val action = NacionalidadFragmentDirections.editarNacionalidad(nacionalidad)
                    it.findNavController().navigate(action)
                }
            }
        }
    }
}