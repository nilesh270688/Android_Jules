package com.example.my_jules_test_app.ui.components

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.my_jules_test_app.data.model.Product
import com.example.my_jules_test_app.ui.viewmodel.CartViewModel

@Composable
fun ProductList(
    products: List<Product>,
    onItemClick: (Product) -> Unit,
    cartViewModel: CartViewModel = viewModel()
) {
    val cartItems by cartViewModel.cartItems.collectAsState()

    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
        items(products) { product ->
            ProductListItem(
                product = product,
                quantity = cartItems[product.id] ?: 0,
                onQuantityChange = { quantity ->
                    if (quantity > (cartItems[product.id] ?: 0)) {
                        cartViewModel.addToCart(product.id)
                    } else {
                        cartViewModel.removeFromCart(product.id)
                    }
                },
                onItemClick = { onItemClick(product) }
            )
        }
    }
}
