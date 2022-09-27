package com.giovana.projetointegradorgen_as

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.giovana.projetointegradorgen_as.adapter.PostagemAdapter
import com.giovana.projetointegradorgen_as.databinding.FragmentListBinding
import com.giovana.projetointegradorgen_as.model.Postagem

class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListBinding.inflate(layoutInflater, container, false)

        val listPostagem = listOf(
            Postagem(
                "Michell Platini",
                "sasdasdaica",
                "foto michell",
                "2022-09-25",
                "Paisagem"
            ),
            Postagem(
                "Michell Platini",
                "sasdasdaica",
                "foto michell",
                "2022-09-25",
                "Paisagem"
            ),
            Postagem(
                "Michell Platini",
                "sasdasdaica",
                "foto michell",
                "2022-09-25",
                "Paisagem"
            )
        )

        //Configuração do recycleView
        val adapter = PostagemAdapter()
        binding.recyclerPostagem.layoutManager = LinearLayoutManager(context)
        binding.recyclerPostagem.adapter = adapter
        binding.recyclerPostagem.setHasFixedSize(true)

        adapter.setList(listPostagem)

        // ----------------- //
        binding.floatingAdd.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_formFragment)
        }
        return binding.root
    }
}