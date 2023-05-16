package com.example.products.ui.presenter

import com.example.credits.core.domain.OfferType
import com.example.credits.core.navigation.CreditsRouter
import com.example.products.ui.ProductUiModel
import com.example.products.ui.view.ProductsView
import moxy.MvpPresenter

internal class ProductsPresenter(
    private val creditsRouter: CreditsRouter,
) : MvpPresenter<ProductsView>() {

    override fun onFirstViewAttach() {
        viewState.showProducts(
            // just for demo
            listOf(
                ProductUiModel(1L, "Auto", OfferType.CREDIT_AUTO),
                ProductUiModel(2L, "Mortgage", OfferType.CREDIT_MORTGAGE),
                ProductUiModel(3L, "Other", OfferType.CREDIT_OTHER),
            )
        )
    }

    fun onOfferClicked(offerType: OfferType) {
        creditsRouter.navigateToOffer(offerType)
    }
}