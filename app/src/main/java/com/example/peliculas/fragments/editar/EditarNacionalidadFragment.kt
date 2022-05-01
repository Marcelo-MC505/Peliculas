package com.example.peliculas.fragments.editar

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.peliculas.R
import com.example.peliculas.databinding.FragmentEditarNacionalidadBinding
import com.example.peliculas.models.entities.Nacionalidad
import com.example.peliculas.models.viewmodels.NacionalidadViewModel

class EditarNacionalidadFragment : Fragment() {
    lateinit var fBinding: FragmentEditarNacionalidadBinding
    private val args by navArgs<EditarNacionalidadFragmentArgs>()
    private lateinit var viewModel: NacionalidadViewModel

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        fBinding = FragmentEditarNacionalidadBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(NacionalidadViewModel::class.java)
        with(fBinding) { txtNacionalidad.setText(args.currentNacionalidad.nombreN)
            btnAgregarnacionalidad.setOnClickListener() {
                GuardarCambios()
            }
        }
        setHasOptionsMenu(true)
        return fBinding.root
    }

    private fun GuardarCambios() {
        val nacionalidad = fBinding.txtNacionalidad.text.toString()
        val pais = Nacionalidad(args.currentNacionalidad.id_Nacionalidad, nacionalidad)
        viewModel.actualizarNacionalidad(pais)
        Toast.makeText(requireContext(), "Registro actualizado", Toast.LENGTH_LONG).show()
        findNavController().navigate(R.id.volver_listaNacionalidad_updated)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.mnuEliminar) {
            eliminarNacionalidad()
        }
        return super.onOptionsItemSelected(item)
    }
    private fun eliminarNacionalidad() {
        val alerta = AlertDialog.Builder(requireContext())
        alerta.setPositiveButton("Si") { _, _ -> viewModel.eliminarNacionalidad(args.currentNacionalidad)
            Toast.makeText( requireContext(), "Registro eliminado satisfactoriamente...", Toast.LENGTH_LONG ).show()
            findNavController().navigate(R.id.volver_listaNacionalidad_updated)
        }
        alerta.setNegativeButton("No") { _, _ -> Toast.makeText( requireContext(), "Operación cancelada...", Toast.LENGTH_LONG ).show()
        }
        alerta.setTitle("Eliminando ${args.currentNacionalidad.nombreN}")
        alerta.setMessage("¿Esta seguro de eliminar a ${args.currentNacionalidad.nombreN}?")
        alerta.create().show()
    }
}