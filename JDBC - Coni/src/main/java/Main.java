import java.util.Scanner;

import model.Usuario;
import repository.UsuarioRepository;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UsuarioRepository usuarioRepository = new UsuarioRepository(); //Crear instancia del repositorio

        /* Pedir nombre */
        System.out.print("Ingrese nombre: ");
        String nombre = scanner.nextLine();

        /* Pedir edad */
        System.out.print("Ingrese edad: ");
        Long edad = scanner.nextLong();

        Usuario usuario = new Usuario(nombre, edad);
        usuarioRepository.insertarUsuario(usuario);

        // Consultar usuario por ID
        System.out.print("Ingrese el ID del usuario a consultar: ");
        Long id = scanner.nextLong();
        usuarioRepository.consultarUsuarioPorId(id);
        
        // Actualizar usuario
        System.out.print("Ingrese el ID del usuario a actualizar: ");
        Long id1 = scanner.nextLong();
        System.out.print("Ingrese el nuevo nombre: ");
        String nombre1 = scanner.nextLine();
        System.out.print("Ingrese la nueva edad: ");
        Long edad1= scanner.nextLong();

        usuarioRepository.actualizarUsuario(id1, nombre1, edad1);

        // Eliminar usuario
        System.out.print("Ingrese el Id del usuario a eliminar: ");
        Long id3= scanner.nextLong();

        usuarioRepository.eliminarUsuario(id3);

        // Listar usuarios
        System.out.println("Lista de usuarios:");

        for(Usuario u: usuarioRepository.listarUsuarios()) {
            System.out.println("Id: " + u.getId() + 
                                " Nombre: " + u.getNombre() +
                                " Edad: " + u.getEdad()
            );
        }
        
        scanner.close();
    }
}