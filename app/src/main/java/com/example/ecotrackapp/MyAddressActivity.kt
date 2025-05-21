package com.example.ecotrackapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast

class MyAddressActivity : AppCompatActivity() {

    // Declaramos variables para los campos
    private lateinit var backButton: ImageView
    private lateinit var nameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var phoneEditText: EditText
    private lateinit var addressEditText: EditText
    private lateinit var postalCodeEditText: EditText
    private lateinit var cityEditText: EditText
    private lateinit var countryEditText: EditText
    private lateinit var saveAddressSwitch: Switch
    private lateinit var addAddressButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_address)

        backButton = findViewById(R.id.backButton)
        backButton.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
        // Asociamos los views
        nameEditText = findViewById(R.id.nameEditText)
        emailEditText = findViewById(R.id.emailEditText)
        phoneEditText = findViewById(R.id.phoneEditText)
        addressEditText = findViewById(R.id.addressEditText)
        postalCodeEditText = findViewById(R.id.postalCodeEditText)
        cityEditText = findViewById(R.id.cityEditText)
        countryEditText = findViewById(R.id.countryEditText)
        saveAddressSwitch = findViewById(R.id.saveAddressSwitch)
        addAddressButton = findViewById(R.id.addAddressButton)

        // Acción cuando el usuario presione "Agregar dirección"
        addAddressButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val email = emailEditText.text.toString()
            val phone = phoneEditText.text.toString()
            val address = addressEditText.text.toString()
            val postalCode = postalCodeEditText.text.toString()
            val city = cityEditText.text.toString()
            val country = countryEditText.text.toString()
            val saveAddress = saveAddressSwitch.isChecked

            Toast.makeText(
                this,
                "Nombre: $name\nEmail: $email\nTel: $phone\nDirección: $address\nCódigo Postal: $postalCode\nCiudad: $city\nPaís: $country\nGuardar: $saveAddress",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}
