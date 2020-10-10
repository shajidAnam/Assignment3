package com.example.assignment3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.assignment3.sharedPreferences.sharedPreference
import com.example.assignment3.sharedPreferences.sharedPreferencesImplement
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.activity_profile.view.*

class Profile : AppCompatActivity() {
    private lateinit var SharedPreference : sharedPreference
    private lateinit var  storedEmail:String
    private lateinit var   storedName :String
    private lateinit var storedPhone :String
    private lateinit var storedGender :String
    private  var storedNotificationValue =false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        supportActionBar?.hide()
        SharedPreference= sharedPreferencesImplement(this)

        loadData()
        imageLoad()
        showData()

      btn_logout.setOnClickListener {
            SharedPreference.setBoolean(sharedPreference.LOGINFLAG,false)
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        btn_ediProfile.setOnClickListener {
            val intent=Intent(this,SignUp::class.java)
            SharedPreference.setInt(sharedPreference.FLAG,1)
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
    fun imageLoad(){
        Glide
            .with(this)
            .load(SharedPreference.getString(sharedPreference.IMAGEURL))
            .override(300,200)
            .centerCrop()
            .placeholder(R.drawable.ic_baseline_sentiment_very_dissatisfied_24)
            .error(R.drawable.ic_baseline_signal_wifi_off_24)
            .fallback(R.drawable.ic_baseline_broken_image_24)
            .into(iv_glide)
    }
    fun loadData(){
        storedEmail = SharedPreference.getString(sharedPreference.EMAIL).toString()
        storedName =SharedPreference.getString(sharedPreference.NAME).toString()
        storedPhone= SharedPreference.getString(sharedPreference.PHONE).toString()
        storedGender= SharedPreference.getString(sharedPreference.GENDER).toString()
        storedNotificationValue= SharedPreference.getBoolean(sharedPreference.CHECKBOXVALUE)!!


        if (storedNotificationValue){
            checkbox_output.isChecked=true
            tv_notificationValue_output.text="enabled"
        }
        else{
            checkbox_output.isChecked=false
            tv_notificationValue_output.text="disabled"}

        checkbox_output.isEnabled=false

        if (storedGender=="Male"){
            radio_male.isChecked=true

        }
        else if (storedGender=="Female")
        { radio_female.isChecked=true

            }
        radio_female.isEnabled=false
        radio_male.isEnabled=false


    }


    fun showData(){
        tv_email_output.text = storedEmail
        tv_name_output.text = storedName
        tv_phone_output.text = storedPhone
    }
}