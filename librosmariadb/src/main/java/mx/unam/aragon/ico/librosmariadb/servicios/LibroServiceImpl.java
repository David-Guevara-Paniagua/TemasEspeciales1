package mx.unam.aragon.ico.librosmariadb.servicios;

import jakarta.validation.Valid;
import mx.unam.aragon.ico.librosmariadb.entidades.Libro;
import mx.unam.aragon.ico.librosmariadb.repositorios.LibroRepository;
import mx.unam.aragon.ico.librosmariadb.servicios.interfaces.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class LibroServiceImpl implements LibroService {
    @Autowired
    private LibroRepository libroRepository;

    @Override
    public ArrayList<Libro> obtenerTodos() {
        ArrayList<Libro> libros = new ArrayList<>();
        libroRepository.findAll().forEach(libros::add);
        return libros;
    }

    @Override
    public Libro obtenerPorId(int id) {
        return libroRepository.findById(id).orElse(null);
    }

    @Override
    public Libro guardar(Libro libro) {
        libroRepository.save(libro);
        return libro;
    }

    @Override
    public Libro acutalizarCompleto(int id, Libro libro) {
        libro.setId(id);
        return libroRepository.save(libro);
    }

    @Override
    public Libro actualizarParcial(int id, Libro libro) {
        Libro libroExistente = libroRepository.findById(id).orElse(null);
        if (libro.getTitulo() != null) {
            libroExistente.setTitulo(libro.getTitulo());
        }
        if (libro.getAutor() != null) {
            libroExistente.setAutor(libro.getAutor());
        }
        if (libro.getEdictorial() != null) {
            libroExistente.setEdictorial(libro.getEdictorial());
        }
        if (libro.getCorreo() != null) {
            libroExistente.setCorreo(libro.getCorreo());
        }
        if (libro.getPrecio() > 0) {
            libroExistente.setPrecio(libro.getPrecio());
        }
        if (libro.getGenero() != null) {
            libroExistente.setGenero(libro.getGenero());
        }
        return libroRepository.save(libroExistente);
    }
    public void eliminar(int id){
        Libro libro = libroRepository.findById(id).orElse(null);
        libroRepository.delete(libro);
    }
}
