package com.giovana.todoandroid

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.giovana.todoandroid.databinding.FragmentFormBinding
import com.giovana.todoandroid.databinding.FragmentListBinding
import com.giovana.todoandroid.model.Categoria

class FormFragment : Fragment() {

    private lateinit var binding: FragmentFormBinding
    //usado para verificar se os dados da API estão vindo
    private val mainViewModel: MainViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //Inflando e retornando a fragment_form
        binding = FragmentFormBinding.inflate(layoutInflater, container, false)

        mainViewModel.listCategoria()

        //observe(viewLifecycleOwner) -> observa com base no ciclo de vida do fragment
        mainViewModel.myCategoriaResponse.observe(viewLifecycleOwner){
            //Loga com os dados
            //converte para string, pois é uma lista
            response -> Log.d("Requisicao", response.body().toString())
            spinnerCategoria(response.body())
        }

        //Quando clicar no botão
        binding.buttonSalvar.setOnClickListener {

            //dando a ação. Para onde ira
            findNavController().navigate(R.id.action_formFragment_to_listFragment)
        }
        return binding.root
    }

    fun spinnerCategoria(listCategoria: List<Categoria>?){
        if (listCategoria != null){
            binding.spinnerCategoria.adapter=
                ArrayAdapter(
                    requireContext(),
                    androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                    listCategoria
                )
        }
    }
}