package proyecto_premier;

import java.awt.Color;

/**
 * Estado global de la aplicacion: usuario en sesion y tema activo.
 *
 * Los colores dependen del tema, por eso se resuelven aca en lugar de
 * quedar fijos en cada ventana. La definicion de cada color esta en
 * {@link Paleta}.
 */
public class Config {

    private static String usuarioActual;
    private static boolean temaOscuro = false;

    // ------------------------------------------------------------------
    // Colores segun tema
    // ------------------------------------------------------------------

    /** Fondo principal de las ventanas. */
    public static Color getBackgroundColor() {
        return temaOscuro ? Paleta.FONDO_OSCURO : Paleta.BLANCO;
    }

    /** Color del texto principal. */
    public static Color getContrastColor() {
        return temaOscuro ? Paleta.BLANCO : Paleta.TEXTO;
    }

    /** Fondo de paneles, campos de texto y tablas. */
    public static Color getPanelColor() {
        return temaOscuro ? Paleta.PANEL_OSCURO : Paleta.BLANCO;
    }

    /** Bordes de paneles, campos de texto y botones. */
    public static Color getBorderColor() {
        return temaOscuro ? Paleta.BORDE_OSCURO : Paleta.BORDE;
    }

    /** Subtitulos y textos de ayuda. */
    public static Color getSecondaryTextColor() {
        return temaOscuro ? Paleta.TEXTO_SECUNDARIO_OSCURO : Paleta.TEXTO_SECUNDARIO;
    }

    /** Lineas de grilla de las tablas. */
    public static Color getGridColor() {
        return temaOscuro ? Paleta.BORDE_OSCURO : Paleta.GRIS_CLARO;
    }

    // ------------------------------------------------------------------
    // Estado
    // ------------------------------------------------------------------

    public static void setUsuario(String usuario) {
        usuarioActual = usuario;
    }

    public static String getUsuario() {
        return usuarioActual;
    }

    public static boolean isTemaOscuro() {
        return temaOscuro;
    }

    /** Alterna entre tema claro y oscuro. */
    public static void setColores() {
        temaOscuro = !temaOscuro;
    }
}
