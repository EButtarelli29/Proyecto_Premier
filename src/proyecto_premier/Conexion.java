
package proyecto_premier;
import java.sql.*;

public class Conexion {
    
    public static void main(String[] args) {
        
    String user = "root";
    String key = "";
    String url = "jdbc:mysql://localhost:3306/PremierDataBase";
    Connection conexion;
    Statement stmt;
    ResultSet rs;

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
        stmt.executeUpdate("INSERT INTO users VALUES(null, 'Emi', '12345678', 'emi@gmail.com')");
    } catch(SQLException e) {
        throw new IllegalStateException("Error al cargar", e);
    } 
    }
}
