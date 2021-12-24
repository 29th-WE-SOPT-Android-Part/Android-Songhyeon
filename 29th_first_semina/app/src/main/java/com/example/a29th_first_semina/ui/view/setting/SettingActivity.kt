package com.example.a29th_first_semina.ui.view.setting

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.a29th_first_semina.R
import com.example.a29th_first_semina.databinding.ActivitySettingBinding
import com.example.a29th_first_semina.ui.view.sigin.SheredPreference.SophubUserAuthStorage
import com.example.a29th_first_semina.ui.view.sigin.view.SignInActivity
import com.example.a29th_first_semina.util.IntentUtil

class SettingActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySettingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingBinding.inflate(layoutInflater)


        binding.btnBack.setOnClickListener {
            finish()
        }

        binding.tvLogout.setOnClickListener {
            SophubUserAuthStorage.clearAuthStorage(this)
            IntentUtil.moveActivity(this, SignInActivity::class.java)
            Log.d("자동 로그아웃","해제")

        }


        setContentView(binding.root)
    }
}