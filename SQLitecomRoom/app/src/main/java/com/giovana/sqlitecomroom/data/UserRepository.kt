package com.giovana.sqlitecomroom.data

//Room pt8 {
class UserRepository (private val userDao: UserDao){
    //retorna com livedata
    val selectUsers = userDao.selectUsers()

    fun addUser(usuario: Usuario){
        userDao.addUser(usuario)
    }

}
//}