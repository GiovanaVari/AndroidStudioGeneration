package com.giovana.newdice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.navigation.fragment.findNavController

class dice_12_Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //Inflando e retornando a fragment_form
        val view = inflater.inflate(R.layout.fragment_dice_12_, container, false)

        fun rolarDados(lados: Int) {
            val rolagem = (1..12).random()

            //val textDado = findViewById<TextView>(R.id.textDado)
            val imageDado12 = view.findViewById<ImageView>(R.id.imageDado12)
            //textDado.text = rolagem.toString()

            when (rolagem) {
                1 -> imageDado12.setImageResource(R.drawable.dice12_1)
                2 -> imageDado12.setImageResource(R.drawable.dice12_2)
                3 -> imageDado12.setImageResource(R.drawable.dice12_3)
                4 -> imageDado12.setImageResource(R.drawable.dice12_4)
                5 -> imageDado12.setImageResource(R.drawable.dice12_5)
                6 -> imageDado12.setImageResource(R.drawable.dice12_6)
                7 -> imageDado12.setImageResource(R.drawable.dice12_7)
                8 -> imageDado12.setImageResource(R.drawable.dice12_8)
                9 -> imageDado12.setImageResource(R.drawable.dice12_9)
                10 -> imageDado12.setImageResource(R.drawable.dice12_10)
                11 -> imageDado12.setImageResource(R.drawable.dice12_11)
                12 -> imageDado12.setImageResource(R.drawable.dice12_12)
            }
        }

        val buttonJogar12 = view.findViewById<Button>(R.id.buttonJogar12)

        buttonJogar12.setOnClickListener {
            // Toast.makeText(this, "Botão clicado", Toast.LENGTH_LONG).show()
            rolarDados(12)
        }

        //Referenciando o botão
        val buttonVoltar = view.findViewById<Button>(R.id.buttonVoltar12)

        //Quando clicar no botão
        buttonVoltar.setOnClickListener {

            //dando a ação. Para onde ira
            findNavController().navigate(R.id.action_dice_12_Fragment_to_menuFragment)
        }
        return view
    }
}