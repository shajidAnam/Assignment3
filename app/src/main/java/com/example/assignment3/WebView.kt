package com.example.assignment3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_web_view.*

class WebView : AppCompatActivity() {
    lateinit var myPreferences: MyPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)
        supportActionBar?.hide()
        myPreferences= MyPreferences.getPreferences(this)!!

  webUrl.loadUrl(myPreferences.webUrl)
    }
}