package com.example.my_jules_test_app.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class CartViewModel : ViewModel() {

    private val _cartItems = MutableStateFlow<Map<Int, Int>>(emptyMap())
    val cartItems: StateFlow<Map<Int, Int>> = _cartItems.asStateFlow()

    val totalItemCount: StateFlow<Int> = _cartItems.map { it.values.sum() }
        .stateIn(viewModelScope, kotlinx.coroutines.flow.SharingStarted.Lazily, 0)

    fun addToCart(productId: Int) {
        val currentItems = _cartItems.value.toMutableMap()
        currentItems[productId] = (currentItems[productId] ?: 0) + 1
        _cartItems.value = currentItems
    }

    fun removeFromCart(productId: Int) {
        val currentItems = _cartItems.value.toMutableMap()
        val currentQuantity = currentItems[productId] ?: 0
        if (currentQuantity > 1) {
            currentItems[productId] = currentQuantity - 1
        } else {
            currentItems.remove(productId)
        }
        _cartItems.value = currentItems
    }

    fun getQuantity(productId: Int): Int {
        return _cartItems.value[productId] ?: 0
    }
}
