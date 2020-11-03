package com.example.tymes.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.collection.ArrayMap
import com.example.tymes.R
import com.example.tymes.utills.webservice.RetrofitConnect
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity() {

    private val retroConnect = RetrofitConnect.retrofitCall()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login_btn.setOnClickListener {
            if (username.text.isEmpty())
                username.error = "Enter User name"
            else if (password.text.isEmpty())
                password.error = "Enter Password"
            else
                callLoginAPI()
        }
    }

    private fun callLoginAPI() {
        val response = retroConnect.callLogin("", ArrayMap())
        if (response.isSuccessful) {
            //get value from response
            val loginModel = response.body()
        } else {
            Toast.makeText(this, "Invalid credential", Toast.LENGTH_SHORT).show()
        }
    }
}