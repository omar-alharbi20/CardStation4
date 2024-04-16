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
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.FirebaseApp

class LoginActivity : AppCompatActivity() {
    private lateinit var emailTextView: EditText
    private lateinit var passwordTextView: EditText
    private lateinit var btnLogin: Button
    private lateinit var progressbar: ProgressBar
    private lateinit var mAuth: FirebaseAuth
    private lateinit var btnSignUp: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        FirebaseApp.initializeApp(applicationContext)
        mAuth = FirebaseAuth.getInstance()

        emailTextView = findViewById(R.id.email)
        passwordTextView = findViewById(R.id.password)
        btnLogin = findViewById(R.id.login)
        progressbar = findViewById(R.id.progressBar)
        btnSignUp = findViewById(R.id.signup) // تعديل الهوية إلى "signup"

        btnLogin.setOnClickListener {
            loginUserAccount()
        }

        btnSignUp.setOnClickListener {
            val intent = Intent(this@LoginActivity, Signup::class.java)
            startActivity(intent)
        }
    }

    private fun loginUserAccount() {
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

        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(applicationContext, "Login successful!!", Toast.LENGTH_LONG).show()
                    progressbar.visibility = View.GONE

                    val intent = Intent(this@LoginActivity, MainActivity2::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(applicationContext, "Login failed!! Please try again later", Toast.LENGTH_LONG).show()
                    progressbar.visibility = View.GONE
                }
            }
    }
}