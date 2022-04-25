package com.example.moviereview

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowInsets
import android.view.WindowManager
import androidx.lifecycle.lifecycleScope
import com.example.moviereview.databinding.ActivityMainBinding
import com.example.moviereview.ui.MoviesActivity
import kotlinx.coroutines.delay

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        @Suppress("DEPRECATION")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }

        val anim = android.view.animation.AnimationUtils.loadAnimation(applicationContext, R.anim.splash_fade_in)

        lifecycleScope.launchWhenCreated {
            delay(100)
            binding.apply {
                appIcon.startAnimation(anim)
                appName.startAnimation(anim)
            }
            delay(1600)
            startActivity(Intent(this@MainActivity, MoviesActivity::class.java))
            finish()
        }
    }
}