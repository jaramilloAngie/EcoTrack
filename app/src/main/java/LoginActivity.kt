package com.tuapp.ecotrack

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val emailEditText = findViewById<EditText>(R.id.emailEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
        val loginButton = findViewById<Button>(R.id.loginButton)
        val forgotPasswordText = findViewById<TextView>(R.id.forgotPasswordText)
        val registerButton = findViewById<Button>(R.id.registerButton)

        loginButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                // Aquí pondrías la lógica para iniciar sesión
                Toast.makeText(this, "Iniciando sesión...", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Por favor ingresa tus datos", Toast.LENGTH_SHORT).show()
            }
        }

        forgotPasswordText.setOnClickListener {
            // Aquí abres pantalla para recuperar contraseña
            Toast.makeText(this, "Función Olvide mi contraseña", Toast.LENGTH_SHORT).show()
        }

        registerButton.setOnClickListener {
            // Aquí abres pantalla para registrarse
            Toast.makeText(this, "Ir a pantalla de registro", Toast.LENGTH_SHORT).show()
        }
    }
}
