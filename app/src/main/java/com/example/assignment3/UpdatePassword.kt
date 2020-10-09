package com.example.assignment3

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.assignment3.sharedPreferences.sharedPreference
import com.example.assignment3.sharedPreferences.sharedPreferencesImplement
import kotlinx.android.synthetic.main.activity_update_password.*

class UpdatePassword : AppCompatActivity() {
    private lateinit var SharedPreference : sharedPreference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_password)
        SharedPreference= sharedPreferencesImplement(this)

        val storedpassword = SharedPreference.getString(sharedPreference.PASSWORD)

        et_oldPassword.setOnFocusChangeListener { _: View?, hasFocus: Boolean ->
            if (!hasFocus)
                if (et_oldPassword.text.toString().trim().isEmpty())
                    et_oldPassword.error = "Password can't be Empty"


        }
        et_newPassword.setOnFocusChangeListener { _: View?, hasFocus: Boolean ->
            if (!hasFocus)
                if (et_newPassword.text.toString().trim().isEmpty())
                    et_newPassword.error = "Password can't be Empty"


        }
        et_confirmNewPassword.setOnFocusChangeListener { _: View?, hasFocus: Boolean ->
            if (!hasFocus)
                if (et_confirmNewPassword.text.toString().trim().isEmpty())
                    et_confirmNewPassword.error = "Password can't be Empty"


        }
        btn_updatePassword.setOnClickListener {
            if (et_oldPassword.text.toString().trim().isNotEmpty() && et_newPassword.text.toString()
                    .trim().isNotEmpty() && et_confirmNewPassword.text.toString().trim()
                    .isNotEmpty()
            ) {
                if (storedpassword == et_oldPassword.text.toString()) {
                    if (et_newPassword.text.toString() == et_confirmNewPassword.text.toString()) {
                        SharedPreference.setString(sharedPreference.PASSWORD,et_newPassword.text.toString())
                        //myPreferences.userPassword = et_newPassword.text.toString()
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