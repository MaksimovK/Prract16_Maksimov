package com.example.prract16

import android.R.attr.data
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast


class UserLoginAcrivity : AppCompatActivity() {
    private lateinit var BackButton: ImageButton
    private lateinit var ButtonLogin: Button
    private lateinit var LoginEditText : EditText
    private lateinit var EmailEditText : EditText
    private lateinit var PassEditText : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_login_acrivity)
        BackButton = findViewById(R.id.back_button)
        LoginEditText = findViewById(R.id.login)
        ButtonLogin = findViewById(R.id.button_login)
        EmailEditText = findViewById(R.id.email)
        PassEditText = findViewById(R.id.password)

        BackButton.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }
        ButtonLogin.setOnClickListener {
            if (LoginEditText.text.toString().isEmpty() || EmailEditText.text.toString().isEmpty() || PassEditText.text.toString().isEmpty()) {
                val toast = Toast.makeText(this, R.string.CheckEditText, Toast.LENGTH_SHORT)
                toast.setGravity(Gravity.BOTTOM, 0, 0)
                toast.show()


            }
            else
            {
                val toast = Toast.makeText(this, "Вы зарегистрировались", Toast.LENGTH_SHORT)
                toast.setGravity(Gravity.BOTTOM, 0, 0)
                toast.show()

                val intent = Intent(this, ProfileActivity::class.java)
                startActivity(intent)
            }
        }



    }
}