public class testAgregacion { 
    public static void main(String[] args) { 
         
        Persona persona1 = new Persona(00000001, "Cristhian", "Rodriguez", 123456789); 
        Cuenta cuenta1 = new Cuenta(12345678, 15000); 
        Persona persona2 = new Persona(00000002, "Adrian", "Perez", 987654321); 
        Cuenta cuenta2 = new Cuenta(87654321, 10000); 
 
        System.out.println(persona1.toString()); 
        System.out.println(cuenta1.toString()); 
        System.out.println(persona2.toString()); 
        System.out.println(cuenta2.toString()); 
    } 
}
