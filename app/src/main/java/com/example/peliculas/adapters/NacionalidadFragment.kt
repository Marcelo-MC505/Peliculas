package com.example.peliculas.adapters

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.peliculas.R
import com.example.peliculas.models.viewmodels.NacionalidadViewModel
import com.example.peliculas.databinding.FragmentNacionalidadBinding

class NacionalidadFragment : Fragment() {
    private lateinit var fBinding: FragmentNacionalidadBinding

    private lateinit var viewModel : NacionalidadViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View {
        fBinding = FragmentNacionalidadBinding.inflate(layoutInflater)
        val adapter = Nacionalidad_Adapter()
        val recycleView = fBinding.RcvListaNacionalidad
        recycleView.adapter = adapter
        recycleView.layoutManager = LinearLayoutManager(requireContext())
        viewModel = ViewModelProvider(this).get(NacionalidadViewModel::class.java)
        viewModel.listaN.observe(viewLifecycleOwner, Observer
        {
                nacionalidad-> adapter.setData(nacionalidad)
        })

        setHasOptionsMenu(true)
        return fBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }

    private fun setupViews() {
        with(fBinding) {
            BtnAgregarNacionalidad.setOnClickListener {
                it.findNavController().navigate(R.id.agregar_nacionalidad)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.mnuEliminar) {
            eliminarTodo()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun eliminarTodo() {
        val alerta = AlertDialog.Builder(requireContext())
        alerta.setPositiveButton("Si") {
                _, _ -> viewModel.eliminarTodoNacionalidad()
            Toast.makeText( requireContext(), "Registros eliminados satisfactoriamente...", Toast.LENGTH_LONG ).show()
        }
        alerta.setNegativeButton("No") { _, _ -> Toast.makeText( requireContext(), "Operación cancelada...", Toast.LENGTH_LONG ).show()
        }
        alerta.setTitle("Eliminando todos los registro")
        alerta.setMessage("¿Esta seguro de eliminar los registros?")
        alerta.create().show()
    }
}