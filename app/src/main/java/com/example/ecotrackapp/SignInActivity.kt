package com.example.ecotrackapp

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Spinner
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
        val ciudades = listOf("  Ciudad", "  Tuluá", "  Cali", "  Medellín")
        val adapter = ArrayAdapter(this, R.layout.spinner_item, ciudades)
        adapter.setDropDownViewResource(R.layout.spinner_item)
        val spinner = findViewById<Spinner>(R.id.city_spinner)
        spinner.adapter = adapter

        val genders = listOf("  Genero", "  Masculino", "  Femenino")
        val adapterGender = ArrayAdapter(this, R.layout.spinner_item, genders)
        adapterGender.setDropDownViewResource(R.layout.spinner_item)
        val spinnerGender = findViewById<Spinner>(R.id.gender_spinner)
        spinnerGender.adapter = adapterGender
    }
}
