package com.example.a29th_first_semina.ui.view.sigin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.a29th_first_semina.databinding.ActivitySigninBinding
import com.example.a29th_first_semina.ui.view.home.HomeActivity

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
        val homeIntent = Intent(this, HomeActivity::class.java)
        startActivity(homeIntent)
    }

    private fun moveSignUpActivity() {
        val signupIntent = Intent(this, SignUpActivity::class.java)
        startActivity(signupIntent)

    }

    private fun clickLoginEvent() {

        with(binding) {
            btnLogin.setOnClickListener {
                val userId = etId.text
                val userPassword= etPwd.text
                if (userId.isEmpty() || userPassword.isEmpty()) {
                    Toast.makeText(this@SignInActivity, "로그인 실패", Toast.LENGTH_SHORT).show()
                } else {
                    moveHomeActivity()
                }

            }

        }

    }

    private fun clickSignUpEvent() {
        binding.tvSignup.setOnClickListener {
            moveSignUpActivity()
        }

    }
}