package com.example.ecotrackapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ecotrackapp.databinding.ActivityMemberShipBinding

class MemberShipActivity : AppCompatActivity(), BottomNavigationActivity.OnButtonClickListener {

    private lateinit var binding: ActivityMemberShipBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicializar ViewBinding
        binding = ActivityMemberShipBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configurar botón de retroceso
        setupNavigation()

        // Fragmento de navegación inferior
        supportFragmentManager.beginTransaction()
            .replace(R.id.bottom_navigation_container, BottomNavigationActivity())
            .commit()
    }

    // Manejo de clics desde la navegación inferior
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
    }

    // Configurar la flecha de retroceso
    private fun setupNavigation() {
        binding.backArrow.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}
