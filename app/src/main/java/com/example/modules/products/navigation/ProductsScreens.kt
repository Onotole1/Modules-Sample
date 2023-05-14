package com.example.modules.products.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.modules.products.ui.view.ProductsFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object ProductsScreens {

    object ProductsList : FragmentScreen {
        override fun createFragment(factory: FragmentFactory): Fragment =
            ProductsFragment.newInstance()
    }
}
