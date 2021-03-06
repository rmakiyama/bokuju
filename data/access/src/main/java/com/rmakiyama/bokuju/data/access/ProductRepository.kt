package com.rmakiyama.bokuju.data.access

import com.rmakiyama.bokuju.model.Product

interface ProductRepository {
    suspend fun getProductList(): List<Product>
}
