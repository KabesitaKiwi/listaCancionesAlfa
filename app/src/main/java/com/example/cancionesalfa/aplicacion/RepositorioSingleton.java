package com.example.cancionesalfa.aplicacion;

import com.example.cancionesalfa.datos.ListaCanciones;
import com.example.cancionesalfa.datos.RepositorioCanciones;

public class RepositorioSingleton {
    private static RepositorioSingleton instancia = new RepositorioSingleton();
    private RepositorioCanciones repo;

    private RepositorioSingleton() {
        repo = new ListaCanciones();
        repo.cargarEjemplos();
    }

    public RepositorioCanciones getRepo() {
        return repo;
    }

    public static RepositorioSingleton getInstancia() {
        return instancia;
    }
}
