package com.example.ecotrackapp

import android.os.Bundle
import android.text.InputType
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class AboutMeActivity : AppCompatActivity() {

    private lateinit var backButton: ImageView
    private lateinit var saveButton: Button
    private lateinit var toggleNewPasswordVisibility: ImageView
    private lateinit var newPasswordEditText: EditText

    private var isPasswordVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_me)

        // Referencias
        backButton = findViewById(R.id.backButton)
        saveButton = findViewById(R.id.saveButton)
        toggleNewPasswordVisibility = findViewById(R.id.toggleNewPasswordVisibility)
        newPasswordEditText = findViewById(R.id.newPasswordEditText)

        // Acción del botón "Atrás"
        backButton.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        // Alternar visibilidad de la contraseña nueva
        toggleNewPasswordVisibility.setOnClickListener {
            togglePasswordVisibility()
        }

        // Guardar configuración
        saveButton.setOnClickListener {
            Toast.makeText(this, getString(R.string.save_configuration), Toast.LENGTH_SHORT).show()
            // Aquí podrías también guardar la nueva contraseña si implementas la lógica
        }
    }

    private fun togglePasswordVisibility() {
        if (isPasswordVisible) {
            // Ocultar contraseña
            newPasswordEditText.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            toggleNewPasswordVisibility.setImageResource(R.drawable.ic_visibility)
        } else {
            // Mostrar contraseña
            newPasswordEditText.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
            toggleNewPasswordVisibility.setImageResource(R.drawable.ic_visibility)
        }
        // Mover el cursor al final
        newPasswordEditText.setSelection(newPasswordEditText.text.length)
        isPasswordVisible = !isPasswordVisible
    }
}
