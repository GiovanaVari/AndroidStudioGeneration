package com.giovana.projetointegradorgen_as.model

import androidx.room.Entity
import androidx.room.PrimaryKey


class Usuario(
    val id: Long,
    val email: String,
    val senha: String,
) {
}