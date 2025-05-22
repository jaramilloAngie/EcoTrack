package com.example.ecotrackapp

import ProductoAdapter
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.bottomnavigation.BottomNavigationView

class PlasticoActivity : AppCompatActivity(),BottomNavigationActivity.OnButtonClickListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ProductoAdapter
    private lateinit var fabCarrito: FloatingActionButton
    private lateinit var bottomNavigationView: BottomNavigationView

    private var carritoCantidad = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plastico)
        val backButton = findViewById<ImageView>(R.id.backButton)
        backButton.setOnClickListener {
            finish()
        }
        supportFragmentManager.beginTransaction()
            .replace(R.id.bottomNavContainer, BottomNavigationActivity())
            .commit()
    }

    override fun onButtonClicked(screen: Int) {
        when (screen) {
            1 -> {
                startActivity(Intent(this, PrincipalActivity::class.java))
                finish()
            }
            2 -> {
                startActivity(Intent(this, RecicladoActivity ::class.java))
                finish()
            }
            3 -> {
                startActivity(Intent(this, RedimirActivity::class.java))
                finish()
            }
            4 -> {
                startActivity(Intent(this, AccountActivity::class.java))
                finish()
            }
        }
    }
}
