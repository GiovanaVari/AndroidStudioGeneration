package com.giovana.newdice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.navigation.fragment.findNavController

class dice_20_Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //Inflando e retornando a fragment_form
        val view = inflater.inflate(R.layout.fragment_dice_20_, container, false)

        fun rolarDados(lados: Int) {
            val rolagem = (1..20).random()

            //val textDado = findViewById<TextView>(R.id.textDado)
            val imageDado20 = view.findViewById<ImageView>(R.id.imageDado20)
            //textDado.text = rolagem.toString()

            when (rolagem) {
                1 -> imageDado20.setImageResource(R.drawable.dice20_1)
                2 -> imageDado20.setImageResource(R.drawable.dice20_2)
                3 -> imageDado20.setImageResource(R.drawable.dice20_3)
                4 -> imageDado20.setImageResource(R.drawable.dice20_4)
                5 -> imageDado20.setImageResource(R.drawable.dice20_5)
                6 -> imageDado20.setImageResource(R.drawable.dice20_6)
                7 -> imageDado20.setImageResource(R.drawable.dice20_7)
                8 -> imageDado20.setImageResource(R.drawable.dice20_8)
                9 -> imageDado20.setImageResource(R.drawable.dice20_9)
                10 -> imageDado20.setImageResource(R.drawable.dice20_10)
                11 -> imageDado20.setImageResource(R.drawable.dice20_11)
                12 -> imageDado20.setImageResource(R.drawable.dice20_12)
                13 -> imageDado20.setImageResource(R.drawable.dice20_13)
                14 -> imageDado20.setImageResource(R.drawable.dice20_14)
                15 -> imageDado20.setImageResource(R.drawable.dice20_15)
                16 -> imageDado20.setImageResource(R.drawable.dice20_16)
                17 -> imageDado20.setImageResource(R.drawable.dice20_17)
                18 -> imageDado20.setImageResource(R.drawable.dice20_18)
                19 -> imageDado20.setImageResource(R.drawable.dice20_19)
                20 -> imageDado20.setImageResource(R.drawable.dice20_20)
            }
        }

        val buttonJogar20 = view.findViewById<Button>(R.id.buttonJogar20)

        buttonJogar20.setOnClickListener {
            // Toast.makeText(this, "Botão clicado", Toast.LENGTH_LONG).show()
            rolarDados(20)
        }

        //Referenciando o botão
        val buttonVoltar = view.findViewById<Button>(R.id.buttonVoltar20)

        //Quando clicar no botão
        buttonVoltar.setOnClickListener {

            //dando a ação. Para onde ira
            findNavController().navigate(R.id.action_dice_20_Fragment_to_menuFragment)
        }
        return view
    }
}