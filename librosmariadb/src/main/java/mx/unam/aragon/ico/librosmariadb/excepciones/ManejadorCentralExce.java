package mx.unam.aragon.ico.librosmariadb.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class ManejadorCentralExce {

    /*@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public String metodoNoSoportado(HttpRequestMethodNotSupportedException e){
        return "Error: El metodo no es soportado en esta ruta";
    }*/

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<String> metodoNoSoportado(HttpRequestMethodNotSupportedException e) {
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED)
                .body("Error: El método " + e.getMethod() + " no es soportado en esta ruta.");
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<String> recursoNoEncontrado(NoHandlerFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Error: El recurso solicitado no existe (" + e.getRequestURL() + ").");
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<String> errorDeTipo(MethodArgumentTypeMismatchException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Error: El parámetro '" + e.getName() + "' debe ser de tipo " + e.getRequiredType().getSimpleName());
    }

}
