package com.giovana.newdice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

class MenuFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //Inflando e retornando a fragment_menu
        val view = inflater.inflate(R.layout.fragment_menu, container, false)

        //Referenciando o botão
        val button = view.findViewById<Button>(R.id.buttond6)

        //Quando clicar no botão
        button.setOnClickListener {

            //dando a ação. Para onde ira
            findNavController().navigate(R.id.action_dice_6Fragment_to_menuFragment)
        }

        return view
    }
}