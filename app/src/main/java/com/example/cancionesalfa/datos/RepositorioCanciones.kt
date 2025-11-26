package com.example.cancionesalfa.datos

import com.example.cancionesalfa.Modelo.Afiliacion
import com.example.cancionesalfa.Modelo.Cancion

interface RepositorioCanciones {
    fun cargarEjemplos(){
        annadeCancion(
            Cancion("4k", "single", Afiliacion.CUATROK, "", 5),
        )
        annadeCancion(
            Cancion("Coronao Now", "Androide", Afiliacion.ANDROIDE, "", 5),
        )
        annadeCancion(
            Cancion("martillando", "el rey del dembow", Afiliacion.ELREYDELDEMBOW, "", 5),
        )
        annadeCancion(
            Cancion("Singapur", "Androide", Afiliacion.ANDROIDE, "", 5),
        )

        annadeCancion(
            Cancion("Panamá", "Sabiduria", Afiliacion.SABIDURIA, "", 5),
        )
        annadeCancion(
            Cancion("Con Silenciador", "El Hombre", Afiliacion.ELHOMBRE, "", 5)
        )
        annadeCancion(
            Cancion("Gogo dance", "Sabiduria", Afiliacion.SABIDURIA, "", 5)
        )
        annadeCancion(
            Cancion("Sientate en ese deo", "El hombre", Afiliacion.ELHOMBRE, "", 5)
        )
        annadeCancion(
            Cancion("Suave Remix", "El Hombre", Afiliacion.ELHOMBRE, "", 5)
        )
        annadeCancion(
            Cancion("Bésalo", "Androide", Afiliacion.ANDROIDE, "", 5),
        )
        annadeCancion(
            Cancion("Curazao", "Sagitario", Afiliacion.SAGITARIO, "", 5),
        )

    }
    fun annadeCancion(cancion: Cancion)
    fun elemento(ud: Int): Cancion
    fun borrarCancion(id: Int)
    fun actualizarCancion(id: Int, cancion: Cancion)
    fun tamanno(): Int


}