import java.util.Scanner;
public class EjercicioPropuesto05{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
		System.out.print("Introduce la cantidad de horas: ");
		int horas =scanner.nextInt();
		
        double cargo = calcularCargo(horas);
        System.out.println("El cargo por " + horas + " horas es: S/" + cargo);
    }

    public static double calcularCargo(int horas) {
        double cargo = 3.00;

        if (horas > 1) {
            cargo += (horas - 1) * 0.50;
        }

        if (cargo > 12.00) {
            cargo = 12.00;
        }

        return cargo;
    }
}
