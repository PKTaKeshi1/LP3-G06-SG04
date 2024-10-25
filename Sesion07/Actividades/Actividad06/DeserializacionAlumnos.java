package Sesion07.src.Actividades.Actividad06;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializacionAlumnos {
    public static void main(String[] args) {
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("alumnos.dat"))) {
            Alumno alumno1 = (Alumno) entrada.readObject();
            Alumno alumno2 = (Alumno) entrada.readObject();
            Alumno alumno3 = (Alumno) entrada.readObject();

            System.out.println("Objetos de Alumno deserializados:");
            System.out.println(alumno1);
            System.out.println(alumno2);
            System.out.println(alumno3);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al deserializar los objetos: " + e.getMessage());
        }
    }
}
