import java.io.*;

public class ManejoExcepcionesCaracter {

    public static void procesar(char c) throws ExcepcionVocal, ExcepcionNumero, ExcepcionBlanco, ExcepcionSalida {
        if (Character.isDigit(c)) throw new ExcepcionNumero("Se ingresó un número.");
        if (Character.isWhitespace(c)) throw new ExcepcionBlanco("Se ingresó un espacio en blanco.");
        if ("aeiouAEIOU".indexOf(c) >= 0) throw new ExcepcionVocal("Se ingresó una vocal.");
        if (c == 'x' || c == 'X') throw new ExcepcionSalida("Se ingresó el carácter de salida.");
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            char c;
            while (true) {
                System.out.print("Ingresa un carácter: ");
                c = (char) reader.read();
                reader.readLine();  // Limpiar el buffer
                try {
                    procesar(c);
                    System.out.println("Carácter procesado: " + c);
                } catch (ExcepcionVocal | ExcepcionNumero | ExcepcionBlanco e) {
                    System.out.println(e.getMessage());
                } catch (ExcepcionSalida e) {
                    System.out.println(e.getMessage());
                    break; // Finaliza el programa
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ExcepcionVocal extends Exception {
    public ExcepcionVocal(String message) {
        super(message);
    }
}

class ExcepcionNumero extends Exception {
    public ExcepcionNumero(String message) {
        super(message);
    }
}

class ExcepcionBlanco extends Exception {
    public ExcepcionBlanco(String message) {
        super(message);
    }
}

class ExcepcionSalida extends Exception {
    public ExcepcionSalida(String message) {
        super(message);
    }
}
