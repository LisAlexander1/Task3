package com.example.task3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class TaskActivity : AppCompatActivity() {
    private lateinit var resultButton: Button
    private val resultCode = ResultCode()
    private var totalPrice: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task)

        resultButton = findViewById(R.id.resultButton)




        resultButton.setOnClickListener {
            val answer = Intent().putExtra("totalPrice", 123)
            val code = if (totalPrice == 0.0) ResultCode.NO_RESULT else ResultCode.RESULT_OK
            setResult(code, answer)
            finish()
        }

    }
}