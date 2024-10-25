package Sesion07.src.Actividades.Actividad07;

import java.io.IOException;  // Importa todas las clases de javax.swing
import java.nio.file.*;
import javax.swing.*;

public class DemoJFileChooser extends JFrame {
    private final JTextArea areaSalida;

    public DemoJFileChooser() throws IOException {
        super("Demo de JFileChooser");
        areaSalida = new JTextArea();
        add(new JScrollPane(areaSalida)); // areaSalida cuenta con controles deslizables
        analizarRuta(); // obtiene el objeto Path del usuario y muestra la información
    }

    // crea un objeto Path con la ruta al archivo o directorio seleccionado por el usuario
    public void analizarRuta() throws IOException {
        Path ruta = obtenerRutaArchivoDirectorio();

        if (ruta == null) {
            JOptionPane.showMessageDialog(this, "No se seleccionó ningún archivo o directorio.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (Files.exists(ruta)) {
            StringBuilder builder = new StringBuilder();
            builder.append(String.format("%s:%n", ruta.getFileName()));
            builder.append(String.format("%s un directorio", Files.isDirectory(ruta) ? "Es" : "No es"));
            builder.append(String.format("%s una ruta absoluta", ruta.isAbsolute() ? "Es" : "No es"));
            builder.append(String.format("Última modificación: %s%n", Files.getLastModifiedTime(ruta)));
            builder.append(String.format("Tamaño: %s%n", Files.size(ruta)));
            builder.append(String.format("Ruta: %s%n", ruta));
            builder.append(String.format("Ruta absoluta: %s%n", ruta.toAbsolutePath()));

            if (Files.isDirectory(ruta)) {
                builder.append(String.format("%nContenido del directorio:%n"));
                DirectoryStream<Path> flujoDirectorio = Files.newDirectoryStream(ruta);
                for (Path p : flujoDirectorio) {
                    builder.append(String.format("%s%n", p));
                }
            }

            areaSalida.setText(builder.toString()); // muestra el contenido del objeto String
        } else {
            JOptionPane.showMessageDialog(this, ruta.getFileName() + " no existe.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    private Path obtenerRutaArchivoDirectorio() {
        JFileChooser selectorArchivos = new JFileChooser();
        selectorArchivos.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        int resultado = selectorArchivos.showOpenDialog(this);
        if (resultado == JFileChooser.CANCEL_OPTION) {
            System.exit(1);
        }

        return selectorArchivos.getSelectedFile() != null ? selectorArchivos.getSelectedFile().toPath() : null;
    }
}
