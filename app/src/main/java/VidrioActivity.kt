package com.tuapp.reciclaje

import Producto
import ProductoAdapter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ecotrackapp.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.bottomnavigation.BottomNavigationView

class VidrioActivity : AppCompatActivity() {

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
            Producto("Botella Vidrio", 100, R.drawable.ic_botellavidrio),
            Producto("Vasi vidrio", 30, R.drawable.ic_vasovidrio),
            Producto("Espejo", 50, R.drawable.ic_espejo),
            Producto("Jarron", 100, R.drawable.ic_jarron),
            Producto("Bombillo", 30, R.drawable.ic_bombillo),
            Producto("Recipiente de vidrio", 30, R.drawable.ic_recipiente)
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
