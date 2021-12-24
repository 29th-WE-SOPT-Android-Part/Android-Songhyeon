package com.example.a29th_first_semina.util
import android.content.Context
import android.content.Intent

object IntentUtil {
    fun moveActivity(context: Context?, activity: Class<*>){
        val intent = Intent(context,activity)
        context?.startActivity(intent)
    }

}