package s09;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class MarcoBoton extends JFrame {
    private final JButton botonJButtonSimple; // botón con texto solamente
    private final JButton botonJButtonElegante; // botón con iconos

    // Constructor de MarcoBoton, agrega objetos JButton a JFrame
    public MarcoBoton() {
        super("Ayala Arce Sergio Daniel , Herrera Ramos Edwin Jose");
        setLayout(new FlowLayout());

        // Inicialización del botón simple
        botonJButtonSimple = new JButton("Botón simple"); // botón con texto
        add(botonJButtonSimple); // agrega botonJButtonSimple a JFrame

        // Inicialización del botón elegante con iconos
        Icon insecto1 = new ImageIcon(getClass().getResource("insecto1.png"));
        Icon insecto2 = new ImageIcon(getClass().getResource("insecto2.png"));
        botonJButtonElegante = new JButton("Botón elegante", insecto1); // establece la imagen
        botonJButtonElegante.setRolloverIcon(insecto2); // establece la imagen al pasar el mouse
        add(botonJButtonElegante); // agrega botonJButtonElegante a JFrame

        // Crea un nuevo ManejadorBoton para manejar los eventos de botón
        ManejadorBoton manejador = new ManejadorBoton();
        botonJButtonElegante.addActionListener(manejador);
        botonJButtonSimple.addActionListener(manejador);
    }

    // Clase interna para manejar eventos de botón
    private class ManejadorBoton implements ActionListener {
        // Maneja evento de botón
        @Override
        public void actionPerformed(ActionEvent evento) {
            JOptionPane.showMessageDialog(MarcoBoton.this, String.format(
                "Usted oprimió: %s", evento.getActionCommand()));
        }
    }
}
