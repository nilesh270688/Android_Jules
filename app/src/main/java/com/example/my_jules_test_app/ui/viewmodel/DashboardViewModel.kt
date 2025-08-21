package com.example.my_jules_test_app.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.my_jules_test_app.data.SampleData
import com.example.my_jules_test_app.data.model.Product
import com.example.my_jules_test_app.data.model.ProductType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class DashboardViewModel : ViewModel() {

    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products: StateFlow<List<Product>> = _products

    init {
        _products.value = SampleData.products
    }

    fun getProductsByType(type: ProductType): List<Product> {
        return _products.value.filter { it.type == type }
    }
}
