package com.example.a29th_first_semina.ui.view.sigin.di

import android.telecom.Call
import com.example.a29th_first_semina.ui.view.sigin.data.RequsetLoginData
import com.example.a29th_first_semina.ui.view.sigin.data.RequsetSignUpdata
import com.example.a29th_first_semina.ui.view.sigin.data.ResponseLoginData
import com.example.a29th_first_semina.ui.view.sigin.data.ResponseSignUpData
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface Service {
    @Headers("Content-Type:application/json")
    @POST("user/login")
    fun postLogin(
        @Body body : RequsetLoginData
    ) : retrofit2.Call <ResponseLoginData>


    @POST("user/signup")
    fun postSignup(
        @Body body : RequsetSignUpdata
    ) : retrofit2.Call <ResponseSignUpData>
}