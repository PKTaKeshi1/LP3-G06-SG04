// Interfaz para definir las políticas de cancelación 
interface PoliticaCancelacion { 
    boolean puedeCancelar(Reserva reserva); 
} 
 
// Implementación de la política de cancelación flexible 
class PoliticaCancelacionFlexible implements PoliticaCancelacion { 
    @Override 
    public boolean puedeCancelar(Reserva reserva) { 
        // Permite cancelar hasta 24 horas antes del check-in sin penalización 
        long horasHastaCheckIn = reserva.getHorasHastaCheckIn(); 
        return horasHastaCheckIn >= 24; 
    } 
} 
 
// Implementación de la política de cancelación moderada 
class PoliticaCancelacionModerada implements PoliticaCancelacion { 
    @Override 
    public boolean puedeCancelar(Reserva reserva) { 
        // Permite cancelar hasta 72 horas antes del check-in con una penalización del 50% 
        long horasHastaCheckIn = reserva.getHorasHastaCheckIn(); 
        return horasHastaCheckIn >= 72; 
    } 
} 
 
// Implementación de la política de cancelación estricta 
class PoliticaCancelacionEstricta implements PoliticaCancelacion { 
    @Override 
    public boolean puedeCancelar(Reserva reserva) { 
        // No permite cancelaciones después de realizar la reserva 
        return false; 
    } 
} 
 
// Clase Reserva que usa la política de cancelación 
class Reserva { 
    private PoliticaCancelacion politicaCancelacion; 
    private long horasHastaCheckIn; // Horas hasta el check-in desde el momento de la reserva 
 
    public Reserva(PoliticaCancelacion politicaCancelacion, long horasHastaCheckIn) { 
        this.politicaCancelacion = politicaCancelacion; 
        this.horasHastaCheckIn = horasHastaCheckIn; 
    } 
 
    public long getHorasHastaCheckIn() { 
        return horasHastaCheckIn; 
    } 
 
    public boolean cancelar() { 
        if (politicaCancelacion.puedeCancelar(this)) { 
            System.out.println("Reserva cancelada con éxito."); 
            return true; 
        } else { 
            System.out.println("No se puede cancelar la reserva según la política actual."); 
            return false; 
        } 
    } 
} 
 
// Clase principal para demostrar la funcionalidad 
public class Main { 
    public static void main(String[] args) { 
        Reserva reserva1 = new Reserva(new PoliticaCancelacionFlexible(), 30); 
        Reserva reserva2 = new Reserva(new PoliticaCancelacionModerada(), 50); 
        Reserva reserva3 = new Reserva(new PoliticaCancelacionEstricta(), 10); 
 
        System.out.println("Intento de cancelar reserva 1:"); 
        reserva1.cancelar(); 
 
        System.out.println("Intento de cancelar reserva 2:"); 
        reserva2.cancelar(); 

        System.out.println("Intento de cancelar reserva 3:"); 
        reserva3.cancelar(); 
    } 
} 
