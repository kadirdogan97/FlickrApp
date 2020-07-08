package com.kadirdogan97.flickrapp.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.kadirdogan97.flickrapp.R


class SplashActivity : AppCompatActivity() {
    private val animationStarted = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        setTheme(R.style.AppTheme)
        window.decorView.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
        supportActionBar?.hide()
        Handler().postDelayed({
            moveForward()
        }, ANIM_ITEM_DURATION)
    }
    companion object {
        const val ANIM_ITEM_DURATION: Long = 3000
    }

    private fun moveForward() {
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_NO_ANIMATION
        startActivity(intent)
        finish()
    }
}