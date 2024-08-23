package Actividades;

public class Coche {
    private String marca;
    private int aniodefabricacion;
    private double precio;
    public String modelo;
    
    public Coche(String marca, String modelo, int aniodefabricacion, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.aniodefabricacion = aniodefabricacion;
        this.precio = precio;
    }
    
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public int getAniodefabricacion() {
        return aniodefabricacion;
    }
    public void setAniodefabricacion(int aniodefabricacion) {
        this.aniodefabricacion = aniodefabricacion;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    public boolean aplicarDescuento(double descuento) {
        if (aniodefabricacion >= 2010) {
            return false;
        } else {
            this.precio -= descuento;
            return true;
        }
    }

    public static void main(String[] args) {
        Coche c1 = new Coche("Hyundai", "Santafe", 2015, 150000);
        Coche c2 = new Coche("Toyota", "Yaris", 2009, 50000);
        
        boolean descuentoAplicadoc1 = c1.aplicarDescuento(5000);
        System.out.println("Descuento aplicado: " + descuentoAplicadoc1);
        System.out.println("Precio después del descuento: " + c1.getPrecio());
        
        boolean descuentoAplicadoc2 = c2.aplicarDescuento(2000);
        System.out.println("Descuento aplicado: " + descuentoAplicadoc2);
        System.out.println("Precio después del descuento: " + c2.getPrecio());
    }
}
