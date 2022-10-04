package com.giovana.todoandroid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.giovana.todoandroid.adapter.TarefaAdapter
import com.giovana.todoandroid.databinding.FragmentListBinding
import com.giovana.todoandroid.model.Tarefa
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding

    //----- 31 - Listando Tarefas ------p6
    //{
    //Pega a mesma instancia que esta sendo usada no form fragment
    private val mainViewModel: MainViewModel by activityViewModels()
    // }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //Inflando e retornando a fragment_list
        binding = FragmentListBinding.inflate(layoutInflater, container, false)

        //----- 31 - Listando Tarefas ------p7
        //{
        mainViewModel.listTarefa()
        //}

        //Configuração do RecyclerView
        val adapter = TarefaAdapter()
        binding.recyclerTarefa.layoutManager = LinearLayoutManager(context)
        binding.recyclerTarefa.adapter = adapter
        binding.recyclerTarefa.setHasFixedSize(true)

        //Quando clicar no botão
        binding.floatingAdd.setOnClickListener {

            //dando a ação. Para onde ira
            findNavController().navigate(R.id.action_listFragment_to_formFragment)
        }

        //----- 31 - Listando Tarefas ------p8
        //{
        mainViewModel.myTarefaResponse.observe(viewLifecycleOwner) {
            //verifica se é nulo, antes de chamar o set list
                response ->
            if (response.body() != null) {
                adapter.setList(response.body()!!)
            }
        }
        //}

        return binding.root
    }
}