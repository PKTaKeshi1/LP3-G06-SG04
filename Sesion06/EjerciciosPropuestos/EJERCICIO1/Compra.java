package s06;

import java.util.List;

public class Compra {
    private List<Producto> productosComprados;
    private double total;
    private double descuentoAplicado;
    private double envioAplicado;

    public Compra(List<Producto> productos, double total, double descuentoAplicado, double envioAplicado) {
        this.productosComprados = productos;
        this.total = total;
        this.descuentoAplicado = descuentoAplicado;
        this.envioAplicado = envioAplicado;
    }

    public List<Producto> getProductosComprados() {
        return productosComprados;
    }

    public double getTotal() {
        return total;
    }

    public double getDescuentoAplicado() {
        return descuentoAplicado;
    }

    public double getEnvioAplicado() {
        return envioAplicado;
    }
}