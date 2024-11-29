package s11;
import java.util.ArrayList;
import java.util.List;
//Clase Notificacion (Sujeto)
class Notificacion {
    private List<Observer> usuarios = new ArrayList<>();

    public void suscribir(Observer usuario) {
        if (usuarios.contains(usuario)) {
            System.out.println(((Usuario) usuario).getNombre() + " ya está suscrito.");
        } else {
            usuarios.add(usuario);
            System.out.println(((Usuario) usuario).getNombre() + " se ha suscrito a las notificaciones.");
        }
    }

    public void desuscribir(Observer usuario) {
        usuarios.remove(usuario);
        System.out.println(((Usuario) usuario).getNombre() + " se ha desuscrito de las notificaciones.");
    }

    public void enviarNotificacion(String mensaje) {
        System.out.println("Enviando notificación: " + mensaje);
        for (Observer usuario : usuarios) {
            usuario.update(mensaje);
        }
    }

    public boolean estaSuscrito(Observer usuario) {
        return usuarios.contains(usuario);
    }
}