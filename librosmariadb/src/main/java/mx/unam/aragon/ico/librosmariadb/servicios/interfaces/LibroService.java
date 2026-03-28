package mx.unam.aragon.ico.librosmariadb.servicios.interfaces;

import mx.unam.aragon.ico.librosmariadb.entidades.Libro;

import java.util.ArrayList;

public interface LibroService {
    public ArrayList<Libro> obtenerTodos();
    public Libro obtenerPorId(int id);
    public Libro guardar(Libro libro);
    public Libro acutalizarCompleto(int id, Libro libro);
    public Libro actualizarParcial(int id, Libro libro);
}
