package com.example.modules.credits.ui.view

import com.example.modules.credits.ui.CreditUiModel
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEnd

interface CreditsView : MvpView {
    @AddToEnd
    fun showCredits(credits: List<CreditUiModel>)
}
