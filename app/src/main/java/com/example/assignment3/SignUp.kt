package com.example.assignment3

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.view.View
import android.view.View.OnFocusChangeListener
import android.webkit.URLUtil
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_sign_up.*


class SignUp : AppCompatActivity() {
    lateinit var  myPreferences: MyPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        myPreferences = MyPreferences.getPreferences(this)!!

        et_mail.setOnFocusChangeListener(OnFocusChangeListener { v, hasFocus ->
            if (!hasFocus)
                if (isValidEmail(et_mail.text.toString())) {

                } else
                    et_mail.error = "Enter a valid email address"
        })
        et_age.setOnFocusChangeListener(OnFocusChangeListener { v: View?, hasFocus: Boolean ->
            if (!hasFocus)
                if (et_age.text.toString().isEmpty()) {
                    et_age.error = "Age can't be empty"
                }
        })

        et_phone.setOnFocusChangeListener(OnFocusChangeListener { v: View?, hasFocus: Boolean ->
            if (!hasFocus)
                if (et_phone.text.toString().isEmpty()) {
                    et_phone.error = "Phone can't be empty"
                }
        })

        et_name.setOnFocusChangeListener(OnFocusChangeListener { v: View?, hasFocus: Boolean ->
            if (!hasFocus)
                if (et_name.text.toString().isEmpty()) {
                    et_name.error = "Name can't be empty"
                }
        })
        et_pass.setOnFocusChangeListener(OnFocusChangeListener { v: View?, hasFocus: Boolean ->
            if (!hasFocus)
                if (et_pass.text.toString().isEmpty()) {
                    et_pass.error = "Password can't be empty"
                }
        })
        et_reType_pass.setOnFocusChangeListener(OnFocusChangeListener { v: View?, hasFocus: Boolean ->
            if (!hasFocus)
                if (et_reType_pass.text.toString().isEmpty()) {
                    et_reType_pass.error = "Password can't be empty"
                }
        })
        et_website.setOnFocusChangeListener(OnFocusChangeListener { v: View?, hasFocus: Boolean ->
            if (!hasFocus)

                if (et_website.text.toString().isEmpty()) {

                    et_website.error = "Web Url can't be empty"

                }
            else
                    if(URLUtil.isValidUrl(et_website.text.toString()))
                        else  et_website.error = "Web Url formation is wrong"

        })



        btn_signup.setOnClickListener {
            if (et_name.text.toString().trim().isNotEmpty()&&et_age.text.toString().trim().isNotEmpty()&&et_phone.text.toString().trim().isNotEmpty()&&et_mail.text.toString().trim().isNotEmpty()&&et_website.text.toString().trim().isNotEmpty()&&et_pass.text.toString().trim().isNotEmpty()&&et_reType_pass.text.toString().trim().isNotEmpty()) {
                if(URLUtil.isValidUrl(et_website.text.toString())) {
                    if (isValidEmail(et_mail.text.toString())) {

                        if (et_pass.text.toString() == et_reType_pass.text.toString()) {
                            myPreferences.userName = et_name.text.toString()
                            myPreferences.age = et_age.text.toString().toInt()
                            myPreferences.phone = et_phone.text.toString().toInt()
                            myPreferences.userEmail = et_mail.text.toString()
                            myPreferences.userPassword = et_pass.text.toString()
                            myPreferences.webUrl = et_website.text.toString()

                            val intent = Intent(this, MainActivity::class.java)
                            startActivity(intent)
                            finish()
                        } else
                            Toast.makeText(this, "Password didn't match", Toast.LENGTH_SHORT).show()
                    }
             }
               else et_website.error = "Web Url formation is wrong"

            }
            else Toast.makeText(this, "No field can be empty ", Toast.LENGTH_SHORT).show()
        }
    }
    private fun isValidEmail(email: String): Boolean {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches()





    }

}