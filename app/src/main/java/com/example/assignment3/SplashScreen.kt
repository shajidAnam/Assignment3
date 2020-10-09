package com.example.assignment3

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.animation.LinearInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.agrawalsuneet.loaderspack.loaders.CurvesLoader
import com.example.assignment3.sharedPreferences.sharedPreference
import com.example.assignment3.sharedPreferences.sharedPreferencesImplement
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreen : AppCompatActivity() {
    private lateinit var SharedPreference : sharedPreference

    private lateinit var handler: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        supportActionBar?.hide()
        handler = Handler()


        handler.postDelayed({
            checkLogin()


        }, 5000)
        SharedPreference= sharedPreferencesImplement(this)


        CurvesLoader(
            this,
            4,
            100,
            10,
            10,
            160.0f,
            ContextCompat.getColor(this, R.color.textColor)
        )
            .apply {
                animDuration = 1000
                interpolator = LinearInterpolator()
            }

  }
    private fun checkLogin(){
        if (SharedPreference.getBoolean(sharedPreference.LOGINFLAG)!!){
            val intent = Intent(this, Profile::class.java)
            startActivity(intent)
            finish()

            } else {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()

        }
    }

}

