package com.example.cancionesalfa.casos_uso

import android.content.Context
import android.content.Intent
import com.example.cancionesalfa.AcercaDe
import com.example.cancionesalfa.AnadirCancion
import com.example.cancionesalfa.ListaActivity
import com.example.cancionesalfa.VistaCancion
import com.example.cancionesalfa.datos.ListaCanciones
import com.example.cancionesalfa.editar

class AppController (val contexto : Context){

    fun lanzarAcercaDe(){
        val intent = Intent(contexto, AcercaDe::class.java)
        contexto.startActivity(intent)
    }

    fun lanzarLista(){
        val intent = Intent(contexto, ListaActivity::class.java)
        contexto.startActivity(intent)
    }

    fun lanzarCancion(id: Int){
        val intent = Intent(contexto, VistaCancion::class.java)
        intent.putExtra("id",id)
        contexto.startActivity(intent)
    }

    fun editarCancion(id: Int){
        val intent = Intent(contexto, editar::class.java)
        intent.putExtra("id",id)
        contexto.startActivity(intent)
    }

    fun annadirCancion(){
        val intent = Intent(contexto, AnadirCancion::class.java)
        contexto.startActivity(intent)
    }
}



