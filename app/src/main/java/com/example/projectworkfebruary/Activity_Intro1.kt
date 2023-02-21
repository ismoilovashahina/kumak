package com.example.projectworkfebruary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_intro1.*

class Activity_Intro1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro1)

        next.setOnClickListener {
            intent = Intent(this, ActivityIntro2::class.java)
            startActivity(intent)
        }

        skip.setOnClickListener {
            intent = Intent(this, Welcome::class.java)
            startActivity(intent)
        }
    }
}