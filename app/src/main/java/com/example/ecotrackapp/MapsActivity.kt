package com.example.ecotrackapp

import Usuario
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
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
            org.osmdroid.util.GeoPoint(4.0706, -76.1902), // Universidad del Valle
            org.osmdroid.util.GeoPoint(4.0858, -76.1971), // Parque Bolívar
            org.osmdroid.util.GeoPoint(4.0863, -76.1951) // Estación de Bomberos


        )

        for ((index, p) in puntos.withIndex()) {
            val marker = Marker(map)
            marker.position = p
            marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
            marker.title = "Punto de recolección ${index + 1}"
            marker.snippet = "Aquí puedes dejar reciclaje"
            marker.setIcon(ContextCompat.getDrawable(this, R.drawable.ic_location_gris))
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
