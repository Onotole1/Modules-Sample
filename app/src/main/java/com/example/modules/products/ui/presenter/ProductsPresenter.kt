package com.example.modules.products.ui.presenter

import com.example.modules.credits.navigation.CreditsScreens
import com.example.modules.products.domain.OfferType
import com.example.modules.products.ui.ProductUiModel
import com.example.modules.products.ui.view.ProductsView
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class ProductsPresenter(
    private val router: Router,
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
        router.navigateTo(CreditsScreens.CreditsList(offerType))
    }
}
