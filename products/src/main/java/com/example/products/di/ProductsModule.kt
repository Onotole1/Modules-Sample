package com.example.products.di

import com.example.products.core.navigation.ProductsRouter
import com.example.products.navigation.ProductsRouterImpl
import com.example.products.ui.presenter.ProductsPresenter
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

val productsModule = module {
    factoryOf(::ProductsPresenter)
    factoryOf(::ProductsRouterImpl).bind<ProductsRouter>()
}
