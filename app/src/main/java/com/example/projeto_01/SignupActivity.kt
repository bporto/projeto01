package com.example.projeto_01

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.projeto_01.utils.SharedPrefUtils

class SignupActivity : AppCompatActivity() {


    lateinit var edtName: EditText
    lateinit var edtEmail: EditText
    lateinit var edtPassword: EditText
    lateinit var edtConfirmPassword: EditText
    lateinit var btnToSignup: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        //actionbar
        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = "Cadastre-se"
        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)





        SharedPrefUtils.init(this)

        edtName = findViewById<EditText>(R.id.edt_name)
        edtEmail = findViewById<EditText>(R.id.edt_email)
        edtPassword = findViewById<EditText>(R.id.edt_password)
        edtConfirmPassword = findViewById<EditText>(R.id.edt_confirmPassword)
        btnToSignup = findViewById<Button>(R.id.btn_toSignup)

        btnToSignup.setOnClickListener {
            if (edtName.text.isEmpty()) {
                edtName.error = "Campo obrigatório"
            } else if (edtEmail.text.isEmpty()) {
                edtEmail.error = "Campo obrigatório"
            } else if (edtPassword.text.isEmpty()) {
                edtPassword.error = "Campo obrigatório"
            } else if (edtPassword.length() < 6) {
                edtPassword.error = "Mínimo de 6 caracteres"
            } else if (edtConfirmPassword.text.toString().trim() != edtPassword.text.toString()
                    .trim()
            ) {
                edtConfirmPassword.error = "As senhas não conferem"
            } else {
                signup(
                    edtName.text.toString().trim(),
                    edtEmail.text.toString().trim(),
                    edtPassword.text.toString().trim()
                )
            }
        }
    }

    private fun signup(name: String, email: String, password: String) {

        SharedPrefUtils.putString("NAME", name)
        SharedPrefUtils.putString("EMAIL", email)
        SharedPrefUtils.putString("PASSWORD", password)
        SharedPrefUtils.putBoolean("ISLOGGED", false)

        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}

