package com.anehta.mvvmtp.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.anehta.mvvmtp.data.network.MyApi
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepositories {
    fun userLogin(email : String, password : String) : LiveData<String>{

        val loginResonpse = MutableLiveData<String>()

        MyApi().userLogin(email, password)
            .enqueue(object : Callback<ResponseBody>{
                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: Response<ResponseBody>
                ) {
                    if (response.isSuccessful){
                        loginResonpse.value = response.body()?.toString()
                    }else{
                        loginResonpse.value = response.errorBody()?.toString()
                    }
                }

                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    loginResonpse.value = t.message
                }
            })
        return loginResonpse
    }
}