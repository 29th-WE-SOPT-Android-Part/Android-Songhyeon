package com.example.a29th_first_semina.ui.view.sigin.data

import com.google.gson.annotations.SerializedName

data class RequsetLoginData(
    @SerializedName("email")
    val email : String,
    val password : String,
)
