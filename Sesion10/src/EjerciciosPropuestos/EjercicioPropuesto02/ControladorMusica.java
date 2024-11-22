package s101;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import javax.sound.sampled.*;
public class ControladorMusica extends JFrame {
    private Clip clip;
    private long pausaPosition = 0; // Guardar la posición de pausa
    public ControladorMusica() {
        setTitle("Controlador de Música");
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(1, 3));
     // Crear botones con imágenes
        JButton btnReproducir = new JButton(new ImageIcon("reproducir.png"));
        JButton btnPausar = new JButton(new ImageIcon("pausar.png"));
        JButton btnReanudar = new JButton(new ImageIcon("reanudar.png"));
        // Agregar listeners
        btnReproducir.addActionListener(e -> reproducirMusica("musica.wav"));
        btnPausar.addActionListener(e -> pausarMusica());
        btnReanudar.addActionListener(e -> reanudarMusica());
        // Añadir botones al frame
        add(btnReproducir);
        add(btnPausar);
        add(btnReanudar);
    }
    private void reproducirMusica(String nombreArchivo) {
        try {
            // Si ya hay un clip cargado, detenerlo para reproducir desde el inicio
            if (clip != null && clip.isRunning()) {
                clip.stop();
                clip.close();
            }
            File archivoMusica = new File(nombreArchivo);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivoMusica);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            pausaPosition = 0; // Reiniciar posición de pausa
            clip.start();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al reproducir la música: " + ex.getMessage());
        }
    }
    private void pausarMusica() {
        if (clip != null && clip.isRunning()) {
            pausaPosition = clip.getMicrosecondPosition(); // Guardar posición actual
            clip.stop();
        }
    }
    private void reanudarMusica() {
        if (clip != null && !clip.isRunning()) {
            clip.setMicrosecondPosition(pausaPosition); // Reanudar desde posición guardada
            clip.start();
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ControladorMusica().setVisible(true));
    }
}
