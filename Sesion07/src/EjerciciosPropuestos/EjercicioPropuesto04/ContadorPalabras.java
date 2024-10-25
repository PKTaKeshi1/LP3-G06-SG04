package Sesion07.src.EjerciciosPropuestos.EjercicioPropuesto04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import javax.swing.*;

public class ContadorPalabras {
    public static void main(String[] args) {
        File archivo = seleccionarArchivo();

        if (archivo != null && archivo.exists()) {
            try {
                contarContenidoArchivo(archivo);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error al leer el archivo: " + e.getMessage());
            }
        }
    }

    private static File seleccionarArchivo() {
        JFileChooser selector = new JFileChooser();
        int resultado = selector.showOpenDialog(null);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            return selector.getSelectedFile();
        } else {
            JOptionPane.showMessageDialog(null, "Operación cancelada. No se seleccionó ningún archivo.");
            return null;
        }
    }

    private static void contarContenidoArchivo(File archivo) throws IOException {
        int totalLineas = 0;
        int totalPalabras = 0;
        int totalCaracteres = 0;
        Map<String, Integer> contadorPalabras = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                totalLineas++;
                totalCaracteres += linea.length(); // Contar caracteres de la línea

                // Tokenizar la línea en palabras
                StringTokenizer tokenizer = new StringTokenizer(linea);
                while (tokenizer.hasMoreTokens()) {
                    String palabra = tokenizer.nextToken();
                    // Comprobar si es una palabra válida (solo letras y dígitos)
                    if (esPalabraValida(palabra)) {
                        totalPalabras++;
                        contadorPalabras.put(palabra, contadorPalabras.getOrDefault(palabra, 0) + 1);
                    }
                }
            }
        }

        // Mostrar resultados
        System.out.println("Total de líneas: " + totalLineas);
        System.out.println("Total de palabras: " + totalPalabras);
        System.out.println("Total de caracteres: " + totalCaracteres);
        if (totalLineas > 0) {
            System.out.printf("Promedio de palabras por línea: %.2f%n", (double) totalPalabras / totalLineas);
        }

        // Mostrar palabras más frecuentes
        mostrarPalabrasFrecuentes(contadorPalabras);
    }

    private static boolean esPalabraValida(String palabra) {
        for (char c : palabra.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) {
                return false; // Si contiene un carácter no válido
            }
        }
        return true; // Es una palabra válida
    }

    private static void mostrarPalabrasFrecuentes(Map<String, Integer> contadorPalabras) {
        if (contadorPalabras.isEmpty()) {
            System.out.println("No se encontraron palabras válidas en el archivo.");
            return;
        }

        int maxFrecuencia = 0;
        for (int frecuencia : contadorPalabras.values()) {
            if (frecuencia > maxFrecuencia) {
                maxFrecuencia = frecuencia;
            }
        }

        System.out.println("Palabras más frecuentes:");
        for (Map.Entry<String, Integer> entry : contadorPalabras.entrySet()) {
            if (entry.getValue() == maxFrecuencia) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }
}
