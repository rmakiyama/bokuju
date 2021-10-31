package com.rmakiyama.bokuju.usecase.product

import com.rmakiyama.bokuju.data.access.ProductRepository
import com.rmakiyama.bokuju.model.Product
import com.rmakiyama.bokuju.usecase.OneShotUseCase
import javax.inject.Inject

class GetProductList @Inject constructor(
    private val repository: ProductRepository,
) : OneShotUseCase<Unit, List<Product>>() {
    override suspend fun execute(params: Unit): List<Product> {
        return repository.getProductList()
    }
}
