package com.example.ecotrackapp

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.ecotrackapp.R

class RecicladoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reciclado) // Asegúrate que este es el XML correcto


        // Navegación inferior
       // val btnInicio = findViewById<ImageView>(R.id.ic_inicio)
       // val btnEscanear = findViewById<ImageView>(R.id.ic_reciclado)
        //val btnPuntos = findViewById<ImageView>(R.id.iconoPuntos)
        //val btnPerfil = findViewById<ImageView>(R.id.iconoPerfil)

        //btnInicio.setOnClickListener {
            // Ir a pantalla de inicio
            finish() // Si Reciclado fue abierto desde Inicio
        //}

        //btnEscanear.setOnClickListener {
            // Abre EscanearActivity
            // startActivity(Intent(this, EscanearActivity::class.java))
       // }

        //btnPuntos.setOnClickListener {
            // Abre PuntosActivity
            // startActivity(Intent(this, PuntosActivity::class.java))
        //}

        //btnPerfil.setOnClickListener {
            // Abre PerfilActivity
            // startActivity(Intent(this, PerfilActivity::class.java))
        //}
    }
}
