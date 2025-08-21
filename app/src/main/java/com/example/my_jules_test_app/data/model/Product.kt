package com.example.my_jules_test_app.data.model

data class Product(
    val id: Int,
    val name: String,
    val price: Double,
    val imageName: String,
    val benefits: String,
    val uses: String,
    val description: String,
    val type: ProductType
)

enum class ProductType {
    VEGETABLE,
    FRUIT
}
