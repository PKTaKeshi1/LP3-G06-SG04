package s11;
import java.util.ArrayList;
import java.util.List;

// Interfaz Observer
interface Observer {
    void update(String mensaje);
}

// Clase concreta Usuario (Observador)
//Clase concreta Usuario (Observador)
class Usuario implements Observer {
 private String nombre;

 public Usuario(String nombre) {
     this.nombre = nombre;
 }

 @Override
 public void update(String mensaje) {
     System.out.println(nombre + " recibió: " + mensaje);
 }

 public String getNombre() {
     return nombre;
 }
}