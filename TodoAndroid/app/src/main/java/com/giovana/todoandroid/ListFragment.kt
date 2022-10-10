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
import com.giovana.todoandroid.adapter.TaskClickListener
import com.giovana.todoandroid.databinding.FragmentListBinding
import com.giovana.todoandroid.model.Tarefa
import com.google.android.material.floatingactionbutton.FloatingActionButton

//------35 - Atualizando Tarefas------p6
//{
//class ListFragment : Fragment() {
//Implementando a interface TaskClickListener
class ListFragment : Fragment(), TaskClickListener {
//}
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

        //------35 - Atualizando Tarefas------p10
        //{
        //colocando o this, mainViewModel
        //Configuração do RecyclerView
        val adapter = TarefaAdapter(this, mainViewModel)
        //}
        binding.recyclerTarefa.layoutManager = LinearLayoutManager(context)
        binding.recyclerTarefa.adapter = adapter
        binding.recyclerTarefa.setHasFixedSize(true)

        //Quando clicar no botão
        binding.floatingAdd.setOnClickListener {

            //------36 - Atualizando Tarefas II ------p3
            //{
            //quando usar o botao, entrara na fragment com os campos vazios
            mainViewModel.tarefaSeleciona = null
            //}
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

    override fun onTaskClickListener(tarefa: Tarefa) {
        //------35 - Atualizando Tarefas------p7
        //{
        mainViewModel.tarefaSeleciona = tarefa
        findNavController().navigate(R.id.action_listFragment_to_formFragment)
        //}
    }
}