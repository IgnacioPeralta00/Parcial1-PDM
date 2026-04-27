package com.fipr.orderup.model

data class Product(
    val id: Int,
    val nombre: String,
    val precio: Double,
    val imagenUrl: String,
    val tipo: TipoProducto
)

enum class TipoProducto {
    PUPUSA,
    BEBIDA
}