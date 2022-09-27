package com.giovana.newdice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.navigation.fragment.findNavController

class dice_6_Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        //Inflando e retornando a fragment_form
        val view = inflater.inflate(R.layout.fragment_dice_6, container, false)

        fun rolarDados(lados: Int) {
            val rolagem = (1..6).random()

            //val textDado = findViewById<TextView>(R.id.textDado)
            val imageDado = view.findViewById<ImageView>(R.id.imageDado6)
            //textDado.text = rolagem.toString()

            when (rolagem) {
                1 -> imageDado.setImageResource(R.drawable.dice6_1)
                2 -> imageDado.setImageResource(R.drawable.dice6_2)
                3 -> imageDado.setImageResource(R.drawable.dice6_3)
                4 -> imageDado.setImageResource(R.drawable.dice6_4)
                5 -> imageDado.setImageResource(R.drawable.dice6_5)
                6 -> imageDado.setImageResource(R.drawable.dice6_6)
            }
        }

        val buttonJogar6 = view.findViewById<Button>(R.id.buttonJogar6)

        buttonJogar6.setOnClickListener {
            // Toast.makeText(this, "Botão clicado", Toast.LENGTH_LONG).show()
            rolarDados(6)
        }

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