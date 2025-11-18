
package proyecto_premier;

import java.sql.*;

public class IngRegistrosCheck {
    
    public boolean ingresarRegistro(String fecha, String cuenta, double monto) {
        
        String insertSql = "INSERT INTO registros (fecha, cuenta, monto) VALUES (?, ?, ?)";

        try (Connection conn = Conexion.getConnection()) {

            try (PreparedStatement insert = conn.prepareStatement(insertSql)) {
                insert.setString(1, fecha);
                insert.setString(2, cuenta);
                insert.setDouble(3, monto);
                insert.executeUpdate();
                System.out.println("Registro ingresado correctamente.");
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
