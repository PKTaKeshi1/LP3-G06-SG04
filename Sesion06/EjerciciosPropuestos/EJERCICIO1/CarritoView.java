package s06;

import java.util.List;


public class CarritoView {
    public void mostrarProductos(List<Producto> productos) {
        System.out.println("Productos:");
        for (Producto producto : productos) {
            System.out.println(producto);
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarHistorial(List<Compra> historial) {
        System.out.println("Historial de Compras:");
        for (Compra compra : historial) {
            System.out.println("Compra:");
            for (Producto producto : compra.getProductosComprados()) {
                System.out.println(producto);
            }
            if (compra.getDescuentoAplicado() > 0) {
                System.out.println("Descuento aplicado: " + compra.getDescuentoAplicado());
            }
            if (compra.getEnvioAplicado() > 0) {
                System.out.println("Costo de envío aplicado: " + compra.getEnvioAplicado());
            }
            System.out.println("Total de la compra: " + compra.getTotal());
            System.out.println("---");
        }
    }
}