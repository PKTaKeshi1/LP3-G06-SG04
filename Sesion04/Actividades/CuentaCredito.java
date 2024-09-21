public class CuentaCredito extends CuentaBancaria {
    private double limiteCredito;

    public CuentaCredito(String numeroCuenta, String titular, double saldo, double limiteCredito) {
        super(numeroCuenta, titular, saldo);
        this.limiteCredito = limiteCredito;
    }

    @Override
    public void retirar(double monto) throws LimiteCreditoExcedidoException {
        if (monto > (getSaldo() + limiteCredito)) {
            throw new LimiteCreditoExcedidoException("El monto excede el límite de crédito.");
        }
        super.retirar(monto);
    }

    public static void main(String[] args) {
        try {
            CuentaCredito cuentaCredito = new CuentaCredito("12345", "Juan Perez", 500, 300);
            cuentaCredito.retirar(900); // Lanza LimiteCreditoExcedidoException
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

class LimiteCreditoExcedidoException extends Exception {
    public LimiteCreditoExcedidoException(String message) {
        super(message);
    }
}
