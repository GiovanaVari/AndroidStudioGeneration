package com.giovana.todoandroid.di

import com.giovana.todoandroid.api.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

//Para virar um objeto de Modulo
@Module
//Para prover as classes como objeto unico
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Singleton
    //Indica que podera ser injetado
    @Provides
    fun returnRepository(): Repository{
        return Repository()
    }

}