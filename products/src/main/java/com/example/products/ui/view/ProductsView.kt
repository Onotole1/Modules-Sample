package com.example.products.ui.view

import com.example.products.ui.ProductUiModel
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEnd

internal interface ProductsView : MvpView {
    @AddToEnd
    fun showProducts(products: List<ProductUiModel>)
}
