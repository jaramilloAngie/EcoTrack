import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @GET("usuarios")
    fun obtenerUsuarios(): Call<List<Usuario>>

    @POST("usuarios")
    fun agregarUsuario(@Body usuario: Usuario): Call<Usuario>
}
