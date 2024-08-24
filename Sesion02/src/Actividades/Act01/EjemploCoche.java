package Actividades;

public class EjemploCoche {
    public static void main(String[] args) {
        // Crear objetos coche
        Coche cocheDeportivo = new Coche("Deportivo", 300, 500);
        Coche cocheTodoTerreno = new Coche("Todo Terreno", 200, 350);

        // Encender los coches
        cocheDeportivo.encender();
        cocheTodoTerreno.encender();

        // Acelerar y frenar los coches
        cocheDeportivo.acelerar();
        cocheDeportivo.frenar();

        cocheTodoTerreno.acelerar();
        cocheTodoTerreno.frenar();

        // Apagar los coches
        cocheDeportivo.apagar();
        cocheTodoTerreno.apagar();

        // Aplicar descuento (si aplica)
        cocheDeportivo.setAnio(2009); // Modelo antiguo
        cocheDeportivo.setPrecio(10000.00);
        cocheDeportivo.aplicarDescuento();

        cocheTodoTerreno.setAnio(2015); // Modelo reciente
        cocheTodoTerreno.setPrecio(12000.00);
        cocheTodoTerreno.aplicarDescuento();
    }
}
