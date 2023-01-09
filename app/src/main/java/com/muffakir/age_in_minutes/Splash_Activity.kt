package com.muffakir.age_in_minutes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.muffakir.age_in_minutes.databinding.ActivitySplashBinding

class Splash_Activity : AppCompatActivity() {
    private lateinit var binding : ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Handler(Looper.getMainLooper()).postDelayed(
            Runnable {
                val intent = Intent(this@Splash_Activity, MainActivity::class.java)
                startActivity(intent)
                finish()
            },
            2000
        )
    }
}