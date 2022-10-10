package com.giovana.todoandroid

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.giovana.todoandroid.api.Repository
import com.giovana.todoandroid.model.Categoria
import com.giovana.todoandroid.model.Tarefa
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository
        ): ViewModel() {

    //------35 - Atualizando Tarefas------p4
    //{
    //se for nulo cria uma nova e se não for, entao atualiza
    var tarefaSeleciona : Tarefa? = null
    //}

    private val _myCategoriaResponse =
        MutableLiveData<Response<List<Categoria>>>()

    val myCategoriaResponse: LiveData<Response<List<Categoria>>> =
        _myCategoriaResponse

    // ------ 31 - Listando Tarefas ------ p4
    //{
    private val _myTarefaResponse =
        MutableLiveData<Response<List<Tarefa>>>()

    val myTarefaResponse: LiveData<Response<List<Tarefa>>> =
        _myTarefaResponse
    //}


    val dataSelecionada = MutableLiveData<LocalDate>()

    init {
        //listCategoria()
    }

    fun listCategoria(){
        viewModelScope.launch {
            //para caso não tiver internet, ele não quebre o app
            try {
                val response = repository.listCategoria()
                _myCategoriaResponse.value = repository.listCategoria()
            }catch (e: Exception){
                Log.d("Erro", e.message.toString())
            }

        }
    }

    fun addTarefa(tarefa: Tarefa){
        viewModelScope.launch {
            try {
                repository.addTarefa(tarefa)
                //----- 31 - Listando Tarefas ------p9
                //{
                listTarefa()
                //}
            } catch (e:Exception){
                Log.d("Erro", e.message.toString())
            }
        }
    }

    //----- 31 - Listando Tarefas ------p3
    //{
    fun listTarefa(){
        //abrindo uma corrotina
        viewModelScope.launch {
            try{
                //----- 31 - Listando Tarefas ------p5
                //{
                val response = repository.listTarefa()
                _myTarefaResponse.value = response
                //}
            }catch (e: Exception){
                Log.d("Erro", e.message.toString())
            }

        }
    }
//}

    //------35 - Atualizando Tarefas------p3
    //{
    //processando os dados
    fun updateTarefa(tarefa: Tarefa){
        viewModelScope.launch {
            try {
                repository.updateTarefa(tarefa)
                listTarefa()
            }catch (e: Exception){
                Log.d("Erro", e.message.toString())
            }
        }
    }
    //}

}