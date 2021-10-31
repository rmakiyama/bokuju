package com.rmakiyama.infra.product

import com.rmakiyama.bokuju.data.access.ProductRepository as IProductRepository
import com.rmakiyama.bokuju.model.Product
import com.rmakiyama.bokuju.model.ProductId
import javax.inject.Inject

class ProductRepository @Inject constructor() : IProductRepository {
    override fun getProductList(): List<Product> {
        // fixme
        return listOf(
            Product(ProductId(1), "title 1"),
            Product(ProductId(2), "title 2"),
            Product(ProductId(3), "title 3"),
            Product(ProductId(4), "title 4"),
        )
    }
}
