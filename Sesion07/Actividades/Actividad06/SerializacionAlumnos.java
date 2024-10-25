package Sesion07.src.Actividades.Actividad06;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializacionAlumnos {
    public static void main(String[] args) {
        Alumno alumno1 = new Alumno("Juan Perez", 20, new Fecha(15, 3, 2021));
        Alumno alumno2 = new Alumno("Ana Gomez", 22, new Fecha(8, 9, 2020));
        Alumno alumno3 = new Alumno("Luis Martinez", 21, new Fecha(1, 11, 2019));

        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("alumnos.dat"))) {
            salida.writeObject(alumno1);
            salida.writeObject(alumno2);
            salida.writeObject(alumno3);
            System.out.println("Objetos de Alumno serializados correctamente.");
        } catch (IOException e) {
            System.err.println("Error al serializar los objetos: " + e.getMessage());
        }
    }
}
