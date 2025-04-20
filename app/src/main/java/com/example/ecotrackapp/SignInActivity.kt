package com.example.ecotrackapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton

class SignInActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        val btnSignIn = findViewById<AppCompatButton>(R.id.sign_in_button)
        btnSignIn.setOnClickListener{
            Log.i("EcoTrack", "Sign in button clicked")
        }
    }
}
