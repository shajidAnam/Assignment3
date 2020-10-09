package com.example.assignment3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.assignment3.sharedPreferences.sharedPreference
import com.example.assignment3.sharedPreferences.sharedPreferencesImplement
import kotlinx.android.synthetic.main.activity_profile.*

class Profile : AppCompatActivity() {
    private lateinit var SharedPreference : sharedPreference
    private lateinit var  storedEmail:String
    private lateinit var   storedName :String
    private lateinit var storedPhone :String
    private lateinit var storedGender :String
    private  var StoredNotificationValue =false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        supportActionBar?.hide()
        SharedPreference= sharedPreferencesImplement(this)
        storedEmail = SharedPreference.getString(sharedPreference.EMAIL).toString()
        storedName =SharedPreference.getString(sharedPreference.NAME).toString()
        storedPhone= SharedPreference.getString(sharedPreference.PHONE).toString()
        storedGender= SharedPreference.getString(sharedPreference.GENDER).toString()
        StoredNotificationValue= SharedPreference.getBoolean(sharedPreference.CHECKBOXVALUE)!!

        Glide.with(this).load("https://images.wallpapersden.com/image/download/iron-man-minimalist_66484_3840x2160.jpg").into(iv_glide)
        tv_email_output.text = storedEmail
        tv_name_output.text = storedName
        tv_phone_output.text = storedPhone

        btn_logout.setOnClickListener {
            SharedPreference.setBoolean(sharedPreference.LOGINFLAG,false)
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        btn_ediProfile.setOnClickListener {
            val intent=Intent(this,SignUp::class.java)
            startActivity(intent)
        }

        btn_changePassword.setOnClickListener {
            val intent=Intent(this,UpdatePassword::class.java)
            startActivity(intent)
        }
        btn_webUrl.setOnClickListener {
            val intent=Intent(this,WebView::class.java)
            startActivity(intent)
        }



    }
}