package com.giovana.todoandroid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.giovana.todoandroid.adapter.TarefaAdapter
import com.giovana.todoandroid.databinding.FragmentListBinding
import com.giovana.todoandroid.model.Tarefa
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //Inflando e retornando a fragment_list
        binding = FragmentListBinding.inflate(layoutInflater, container, false)

        val listTarefa = listOf(
            Tarefa(
                "Lavar a louça",
                "lavar a louça do dia todo",
                "Henrique",
                "2022-05-15",
                false,
                "Dia-a-dia"
            ),
        Tarefa(
              "Lavar Roupa",
            "Separar por cor e por na máquina",
            "Giovana",
            "2022-09-26",
            true,
            "Dia-a-dia"
        ),
            Tarefa(
                "Assistir um série",
                "Assistir uma série para relaxar",
                "Todos na face da terra",
                "2022-10-12",
                false,
                "Lazer"
            )
        )

        //Configuração do RecyclerView
        val adapter = TarefaAdapter()
        binding.recyclerTarefa.layoutManager = LinearLayoutManager(context)
        binding.recyclerTarefa.adapter = adapter
        binding.recyclerTarefa.setHasFixedSize(true)

        adapter.setList(listTarefa)


        //Quando clicar no botão
        binding.floatingAdd.setOnClickListener {

            //dando a ação. Para onde ira
            findNavController().navigate(R.id.action_listFragment_to_formFragment)
        }

        return binding.root
    }
}