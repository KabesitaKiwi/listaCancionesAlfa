package com.example.cancionesalfa

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cancionesalfa.Modelo.Afiliacion
import com.example.cancionesalfa.Modelo.Cancion
import com.example.cancionesalfa.aplicacion.RepositorioSingleton

class AnadirCancion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_anadir_cancion)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val etTitulo = findViewById<EditText>(R.id.et_titulo)
        val etAutor = findViewById<EditText>(R.id.et_autor)
        val btnGuardar = findViewById<Button>(R.id.btn_guardar_cancion)

        btnGuardar.setOnClickListener {
            val titulo = etTitulo.text.toString()
            val autor = etAutor.text.toString()

            if (titulo.isEmpty() || autor.isEmpty()) {
                Toast.makeText(this, "Faltan datos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val nuevaCancion = Cancion(
                titulo,
                autor,
                Afiliacion.CUATROK,
                "",
                0
            )
            RepositorioSingleton.getInstancia().repo.annadeCancion(nuevaCancion)

            Toast.makeText(this, "Canción guardada", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}