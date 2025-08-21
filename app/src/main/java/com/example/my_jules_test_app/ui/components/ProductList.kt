package com.example.my_jules_test_app.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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

    LazyColumn {
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
