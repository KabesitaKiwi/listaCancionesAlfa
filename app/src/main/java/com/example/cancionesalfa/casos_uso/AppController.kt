package com.example.cancionesalfa.casos_uso

import android.content.Context
import android.content.Intent
import com.example.cancionesalfa.AcercaDe
import com.example.cancionesalfa.ListaActivity
import com.example.cancionesalfa.datos.ListaCanciones

class AppController (val contexto : Context){

    fun lanzarAcercaDe(){
        val intent = Intent(contexto, AcercaDe::class.java)
        contexto.startActivity(intent)
    }

    fun VistaCancion(id: Int){
        val intent = Intent(contexto, AcercaDe::class.java)
        intent.putExtra("id",id)
        contexto.startActivity(intent)
    }

    fun lanzarLista(){
        val intent = Intent(contexto, ListaActivity::class.java)
        contexto.startActivity(intent)
    }


}