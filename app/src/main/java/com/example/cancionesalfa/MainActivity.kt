package com.example.cancionesalfa

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cancionesalfa.aplicacion.RepositorioSingleton
import com.example.cancionesalfa.casos_uso.AppController

class MainActivity : AppCompatActivity() {
    lateinit var controlador: AppController

    override fun onCreate(savedInstanceState: Bundle?) {
        controlador = AppController(this)
        val lista = RepositorioSingleton.getInstancia().repo
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

        findViewById<Button>(R.id.botonVerLista).setOnClickListener {
            controlador.lanzarLista()
        }
        findViewById<Button>(R.id.botonVerCancionAleatoria).setOnClickListener {
            val rand = (Math.random()*lista.tamanno()).toInt()
            controlador.lanzarCancion(rand)
        }
        findViewById<Button>(R.id.btonEditar).setOnClickListener {
            dialogoElegir(true)

        }
        findViewById<Button>(R.id.botonAnadir).setOnClickListener {
            controlador.annadirCancion()
        }


    }
    fun dialogoElegir(editar: Boolean) {
        val entrada = EditText(this)
        entrada.inputType = InputType.TYPE_CLASS_NUMBER
        AlertDialog.Builder(this)
            .setTitle("Elige un elemento")
            .setMessage("Elige un elemento")
            .setView(entrada)
            .setPositiveButton("Buscar") { dialog, which ->
                val id = Integer.parseInt(entrada.text.toString())
                if (editar) {
                    controlador.editarCancion(id)
                } else {
                    controlador.lanzarCancion(id)
                }
            }
            .setNegativeButton("Cancelar", null)
            .show()
    }
}