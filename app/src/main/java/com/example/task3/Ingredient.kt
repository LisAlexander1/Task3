package com.example.task3

class Ingredient(
    name: String,
    price: Double?,
    volume: Double?,
    quantity: Double?
) {


    var name: String = ""

    var price: Double? = null

    var volume: Double? = null

    var quantity: Double? = null


    init {
        this.name = name
        this.price = price
        this.volume = volume
        this.quantity = quantity
    }

    fun getTotalPrice(): Double {
        if (volume ?: 0.0 == 0.0)
            return 0.0

        return price ?: 0 / volume!! * (quantity ?: 0.0)
    }

}