package com.example.products.ui

import com.example.credits.core.domain.OfferType

internal data class ProductUiModel(
    val id: Long,
    val name: String,
    val type: OfferType,
)
