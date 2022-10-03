package com.giovana.projetointegradorgen_as.model

data class Tema(
    var id: Long,
    var tema: String?,
    var postagens: List<Postagem>?
) {}