package com.tuapp.reciclaje

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.bottomnavigation.BottomNavigationView

class PlasticoActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ProductoAdapter
    private lateinit var fabCarrito: FloatingActionButton
    private lateinit var bottomNavigationView: BottomNavigationView

    private var carritoCantidad = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.plastico_activity)

        // Inicializar views
        recyclerView = findViewById(R.id.recyclerViewProductos)
        fabCarrito = findViewById(R.id.fabCarrito)
        bottomNavigationView = findViewById(R.id.bottomNavigationView)

        // Configurar RecyclerView
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        val listaProductos = listOf(
            Producto("Botella Plástica", 100, R.drawable.botella),
            Producto("Empaque de papas", 30, R.drawable.empaque_papas),
            Producto("Bolsa plástica", 50, R.drawable.bolsa),
            Producto("Producto de limpieza", 100, R.drawable.limpieza),
            Producto("Tapas", 30, R.drawable.tapas),
            Producto("Vasos", 30, R.drawable.vaso)
        )

        adapter = ProductoAdapter(listaProductos) { producto ->
            agregarProductoAlCarrito(producto)
        }
        recyclerView.adapter = adapter

        // FAB carrito click
        fabCarrito.setOnClickListener {
            // Aquí puedes abrir una pantalla de resumen del carrito
        }

        // Navegación inferior
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_inicio -> {
                    // Ir a Inicio
                    true
                }
                R.id.menu_reciclado -> {
                    // Ir a Reciclado
                    true
                }
                R.id.menu_redimir -> {
                    // Ir a Redimir
                    true
                }
                R.id.menu_perfil -> {
                    // Ir a Perfil
                    true
                }
                else -> false
            }
        }
    }

    private fun agregarProductoAlCarrito(producto: Producto) {
        carritoCantidad++
        fabCarrito.setImageResource(R.drawable.ic_cart_con_numero) // Puedes personalizar para mostrar cantidad
    }
}
