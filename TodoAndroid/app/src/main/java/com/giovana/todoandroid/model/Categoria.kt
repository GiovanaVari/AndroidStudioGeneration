package com.giovana.todoandroid.model

//? para poder ser nula
data class Categoria(
    var id : Long,
    var descricao : String?,
    var tarefa : List<Tarefa>?
) {
    //sobrescreve o toString passando a descricao. !! -> para não aceitar que seja nulo
    override fun toString(): String {
        return descricao!!
    }
}