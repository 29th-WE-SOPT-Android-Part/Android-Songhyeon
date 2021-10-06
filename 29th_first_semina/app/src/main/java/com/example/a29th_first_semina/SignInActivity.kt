package com.example.a29th_first_semina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.a29th_first_semina.databinding.ActivitySigninBinding

class SignInActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySigninBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySigninBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initButtonClickEvent()

    }
    private fun initButtonClickEvent(){
        binding.btnLogin.setOnClickListener{
            val user_id : String = binding.etId.toString()
            val user_pwd : String = binding.etPwd.toString()

        }
    }
}