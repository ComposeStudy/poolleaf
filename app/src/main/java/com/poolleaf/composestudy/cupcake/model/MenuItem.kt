package com.poolleaf.composestudy.cupcake.model // ktlint-disable filename

sealed class MenuItem(
    open val name: String,
    open val description: String,
    open val price: Double
) {
    data class AccompanimentItem(
        override val name: String,
        override val description: String,
        override val price: Double
    ) : MenuItem(name, description, price)

    data class EntreeItem(
        override val name: String,
        override val description: String,
        override val price: Double
    ) : MenuItem(name, description, price)

    data class SideDishItem(
        override val name: String,
        override val description: String,
        override val price: Double
    ) : MenuItem(name, description, price)
}
