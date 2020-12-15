package com.example.projeto_01.utils

import android.content.Context
import android.content.SharedPreferences


object SharedPrefUtils{
    private val NAME = "Projeto01"
    private val MODE = Context.MODE_PRIVATE
    private lateinit var preferences: SharedPreferences

    fun init(context: Context){
        preferences = context.getSharedPreferences(NAME, MODE)
    }

    fun getBool(key:String): Boolean {
        return preferences.getBoolean(key, false)
    }

    fun getString(key:String) : String? {
        return preferences.getString(key,"null")
    }

}