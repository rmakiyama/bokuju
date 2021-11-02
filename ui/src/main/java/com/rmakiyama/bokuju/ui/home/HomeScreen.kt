package com.rmakiyama.bokuju.ui.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.insets.LocalWindowInsets
import com.google.accompanist.insets.rememberInsetsPaddingValues
import com.rmakiyama.bokuju.model.Product
import com.rmakiyama.bokuju.model.ProductId
import com.rmakiyama.bokuju.ui.component.NetworkImage

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

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProductList(
    productList: List<Product>,
) {
    LazyVerticalGrid(
        modifier = Modifier.padding(horizontal = 16.dp),
        contentPadding = rememberInsetsPaddingValues(
            insets = LocalWindowInsets.current.systemBars,
        ),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        cells = GridCells.Adaptive(minSize = 112.dp),
    ) {
        items(productList) { product ->
            ProductListItem(product)
        }
    }
}

@Composable
fun ProductListItem(
    product: Product,
) {
    Column {
        NetworkImage(
            url = product.imageUrl,
            modifier = Modifier
                .fillMaxSize()
                .aspectRatio(1f)
                .clip(RoundedCornerShape(12.dp)),
            contentDescription = product.title,
        )
        Text(
            text = product.title,
            style = MaterialTheme.typography.labelMedium,
        )
    }
}

@Preview
@Composable
fun PreviewHomeScreen() {
    val list = listOf(
        Product(ProductId(0), "title", "", emptyList(), 100)
    )
    HomeScreen(list)
}
