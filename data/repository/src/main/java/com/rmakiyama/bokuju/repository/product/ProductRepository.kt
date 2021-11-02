package com.rmakiyama.bokuju.repository.product

import com.rmakiyama.bokuju.data.access.ProductRepository as IProductRepository
import com.rmakiyama.bokuju.model.Product
import com.rmakiyama.bokuju.remote.suzuri.SuzuriApi
import javax.inject.Inject

internal class ProductRepository @Inject constructor(
    private val suzuriApi: SuzuriApi,
) : IProductRepository {
    override suspend fun getProductList(): List<Product> {
        return suzuriApi.getProductList()
    }
}
