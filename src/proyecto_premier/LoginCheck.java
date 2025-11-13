package proyecto_premier;
import java.sql.*;

public class LoginCheck {
    
    public boolean autenticar(String usuario, String password) {
        String sql = "SELECT * FROM users WHERE name = ? AND password = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, usuario);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            
            return rs.next(); // devuelve true si encontró el usuario
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
