package Sesion07.src.Actividades.Actividad07;

import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class PruebaJFileChooser {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                DemoJFileChooser aplicacion = new DemoJFileChooser();
                aplicacion.setSize(400, 400);
                aplicacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                aplicacion.setVisible(true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
