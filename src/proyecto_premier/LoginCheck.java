package proyecto_premier;
import java.sql.*;

public class LoginCheck {
    
    public boolean autenticar(String usuario, String hashPassword) {
        String sql = "SELECT * FROM users WHERE nombre = ? AND password = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, usuario);
            ps.setString(2, hashPassword);

           ResultSet rs = ps.executeQuery();

            return rs.next();
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
