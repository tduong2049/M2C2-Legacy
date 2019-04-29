package com.example.m2_c2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    // To minimize the number of times the findViewById function is
    // used, create a late initialized variable for each Button, ImageView,
    // or TextView that's going to be modified in functions.
    lateinit var beginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        beginButton = findViewById(R.id.begin_button)

        beginButton.setOnClickListener {
            val agentSetupIntent = Intent(this, AgentSetupActivity::class.java)
            startActivity(agentSetupIntent)
        }
    }
}