package com.example.ecotrackapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.ecotrackapp.databinding.ActivityVersionBinding

class VersionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityVersionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVersionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configurar la Toolbar para manejar el botón de regreso
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.toolbar.setNavigationOnClickListener {
            val intent = Intent(this, CuentaActivity::class.java)
            startActivity(intent)
        }

    }
}
