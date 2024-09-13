abstract class Vehiculo {
    public abstract void acelerar();
}

class Coche extends Vehiculo {
    @Override
    public void acelerar() {
        System.out.println("Acelerando con el motor del coche...");
    }
}

class Bicicleta extends Vehiculo {
    @Override
    public void acelerar() {
        System.out.println("Acelerando pedaleando...");
    }
}

// Aplicación principal para demostrar la funcionalidad
public class Main {
    public static void main(String[] args) {
        Vehiculo coche = new Coche();
        Vehiculo bicicleta = new Bicicleta();

        coche.acelerar();
        bicicleta.acelerar();
    }
}
