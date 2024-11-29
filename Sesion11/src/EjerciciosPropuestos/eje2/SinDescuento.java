package s111;
import java.util.List;
public class SinDescuento implements EstrategiaDescuento {
    @Override
    public double calcularPrecioFinal(List<Producto> productos) {
        return productos.stream().mapToDouble(Producto::getPrecio).sum();
    }
}
