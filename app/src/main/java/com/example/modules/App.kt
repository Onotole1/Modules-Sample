package com.example.modules

import android.app.Application
import com.github.terrakok.cicerone.Cicerone

class App : Application() {
    companion object {
        internal lateinit var INSTANCE: App
            private set
    }

    private val cicerone = Cicerone.create()
    val router get() = cicerone.router
    val navigatorHolder get() = cicerone.getNavigatorHolder()

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }
}
