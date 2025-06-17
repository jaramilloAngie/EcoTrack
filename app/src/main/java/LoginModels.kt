package com.example.ecotrackapp

import Usuario
import com.google.gson.annotations.SerializedName


data class LoginRequest(
    @SerializedName("correo_electronico")
    val correoElectronico: String,

    @SerializedName("contraseña")
    val contrasena: String
)

data class LoginResponse(
    val success: Boolean,
    val message: String? = null,
    val user: Usuario? = null
)
