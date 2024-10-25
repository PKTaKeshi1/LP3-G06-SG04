package Sesion07.src.Actividades.Actividad02;
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String cadena;

        try (PrintWriter salida = new PrintWriter("texto.txt")){
            System.out.println("Introduce texto. Para acabar introduce la cadena FIN: ");
            cadena = sc.nextLine();
            while (!cadena.equalsIgnoreCase("FIN")){
                salida.println(cadena);
                cadena = sc.nextLine();
            }
        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }

}
