import java.util.List;
import java.util.Scanner;

public class Vista {
    Scanner scanner = new Scanner(System.in);

    public void mostrarMenu() {
        System.out.println("Opciones:");
        System.out.println("1. Listar todos los empleados");
        System.out.println("2. Agregar un nuevo empleado");
        System.out.println("3. Buscar un empleado por su número");
        System.out.println("4. Eliminar un empleado por su número");
        System.out.println("0. Salir");
        System.out.print("Selecciona una opción: ");
    }

    public void mostrarEmpleados(Controlador controlador) {
        List<Empleado> empleados = controlador.getEmpleados();
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
        } else {
            for (Empleado empleado : empleados) {
                System.out.println(empleado);
            }
        }
    }

    public Empleado obtenerDatosEmpleado() {
        System.out.print("Número: ");
        int numero = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Sueldo: ");
        double sueldo = scanner.nextDouble();
        return new Empleado(numero, nombre, sueldo);
    }

    public int obtenerNumero() {
        System.out.print("Introduce el número del empleado: ");
        return scanner.nextInt();
    }
}
