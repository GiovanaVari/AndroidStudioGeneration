package com.giovana.todoandroid

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.giovana.todoandroid.api.Repository
import com.giovana.todoandroid.model.Categoria
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository
        ): ViewModel() {

    private val _myCategoriaResponse =
        MutableLiveData<Response<List<Categoria>>>()

    val myCategoriaResponse: LiveData<Response<List<Categoria>>> =
        _myCategoriaResponse

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

}