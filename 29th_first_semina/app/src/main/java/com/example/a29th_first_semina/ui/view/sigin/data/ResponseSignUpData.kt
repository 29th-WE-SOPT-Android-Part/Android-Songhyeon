package com.example.a29th_first_semina.ui.view.sigin.data

data class ResponseSignUpData(

    val status : Int,
    val success : Boolean,
    val message : String,
    val data : Data
) {

    data class Data(
        val id: Int,
        val name: String,
        val email: String

    )
}
