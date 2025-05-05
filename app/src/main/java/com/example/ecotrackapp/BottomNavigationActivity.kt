package com.example.ecotrackapp

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class BottomNavigationActivity : Fragment() {

    interface OnButtonClickListener {
        fun onButtonClicked(screen: Int)
    }

    private lateinit var listener: OnButtonClickListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnButtonClickListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement OnButtonClickListener")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.bottom_navigation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<View>(R.id.botonInicio).setOnClickListener {
            listener.onButtonClicked(1)
        }
        view.findViewById<View>(R.id.botonReciclado).setOnClickListener {
            listener.onButtonClicked(2)
        }
        view.findViewById<View>(R.id.botonRedimir).setOnClickListener {
            listener.onButtonClicked(3)
        }
        view.findViewById<View>(R.id.botonPerfil).setOnClickListener {
            listener.onButtonClicked(4)
        }
    }
}
