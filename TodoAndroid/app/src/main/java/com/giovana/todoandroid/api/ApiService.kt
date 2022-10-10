package com.giovana.todoandroid.api

import com.giovana.todoandroid.model.Categoria
import com.giovana.todoandroid.model.Tarefa
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

interface ApiService {

    @GET("categoria")
    suspend fun listCategoria(): Response<List<Categoria>>

    @POST("tarefa")
    suspend fun addTarefa(
        //Indica o corpo
        @Body tarefa: Tarefa
    ): Response<Tarefa>

    //------31 - Listando Tarefas------p1
    //{
    //Faz uma requisicao e devolve a lista tarefa
    @GET("tarefa")
    suspend fun listTarefa():Response<List<Tarefa>>

    //------35 - Atualizando Tarefas------p1
    //{
    @PUT("tarefa")
    suspend fun updateTarefa(
        @Body tarefa: Tarefa
    ): Response<Tarefa>
    //}

//}
}