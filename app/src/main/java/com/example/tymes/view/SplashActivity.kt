package com.example.tymes.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.example.tymes.R
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    private val SPLASH_TIME_OUT: Long = 5000
    private var topAnimantion: Animation? = null
    private var bottomAnimation: Animation? = null
    private var middleAnimation: Animation? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        //Animation Calls
        topAnimantion = AnimationUtils.loadAnimation(this, R.anim.top_animation)
        bottomAnimation = AnimationUtils.loadAnimation(this, R.anim.bottom_animation)
        middleAnimation = AnimationUtils.loadAnimation(this, R.anim.middle_animation)

        first_line.animation = topAnimantion
        second_line.animation = topAnimantion
        third_line.animation = topAnimantion
        fourth_line.animation = topAnimantion
        fifth_line.animation = topAnimantion
        sixth_line.animation = topAnimantion
        app_logo.animation = middleAnimation
        tagLine.animation = bottomAnimation

        Handler(Looper.getMainLooper()).postDelayed({

            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }, SPLASH_TIME_OUT)
    }
}