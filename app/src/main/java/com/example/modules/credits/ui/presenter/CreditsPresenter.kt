package com.example.modules.credits.ui.presenter

import com.example.modules.credits.ui.CreditUiModel
import com.example.modules.credits.ui.view.CreditsView
import com.example.modules.products.domain.OfferType
import moxy.MvpPresenter
import java.math.BigDecimal

class CreditsPresenter(
    private val offerType: OfferType,
) : MvpPresenter<CreditsView>() {

    override fun onFirstViewAttach() {
        viewState.showCredits(
            // just for demo
            List(10) {
                val id = it + 1
                CreditUiModel(
                    id = id.toLong(),
                    name = offerType.name,
                    rate = BigDecimal(id),
                )
            }
        )
    }
}
