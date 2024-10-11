package s06;


import java.util.ArrayList;
import java.util.List;

public class HistorialCompras {
    private List<Compra> historial;  // Cambia a List<Compra>

    public HistorialCompras() {
        historial = new ArrayList<>();
    }

    public void agregarCompra(List<Producto> productos, double total, double descuento, double envio) {
        historial.add(new Compra(productos, total, descuento, envio));  // Pasa los datos relevantes
    }

    public List<Compra> obtenerHistorial() {
        return historial;
    }
}