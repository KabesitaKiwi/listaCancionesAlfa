package com.example.cancionesalfa.Modelo

import android.media.Image

data class Cancion(
    var titulo: String = "",
    var album: String="",
    var portada: Afiliacion = Afiliacion.CUATROK,
    var descripcion: String = "",
    var valoracion: Int = 0
){
    fun getImagen(): Int {
        return portada.imagen
    }
}
