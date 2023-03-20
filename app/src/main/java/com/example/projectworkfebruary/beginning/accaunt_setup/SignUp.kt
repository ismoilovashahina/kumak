package com.example.projectworkfebruary.beginning.accaunt_setup

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.projectworkfebruary.MainActivity
import com.example.projectworkfebruary.R
import com.example.projectworkfebruary.beginning.SignIn
import com.example.projectworkfebruary.datas.User
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        var sharedPreferences = getSharedPreferences("reg", MODE_PRIVATE)
        var edit = sharedPreferences.edit()
        var gson = Gson()
        var userList = mutableListOf<User>()
        var type = object : TypeToken<List<User>>() {}.type


        signup_btn.setOnClickListener {
            var users = sharedPreferences.getString("users","")
            var pos=false
            if (users==""){
                userList = mutableListOf()
                userList.add(User(signup_email.text.toString(),signup_password.text.toString()))
                Toast.makeText(this,"Succesfully registered", Toast.LENGTH_SHORT).show()
                val str = gson.toJson(userList)
                edit.putString("users", str).commit()

            }else{
                userList = gson.fromJson(users,type)
                for( i in userList){
                    if(i.email!=signup_email.text.toString() && i.password!=signup_password.text.toString()){
                        pos=true
                    }
                    else{
                        pos=false
                        break
                    }

                }
                if(pos==true){
                    userList.add(User(signup_email.text.toString(),signup_password.text.toString()))
                    Toast.makeText(this,"Succesfully registered", Toast.LENGTH_SHORT).show()
                    val str = gson.toJson(userList)
                    edit.putString("users", str).commit()
                    var intent= Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
                else{
                    Toast.makeText(this,"Change inputs!", Toast.LENGTH_SHORT).show()
                }
            }
        }

        signup_facebook.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://facebook.com/")
            startActivity(openURL)
        }

        signup_google.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://google.com/")
            startActivity(openURL)
        }

        signup_apple.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://apple.com/")
            startActivity(openURL)
        }


        signin_tv.setOnClickListener {
            intent = Intent(this, SignIn::class.java)
            startActivity(intent)
        }






    }
}