public class CuentaBancaria {
    private String numeroCuenta;
    private String titular;
    private double saldo;

    public CuentaBancaria(String numeroCuenta, String titular, double saldo) {
        if (saldo < 0) throw new IllegalArgumentException("Saldo inicial no puede ser negativo.");
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldo;
    }

    public void depositar(double monto) {
        if (monto <= 0) throw new IllegalArgumentException("El monto a depositar debe ser positivo.");
        saldo += monto;
    }

    public void retirar(double monto) throws SaldoInsuficienteException {
        if (monto <= 0) throw new IllegalArgumentException("El monto a retirar debe ser positivo.");
        if (monto > saldo) throw new SaldoInsuficienteException("Saldo insuficiente para retirar.");
        saldo -= monto;
    }

    public double getSaldo() {
        return saldo;
    }

    public static void main(String[] args) {
        try {
            CuentaBancaria cuenta = new CuentaBancaria("12345", "Juan Perez", 500);
            cuenta.depositar(200);
            cuenta.retirar(1000); // Lanza SaldoInsuficienteException
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

class SaldoInsuficienteException extends Exception {
    public SaldoInsuficienteException(String message) {
        super(message);
    }
}
