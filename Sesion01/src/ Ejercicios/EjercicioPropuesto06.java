import java.util.Scanner;

public class EjercicioPropuesto06{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el número de horas: ");
        int horas = scanner.nextInt();

        System.out.print("Ingrese el número de minutos: ");
        int minutos = scanner.nextInt();

        System.out.print("Ingrese el número de segundos: ");
        int segundos = scanner.nextInt();

        int totalSegundos = convertirASegundos(horas, minutos, segundos);

        System.out.println("El tiempo total en segundos es: " + totalSegundos);
    }

    public static int convertirASegundos(int horas, int minutos, int segundos) {
        return (horas * 3600) + (minutos * 60) + segundos;
    }
}
