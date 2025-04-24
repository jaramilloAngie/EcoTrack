package com.example.ecotrackapp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.ecotrackapp.databinding.ActivityMemberShipBinding

class MemberShipActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMemberShipBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Usamos ViewBinding para evitar usar findViewById
        binding = ActivityMemberShipBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupNavigation()
    }

    private fun setupNavigation() {
        // Flecha de regreso
        binding.backArrow.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

    }



}
