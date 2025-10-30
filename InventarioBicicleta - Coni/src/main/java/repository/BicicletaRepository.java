package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.Conexion;
import model.Bicicleta;

public class BicicletaRepository {

   // Método para INSERTAR marca 

    public void insertarBicicleta(Bicicleta bicicleta) {
        String sql = "INSERT INTO BIBLIOTECA (MODELO, TIPO, TALLA, COLOR, DESCRIPCION, PRECIO, CANTIDAD_STOCK, STOCK_MANIMO, ID_MARCA) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = Conexion.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            
            validarDatosBicicleta(bicicleta);
            
            preparedStatement.setString(1, bicicleta.getModelo());
            preparedStatement.setString(2, bicicleta.getTipo());
            preparedStatement.setString(3, bicicleta.getTalla());
            preparedStatement.setString(4, bicicleta.getColor());
            preparedStatement.setString(5, bicicleta.getDescripcion());
            preparedStatement.setDouble(6, bicicleta.getPrecio());
            preparedStatement.setLong(7, bicicleta.getCantidad_Stock());
            preparedStatement.setLong(8, bicicleta.getStock_Minimo());
            preparedStatement.setLong(9, bicicleta.getId_Marca());

            //Opner las claves primarias
            int filasAfectadas = preparedStatement.executeUpdate(); //Ejecutar la consulta
            if (filasAfectadas > 0) {
                ResultSet generatedKeys  = preparedStatement.getGeneratedKeys();
                if (generatedKeys .next()) {
                    bicicleta.setId_Bicicleta(generatedKeys.getLong(1));
                }
            }
            System.out.println("Biblioteca insertada correctamente");
            verificarStockMinimo(bicicleta);
        
        } catch (Exception e) { //Manejo de errores
            e.printStackTrace();
        }
    }
    
    //Método para VALIDAR LOS DATOS de bicicleta

    private void validarDatosBicicleta(Bicicleta b) {
        if (b.getPrecio() <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor a 0.");
        }
        if (b.getCantidad_Stock() < 0) {
            throw new IllegalArgumentException("La cantidad en stock no puede ser negativa.");
        }
        if (b.getStock_Minimo() < 0) {
            throw new IllegalArgumentException("El stock mínimo no puede ser negativo.");
        }
        if (!ValidarTipo(b.getTipo())) {
            throw new IllegalArgumentException("Tipo inválido. Debe ser: Montaña, Ruta, Urbana, Eléctrica, BMX, Híbrida.");
        }
    }

    //Método para VALIDAR el tipo de bicicleta

    private boolean ValidarTipo(String tipo) {
        return "Montaña".equals(tipo) || "Ruta".equals(tipo) || "Urbana".equals(tipo) ||
               "Eléctrica".equals(tipo) || "BMX".equals(tipo) || "Híbrida".equals(tipo);
    }

    //Método para VERIFICAR el stock minimo de la bicicleta

    private void verificarStockMinimo(Bicicleta b) {
        if (b.getCantidad_Stock() < b.getStock_Minimo()) {
            System.out.println("ALERTA: La bicicleta '" + b.getModelo() + "' está por debajo del stock mínimo (" + b.getStock_Minimo() + "). Stock actual: " + b.getCantidad_Stock());
        }
    }

    //Método para CONSULTAR por id 

     public void consultarBicicletaPorId(Long id_bicicleta) {
        String sql = "SELECT * FROM BICICLETA WHERE ID_BICILETA = ?";

        try (Connection connection = Conexion.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setLong(1, id_bicicleta); //Setear el valor del ID

            ResultSet resultSet = preparedStatement.executeQuery(); //Ejecutar la consulta

            if (resultSet.next()) { //Si se encuentra un usuario con el ID especificado
                Bicicleta bicicleta = new Bicicleta(
                    resultSet.getLong("id_bicicleta"),
                    resultSet.getString("modelo"),
                    resultSet.getString("tipo"),
                    resultSet.getString("talla"),
                    resultSet.getString("color"),
                    resultSet.getString("descripcion"),
                    resultSet.getDouble("precio"),
                    resultSet.getLong("cantidad_stock"),
                    resultSet.getLong("stock_minimo"),
                    resultSet.getLong("id_marca")
                );

                System.out.println("Bicicleta encontrada: ");
                System.out.println("Id: " + bicicleta.getId_Bicicleta() +
                                   " Modelo: " + bicicleta.getModelo() +
                                   " Tipo: " + bicicleta.getTipo() +
                                   " Talla: " + bicicleta.getTalla() +
                                   " Color: " + bicicleta.getColor() +
                                   " Descripción: " + bicicleta.getDescripcion() +
                                   " Precio: " + bicicleta.getPrecio() +
                                   " Cantidad del stock: " + bicicleta.getCantidad_Stock() +
                                   " Stock minino: " + bicicleta.getStock_Minimo() +
                                   " Id de la Marca: " + bicicleta.getId_Marca() 
                );
            } else {
                System.out.println("No se encontró una marca con el ID especificado.");
            }

        } catch (Exception e) { //Manejo de errores
            e.printStackTrace();
        }
    }

    // Método para LISTAR TODAS las bicicletas

    public List<Bicicleta> listarBicicletas(){ //Metodo para listar usuarios
        List<Bicicleta> bicicleta = new ArrayList<>(); //Lista vacia para almacenar los usuarios
        String sql= "SELECT * FROM  BICICLETA"; //Consulta SQL para seleccionar todos los usuarios de la tabla ususarios

        
        try (Connection connection = Conexion.getConnection();
            Statement statement= connection.createStatement(); //Crear un objeto Statement para ejecutar la consulta
            ResultSet resultSet= statement.executeQuery(sql)){;//Ejecutar la consulta y obtener los resultados en un ResultSet

            while (resultSet.next()) { //Recorrer el ResultSet y crear objetos Usuario para cada fila
                bicicleta.add(new Bicicleta(
                    resultSet.getLong("id_bicicleta"),
                    resultSet.getString("modelo"),
                    resultSet.getString("tipo"),
                    resultSet.getString("talla"),
                    resultSet.getString("color"),
                    resultSet.getString("descripcion"),
                    resultSet.getDouble("precio"),
                    resultSet.getLong("cantidad_stock"),
                    resultSet.getLong("stock_minimo"),
                    resultSet.getLong("id_marca")
                )
            );
        }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return bicicleta;
    }

    // Método para ACTUALIZAR bicicleta

    public void actualizarBicicleta(Bicicleta bicicleta){
        String sql= "UPDATE  BICICLETA SET MODELO = ?, TIPO = ?, TALLA = ?, COLOR = ?, DESCRIPCION, PRECIO = ? CANTIDAD_STOCK= ?, STOCK_MINIMO = ?, ID_MARCA = ? WHERE ID_BICICLETA = ?";

        try (Connection connection = Conexion.getConnection(); 
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            validarDatosBicicleta(bicicleta);
            //Setear los valores
            preparedStatement.setString(1, bicicleta.getModelo());
            preparedStatement.setString(1, bicicleta.getTipo());
            preparedStatement.setString(1, bicicleta.getTalla());
            preparedStatement.setString(1, bicicleta.getColor());
            preparedStatement.setString(1, bicicleta.getDescripcion());
            preparedStatement.setDouble(1, bicicleta.getPrecio());
            preparedStatement.setLong(1, bicicleta.getCantidad_Stock());
            preparedStatement.setLong(1, bicicleta.getStock_Minimo());
            preparedStatement.setLong(1, bicicleta.getId_Marca());
            preparedStatement.setLong(1, bicicleta.getId_Bicicleta());


            int bicicletaActualizada= preparedStatement.executeUpdate(); //Ejecutar la consulta
            if (bicicletaActualizada > 0) {
                System.out.println("Bicicleta actulizada corrctamente.");
                verificarStockMinimo(bicicleta);
            } else {
                System.out.println("No se encontro ningun marca con el ID: " + bicicleta.getId_Marca());
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método para ELIMINAR biciclceta

    public void eliminarBicicleta(Long id_bicicleta1){
        String sql = "DELETE FROM MARAC WHERE ID_MARCA = ?";

        try (Connection connection = Conexion.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.setLong(0, id_bicicleta1);

            int marcaElininada =  preparedStatement.executeUpdate(); //Ejecutar la consulta

            if (marcaElininada > 0) {
                System.out.println("Biciccleta" + id_bicicleta1 + "eliminada correctamente");
            } else {
                System.out.println("No se encontro la bicicleta con el " + id_bicicleta1);
            } 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

// Función para registrar movimiento de entrada (por ejemplo, al recibir mercancía)
    public void registrarEntrada(Long id_Bicicleta3, Long cantidad) {
       if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad de entrada debe ser mayor a 0.");
        }
        String sql = "UPDATE BICICLETA SET CANTIDAD_STOCK = CANTDAD_STOCK + ? WHERE ID_BICICLETA = ?";
        try (Connection connection = Conexion.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.setLong(1, cantidad);
            preparedStatement.setLong(2, id_Bicicleta3);
        
            int filasAfectadas = preparedStatement.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Se registró entrada de " + cantidad + " unidades para la bicicleta ID: " + id_Bicicleta3);
            } else {
                throw new IllegalStateException("No hay suficiente stock para la bicicleta ID: " + id_Bicicleta3);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Función para registrar movimiento de salida (por ejemplo, al vender)
    public void registrarSalida(Long id_bicicleta4, Long cantidad1) {
        if (cantidad1 <= 0) {
            throw new IllegalArgumentException("La cantidad de salida debe ser mayor a 0.");
        }
        String sql = "UPDATE BICICLETA SET CANTIDAD_STOCK = CANTDAD_STOCK - ? WHERE ID_BICICLETA = ? AND CANTIDAD_STOCK = ?";
        try (Connection connection = Conexion.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setLong(1, cantidad1);
            preparedStatement.setLong(2, id_bicicleta4);
            preparedStatement.setLong(3, cantidad1); // Asegurar que hay suficiente stock

            int filasAfectadas = preparedStatement.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Se registró salida de " + cantidad1 + " unidades para la bicicleta ID: " + id_bicicleta4);
                
            } else {
                throw new IllegalStateException("No hay suficiente stock para la bicicleta ID: " + id_bicicleta4);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
