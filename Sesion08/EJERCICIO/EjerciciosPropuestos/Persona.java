package EjerciciosPropuestos;

public class Persona {
    private int id;
    private String nombre;
    private int edad;
    private String ciudad;

    public Persona(int id, String nombre, int edad, String ciudad) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.ciudad = ciudad;
    }

    // Getters y Setters
    public int getId() { 
    	return id; 
    	}
    public String getNombre() { 
    	return nombre; 
    	}
    public int getEdad() { 
    	return edad; 
    	}
    public String getCiudad() { 
    	return ciudad; 
    	}

    @Override
    public String toString() {
        return "ID: " + id + ", Nombre: " + nombre + ", Edad: " + edad + ", Ciudad: " + ciudad;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
}
