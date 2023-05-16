package com.example.credits.navigation

import com.example.credits.core.domain.OfferType
import com.example.credits.core.navigation.CreditsRouter
import com.github.terrakok.cicerone.Router

internal class CreditsRouterImpl(private val router: Router) : CreditsRouter {

    override fun navigateToOffer(offerType: OfferType) {
        router.navigateTo(CreditsScreens.CreditsList(offerType))
    }
}
