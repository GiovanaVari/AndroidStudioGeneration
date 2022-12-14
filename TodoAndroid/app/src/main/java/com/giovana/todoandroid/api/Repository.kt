package com.giovana.todoandroid.api

import com.giovana.todoandroid.model.Categoria
import com.giovana.todoandroid.model.Tarefa
import retrofit2.Response

class Repository {

    suspend fun listCategoria(): Response<List<Categoria>> {
        return RetrofitInstance.api.listCategoria()
    }

    suspend fun addTarefa(tarefa: Tarefa): Response<Tarefa>{
        return RetrofitInstance.api.addTarefa(tarefa)
    }

    //----- 31 - Listando Tarefas-----p2
    //{
    suspend fun listTarefa(): Response<List<Tarefa>>{
        return RetrofitInstance.api.listTarefa()
    }
//}

    //------35 - Atualizando Tarefas------p2
    //{
    suspend fun updateTarefa(tarefa: Tarefa): Response<Tarefa>{
        return RetrofitInstance.api.updateTarefa(tarefa)
    }

    //------37 - Deletando Tarefas------p2
    //{
    suspend fun deleteTarefa(id: Long): Response<Tarefa>{
        return RetrofitInstance.api.deleteTarefa(id)
    }
    //}
    //}
}