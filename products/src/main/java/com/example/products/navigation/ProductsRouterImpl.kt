package com.example.products.navigation

import com.example.products.core.navigation.ProductsRouter
import com.github.terrakok.cicerone.Router

internal class ProductsRouterImpl(private val router: Router) : ProductsRouter {
    override fun navigateToProducts() {
        router.replaceScreen(ProductsScreens.ProductsList)
    }
}
