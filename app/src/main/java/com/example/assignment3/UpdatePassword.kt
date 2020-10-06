package com.example.assignment3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_update_password.*

class UpdatePassword : AppCompatActivity() {
    lateinit var myPreferences: MyPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_password)
        myPreferences = MyPreferences.getPreferences(this)!!

        var storedpassword = myPreferences.userPassword

        et_oldPassword.setOnFocusChangeListener(View.OnFocusChangeListener { v: View?, hasFocus: Boolean ->
            if (!hasFocus)
                if (et_oldPassword.text.toString().trim().isEmpty())
                    et_oldPassword.setError("Password can't be Empty")


        })
        et_newPassword.setOnFocusChangeListener(View.OnFocusChangeListener { v: View?, hasFocus: Boolean ->
            if (!hasFocus)
                if (et_newPassword.text.toString().trim().isEmpty())
                    et_newPassword.setError("Password can't be Empty")


        })
        et_confirmNewPassword.setOnFocusChangeListener(View.OnFocusChangeListener { v: View?, hasFocus: Boolean ->
            if (!hasFocus)
                if (et_confirmNewPassword.text.toString().trim().isEmpty())
                    et_confirmNewPassword.setError("Password can't be Empty")


        })
        btn_updatePassword.setOnClickListener {
            if (et_oldPassword.text.toString().trim().isNotEmpty() && et_newPassword.text.toString()
                    .trim().isNotEmpty() && et_confirmNewPassword.text.toString().trim()
                    .isNotEmpty()
            ) {
                if (storedpassword == et_oldPassword.text.toString()) {
                    if (et_newPassword.text.toString() == et_confirmNewPassword.text.toString()) {
                        myPreferences.userPassword = et_newPassword.text.toString()
                        Toast.makeText(this, "Password successfully changed", Toast.LENGTH_SHORT)
                            .show()
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    } else Toast.makeText(this, "Password didn't match", Toast.LENGTH_SHORT).show()
                } else Toast.makeText(this, "Password incorrect", Toast.LENGTH_SHORT).show()

            } else Toast.makeText(this, "No field can be empty ", Toast.LENGTH_SHORT).show()
        }

    }
}