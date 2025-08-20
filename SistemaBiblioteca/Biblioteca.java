package SistemaBiblioteca;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Biblioteca {
    ArrayList<Libro> listaLibros;
    ArrayList<Usuario> listaUsuarios;
    HashMap<Libro, Date[]> registroPrestamos; 
    // guardo inicio[0] y limite[1] por cada libro

    public Biblioteca() {
        listaLibros = new ArrayList<Libro>();
        listaUsuarios = new ArrayList<Usuario>();
        registroPrestamos = new HashMap<Libro, Date[]>();
    }

    public void registrarLibro(String titulo, String autor, String codigo) {
        Libro libro = new Libro(titulo, autor, codigo);
        listaLibros.add(libro);
        System.out.println("Libro registrado correctamente.");
    }

    public void registrarUsuario(String nombre, String id) {
        Usuario usuario = new Usuario(nombre, id);
        listaUsuarios.add(usuario);
        System.out.println("Usuario registrado correctamente.");
    }

/****************** Prestar Libro **********************/

    public void prestarLibro(String codigo, String idUsuario) {
        Libro libroEncontrado = null;
        Usuario usuarioEncontrado = null;

        for (Libro l : listaLibros) {
            if (l.codigo.equals(codigo)) {
                libroEncontrado = l;
                break;
            }
        }

        for (Usuario u : listaUsuarios) {
            if (u.idUsuario.equals(idUsuario)) {
                usuarioEncontrado = u;
                break;
            }
        }

        if (libroEncontrado != null && usuarioEncontrado != null) {
            if (libroEncontrado.disponible && usuarioEncontrado.librosPrestados.size() < 3) {
                libroEncontrado.marcarPrestado();
                usuarioEncontrado.agregarPrestamo(libroEncontrado);

                Date hoy = new Date();
                Date limite = new Date(hoy.getTime() + (3 * 60 * 1000)); // 7 días
                Date[] fechas = {hoy, limite};
                registroPrestamos.put(libroEncontrado, fechas);

                System.out.println("Préstamo realizado. Fecha límite: " + limite);
            } else {
                System.out.println("No se pudo prestar (libro no disponible o usuario con 3 libros).");
            }
        } else {
            System.out.println("Usuario o libro no encontrado.");
        }
    }

/****************** Devolver Libro **********************/

    public void devolverLibro(String codigo, String idUsuario) {
        Libro libroEncontrado = null;
        Usuario usuarioEncontrado = null;

        for (Libro l : listaLibros) {
            if (l.codigo.equals(codigo)) {
                libroEncontrado = l;
                break;
            }
        }

        for (Usuario u : listaUsuarios) {
            if (u.idUsuario.equals(idUsuario)) {
                usuarioEncontrado = u;
                break;
            }
        }

        if (libroEncontrado != null && usuarioEncontrado != null) {
            if (usuarioEncontrado.librosPrestados.contains(libroEncontrado)) {
                usuarioEncontrado.devolverLibro(libroEncontrado);
                libroEncontrado.marcarDisponible();

                Date[] fechas = registroPrestamos.get(libroEncontrado);
                Date hoy = new Date();
                if (hoy.after(fechas[1])) {
                    long retraso = (hoy.getTime() - fechas[1].getTime()) / (1000 * 60 * 60 * 24);
                    long multa = retraso * 500;
                    System.out.println("Libro devuelto con retraso de " + retraso + " días. Multa: $" + multa);
                } else {
                    System.out.println("Libro devuelto a tiempo. Sin multa.");
                }

                registroPrestamos.remove(libroEncontrado);
            } else {
                System.out.println("Ese usuario no tenía prestado este libro.");
            }
        } else {
            System.out.println("Usuario o libro no encontrado.");
        }
    }

/****************** Libros Disponibles **********************/

    public void mostrarLibrosDisponibles() {
        for (Libro l : listaLibros) {
            if (l.disponible) {
                l.mostrarDatos();
            }
        }
    }

/****************** Lista de Usuarios **********************/

    public void mostrarUsuarios() {
        for (Usuario u : listaUsuarios) {
            u.mostrarDatos();
        }
    }

/****************** Historial de Prestamos **********************/

    public void mostrarHistorialPrestamos() {
        for (Libro l : registroPrestamos.keySet()) {
            Date[] fechas = registroPrestamos.get(l);
            System.out.println("Libro: " + l.titulo + " | Prestado: " + fechas[0] + " | Límite: " + fechas[1]);
        }
    }


}













