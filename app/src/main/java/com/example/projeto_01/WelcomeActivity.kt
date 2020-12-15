package com.example.projeto_01

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        //actionbar
        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = "Bem-Vindo"

        val btnSignup = findViewById<Button>(R.id.btn_signup)
        val btnLogin = findViewById<Button>(R.id.btn_login)


        btnSignup.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)

        }

        btnLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)

        }
    }

}