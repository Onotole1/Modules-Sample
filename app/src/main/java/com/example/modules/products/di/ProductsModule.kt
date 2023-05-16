package com.example.modules.products.di

import com.example.modules.products.ui.presenter.ProductsPresenter
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val productsModule = module {
    factoryOf(::ProductsPresenter)
}