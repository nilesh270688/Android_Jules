package com.example.my_jules_test_app.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.my_jules_test_app.data.SampleData
import com.example.my_jules_test_app.data.model.Product
import com.example.my_jules_test_app.data.model.ProductType
import kotlinx.coroutines.flow.*

class DashboardViewModel : ViewModel() {

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery

    private val _selectedCategory = MutableStateFlow("All")
    val selectedCategory: StateFlow<String> = _selectedCategory

    val products: StateFlow<List<Product>> =
        combine(
            _searchQuery,
            _selectedCategory
        ) { query, category ->
            SampleData.products.filter { product ->
                val matchesCategory = when (category) {
                    "Vegetables" -> product.type == ProductType.VEGETABLE
                    "Fruits" -> product.type == ProductType.FRUIT
                    else -> true
                }
                val matchesSearch = product.name.contains(query, ignoreCase = true)
                matchesCategory && matchesSearch
            }
        }.stateIn(viewModelScope, SharingStarted.Lazily, SampleData.products)

    fun onSearchQueryChange(query: String) {
        _searchQuery.value = query
    }

    fun onCategorySelected(category: String) {
        _selectedCategory.value = category
    }
}
