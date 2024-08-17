package lab01;

import java.util.Scanner;

public class EjercicioPropuesto01{

	public static void main(String[]args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Introduce el tammaño del arreglo: ");
		int n =scanner.nextInt();
		
		int[] arreglo = new int[n];
		System.out.println("Introduce los elementeos del arreglo: ");
		leerArreglo(scanner, arreglo);
		
		double rpta = calcularPromedio(arreglo);
		System.out.println("La suma de los elemetos es: " + rpta);
		
	}
	public static void leerArreglo(Scanner scanner, int [] arreglo) {
		for (int i=0; i<arreglo.length;i++) {
			arreglo[i]=scanner.nextInt();
		}
	}
	public static double calcularPromedio(int[]arreglo) {
		int suma=0;
		for(int num: arreglo) {
			suma+=num;
		}
		return(double) suma;
	}

}
