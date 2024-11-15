package Sesion09.src.EjerciciosPropuestos.EjerciciosPropuesto02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CompraPasajeGUI extends JFrame {

    public CompraPasajeGUI() {
        setTitle("Compra de Pasajes");
        setSize(350, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());

        // Configurar constraints para GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Etiquetas y campos de texto
        JLabel labelNombre = new JLabel("Nombre:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(labelNombre, gbc);

        JTextField textNombre = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(textNombre, gbc);

        JLabel labelDocumento = new JLabel("Documento de Identidad:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(labelDocumento, gbc);

        JTextField textDocumento = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(textDocumento, gbc);

        JLabel labelFechaViaje = new JLabel("Fecha de Viaje:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(labelFechaViaje, gbc);

        JTextField textFechaViaje = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(textFechaViaje, gbc);

        // Casillas de verificación para servicios opcionales
        JLabel labelServicios = new JLabel("Servicios Opcionales:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(labelServicios, gbc);

        JCheckBox chkAudifonos = new JCheckBox("Audífonos");
        gbc.gridx = 1;
        gbc.gridy = 3;
        add(chkAudifonos, gbc);

        JCheckBox chkManta = new JCheckBox("Manta");
        gbc.gridx = 1;
        gbc.gridy = 4;
        add(chkManta, gbc);

        JCheckBox chkRevistas = new JCheckBox("Revistas");
        gbc.gridx = 1;
        gbc.gridy = 5;
        add(chkRevistas, gbc);

        // Botones de opción para el piso
        JLabel labelPiso = new JLabel("Piso de Viaje:");
        gbc.gridx = 0;
        gbc.gridy = 6;
        add(labelPiso, gbc);

        JRadioButton radio1erPiso = new JRadioButton("1er Piso");
        JRadioButton radio2doPiso = new JRadioButton("2do Piso");
        ButtonGroup grupoPiso = new ButtonGroup();
        grupoPiso.add(radio1erPiso);
        grupoPiso.add(radio2doPiso);

        gbc.gridx = 1;
        gbc.gridy = 6;
        add(radio1erPiso, gbc);

        gbc.gridx = 1;
        gbc.gridy = 7;
        add(radio2doPiso, gbc);

        // Cuadro combinado para origen y destino
        JLabel labelOrigen = new JLabel("Lugar de Origen:");
        gbc.gridx = 0;
        gbc.gridy = 8;
        add(labelOrigen, gbc);

        JComboBox<String> comboOrigen = new JComboBox<>(new String[]{"Ciudad A", "Ciudad B", "Ciudad C"});
        gbc.gridx = 1;
        gbc.gridy = 8;
        add(comboOrigen, gbc);

        JLabel labelDestino = new JLabel("Lugar de Destino:");
        gbc.gridx = 0;
        gbc.gridy = 9;
        add(labelDestino, gbc);

        JComboBox<String> comboDestino = new JComboBox<>(new String[]{"Ciudad X", "Ciudad Y", "Ciudad Z"});
        gbc.gridx = 1;
        gbc.gridy = 9;
        add(comboDestino, gbc);

        // Lista para calidad de servicio con valor predeterminado
        JLabel labelCalidad = new JLabel("Calidad de Servicio:");
        gbc.gridx = 0;
        gbc.gridy = 10;
        add(labelCalidad, gbc);

        JList<String> listaCalidadServicio = new JList<>(new String[]{"Económico", "Standard", "VIP"});
        listaCalidadServicio.setSelectedIndex(0);  // Seleccionar el primer valor predeterminado
        gbc.gridx = 1;
        gbc.gridy = 10;
        add(new JScrollPane(listaCalidadServicio), gbc);

        // Botón de comando
        JButton btnResumen = new JButton("Mostrar Resumen");
        gbc.gridx = 1;
        gbc.gridy = 11;
        add(btnResumen, gbc);

        // Acción del botón
        btnResumen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = textNombre.getText();
                String documento = textDocumento.getText();
                String fechaViaje = textFechaViaje.getText();
                String servicios = "";
                if (chkAudifonos.isSelected()) servicios += "Audífonos ";
                if (chkManta.isSelected()) servicios += "Manta ";
                if (chkRevistas.isSelected()) servicios += "Revistas ";

                String piso = radio1erPiso.isSelected() ? "1er Piso" : "2do Piso";
                String origen = (String) comboOrigen.getSelectedItem();
                String destino = (String) comboDestino.getSelectedItem();

                // Verificar que haya una selección en la lista
                String calidad = listaCalidadServicio.getSelectedValue();
                if (calidad == null) {
                    calidad = "Económico"; // Valor predeterminado si no se selecciona ninguno
                }

                String resumen = String.format("Nombre: %s\nDocumento: %s\nFecha de Viaje: %s\n" +
                        "Servicios: %s\nPiso: %s\nOrigen: %s\nDestino: %s\nCalidad de Servicio: %s",
                        nombre, documento, fechaViaje, servicios, piso, origen, destino, calidad);

                JOptionPane.showMessageDialog(null, resumen, "Resumen de Compra", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CompraPasajeGUI().setVisible(true));
    }
}
