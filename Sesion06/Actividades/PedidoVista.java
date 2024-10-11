package Sesion06.Actividades;

import java.util.List;
import java.util.Scanner;

public class PedidoVista {
    Scanner scanner;  // Cambié el modificador de acceso a default para permitir el acceso desde el controlador

    public PedidoVista() {
        scanner = new Scanner(System.in);
    }

    public String solicitarNombrePlato() {
        System.out.print("Introduce el nombre del plato: ");
        return scanner.nextLine();
    }

    public String solicitarTipoPlato() {
        System.out.print("Introduce el tipo del plato: ");
        return scanner.nextLine();
    }

    public int solicitarIndicePedido() {
        System.out.print("Introduce el índice del pedido: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Opción inválida. Debes ingresar un número.");
            scanner.next();  // Limpiar la entrada
            System.out.print("Introduce el índice del pedido: ");
        }
        return scanner.nextInt();
    }

    // Método para solicitar el estado del pedido
    public String solicitarEstado() {
        System.out.print("Introduce el estado (Pendiente/Completo): ");
        return scanner.nextLine();
    }

    // Método para capturar la opción del usuario en el menú
    public int solicitarOpcion() {
        System.out.print("Selecciona una opción: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Opción inválida. Debes ingresar un número.");
            scanner.next();  // Limpiar la entrada
            System.out.print("Selecciona una opción: ");
        }
        return scanner.nextInt();
    }

    public void mostrarPedidos(List<Pedido> pedidos) {
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos en la lista.");
        } else {
            System.out.println("Lista de Pedidos:");
            for (Pedido pedido : pedidos) {
                System.out.println("- " + pedido.getNombrePlato() + " (" + pedido.getTipoPlato() + ") - Estado: " + pedido.getEstado());
            }
        }
    }

    public void mostrarMenu() {
        System.out.println("\nOpciones:");
        System.out.println("1. Agregar Pedido");
        System.out.println("2. Mostrar Pedidos");
        System.out.println("3. Eliminar Pedido");
        System.out.println("4. Actualizar Pedido");
        System.out.println("5. Buscar Pedido por Nombre");
        System.out.println("6. Contar Pedidos por Tipo");
        System.out.println("7. Marcar Pedido como Completo");
        System.out.println("8. Mostrar Pedidos por Estado");
        System.out.println("9. Contar Pedidos Pendientes");
        System.out.println("10. Ver Historial de Pedidos");
        System.out.println("11. Salir");
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void cerrarScanner() {
        scanner.close();
    }
}
