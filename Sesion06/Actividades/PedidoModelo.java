package Sesion06.Actividades;

import java.util.ArrayList;
import java.util.List;

public class PedidoModelo {
    private List<Pedido> pedidos;  // Lista de pedidos actuales
    private List<Pedido> historial; // Lista de pedidos completados o eliminados

    public PedidoModelo() {
        pedidos = new ArrayList<>();
        historial = new ArrayList<>();
    }

    public void agregarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public void eliminarPedido(int index) {
        if (index >= 0 && index < pedidos.size()) {
            Pedido pedido = pedidos.get(index);
            pedido.eliminar();  // Cambiar el estado a "Eliminado"
            historial.add(pedido);  // Agregar al historial
            pedidos.remove(index);   // Eliminar de la lista principal
        }
    }

    public void marcarPedidoComoCompleto(int index) {
        if (index >= 0 && index < pedidos.size()) {
            Pedido pedido = pedidos.get(index);
            pedido.marcarComoCompleto();  // Cambiar el estado a "Completo"
            historial.add(pedido);  // Agregar al historial
            pedidos.remove(index);   // Eliminar de la lista principal
        }
    }

    public List<Pedido> getPedidosPorEstado(String estado) {
        List<Pedido> resultados = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            if (pedido.getEstado().equalsIgnoreCase(estado)) {
                resultados.add(pedido);
            }
        }
        return resultados;
    }

    // Método para contar los pedidos por tipo
    public int contarPedidosPorTipo(String tipo) {
        int contador = 0;
        for (Pedido pedido : pedidos) {
            if (pedido.getTipoPlato().equalsIgnoreCase(tipo)) {
                contador++;
            }
        }
        return contador; // Devuelve el número de pedidos del tipo especificado
    }

    public int contarPedidosPendientes() {
        int contador = 0;
        for (Pedido pedido : pedidos) {
            if (pedido.getEstado().equalsIgnoreCase("Pendiente")) {
                contador++;
            }
        }
        return contador;
    }

    public List<Pedido> getHistorial() {
        return historial; // Retorna el historial de pedidos completados o eliminados
    }

    public List<Pedido> getPedidos() {
        return pedidos; // Retorna la lista de pedidos actuales
    }

    public void setHistorial(List<Pedido> historial) {
        this.historial = historial;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}
