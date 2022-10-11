package com.giovana.projetointegradorgen_as.model

data class Postagem(
    var id: Long,
    var imagem: String,
    var descricao: String,
    var tema: Tema
) {
}