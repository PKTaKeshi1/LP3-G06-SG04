import java.util.ArrayList;
import java.util.NoSuchElementException;

public class RegistroEstudiantes {
    private ArrayList<String> estudiantes;

    public RegistroEstudiantes() {
        estudiantes = new ArrayList<>();
    }

    public void agregarEstudiante(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío.");
        }
        estudiantes.add(nombre);
    }

    public String buscarEstudiante(String nombre) {
        for (String estudiante : estudiantes) {
            if (estudiante.equalsIgnoreCase(nombre)) {
                return estudiante;
            }
        }
        throw new NoSuchElementException("Estudiante no encontrado.");
    }

    public static void main(String[] args) {
        RegistroEstudiantes registro = new RegistroEstudiantes();
        try {
            registro.agregarEstudiante("Juan");
            registro.agregarEstudiante(null); // Lanza IllegalArgumentException
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Estudiante encontrado: " + registro.buscarEstudiante("Pedro")); // Lanza NoSuchElementException
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }
}
