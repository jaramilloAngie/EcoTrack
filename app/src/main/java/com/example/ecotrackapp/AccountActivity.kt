package com.example.ecotrackapp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AccountActivity : AppCompatActivity(), BottomNavigationActivity.OnButtonClickListener {

    private lateinit var acercaDeMi: LinearLayout
    private lateinit var membresia: LinearLayout
    private lateinit var miDireccion: LinearLayout
    private lateinit var version: LinearLayout
    private lateinit var signOut: LinearLayout
    private lateinit var backButton: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)

        // Referencias a los LinearLayout de cada opción
        val listaOpciones = findViewById<LinearLayout>(R.id.listaOpciones)

        acercaDeMi = listaOpciones.getChildAt(1) as LinearLayout
        membresia = listaOpciones.getChildAt(2) as LinearLayout
        miDireccion = listaOpciones.getChildAt(3) as LinearLayout
        version = listaOpciones.getChildAt(4) as LinearLayout
        signOut = listaOpciones.getChildAt(5) as LinearLayout
        backButton = findViewById(R.id.btnBack)
        backButton.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        // Configuramos los listeners para cada opción
        acercaDeMi.setOnClickListener {
            val intent = Intent(this, AboutMeActivity::class.java)
            startActivity(intent)
        }

        membresia.setOnClickListener {
            val intent = Intent(this,AboutMeActivity::class.java)
            startActivity(intent)
        }

        miDireccion.setOnClickListener {
            val intent = Intent(this, MyAddressActivity::class.java)
            startActivity(intent)
        }

        version.setOnClickListener {
            val intent = Intent(this, VersionActivity::class.java)
            startActivity(intent)
        }

        signOut.setOnClickListener {
            // Aquí puedes hacer la lógica de cerrar sesión
            Toast.makeText(this, "Sesión cerrada", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, SignInActivity::class.java) // O a donde quieras que regrese el usuario
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }



    }

    override fun onButtonClicked(screen: Int) {
        when (screen) {
            1 -> {
                startActivity(Intent(this, PrincipalActivity::class.java))
                finish()
            }
            2 -> {
                startActivity(Intent(this, RecicladoActivity::class.java))
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
        supportFragmentManager.beginTransaction()
            .replace(R.id.bottomNavContainer, BottomNavigationActivity())
            .commit()
    }

}


