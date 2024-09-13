// Interfaz para los canales de notificación 
interface CanalNotificacion { 
    void enviarNotificacion(String mensaje); 
} 
 
// Implementación concreta para enviar notificaciones por correo electrónico 
class EnviadorCorreo implements CanalNotificacion { 
    @Override 
    public void enviarNotificacion(String mensaje) { 
        System.out.println("Enviando correo: " + mensaje); 
    } 
} 
 
// Implementación concreta para enviar notificaciones por SMS 
class EnviadorSMS implements CanalNotificacion { 
    @Override 
    public void enviarNotificacion(String mensaje) { 
        System.out.println("Enviando SMS: " + mensaje); 
    } 
} 
 
// Clase para manejar la notificación de reservas 
class NotificadorReserva { 
    private CanalNotificacion canalNotificacion; 
 
    public NotificadorReserva(CanalNotificacion canalNotificacion) { 
        this.canalNotificacion = canalNotificacion; 
    } 
 
    public void notificar(String mensaje) { 
        canalNotificacion.enviarNotificacion(mensaje); 
    } 
} 
 
// Clase principal para demostrar la funcionalidad 
public class Main { 
    public static void main(String[] args) { 
        CanalNotificacion canalCorreo = new EnviadorCorreo(); 
        CanalNotificacion canalSMS = new EnviadorSMS(); 
        NotificadorReserva notificadorCorreo = new NotificadorReserva(canalCorreo); 
        NotificadorReserva notificadorSMS = new NotificadorReserva(canalSMS); 
        // Enviar notificaciones usando diferentes canales 
        notificadorCorreo.notificar("Confirmación de reserva: Habitación 101"); 
        notificadorSMS.notificar("Confirmación de reserva: Habitación 102"); 
  } 
} 
