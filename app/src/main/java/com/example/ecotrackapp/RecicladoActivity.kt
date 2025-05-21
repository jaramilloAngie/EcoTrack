package com.example.ecotrackapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RecicladoActivity : AppCompatActivity(), BottomNavigationActivity.OnButtonClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reciclado)

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
                Toast.makeText(this, "Ya estás en Reciclado", Toast.LENGTH_SHORT).show()
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
