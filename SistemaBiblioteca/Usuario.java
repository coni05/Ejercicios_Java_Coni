package SistemaBiblioteca;
import java.util.ArrayList;

public class Usuario {
    String nombre;
    String idUsuario;
    ArrayList<Libro> librosPrestados;

    public Usuario(String nombre, String idUsuario) {
        this.nombre = nombre;
        this.idUsuario = idUsuario;
        this.librosPrestados = new ArrayList<Libro>();
    }

    public void mostrarDatos() {
        System.out.println("Nombre: " + nombre + ", ID: " + idUsuario + 
        ", Libros prestados: " + librosPrestados.size());
    }

    public void agregarPrestamo(Libro libro) {
        if (librosPrestados.size() < 3) {
            librosPrestados.add(libro);
        } else {
            System.out.println("El usuario ya tiene 3 libros prestados.");
        }
    }

    public void devolverLibro(Libro libro) {
    if (librosPrestados.contains(libro)) {
        librosPrestados.remove(libro);
        System.out.println("El libro fue devuelto con éxito.");
    } else {
        System.out.println("Ese libro ya había sido entregado o no estaba prestado.");
    }
}

 
}
