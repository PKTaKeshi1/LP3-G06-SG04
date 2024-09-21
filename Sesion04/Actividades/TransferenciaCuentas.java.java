public class TransferenciaCuentas {
    private String numeroCuenta;
    private String titular;
    private double saldo;

    public CuentaBancaria(String numeroCuenta, String titular, double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldo;
    }

    public void transferir(CuentaBancaria destino, double monto) throws SaldoInsuficienteException, CuentaNoEncontradaException {
        if (destino == null) throw new CuentaNoEncontradaException("Cuenta destino no encontrada.");
        if (monto > saldo) throw new SaldoInsuficienteException("Saldo insuficiente para la transferencia.");
        saldo -= monto;
        destino.saldo += monto;
    }

    public void cerrarCuenta() throws SaldoNoCeroException {
        if (saldo != 0) throw new SaldoNoCeroException("No se puede cerrar la cuenta con saldo positivo.");
    }

    public static void main(String[] args) {
        try {
            CuentaBancaria cuenta1 = new CuentaBancaria("12345", "Juan Perez", 500);
            CuentaBancaria cuenta2 = new CuentaBancaria("67890", "Maria Lopez", 1000);
            cuenta1.transferir(cuenta2, 600); // Lanza SaldoInsuficienteException
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

class CuentaNoEncontradaException extends Exception {
    public CuentaNoEncontradaException(String message) {
        super(message);
    }
}

class SaldoNoCeroException extends Exception {
    public SaldoNoCeroException(String message) {
        super(message);
    }
}
