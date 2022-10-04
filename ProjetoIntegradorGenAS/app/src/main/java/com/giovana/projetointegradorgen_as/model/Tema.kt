package com.giovana.projetointegradorgen_as.model

data class Tema(
    var id: Long,
    var nome: String?,
    var postagens: List<Postagem>?
) {

    override fun toString(): String {
        return nome!!
    }

}