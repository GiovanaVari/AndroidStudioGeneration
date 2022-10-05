package com.giovana.projetointegradorgen_as.api

import com.giovana.projetointegradorgen_as.model.Postagem
import com.giovana.projetointegradorgen_as.model.Tema
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("tema")
    suspend fun listTema(): Response<List<Tema>>

    @POST("postagem")
    suspend fun addPost(
        @Body postagem: Postagem
    ): Response<Postagem>
}