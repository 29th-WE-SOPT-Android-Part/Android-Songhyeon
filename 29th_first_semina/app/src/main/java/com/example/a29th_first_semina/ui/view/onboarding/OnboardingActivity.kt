package com.example.a29th_first_semina.ui.view.onboarding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.findNavController
import com.example.a29th_first_semina.R
import com.example.a29th_first_semina.databinding.ActivityOnboardingBinding
import com.example.a29th_first_semina.ui.view.home.HomeActivity
import com.example.a29th_first_semina.ui.view.sigin.SheredPreference.SophubUserAuthStorage
import com.example.a29th_first_semina.ui.view.sigin.data.RequsetLoginData
import com.example.a29th_first_semina.ui.view.sigin.di.ServiceCreater
import com.example.a29th_first_semina.util.IntentUtil

class OnboardingActivity : AppCompatActivity() {
    private lateinit var binding : ActivityOnboardingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityOnboardingBinding.inflate(layoutInflater)

        if(hasUserAutoData()){
            IntentUtil.moveActivity(this,HomeActivity::class.java)
        }

        else{
            Log.d("자동로그인 상태가","아님")
        }


        setContentView(binding.root)


    }

    private fun hasUserAutoData() = SophubUserAuthStorage.getUserId(this).isNotEmpty() &&
            SophubUserAuthStorage.getUserPwd(this).isNotEmpty()

}