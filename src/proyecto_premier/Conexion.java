package proyecto_premier;
import java.sql.*;

public class Conexion {
    
    public Conexion() {
    String user = "root";
    String key = "";
    String url = "jdbc:mysql://localhost:3306/PremierDataBase";
    Connection conexion;
    Statement stmt;
    ResultSet rs;
    
    String crearDB = "CREATE DATABASE IF NOT EXISTS premierdatabase";
    String crearTabla = "CREATE TABLE IF NOT EXISTS users (" +
                               "id INT PRIMARY KEY AUTO_INCREMENT, " +
                               "nombre VARCHAR(100), " +
                               "password VARCHAR(20), " +
                               "email VARCHAR(100)" +
                               ")";
    
    
    try {
     Class.forName("com.mysql.cj.jdbc.Driver"); 
     System.out.println("Driver cargado!");
     } catch (ClassNotFoundException e) {
     throw new IllegalStateException("Sin driver!", e);
    }

    try {
        conexion = DriverManager.getConnection(url, user, key);
        System.out.println("Base de datos conectada!");
    } catch (SQLException e) {
        throw new IllegalStateException("Error al conectar!", e);
    }
    
    try {
        stmt = conexion.createStatement();
        
        stmt.execute(crearDB);
        stmt.execute(crearTabla);
        System.out.println("Base de datos y tabla creada!");
    } catch (SQLException e) {
        throw new IllegalStateException("Error al crear base de datos/tabla!", e);
    }
    
    // PRUEBA PARA CARGAR DATOS A TABLA
    // try {
    //     stmt = conexion.createStatement();
    //     stmt.executeUpdate("INSERT INTO users VALUES(null, 'Emi', '12345678', 'emi@gmail.com')");
    //     System.out.println("Datos cargados correctamente!");
    // } catch(SQLException e) {
    //     throw new IllegalStateException("Error al cargar", e);
    // }
    }
}
