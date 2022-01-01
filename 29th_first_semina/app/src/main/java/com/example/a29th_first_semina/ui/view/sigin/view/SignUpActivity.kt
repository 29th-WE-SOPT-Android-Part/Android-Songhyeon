package com.example.a29th_first_semina.ui.view.sigin.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Toast
import com.example.a29th_first_semina.databinding.ActivitySignUpBinding
import com.example.a29th_first_semina.ui.view.sigin.di.ServiceCreater
import com.example.a29th_first_semina.ui.view.sigin.data.RequsetSignUpdata
import com.example.a29th_first_semina.ui.view.sigin.data.ResponseSignUpData
import com.example.a29th_first_semina.util.ToastUtil.makeToast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        checkSignUpBtn()
        enableSignUpBtn()
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
                if (userName.isEmpty() || userId.isEmpty() || userPwd.isEmpty()) {
                    makeToast("입력되지 않은 정보가 있습니다")
                } else {
                    initNetwork()
                }
            }
        }


    }

    private fun initNetwork() {
        val requsetSignupData = RequsetSignUpdata(
            email = binding.etId.text.toString(),
            password = binding.etPwd.toString(),
            name = binding.etName.toString()
        )

        val call: Call<ResponseSignUpData> = ServiceCreater.service.postSignup(requsetSignupData)

        call.enqueue(object : Callback<ResponseSignUpData> {
            override fun onResponse(
                call: Call<ResponseSignUpData>,
                response: Response<ResponseSignUpData>
            ) {
                if (response.isSuccessful) {
                    val data = response.body()?.data
                    Log.d("서버통신 상태", response.body()?.status.toString())
                    finish()
                } else {
                    Log.d("서버통신 상태", response.body()?.status.toString())
                }
            }

            override fun onFailure(call: Call<ResponseSignUpData>, t: Throwable) {
                Log.d("서버통신 상태", "실패")
            }
        })
    }


    private fun hasUserName() = binding.etName.text.isEmpty()
    private fun hasUserId() = binding.etId.text.isEmpty()
    private fun hasUserPwd() = binding.etPwd.text.isEmpty()

    private fun enableSignUpBtn() {
        binding.btnSignup.isEnabled = !hasUserId() && !hasUserName() && !hasUserPwd()
    }

    private fun checkSignUpBtn() {
        binding.etName.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                enableSignUpBtn()

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                binding.btnSignup.isEnabled = false
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                enableSignUpBtn()

            }
        })

        binding.etId.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                enableSignUpBtn()

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                binding.btnSignup.isEnabled = false
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                enableSignUpBtn()

            }
        })

        binding.etPwd.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                enableSignUpBtn()

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                binding.btnSignup.isEnabled = false
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                enableSignUpBtn()

            }
        })

    }

}