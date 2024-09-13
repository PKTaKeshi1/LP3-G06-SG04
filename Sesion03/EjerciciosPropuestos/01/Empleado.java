// Clase para almacenar la información del empleado
class Empleado {
    private String nombre;
    private double salario;
    private String departamento;

    public Empleado(String nombre, double salario, String departamento) {
        this.nombre = nombre;
        this.salario = salario;
        this.departamento = departamento;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSalario() {
        return salario;
    }

    public String getDepartamento() {
        return departamento;
    }
}

// Clase separada para calcular el pago
class CalculadoraPago {
    public double calcularPagoMensual(Empleado empleado) {
        return empleado.getSalario() / 12;
    }
}

// Aplicación principal para demostrar la funcionalidad
public class Main {
    public static void main(String[] args) {
        Empleado empleado = new Empleado("Juan Pérez", 36000, "Recursos Humanos");
        CalculadoraPago calculadora = new CalculadoraPago();

        double pagoMensual = calculadora.calcularPagoMensual(empleado);
        System.out.println("Pago mensual para " + empleado.getNombre() + ": $" + pagoMensual);
    }
}
