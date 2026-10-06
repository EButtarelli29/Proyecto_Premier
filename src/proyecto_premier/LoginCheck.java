package proyecto_premier;
import java.sql.*;

public class LoginCheck {
    
    public boolean autenticar(String usuario, String password) {
        String sql = "SELECT password FROM users WHERE nombre = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, usuario);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String hashAlmacenado = rs.getString("password");
                return HashUtil.verifyPassword(password, hashAlmacenado);
            }
            
            return false;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
