package com.example.projectworkfebruary

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignIn : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        signin_btn.setOnClickListener {
            intent = Intent(this, MainActivity::class.java)
        }

        signin_facebook.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://facebook.com/")
            startActivity(openURL)
        }

        signin_google.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://google.com/")
            startActivity(openURL)
        }

        signin_apple.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://apple.com/")
            startActivity(openURL)
        }

        signup_tv.setOnClickListener {
            intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }

    }
}