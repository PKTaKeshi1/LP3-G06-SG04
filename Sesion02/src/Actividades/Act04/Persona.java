public class Persona { 
    // Atributos 
    private int id; 
    private String nombre; 
    private String apellido; 
    private Cuenta cuenta; 
 
    // Constructor 
    public Persona(int id, String nombre, String apellido, int numero) { 
        this.id = id; 
        this.nombre = nombre; 
        this.apellido = apellido; 
        this.cuenta = new Cuenta(numero); 
    } 
 
    // Getters y Setters 
    public int getId() { 
        return id; 
    } 
    public void setId(int id) { 
        this.id = id; 
    } 
    public String getNombre() { 
        return nombre; 
    } 
    public void setNombre(String nombre) { 
        this.nombre = nombre; 
    } 
    public String getApellido() { 
        return apellido; 
    } 
    public void setApellido(String apellido) { 
        this.apellido = apellido; 
    } 
    public Cuenta getCuenta() { 
        return cuenta; 
    } 
    public void setCuenta(Cuenta cuenta) { 
        this.cuenta = cuenta; 
    } 
 
    // toString 
    public String toString() { 
        return "Persona: " + 
               "Id='" + id + '\'' + 
               ", Nombre=" + nombre + 
               ", Apellido='" + apellido + '\'' + 
               ", Cuenta=" + cuenta + '}'; 
    } 
}
