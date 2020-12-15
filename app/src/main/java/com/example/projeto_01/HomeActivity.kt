package com.example.projeto_01

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {


    lateinit var edtName: EditText
    lateinit var edtEmail: EditText
    lateinit var btnExit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        //actionbar
        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = "Home"

        edtName = findViewById(R.id.edt_home_name)
        edtEmail = findViewById(R.id.edt_home_email)
        btnExit = findViewById(R.id.btn_exit)

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