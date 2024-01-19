package com.anehta.mvvmtp.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.anehta.mvvmtp.R
import com.anehta.mvvmtp.databinding.ActivityLoginBinding
import com.anehta.mvvmtp.util.toast

//액티비티에는 오직 UI만 핸들링한다

class LoginActivity : AppCompatActivity(), AuthListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding : ActivityLoginBinding = DataBindingUtil.setContentView(this,R.layout.activity_login)
        val viewModel = ViewModelProvider(this).get(AuthViewModel::class.java)
        binding.viewModel = viewModel

        viewModel.authListener = this
    }

    override fun onStarted() {
        toast("login started")
    }

    override fun onSuccess() {
        toast("login successed")
    }

    override fun onFailure(message: String) {
        toast("login failured")

    }
}
