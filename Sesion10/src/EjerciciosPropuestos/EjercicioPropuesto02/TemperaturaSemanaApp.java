package EjerciciosPropuestos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperaturaSemanaApp extends JFrame {
    private JTextField[] camposTemperatura = new JTextField[7];
    private JPanel panelGrafico;
    private String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"}; // Variable de instancia

    public TemperaturaSemanaApp() {
        setTitle("Registro de Temperaturas Semanales");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear panel principal
        JPanel panelPrincipal = new JPanel(new BorderLayout());

        // Panel para los campos de texto
        JPanel panelEntrada = new JPanel();
        panelEntrada.setLayout(new GridLayout(2, 7, 10, 10)); // 2 filas y 7 columnas

        for (int i = 0; i < 7; i++) {
            panelEntrada.add(new JLabel(dias[i], SwingConstants.CENTER)); // Etiquetas centradas
            camposTemperatura[i] = new JTextField();
            panelEntrada.add(camposTemperatura[i]);
        }

        // Crear botón y panel para el botón
        JButton botonMostrar = new JButton("Mostrar Gráfico");
        botonMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelGrafico.repaint();
            }
        });

        JPanel panelBoton = new JPanel();
        panelBoton.add(botonMostrar);

        // Panel para el gráfico
        panelGrafico = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                dibujarGrafico(g);
            }
        };
        panelGrafico.setPreferredSize(new Dimension(500, 200));

        // Añadir paneles al frame
        panelPrincipal.add(panelEntrada, BorderLayout.NORTH);
        panelPrincipal.add(panelBoton, BorderLayout.CENTER);
        panelPrincipal.add(panelGrafico, BorderLayout.SOUTH);

        add(panelPrincipal);
    }

    private void dibujarGrafico(Graphics g) {
        int width = panelGrafico.getWidth();
        int height = panelGrafico.getHeight();
        
        int margin = 50;
        int[] temperaturas = new int[7];
        
        try {
            for (int i = 0; i < 7; i++) {
                temperaturas[i] = Integer.parseInt(camposTemperatura[i].getText());
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese valores numéricos válidos para cada día.");
            return;
        }
        
        int espacio = (width - 2 * margin) / 6;
        int maxTemperatura = 50;
        
        int[] puntosY = new int[7];
        for (int i = 0; i < 7; i++) {
            puntosY[i] = height - margin - (temperaturas[i] * (height - 2 * margin) / maxTemperatura);
        }
        
        g.setColor(Color.BLUE);
        for (int i = 0; i < 6; i++) {
            g.drawLine(margin + i * espacio, puntosY[i], margin + (i + 1) * espacio, puntosY[i + 1]);
        }
        
        g.setColor(Color.RED);
        for (int i = 0; i < 7; i++) {
            g.fillOval(margin + i * espacio - 5, puntosY[i] - 5, 10, 10);
        }
        
        g.setColor(Color.BLACK);
        g.drawLine(margin, height - margin, width - margin, height - margin);
        g.drawLine(margin, height - margin, margin, margin);
        
        for (int i = 0; i < 7; i++) {
            g.drawString(dias[i], margin + i * espacio - 10, height - margin + 20);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TemperaturaSemanaApp app = new TemperaturaSemanaApp();
            app.setVisible(true);
        });
    }
}
