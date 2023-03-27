package com.example.projectworkfebruary

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.projectworkfebruary.onboarding.SignIn
import com.example.projectworkfebruary.onboarding.SignUp
import kotlinx.android.synthetic.main.activity_welcome.*

class Welcome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

            signup_facebook.setOnClickListener {
                val openURL = Intent(Intent.ACTION_VIEW)
                openURL.data = Uri.parse("https://www.facebook.com/")
                startActivity(openURL)
            }

        signup_google.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://www.google.com/")
            startActivity(openURL)
        }

        signup_apple.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://www.apple.com/")
            startActivity(openURL)
        }

        signin_password.setOnClickListener {
            intent = Intent(this, SignIn::class.java)
            startActivity(intent)
        }

        signup_tv.setOnClickListener {
            intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }


    }
}