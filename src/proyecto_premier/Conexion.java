package proyecto_premier;
import java.sql.*;

/**
 * Conexion con MySQL y preparacion del esquema.
 *
 * La base PremierDataBase y las tablas users y registros se crean sola
 * la primera vez. El monto se guarda como DECIMAL(12,2) y no como INT:
 * en un sistema financiero el redondeo automatico del motor hacia que
 * 100.75 se guarde como 101 sin avisar, y el arreglo del tipo existente
 * se aplica por migration para no romper las instalaciones anteriores.
 */
public class Conexion {

    private static final String USER = "root";
    private static final String KEY = "";
    private static final String URL_BASE = "jdbc:mysql://localhost:3306/";
    private static final String URL_DB = "jdbc:mysql://localhost:3306/PremierDataBase";

    private static boolean esquemaPreparado;

    public Conexion() {
        // Se conserva por compatibilidad, pero el esquema se prepara una sola vez.
        prepararEsquema();
    }

    /**
     * Crea la base y las tablas si no existen y migra el tipo de la
     * columna monto. Es idempotente: solo hace trabajo la primera vez.
     */
    public static synchronized void prepararEsquema() {
        if (esquemaPreparado) {
            return;
        }
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection conexion = DriverManager.getConnection(URL_BASE, USER, KEY);
                 Statement stmt = conexion.createStatement()) {
                stmt.execute("CREATE DATABASE IF NOT EXISTS PremierDataBase");
            }

            try (Connection conexion = DriverManager.getConnection(URL_DB, USER, KEY);
                 Statement stmt = conexion.createStatement()) {
                stmt.execute("CREATE TABLE IF NOT EXISTS users ("
                        + "id INT PRIMARY KEY AUTO_INCREMENT, "
                        + "nombre VARCHAR(100), "
                        + "password VARCHAR(100), "
                        + "email VARCHAR(100))");
            }

            try (Connection conexion = DriverManager.getConnection(URL_DB, USER, KEY);
                 Statement stmt = conexion.createStatement()) {
                stmt.execute("CREATE TABLE IF NOT EXISTS registros ("
                        + "id INT PRIMARY KEY AUTO_INCREMENT, "
                        + "fecha VARCHAR(100), "
                        + "cuenta VARCHAR(100), "
                        + "monto DECIMAL(12,2))");
            }

            migrarMonto();

            esquemaPreparado = true;
        } catch (Exception e) {
            throw new IllegalStateException("Error al preparar base de datos", e);
        }
    }

    /**
     * Cambia monto a DECIMAL(12,2) si todavia no lo es.
     *
     * Las instalaciones viejas quedaron con INT, y CREATE TABLE IF NOT
     * EXISTS no modifica una tabla que ya existe, asi que hace falta un
     * ALTER explicito. Se consulta information_schema primero para no
     * reconstruir la tabla en cada arranque.
     */
    private static void migrarMonto() throws SQLException {
        String consulta = "SELECT DATA_TYPE FROM information_schema.COLUMNS "
                + "WHERE TABLE_SCHEMA = 'PremierDataBase' "
                + "AND TABLE_NAME = 'registros' AND COLUMN_NAME = 'monto'";

        try (Connection conexion = DriverManager.getConnection(URL_DB, USER, KEY);
             PreparedStatement ps = conexion.prepareStatement(consulta);
             ResultSet rs = ps.executeQuery()) {

            if (!rs.next()) {
                return;
            }
            String tipoActual = rs.getString("DATA_TYPE");

            if (tipoActual.toLowerCase().startsWith("decimal")) {
                return;
            }

            System.out.println("Migrando columna monto de " + tipoActual + " a DECIMAL(12,2)");
            try (Statement stmt = conexion.createStatement()) {
                stmt.execute("ALTER TABLE registros MODIFY COLUMN monto DECIMAL(12,2)");
            }
        }
    }

    /** Metodo estatico para obtener una conexion a la base de datos. */
    public static Connection getConnection() throws SQLException {
        prepararEsquema();
        return DriverManager.getConnection(URL_DB, USER, KEY);
    }
}
