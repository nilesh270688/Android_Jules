package com.example.my_jules_test_app.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.my_jules_test_app.ui.components.ProductList
import com.example.my_jules_test_app.ui.viewmodel.CartViewModel
import com.example.my_jules_test_app.ui.viewmodel.DashboardViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(
    navController: NavController,
    dashboardViewModel: DashboardViewModel = viewModel(),
    cartViewModel: CartViewModel = viewModel()
) {
    val products by dashboardViewModel.products.collectAsState()
    val searchQuery by dashboardViewModel.searchQuery.collectAsState()
    val selectedCategory by dashboardViewModel.selectedCategory.collectAsState()

    Column(modifier = Modifier.fillMaxSize()) {
        TextField(
            value = searchQuery,
            onValueChange = { dashboardViewModel.onSearchQueryChange(it) },
            label = { Text("Search") },
            leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = "Search") },
            trailingIcon = {
                IconButton(onClick = { /* TODO: Open filter dialog */ }) {
                    Icon(imageVector = Icons.Default.Tune, contentDescription = "Filter")
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            FilterChip(
                selected = selectedCategory == "All",
                onClick = { dashboardViewModel.onCategorySelected("All") },
                label = { Text("All") }
            )
            FilterChip(
                selected = selectedCategory == "Vegetables",
                onClick = { dashboardViewModel.onCategorySelected("Vegetables") },
                label = { Text("Vegetables") }
            )
            FilterChip(
                selected = selectedCategory == "Fruits",
                onClick = { dashboardViewModel.onCategorySelected("Fruits") },
                label = { Text("Fruits") }
            )
        }

        ProductList(
            products = products,
            onItemClick = { product ->
                navController.navigate("productDetail/${product.id}")
            },
            cartViewModel = cartViewModel
        )
    }
}
