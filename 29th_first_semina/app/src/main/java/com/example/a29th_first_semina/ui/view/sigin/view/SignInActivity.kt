package com.example.a29th_first_semina.ui.view.sigin.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Toast
import com.example.a29th_first_semina.databinding.ActivitySigninBinding
import com.example.a29th_first_semina.ui.view.home.HomeActivity
import com.example.a29th_first_semina.ui.view.sigin.SheredPreference.SophubUserAuthStorage
import com.example.a29th_first_semina.ui.view.sigin.di.ServiceCreater
import com.example.a29th_first_semina.ui.view.sigin.data.RequsetLoginData
import com.example.a29th_first_semina.ui.view.sigin.data.ResponseLoginData
import com.example.a29th_first_semina.util.IntentUtil
import com.example.a29th_first_semina.util.ToastUtil.makeToast
import retrofit2.Callback
import retrofit2.Response

class SignInActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySigninBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySigninBinding.inflate(layoutInflater)
        setContentView(binding.root)


        searchSopthubUserStoage()
        initButtonClickEvent()
        checkUserData()
        enableLoginButton()

    }

    private fun initButtonClickEvent() {

        clickLoginEvent()
        clickSignUpEvent()
    }

    private fun moveHomeActivity() {
        IntentUtil.moveActivity(this, HomeActivity::class.java)
    }


    private fun clickLoginEvent() {

        with(binding) {
            btnLogin.setOnClickListener {
                val userId = etId.text
                val userPassword = etPwd.text
                if (userId.isEmpty() || userPassword.isEmpty()) {
                    makeToast("아이디/비번 둘 다 입력해라")
                } else {
                    initNetwork()
                }
            }
        }
    }

    private fun clickSignUpEvent() {
        binding.tvSignup.setOnClickListener {
            IntentUtil.moveActivity(this, SignUpActivity::class.java)
        }

    }

    private fun initNetwork() {
        val requsetLoginData = RequsetLoginData(
            email = binding.etId.text.toString(),
            password = binding.etPwd.text.toString()
        )

        val call: retrofit2.Call<ResponseLoginData> =
            ServiceCreater.service.postLogin(requsetLoginData)

        call.enqueue(object : Callback<ResponseLoginData> {
            override fun onResponse(
                call: retrofit2.Call<ResponseLoginData>,
                response: Response<ResponseLoginData>
            ) {
                if (response.isSuccessful) {
                    moveHomeActivity()
                    Log.d("서버통신 상태", response.body()?.status.toString())

                    if (!hasUserAutoData()) {
                        Log.d("저장소에 있는", "아이디 비번 없음")
                        binding.apply {
                            SophubUserAuthStorage.saveUserId(
                                this@SignInActivity,
                                etId.text.toString()
                            )
                            SophubUserAuthStorage.saveUserPwd(
                                this@SignInActivity,
                                etPwd.text.toString()
                            )
                        }
                    }
                } else {
                    Toast.makeText(
                        this@SignInActivity,
                        response.body()?.status.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                    Log.d("서버통신 상태", response.body()?.status.toString())
                }
            }

            override fun onFailure(call: retrofit2.Call<ResponseLoginData>, t: Throwable) {
                Log.d("로그인통신 실패", "실패임")
            }
        })
    }

    private fun searchSopthubUserStoage() {
        if (hasUserAutoData()) {
            val requsetLoginData = RequsetLoginData(
                email = binding.etId.text.toString(),
                password = binding.etPwd.text.toString()
            )

            ServiceCreater.service.postLogin(requsetLoginData)
            Log.d("자동 로그인", "성공")
            IntentUtil.moveActivity(this, HomeActivity::class.java)

        }

    }

    private fun hasUserAutoData() = SophubUserAuthStorage.getUserId(this).isNotEmpty() &&
            SophubUserAuthStorage.getUserPwd(this).isNotEmpty()

    private fun hasUserId() = binding.etId.text.isEmpty()
    private fun hasUserPwd() = binding.etPwd.text.isEmpty()

    private fun enableLoginButton() {
        binding.btnLogin.isEnabled = !hasUserId() && !hasUserPwd()
        Log.d("로그인 enable 함수", "실행되긴함")
    }

    private fun checkUserData() {
        binding.etId.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                enableLoginButton()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                binding.btnLogin.isEnabled = false
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                enableLoginButton()
            }
        })

        binding.etPwd.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                enableLoginButton()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                binding.btnLogin.isEnabled = false
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                enableLoginButton()
            }
        })
    }
}