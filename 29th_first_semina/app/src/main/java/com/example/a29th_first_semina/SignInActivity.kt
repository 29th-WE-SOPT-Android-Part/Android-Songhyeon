package com.example.a29th_first_semina

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.a29th_first_semina.databinding.ActivitySigninBinding

class SignInActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySigninBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySigninBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initButtonClickEvent()

    }

    private fun initButtonClickEvent() {

        clickLoginEvent()
        clickSignUpEvent()
    }

    private fun moveHomeActivity() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }

    private fun moveSignUpActivity() {
        val signupintent = Intent(this, SignUpActivity::class.java)
        startActivity(signupintent)

    }

    private fun clickLoginEvent() {

        binding.apply {
            btnLogin.setOnClickListener {
                val userId: String = etId.text.toString()
                val userPwd: String = etPwd.text.toString()
                if (userId.isEmpty() || userPwd.isEmpty()) {
                    Toast.makeText(this@SignInActivity, "로그인 실패", Toast.LENGTH_SHORT).show()
                } else {
                    moveHomeActivity()
                }

            }

        }

    }

    private fun clickSignUpEvent() {
        binding.btnSignin.setOnClickListener {
            moveSignUpActivity()
        }

    }
}