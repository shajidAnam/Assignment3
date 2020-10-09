package com.example.assignment3.sharedPreferences

import android.content.Context
import android.content.SharedPreferences

class sharedPreferencesImplement(context: Context) :sharedPreference {

    private val sharedPreferences = context.getSharedPreferences("sharedPreferences", Context.MODE_PRIVATE)
    private val editor = sharedPreferences.edit()

    override fun getString(key: String): String? {
        return sharedPreferences.getString(key,"")
    }

    override fun setString(key: String, value: String) {
        editor.putString(key, value)
        editor.apply()
    }

    override fun getInt(key: String): Int? {
        return sharedPreferences.getInt(key,-1)
    }

    override fun setInt(key: String, value: Int) {
        editor.putInt(key, value)
        editor.apply()
    }

    override fun getBoolean(key: String): Boolean? {
       return sharedPreferences.getBoolean(key,false)
    }

    override fun setBoolean(key: String, value: Boolean) {
        editor.putBoolean(key, value)
        editor.apply()
    }

    override fun getFloat(key: String): Float? {
        return sharedPreferences.getFloat(key, -0.1F)
    }


    override fun setFloat(key: String, value: Float) {
        editor.putFloat(key, value)
        editor.apply()
    }
}