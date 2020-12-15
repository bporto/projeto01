package com.example.projeto_01

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.projeto_01.utils.SharedPrefUtils

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //actionbar
        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = "Login"
        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)

        val edtEmail = findViewById<EditText>(R.id.edt_login_email)
        val edtPassword = findViewById<EditText>(R.id.edt_Login_password)
        val btnToLogin = findViewById<Button>(R.id.btn_toLogin)

        btnToLogin.setOnClickListener {
            val storedEmail = SharedPrefUtils.getString("EMAIL")
            val storedPassword = SharedPrefUtils.getString("PASSWORD")

            if (edtEmail.text.toString() == storedEmail && edtPassword.text.toString() == storedPassword) {

                SharedPrefUtils.putBoolean("ISLOGGED", true)

                Toast.makeText(this, "Seja Bem-Vindo!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish()

            } else {
                Toast.makeText(this, "Login ou senha inválidos", Toast.LENGTH_LONG).show()
            }
        }


    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}