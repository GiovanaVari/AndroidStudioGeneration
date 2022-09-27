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
        val buttond6 = view.findViewById<Button>(R.id.buttond6)

        //Quando clicar no botão
        buttond6.setOnClickListener {

            //dando a ação. Para onde ira
            findNavController().navigate(R.id.action_menuFragment_to_dice_6_Fragment)
        }

        val buttond8 = view.findViewById<Button>(R.id.buttond8)

        //Quando clicar no botão
        buttond8.setOnClickListener {

            //dando a ação. Para onde ira
            findNavController().navigate(R.id.action_menuFragment_to_dice_8_Fragment)
        }

        val buttond12 = view.findViewById<Button>(R.id.buttond12)

        //Quando clicar no botão
        buttond12.setOnClickListener {

            //dando a ação. Para onde ira
            findNavController().navigate(R.id.action_menuFragment_to_dice_12_Fragment)
        }

        val buttond20 = view.findViewById<Button>(R.id.buttond20)

        //Quando clicar no botão
        buttond20.setOnClickListener {

            //dando a ação. Para onde ira
            findNavController().navigate(R.id.action_menuFragment_to_dice_20_Fragment)
        }

        return view
    }
}