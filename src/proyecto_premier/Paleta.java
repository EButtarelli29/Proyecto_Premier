package proyecto_premier;

import java.awt.Color;

/**
 * Paleta de colores corporativa del sistema.
 *
 * Basada en azul marino y grises neutros, con verde y rojo oscuros
 * reservados unicamente para acciones de confirmar y descartar.
 * Todos los colores de la interfaz deben referirse a esta clase
 * en lugar de usar valores literales.
 */
public final class Paleta {

    private Paleta() {
        // Clase de constantes: no se instancia.
    }

    // ------------------------------------------------------------------
    // Azules
    // ------------------------------------------------------------------

    /** Azul marino corporativo. Header y fondos de titulo. */
    public static final Color AZUL_MARINO = new Color(30, 58, 95);

    /** Azul acero. Botones de accion secundaria y enlaces. */
    public static final Color AZUL_ACERO = new Color(70, 130, 180);

    // ------------------------------------------------------------------
    // Neutros
    // ------------------------------------------------------------------

    public static final Color BLANCO = new Color(255, 255, 255);

    /** Texto principal sobre fondo claro. */
    public static final Color TEXTO = new Color(26, 26, 26);

    /** Texto secundario sobre fondos claros: textos de ayuda. */
    public static final Color TEXTO_SECUNDARIO = new Color(89, 89, 89);

    /** Texto secundario sobre el header azul: subtitulos de ventana. */
    public static final Color TEXTO_HEADER = new Color(166, 166, 166);

    /** Bordes de paneles, campos y botones. */
    public static final Color BORDE = new Color(128, 128, 128);

    /** Fondos secundarios y lineas de grilla. */
    public static final Color GRIS_CLARO = new Color(240, 240, 240);

    // ------------------------------------------------------------------
    // Acciones
    // ------------------------------------------------------------------

    /** Acciones positivas: iniciar sesion, registrarse, guardar. */
    public static final Color VERDE_OSCURO = new Color(0, 100, 0);

    /** Acciones destructivas: salir, cancelar, cerrar sesion. */
    public static final Color ROJO_OSCURO = new Color(139, 0, 0);

    // ------------------------------------------------------------------
    // Tema oscuro
    // ------------------------------------------------------------------

    public static final Color FONDO_OSCURO = new Color(45, 45, 45);

    public static final Color PANEL_OSCURO = new Color(64, 64, 64);

    public static final Color BORDE_OSCURO = new Color(90, 90, 90);

    public static final Color TEXTO_SECUNDARIO_OSCURO = new Color(166, 166, 166);
}
