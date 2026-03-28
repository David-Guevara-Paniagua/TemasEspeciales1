package mx.unam.aragon.ico.librosmariadb.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "El título no puede estar vacío")
    @Size(min = 2, max = 150, message = "El título debe tener entre 2 y 150 caracteres")
    private String titulo;

    @NotBlank(message = "El autor es obligatorio")
    private String autor;

    @NotBlank(message = "La editorial no puede estar vacía")
    private String edictorial;

    @Column(unique = true)
    @Email(message = "Debe proporcionar un formato de correo válido")
    @NotBlank(message = "El correo es obligatorio")
    private String correo;

    @Min(value = 0, message = "El precio no puede ser negativo")
    private int precio;

    private String genero;

    public Libro() {
    }

    public Libro(String genero, int precio, String correo, String edictorial, String autor, String titulo) {
        this.genero = genero;
        this.precio = precio;
        this.correo = correo;
        this.edictorial = edictorial;
        this.autor = autor;
        this.titulo = titulo;
        //this.id = id;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getEdictorial() {
        return edictorial;
    }

    public void setEdictorial(String edictorial) {
        this.edictorial = edictorial;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", edictorial='" + edictorial + '\'' +
                ", correo='" + correo + '\'' +
                ", precio=" + precio +
                ", genero='" + genero + '\'' +
                '}';
    }
}

