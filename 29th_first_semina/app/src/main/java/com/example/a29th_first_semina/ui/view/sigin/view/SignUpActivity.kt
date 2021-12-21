package com.example.a29th_first_semina.ui.view.sigin.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.a29th_first_semina.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initButtonClick()
    }

    private fun initButtonClick() {
        clickSignUpEvent()
    }

    private fun clickSignUpEvent() {

        binding.apply {
            val userName = etName.text
            val userId = etId.text
            val userPwd = etPwd.text

            btnSignup.setOnClickListener {
                if (userName.isEmpty() || userId.isEmpty() || userPwd.isEmpty() ){
                    Toast.makeText(this@SignUpActivity, "입력되지 않은 정보가 있습니다", Toast.LENGTH_SHORT)
                        .show()
                }
                else {
                    finish()
                }
            }
        }


    }

    private fun initNetwork() {


    }
}