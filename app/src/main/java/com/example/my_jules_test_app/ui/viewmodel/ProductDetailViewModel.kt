package com.example.my_jules_test_app.ui.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.my_jules_test_app.data.SampleData
import com.example.my_jules_test_app.data.model.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ProductDetailViewModel(savedStateHandle: SavedStateHandle) : ViewModel() {

    private val _product = MutableStateFlow<Product?>(null)
    val product: StateFlow<Product?> = _product

    init {
        val productId = savedStateHandle.get<String>("productId")?.toIntOrNull()
        if (productId != null) {
            _product.value = SampleData.products.find { it.id == productId }
        }
    }
}
