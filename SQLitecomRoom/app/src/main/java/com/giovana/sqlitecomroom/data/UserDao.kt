package com.giovana.sqlitecomroom.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

//Room pt5{
//Para o room gerar as requisições a partir daqui
@Dao
//}
interface UserDao {
    //Room pt6{
    //Para indicar pro room que usara a fun para inserir dados no banco. caso duplicado ignora
    @Insert(onConflict = OnConflictStrategy.IGNORE)

    //add usuario no banco
    fun addUser(usuario: Usuario)

    //Seleciona usuarios e ordena
    @Query("select * from user_table order by id asc")
    fun selectUsers(): LiveData<List<Usuario>>
    //}
}