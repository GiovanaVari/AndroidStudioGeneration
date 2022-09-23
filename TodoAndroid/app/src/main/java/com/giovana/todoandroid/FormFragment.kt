package com.giovana.todoandroid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

class FormFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //Inflando e retornando a fragment_form
        val view = inflater.inflate(R.layout.fragment_form, container, false)

        //Referenciando o botão
        val buttonSalvar = view.findViewById<Button>(R.id.buttonSalvar)

        //Quando clicar no botão
        buttonSalvar.setOnClickListener {

            //dando a ação. Para onde ira
            findNavController().navigate(R.id.action_formFragment_to_listFragment)
        }
        return view
    }
}