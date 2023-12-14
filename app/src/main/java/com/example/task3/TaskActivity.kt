package com.example.task3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.core.widget.addTextChangedListener

class TaskActivity : AppCompatActivity() {
    private lateinit var resultButton: Button
    private lateinit var volumeEditText: EditText
    private lateinit var quantityEditText: EditText
    private lateinit var priceEditText: EditText
    private lateinit var totalPriceTextView: TextView
    private val resultCode = ResultCode()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task)

        resultButton = findViewById(R.id.resultButton)
        volumeEditText = findViewById(R.id.ingredient_volume)
        quantityEditText = findViewById(R.id.ingredient_quantity)
        priceEditText = findViewById(R.id.ingredient_price)
        totalPriceTextView = findViewById(R.id.total_price)


        resultButton.setOnClickListener {
            var ingredient = Ingredient()

            ingredient.volume = volumeEditText.text.toString().toDoubleOrNull()?: 0.0;
            ingredient.quantity = quantityEditText.text.toString().toDoubleOrNull()?: 0.0;
            ingredient.price = priceEditText.text.toString().toDoubleOrNull()?: 0.0;

            val totalPrice = ingredient.getTotalPrice()
            val answer = Intent()
            answer.putExtra("totalPrice", totalPrice)
            val code = if (totalPrice == 0.0) ResultCode.NO_RESULT else ResultCode.RESULT_OK
            setResult(code, answer)
            finish()
        }

    }
}