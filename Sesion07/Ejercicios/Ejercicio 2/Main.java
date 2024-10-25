import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Gestor gestor = new Gestor("personajes.txt");
        while (true) {
            System.out.println("Opciones:");
            System.out.println("1. Mostrar personajes");
            System.out.println("2. Añadir personaje");
            System.out.println("3. Modificar personaje");
            System.out.println("4. Borrar personaje");
            System.out.println("5. Filtrar personajes por atributo");
            System.out.println("6. Mostrar estadísticas");
            System.out.println("7. Importar personajes desde un archivo");
            System.out.println("8. Mejorar atributos por nivel");
            System.out.println("9. Cargar personajes aleatorios"); // Nueva opción
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer
            switch (opcion) {
                case 1:
                    gestor.mostrarPersonajes();
                    break;
                case 2:
                    System.out.print("Nombre del personaje: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Vida: ");
                    int vida = scanner.nextInt();
                    System.out.print("Ataque: ");
                    int ataque = scanner.nextInt();
                    System.out.print("Defensa: ");
                    int defensa = scanner.nextInt();
                    System.out.print("Alcance: ");
                    int alcance = scanner.nextInt();
                    gestor.añadirPersonaje(new Personaje(nombre, vida, ataque, defensa, alcance));
                    break;
                case 3:
                    System.out.print("Nombre del personaje a modificar: ");
                    String nombreModificar = scanner.nextLine();
                    System.out.print("Nueva Vida: ");
                    int nuevaVida = scanner.nextInt();
                    System.out.print("Nuevo Ataque: ");
                    int nuevoAtaque = scanner.nextInt();
                    System.out.print("Nueva Defensa: ");
                    int nuevaDefensa = scanner.nextInt();
                    System.out.print("Nuevo Alcance: ");
                    int nuevoAlcance = scanner.nextInt();
                    gestor.modificarPersonaje(nombreModificar, nuevaVida, nuevoAtaque, nuevaDefensa, nuevoAlcance);
                    break;
                case 4:
                    System.out.print("Nombre del personaje a borrar: ");
                    String nombreBorrar = scanner.nextLine();
                    gestor.borrarPersonaje(nombreBorrar);
                    break;
                case 5:
                    System.out.print("Atributo por el que filtrar (vida, ataque, defensa, alcance): ");
                    String atributo = scanner.nextLine();
                    gestor.filtrarPersonajesPorAtributo(atributo);
                    break;
                case 6:
                    gestor.mostrarEstadisticas();
                    break;
                case 7:
                    System.out.print("Ruta del archivo a importar: ");
                    String rutaImportar = scanner.nextLine();
                    gestor.importarPersonajesDesdeArchivo(rutaImportar);
                    break;
                case 8:
                    System.out.print("Nombre del personaje a mejorar: ");
                    String nombreMejorar = scanner.nextLine();
                    System.out.print("Nivel para mejorar: ");
                    int nivel = scanner.nextInt();
                    gestor.mejorarAtributosConNiveles(nombreMejorar, nivel);
                    break;
                case 9:
                    System.out.print("¿Cuántos personajes aleatorios desea cargar? ");
                    int cantidadAleatorios = scanner.nextInt();
                    gestor.cargarPersonajesAleatorios(cantidadAleatorios); // Llama al método para cargar personajes aleatorios
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        }
    }
}
