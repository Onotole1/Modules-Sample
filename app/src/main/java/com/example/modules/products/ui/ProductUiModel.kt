package com.example.modules.products.ui

import com.example.modules.products.domain.OfferType

data class ProductUiModel(
    val id: Long,
    val name: String,
    val type: OfferType,
)
