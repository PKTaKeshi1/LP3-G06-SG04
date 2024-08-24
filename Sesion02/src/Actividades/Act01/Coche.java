package Actividades;

public class Coche {
	// Atributos
	public String color;
	private String modelo;
	private int velocidadMaxima;
	private int potenciaMotor;
	private boolean enMarcha;
	
	private String marca;
	private int an_fabri;
	private double precio;
	
	public Coche(String modelo, int velocidadMaxima, int potenciaMotor) {
		this.modelo = modelo;
		this.velocidadMaxima = velocidadMaxima;
		this.potenciaMotor = potenciaMotor;
		this.enMarcha = false;
	}
	
	public Coche(){
		this.modelo = "";
		this.velocidadMaxima = 0;
		this.potenciaMotor = 0;
		this.enMarcha = false;
		this.marca = "";
		this.an_fabri = 0;
		this.precio = 0.00;
	}
	
	public Coche(String marca,String modelo,int anio,double precio) {
		this.modelo = modelo;
		this.velocidadMaxima = 0;
		this.potenciaMotor = 0;
		this.enMarcha = false;
		this.marca = marca;
		this.an_fabri = anio;
		this.precio = precio;
	}
	
	// Metodos
	public void acelerar() {
		if (enMarcha) {
			System.out.println("El coche " + modelo + " esta acelerando.");
		} else {
			System.out.println("Primero enciende el coche.");
		}
	}
	public void frenar() {
		if (enMarcha) {
			System.out.println("El coche " + modelo + " esta frenando.");
		} else {
			System.out.println("El coche esta apagado, no se puede frenar.");
		}
	}
	
	public void encender() {
		enMarcha = true;
		System.out.println("El coche " + modelo + " se ha encendido.");
	}
	public void apagar() {
		enMarcha = false;
		System.out.println("El coche " + modelo + " se ha apagado.");
	}
	public String getModelo() {
		return this.modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public void aplicarDescuento() {
		if(this.an_fabri < 2010) {
			//Teniendo en cuenta que se aplica un descuento de 200.00S
			this.precio -= 200.00;
			System.out.println("Descuento aplicado: " + this.precio);
		}else {
			System.out.println("No se puede aplicar el descuento - Modelo reciente: " + this.an_fabri);
		}
	}

	public String getMarca() {
		return this.marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public int getAnio() {
		return this.an_fabri;
	}
	public void setAnio(int anio) {
		this.an_fabri = anio;
	}
	public double getPrecio() {
		return this.precio;
	}
	public void setPrecio(double precio){
		if(precio < 0) {
			System.out.println("Precio no valido.");
		}else {
			this.precio = precio;
		}
	}

}
