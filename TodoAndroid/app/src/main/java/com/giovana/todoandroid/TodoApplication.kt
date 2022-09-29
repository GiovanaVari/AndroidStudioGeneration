package com.giovana.todoandroid

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

//Indica que pode usar o hilt
@HiltAndroidApp
class TodoApplication : Application() {
}