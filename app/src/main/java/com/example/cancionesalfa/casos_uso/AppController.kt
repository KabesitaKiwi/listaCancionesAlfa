package com.example.cancionesalfa.casos_uso

import android.content.Context
import android.content.Intent
import com.example.cancionesalfa.AcercaDe

class AppController (val contexto : Context){

    fun lanzarAcercaDe(){
        val intent = Intent(contexto, AcercaDe::class.java)
        contexto.startActivity(intent)
    }

}