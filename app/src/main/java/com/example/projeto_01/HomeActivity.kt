package com.example.projeto_01

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val edtName = findViewById<EditText>(R.id.edt_home_name)
        val edtEmail = findViewById<EditText>(R.id.edt_home_email)
        val btnExit = findViewById<Button>(R.id.btn_exit)

        val prefs = getSharedPreferences("Projeto01", Context.MODE_PRIVATE)

        edtName.setText(prefs.getString("NAME", "null"))
        edtEmail.setText(prefs.getString("EMAIL", "null"))

        btnExit.setOnClickListener {
            val editor = prefs.edit()
            editor.putBoolean("ISLOGGED", false)
            editor.apply()

            val intent = Intent(this, WelcomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}