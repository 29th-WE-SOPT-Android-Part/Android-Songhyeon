package com.example.a29th_first_semina.ui.view.sigin.SheredPreference

import android.content.Context

object SophubUserAuthStorage {

    private const val STORAGE_KEY = "user_auth"
    private const val USER_ID_KEY = "user_id"
    private const val USER_PWD_KEY = "user_pwd"

    fun getUserId(context: Context) : String {
        val sharedPreferences = context.getSharedPreferences(
            "${context.packageName}.$STORAGE_KEY",
            Context.MODE_PRIVATE
        )
        return sharedPreferences.getString(USER_ID_KEY,"") ?: ""
    }

    fun getUserPwd(context: Context) : String {
        val sharedPreferences = context.getSharedPreferences(
            "${context.packageName}.$STORAGE_KEY",
            Context.MODE_PRIVATE
        )
        return sharedPreferences.getString(USER_PWD_KEY,"") ?: ""
    }

    fun saveUserId(context: Context, id : String) {
        val sharedPreferences = context.getSharedPreferences(
            "${context.packageName}.$STORAGE_KEY",
            Context.MODE_PRIVATE
        )
        sharedPreferences.edit()
            .putString(USER_ID_KEY,id)
            .apply()
    }

    fun saveUserPwd(context: Context, pwd : String){
        val sharedPreferences = context.getSharedPreferences(
            "${context.packageName}.$STORAGE_KEY",
            Context.MODE_PRIVATE
        )
        sharedPreferences.edit()
            .putString(USER_PWD_KEY,pwd)
            .apply()
    }

    fun removeUserId(context: Context){
        val sharedPreferences = context.getSharedPreferences(
            "${context.packageName}.$STORAGE_KEY",
            Context.MODE_PRIVATE
        )
        sharedPreferences.edit()
            .remove(USER_ID_KEY)
            .apply()
    }

    fun removeUserPwe(context: Context){
        val sharedPreferences = context.getSharedPreferences(
            "${context.packageName}.$STORAGE_KEY",
            Context.MODE_PRIVATE
        )
        sharedPreferences.edit()
            .remove(USER_PWD_KEY)
            .apply()
    }


    fun clearAuthStorage(context: Context){
        val sharedPreferences = context.getSharedPreferences(
            "${context.packageName}.$STORAGE_KEY",
            Context.MODE_PRIVATE
        )

        sharedPreferences.edit()
            .clear()
            .apply()
    }

}