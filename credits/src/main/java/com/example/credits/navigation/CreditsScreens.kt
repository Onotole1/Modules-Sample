package com.example.credits.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.credits.ui.view.CreditsFragment
import com.example.credits.core.domain.OfferType
import com.github.terrakok.cicerone.androidx.FragmentScreen

internal object CreditsScreens {

    data class CreditsList(val offerType: OfferType) : FragmentScreen {
        override fun createFragment(factory: FragmentFactory): Fragment =
            CreditsFragment.newInstance(offerType)
    }
}
