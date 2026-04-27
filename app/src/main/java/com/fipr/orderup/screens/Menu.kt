package com.fipr.orderup.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.fipr.orderup.dummy.menu
import com.fipr.orderup.model.Product
import com.fipr.orderup.screens.components.AppScaffold

@Composable
fun ProductMenu(
    modifier: Modifier,
    carrito: List<Product>,
    onProductClick: (producto: Product) -> Unit,
    onCheckOrder: () -> Unit
) {

    AppScaffold(
        modifier = Modifier,
        title = "Menú"
    ) { innerPadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                items(menu) { product ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { onProductClick(product) },
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        // Nombre, precio, imagen
                        Row(
                            modifier = Modifier
                                .padding(16.dp)
                        ) {
                            AsyncImage(
                                model = product.imagenUrl,
                                contentDescription = "Imagen de porducto",
                                modifier = Modifier
                                    .size(width = 80.dp, height = 120.dp)
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(8.dp)),
                                contentScale = ContentScale.Crop
                            )

                            Text(
                                text = product.nombre,
                                style = MaterialTheme.typography.bodySmall
                            )
                            Text(
                                text = "${product.precio}",
                                style = MaterialTheme.typography.bodySmall
                            )
                        }
                    }
                }
            }

            Button(
                onClick = { onCheckOrder() },
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Ver carrito",
                    style = MaterialTheme.typography.bodyMedium
                )

            }

        }

    }
}