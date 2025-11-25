package com.example.cancionesalfa

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cancionesalfa.casos_uso.AppController

class MainActivity : AppCompatActivity() {
    lateinit var controlador: AppController

    override fun onCreate(savedInstanceState: Bundle?) {
        controlador = AppController(this)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<Button>(R.id.botonAcercaDe).setOnClickListener {
            controlador.lanzarAcercaDe()
        }
    }
}