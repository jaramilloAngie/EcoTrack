package com.example.ecotrackapp

import Producto
import ProductoAdapter
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ecotrackapp.AccountActivity
import com.example.ecotrackapp.BottomNavigationActivity
import com.example.ecotrackapp.PrincipalActivity
import com.example.ecotrackapp.R
import com.example.ecotrackapp.RecicladoActivity
import com.example.ecotrackapp.RedimirActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.bottomnavigation.BottomNavigationView

class VidrioActivity : AppCompatActivity(),BottomNavigationActivity.OnButtonClickListener {

    private var carritoCantidad = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vidrio)

        val backButton = findViewById<ImageView>(R.id.backButton)
        backButton.setOnClickListener {
            finish()
        }

        supportFragmentManager.beginTransaction()
            .replace(R.id.bottomNavContainer, BottomNavigationActivity())
            .commit()

        val listaProductos = listOf(
            Producto("Botella Vidrio", 100, R.drawable.ic_botellavidrio),
            Producto("Vasi vidrio", 30, R.drawable.ic_vasovidrio),
            Producto("Espejo", 50, R.drawable.ic_espejo),
            Producto("Jarron", 100, R.drawable.ic_jarron),
            Producto("Bombillo", 30, R.drawable.ic_bombillo),
            Producto("Recipiente de vidrio", 30, R.drawable.ic_recipiente)
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
