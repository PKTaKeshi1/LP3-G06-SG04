// Interfaces específicas para diferentes servicios
interface ServicioLimpieza {
    void solicitarLimpieza();
}

interface ServicioComida {
    void solicitarComida(String pedido);
}

interface ServicioLavanderia {
    void solicitarLavanderia(String ropa);
}

// Clase Habitacion que implementa las interfaces necesarias
class Habitacion implements ServicioLimpieza, ServicioComida {
    private String numero;

    public Habitacion(String numero) {
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    @Override
    public void solicitarLimpieza() {
        System.out.println("Solicitud de limpieza para la habitación " + numero);
    }

    @Override
    public void solicitarComida(String pedido) {
        System.out.println("Solicitud de comida para la habitación " + numero + ": " + pedido);
    }

    // ServicioLavanderia no se implementa aquí porque no es relevante para esta habitación
}

// Clase Suite que implementa todos los servicios
class Suite implements ServicioLimpieza, ServicioComida, ServicioLavanderia {
    private String numero;

    public Suite(String numero) {
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    @Override
    public void solicitarLimpieza() {
        System.out.println("Solicitud de limpieza para la suite " + numero);
    }

    @Override
    public void solicitarComida(String pedido) {
        System.out.println("Solicitud de comida para la suite " + numero + ": " + pedido);
    }

    @Override
    public void solicitarLavanderia(String ropa) {
        System.out.println("Solicitud de lavandería para la suite " + numero + ": " + ropa);
    }
}

// Clase principal para demostrar la funcionalidad
public class Main {
    public static void main(String[] args) {
        Habitacion habitacion = new Habitacion("201");
        Suite suite = new Suite("301");

        // Usar interfaces específicas según los servicios disponibles
        ServicioLimpieza servicioLimpiezaHabitacion = habitacion;
        servicioLimpiezaHabitacion.solicitarLimpieza();

        ServicioComida servicioComidaSuite = suite;
        servicioComidaSuite.solicitarComida("Pizza y ensalada");

        // Intentar usar ServicioLavanderia con Habitacion daría error en tiempo de compilación
        // ServicioLavanderia servicioLavanderiaHabitacion = habitacion; // Error: Habitacion no implementa ServicioLavanderia

        // Usar todos los servicios con Suite
        Suite suiteCompleta = suite;
        suiteCompleta.solicitarLimpieza();
        suiteCompleta.solicitarComida("Cena gourmet");
        suiteCompleta.solicitarLavanderia("Camisa blanca");
    }
}
