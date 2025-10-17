package repository;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import db.Conexion;
import model.Usuario;

//Método para insertar usuarios

public class UsuarioRepository {
    public void insertarUsuario(Usuario usuario) {
        String sql = "INSERT INTO USUARIO (NOMBRE, EDAD) VALUES (?, ?)";

        try (Connection connection = Conexion.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, usuario.getNombre()); //Setear los valores
            preparedStatement.setLong(2, usuario.getEdad());


            preparedStatement.executeUpdate(); //Ejecutar la consulta

            System.out.println("Usuario insertado correctamente");

        } catch (Exception e) { //Manejo de errores
            e.printStackTrace();
        }
    }

    // Método para listar usuarios
    public List<Usuario> listarUsuarios(){ //Metodo para listar usuarios
        List<Usuario> usuarios = new ArrayList<>(); //Lista vacia para almacenar los usuarios
        String sql= "SELECT * FROM USUARIO"; //Consulta SQL para seleccionar todos los usuarios de la tabla ususarios

        
        try (Connection connection = Conexion.getConnection()){
            Statement statement= connection.createStatement(); //Crear un objeto Statement para ejecutar la consulta
            ResultSet resultSet= statement.executeQuery(sql);//Ejecutar la consulta y obtener los resultados en un ResultSet

            while (resultSet.next()) { //Recorrer el ResultSet y crear objetos Usuario para cada fila
                usuarios.add(new Usuario(
                        resultSet.getLong("id"),
                        resultSet.getString("nombre"),
                        resultSet.getLong("edad")
                    )
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return usuarios;
    }

    // Método para consulta de usuario por ID
    public void consultarUsuarioPorId(Long id) {
        String sql = "SELECT * FROM USUARIO WHERE ID = ?";

        try (Connection connection = Conexion.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setLong(0, id); //Setear el valor del ID

            ResultSet resultSet = preparedStatement.executeQuery(); //Ejecutar la consulta

            if (resultSet.next()) { //Si se encuentra un usuario con el ID especificado
                Usuario usuario = new Usuario(
                        resultSet.getLong("id"),
                        resultSet.getString("nombre"),
                        resultSet.getLong("edad")
                );

                System.out.println("Usuario encontrado: ");
                System.out.println("Id: " + usuario.getId() +
                                   " Nombre: " + usuario.getNombre() +
                                   " Edad: " + usuario.getEdad()
                );
            } else {
                System.out.println("No se encontró un usuario con el ID especificado.");
            }

        } catch (Exception e) { //Manejo de errores
            e.printStackTrace();
        }
    }

    // Método para actualizar usuario
    public void actualizarUsuario(Long id1, String nombre1, Long edad1){
        String sql= "UPDATE  USUARIO SET NOMBRE = ?, EDAD = ? WHERE ID = ?";

        try (Connection connection = Conexion.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            //Setear los valores
            preparedStatement.setString(1, nombre1);
            preparedStatement.setLong(2, edad1);
            preparedStatement.setLong(3, id1);
            
            int usuarioActualizado= preparedStatement.executeUpdate(); //Ejecutar la consulta
            if (usuarioActualizado > 0) {
                System.out.println("Usuario actulizado corrctamente.");
        
            } else {
                System.out.println("No se encontro ningun usuario con el ID: " + id1);
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método para eliminar usuario
    public void eliminarUsuario(Long id3){
        String sql = "DELETE FROM USUARIO WHERE ID = ?";

        try (Connection connection = Conexion.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, id3);

            int usuarioElininado =  preparedStatement.executeUpdate(); //Ejecutar la consulta

            if (usuarioElininado > 0) {
                System.out.println("El usuario fue eliminado correctamente");
            } else {
                System.out.println("El usuario con el ID " + id3 + "no pudo ser eliminado");
            } 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
