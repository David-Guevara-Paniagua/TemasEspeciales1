package mx.unam.aragon.ico.librosmariadb.repositorios;

import mx.unam.aragon.ico.librosmariadb.entidades.Libro;
import org.springframework.data.repository.CrudRepository;

public interface LibroRepository extends CrudRepository<Libro, Integer> {
}
