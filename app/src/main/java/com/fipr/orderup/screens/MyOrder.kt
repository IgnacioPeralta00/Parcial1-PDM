package com.fipr.orderup.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fipr.orderup.model.Product
import com.fipr.orderup.screens.components.AppScaffold

@Composable
fun OrderResult(
    modifier : Modifier,
    shoppingCart: List<Product>) {

    shoppingCart[0]

    AppScaffold(
        modifier = Modifier,
        title = "Carrito"
    ) { innerPadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Text(
                text = ""
            )

        }
    }




}