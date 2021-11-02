package com.rmakiyama.bokuju.model

import java.io.Serializable

@JvmInline
value class ProductId(val id: Int) : Serializable

data class Product(
    val id: ProductId,
    val title: String,
    val imageUrl: String,
    val imageUrls: List<String>,
    val priceWithTax: Int,
)
