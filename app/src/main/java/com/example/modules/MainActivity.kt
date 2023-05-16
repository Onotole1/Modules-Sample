package com.example.modules

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.products.core.navigation.ProductsRouter
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.androidx.AppNavigator
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val navigator = AppNavigator(this, R.id.container)
    private val navigatorHolder: NavigatorHolder by inject()
    private val productsRouter: ProductsRouter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            productsRouter.navigateToProducts()
        }
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }
}
