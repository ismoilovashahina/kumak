package com.example.projectworkfebruary

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignIn : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        var sharedpreferences = getSharedPreferences("reg", MODE_PRIVATE)
        var edit = sharedpreferences.edit()
        var gson = Gson()
        var userList = mutableListOf<User>()
        var type = object : TypeToken<List<User>>() {}.type

        signin_btn.setOnClickListener {
            var users = sharedpreferences.getString("users", "")
            var pos = false

            if (users == "") {
                Toast.makeText(this, "Enter empty blanks!", Toast.LENGTH_SHORT).show()

            } else {
                userList = gson.fromJson(users, type)
                for (i in userList) {
                    if (i.email == signin_email.text.toString() && i.password == signin_password.text.toString()) {
                        pos = true
                        break
                    } else {
                        pos = false
                    }
                }

                if (pos == true) {
                    var intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "You have not registered yet!", Toast.LENGTH_SHORT).show()
                }
            }
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