package s0602;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        InventarioModel modelo = new InventarioModel();
        InventarioView vista = new InventarioView();
        InventarioController controlador = new InventarioController(modelo, vista);

        // Agregar items de ejemplo
        controlador.agregarItem("Espada", 1, "Arma", "Una espada afilada.");
        controlador.agregarItem("Poción", 3, "Poción", "Recupera 50 puntos de salud.");

        // Inicializar jugador y enemigo
        Jugador jugador = new Jugador("Heroe", 100, 1);
        Enemigo enemigo = new Enemigo("Orco", 80, 1);
        CombateController combate = new CombateController(jugador, enemigo);

        boolean salir = false;
        while (!salir) {
            String menu = "Seleccione una opción:\n"
                    + "1. Ver Inventario\n"
                    + "2. Agregar Item\n"
                    + "3. Eliminar Item\n"
                    + "4. Mostrar Detalles de Item\n"
                    + "5. Iniciar Combate\n"
                    + "6. Salir";

            String opcion = JOptionPane.showInputDialog(menu);

            switch (opcion) {
                case "1":
                    controlador.verInventario();
                    break;
                case "2":
                    String nombre = JOptionPane.showInputDialog("Ingrese el nombre del item:");
                    int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad:"));
                    String tipo = JOptionPane.showInputDialog("Ingrese el tipo (Arma/Poción):");
                    String descripcion = JOptionPane.showInputDialog("Ingrese la descripción:");
                    controlador.agregarItem(nombre, cantidad, tipo, descripcion);
                    break;
                case "3":
                    String nombreEliminar = JOptionPane.showInputDialog("Ingrese el nombre del item a eliminar:");
                    controlador.eliminarItem(nombreEliminar);
                    break;
                case "4":
                    String nombreDetalles = JOptionPane.showInputDialog("Ingrese el nombre del item para mostrar detalles:");
                    controlador.mostrarDetalles(nombreDetalles);
                    break;
                case "5":
                    combate.iniciarCombate();
                    break;
                case "6":
                    salir = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Intente de nuevo.");
            }
        }

        JOptionPane.showMessageDialog(null, "Gracias por jugar.");
    }
}
