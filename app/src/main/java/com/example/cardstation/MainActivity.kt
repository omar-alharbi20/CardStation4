package com.example.cardstation

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var username: TextView
    private lateinit var password: TextView
    private lateinit var loginBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        username = findViewById(R.id.user)
        password = findViewById(R.id.Pass)
        loginBtn = findViewById(R.id.loginbtn)

        loginBtn.setOnClickListener {
            if (username.text.toString() == "admin" && password.text.toString() == "admin") {
                Toast.makeText(this@MainActivity, "LOGIN SUCCESSFUL", Toast.LENGTH_SHORT).show()
                Handler().postDelayed({
                    val intent = Intent(this@MainActivity, MainActivity2::class.java)
                    startActivity(intent)
                }, 2000)
            } else {
                Toast.makeText(this@MainActivity, "LOGIN FAILED!!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}