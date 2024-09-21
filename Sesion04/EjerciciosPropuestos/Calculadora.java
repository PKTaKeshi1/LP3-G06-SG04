public class Calculadora {

    public double sumar(double a, double b) {
        return a + b;
    }

    public double restar(double a, double b) {
        return a - b;
    }

    public double multiplicar(double a, double b) {
        return a * b;
    }

    public double dividir(double a, double b) throws DivisionPorCeroException {
        if (b == 0) throw new DivisionPorCeroException("No se puede dividir entre cero.");
        return a / b;
    }

    public static void main(String[] args) {
        Calculadora calc = new Calculadora();
        try {
            System.out.println("Suma: " + calc.sumar(10, 5));
            System.out.println("División: " + calc.dividir(10, 0)); // Lanza DivisionPorCeroException
        } catch (DivisionPorCeroException e) {
            System.out.println(e.getMessage());
        }
    }
}

class DivisionPorCeroException extends Exception {
    public DivisionPorCeroException(String message) {
        super(message);
    }
}
