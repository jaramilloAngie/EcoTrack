package com.example.ecotrackapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailRewardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_reward)

        val backButton: ImageView = findViewById(R.id.backButton)
        val rewardImage: ImageView = findViewById(R.id.rewardImage)
        val rewardName: TextView = findViewById(R.id.rewardName)
        val rewardPoints: TextView = findViewById(R.id.rewardPoints)
        val rewardDescription: TextView = findViewById(R.id.rewardDescription)
        val inputNumber: EditText = findViewById(R.id.inputNumber)
        val btnCanjear: Button = findViewById(R.id.btnCanjear)

        // Recibir datos desde el intent
        val name = intent.getStringExtra("rewardName")
        val points = intent.getStringExtra("rewardPoints")
        val imageResId = intent.getIntExtra("rewardImage", 0)

        rewardName.text = name
        rewardPoints.text = "$points Puntos"
        rewardImage.setImageResource(imageResId)

        // Acción de regresar
        backButton.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        // Acción de botón canjear
        btnCanjear.setOnClickListener {
        }
    }
}
