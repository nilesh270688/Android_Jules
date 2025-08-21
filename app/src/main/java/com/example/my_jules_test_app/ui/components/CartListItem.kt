package com.example.my_jules_test_app.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.my_jules_test_app.data.model.Product

@Composable
fun CartListItem(
    product: Product,
    quantity: Int
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = product.name, modifier = Modifier.weight(1f))
            Text(text = "Qty: $quantity")
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = "₹${product.price * quantity}")
        }
    }
}
