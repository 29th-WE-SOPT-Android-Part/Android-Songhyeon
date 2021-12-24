package com.example.a29th_first_semina.util

import android.content.Context
import android.widget.Toast

object ToastUtil {

    fun Context.makeToast(message : String){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }
}