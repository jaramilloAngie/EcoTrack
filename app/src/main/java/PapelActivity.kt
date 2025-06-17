package com.example.ecotrackapp

import Producto
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class PapelActivity : AppCompatActivity(),BottomNavigationActivity.OnButtonClickListener {

    private var carritoCantidad = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_papel)

        val backButton = findViewById<ImageView>(R.id.backButton)
        backButton.setOnClickListener {
            finish()
        }

        supportFragmentManager.beginTransaction()
            .replace(R.id.bottomNavContainer, BottomNavigationActivity())
            .commit()

        val listaProductos = listOf(
            Producto("Periódico", 100, R.drawable.ic_periodico),
            Producto("Hojas de papel", 30, R.drawable.ic_hojasdepapel),
            Producto("Caja de cartón", 100, R.drawable.ic_caja),
            Producto("Cubeta de huevos", 40, R.drawable.ic_cubetahuevos),
            Producto("Bolsa de papel", 30, R.drawable.ic_bolsapapel),
            Producto("vaso de cartón", 30, R.drawable.ic_vasocarton),
            Producto("Empaque de leche", 30, R.drawable.ic_empaqueleche)

        )

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
}