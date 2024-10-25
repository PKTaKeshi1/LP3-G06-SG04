public class Main {
    public static void main(String[] args) {
        String rutaArchivo = "empleados.txt"; // Ruta del archivo
        Vista vista = new Vista();
        Controlador controlador = new Controlador(vista, rutaArchivo);
        controlador.iniciar();
    }
}
