package com.example.projeto_01

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash__screen)

        startup()
    }

    private fun startup() {
        Handler(Looper.getMainLooper()).postDelayed({

            val prefs = getSharedPreferences("Projeto01", Context.MODE_PRIVATE)
            val isLogged = prefs.getBoolean("ISLOGGED", false)

            if(isLogged){
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish()
            } else{
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }

        }, 3000)


    }

}