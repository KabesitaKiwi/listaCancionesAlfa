package com.example.cancionesalfa

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cancionesalfa.Modelo.Cancion
import com.example.cancionesalfa.aplicacion.RepositorioSingleton

class editar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_editar)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val titulo = findViewById<EditText>(R.id.editTitulo)
        val album = findViewById<EditText>(R.id.editAlbum)
        val descripcion = findViewById<EditText>(R.id.editDescripcion)
        val barraNota = findViewById<RatingBar>(R.id.editarValoracion)

        val id = intent.extras?.getInt("id")
        if (id != null) {
            val cancionEditar = RepositorioSingleton.getInstancia().repo.elemento(id)
            titulo.setText(cancionEditar.titulo)
            album.setText(cancionEditar.album)
            descripcion.setText(cancionEditar.descripcion)
            barraNota.rating = cancionEditar.valoracion.toFloat()
        }

        findViewById<Button>(R.id.botonGuardar).setOnClickListener {
            if (id != null) {
                val cancioneditar =  RepositorioSingleton.getInstancia().repo.elemento(id)
                cancioneditar.titulo = titulo.text.toString()
                cancioneditar.album = album.text.toString()
                cancioneditar.descripcion = descripcion.text.toString()
                cancioneditar.valoracion = barraNota.rating.toInt()
                RepositorioSingleton.getInstancia().repo.actualizarCancion(id ?: 0, cancioneditar)
                finish()

            }
        }

        findViewById<Button>(R.id.botonCancelar).setOnClickListener {
            finish()
        }

    }
}