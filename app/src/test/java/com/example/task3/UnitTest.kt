package com.example.task3

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class UnitTest {
    @Test
    fun getTotalPrice_correctly() {
        val ingredient = Ingredient()
        ingredient.name = ""
        ingredient.price = 100.0
        ingredient.volume = 50.0
        ingredient.quantity = 200.0
        assertEquals(400.0, ingredient.getTotalPrice(),0.01)
    }
}