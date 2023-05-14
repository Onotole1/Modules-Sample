package com.example.modules

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.modules.products.navigation.ProductsScreens
import com.github.terrakok.cicerone.androidx.AppNavigator

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val navigator = AppNavigator(this, R.id.container)

    private val navigatorHolder = App.INSTANCE.navigatorHolder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            App.INSTANCE.router.replaceScreen(ProductsScreens.ProductsList)
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
