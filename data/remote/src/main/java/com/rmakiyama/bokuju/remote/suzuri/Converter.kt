package com.rmakiyama.bokuju.remote.suzuri

import com.rmakiyama.bokuju.model.Product
import com.rmakiyama.bokuju.model.ProductId
import com.rmakiyama.bokuju.remote.suzuri.response.GetProductListResponse

internal fun GetProductListResponse.convert(): List<Product> {
    return products.map { product ->
        Product(
            id = ProductId(product.id),
            title = product.title,
            imageUrl = product.sampleImageUrl,
            imageUrls = product.sampleImageUrls,
            priceWithTax = product.priceWithTax,
        )
    }
}
