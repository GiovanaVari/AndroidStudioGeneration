package com.giovana.sqlitecomroom

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.giovana.sqlitecomroom.data.Usuario
import com.giovana.sqlitecomroom.databinding.FragmentAddBinding

class AddFragment : Fragment() {

    private lateinit var binding: FragmentAddBinding
    //aqui
    //Room Video 2 pt3{
    private lateinit var mainViewModel: MainViewModel
    //}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddBinding.inflate(layoutInflater, container, false)

        //Room Video 2 pt4{
        //para instanciar a mainviewmodel
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        //}

        binding.buttonAdd.setOnClickListener {
            //Room Video 2 pt6 APAGAR O "//" da linha de baixo
            inserirNoBanco()
        }
        return binding.root
    }

    //Room Video 2 pt0.1{
    //verificando se os campos estão vazios
    fun verificarCampos(nome : String, sobrenome : String, idade : String): Boolean{
        //se qualquer um estiver vazio, ele ira retornar false
        return !(nome == "" || sobrenome == "" || idade == "")
    }

    fun inserirNoBanco(){
        //pegando informações digitadas pelo user
        val nome = binding.editNome.text.toString()
        val sobrenome = binding.editSobrenome.text.toString()
        val idade = binding.editIdade.text.toString()

        //verificando se esta preenchido corretamente
        if(verificarCampos(nome,sobrenome,idade)){
            val user = Usuario(0, nome, sobrenome, idade.toInt())
            //}
            //Room Video 2 pt5{
            //chamando o metodo
            mainViewModel.addUser(user)
            //dando feedback para o usuario
            Toast.makeText(context, "Usuario Adicionado!", Toast.LENGTH_LONG).show()
            //para navegar para a fragment list
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }else{
            Toast.makeText(context, "Preencha todos os campos!", Toast.LENGTH_LONG).show()
        }
        //}
    }
}