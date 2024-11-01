package EjerciciosPropuestos;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        GestorRegistros gestor = new GestorRegistros();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Agregar registro");
            System.out.println("2. Eliminar registro");
            System.out.println("3. Actualizar registro");
            System.out.println("4. Consultar registros");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese edad: ");
                    int edad = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ingrese ciudad: ");
                    String ciudad = scanner.nextLine();
                    gestor.agregarRegistro(nombre, edad, ciudad);
                    break;
                case 2:
                    System.out.print("Ingrese el ID del registro a eliminar: ");
                    int idEliminar = scanner.nextInt();
                    scanner.nextLine();
                    gestor.eliminarRegistro(idEliminar);
                    break;
                case 3:
                    System.out.print("Ingrese el ID del registro a actualizar: ");
                    int idActualizar = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ingrese nuevo nombre: ");
                    String nuevoNombre = scanner.nextLine();
                    System.out.print("Ingrese nueva edad: ");
                    int nuevaEdad = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ingrese nueva ciudad: ");
                    String nuevaCiudad = scanner.nextLine();
                    gestor.actualizarRegistro(idActualizar, nuevoNombre, nuevaEdad, nuevaCiudad);
                    break;
                case 4:
                    System.out.println("Ingrese los campos a mostrar (separados por coma): ");
                    List<String> camposAMostrar = List.of(scanner.nextLine().split(","));
                    System.out.print("Campo para filtrar (o deje en blanco): ");
                    String campoCondicion = scanner.nextLine();
                    System.out.print("Valor de condición (o deje en blanco): ");
                    String valorCondicion = scanner.nextLine();
                    System.out.print("Campo para ordenar (o deje en blanco): ");
                    String campoOrden = scanner.nextLine();
                    System.out.print("Orden descendente (true/false): ");
                    boolean descendente = scanner.nextBoolean();
                    System.out.print("Límite de registros a mostrar: ");
                    int limite = scanner.nextInt();
                    scanner.nextLine();
                    gestor.consultarRegistros(camposAMostrar, 
                                              campoCondicion.isEmpty() ? null : campoCondicion, 
                                              valorCondicion.isEmpty() ? null : valorCondicion,
                                              campoOrden.isEmpty() ? null : campoOrden,
                                              descendente, limite);
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 5);
        scanner.close();
    }
}
