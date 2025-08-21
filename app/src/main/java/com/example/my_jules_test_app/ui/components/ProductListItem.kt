package com.example.my_jules_test_app.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.my_jules_test_app.data.model.Product

@Composable
fun ProductListItem(
    product: Product,
    quantity: Int,
    onQuantityChange: (Int) -> Unit,
    onItemClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick() }
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = product.imageUrl,
            contentDescription = product.name,
            modifier = Modifier.size(64.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(text = product.name, style = androidx.compose.material3.MaterialTheme.typography.bodyLarge)
            Text(text = "$${product.price}", style = androidx.compose.material3.MaterialTheme.typography.bodyMedium)
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = { onQuantityChange(quantity - 1) }) {
                Icon(imageVector = Icons.Default.Remove, contentDescription = "Remove")
            }
            Text(text = quantity.toString())
            IconButton(onClick = { onQuantityChange(quantity + 1) }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
            }
        }
    }
}
