package com.example.ecotrackapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class RedimirActivity : AppCompatActivity() {

    private lateinit var containerRewards: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_redimir)

        val backButton = findViewById<ImageView>(R.id.backButton)
        containerRewards = findViewById(R.id.containerRewards)

        backButton.setOnClickListener {
            finish()
        }

        // Agregar tarjetas de ejemplo
        agregarRecompensa("Netflix", "10,000 Puntos", R.drawable.netflix)
        agregarRecompensa("Helado gourmet Popsy", "10,000 Puntos", R.drawable.popsy)
        agregarRecompensa("Cine", "10,000 Puntos", R.drawable.cinema)
        agregarRecompensa("Mía", "10,000 Puntos", R.drawable.mia)
    }

    private fun agregarRecompensa(nombre: String, puntos: String, imagenResId: Int) {
        val card = layoutInflater.inflate(R.layout.item_reward_card, containerRewards, false)

        val imagen = card.findViewById<ImageView>(R.id.ivImagen)
        val titulo = card.findViewById<TextView>(R.id.tvTitulo)
        val puntosTexto = card.findViewById<TextView>(R.id.tvPuntos)
        val boton = card.findViewById<Button>(R.id.btnCanjear)

        imagen.setImageResource(imagenResId)
        titulo.text = nombre
        puntosTexto.text = puntos

        boton.setOnClickListener {
            val intent = Intent(this, DetailRewardActivity::class.java)

            // Si quieres enviar datos como nombre, puntos e imagen:
            intent.putExtra("rewardName", "Nombre del premio")
            intent.putExtra("rewardPoints", "10000")
            intent.putExtra("rewardImage", R.drawable.netflix)

            startActivity(intent)
        }


        containerRewards.addView(card)
    }
}
