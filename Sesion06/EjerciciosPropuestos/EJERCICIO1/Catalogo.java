package s06;

import java.util.ArrayList;
import java.util.List;

public class Catalogo {
    private List<Producto> productos;

    public Catalogo() {
        productos = new ArrayList<>();
        // Algunos productos iniciales (opcional)
        productos.add(new Producto("Pocion", 10.0, "Restaura salud."));
        productos.add(new Producto("Espada", 25.0, "Espada afilada ."));
        productos.add(new Producto("Escudo", 15.0, "Escudo resistente."));
    }

    public List<Producto> obtenerProductos() {
        return productos;
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public void eliminarProducto(String nombre) {
        Producto producto = buscarProducto(nombre);
        if (producto != null) {
            productos.remove(producto);
        }
    }

    private Producto buscarProducto(String nombre) {
        for (Producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                return producto;
            }
        }
        return null;
    }
}