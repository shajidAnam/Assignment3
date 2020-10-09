package com.example.assignment3

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.assignment3.sharedPreferences.sharedPreference
import com.example.assignment3.sharedPreferences.sharedPreference.Companion.PASSWORD
import com.example.assignment3.sharedPreferences.sharedPreferencesImplement
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var et_userName=""
    private var et_userPassword=""
    private lateinit var SharedPreference :  sharedPreference

    private lateinit var  storedEmail:String
    private lateinit var   storedPassword :String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        SharedPreference=sharedPreferencesImplement(this)

        storedEmail = SharedPreference.getString(sharedPreference.EMAIL).toString()
        storedPassword =  SharedPreference.getString(PASSWORD).toString()

        et_email.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus)
                if (isValidEmail(et_email.text.toString())) {

                } else
                    et_email.error = "Enter a valid email address"
        }
        et_password.setOnFocusChangeListener { v: View?, hasFocus: Boolean ->
            if (!hasFocus) {
                if (et_userPassword.trim().isEmpty())
                    et_password.error = "Password can't be Empty"
            }


        }

        btn_login.setOnClickListener {
            if (et_email.text.toString().trim().isNotEmpty()&& et_password.text.toString().trim().isNotEmpty()){
            et_userName = et_email.text.toString()
            et_userPassword = et_password.text.toString()
            checkLogin()}
            else Toast.makeText(this,"No field can be empty ",Toast.LENGTH_SHORT).show()
        }

        btn_register.setOnClickListener {
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
            finish()

        }
    }
    private fun checkLogin() {
        if (et_userName == storedEmail && et_userPassword == storedPassword) {
            val intent = Intent(this, Profile::class.java)
            SharedPreference.setBoolean(sharedPreference.LOGINFLAG,true)
            startActivity(intent)
            finish()
        } else
            Toast.makeText(this, "Your email or password is incorrect", Toast.LENGTH_SHORT)
                .show()
    }


    private fun isValidEmail(email: String): Boolean {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}