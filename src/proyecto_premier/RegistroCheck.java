package proyecto_premier;
import java.sql.*;

public class RegistroCheck {
    
    public boolean registrar(String usuario, String password, String email) {
        String checkSql = "SELECT * FROM users WHERE name = ?";
        String insertSql = "INSERT INTO users (name, password, email) VALUES (?, ?, ?)";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement check = conn.prepareStatement(checkSql)) {
            
            check.setString(1, usuario);
            ResultSet rs = check.executeQuery();
            
            if (rs.next()) {
                System.out.println("El usuario ya existe.");
                return false;
            }

            try (PreparedStatement insert = conn.prepareStatement(insertSql)) {
                insert.setString(1, usuario);
                insert.setString(2, password);
                insert.setString(3, email);
                insert.executeUpdate();
                System.out.println("Usuario registrado correctamente.");
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
