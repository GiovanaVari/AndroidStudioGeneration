package com.giovana.newdice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.navigation.fragment.findNavController

class dice_8_Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //Inflando e retornando a fragment_form
        val view = inflater.inflate(R.layout.fragment_dice_8, container, false)

        fun rolarDados(lados: Int) {
            val rolagem = (1..8).random()

            //val textDado = findViewById<TextView>(R.id.textDado)
            val imageDado8 = view.findViewById<ImageView>(R.id.imageDado8)
            //textDado.text = rolagem.toString()

            when (rolagem) {
                1 -> imageDado8.setImageResource(R.drawable.dice8_1)
                2 -> imageDado8.setImageResource(R.drawable.dice8_2_png)
                3 -> imageDado8.setImageResource(R.drawable.dice8_3_png)
                4 -> imageDado8.setImageResource(R.drawable.dice8_4_png)
                5 -> imageDado8.setImageResource(R.drawable.dice8_5_png)
                6 -> imageDado8.setImageResource(R.drawable.dice8_6_png)
                7 -> imageDado8.setImageResource(R.drawable.dice8_7_png)
                8 -> imageDado8.setImageResource(R.drawable.dice8_8_png)
            }
        }

        val buttonJogar8 = view.findViewById<Button>(R.id.buttonJogar8)

        buttonJogar8.setOnClickListener {
            // Toast.makeText(this, "Botão clicado", Toast.LENGTH_LONG).show()
            rolarDados(8)
        }

        //Referenciando o botão
        val buttonVoltar = view.findViewById<Button>(R.id.buttonVoltar8)

        //Quando clicar no botão
        buttonVoltar.setOnClickListener {

            //dando a ação. Para onde ira
            findNavController().navigate(R.id.action_dice_8_Fragment_to_menuFragment)
        }
        return view
    }
}