package com.example.ecotrackapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PrincipalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal) // Asegúrate de que el nombre sea correcto

        // Ejemplo de cómo usar los botones del menú inferior
        val homeButton = findViewById<ImageView>(R.id.menuButton)
        homeButton.setOnClickListener {
            Toast.makeText(this, "Menú abierto", Toast.LENGTH_SHORT).show()
        }
    }
}
