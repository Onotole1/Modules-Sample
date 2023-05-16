package com.example.credits.ui.presenter

import com.example.credits.ui.CreditUiModel
import com.example.credits.ui.view.CreditsView
import com.example.credits.core.domain.OfferType
import moxy.MvpPresenter
import java.math.BigDecimal

internal class CreditsPresenter(
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
