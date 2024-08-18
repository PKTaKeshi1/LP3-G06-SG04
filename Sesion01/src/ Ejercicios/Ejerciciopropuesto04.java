public class Main {
    public static void EjercicioPropuesto04(String[] args) {
        double num1 = 5.3;
        double num2 = 2.8;
        double num3 = 7.6;

        double menorNumero = menor(num1, num2, num3);
        System.out.println("El menor de los tres números es: " + menorNumero);
    }

    public static double menor(double a, double b, double c) {
        return Math.min(a, Math.min(b, c));
    }
}
