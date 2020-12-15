package com.example.projeto_01

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.projeto_01.utils.SharedPrefUtils

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash__screen)

        SharedPrefUtils.init(this)

        startup()
    }

    private fun startup() {
        Handler(Looper.getMainLooper()).postDelayed({

            val isLogged = SharedPrefUtils.getBool("ISLOGGED")

            if(isLogged){
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish()
            } else{
                val intent = Intent(this, WelcomeActivity::class.java)
                startActivity(intent)
                finish()
            }

        }, 3000)


    }

}