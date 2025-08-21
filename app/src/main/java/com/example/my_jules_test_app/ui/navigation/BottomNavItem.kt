package com.example.my_jules_test_app.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(val route: String, val icon: ImageVector, val title: String) {
    object Home : BottomNavItem("dashboard", Icons.Default.Home, "Home")
    object Cart : BottomNavItem("cart", Icons.Default.ShoppingCart, "Cart")
}
