package com.example.task3

class Ingredient() {

    var name: String = ""

    var price: Double = 0.0

    var volume: Double = 0.0

    var quantity: Double = 0.0



    fun getTotalPrice(): Double {
        if (volume == 0.0)
            return 0.0

        return price / volume * quantity
    }

}