package com.example.prract16

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.ImageButton


class ProfileActivity : AppCompatActivity() {
    private lateinit var RegisterButton: Button
    private lateinit var LoginButton: Button
    private lateinit var BackButton: ImageButton
    private lateinit var Avatar: ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        RegisterButton = findViewById(R.id.button_register)
        LoginButton = findViewById(R.id.button_login)
        BackButton = findViewById(R.id.back_button)
        Avatar = findViewById(R.id.avatar)

        RegisterButton.setOnClickListener{
            val intent = Intent(this, UserLoginAcrivity::class.java)
            startActivity(intent)
        }

        LoginButton.setOnClickListener {
            val intent = Intent(this, EditTaskActivity::class.java)
            startActivity(intent)
        }

        BackButton.setOnClickListener{
            this.finishAffinity();
        }

        Avatar.setOnClickListener{
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://classroom.google.com/u/0/c/NTI3MjA2OTkxNDY5/a/NjAzMjkzODcxNzg1/details")
            startActivity(openURL)
        }

    }

}