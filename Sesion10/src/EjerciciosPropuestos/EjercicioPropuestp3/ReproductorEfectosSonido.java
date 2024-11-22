package s10;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import javax.sound.sampled.*;
public class ReproductorEfectosSonido extends JFrame {
    public ReproductorEfectosSonido() {
        setTitle("Reproductor de Efectos de Sonido");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(1, 3));
        // Crear botones con imágenes
        JButton btnAplausos = new JButton(new ImageIcon("aplausos.png"));
        JButton btnCampana = new JButton(new ImageIcon("campana.png"));
        JButton btnExplosion = new JButton(new ImageIcon("explosion.png"));
        // Agregar listeners
        btnAplausos.addActionListener(e -> reproducirSonido("aplausos.wav"));
        btnCampana.addActionListener(e -> reproducirSonido("campana.wav"));
        btnExplosion.addActionListener(e -> reproducirSonido("explosion.wav"));
        // Añadir botones al frame
        add(btnAplausos);
        add(btnCampana);
        add(btnExplosion);
    }
    private void reproducirSonido(String nombreArchivo) {
        try {
            File archivoSonido = new File(nombreArchivo);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivoSonido);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al reproducir el sonido: " + nombreArchivo + "\n" + ex.getMessage());
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ReproductorEfectosSonido().setVisible(true));
    }
}
