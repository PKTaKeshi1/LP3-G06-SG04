interface Imprimible {
    void imprimir();
}

interface Escaneable {
    void escanear();
}

class Impresora implements Imprimible {
    @Override
    public void imprimir() {
        System.out.println("Imprimiendo...");
    }
}

class ImpresoraMultifuncional implements Imprimible, Escaneable {
    @Override
    public void imprimir() {
        System.out.println("Imprimiendo...");
    }

    @Override
    public void escanear() {
        System.out.println("Escaneando...");
    }
}

// Aplicación principal para demostrar la funcionalidad
public class Main {
    public static void main(String[] args) {
        Imprimible impresora = new Impresora();
        ImpresoraMultifuncional multifuncional = new ImpresoraMultifuncional();

        impresora.imprimir();
        multifuncional.imprimir();
        multifuncional.escanear();
    }
}
