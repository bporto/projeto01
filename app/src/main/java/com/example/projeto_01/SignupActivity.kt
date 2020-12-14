package com.example.projeto_01

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class SignupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        val prefs = getSharedPreferences("Projeto01", Context.MODE_PRIVATE)
        val edtName = findViewById<EditText>(R.id.edt_name)
        val edtEmail = findViewById<EditText>(R.id.edt_email)
        val edtPassword = findViewById<EditText>(R.id.edt_password)
        val edtConfirmPassword = findViewById<EditText>(R.id.edt_confirmPassword)
        val btnToSignup = findViewById<Button>(R.id.btn_toSignup)

        btnToSignup.setOnClickListener {
            if (edtName.text.isEmpty()) {
                edtName.setError("Campo obrigatório")
            } else if (edtEmail.text.isEmpty()) {
                edtEmail.setError("Campo obrigatório")
            } else if (edtPassword.text.isEmpty()) {
                edtPassword.setError("Campo obrigatório")
            } else if (edtPassword.length() < 6) {
                edtPassword.setError("Mínimo de 6 caracteres")
            } else if (edtConfirmPassword.text.toString().trim() != edtPassword.text.toString()
                    .trim()
            ) {
                edtConfirmPassword.setError("As senhas não conferem")
            } else {
                val name = edtName.text.toString().trim()
                val email = edtEmail.text.toString().trim()
                val password = edtPassword.text.toString().trim()

                val signup = prefs.edit()
                signup.putString("NAME", name)
                signup.putString("EMAIL", email)
                signup.putString("PASSWORD", password)
                signup.putBoolean("ISLOGGED", false)
                signup.apply()

                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}

