package s111;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CalculadoraDePrecios calculadora = new CalculadoraDePrecios();
        List<Producto> carrito = new ArrayList<>();
        int opcion;
        do {
            System.out.println("\n=== Menú de Descuentos ===");
            System.out.println("1. Agregar producto al carrito");
            System.out.println("2. Mostrar carrito");
            System.out.println("3. Calcular precio final (Sin descuento)");
            System.out.println("4. Calcular precio final (Descuento fijo 10%)");
            System.out.println("5. Calcular precio final (30% en 2 productos iguales)");
            System.out.println("6. Calcular precio final (50% en producto más barato, 3+ productos)");
            System.out.println("7. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer
            switch (opcion) {
                case 1:
                System.out.print("Nombre del producto: ");
                String nombre = scanner.nextLine();
                System.out.print("Precio del producto: ");
                double precio = scanner.nextDouble();
                carrito.add(new Producto(nombre, precio));
                System.out.println("Producto agregado al carrito.");
                break;
            case 2: // Mostrar carrito
                if (carrito.isEmpty()) {
                    System.out.println("El carrito está vacío.");
                } else {
                    System.out.println("Productos en el carrito:");
                    carrito.forEach(p -> System.out.println("- " + p.getNombre() + ": S/." + p.getPrecio()));
                }
                break;
            case 3: // Sin descuento
                calculadora.setEstrategia(new SinDescuento());
                System.out.println("Precio final: S/." + calculadora.calcular(carrito));
                break;
            case 4: // Descuento fijo
                calculadora.setEstrategia(new DescuentoFijo());
                System.out.println("Precio final: S/." + calculadora.calcular(carrito));
                break;
            case 5: // Descuento porcentual (30% en 2 iguales)
                calculadora.setEstrategia(new DescuentoPorcentual());
                System.out.println("Precio final: S/." + calculadora.calcular(carrito));
                break;
            case 6: // Descuento acumulado (50% en más barato, 3+ productos)
                calculadora.setEstrategia(new DescuentoPorcentualAcumulado());
                System.out.println("Precio final: S/." + calculadora.calcular(carrito));
                break;
            case 7: // Salir
                System.out.println("Saliendo del programa...");
                break;
            default:
                System.out.println("Opción inválida. Intenta nuevamente.");
        }
    } while (opcion != 7);
    scanner.close();
}
}

