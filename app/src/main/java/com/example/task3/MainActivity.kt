package com.example.task3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    private lateinit var switchButton: Button
    private lateinit var resultOut: TextView
    private lateinit var emojiOut: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        switchButton = findViewById(R.id.switchButton)
        resultOut = findViewById(R.id.result)
        emojiOut = findViewById(R.id.emoji)

        var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {result ->
            if (result.resultCode == ResultCode.RESULT_OK) {
                val data: Intent? = result.data
                resultOut.text = data?.extras?.getString("totalPrice")
                emojiOut.text = resources.getString(R.string.emojiCake)

            } else if (result.resultCode == ResultCode.NO_RESULT) {
                resultOut.text = resources.getString(R.string.noResult)
                emojiOut.text = resources.getString(R.string.emojiBone)

            }
        }

        val intent = Intent(this@MainActivity, TaskActivity::class.java)


        switchButton.setOnClickListener {
            resultLauncher.launch(intent);
        }
    }
}