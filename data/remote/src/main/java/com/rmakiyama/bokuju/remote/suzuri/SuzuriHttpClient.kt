package com.rmakiyama.bokuju.remote.suzuri

import com.rmakiyama.bokuju.model.Product
import com.rmakiyama.bokuju.remote.di.SuzuriHttpClient
import com.rmakiyama.bokuju.remote.suzuri.response.GetProductListResponse
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import javax.inject.Inject

internal class SuzuriHttpClient @Inject constructor(
    @SuzuriHttpClient private val httpClient: HttpClient,
) : SuzuriApi {

    override suspend fun getProductList(): List<Product> {
        return httpClient.get<GetProductListResponse>("$SUZURI_API_URL/products").convert()
    }

    companion object {
        const val SUZURI_API_URL = "https://suzuri.jp/api/v1"
    }
}
