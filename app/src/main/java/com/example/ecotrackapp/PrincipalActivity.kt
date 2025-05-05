package com.example.ecotrackapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PrincipalActivity : AppCompatActivity(), BottomNavigationActivity.OnButtonClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

        // Cargar el fragmento de navegación solo una vez
        supportFragmentManager.beginTransaction()
            .replace(R.id.bottom_navigation_container, BottomNavigationActivity())
            .commit()

        val menuButton = findViewById<ImageView>(R.id.button_menu)
        menuButton.setOnClickListener { showPopupMenu(it) }
    }

    override fun onButtonClicked(screen: Int) {
        val intent = when (screen) {
            1 -> Intent(this, PrincipalActivity::class.java)
            2 -> Intent(this, RecicladoActivity::class.java)
            3 -> Intent(this, RedimirActivity::class.java)
            4 -> Intent(this, AccountActivity::class.java)
            else -> null
        }

        intent?.let {
            startActivity(it)
        }
    }

    private fun showPopupMenu(view: View) {
        val popupMenu = PopupMenu(this, view)
        popupMenu.menuInflater.inflate(R.menu.menu_hamburguesa, popupMenu.menu)
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
