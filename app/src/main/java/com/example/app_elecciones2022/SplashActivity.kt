package com.example.app_elecciones2022

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.HandlerCompat.postDelayed

/**
 * SplashActivity donde carga el logo de la app y nombre del desarrollador
 */
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_splash)

        // Animaciones
        var animation1: Animation = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_arriba)
        var animation2: Animation = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_abajo)

        val deTextView: TextView = findViewById(R.id.etqBy)
        val ollinTextView: TextView = findViewById(R.id.etqOllin)
        val logoImageView: ImageView = findViewById(R.id.logoImageView)

        deTextView.animation = animation2
        ollinTextView.animation = animation2
        logoImageView.animation = animation1

        Handler().postDelayed(Runnable {
            val intent: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 4000)
    }
}
