package s0602;

public class Item {
    private String nombre;
    private int cantidad;
    private String tipo; // Arma, Poción
    private String descripcion;

    public Item(String nombre, int cantidad, String tipo, String descripcion) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.tipo = tipo;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void usarItem() {
        // Lógica para usar el item
    }

    @Override
    public String toString() {
        return nombre + " (Cantidad: " + cantidad + ", Tipo: " + tipo + ")";
    }
}
