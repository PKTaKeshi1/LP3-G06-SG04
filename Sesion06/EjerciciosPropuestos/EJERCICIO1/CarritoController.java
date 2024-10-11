package s06;

import java.util.ArrayList;
import java.util.List;

public class CarritoController {
    private Carrito carrito;
    private HistorialCompras historialCompras;
    private Catalogo catalogo;
    private CarritoView vista;
    private double costoEnvio; // Nueva variable para el costo de envío
    private double porcentajeDescuento;

    public CarritoController(Carrito carrito, HistorialCompras historialCompras, Catalogo catalogo, CarritoView vista) {
        this.carrito = carrito;
        this.historialCompras = historialCompras;
        this.catalogo = catalogo;
        this.vista = vista;
        this.costoEnvio = 0; // Iniciar en 0
        this.porcentajeDescuento = 0; // Iniciar en 0
    }

    public void agregarProducto(String nombre) {
        Producto producto = buscarProducto(nombre);
        if (producto != null) {
            carrito.agregarProducto(producto);
            vista.mostrarMensaje("Producto agregado: " + producto);
        } else {
            vista.mostrarMensaje("Producto no encontrado: " + nombre);
        }
    }

    public void eliminarProducto(String nombre) {
        Producto producto = buscarProductoEnCarrito(nombre);
        if (producto != null) {
            carrito.eliminarProducto(producto);
            vista.mostrarMensaje("Producto eliminado: " + producto.getNombre());
        } else {
            vista.mostrarMensaje("Producto no encontrado en el carrito: " + nombre);
        }
    }

    public void listarProductosDisponibles() {
        vista.mostrarProductos(catalogo.obtenerProductos());
    }

    public void verCarrito() {
        vista.mostrarProductos(carrito.obtenerProductos());
        vista.mostrarMensaje("Total en el carrito: " + carrito.calcularTotal());
    }

    public void calcularEnvio(double tarifaEnvio) {
        this.costoEnvio = tarifaEnvio;
        double total = carrito.calcularTotal() + tarifaEnvio;
        vista.mostrarMensaje("Total con envío: " + total);
    }

    public void aplicarDescuento(double porcentaje) {
        this.porcentajeDescuento = porcentaje; // Guardar el descuento aplicado
        carrito.aplicarDescuento(porcentaje);
    }
    public void verHistorialCompras() {
        List<Compra> compras = historialCompras.obtenerHistorial();
        vista.mostrarMensaje("Historial de Compras:");
        for (Compra compra : compras) {
            vista.mostrarProductos(compra.getProductosComprados());
            
            // Mostrar el descuento si se aplicó
            if (compra.getDescuentoAplicado() > 0) {
                vista.mostrarMensaje("Descuento aplicado: " + compra.getDescuentoAplicado());
            }
            
            // Mostrar el costo de envío si se aplicó
            if (compra.getEnvioAplicado() > 0) {
                vista.mostrarMensaje("Costo de envío aplicado: " + compra.getEnvioAplicado());
            }

            vista.mostrarMensaje("Total de la compra: " + compra.getTotal());
            vista.mostrarMensaje("---");  // Separador entre compras
        }
    }
    public void realizarCompra() {
        // Mostrar los productos y su precio total antes de finalizar la compra
        vista.mostrarMensaje("Resumen de la compra:");
        vista.mostrarProductos(carrito.obtenerProductos());

        double totalCarrito = carrito.calcularTotal();
        double descuentoAplicado = 0;
        double costoEnvioAplicado = 0;

        // Verificar si hay un costo de envío y mostrarlo
        if (costoEnvio > 0) {
            vista.mostrarMensaje("Costo de envío aplicado: " + costoEnvio);
            totalCarrito += costoEnvio;
            costoEnvioAplicado = costoEnvio; // Guardar el costo de envío aplicado
        }

        // Verificar si hay un descuento aplicado y mostrarlo
        if (porcentajeDescuento > 0) {
            double descuento = totalCarrito * (porcentajeDescuento / 100);
            vista.mostrarMensaje("Descuento aplicado: " + descuento);
            totalCarrito -= descuento;
            descuentoAplicado = descuento; // Guardar el descuento aplicado
        }

        vista.mostrarMensaje("Total final: " + totalCarrito);

        // Agregar la compra al historial
        historialCompras.agregarCompra(new ArrayList<>(carrito.obtenerProductos()), totalCarrito, descuentoAplicado, costoEnvioAplicado);
        carrito.obtenerProductos().clear(); // Vaciar carrito después de la compra
        vista.mostrarMensaje("Compra realizada con éxito.");

        // Reiniciar valores de costo de envío y descuento
        costoEnvio = 0;
        porcentajeDescuento = 0;
    }
    private Producto buscarProducto(String nombre) {
        for (Producto producto : catalogo.obtenerProductos()) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                return producto;
            }
        }
        return null;
    }

    private Producto buscarProductoEnCarrito(String nombre) {
        for (Producto producto : carrito.obtenerProductos()) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                return producto;
            }
        }
        return null;
    }
    public void agregarProductoAlCatalogo(String nombre, double precio, String descripcion) {
        Producto producto = new Producto(nombre, precio, descripcion);
        catalogo.agregarProducto(producto);
        vista.mostrarMensaje("Producto agregado al catálogo: " + producto);
    }

    public void eliminarProductoDelCatalogo(String nombre) {
        catalogo.eliminarProducto(nombre);
        vista.mostrarMensaje("Producto eliminado del catálogo: " + nombre);
    }
}