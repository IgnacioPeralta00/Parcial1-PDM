package com.fipr.orderup

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.fipr.orderup.model.Product
import com.fipr.orderup.routes.Routes
import com.fipr.orderup.screens.OrderResult
import com.fipr.orderup.screens.ProductMenu

@Composable
fun MainNavigator(modifier: Modifier = Modifier) {

    val backStack = rememberNavBackStack(Routes.Menu)
    val shoppingCart = remember { mutableListOf<Product>()}

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {
            entry<Routes.Menu> {
                ProductMenu(
                    modifier = modifier,
                    carrito = shoppingCart,
                    onProductClick = { product -> shoppingCart.add(product) },
                    onCheckOrder = { backStack.add(Routes.MyOrder(shoppingCart)) }
                )
            }
            entry<Routes.MyOrder> { productList ->
                OrderResult(
                    modifier = Modifier,
                    productList.list
                )
            }
        }
    )
}