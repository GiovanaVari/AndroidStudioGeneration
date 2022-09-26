package com.giovana.todoandroid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.giovana.todoandroid.databinding.FragmentFormBinding
import com.giovana.todoandroid.databinding.FragmentListBinding

class FormFragment : Fragment() {

    private lateinit var binding: FragmentFormBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //Inflando e retornando a fragment_form
        binding = FragmentFormBinding.inflate(layoutInflater, container, false)

        //Quando clicar no botão
        binding.buttonSalvar.setOnClickListener {

            //dando a ação. Para onde ira
            findNavController().navigate(R.id.action_formFragment_to_listFragment)
        }
        return binding.root
    }
}