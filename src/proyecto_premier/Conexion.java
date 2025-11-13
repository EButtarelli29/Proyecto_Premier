package proyecto_premier;
import java.sql.*;

public class Conexion {
    
    private static final String USER = "root";
    private static final String KEY = "";
    private static final String URL_BASE = "jdbc:mysql://localhost:3306/";
    private static final String URL_DB = "jdbc:mysql://localhost:3306/PremierDataBase";
    
    public Conexion() {
        crearBaseYTabla();
    }

    // Crea DB y tabla si no existen
    private void crearBaseYTabla() {
        String crearDB = "CREATE DATABASE IF NOT EXISTS PremierDataBase";
        String crearTabla = "CREATE TABLE IF NOT EXISTS users (" +
                "id INT PRIMARY KEY AUTO_INCREMENT, " +
                "nombre VARCHAR(100), " +
                "password VARCHAR(100), " + // más largo por si encriptás
                "email VARCHAR(100)" +
                ")";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver cargado!");
            
            // Crear la base
            try (Connection conexion = DriverManager.getConnection(URL_BASE, USER, KEY);
                 Statement stmt = conexion.createStatement()) {
                stmt.execute(crearDB);
            }

            // Crear tabla
            try (Connection conexion = DriverManager.getConnection(URL_DB, USER, KEY);
                 Statement stmt = conexion.createStatement()) {
                stmt.execute(crearTabla);
            }

            System.out.println("Base de datos y tabla listas.");
        } catch (Exception e) {
            throw new IllegalStateException("Error al preparar base de datos", e);
        }
    }

    // Método para obtener conexión a la DB
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL_DB, USER, KEY);
    }
}
