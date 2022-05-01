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
import com.example.peliculas.databinding.FragmentEditarIdiomaBinding
import com.example.peliculas.models.entities.Idioma
import com.example.peliculas.models.viewmodels.IdiomaViewModel

class EditarIdiomaFragment : Fragment() {
    lateinit var fBinding: FragmentEditarIdiomaBinding
    private val args by navArgs<EditarIdiomaFragmentArgs>()
    private lateinit var viewModel: IdiomaViewModel

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        fBinding = FragmentEditarIdiomaBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(IdiomaViewModel::class.java)
        with(fBinding) { txtIdioma.setText(args.currentIdioma.nombreI)
            btnagregarIdioma.setOnClickListener() {
                GuardarCambios()
            }
        }
        setHasOptionsMenu(true)
        return fBinding.root
    }

    private fun GuardarCambios() {
        val idioma = fBinding.txtIdioma.text.toString()
        val language = Idioma(args.currentIdioma.id_Idioma, idioma)
        viewModel.actualizarIdioma(language)
        Toast.makeText(requireContext(), "Registro actualizado", Toast.LENGTH_LONG).show()
        findNavController().navigate(R.id.volver_listaIdioma_updated)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.mnuEliminar) {
            eliminarIdioma()
        }
        return super.onOptionsItemSelected(item)
    }
    private fun eliminarIdioma() {
        val alerta = AlertDialog.Builder(requireContext())
        alerta.setPositiveButton("Si") { _, _ -> viewModel.eliminarIdioma(args.currentIdioma)
            Toast.makeText( requireContext(), "Registro eliminado satisfactoriamente...", Toast.LENGTH_LONG ).show()
            findNavController().navigate(R.id.volver_listaIdioma_updated)
        }
        alerta.setNegativeButton("No") { _, _ -> Toast.makeText( requireContext(), "Operación cancelada...", Toast.LENGTH_LONG ).show()
        }
        alerta.setTitle("Eliminando ${args.currentIdioma.nombreI}")
        alerta.setMessage("¿Esta seguro de eliminar a ${args.currentIdioma.nombreI}?")
        alerta.create().show()
    }
}