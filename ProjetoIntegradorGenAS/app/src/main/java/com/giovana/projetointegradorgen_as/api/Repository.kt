package com.giovana.projetointegradorgen_as

import com.giovana.projetointegradorgen_as.model.Postagem
import com.giovana.projetointegradorgen_as.model.Tema
import retrofit2.Response

class Repository {
    suspend fun listTema(): Response<List<Tema>> {
        return RetrofitInstance.api.listTema()
    }

    suspend fun addPost(postagem: Postagem): Response<Postagem> {
        return RetrofitInstance.api.addPost(postagem)
    }
}