package com.example.my_jules_test_app.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.my_jules_test_app.data.SampleData
import com.example.my_jules_test_app.ui.viewmodel.CartViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartScreen(
    navController: NavController,
    cartViewModel: CartViewModel = viewModel()
) {
    val cartItems by cartViewModel.cartItems.collectAsState()
    val products = SampleData.products

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "My Cart") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { paddingValues ->
        if (cartItems.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Your cart is empty")
            }
        } else {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                LazyColumn(modifier = Modifier.weight(1f)) {
                    items(cartItems.keys.toList()) { productId ->
                        val product = products.find { it.id == productId }
                        val quantity = cartItems[productId] ?: 0
                        if (product != null) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(text = product.name, modifier = Modifier.weight(1f))
                                Text(text = "Qty: $quantity")
                                Spacer(modifier = Modifier.width(16.dp))
                                Text(text = "$${product.price * quantity}")
                            }
                        }
                    }
                }
                val totalPrice = cartItems.entries.sumOf { (productId, quantity) ->
                    val product = products.find { it.id == productId }
                    (product?.price ?: 0.0) * quantity
                }
                Text(
                    text = "Total: $${totalPrice}",
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier
                        .align(Alignment.End)
                        .padding(16.dp)
                )
            }
        }
    }
}
