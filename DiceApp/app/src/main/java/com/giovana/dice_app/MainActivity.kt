package com.giovana.dice_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonD6 = findViewById<Button>(R.id.buttonD6)

        buttonD6.setOnClickListener {
           // Toast.makeText(this, "Botão clicado", Toast.LENGTH_LONG).show()
            rolarDados(6)
        }

        val buttonD8 = findViewById<Button>(R.id.buttonD20)

        buttonD8.setOnClickListener {
            // Toast.makeText(this, "Botão clicado", Toast.LENGTH_LONG).show()
            rolarDados(8)
        }

        val buttonD12 = findViewById<Button>(R.id.buttonD8)

        buttonD12.setOnClickListener {
            // Toast.makeText(this, "Botão clicado", Toast.LENGTH_LONG).show()
            rolarDados(12)
        }
        val buttonD20 = findViewById<Button>(R.id.buttonD12)

        buttonD20.setOnClickListener {
            // Toast.makeText(this, "Botão clicado", Toast.LENGTH_LONG).show()
            rolarDados(20)
        }
    }

    private fun rolarDados(lados: Int){
        val rolagem = (1..lados).random()

        //val textDado = findViewById<TextView>(R.id.textDado)
        val imageDado = findViewById<ImageView>(R.id.imageDado)
        //textDado.text = rolagem.toString()

        when(lados){

            6 ->{

                when(rolagem){
                    1 -> imageDado.setImageResource(R.drawable.dice6_1)
                    2 -> imageDado.setImageResource(R.drawable.dice6_2)
                    3 -> imageDado.setImageResource(R.drawable.dice6_3)
                    4 -> imageDado.setImageResource(R.drawable.dice6_4)
                    5 -> imageDado.setImageResource(R.drawable.dice6_5)
                    6 -> imageDado.setImageResource(R.drawable.dice6_6)
                }
            }
            8->{
                when(rolagem){
                    1 -> imageDado.setImageResource(R.drawable.dice8_1)
                    2 -> imageDado.setImageResource(R.drawable.dice8_2_png)
                    3 -> imageDado.setImageResource(R.drawable.dice8_3_png)
                    4 -> imageDado.setImageResource(R.drawable.dice8_4_png)
                    5 -> imageDado.setImageResource(R.drawable.dice8_5_png)
                    6 -> imageDado.setImageResource(R.drawable.dice8_6_png)
                    7 -> imageDado.setImageResource(R.drawable.dice8_7_png)
                    8 -> imageDado.setImageResource(R.drawable.dice8_8_png)
                }
            }
            12 ->{
                when(rolagem){
                    1 -> imageDado.setImageResource(R.drawable.dice12_1)
                    2 -> imageDado.setImageResource(R.drawable.dice12_2)
                    3 -> imageDado.setImageResource(R.drawable.dice12_3)
                    4 -> imageDado.setImageResource(R.drawable.dice12_4)
                    5 -> imageDado.setImageResource(R.drawable.dice12_5)
                    6 -> imageDado.setImageResource(R.drawable.dice12_6)
                    7 -> imageDado.setImageResource(R.drawable.dice12_7)
                    8 -> imageDado.setImageResource(R.drawable.dice12_8)
                    9 -> imageDado.setImageResource(R.drawable.dice12_9)
                    10 -> imageDado.setImageResource(R.drawable.dice12_10)
                    11 -> imageDado.setImageResource(R.drawable.dice12_11)
                    12 -> imageDado.setImageResource(R.drawable.dice12_12)
                }
                    }
            20 ->{
                when(rolagem){
                    1 -> imageDado.setImageResource(R.drawable.dice20_1)
                    2 -> imageDado.setImageResource(R.drawable.dice20_2)
                    3 -> imageDado.setImageResource(R.drawable.dice20_3)
                    4 -> imageDado.setImageResource(R.drawable.dice20_4)
                    5 -> imageDado.setImageResource(R.drawable.dice20_5)
                    6 -> imageDado.setImageResource(R.drawable.dice20_6)
                    7 -> imageDado.setImageResource(R.drawable.dice20_7)
                    8 -> imageDado.setImageResource(R.drawable.dice20_8)
                    9 -> imageDado.setImageResource(R.drawable.dice20_9)
                    10 -> imageDado.setImageResource(R.drawable.dice20_10)
                    11 -> imageDado.setImageResource(R.drawable.dice20_11)
                    12 -> imageDado.setImageResource(R.drawable.dice20_12)
                    13 -> imageDado.setImageResource(R.drawable.dice20_13)
                    14 -> imageDado.setImageResource(R.drawable.dice20_14)
                    15 -> imageDado.setImageResource(R.drawable.dice20_15)
                    16 -> imageDado.setImageResource(R.drawable.dice20_16)
                    17 -> imageDado.setImageResource(R.drawable.dice20_17)
                    18 -> imageDado.setImageResource(R.drawable.dice20_18)
                    19 -> imageDado.setImageResource(R.drawable.dice20_19)
                    20 -> imageDado.setImageResource(R.drawable.dice20_20)
                }
            }
        }


    }
}