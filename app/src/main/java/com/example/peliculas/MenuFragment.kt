package com.example.peliculas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.peliculas.databinding.FragmentMenuBinding
import com.example.peliculas.R
import androidx.navigation.fragment.findNavController


class MenuFragment : Fragment() {

    private lateinit var binding:FragmentMenuBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBinding.inflate(inflater,container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding){
            BtnClasificacion.setOnClickListener {
                findNavController().navigate(R.id.clasificacionFragment)
            }

            BtnIdioma.setOnClickListener {
                findNavController().navigate(R.id.idiomaFragment)
            }
            BtnGenero.setOnClickListener {
                findNavController().navigate(R.id.generoFragment)
            }
            BtnNacionalidad.setOnClickListener {
                findNavController().navigate(R.id.irANacionalidad)
            }
            BtnPelicula.setOnClickListener {
                findNavController().navigate(R.id.peliculaFragment)
            }

        }
    }

}