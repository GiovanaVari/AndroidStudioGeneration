package com.giovana.sqlitecomroom.data

import androidx.room.Entity
import androidx.room.PrimaryKey

//Room pt4{
//Por meio dela expecifica que é uma tabela
@Entity(tableName = "user_table")
//}

//Room pt3{
class Usuario(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    var nome: String,
    //Room Video 2 pt0.2{
    var sobrenome: String,
    //}
    var idade: Int
)//}
{
}