package com.example.ecotrackapp

import Usuario
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignInActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val btnSignIn = findViewById<AppCompatButton>(R.id.sign_in_button)
        val spinnerCity = findViewById<Spinner>(R.id.city_spinner)
        val spinnerGender = findViewById<Spinner>(R.id.gender_spinner)

        val etNombre = findViewById<EditText>(R.id.name_input)
        val etContrasena = findViewById<EditText>(R.id.password_input)
        val etCelular = findViewById<EditText>(R.id.phone_input)
        val etCorreo = findViewById<EditText>(R.id.email_adress_input)

        // Setup spinners
        val ciudades = listOf("Ciudad", "Tuluá", "Cali", "Medellín")
        val adapter = ArrayAdapter(this, R.layout.spinner_item, ciudades)
        adapter.setDropDownViewResource(R.layout.spinner_item)
        spinnerCity.adapter = adapter

        val genders = listOf("Genero", "Masculino", "Femenino")
        val adapterGender = ArrayAdapter(this, R.layout.spinner_item, genders)
        adapterGender.setDropDownViewResource(R.layout.spinner_item)
        spinnerGender.adapter = adapterGender

        btnSignIn.setOnClickListener {
            val nombre = etNombre.text.toString().trim()
            val contrasena = etContrasena.text.toString().trim()
            val celular = etCelular.text.toString().trim()
            val correo = etCorreo.text.toString().trim()
            val ciudad = spinnerCity.selectedItem.toString().trim()
            val genero = spinnerGender.selectedItem.toString().trim()

            // Validar campos obligatorios
            if (nombre.isEmpty() || contrasena.isEmpty() || correo.isEmpty()) {
                Toast.makeText(this, "Completa los campos obligatorios", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val ciudadFinal = if (ciudad == "Ciudad") null else ciudad
            val generoFinal = if (genero == "Genero") null else genero

            val nuevoUsuario = Usuario(
                id = null,
                nombre = nombre,
                contraseña = contrasena,
                genero = generoFinal,
                celular = if (celular.isEmpty()) null else celular,
                correo_electronico = correo,
                ciudad = ciudadFinal,
                puntos = 0,
                fecha_creacion = null
            )

            registrarUsuario(nuevoUsuario)
        }
    }

    private fun registrarUsuario(usuario: Usuario) {
        Log.d("REGISTRO", "Intentando registrar usuario: $usuario")

        ApiClient.retrofit.agregarUsuario(usuario).enqueue(object : Callback<Usuario> {
            override fun onResponse(call: Call<Usuario>, response: Response<Usuario>) {
                Log.d("REGISTRO", "Respuesta recibida")

                if (response.isSuccessful) {
                    Toast.makeText(
                        this@SignInActivity,
                        "Usuario registrado exitosamente",
                        Toast.LENGTH_SHORT
                    ).show()
                    val intent = Intent(this@SignInActivity, LoginActivity::class.java)
                    startActivity(intent)
                    finish() // Opcional: evita que el usuario vuelva atrás con el botón "Atrás"

                    Log.d("REGISTRO", "Usuario agregado: ${response.body()}")
                } else {
                    val errorBody = response.errorBody()?.string()
                    Log.e("REGISTRO", "Error al registrar: $errorBody")
                    Toast.makeText(
                        this@SignInActivity,
                        "Error al registrar usuario",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(call: Call<Usuario>, t: Throwable) {
                Log.e("REGISTRO", "Fallo en la conexión: ${t.message}")
                Toast.makeText(
                    this@SignInActivity,
                    "Fallo en la conexión: ${t.message}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }
}