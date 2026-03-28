package mx.unam.aragon.ico.librosmariadb.controladores;

import jakarta.validation.Valid;
import mx.unam.aragon.ico.librosmariadb.entidades.Libro;
import mx.unam.aragon.ico.librosmariadb.servicios.LibroServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/libros")
public class LibrosController {

    @Autowired
    private LibroServiceImpl libroService;

    @GetMapping("/")
    public ResponseEntity<ArrayList<Libro>> index(){
        //libroRepository.save(new Libro("terror",200, "porrua@gmail.com", "porrua", "Gabriel Marquez", "Elcallejon"));
        return ResponseEntity.ok(libroService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity <Libro> getLibro(@PathVariable int id){
        return ResponseEntity.ok(libroService.obtenerPorId(id));
    }

    @PostMapping("/")
    public ResponseEntity <Libro> crearLibro(@Valid @RequestBody Libro libro){
        return ResponseEntity.ok(libroService.guardar(libro));
    }
    @PutMapping("/{id}")
    public ResponseEntity <Libro> actualizarLibro(@PathVariable int id, @RequestBody Libro libro){
        return ResponseEntity.ok(libroService.acutalizarCompleto(id, libro));
    }
    @PatchMapping("/{id}")
    public ResponseEntity <Libro> patchLibro(@PathVariable int id, @RequestBody Libro libro){
        return ResponseEntity.ok(libroService.actualizarParcial(id, libro));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarLibro(@PathVariable int id) {
        libroService.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
