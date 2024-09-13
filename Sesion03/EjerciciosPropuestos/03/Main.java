interface Forma {
    void dibujar();
}

class Circulo implements Forma {
    @Override
    public void dibujar() {
        System.out.println("Dibujando un círculo");
    }
}

class Rectangulo implements Forma {
    @Override
    public void dibujar() {
        System.out.println("Dibujando un rectángulo");
    }
}

// Nueva forma: Triángulo
class Triangulo implements Forma {
    @Override
    public void dibujar() {
        System.out.println("Dibujando un triángulo");
    }
}

// Aplicación principal para demostrar la funcionalidad
public class Main {
    public static void main(String[] args) {
        Forma[] formas = {new Circulo(), new Rectangulo(), new Triangulo()};

        for (Forma forma : formas) {
            forma.dibujar();
        }
    }
}
