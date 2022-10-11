package com.giovana.projetointegradorgen_as.api

import com.giovana.projetointegradorgen_as.model.Postagem
import com.giovana.projetointegradorgen_as.model.Tema
import retrofit2.Response

class Repository {

    suspend fun listTema(): Response<List<Tema>> {
        return RetrofitInstance.api.listTema()
    }

    suspend fun listPostagem(): Response<List<Postagem>> {
        return RetrofitInstance.api.listPostagem()
    }

    suspend fun addPost(postagem: Postagem): Response<Postagem> {
        return RetrofitInstance.api.addPost(postagem)
    }

    suspend fun upDatePostagem(postagem: Postagem): Response<Postagem> {
        return RetrofitInstance.api.upDatePost(postagem)
    }
}
