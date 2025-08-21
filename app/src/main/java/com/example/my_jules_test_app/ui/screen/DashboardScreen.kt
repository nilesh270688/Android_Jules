package com.example.my_jules_test_app.ui.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.my_jules_test_app.data.model.ProductType
import com.example.my_jules_test_app.ui.components.CartIcon
import com.example.my_jules_test_app.ui.components.ProductList
import com.example.my_jules_test_app.ui.viewmodel.CartViewModel
import com.example.my_jules_test_app.ui.viewmodel.DashboardViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(
    navController: NavController,
    dashboardViewModel: DashboardViewModel = viewModel(),
    cartViewModel: CartViewModel = viewModel()
) {
    val pagerState = rememberPagerState(pageCount = { 2 })
    val scope = rememberCoroutineScope()
    val tabTitles = listOf("Vegetables", "Fruits")
    val products by dashboardViewModel.products.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Vegetable Glossary") },
                actions = {
                    CartIcon(cartViewModel = cartViewModel) {
                        navController.navigate("cart")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            TabRow(selectedTabIndex = pagerState.currentPage) {
                tabTitles.forEachIndexed { index, title ->
                    Tab(
                        selected = pagerState.currentPage == index,
                        onClick = {
                            scope.launch {
                                pagerState.animateScrollToPage(index)
                            }
                        },
                        text = { Text(text = title) }
                    )
                }
            }

            HorizontalPager(state = pagerState) { page ->
                when (page) {
                    0 -> {
                        ProductList(
                            products = products.filter { it.type == ProductType.VEGETABLE },
                            onItemClick = { product ->
                                navController.navigate("productDetail/${product.id}")
                            },
                            cartViewModel = cartViewModel
                        )
                    }
                    1 -> {
                        ProductList(
                            products = products.filter { it.type == ProductType.FRUIT },
                            onItemClick = { product ->
                                navController.navigate("productDetail/${product.id}")
                            },
                            cartViewModel = cartViewModel
                        )
                    }
                }
            }
        }
    }
}
