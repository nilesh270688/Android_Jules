package com.example.my_jules_test_app.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.my_jules_test_app.ui.viewmodel.CartViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartIcon(
    cartViewModel: CartViewModel = viewModel(),
    onCartClick: () -> Unit
) {
    val totalItemCount by cartViewModel.totalItemCount.collectAsState()

    IconButton(onClick = { onCartClick() }) {
        BadgedBox(
            badge = {
                if (totalItemCount > 0) {
                    Badge { Text(text = totalItemCount.toString()) }
                }
            }
        ) {
            Icon(
                imageVector = Icons.Default.ShoppingCart,
                contentDescription = "Shopping Cart"
            )
        }
    }
}
