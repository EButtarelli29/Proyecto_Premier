package proyecto_premier;

import java.awt.Color;
import static java.awt.Color.WHITE;


public class Config {
    private static String usuarioActual;
    private static boolean Theme = false;
    public static Color grisOscuro = new Color(51,51,51);
    private static Color bgColor = WHITE;
    private static Color contrastColor = grisOscuro;

    public static void setUsuario(String usuario) {
        usuarioActual = usuario;
    }

    public static String getUsuario() {
        return usuarioActual;
    }
    
    public static Color getBackgroundColor() {
        return bgColor;
    }
    
    public static Color getContrastColor() {
        return contrastColor;
    }
    
    public static void setColores() {
        
        Theme = !Theme;
        
        if(!Theme) {
            bgColor = WHITE;
            contrastColor = grisOscuro;
        } else {
            bgColor = grisOscuro;
            contrastColor = WHITE;
        }
    }
}
