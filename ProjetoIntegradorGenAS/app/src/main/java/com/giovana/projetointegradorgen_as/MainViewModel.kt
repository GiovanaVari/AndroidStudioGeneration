package com.giovana.projetointegradorgen_as

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.giovana.projetointegradorgen_as.api.Repository
import com.giovana.projetointegradorgen_as.model.Postagem
import com.giovana.projetointegradorgen_as.model.Tema
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    private val _myTemaResponse = MutableLiveData<Response<List<Tema>>>()

    val myTemaResponse: LiveData<Response<List<Tema>>> = _myTemaResponse

//
//    init {
//        listTema()
//    }

    fun listTema() {
        viewModelScope.launch {

            try {
                val response = repository.listTema()
                _myTemaResponse.value = response
            } catch (e: Exception) {
                Log.d("Erro:/", e.message.toString())
            }

        }
    }

    fun addPost(postagem: Postagem) {
        viewModelScope.launch {
            try {
                val response = repository.addPost(postagem)
                Log.d("jsaid", "jodasjod")

            } catch (e: Exception) {
                Log.d("Erro:/", e.message.toString())
            }
        }
    }
}