package com.example.ecotrackapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.PopupMenu
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

        val menuButton = findViewById<ImageView>(R.id.menuButton)

        menuButton.setOnClickListener {
            val popupMenu = PopupMenu(this, menuButton)
            popupMenu.menuInflater.inflate(R.menu.menu_hamburguesa, popupMenu.menu)

            // Manejo de clics
            popupMenu.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.opcion_cuenta -> {
                        Toast.makeText(this, "Cuenta seleccionada", Toast.LENGTH_SHORT).show()
                        true
                    }
                    R.id.opcion_membresia -> {
                        Toast.makeText(this, "Membresía seleccionada", Toast.LENGTH_SHORT).show()
                        true
                    }
                    else -> false
                }
            }

            popupMenu.show()
        }

    }
}
