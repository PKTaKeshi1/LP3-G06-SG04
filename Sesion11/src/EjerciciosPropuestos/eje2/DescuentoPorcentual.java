package s111;
import java.util.ArrayList;
import java.util.List;
public class DescuentoPorcentual implements EstrategiaDescuento {
    @Override
    public double calcularPrecioFinal(List<Producto> productos) {
        double total = 0.0;
        List<Producto> procesados = new ArrayList<>();
        for (Producto p : productos) {
            if (!procesados.contains(p)) {
                long count = productos.stream().filter(x -> x.equals(p)).count();
                if (count >= 2) {
                    total += p.getPrecio() * count * 0.70; // 30% de descuento
                } else {
                    total += p.getPrecio();
                }
                procesados.add(p);
            }
        }
        return total;
    }
}
