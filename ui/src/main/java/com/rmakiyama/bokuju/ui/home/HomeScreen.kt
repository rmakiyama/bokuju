package com.rmakiyama.bokuju.ui.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.insets.statusBarsPadding
import com.rmakiyama.bokuju.model.Product
import com.rmakiyama.bokuju.model.ProductId

@Composable
fun HomeScreen() {
    val viewModel: HomeViewModel = hiltViewModel()
    val productList by viewModel.productList.collectAsState()

    HomeScreen(productList)
}

@Composable
fun HomeScreen(
    productList: List<Product>,
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        ProductList(productList)
    }
}

@Composable
fun ProductList(
    productList: List<Product>,
) {
    LazyColumn(
        modifier = Modifier.statusBarsPadding(),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(productList, key = { product -> product.id }) { product ->
            ProductListItem(product)
        }
    }
}

@Composable
fun ProductListItem(
    product: Product,
) {
    Text(text = product.title)
}

@Preview
@Composable
fun PreviewHomeScreen() {
    val list = listOf(
        Product(ProductId(0), "title", "", emptyList(), 100)
    )
    HomeScreen(list)
}
