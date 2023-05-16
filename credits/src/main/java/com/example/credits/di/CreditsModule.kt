package com.example.credits.di

import com.example.credits.core.navigation.CreditsRouter
import com.example.credits.navigation.CreditsRouterImpl
import com.example.credits.ui.presenter.CreditsPresenter
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

val creditsModule = module {
    factoryOf(::CreditsRouterImpl).bind<CreditsRouter>()
    factoryOf(::CreditsPresenter)
}
