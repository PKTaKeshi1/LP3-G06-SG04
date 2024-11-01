package EjerciciosPropuestos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GestorRegistros {
    private List<Persona> registros;
    private int idCounter = 1;

    public GestorRegistros() {
        this.registros = new ArrayList<>();
    }

    public void agregarRegistro(String nombre, int edad, String ciudad) {
        registros.add(new Persona(idCounter++, nombre, edad, ciudad));
        System.out.println("Registro agregado exitosamente.");
    }

    public void eliminarRegistro(int id) {
        registros.removeIf(persona -> persona.getId() == id);
        System.out.println("Registro eliminado (si existía).");
    }

    public void actualizarRegistro(int id, String nuevoNombre, int nuevaEdad, String nuevaCiudad) {
        for (Persona persona : registros) {
            if (persona.getId() == id) {
                persona = new Persona(id, nuevoNombre, nuevaEdad, nuevaCiudad);
                System.out.println("Registro actualizado.");
                return;
            }
        }
        System.out.println("Registro no encontrado.");
    }

    public List<Persona> consultarRegistros(List<String> campos, String campoCondicion, String valorCondicion, 
                                            String campoOrden, boolean descendente, int limite) {
        List<Persona> resultados = registros.stream()
            .filter(p -> {
                if (campoCondicion != null && valorCondicion != null) {
                    switch (campoCondicion) {
                        case "nombre": return p.getNombre().equals(valorCondicion);
                        case "edad": return Integer.toString(p.getEdad()).equals(valorCondicion);
                        case "ciudad": return p.getCiudad().equals(valorCondicion);
                        default: return true;
                    }
                }
                return true;
            })
            .sorted((p1, p2) -> {
                int comparacion = 0;
                if (campoOrden != null) {
                    switch (campoOrden) {
                        case "nombre": comparacion = p1.getNombre().compareTo(p2.getNombre()); break;
                        case "edad": comparacion = Integer.compare(p1.getEdad(), p2.getEdad()); break;
                        case "ciudad": comparacion = p1.getCiudad().compareTo(p2.getCiudad()); break;
                    }
                    return descendente ? -comparacion : comparacion;
                }
                return comparacion;
            })
            .limit(limite)
            .collect(Collectors.toList());

        resultados.forEach(persona -> {
            System.out.println("Registro:");
            if (campos.contains("id")) System.out.println("ID: " + persona.getId());
            if (campos.contains("nombre")) System.out.println("Nombre: " + persona.getNombre());
            if (campos.contains("edad")) System.out.println("Edad: " + persona.getEdad());
            if (campos.contains("ciudad")) System.out.println("Ciudad: " + persona.getCiudad());
            System.out.println("-----------");
        });

        return resultados;
    }
}
