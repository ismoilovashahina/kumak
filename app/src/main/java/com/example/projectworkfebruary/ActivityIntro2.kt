package com.example.projectworkfebruary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_intro2.*

class ActivityIntro2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro2)

        next.setOnClickListener {
            intent = Intent(this, Intro3::class.java)
            startActivity(intent)
        }
    }
}