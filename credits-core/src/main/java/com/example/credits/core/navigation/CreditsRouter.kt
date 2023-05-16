package com.example.credits.core.navigation

import com.example.credits.core.domain.OfferType

interface CreditsRouter {
    fun navigateToOffer(offerType: OfferType)
}
