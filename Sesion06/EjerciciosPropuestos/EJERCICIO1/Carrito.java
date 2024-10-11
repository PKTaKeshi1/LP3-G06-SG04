package s06;

import java.util.ArrayList;
import java.util.List;

public class Carrito {
    private List<Producto> productos;

    public Carrito() {
        productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public void eliminarProducto(Producto producto) {
        productos.remove(producto);
    }

    public List<Producto> obtenerProductos() {
        return productos;
    }

    public double calcularTotal() {
        double total = 0;
        for (Producto producto : productos) {
            total += producto.getPrecio();
        }
        return total;
    }

    public void aplicarDescuento(double porcentaje) {
        double total = calcularTotal();
        double descuento = total * (porcentaje / 100);
        total -= descuento;
        System.out.println("Descuento aplicado: " + descuento);
        System.out.println("Total después de aplicar descuento: " + total);
    }
}