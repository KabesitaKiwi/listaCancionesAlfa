package com.example.cancionesalfa

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cancionesalfa.Modelo.Cancion
import com.example.cancionesalfa.aplicacion.RepositorioSingleton
import com.example.cancionesalfa.casos_uso.AppController


class VistaCancion : AppCompatActivity() {

    var id: Int? = null
    lateinit var controlador: AppController
    override fun onCreate(savedInstanceState: Bundle?) {
        controlador = AppController(this)
        id = intent.extras?.getInt("id")
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_vista_cancion)
        setSupportActionBar(findViewById<Toolbar>(R.id.toolbar))
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onResume() {
            super.onResume()
        cargarCancion(
            RepositorioSingleton.getInstancia().repo.elemento(this .id?:0)
        )
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_principal, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        when (id){
            R.id.toolbar_editar -> {
                controlador.editarCancion(this.id?:0)
            }
            R.id.toolbar_eliminar -> {
                val posicionParaBorrar = this.id

                if (posicionParaBorrar != null) {
                    RepositorioSingleton.getInstancia().repo.borrarCancion(posicionParaBorrar)
                    Toast.makeText(this, "Canción eliminada correctamente, reinicie la lista para actualizar", Toast.LENGTH_SHORT).show()
                    finish()
                }
            }

        }
        return true
    }

    fun cargarCancion (c: Cancion){
        findViewById<TextView>(R.id.titulo).text = c.titulo
        findViewById<TextView>(R.id.album).text = c.album
        findViewById<TextView>(R.id.descripcion).text = c.descripcion
        findViewById<RatingBar>(R.id.barraNota).rating = c.valoracion.toFloat()
        val foto = findViewById<ImageView>(R.id.portada)
        foto.setImageResource(c.getImagen())
        val draw = AppCompatResources.getDrawable(this,c.getImagen())
        foto.setImageDrawable(draw)


    }


}