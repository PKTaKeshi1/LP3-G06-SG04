import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class Controlador {
    private final Vista vista;
    private final String rutaArchivo;
    private List<Empleado> empleados;
    public Controlador(Vista vista, String rutaArchivo) {
        this.vista = vista;
        this.rutaArchivo = rutaArchivo;
        this.empleados = new ArrayList<>();
        leerEmpleados();
    }
    public void leerEmpleados() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaArchivo))) {
            empleados = (List<Empleado>) ois.readObject(); // Leer empleados desde el archivo
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado. Se creará un nuevo archivo.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
    public boolean agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
        return guardarEmpleados(); // Guarda los empleados después de agregar
    }
    public boolean eliminarEmpleado(int numero) {
        Empleado empleado = buscarEmpleado(numero);
        if (empleado != null) {
            empleados.remove(empleado);
            return guardarEmpleados(); // Guarda los empleados después de eliminar
        }
        return false;
    }
    public Empleado buscarEmpleado(int numero) {
        for (Empleado empleado : empleados) {
            if (empleado.getNumero() == numero) {
                return empleado;
            }
        }
        return null;
    }
    private boolean guardarEmpleados() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaArchivo))) {
            oos.writeObject(empleados); // Guarda la lista de empleados en el archivo
            return true;
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo: " + e.getMessage());
            return false;
        }
    }
    // Método para obtener la lista de empleados
    public List<Empleado> getEmpleados() {
        return empleados;
    }
    public void iniciar() {
        while (true) {
            vista.mostrarMenu();
            int opcion = vista.scanner.nextInt();
            switch (opcion) {
                case 1:
                    vista.mostrarEmpleados(this);
                    break;
                case 2:
                    Empleado nuevoEmpleado = vista.obtenerDatosEmpleado();
                    if (agregarEmpleado(nuevoEmpleado)) {
                        System.out.println("Empleado agregado exitosamente.");
                    } else {
                        System.out.println("Error al agregar el empleado.");
                    }
                    break;
                case 3:
                    int numeroBuscar = vista.obtenerNumero();
                    Empleado empleado = buscarEmpleado(numeroBuscar);
                    if (empleado != null) {
                        System.out.println(empleado);
                    } else {
                        System.out.println("Empleado no encontrado.");
                    }
                    break;
                case 4:
                    int numeroEliminar = vista.obtenerNumero();
                    if (eliminarEmpleado(numeroEliminar)) {
                        System.out.println("Empleado eliminado exitosamente.");
                    } else {
                        System.out.println("Error al eliminar el empleado.");
                    }
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    return;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        }
    }
}

