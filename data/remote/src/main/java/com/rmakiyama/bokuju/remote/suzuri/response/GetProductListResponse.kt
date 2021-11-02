package com.rmakiyama.bokuju.remote.suzuri.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GetProductListResponse(
    @SerialName("products")
    val products: List<ProductResponse>,
)

@Serializable
data class ProductResponse(
    @SerialName("id")
    val id: Int,
    @SerialName("title")
    val title: String,
    @SerialName("imageUrl")
    val imageUrl: String,
    @SerialName("sampleImageUrl")
    val sampleImageUrl: String,
    @SerialName("sampleImageUrls")
    val sampleImageUrls: List<String>,
    @SerialName("sampleUrl")
    val suzuriUrl: String,
    @SerialName("priceWithTax")
    val priceWithTax: Int,
)
