package com.giovana.sqlitecomroom.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//Room pt7{
//Para reconhecer que essa class sera um banco de dados do room
@Database(entities = [Usuario::class], version = 1, exportSchema = false)

abstract class UserDatabase : RoomDatabase(){
    //Para recupera o userdao
    abstract fun userDao(): UserDao

    //Criando o esquema para retornar o banco de dados
    companion object{
        //certifica q nao existe instancia do room criada
        @Volatile
        // para ficar visivel para todas as threads do app a partir do momento que sera instanciada
        private var INSTANCE: UserDatabase? = null

        //Verifica se existe uma instancia criada, se não existir entao sera criada
        fun getDatabase(context: Context): UserDatabase {
            val tempInstance = INSTANCE
            //Se existir retorna ela
            if (tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                //guarda a instacia do bd
                val instance = Room.databaseBuilder(
                    //onde sera criado
                    context.applicationContext,
                    //cria o bd com base na UserDatabase
                    UserDatabase::class.java,
                    //nome
                    "user_database"
                ).build()
                //guarda
                INSTANCE = instance
                return instance
            }
        }
    }
}
//}