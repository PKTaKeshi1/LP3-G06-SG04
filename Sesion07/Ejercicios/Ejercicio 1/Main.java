package s07;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
    	Gestor gestor = new Gestor("C:\\Users\\ZERYUS\\Desktop\\PROGRAMAS JAVA\\S07\\src\\s07\\personajes.txt");
        Scanner scanner = new Scanner(System.in);
        String opcion;
        do {
            System.out.println("Menú:");
            System.out.println("1. Añadir personaje");
            System.out.println("2. Modificar personaje");
            System.out.println("3. Borrar personaje");
            System.out.println("4. Mostrar personajes");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextLine();
            switch (opcion) {
                case "1":
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Vida: ");
                    int vida = scanner.nextInt();
                    System.out.print("Ataque: ");
                    int ataque = scanner.nextInt();
                    System.out.print("Defensa: ");
                    int defensa = scanner.nextInt();
                    System.out.print("Alcance: ");
                    int alcance = scanner.nextInt();
                    scanner.nextLine();  // Limpiar el buffer
                    gestor.añadirPersonaje(new Personaje(nombre, vida, ataque, defensa, alcance));
                    break;
                case "2":
                    System.out.print("Nombre del personaje a modificar: ");
                    nombre = scanner.nextLine();
                    System.out.print("Nueva vida: ");
                    vida = scanner.nextInt();
                    System.out.print("Nuevo ataque: ");
                    ataque = scanner.nextInt();
                    System.out.print("Nueva defensa: ");
                    defensa = scanner.nextInt();
                    System.out.print("Nuevo alcance: ");
                    alcance = scanner.nextInt();
                    scanner.nextLine();  // Limpiar el buffer
                    gestor.modificarPersonaje(nombre, vida, ataque, defensa, alcance);
                    break;
                case "3":
                    System.out.print("Nombre del personaje a borrar: ");
                    nombre = scanner.nextLine();
                    gestor.borrarPersonaje(nombre);
                    break;
                case "4":
                    gestor.mostrarPersonajes();
                    break;
                case "5":
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (!opcion.equals("5"));
        scanner.close();
    }
}
