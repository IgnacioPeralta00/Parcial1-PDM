package com.fipr.orderup.routes

import androidx.navigation3.runtime.NavKey
import com.fipr.orderup.model.Product
import kotlinx.serialization.Serializable

sealed class Routes : NavKey {

    @Serializable
    data object Menu: Routes()

    data class MyOrder(val list: List<Product>) : Routes()


}