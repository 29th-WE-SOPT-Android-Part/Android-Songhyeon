package com.example.a29th_first_semina.ui.view.sigin.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.a29th_first_semina.databinding.ActivitySignUpBinding
import com.example.a29th_first_semina.ui.view.sigin.ServiceCreater
import com.example.a29th_first_semina.ui.view.sigin.data.RequsetSignUpdata
import com.example.a29th_first_semina.ui.view.sigin.data.ResponseSignUpData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
                    initNetwork()
                }
            }
        }


    }

    private fun initNetwork() {
        val requsetSignupData = RequsetSignUpdata(
            email = binding.etId.text.toString(),
            password =  binding.etPwd.toString(),
            name = binding.etName.toString()
        )

        val call : Call<ResponseSignUpData> = ServiceCreater.service.postSignup(requsetSignupData)

        call.enqueue(object : Callback<ResponseSignUpData>{
            override fun onResponse(
                call: Call<ResponseSignUpData>,
                response: Response<ResponseSignUpData>
            ) {
                if(response.isSuccessful){
                    val data = response.body()?.data
                    Log.d("서버통신 상태", response.body()?.status.toString())
                    finish()
                }

                else{
                    Log.d("서버통신 상태", response.body()?.status.toString())
                }
            }

            override fun onFailure(call: Call<ResponseSignUpData>, t: Throwable) {
                Log.d("서버통신 상태", "실패")
            }
        })


    }
}