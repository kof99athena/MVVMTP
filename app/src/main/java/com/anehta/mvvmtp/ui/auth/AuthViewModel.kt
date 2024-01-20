package com.anehta.mvvmtp.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.anehta.mvvmtp.data.repositories.UserRepositories

class AuthViewModel : ViewModel(){

    var email : String? = null
    var password : String? = null

    var authListener : AuthListener? = null

    fun onLoginButtonClick(view : View){
        authListener?.onStarted()
        if (email.isNullOrEmpty() || password.isNullOrEmpty()){
            authListener?.onFailure("Invalid email or password")
            return
        }
        //authListener?.onSuccess(loginResponse)

        val loginResponse = UserRepositories().userLogin(email!!, password!!)
        authListener?.onSuccess(loginResponse)
    }
}