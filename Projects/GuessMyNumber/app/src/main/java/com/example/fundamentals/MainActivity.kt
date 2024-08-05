package com.example.fundamentals

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {

    // Global variables are defined here:
    lateinit var tvMain: TextView
    lateinit var etExample: EditText
    lateinit var btnExample: Button
    val randomNumber = (0..10).random()
    var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // First we are going to find all the elements we need:
        val tvMain = findViewById<TextView>(R.id.tvMain)
        val etExample = findViewById<EditText>(R.id.etExample)
        val btnExample = findViewById<Button>(R.id.btnExample)

        // Button is found and we set the onClickListener:
        btnExample.setOnClickListener {
            counter++
            if (etExample.text.toString().isEmpty()) {
                Toast.makeText(this, "Please enter a number", Toast.LENGTH_SHORT).show()
            } else {
                if (etExample.text.toString().toInt() == randomNumber) {

                    // Here we are going to use "Intent" to open a new activity:
                    val intent = Intent(this, WinActivity::class.java)
                    intent.putExtra("msg", "You guessed the number with $counter tries!")

                    // Always remember to start the activity:
                    startActivity(intent)
                } else if (etExample.text.toString().toInt() > randomNumber) {
                    Toast.makeText(this, "Try a lower number", Toast.LENGTH_SHORT).show()
                    tvMain.text = "Counter tries: $counter"
                } else {
                    Toast.makeText(this, "Try a higher number", Toast.LENGTH_SHORT).show()
                    tvMain.text = "Counter tries: $counter"
                }
            }
        }

    }

    // Now we are going to add some activity running code:
    override fun onPause() {
        super.onPause()
        Toast.makeText(this, "The app is paused", Toast.LENGTH_SHORT).show()
    }
    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "The app is resumed", Toast.LENGTH_SHORT).show()
    }

    // Important fact, we only can use activity lifecycle methods outside of the onCreate method.
}