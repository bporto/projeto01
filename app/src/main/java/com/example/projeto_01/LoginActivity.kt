package com.example.projeto_01

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val edtEmail = findViewById<EditText>(R.id.edt_login_email)
        val edtPassword = findViewById<EditText>(R.id.edt_Login_password)
        val btnToSignup = findViewById<Button>(R.id.btn_toLogin)

        val prefs = getSharedPreferences("Projeto01", Context.MODE_PRIVATE)


        btnToSignup.setOnClickListener {
            val storedEmail = prefs.getString("EMAIL", "null")
            val storedPassword = prefs.getString("PASSWORD", "null")

            if (edtEmail.text.toString() == storedEmail && edtPassword.text.toString() == storedPassword) {
                val login = prefs.edit().putBoolean("ISLOGGED", true)
                login.apply()
                Toast.makeText(this, "Seja Bem-Vindo!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish()

            } else {
                Toast.makeText(this, "Login ou senha inválidos", Toast.LENGTH_LONG).show()
            }
        }


    }
}