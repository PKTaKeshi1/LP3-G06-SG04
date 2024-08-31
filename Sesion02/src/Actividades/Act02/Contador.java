package Sesion02;

public class Contador {
	static int acumulador = 0;
	private int valor;
	
	public static int acumulador() {
		return acumulador;
	}
	
	public Contador(int valor) {
		this.valor = valor;
		acumulador += valor;
	}
	
	public void inc() {
		valor++;
		acumulador++;
	}
	
	public int getValor() {
		return this.valor;
	}

}

