package proyecto_premier;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.regex.Pattern;

public class Validaciones {
    
    // Regex para email válido
    private static final Pattern EMAIL_REGEX = Pattern.compile(
        "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"
    );
    
    /**
     * Valida que el nombre de usuario tenga más de 2 caracteres y no esté vacío
     */
    public static boolean validarUsuario(String usuario) {
        if (usuario == null || usuario.trim().isEmpty()) {
            return false;
        }
        return usuario.trim().length() > 2;
    }
    
    /**
     * Valida que la contraseña tenga más de 8 caracteres y no esté vacía
     */
    public static boolean validarContraseña(String contraseña) {
        if (contraseña == null || contraseña.isEmpty()) {
            return false;
        }
        return contraseña.length() > 8;
    }
    
    /**
     * Valida que el email tenga formato válido
     */
    public static boolean validarEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            return false;
        }
        return EMAIL_REGEX.matcher(email.trim()).matches();
    }
    
    /**
     * Valida que el monto sea un número válido, con decimales y posible negativo.
     * Acepta coma o punto como separador decimal porque el monto es en pesos
     * argentinos y el usuario escribe cualquiera de los dos.
     */
    public static boolean validarMonto(String montoStr) {
        return parsearMonto(montoStr) != null;
    }

    /**
     * Convierte el texto del monto a BigDecimal con dos decimales.
     *
     * @return el monto, o null si el texto no es un número válido
     */
    public static BigDecimal parsearMonto(String montoStr) {
        if (montoStr == null || montoStr.trim().isEmpty()) {
            return null;
        }
        String normalizado = montoStr.trim().replace(',', '.');
        try {
            // HALF_UP coincide con el redondeo del DECIMAL de MySQL, asi el
            // valor que ve el usuario es el que queda guardado.
            return new BigDecimal(normalizado).setScale(2, RoundingMode.HALF_UP);
        } catch (NumberFormatException e) {
            return null;
        }
    }
    
    /**
     * Valida que la fecha tenga formato dd-MM-yyyy
     */
    public static boolean validarFecha(String fecha) {
        if (fecha == null || fecha.trim().isEmpty()) {
            return false;
        }
        // Formato dd-MM-yyyy
        String regex = "^(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[0-2])-\\d{4}$";
        return Pattern.matches(regex, fecha.trim());
    }
    
    /**
     * Valida que un campo no esté vacío
     */
    public static boolean validarNoVacio(String campo) {
        return campo != null && !campo.trim().isEmpty();
    }
    
    /**
     * Obtiene mensaje de error para usuario inválido
     */
    public static String getMensajeUsuario() {
        return "El usuario debe tener más de 2 caracteres y no puede estar vacío.";
    }
    
    /**
     * Obtiene mensaje de error para contraseña inválida
     */
    public static String getMensajeContraseña() {
        return "La contraseña debe tener más de 8 caracteres y no puede estar vacía.";
    }
    
    /**
     * Obtiene mensaje de error para email inválido
     */
    public static String getMensajeEmail() {
        return "El email no tiene un formato válido.";
    }
    
    /**
     * Obtiene mensaje de error para monto inválido
     */
    public static String getMensajeMonto() {
        return "El monto debe ser un número válido, con hasta 2 decimales (puede ser negativo).";
    }
    
    /**
     * Obtiene mensaje de error para fecha inválida
     */
    public static String getMensajeFecha() {
        return "La fecha debe tener formato dd-MM-yyyy.";
    }
    
    /**
     * Obtiene mensaje de error para campo vacío
     */
    public static String getMensajeCampoVacio(String nombreCampo) {
        return "El campo " + nombreCampo + " no puede estar vacío.";
    }
}
