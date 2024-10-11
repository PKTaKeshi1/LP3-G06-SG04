package Sesion06.Actividades;

public class Pedido {
    private String nombrePlato;
    private String tipoPlato;
    private String estado;  // Nuevo atributo para el estado (pendiente, completo, eliminado)

    public Pedido(String nombrePlato, String tipoPlato) {
        this.nombrePlato = nombrePlato;
        this.tipoPlato = tipoPlato;
        this.estado = "Pendiente";  // Estado por defecto al crear un pedido
    }

    public String getNombrePlato() {
        return nombrePlato;
    }

    public void setNombrePlato(String nombrePlato) {
        this.nombrePlato = nombrePlato;
    }

    public String getTipoPlato() {
        return tipoPlato;
    }

    public void setTipoPlato(String tipoPlato) {
        this.tipoPlato = tipoPlato;
    }

    public String getEstado() {
        return estado;
    }

    // Método para marcar el pedido como completo
    public void marcarComoCompleto() {
        this.estado = "Completo";
    }

    // Método para marcar el pedido como eliminado
    public void eliminar() {
        this.estado = "Eliminado";
    }
}
