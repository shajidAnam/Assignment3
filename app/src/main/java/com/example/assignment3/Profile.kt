package com.example.assignment3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_profile.*

class Profile : AppCompatActivity() {
    lateinit var  myPreferences: MyPreferences
    lateinit var  storedEmail:String
    lateinit var   storedName :String
   lateinit var storedPhone :String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        supportActionBar?.hide()
        myPreferences = MyPreferences.getPreferences(this)!!
        storedEmail = myPreferences.userEmail!!
        storedName = myPreferences.userName!!
        storedPhone= myPreferences.phone!!

        Glide.with(this).load("https://images.wallpapersden.com/image/download/iron-man-minimalist_66484_3840x2160.jpg").into(iv_glide)
        tv_email_output.setText(storedEmail)
        tv_name_output.setText(storedName)
        tv_phone_output.setText(storedPhone)

        btn_logout.setOnClickListener {
            myPreferences.setLoginFlag(islogin = false)
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