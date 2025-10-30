package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    /*Ruta de conexión y credenciales ala base de datos */
    private static final String URL = "jdbc:msql://localhost:3306/inventariobicicletas_coni";
    private static final String USER = "root";
    private static final String PASSWORD = "";


    /* Retorna la conexión lista para usar la base de datos */
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
