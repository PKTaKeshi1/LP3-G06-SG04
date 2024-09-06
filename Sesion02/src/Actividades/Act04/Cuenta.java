// Clase 
public class Cuenta { 
    // Atributos 
    private int numero; 
    private double saldo; 
    // Contructor 
    public Cuenta(int numero, double saldo){ 
        this.numero = numero; 
        this.saldo = saldo; 
    } 
    public Cuenta(int numero){ 
        this (numero, 0); 
    } 
    // Getters y Setters 
    public int getNumero() { 
        return numero; 
    } 
    public void setNumero(int numero) { 
        this.numero = numero; 
    } 
    public double getSaldo() { 
        return saldo; 
    } 
    public void setSaldo(double saldo) { 
        this.saldo = saldo; 
    } 
    // toString 
    public String toString(){ 
        return "Cuenta: " + 
                "Numero='" + numero + '\'' + 
                ", Saldo=" + saldo +'}'; 
    } 
} 
