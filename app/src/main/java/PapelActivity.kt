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

class PapelActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ProductoAdapter
    private lateinit var fabCarrito: FloatingActionButton
    private lateinit var bottomNavigationView: BottomNavigationView

    private var carritoCantidad = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.papel_activity)

        // Inicializar views
        recyclerView = findViewById(R.id.recyclerViewProductos)
        fabCarrito = findViewById(R.id.fabCarrito)
        bottomNavigationView = findViewById(R.id.bottomNavigationView)

        // Configurar RecyclerView
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        val listaProductos = listOf(
            Producto("Periódico", 100, R.drawable.ic_periodico),
            Producto("Hojas de papel", 30, R.drawable.ic_hojasdepapel),
            Producto("Caja de cartón", 100, R.drawable.ic_caja),
            Producto("Cubeta de huevos", 40, R.drawable.ic_cubetahuevos),
            Producto("Bolsa de papel", 30, R.drawable.ic_bolsapapel),
            Producto("vaso de cartón", 30, R.drawable.ic_vasocarton),
            Producto("Empaque de leche", 30, R.drawable.ic_empaqueleche)

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