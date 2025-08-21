package com.example.my_jules_test_app

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.my_jules_test_app.ui.navigation.BottomNavigationBar
import com.example.my_jules_test_app.ui.screen.CartScreen
import com.example.my_jules_test_app.ui.screen.DashboardScreen
import com.example.my_jules_test_app.ui.screen.ProductDetailScreen
import com.example.my_jules_test_app.ui.screen.SplashScreen
import com.example.my_jules_test_app.ui.viewmodel.CartViewModel

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val cartViewModel: CartViewModel = viewModel()

    Scaffold(
        bottomBar = { BottomNavigationBar(navController = navController) }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = "splash",
            modifier = Modifier.padding(paddingValues)
        ) {
            composable("splash") {
                SplashScreen(navController = navController)
            }
            composable("dashboard") {
                DashboardScreen(navController = navController, cartViewModel = cartViewModel)
            }
            composable(
                route = "productDetail/{productId}",
                arguments = listOf(navArgument("productId") { type = NavType.StringType })
            ) {
                ProductDetailScreen(navController = navController)
            }
            composable("cart") {
                CartScreen(navController = navController, cartViewModel = cartViewModel)
            }
        }
    }
}
