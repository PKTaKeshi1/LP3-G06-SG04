package s07;
import java.io.*;
import java.util.*;
public class Gestor {
    private List<Personaje> personajes;
    private String archivo;
    public Gestor(String archivo) {
        this.archivo = archivo;
        personajes = new ArrayList<>();
        cargarPersonajes();
    }
    private void cargarPersonajes() {
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                personajes.add(Personaje.fromString(linea));
            }
        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo: " + e.getMessage());
        }
    }
    private void guardarPersonajes() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(archivo))) {
            for (Personaje p : personajes) {
                writer.println(p.toString());
            }
        } catch (IOException e) {
            System.out.println("No se pudo guardar el archivo: " + e.getMessage());
        }
    }
    public void añadirPersonaje(Personaje personaje) {
        if (buscarPersonaje(personaje.getNombre()) == null) {
            personajes.add(personaje);
            guardarPersonajes();
            System.out.println("Personaje añadido correctamente.");
        } else {
            System.out.println("El personaje ya existe.");
        }
    }
    public void modificarPersonaje(String nombre, int vida, int ataque, int defensa, int alcance) {
        Personaje p = buscarPersonaje(nombre);
        if (p != null) {
            p.setVida(vida);
            p.setAtaque(ataque);
            p.setDefensa(defensa);
            p.setAlcance(alcance);
            guardarPersonajes();
            System.out.println("Personaje modificado correctamente.");
        } else {
            System.out.println("El personaje no existe.");
        }
    }
    public void borrarPersonaje(String nombre) {
        Personaje p = buscarPersonaje(nombre);
        if (p != null) {
            personajes.remove(p);
            guardarPersonajes();
            System.out.println("Personaje borrado correctamente.");
        } else {
            System.out.println("El personaje no existe.");
        }
    }
    public void mostrarPersonajes() {
        if (personajes.isEmpty()) {
            System.out.println("No hay personajes.");
        } else {
            // Encabezado
            System.out.println("+-----------------+------+--------+---------+---------+");
            System.out.println("| Nombre          | Vida | Ataque | Defensa | Alcance |");
            System.out.println("+-----------------+------+--------+---------+---------+");
            
            for (Personaje p : personajes) {
                // Imprimir cada personaje con formato
                System.out.printf("| %-15s | %4d | %6d | %7d | %7d |\n",
                        p.getNombre(), p.getVida(), p.getAtaque(), p.getDefensa(), p.getAlcance());
                System.out.println("+-----------------+------+--------+---------+---------+");
            }
        }
    }

    private Personaje buscarPersonaje(String nombre) {
        for (Personaje p : personajes) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                return p;
            }
        }
        return null;
    }
}

