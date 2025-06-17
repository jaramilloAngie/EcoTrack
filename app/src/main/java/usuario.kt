data class Usuario(
    val id: Int?,
    val nombre: String,
    val contraseña: String,
    val genero: String?,
    val celular: String?,
    val correo_electronico: String,
    val ciudad: String?,
    val puntos: Int = 0,
    val fecha_creacion: String?  // Puedes usar String para fecha en formato ISO o Date si haces parsing
)
