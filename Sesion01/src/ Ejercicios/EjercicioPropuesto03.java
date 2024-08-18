import java.util.Random;

public class EjercicioPropuesto03 {
    public static void main(String[] args) {
        int[] frecuencias = new int[6];
        
        Random random = new Random();

        int lanzamientos = 20000;
        for (int i = 0; i < lanzamientos; i++) {
            int resultado = random.nextInt(6) + 1;
            
            frecuencias[resultado - 1]++;
        }
        for (int i = 0; i < frecuencias.length; i++) {
            System.out.println("Cara " + (i + 1) + ": " + frecuencias[i] + " veces");
        }
    }
}
