abstract class Persona { 
    private String nombre; 
    private String dni; 
     
    public Persona(String nombre, String dni) { 
        this.nombre = nombre; 
        this.dni = dni; 
    } 
    public String getNombre() { 
        return nombre; 
    } 
    public String getDni() { 
        return dni; 
    } 
     
    public abstract void mostrarInformacion(); 
} 

// Clase Estudiante que hereda de Persona 
class Estudiante extends Persona { 
    private int numeroMatricula; 
     
    public Estudiante(String nombre, String dni, int numeroMatricula) { 
        super(nombre, dni); 
        this.numeroMatricula = numeroMatricula; 
    } 
    public int getNumeroMatricula() { 
        return numeroMatricula; 
    } 
    @Override 
    public void mostrarInformacion() { 
        System.out.println("Estudiante: " + getNombre() + " - DNI: " + getDni() + " - Matricula: " 
            + numeroMatricula); 
    } 
} 

// Clase Profesor que hereda de Persona 
class Profesor extends Persona { 
    private String especialidad; 
     
    public Profesor(String nombre, String dni, String especialidad) { 
        super(nombre, dni); 
        this.especialidad = especialidad; 
    } 
    public String getEspecialidad() { 
        return especialidad; 
    }  
    @Override 
    public void mostrarInformacion() { 
        System.out.println("Profesor: " + getNombre() + " - DNI: " + getDni() + " - Especialidad: " 
            + especialidad); 
    } 
} 

// Clase Curso 
class Curso { 
    private static final int MAX_ESTUDIANTES = 30; // Constante 
    private String nombre; 
    private Profesor profesor; 
    private Estudiante[] estudiantes; 
    private int cantidadEstudiantes; 
 
    public Curso(String nombre, Profesor profesor) { 
        this.nombre = nombre; 
        this.profesor = profesor; 
        this.estudiantes = new Estudiante[MAX_ESTUDIANTES]; 
        this.cantidadEstudiantes = 0; 
    } 
    public String getNombre() { 
        return nombre; 
    } 
    public Profesor getProfesor() { 
        return profesor; 
    } 
    public void inscribirEstudiante(Estudiante estudiante) { 
        if (cantidadEstudiantes < MAX_ESTUDIANTES) { 
            estudiantes[cantidadEstudiantes++] = estudiante; 
        } else { 
            System.out.println("Curso lleno"); 
        } 
    } 

    public void mostrarInformacionCurso() {
        System.out.println("Curso: " + nombre);
        profesor.mostrarInformacion();
        System.out.println("Estudiantes inscritos:");
        for (int i = 0; i < cantidadEstudiantes; i++) {
            estudiantes[i].mostrarInformacion();
        }
    }
}

// Clase Principal para ejecutar el programa
public class Main {
    public static void main(String[] args) {
        Profesor profesor = new Profesor("Dr. Juan Pérez", "12345678A", "Matemáticas");
        Curso curso = new Curso("Álgebra", profesor);

        Estudiante est1 = new Estudiante("Ana García", "23456789B", 101);
        Estudiante est2 = new Estudiante("Carlos Rodríguez", "34567890C", 102);

        curso.inscribirEstudiante(est1);
        curso.inscribirEstudiante(est2);
        curso.mostrarInformacionCurso();
    }
}
