package com.example.my_jules_test_app.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(val route: String, val icon: ImageVector, val title: String) {
    object Home : BottomNavItem("dashboard", Icons.Default.Home, "Home")
    object Categories : BottomNavItem("categories", Icons.Default.Category, "Categories")
    object FreshDeal : BottomNavItem("fresh_deal", Icons.Default.LocalOffer, "Fresh Deal")
    object Wallet : BottomNavItem("wallet", Icons.Default.AccountBalanceWallet, "Wallet")
    object Cart : BottomNavItem("cart", Icons.Default.ShoppingCart, "Cart")
}
