package s06;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Carrito carrito = new Carrito();
        HistorialCompras historialCompras = new HistorialCompras();
        Catalogo catalogo = new Catalogo();
        CarritoView vista = new CarritoView();
        CarritoController controlador = new CarritoController(carrito, historialCompras, catalogo, vista);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Listar productos disponibles");
            System.out.println("2. Agregar producto al carrito");
            System.out.println("3. Eliminar producto del carrito");
            System.out.println("4. Ver carrito");
            System.out.println("5. Calcular envío");
            System.out.println("6. Aplicar descuento");
            System.out.println("7. Realizar compra");
            System.out.println("8. Ver historial de compras");
            System.out.println("9. Agregar producto al catálogo");
            System.out.println("10. Eliminar producto del catálogo");
            System.out.println("11. Salir");
            System.out.print("Seleccione una opción: ");
            try {
                int opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    controlador.listarProductosDisponibles();
                    break;
                case 2:
                    System.out.print("Nombre del producto a agregar: ");
                    String nombreAgregar = scanner.nextLine();
                    controlador.agregarProducto(nombreAgregar);
                    break;
                case 3:
                    System.out.print("Nombre del producto a eliminar: ");
                    String nombreEliminar = scanner.nextLine();
                    controlador.eliminarProducto(nombreEliminar);
                    break;
                case 4:
                    controlador.verCarrito();
                    break;
                case 5:
                    System.out.print("Tarifa de envío: ");
                    double tarifaEnvio = scanner.nextDouble();
                    scanner.nextLine();
                    controlador.calcularEnvio(tarifaEnvio);
                    break;
                case 6:
                    System.out.print("Porcentaje de descuento: ");
                    double porcentajeDescuento = scanner.nextDouble();
                    scanner.nextLine();
                    controlador.aplicarDescuento(porcentajeDescuento);
                    break;
                case 7:
                	controlador.realizarCompra();
                    break;
                case 8:
                	controlador.verHistorialCompras();
                    break;
                case 9:
                    System.out.print("Nombre del producto: ");
                    String nombreProducto = scanner.nextLine();
                    System.out.print("Precio del producto: ");
                    double precioProducto = scanner.nextDouble();
                    scanner.nextLine(); // Limpiar buffer
                    System.out.print("Descripción del producto: ");
                    String descripcionProducto = scanner.nextLine();
                    controlador.agregarProductoAlCatalogo(nombreProducto, precioProducto, descripcionProducto);
                    break;

                case 10:
                    System.out.print("Nombre del producto a eliminar del catálogo: ");
                    String nombreEliminar1 = scanner.nextLine();
                    controlador.eliminarProductoDelCatalogo(nombreEliminar1);
                    break;

                case 11:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción no válida. Digite un número del 1 al 11.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrada no válida. Por favor, digite un número del 1 al 11.");
        }
    }
}
}