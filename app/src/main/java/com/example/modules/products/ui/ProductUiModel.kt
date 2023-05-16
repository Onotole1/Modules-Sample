package com.example.modules.products.ui

import com.example.credits.core.domain.OfferType

data class ProductUiModel(
    val id: Long,
    val name: String,
    val type: OfferType,
)
