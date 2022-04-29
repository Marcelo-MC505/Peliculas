package com.example.peliculas.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.peliculas.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import com.example.peliculas.adapters.Nacionalidad_Adapter
import com.example.peliculas.dao.Nacionalidad_dao
import com.example.peliculas.databinding.FragmentNacionalidadBinding
import com.example.peliculas.db.dbNacionalidad

class nacionalidadFragment : Fragment() {
    lateinit var binding: FragmentNacionalidadBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNacionalidadBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = Navigation.findNavController(view)
        val db: dbNacionalidad = dbNacionalidad.getInstace(this.requireContext().applicationContext)
        val dao: Nacionalidad_dao = db.nacionalidadDao()

        CoroutineScope(Dispatchers.Main).launch {
            var list_n = dao.getAllNacionalidad()

            binding.recyclerNacionalidad.layoutManager = LinearLayoutManager(context)
            val adapter = Nacionalidad_Adapter(list_n)
            binding.recyclerNacionalidad.adapter = adapter
        }

        binding.btnAgregar.setOnClickListener {
            navController.navigate(R.id.agregar_nacionalidad)
        }
    }

}