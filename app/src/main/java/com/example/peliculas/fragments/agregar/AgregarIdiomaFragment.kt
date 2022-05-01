package com.example.peliculas.fragments.agregar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.peliculas.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import com.example.peliculas.dao.Idioma_dao
import com.example.peliculas.databinding.FragmentAgregarIdiomaBinding
import com.example.peliculas.db.dbIdioma
import com.example.peliculas.models.entities.Idioma

class AgregarIdiomaFragment : Fragment() {

    private lateinit var binding : FragmentAgregarIdiomaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentAgregarIdiomaBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = Navigation.findNavController(view)
        val db: dbIdioma = dbIdioma.getIdiomaBD(this.requireContext().applicationContext)
        val dao: Idioma_dao = db.idiomaDao()

        with(binding){
            btnagregarIdioma.setOnClickListener {

                val id = Idioma(0,txtIdioma.text.toString())

                CoroutineScope(Dispatchers.Main).launch {
                    dao.insertIdioma(id)
                }
                navController.navigate(R.id.volver_a_listaidioma)

            }
        }
    }

}