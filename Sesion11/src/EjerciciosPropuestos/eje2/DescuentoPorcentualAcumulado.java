package s111;
import java.util.List;
public class DescuentoPorcentualAcumulado implements EstrategiaDescuento {
    @Override
    public double calcularPrecioFinal(List<Producto> productos) {
        if (productos.size() < 3) {
            return productos.stream().mapToDouble(Producto::getPrecio).sum();
        }
        double menorPrecio = productos.stream().mapToDouble(Producto::getPrecio).min().orElse(0);
        double total = productos.stream().mapToDouble(Producto::getPrecio).sum();
        return total - (menorPrecio * 0.50); // Descuento del 50% al más barato
    }
}
