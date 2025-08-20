package SistemaBiblioteca;

public class Libro {
    String titulo;
    String autor;
    String codigo;
    boolean disponible;

    public Libro(String titulo, String autor, String codigo) {
        this.titulo = titulo;
        this.autor = autor;
        this.codigo = codigo;
        this.disponible = true; // cuando se crea está disponible
    }

    public void mostrarDatos() {
        System.out.println("Título: " + titulo + ", Autor: " + autor + ", Código: " + codigo + ", Disponible: " + disponible);
    }

    // Método marcarPrestado
    public void marcarPrestado() {
        if (disponible == true) {
            
            disponible = false;
            System.out.println("El libro ahora está prestado.");
        } else {
            System.out.println("El libro no esta disponible.");
        }
    }

    // Método marcarDiponible
    public void marcarDisponible() {
        if (disponible == false) {
            
            disponible = true;
            System.out.println("El libro ha sido devuelto y está disponible.");
        } else {
            System.out.println("El libro se encuentra disponible.");
        }
    }
}
