import java.io.*;
import java.util.*;
public class Gestor {
    private List<Personaje> personajes;
    private String archivo;

    public Gestor(String archivo) {
        this.archivo = archivo;
        personajes = new ArrayList<>();
        cargarPersonajes();
        cargarPersonajesAleatorios(); // Carga personajes aleatorios al iniciar
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
    private void cargarPersonajesAleatorios() {
        personajes.add(new Personaje("Goku", 100, 50, 30, 5));
        personajes.add(new Personaje("Vegeta", 120, 60, 35, 6));
        personajes.add(new Personaje("Piccolo", 90, 45, 40, 4));
        System.out.println("Personajes aleatorios añadidos.");
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
    public void actualizarAtributo(String nombre, String atributo, int valor) {
        Personaje p = buscarPersonaje(nombre);
        if (p != null) {
            switch (atributo.toLowerCase()) {
                case "vida":
                    p.setVida(valor);
                    break;
                case "ataque":
                    p.setAtaque(valor);
                    break;
                case "defensa":
                    p.setDefensa(valor);
                    break;
                case "alcance":
                    p.setAlcance(valor);
                    break;
                default:
                    System.out.println("Atributo no válido.");
                    return;
            }
            guardarPersonajes();
            System.out.println("Atributo " + atributo + " actualizado correctamente.");
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
            System.out.printf("| %-15s | %4s | %6s | %7s | %7s |\n", "Nombre", "Vida", "Ataque", "Defensa", "Alcance");
            System.out.println("|-----------------|------|--------|---------|---------|");
            for (Personaje p : personajes) {
            	System.out.println(p.toFormattedString());
            }
        }
    }
    public void filtrarPersonajesPorAtributo(String atributo) {
        List<Personaje> filtrados = new ArrayList<>(personajes);
        switch (atributo.toLowerCase()) {
            case "vida":
                filtrados.sort(Comparator.comparingInt(Personaje::getVida));
                break;
            case "ataque":
                filtrados.sort(Comparator.comparingInt(Personaje::getAtaque));
                break;
            case "defensa":
                filtrados.sort(Comparator.comparingInt(Personaje::getDefensa));
                break;
            case "alcance":
                filtrados.sort(Comparator.comparingInt(Personaje::getAlcance));
                break;
            default:
                System.out.println("Atributo no válido para filtrar.");
                return;
        }
        System.out.println("Personajes filtrados por " + atributo + ":");
        for (Personaje p : filtrados) {
            System.out.println(p);
        }
    }
    public void cargarPersonajesAleatorios(int cantidad) {
        Random random = new Random();
        String[] nombres = {"Goku", "Vegeta", "Piccolo", "Frieza", "Cell", "Majin Buu"};
        
        for (int i = 0; i < cantidad; i++) {
            String nombre = nombres[random.nextInt(nombres.length)];
            int vida = random.nextInt(100) + 1; // Vida entre 1 y 100
            int ataque = random.nextInt(50) + 1; // Ataque entre 1 y 50
            int defensa = random.nextInt(30) + 1; // Defensa entre 1 y 30
            int alcance = random.nextInt(10) + 1; // Alcance entre 1 y 10
            
            Personaje nuevoPersonaje = new Personaje(nombre, vida, ataque, defensa, alcance);
            añadirPersonaje(nuevoPersonaje); // Agrega el personaje usando el método existente
        }
        
        System.out.println(cantidad + " personajes aleatorios han sido añadidos.");
    }


    public void mostrarEstadisticas() {
        if (personajes.isEmpty()) {
            System.out.println("No hay personajes.");
            return;
        }
        int totalVida = 0, totalAtaque = 0, totalDefensa = 0, totalAlcance = 0;
        for (Personaje p : personajes) {
            totalVida += p.getVida();
            totalAtaque += p.getAtaque();
            totalDefensa += p.getDefensa();
            totalAlcance += p.getAlcance();
        }
        int totalPersonajes = personajes.size();
        System.out.printf("Total de personajes: %d\n", totalPersonajes);
        System.out.printf("Vida promedio: %.2f\n", totalVida / (double) totalPersonajes);
        System.out.printf("Ataque promedio: %.2f\n", totalAtaque / (double) totalPersonajes);
        System.out.printf("Defensa promedio: %.2f\n", totalDefensa / (double) totalPersonajes);
        System.out.printf("Alcance promedio: %.2f\n", totalAlcance / (double) totalPersonajes);
    }

    public void importarPersonajesDesdeArchivo(String nombreArchivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                personajes.add(Personaje.fromString(linea));
            }
            guardarPersonajes(); // Guardar los personajes después de importar
            System.out.println("Personajes importados desde " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo: " + e.getMessage());
        }
    }

    public void mejorarAtributosConNiveles(String nombre, int nivel) {
        Personaje p = buscarPersonaje(nombre);
        if (p != null) {
            int incremento = nivel * 10; // Aumentar atributos en función del nivel
            p.setVida(p.getVida() + incremento);
            p.setAtaque(p.getAtaque() + incremento / 2);
            p.setDefensa(p.getDefensa() + incremento / 3);
            p.setAlcance(p.getAlcance() + incremento / 4);
            guardarPersonajes();
            System.out.println("Atributos de " + nombre + " mejorados por nivel " + nivel + ".");
        } else {
            System.out.println("El personaje no existe.");
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
