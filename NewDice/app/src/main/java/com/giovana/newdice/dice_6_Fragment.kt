package com.giovana.newdice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

class dice_6_Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //Inflando e retornando a fragment_form
        val view = inflater.inflate(R.layout.fragment_dice_6, container, false)

        //Referenciando o botão
        val buttonVoltar = view.findViewById<Button>(R.id.buttonVoltar6)

        //Quando clicar no botão
        buttonVoltar.setOnClickListener {

            //dando a ação. Para onde ira
            findNavController().navigate(R.id.action_dice_6Fragment_to_menuFragment)
        }
        return view
    }
}