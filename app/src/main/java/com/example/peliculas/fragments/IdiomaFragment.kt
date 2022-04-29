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
import com.example.peliculas.adapters.Idioma_Adapter
import com.example.peliculas.dao.Idioma_dao
import com.example.peliculas.databinding.FragmentIdiomaBinding
import com.example.peliculas.db.dbIdioma

class IdiomaFragment : Fragment() {
    lateinit var binding: FragmentIdiomaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentIdiomaBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = Navigation.findNavController(view)
        val db: dbIdioma = dbIdioma.getInstace(this.requireContext().applicationContext)
        val dao: Idioma_dao = db.idiomaDao()

        CoroutineScope(Dispatchers.Main).launch {
            var list_i = dao.getAllIdioma()

            binding.recyclerIdioma.layoutManager = LinearLayoutManager(context)
            val adapter = Idioma_Adapter(list_i)
            binding.recyclerIdioma.adapter = adapter
        }

        binding.btnAgregarIdioma.setOnClickListener {
            navController.navigate(R.id.agregar_idioma)
        }
    }
}