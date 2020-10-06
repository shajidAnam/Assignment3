package com.example.assignment3

import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor

class MyPreferences private constructor(context: Context) {

    var userName: String?
        get() = sharedPreferences.getString("USER_NAME", "Name not found")
        set(userName) {
            editor.putString("USER_NAME", userName)
            editor.apply()
        }
    var userEmail: String?
        get() = sharedPreferences.getString("USER_EMAIL", "Email not found")
        set(userEmail) {
            editor.putString("USER_EMAIL", userEmail)
            editor.apply()
        }
    var webUrl: String?
        get() = sharedPreferences.getString("WEB_URL", "Url not found")
        set(webUrl) {
            editor.putString("WEB_URL", webUrl)
            editor.apply()
        }

    var userPassword: String?
        get() = sharedPreferences.getString("USER_PASSWORD", "Password not found")
        set(userPassword) {
            editor.putString("USER_PASSWORD", userPassword)
            editor.apply()
        }
    var age: Int
        get() = sharedPreferences.getInt(
            "AGE",
            -1
        )
        set(age) {
            editor.putInt("AGE", age)
            editor.apply()
        }
    var phone: Int
        get() = sharedPreferences.getInt(
            "PHONE",
            -1
        )
        set(phone) {
            editor.putInt("PHONE", phone)
            editor.apply()
        }


    fun setLoginFlag(islogin: Boolean) {
        editor.putBoolean("IS_LOGIN", islogin)
        editor.apply()
    }

    fun islogin(): Boolean {
        return sharedPreferences.getBoolean(
            "IS_LOGIN",
            false
        )
    }
    companion object {
        private var myPreferences: MyPreferences? = null
        private lateinit var sharedPreferences: SharedPreferences
        private lateinit var editor: Editor
        fun getPreferences(context: Context): MyPreferences? {
            if (myPreferences == null) myPreferences = MyPreferences(context)
            return myPreferences
        }
    }

    init {
        sharedPreferences = context.getSharedPreferences(
            "SHARED_PREFERENCES_NAME",
            Context.MODE_PRIVATE
        )
        editor = sharedPreferences.edit()
        editor.apply()
    }
}