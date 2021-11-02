package com.rmakiyama.bokuju.remote.suzuri

import com.rmakiyama.bokuju.model.Product

interface SuzuriApi {
    suspend fun getProductList(): List<Product>
}
