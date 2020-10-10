package com.example.assignment3

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.view.View
import android.webkit.URLUtil
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.assignment3.sharedPreferences.sharedPreference
import com.example.assignment3.sharedPreferences.sharedPreferencesImplement
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.activity_sign_up.*
import kotlinx.android.synthetic.main.activity_sign_up.radio_female
import kotlinx.android.synthetic.main.activity_sign_up.radio_male


class SignUp : AppCompatActivity() {
    private lateinit var SharedPreference : sharedPreference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        SharedPreference= sharedPreferencesImplement(this)
        var gender=""
        var checkboxValue=true
        var flag=SharedPreference.getInt(sharedPreference.FLAG)
        if (flag==1){

            et_name.setText(SharedPreference.getString(sharedPreference.NAME))
            et_phone.setText(SharedPreference.getString(sharedPreference.PHONE))
            et_mail.setText(SharedPreference.getString(sharedPreference.EMAIL))
            et_website.setText(SharedPreference.getString(sharedPreference.WEBURL))
            et_imageUrl.setText(SharedPreference.getString(sharedPreference.IMAGEURL))
            et_age.setText(SharedPreference.getInt(sharedPreference.AGE).toString())
            if (SharedPreference.getBoolean(sharedPreference.CHECKBOXVALUE)!!){
                checkbox.isChecked=true
                tv_notificationValue.text="enabled"
            }
            else{
                checkbox_output.isChecked=false
                tv_notificationValue_output.text="disabled"}


            if (SharedPreference.getString(sharedPreference.GENDER)=="Male"){
                radio_male.isChecked=true

            }
            else if (SharedPreference.getString(sharedPreference.GENDER)=="Female")
            { radio_female.isChecked=true

            }

        }



        radio_group.setOnCheckedChangeListener { _, checkedID ->
                if (checkedID == R.id.radio_male) {
                    gender = radio_male.text.toString()

                }
                if (checkedID == R.id.radio_female) {
                    gender = radio_female.text.toString()
                }
            }
            checkbox.setOnCheckedChangeListener { buttonView, isChecked ->

                if (buttonView.isChecked) {
                    tv_notificationValue.text = "enabled"
                    checkboxValue = true
                } else {
                    tv_notificationValue.text = "disabled"
                    checkboxValue = false
                }
            }

            et_mail.setOnFocusChangeListener { _, hasFocus ->
                if (!hasFocus)
                    if (isValidEmail(et_mail.text.toString())) {

                    } else
                        et_mail.error = "Enter a valid email address"
            }
            et_age.setOnFocusChangeListener { _: View?, hasFocus: Boolean ->
                if (!hasFocus)
                    if (et_age.text.toString().trim().isEmpty()) {
                        et_age.error = "Age can't be empty"
                    }
            }

            et_phone.setOnFocusChangeListener { _: View?, hasFocus: Boolean ->
                if (!hasFocus)
                    if (et_phone.text.toString().trim().isEmpty()) {
                        et_phone.error = "Phone can't be empty"
                    }
            }

            et_name.setOnFocusChangeListener { _: View?, hasFocus: Boolean ->
                if (!hasFocus)
                    if (et_name.text.toString().trim().isEmpty()) {
                        et_name.error = "Name can't be empty"
                    }
            }
            et_pass.setOnFocusChangeListener { _: View?, hasFocus: Boolean ->
                if (!hasFocus)
                    if (et_pass.text.toString().trim().isEmpty()) {
                        et_pass.error = "Password can't be empty"
                    }
            }
            et_reType_pass.setOnFocusChangeListener { _: View?, hasFocus: Boolean ->
                if (!hasFocus)
                    if (et_reType_pass.text.toString().trim().isEmpty()) {
                        et_reType_pass.error = "Password can't be empty"
                    }
            }
            et_website.setOnFocusChangeListener { _: View?, hasFocus: Boolean ->
                if (!hasFocus)

                    if (et_website.text.toString().trim().isEmpty()) {

                        et_website.error = "Web Url can't be empty"

                    } else
                        if (URLUtil.isValidUrl(et_website.text.toString()))
                        else et_website.error = "Web Url formation is wrong"

            }
            et_imageUrl.setOnFocusChangeListener { _: View?, hasFocus: Boolean ->
                if (!hasFocus)

                    if (et_imageUrl.text.toString().trim().isEmpty()) {

                        et_imageUrl.error = "Image Url can't be empty"

                    } else
                        if (URLUtil.isValidUrl(et_imageUrl.text.toString()))
                        else et_imageUrl.error = " Url formation is wrong"

            }



        btn_signup.setOnClickListener {
            if (et_name.text.toString().trim().isNotEmpty()&&et_age.text.toString().trim().isNotEmpty()&&et_phone.text.toString().trim().isNotEmpty()&&et_mail.text.toString().trim().isNotEmpty()&&et_website.text.toString().trim().isNotEmpty()&&et_pass.text.toString().trim().isNotEmpty()&&et_reType_pass.text.toString().trim().isNotEmpty()) {
                if(URLUtil.isValidUrl(et_website.text.toString())) {
                    if (isValidEmail(et_mail.text.toString())) {

                        if (et_pass.text.toString() == et_reType_pass.text.toString()) {
                            SharedPreference.setString(sharedPreference.NAME,et_name.text.toString())
                            SharedPreference.setInt(sharedPreference.AGE,et_age.text?.trim().toString().toInt())
                            SharedPreference.setString(sharedPreference.PHONE,et_phone.text?.trim().toString())
                            SharedPreference.setString(sharedPreference.EMAIL,et_mail.text.toString())
                            SharedPreference.setString(sharedPreference.PASSWORD,et_pass.text.toString())
                            SharedPreference.setString(sharedPreference.WEBURL,et_website.text.toString())
                            SharedPreference.setString(sharedPreference.GENDER,gender)
                            SharedPreference.setBoolean(sharedPreference.CHECKBOXVALUE,checkboxValue)
                            SharedPreference.setString(sharedPreference.IMAGEURL,et_imageUrl.text.toString())


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