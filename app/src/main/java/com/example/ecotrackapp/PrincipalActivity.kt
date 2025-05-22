package com.example.ecotrackapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class PrincipalActivity : AppCompatActivity(), BottomNavigationActivity.OnButtonClickListener {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

        val btnPuntos = findViewById<ImageView>(R.id.btn_puntos_recoleccion)
        btnPuntos.setOnClickListener {
            val intent = Intent(this, MapsActivity::class.java)
            startActivity(intent)
        }

        /*val btnPapel = findViewById<ImageView>(R.id.btn_papel)
            btnPapel.setOnClickListener {
            val intent = Intent(this, RecicladoActivity::class.java)
            startActivity(intent)
        }*/

        val btnVidrio = findViewById<ImageView>(R.id.btn_vidrio)
        btnVidrio.setOnClickListener {
            val intent = Intent(this, RecicladoActivity::class.java)
            startActivity(intent)
        }

        val btnPlastico = findViewById<ImageView>(R.id.btn_plastico)
        btnPlastico.setOnClickListener {
            val intent = Intent(this, PlasticoActivity::class.java)
            startActivity(intent)
        }

        // Cargar el fragmento de navegación
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
                    startActivity(Intent(this, AccountActivity::class.java))
                    true
                }
                R.id.opcion_membresia -> {
                    startActivity(Intent(this, MemberShipActivity::class.java))
                    true
                }
                else -> false
            }
        }
        popupMenu.show()
    }

}
