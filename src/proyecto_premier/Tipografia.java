package proyecto_premier;

import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Resolucion de tipografias.
 *
 * El diseno original usa fuentes que no estan instaladas en todos los
 * equipos ("Swis721 BT", "Swis721 Cn BT", "Segoe UI Historic"). Java
 * reemplaza las que no encuentra por una fuente del sistema, pero de
 * forma silenciosa y sin criterio, lo que produceTitulos con otra
 * tipografia y proporciones distintas a las disenadas.
 *
 * En lugar de eso se recorren los componentes y se busca una familia
 * disponible, conservando el tamano y el estilo de cada componente.
 */
public final class Tipografia {

    /**
     * Familia pedida y familia preferida para reemplazar.
     * El primer nombre que este instalado en el equipo gana.
     */
    private static final String[][] SUSTITUTOS = {
        {"Swis721 BT", "Segoe UI"},
        {"Swis721 Cn BT", "Segoe UI"},
        {"Segoe UI Semilight", "Segoe UI"},
        {"Segoe UI Light", "Segoe UI"},
        {"Segoe UI Historic", "Segoe UI"},
    };

    /** Familias instaladas en el equipo, mas la fuente logica siempre disponible. */
    private static final Set<String> DISPONIBLES = new HashSet<>();

    static {
        DISPONIBLES.addAll(Arrays.asList(
                GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames()));
        DISPONIBLES.add(Font.SANS_SERIF);
        DISPONIBLES.add(Font.SERIF);
        DISPONIBLES.add(Font.MONOSPACED);
    }

    private Tipografia() {
        // Clase de utileria: no se instancia.
    }

    /**
     * Devuelve la familia pedida si esta disponible. Si no, busca una
     * alternativa conocida y, como ultimo recurso, la sans serif del
     * sistema, que siempre resuelve en cualquier plataforma.
     */
    private static String resolverFamilia(String familia) {
        if (familia == null || DISPONIBLES.contains(familia)) {
            return familia;
        }
        for (String[] par : SUSTITUTOS) {
            if (par[0].equals(familia) && DISPONIBLES.contains(par[1])) {
                return par[1];
            }
        }
        return Font.SANS_SERIF;
    }

    /** Resuelve una fuente conservando su tamano y su estilo. */
    public static Font resolver(Font fuente) {
        if (fuente == null) {
            return new Font(Font.SANS_SERIF, Font.PLAIN, 12);
        }
        String familia = resolverFamilia(fuente.getFamily());
        if (familia.equals(fuente.getFamily())) {
            return fuente;
        }
        return new Font(familia, fuente.getStyle(), fuente.getSize());
    }

    /**
     * Aplica la resolucion a un componente y a todos sus descendientes.
     * Se invoca despues de initComponents() para no tocar el codigo
     * generado por el diseñador de NetBeans.
     */
    public static void aplicar(Component raiz) {
        if (raiz == null) {
            return;
        }
        Font actual = raiz.getFont();
        if (actual != null) {
            raiz.setFont(resolver(actual));
        }
        if (raiz instanceof Container contenedor) {
            for (Component hijo : contenedor.getComponents()) {
                aplicar(hijo);
            }
        }
    }
}
