import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ecotrackapp.R

class ProductoAdapter(
    private val productos: List<Producto>,
    private val onProductoClick: (Producto) -> Unit
) : RecyclerView.Adapter<ProductoAdapter.ProductoViewHolder>() {

    class ProductoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageProducto: ImageView = itemView.findViewById(R.id.imageProducto)
        val textNombre: TextView = itemView.findViewById(R.id.textNombre)
        val textPuntos: TextView = itemView.findViewById(R.id.textPuntos)
        val buttonAgregar: ImageButton = itemView.findViewById(R.id.buttonAgregar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_login, parent, false)
        return ProductoViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductoViewHolder, position: Int) {
        val producto = productos[position]
        holder.imageProducto.setImageResource(producto.imagen)
        holder.textNombre.text = producto.nombre
        holder.textPuntos.text = producto.puntos.toString()

        holder.buttonAgregar.setOnClickListener {
            onProductoClick(producto)
        }
    }

    override fun getItemCount() = productos.size
}
