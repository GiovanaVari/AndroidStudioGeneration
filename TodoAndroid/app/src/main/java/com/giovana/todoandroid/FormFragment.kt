package com.giovana.todoandroid

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.giovana.todoandroid.databinding.FragmentFormBinding
import com.giovana.todoandroid.databinding.FragmentListBinding
import com.giovana.todoandroid.fragment.DatePickerFragment
import com.giovana.todoandroid.fragment.TimerPickerListener
import com.giovana.todoandroid.model.Categoria
import com.giovana.todoandroid.model.Tarefa
import java.time.LocalDate

//Implementa a interface TimerPickerListener
class FormFragment : Fragment(), TimerPickerListener {

    private lateinit var binding: FragmentFormBinding

    //usado para verificar se os dados da API estão vindo
    private val mainViewModel: MainViewModel by activityViewModels()

    //Armazena o Id da categoria que sera usada
    private var categoriaSelecionada = 0L

    //------35 - Atualizando Tarefas------p11
    //{
    private var tarefaSelecionada: Tarefa? = null
    //}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //Inflando e retornando a fragment_form
        binding = FragmentFormBinding.inflate(layoutInflater, container, false)

        //------35 - Atualizando Tarefas------p13
        //{
        //chamando os dados
        carregarDados()
        //}

        mainViewModel.listCategoria()

        mainViewModel.dataSelecionada.value = LocalDate.now()

        //observe(viewLifecycleOwner) -> observa com base no ciclo de vida do fragment
        mainViewModel.myCategoriaResponse.observe(viewLifecycleOwner) {
            //Loga com os dados
            //converte para string, pois é uma lista
                response ->
            Log.d("Requisicao", response.body().toString())
            spinnerCategoria(response.body())
        }

        //observa o mainViewModel.dataSelecionada.value = LocalDate.now(),
        // para quando mudar ele trazer para o edit data (campo que esta sendo usado)
        mainViewModel.dataSelecionada.observe(viewLifecycleOwner) {
            // criando a variavel localmente. Quando abrir ele seleciona a data atual e salva dentro do editData
                selectedDate ->
            binding.editData.setText(selectedDate.toString())
        }

        //Quando clicar no botão
        binding.buttonSalvar.setOnClickListener {
            inserirNoBanco()
        }

        // Instancia o Date para aparecer
        //Quando clicar no edit mostra o fragment pegando o timerPickerListener
        binding.editData.setOnClickListener {
            DatePickerFragment(this)
                .show(parentFragmentManager, "DatePicker")
        }

        return binding.root
    }

    private fun spinnerCategoria(listCategoria: List<Categoria>?) {
        if (listCategoria != null) {
            binding.spinnerCategoria.adapter =
                ArrayAdapter(
                    requireContext(),
                    androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                    listCategoria
                )

            binding.spinnerCategoria.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                        //Verifica se esta selecionado
                        val selected = binding.spinnerCategoria.selectedItem as Categoria

                        //recupera o id dentro da categoria selecionada
                        categoriaSelecionada = selected.id
                    }

                    override fun onNothingSelected(p0: AdapterView<*>?) {
                        TODO("Not yet implemented")
                    }

                }

        }
    }

    //Validando os campos
    private fun validarCampos(
        nome: String, descricao: String, responsavel: String
    ): Boolean {

        //Verifica se esta certo
        return !(
                (nome == "" || nome.length < 3 || nome.length > 20) ||
                        (descricao == "" || descricao.length < 5 || descricao.length > 200) ||
                        (responsavel == "" || responsavel.length < 3 || responsavel.length > 20)
                )
    }

    private fun inserirNoBanco() {
        val nome = binding.editNome.text.toString()
        val desc = binding.editDescricao.text.toString()
        val resp = binding.editResponsavel.text.toString()
        val data = binding.editData.text.toString()
        val status = binding.switchAtivoCard.isChecked
        val categoria = Categoria(categoriaSelecionada, null, null)

        if (validarCampos(nome, desc, resp)) {

            //------36 - Atualizando Tarefas II ------p1
            //{
            val salvar: String
            //verifica se tem uma tarefa selecionada
            //se for diferente de nula, atualiza
            if (tarefaSelecionada != null){
                salvar = "Tarefa Atualizada"
                val tarefa = Tarefa(tarefaSelecionada?.id!!, nome, desc, resp, data, status, categoria)
                mainViewModel.addTarefa(tarefa)
            }else {
                salvar = "Tarefa Criada!"
                val tarefa = Tarefa(0, nome, desc, resp, data, status, categoria)
                mainViewModel.addTarefa(tarefa)
            }
            Toast.makeText(context, salvar, Toast.LENGTH_SHORT).show()
            //}
            //dando a ação. Para onde ira
            findNavController().navigate(R.id.action_formFragment_to_listFragment)

        } else {
            Toast.makeText(context, "Verifique os campos!", Toast.LENGTH_SHORT).show()
        }

    }

    //------35 - Atualizando Tarefas------p12
    //{
    private fun carregarDados(){
        tarefaSelecionada = mainViewModel.tarefaSeleciona
        //se for diferente de nulo carrega os dados
        if(tarefaSelecionada != null){
            binding.editNome.setText(tarefaSelecionada?.nome)
            binding.editDescricao.setText(tarefaSelecionada?.descricao)
            binding.editResponsavel.setText(tarefaSelecionada?.responsavel)
            binding.editData.setText(tarefaSelecionada?.data)
            binding.switchAtivoCard.isChecked = tarefaSelecionada?.status!!
        }
    }
    //}

    //pega a data e joga na variavel dataSelecionada da mainViewModel
    override fun onDateSelected(date: LocalDate) {
        mainViewModel.dataSelecionada.value = date
    }
}