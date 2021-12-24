package com.example.a29th_first_semina.ui.view.onboarding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a29th_first_semina.R
import com.example.a29th_first_semina.databinding.ActivityOnboardingBinding

class OnboardingActivity : AppCompatActivity() {
    private lateinit var binding : ActivityOnboardingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityOnboardingBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}