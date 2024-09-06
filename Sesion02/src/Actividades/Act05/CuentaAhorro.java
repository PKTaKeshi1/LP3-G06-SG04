public class CuentaAhorro extends Cuenta_5 { 
    private double tasaInteres; 
    private double minSaldo; 
 
    public CuentaAhorro() { 
        this.tasaInteres = 0; 
        this.minSaldo = 0; 
    } 
 
    public void setTasaInteres(double interes) { 
        this.tasaInteres = interes; 
    } 
 
    public void retirar(double monto) { 
        super.retirar(monto); 
        double saldo = getSaldo(); 
        if (saldo < minSaldo) { 
            minSaldo = saldo; 
        } 
    } 
 
    public void consultar() { 
        double interes = minSaldo * tasaInteres / 100; 
        depositar(interes); 
        minSaldo = getSaldo(); 
    } 
} 
