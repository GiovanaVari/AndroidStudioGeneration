package com.giovana.todoandroid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //Inflando e retornando a fragment_list
        val view = inflater.inflate(R.layout.fragment_list, container, false)

        //Referenciando o botão
        val floatingAdd = view.findViewById<FloatingActionButton>(R.id.floatingAdd)

        //Quando clicar no botão
        floatingAdd.setOnClickListener {

            //dando a ação. Para onde ira
            findNavController().navigate(R.id.action_listFragment_to_formFragment)
        }

        return view
    }
}