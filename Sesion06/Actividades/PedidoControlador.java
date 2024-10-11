package Sesion06.Actividades;

import java.util.List;

public class PedidoControlador {
    private PedidoModelo modelo;
    private PedidoVista vista;

    public PedidoControlador(PedidoModelo modelo, PedidoVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void agregarPedido(String nombrePlato, String tipoPlato) {
        if (!nombrePlato.isEmpty() && !tipoPlato.isEmpty()) {
            modelo.agregarPedido(new Pedido(nombrePlato, tipoPlato));
            vista.mostrarMensaje("Pedido agregado: " + nombrePlato + " (" + tipoPlato + ")");
        } else {
            vista.mostrarMensaje("El nombre o tipo del plato no pueden estar vacíos.");
        }
    }

    public void eliminarPedido(int index) {
        modelo.eliminarPedido(index);
        vista.mostrarMensaje("Pedido eliminado.");
    }

    // Método para actualizar un pedido existente
    public void actualizarPedido(int index, String nuevoNombre, String nuevoTipo) {
        if (index >= 0 && index < modelo.getPedidos().size()) {
            Pedido pedido = modelo.getPedidos().get(index);
            pedido.setNombrePlato(nuevoNombre);  // Actualiza el nombre del plato
            pedido.setTipoPlato(nuevoTipo);      // Actualiza el tipo del plato
            vista.mostrarMensaje("Pedido actualizado a: " + nuevoNombre + " (" + nuevoTipo + ")");
        } else {
            vista.mostrarMensaje("Índice de pedido no válido.");
        }
    }

    // Método para buscar un pedido por nombre
    public void buscarPedidoPorNombre(String nombre) {
        List<Pedido> pedidos = modelo.getPedidos();
        boolean encontrado = false;

        for (Pedido pedido : pedidos) {
            if (pedido.getNombrePlato().equalsIgnoreCase(nombre)) {
                vista.mostrarMensaje("Pedido encontrado: " + pedido.getNombrePlato() + " (" + pedido.getTipoPlato() + ") - Estado: " + pedido.getEstado());
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            vista.mostrarMensaje("Pedido no encontrado.");
        }
    }

    // Método para contar los pedidos por tipo
    public void contarPedidosPorTipo(String tipo) {
        int contador = modelo.contarPedidosPorTipo(tipo);
        vista.mostrarMensaje("Hay " + contador + " pedidos del tipo: " + tipo);
    }

    public void marcarPedidoComoCompleto(int index) {
        modelo.marcarPedidoComoCompleto(index);
        vista.mostrarMensaje("Pedido marcado como completo.");
    }

    public void mostrarPedidos() {  // Método para mostrar todos los pedidos
        List<Pedido> pedidos = modelo.getPedidos();
        vista.mostrarPedidos(pedidos);
    }

    public void mostrarPedidosPorEstado(String estado) {
        List<Pedido> pedidosPorEstado = modelo.getPedidosPorEstado(estado);
        vista.mostrarPedidos(pedidosPorEstado);
    }

    public void contarPedidosPendientes() {
        int contador = modelo.contarPedidosPendientes();
        vista.mostrarMensaje("Hay " + contador + " pedidos pendientes.");
    }

    public void verHistorial() {
        List<Pedido> historial = modelo.getHistorial();
        vista.mostrarPedidos(historial);
    }

    public void iniciar() {
        int opcion;
        do {
            vista.mostrarMenu();
            opcion = vista.solicitarOpcion();  // Captura la opción seleccionada por el usuario
            vista.scanner.nextLine();  // Limpiar el buffer de entrada

            switch (opcion) {
                case 1 -> {
                    String nombrePlato = vista.solicitarNombrePlato();
                    String tipoPlato = vista.solicitarTipoPlato();
                    agregarPedido(nombrePlato, tipoPlato);
                }
                case 2 -> mostrarPedidos();  // Llamada al método mostrarPedidos()
                case 3 -> {
                    int indiceEliminar = vista.solicitarIndicePedido();
                    eliminarPedido(indiceEliminar);
                }
                case 4 -> {
                    int indiceActualizar = vista.solicitarIndicePedido();
                    vista.scanner.nextLine();  // Limpiar el buffer
                    String nuevoNombre = vista.solicitarNombrePlato();
                    String nuevoTipo = vista.solicitarTipoPlato();
                    actualizarPedido(indiceActualizar, nuevoNombre, nuevoTipo);
                }
                case 5 -> {
                    String nombreBuscar = vista.solicitarNombrePlato();
                    buscarPedidoPorNombre(nombreBuscar);
                }
                case 6 -> {
                    String tipoContar = vista.solicitarTipoPlato();
                    contarPedidosPorTipo(tipoContar);  // Llamada para contar pedidos por tipo
                }
                case 7 -> {
                    int indiceCompletar = vista.solicitarIndicePedido();
                    marcarPedidoComoCompleto(indiceCompletar);
                }
                case 8 -> {
                    String estado = vista.solicitarEstado();
                    mostrarPedidosPorEstado(estado);
                }
                case 9 -> contarPedidosPendientes();
                case 10 -> verHistorial();
                case 11 -> vista.mostrarMensaje("Saliendo...");
                default -> vista.mostrarMensaje("Opción no válida. Inténtalo de nuevo.");
            }
        } while (opcion != 11);
        vista.cerrarScanner();
    }

    public PedidoVista getVista() {
        return vista;
    }

    public void setVista(PedidoVista vista) {
        this.vista = vista;
    }

    public PedidoModelo getModelo() {
        return modelo;
    }

    public void setModelo(PedidoModelo modelo) {
        this.modelo = modelo;
    }
}
