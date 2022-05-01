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
import com.example.peliculas.dao.Nacionalidad_dao
import com.example.peliculas.databinding.FragmentAgregarNacionalidadBinding
import com.example.peliculas.db.dbNacionalidad
import com.example.peliculas.models.entities.Nacionalidad

class AgregarNacionalidadFragment : Fragment() {

    private lateinit var binding:FragmentAgregarNacionalidadBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentAgregarNacionalidadBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = Navigation.findNavController(view)
        val db: dbNacionalidad = dbNacionalidad.getNacionalidadBD(this.requireContext().applicationContext)
        val dao: Nacionalidad_dao = db.nacionalidadDao()

        with(binding){
            btnAgregarnacionalidad.setOnClickListener {

                val id = Nacionalidad(0,txtNacionalidad.text.toString())

                CoroutineScope(Dispatchers.Main).launch {
                    dao.insertNacionalidad(id)
                }
                navController.navigate(R.id.volver_a_lista)

            }
        }
    }

}