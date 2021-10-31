package com.rmakiyama.bokuju.model

@JvmInline
value class ProductId(val id: Int)

data class Product(
    val id: ProductId,
    val title: String,
)
