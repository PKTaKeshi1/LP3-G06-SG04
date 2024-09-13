// Clase base Habitacion 
abstract class Habitacion { 
    private String numero; 
    private double precioBase; 
 
    public Habitacion(String numero, double precioBase) { 
        this.numero = numero; 
        this.precioBase = precioBase; 
    } 
 
    public String getNumero() { 
        return numero; 
    } 
 
    public double getPrecioBase() { 
        return precioBase; 
    } 
 
    // Método para calcular el precio total de la habitación, puede ser sobrescrito por subclases 
    public abstract double calcularPrecio(double noches); 
     
    // Método para realizar el check-in 
    public void checkIn() { 
        System.out.println("Check-in realizado en la habitación: " + numero); 
    } 
 
    // Método para realizar el check-out 
    public void checkOut() { 
        System.out.println("Check-out realizado en la habitación: " + numero); 
    } 
} 
 
// Subclase HabitacionIndividual 
class HabitacionIndividual extends Habitacion { 
    public HabitacionIndividual(String numero, double precioBase) { 
        super(numero, precioBase); 
    } 
 
    @Override 
    public double calcularPrecio(double noches) { 
        return getPrecioBase() * noches; 
    } 
} 
 
// Subclase HabitacionDoble 
class HabitacionDoble extends Habitacion { 
    public HabitacionDoble(String numero, double precioBase) { 
        super(numero, precioBase); 
    } 
 
    @Override 
    public double calcularPrecio(double noches) { 
        return getPrecioBase() * noches * 1.2; // 20% más caro 
    } 
} 
 
// Subclase HabitacionSuite 
class HabitacionSuite extends Habitacion { 
    public HabitacionSuite(String numero, double precioBase) { 
        super(numero, precioBase); 
    } 
 
    @Override 
    public double calcularPrecio(double noches) { 
        return getPrecioBase() * noches * 2.0; // 100% más caro 
    } 
} 
 
// Clase principal para demostrar la funcionalidad 
public class Main { 
    public static void main(String[] args) { 
        Habitacion habitacion1 = new HabitacionIndividual("101", 100); 
        Habitacion habitacion2 = new HabitacionDoble("102", 150); 
        Habitacion habitacion3 = new HabitacionSuite("103", 300); 
 
        // Usando el polimorfismo para tratar todas las habitaciones de manera uniforme 
        Habitacion[] habitaciones = {habitacion1, habitacion2, habitacion3}; 
 
        for (Habitacion habitacion : habitaciones) { 
            habitacion.checkIn(); 
            System.out.println("Precio total por 3 noches: $" + habitacion.calcularPrecio(3)); 
            habitacion.checkOut(); 
            System.out.println(); 
        } 
    } 
} 
