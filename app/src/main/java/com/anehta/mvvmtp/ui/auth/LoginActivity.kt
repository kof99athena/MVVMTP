package com.anehta.mvvmtp.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Data
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.anehta.mvvmtp.R
import com.anehta.mvvmtp.databinding.ActivityLoginBinding
import com.anehta.mvvmtp.util.hide
import com.anehta.mvvmtp.util.show
import com.anehta.mvvmtp.util.toast

//액티비티에는 오직 UI만 핸들링한다

class LoginActivity : AppCompatActivity(), AuthListener {


    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_login)

        val viewModel = ViewModelProvider(this).get(AuthViewModel::class.java)
        binding.viewModel = viewModel

        viewModel.authListener = this
    }

    override fun onStarted() {
        binding.progressBar.show()
    }

    override fun onSuccess(loginResponse: LiveData<String>) {
        loginResponse.observe(this, Observer {
            toast(it)
        })
    }

    override fun onFailure(message: String) {
        binding.progressBar.show()
        toast("login failured")

    }
}
