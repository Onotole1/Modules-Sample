package com.example.application

import android.app.Application
import com.example.credits.di.creditsModule
import com.example.products.di.productsModule
import com.github.terrakok.cicerone.Cicerone
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

class App : Application() {

    private val navigationModule = module {
        val cicerone = Cicerone.create()
        factoryOf(cicerone::router)
        factoryOf(cicerone::getNavigatorHolder)
    }

    override fun onCreate() {
        super.onCreate()
        startKoin{
            modules(
                navigationModule,
                creditsModule,
                productsModule,
            )
        }
    }
}
