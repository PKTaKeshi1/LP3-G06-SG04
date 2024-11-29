package s11;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Notificacion notificacion = new Notificacion();
        List<Usuario> listaUsuarios = new ArrayList<>();
        int opcion;
        do {
            System.out.println("\n=== Menú de Notificaciones ===");
            System.out.println("1. Registrar nuevo usuario");
            System.out.println("2. Suscribir usuario a notificaciones");
            System.out.println("3. Desuscribir usuario de notificaciones");
            System.out.println("4. Enviar notificación");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer
            switch (opcion) {
                case 1: // Registrar nuevo usuario
                    System.out.print("Ingresa el nombre del nuevo usuario: ");
                    String nombre = scanner.nextLine();
                    listaUsuarios.add(new Usuario(nombre));
                    System.out.println("Usuario " + nombre + " registrado con éxito.");
                    break;
                case 2: // Suscribir usuario
                    boolean suscripcionExitosa = false;
                    while (!suscripcionExitosa) {
                        System.out.println("Usuarios disponibles para suscribirse:");
                        for (int i = 0; i < listaUsuarios.size(); i++) {
                            System.out.println((i + 1) + ". " + listaUsuarios.get(i).getNombre());
                        }
                        System.out.print("Elige el número del usuario a suscribir: ");
                        int indiceSuscribir = scanner.nextInt() - 1;

                        if (indiceSuscribir >= 0 && indiceSuscribir < listaUsuarios.size()) {
                            Usuario usuarioSeleccionado = listaUsuarios.get(indiceSuscribir);
                            if (!notificacion.estaSuscrito(usuarioSeleccionado)) {
                                notificacion.suscribir(usuarioSeleccionado);
                                suscripcionExitosa = true;
                            } else {
                                System.out.println("El usuario ya está suscrito. Por favor, selecciona otro.");
                            }
                        } else {
                            System.out.println("Opción inválida.");
                        }
                    }
                    break;
                case 3: // Desuscribir usuario
                    System.out.println("Usuarios suscritos:");
                    for (int i = 0; i < listaUsuarios.size(); i++) {
                        System.out.println((i + 1) + ". " + listaUsuarios.get(i).getNombre());
                    }
                    System.out.print("Elige el número del usuario a desuscribir: ");
                    int indiceDesuscribir = scanner.nextInt() - 1;
                    if (indiceDesuscribir >= 0 && indiceDesuscribir < listaUsuarios.size()) {
                        Usuario usuarioSeleccionado = listaUsuarios.get(indiceDesuscribir);
                        if (notificacion.estaSuscrito(usuarioSeleccionado)) {
                            notificacion.desuscribir(usuarioSeleccionado);
                        } else {
                            System.out.println("El usuario no está suscrito.");
                        }
                    } else {
                        System.out.println("Opción inválida.");
                    }
                    break;
                case 4: // Enviar notificación
                    System.out.print("Ingresa el mensaje de la notificación: ");
                    String mensaje = scanner.nextLine();
                    notificacion.enviarNotificacion(mensaje);
                    break;

                case 5: // Salir
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción inválida. Intenta nuevamente.");
            }
        } while (opcion != 5);
        scanner.close();
    }
}