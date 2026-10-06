package proyecto_premier;

import java.awt.Image;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * Carga de iconos de la aplicacion.
 *
 * Los PNG estan en src/img y se buscan como recurso del classpath. Si el
 * recurso no esta disponible se devuelve null en lugar de lanzar una
 * excepcion: la version anterior hacia new ImageIcon(getResource(...)) y
 * como getResource devuelve null cuando el recurso falta, eso terminaba en
 * NullPointerException dentro del constructor. La ventana que abria la
 * instancia ya habia cerrado con dispose(), no quedaba ninguna ventana
 * visible y la JVM terminaba sola, de modo que la aplicacion se cerraba
 * sin mostrar ningun error.
 *
 * Un icono ausente solo puede dejar un boton sin dibujo, nunca impedir que
 * la aplicacion abra.
 */
public final class Iconos {

    private Iconos() {
        // Clase de utileria: no se instancia.
    }

    /**
     * Carga un icono y lo ajusta al tamano indicado.
     *
     * @param ruta  ruta del recurso, por ejemplo "/img/userIconBlanco.png"
     * @param ancho ancho final en pixels
     * @param alto  alto final en pixels
     * @return el icono escalado, o null si el recurso no existe
     */
    public static Icon cargar(String ruta, int ancho, int alto) {
        Icon base = cargar(ruta);
        if (base == null) {
            return null;
        }
        return new ImageIcon(((ImageIcon) base).getImage()
                .getScaledInstance(ancho, alto, Image.SCALE_SMOOTH));
    }

    /**
     * Carga un icono con su tamano original.
     *
     * @return el icono, o null si el recurso no existe
     */
    public static Icon cargar(String ruta) {
        URL recurso = Iconos.class.getResource(ruta);
        if (recurso == null) {
            System.err.println("Icono no encontrado en el classpath: " + ruta);
            return null;
        }
        return new ImageIcon(recurso);
    }
}
