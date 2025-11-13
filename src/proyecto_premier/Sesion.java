package proyecto_premier;

public class Sesion {
    private static String usuarioActual;

    public static void setUsuario(String usuario) {
        usuarioActual = usuario;
    }

    public static String getUsuario() {
        return usuarioActual;
    }
}
