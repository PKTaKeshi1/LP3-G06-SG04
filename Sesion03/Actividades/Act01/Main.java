import java.util.List; 
import java.time.LocalDate; 
import java.util.ArrayList; 
 
// Clase Habitacion 
class Habitacion { 
    private String numero; 
    private double precio; 
    private GestorDisponibilidadHabitacion gestorDisponibilidad; 
 
    public Habitacion(String numero, double precio, GestorDisponibilidadHabitacion gestorDisponibilidad) 
{ 
        this.numero = numero; 
        this.precio = precio; 
        this.gestorDisponibilidad = gestorDisponibilidad; 
    } 
 
    public boolean verificarDisponibilidad(List<Reserva> reservas, LocalDate fechaInicio, LocalDate 
fechaFin) { 
        return gestorDisponibilidad.verificarDisponibilidad(this, reservas, fechaInicio, fechaFin); 
    } 
 
    public void marcarReservada() { 
        gestorDisponibilidad.marcarReservada(this); 
    } 
 
    public double calcularPrecio(String temporada, List<Promocion> promociones) { 
        return gestorDisponibilidad.calcularPrecio(this, temporada, promociones); 
    } 
 
    public String getNumero() { 
        return numero; 
    } 
 
    public double getPrecio() { 
        return precio; 
    } 
} 
 
// Clase GestorDisponibilidadHabitacion 
class GestorDisponibilidadHabitacion { 
    public boolean verificarDisponibilidad(Habitacion habitacion, List<Reserva> reservas, LocalDate 
fechaInicio, LocalDate fechaFin) { 
        // Lógica para verificar si la habitación está disponible en el rango de fechas especificado 
        for (Reserva reserva : reservas) { 
            if (reserva.getHabitacion().equals(habitacion) && reserva.seSolapaCon(fechaInicio, fechaFin)) { 
                return false; 
            } 
        } 
        return true; 
    } 
 
    public void marcarReservada(Habitacion habitacion) { 
        // Lógica para marcar la habitación como reservada 
        System.out.println("La habitación " + habitacion.getNumero() + " ha sido reservada."); 
    } 
 
    public double calcularPrecio(Habitacion habitacion, String temporada, List<Promocion> promociones) 
{ 
        double precio = habitacion.getPrecio(); 
        // Lógica para aplicar promociones y calcular precio según la temporada 
        for (Promocion promocion : promociones) { 
            if (promocion.aplica(habitacion, temporada)) { 
                precio -= promocion.getDescuento(); 
            } 
        } 
        return precio; // Precio final después de aplicar promociones 
    } 
} 
 
// Clase Reserva 
class Reserva { 
    private Habitacion habitacion; 
    private LocalDate fechaInicio; 
    private LocalDate fechaFin; 
 
    public Reserva(Habitacion habitacion, LocalDate fechaInicio, LocalDate fechaFin) { 
        this.habitacion = habitacion; 
        this.fechaInicio = fechaInicio; 
        this.fechaFin = fechaFin; 
    } 
 
    public Habitacion getHabitacion() { 
        return habitacion; 
    } 
 
    public LocalDate getFechaInicio() { 
        return fechaInicio; 
    } 
 
    public LocalDate getFechaFin() { 
        return fechaFin; 
    } 
 
    // Método para verificar si una reserva se solapa con un rango de fechas específico 
    public boolean seSolapaCon(LocalDate fechaInicio, LocalDate fechaFin) { 
        return !this.fechaFin.isBefore(fechaInicio) && !this.fechaInicio.isAfter(fechaFin); 
    } 
} 
 
// Clase Promocion 
class Promocion { 
    private double descuento; 
    private String temporada; 
 
    public Promocion(double descuento, String temporada) { 
        this.descuento = descuento; 
        this.temporada = temporada; 
    } 
 
    // Verifica si la promoción aplica a la habitación en una temporada específica 
    public boolean aplica(Habitacion habitacion, String temporadaActual) { 

        return this.temporada.equals(temporadaActual); 
    } 
 
    public double getDescuento() { 
        return descuento; 
    } 
} 
 
// Clase Main 
public class Main { 
    public static void main(String[] args) { 
        // Crear un gestor de disponibilidad 
        GestorDisponibilidadHabitacion gestor = new GestorDisponibilidadHabitacion(); 
 
        // Crear algunas habitaciones 
        Habitacion habitacion1 = new Habitacion("101", 100.0, gestor); 
        Habitacion habitacion2 = new Habitacion("102", 150.0, gestor); 
 
        // Crear una lista de reservas 
        List<Reserva> reservas = new ArrayList<>(); 
        reservas.add(new Reserva(habitacion1, LocalDate.of(2024, 9, 1), LocalDate.of(2024, 9, 5))); 
 
        // Crear una lista de promociones 
        List<Promocion> promociones = new ArrayList<>(); 
        promociones.add(new Promocion(20.0, "Otoño")); 
 
        // Verificar disponibilidad 
        LocalDate fechaInicio = LocalDate.of(2024, 9, 3); 
        LocalDate fechaFin = LocalDate.of(2024, 9, 7); 
        boolean disponible = habitacion1.verificarDisponibilidad(reservas, fechaInicio, fechaFin); 
        System.out.println("Habitación 101 disponible: " + disponible); 
 
        // Calcular el precio 
        double precio = habitacion1.calcularPrecio("Otoño", promociones); 
        System.out.println("Precio final para la habitación 101: " + precio); 
 
        // Marcar la habitación como reservada 
        habitacion1.marcarReservada(); 
    } 
} 
