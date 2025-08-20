package SistemaBiblioteca;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            Biblioteca biblioteca = new Biblioteca();
            Scanner scanner = new Scanner(System.in);
            int opcion = 0;

            do {
                System.out.println("\n--- MENÚ BIBLIOTECA ---");
                System.out.println("1. Registrar libro");
                System.out.println("2. Registrar usuario");
                System.out.println("3. Prestar libro");
                System.out.println("4. Devolver libro");
                System.out.println("5. Mostrar libros disponibles");
                System.out.println("6. Mostrar usuarios");
                System.out.println("7. Mostrar historial préstamos");
                System.out.println("8. Salir");
                System.out.print("Elige una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine(); // limpiar buffer

                switch (opcion) {
                    case 1:
                        System.out.print("Título: ");
                        String titulo = scanner.nextLine();
                        System.out.print("Autor: ");
                        String autor = scanner.nextLine();
                        System.out.print("Código: ");
                        String codigo = scanner.nextLine();
                        biblioteca.registrarLibro(titulo, autor, codigo);
                    break;

                    case 2:
                        System.out.print("Nombre: ");
                        String nombre = scanner.nextLine();
                        System.out.print("ID Usuario: ");
                        String id = scanner.nextLine();
                        biblioteca.registrarUsuario(nombre, id);
                    
                    break;  

                    case 3:
                        System.out.print("Código libro: ");
                        String codPrestamo = scanner.nextLine();
                        System.out.print("ID Usuario: ");
                        String idPrestamo = scanner.nextLine();
                        biblioteca.prestarLibro(codPrestamo, idPrestamo);
                    break;

                    case 4:
                        System.out.print("Código libro: ");
                        String codDev = scanner.nextLine();
                        System.out.print("ID Usuario: ");
                        String idDev = scanner.nextLine();
                        biblioteca.devolverLibro(codDev, idDev);
                    break;

                    case 5:
                        biblioteca.mostrarLibrosDisponibles();
                        break;
                    case 6:
                        biblioteca.mostrarUsuarios();
                        break;
                    case 7:
                        biblioteca.mostrarHistorialPrestamos();
                        break;
                    case 8:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción inválida.");
                }
        } while (opcion != 8);

        scanner.close();

    }

}
