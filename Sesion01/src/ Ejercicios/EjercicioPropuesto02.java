package lab01;

import java.util.Scanner;

public class EjercicioPropuesto02{
	
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arreglo = new int[10];
        
        System.out.println("Ingrese 10 números enteros en orden creciente:");
        
        System.out.print("Número 1: ");
        arreglo[0] = scanner.nextInt();
        
        for (int i = 1; i < arreglo.length; i++) {
            int numero;
            do {
                System.out.print("Número " + (i + 1) + ": ");
                numero = scanner.nextInt();
                
                if (numero <= arreglo[i - 1]) {
                    System.out.println("El número debe ser mayor que el anterior (" + arreglo[i - 1] + "). Intente de nuevo.");
                }
            } while (numero <= arreglo[i - 1]);
            
            arreglo[i] = numero;
        }
        
        System.out.println("Arreglo ingresado:");
        for (int num : arreglo) {
            System.out.print(num + " ");
        }
    }
}
