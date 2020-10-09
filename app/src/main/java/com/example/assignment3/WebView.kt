package com.example.assignment3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.assignment3.sharedPreferences.sharedPreference
import com.example.assignment3.sharedPreferences.sharedPreferencesImplement
import kotlinx.android.synthetic.main.activity_web_view.*

class WebView : AppCompatActivity() {
    private lateinit var SharedPreference : sharedPreference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)
        supportActionBar?.hide()
        SharedPreference= sharedPreferencesImplement(this)

  webUrl.loadUrl(SharedPreference.getString(sharedPreference.WEBURL))
    }
}