package com.example.modules.credits.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.modules.credits.ui.view.CreditsFragment
import com.example.modules.products.domain.OfferType
import com.github.terrakok.cicerone.androidx.FragmentScreen

object CreditsScreens {

    data class CreditsList(val offerType: OfferType) : FragmentScreen {
        override fun createFragment(factory: FragmentFactory): Fragment =
            CreditsFragment.newInstance(offerType)
    }
}
