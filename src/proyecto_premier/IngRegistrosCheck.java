
package proyecto_premier;

import java.math.BigDecimal;
import java.sql.*;

/**
 * Insercion de registros en la tabla registros.
 *
 * El monto viaja como BigDecimal y no como double: double representa los
 * decimales en base 2, asi que 0.1 + 0.2 no da 0.3 y las sumas de un
 * sistema financiero accumulate error. BigDecimal es exacto y ademas
 * coincide con el DECIMAL(12,2) de la columna.
 */
public class IngRegistrosCheck {

    public boolean ingresarRegistro(String fecha, String cuenta, BigDecimal monto) {

        String insertSql = "INSERT INTO registros (fecha, cuenta, monto) VALUES (?, ?, ?)";

        try (Connection conn = Conexion.getConnection()) {

            try (PreparedStatement insert = conn.prepareStatement(insertSql)) {
                insert.setString(1, fecha);
                insert.setString(2, cuenta);
                insert.setBigDecimal(3, monto);
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
