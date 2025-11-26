package com.example.cancionesalfa.datos

import com.example.cancionesalfa.Modelo.Cancion

class ListaCanciones : RepositorioCanciones{
    val lista : MutableList<Cancion> = mutableListOf()

    override fun annadeCancion(cancion: Cancion) {
        lista.add(cancion)
    }

    override fun elemento(id: Int): Cancion = lista.get(id)

    override fun borrarCancion(id: Int) {
        lista.removeAt(id)
    }

    override fun actualizarCancion(id: Int, cancion: Cancion) {
        lista[id] = cancion
    }

    override fun tamanno(): Int {
        return lista.size
    }

}