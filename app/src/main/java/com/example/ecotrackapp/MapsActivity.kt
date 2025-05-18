package com.example.ecotrackapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.osmdroid.config.Configuration
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker

class MapsActivity : AppCompatActivity() {

    private lateinit var map: MapView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Configuration.getInstance().load(applicationContext, getSharedPreferences("osmdroid", MODE_PRIVATE))
        setContentView(R.layout.activity_maps)

        map = findViewById(R.id.map)
        map.setTileSource(TileSourceFactory.MAPNIK)
        map.setMultiTouchControls(true)

        val mapController = map.controller
        mapController.setZoom(15.0)

        val startPoint = org.osmdroid.util.GeoPoint(4.0865, -76.1953) // Universidad del Valle - Tuluá
        mapController.setCenter(startPoint)

        // Puntos de recolección (simulados)
        val puntos = listOf(
            org.osmdroid.util.GeoPoint(4.0865, -76.1953), // Universidad del Valle
            org.osmdroid.util.GeoPoint(4.0880, -76.1940), // Parque Bolívar
            org.osmdroid.util.GeoPoint(4.0840, -76.1910), // Estación de Bombero
            org.osmdroid.util.GeoPoint(4.0900, -76.1965),
            org.osmdroid.util.GeoPoint(4.0855, -76.1930)

        )

        for ((index, p) in puntos.withIndex()) {
            val marker = Marker(map)
            marker.position = p
            marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
            marker.title = "Punto de recolección ${index + 1}"
            marker.snippet = "Aquí puedes dejar reciclaje"
            marker.setIcon(getDrawable(R.drawable.ic_location_gris)) // Tu propio ícono si lo deseas
            map.overlays.add(marker)
        }
    }

    override fun onResume() {
        super.onResume()
        map.onResume()
    }

    override fun onPause() {
        super.onPause()
        map.onPause()
    }
}
