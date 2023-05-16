package com.example.products.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.products.ui.view.ProductsFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

internal object ProductsScreens {

    object ProductsList : FragmentScreen {
        override fun createFragment(factory: FragmentFactory): Fragment =
            ProductsFragment.newInstance()
    }
}
