package com.example.cardstation

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth

class Signup : AppCompatActivity() {
    private lateinit var emailTextView: EditText
    private lateinit var passwordTextView: EditText
    private lateinit var btnRegister: Button
    private lateinit var progressbar: ProgressBar
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        FirebaseApp.initializeApp(applicationContext)
        mAuth = FirebaseAuth.getInstance()

        emailTextView = findViewById(R.id.email)
        passwordTextView = findViewById(R.id.passwd)
        btnRegister = findViewById(R.id.btnregister)
        progressbar = findViewById(R.id.progressbar)

        btnRegister.setOnClickListener {
            registerNewUser()
        }
    }

    private fun registerNewUser() {
        progressbar.visibility = View.VISIBLE

        val email = emailTextView.text.toString()
        val password = passwordTextView.text.toString()

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(applicationContext, "Please enter email!!", Toast.LENGTH_LONG).show()
            return
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(applicationContext, "Please enter password!!", Toast.LENGTH_LONG).show()
            return
        }

        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(applicationContext, "Registration successful!", Toast.LENGTH_LONG).show()
                    progressbar.visibility = View.GONE

                    val intent = Intent(this@Signup, LoginActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(
                        applicationContext, "Registration failed!! Please try again later",
                        Toast.LENGTH_LONG
                    ).show()
                    progressbar.visibility = View.GONE
                }
            }
    }
}