package com.example.modules.products.ui.view

import com.example.modules.products.ui.ProductUiModel
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEnd

interface ProductsView : MvpView {
    @AddToEnd
    fun showProducts(products: List<ProductUiModel>)
}
