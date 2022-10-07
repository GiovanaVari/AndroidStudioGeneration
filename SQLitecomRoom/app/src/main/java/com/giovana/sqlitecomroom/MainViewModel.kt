package com.giovana.sqlitecomroom

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.giovana.sqlitecomroom.data.UserDatabase
import com.giovana.sqlitecomroom.data.UserRepository
import com.giovana.sqlitecomroom.data.Usuario
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//Room pt9{
//Room Video 2 pt1{
//editando a linha abaixo
// class MainViewModel (context: Context) : ViewModel() {
class MainViewModel (application: Application) : AndroidViewModel(application) {
//}

    val selectUsers: LiveData<List<Usuario>>
    val repository: UserRepository

    init {
        //tras os dados do banco
        //Room video 2 pt2{
        //editanto tb
        // val userDao = UserDatabase.getDatabase(context).userDao()
        val userDao = UserDatabase.getDatabase(application).userDao()
        //}
        repository = UserRepository(userDao)
        selectUsers = repository.selectUsers
    }

    fun addUser(usuario: Usuario){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(usuario)
        }
    }

}
//}