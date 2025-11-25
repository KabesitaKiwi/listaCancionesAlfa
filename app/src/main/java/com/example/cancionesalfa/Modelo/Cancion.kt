package com.example.cancionesalfa.Modelo

import android.media.Image

data class Cancion(
    var titulo: String = "",
    var album: String="",
    var portada: Int ?=null,
    var descripcion: String = "",
    var valoracion: Int = 0
){

}
