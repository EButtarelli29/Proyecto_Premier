package proyecto_premier;

import org.mindrot.jbcrypt.BCrypt;

public class HashUtil {
    
    /**
     * Hashea una contraseña usando bcrypt con salt automático
     * @param password Contraseña en texto plano
     * @return Hash de la contraseña
     */
    public static String hashPassword(String password) {
        // gensalt(12) genera un salt con factor de costo 12
        // Mayor factor = más seguro pero más lento
        return BCrypt.hashpw(password, BCrypt.gensalt(12));
    }
    
    /**
     * Verifica si una contraseña coincide con un hash
     * @param password Contraseña en texto plano
     * @param hash Hash almacenado en la base de datos
     * @return true si la contraseña es correcta
     */
    public static boolean verifyPassword(String password, String hash) {
        try {
            return BCrypt.checkpw(password, hash);
        } catch (IllegalArgumentException e) {
            // El hash no es válido
            return false;
        }
    }
}
