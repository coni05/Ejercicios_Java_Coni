package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.Conexion;
import model.Marca;
public class MarcaRepository {
    
    // Método para INSERTAR marca 
    public void insertarMarca(Marca marca) {
        String sql = "INSERT INTO MARCA (NOMBRE, PAIS_ORIGEN, DESCRIPCION) VALUES (?, ?, ?)";

        try (Connection connection = Conexion.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, marca.getNombre()); //Setear los valores
            preparedStatement.setString(2, marca.getPais_Origen());
            preparedStatement.setString(3, marca.getDescripcion());

            int filasAfectadas = preparedStatement.executeUpdate(); //Ejecutar la consulta
            if (filasAfectadas > 0) {
                ResultSet generatedKeys  = preparedStatement.getGeneratedKeys();
                if (generatedKeys .next()) {
                    marca.setId_Marca(generatedKeys.getLong(1));
                }
            }

            System.out.println("Usuario insertado correctamente");

        } catch (Exception e) { //Manejo de errores
            e.printStackTrace();
        }
    }

    // Método para CONSULTAR marcas 
    public void consultarMarcaPorId(Long id_marca) {
        String sql = "SELECT * FROM MARCA WHERE ID_MARCA = ?";

        try (Connection connection = Conexion.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setLong(1, id_marca); //Setear el valor del ID

            ResultSet resultSet = preparedStatement.executeQuery(); //Ejecutar la consulta

            if (resultSet.next()) { //Si se encuentra un usuario con el ID especificado
                Marca marca = new Marca(
                    resultSet.getLong("id"),
                    resultSet.getString("nombre"),
                    resultSet.getString("pais_origen"),
                    resultSet.getString("descripcion")
                );

                System.out.println("Marca encontrada: ");
                System.out.println("Id: " + marca.getId_Marca() +
                                   " Nombre: " + marca.getNombre() +
                                   " Pais de origen: " + marca.getPais_Origen() +
                                   " Descripción: " + marca.getDescripcion()
                );
            } else {
                System.out.println("No se encontró una marca con el ID especificado.");
            }

        } catch (Exception e) { //Manejo de errores
            e.printStackTrace();
        }
    }

    // Método para LISTAR marca  

    public List<Marca> listarMarca(){ //Metodo para listar usuarios
        List<Marca> marca = new ArrayList<>(); //Lista vacia para almacenar los usuarios
        String sql= "SELECT * FROM MARCA"; //Consulta SQL para seleccionar todos los usuarios de la tabla ususarios

        
        try (Connection connection = Conexion.getConnection()){
            Statement statement= connection.createStatement(); //Crear un objeto Statement para ejecutar la consulta
            ResultSet resultSet= statement.executeQuery(sql);//Ejecutar la consulta y obtener los resultados en un ResultSet

            while (resultSet.next()) { //Recorrer el ResultSet y crear objetos Usuario para cada fila
                marca.add(new Marca(
                    resultSet.getLong("id"),
                    resultSet.getString("nombre"),
                    resultSet.getString("pais_origen"),
                    resultSet.getString("descripcion")
                    )
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return marca;
    }

    // Método para ACTUALIZAR marca

    public void actualizarMarca(Marca marca){
        String sql= "UPDATE  MARCA SET NOMBRE = ?, PAIS_ORIGEN = ?, DESCRIPCION = ? WHERE ID_MARCA = ?";

        try (Connection connection = Conexion.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            //Setear los valores
            preparedStatement.setString(1, marca.getNombre());
            preparedStatement.setString(2, marca.getPais_Origen());
            preparedStatement.setString(3, marca.getDescripcion());
            preparedStatement.setLong(4, marca.getId_Marca());
            
            int marcaActualizada= preparedStatement.executeUpdate(); //Ejecutar la consulta
            if (marcaActualizada > 0) {
                System.out.println("Marca actulizada corrctamente.");
        
            } else {
                System.out.println("No se encontro ningun marca con el ID: " + marca.getId_Marca());
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método para ELIMINAR marca
    public void eliminarMarca(Long id_marca1){
        String sql = "DELETE FROM MARAC WHERE ID_MARCA = ?";

        try (Connection connection = Conexion.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(0, id_marca1);

            int marcaElininada =  preparedStatement.executeUpdate(); //Ejecutar la consulta

            if (marcaElininada > 0) {
                System.out.println("Marca" + id_marca1 + "eliminada correctamente");
            } else {
                System.out.println("No se encontro la marca con el " + id_marca1);
            } 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
