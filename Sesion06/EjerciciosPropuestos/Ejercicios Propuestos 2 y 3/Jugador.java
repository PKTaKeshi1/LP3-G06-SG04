package s0602;
import java.util.ArrayList;
import java.util.List;

public class Jugador {
    private String nombre;
    private int salud;
    private int nivel;
    private boolean defendiendo; // Nuevo atributo para indicar si está defendiendo
    private List<Item> inventario;

    public Jugador(String nombre, int salud, int nivel) {
        this.nombre = nombre;
        this.salud = salud;
        this.nivel = nivel;
        this.defendiendo = false; // Inicialmente no está defendiendo
        this.inventario = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public int getSalud() {
        return salud;
    }

    public int getNivel() {
        return nivel;
    }

    public boolean getDefendiendo() { // Método para obtener el estado de defensa
        return defendiendo;
    }

    public void setDefendiendo(boolean defendiendo) { // Método para establecer el estado de defensa
        this.defendiendo = defendiendo;
    }

    public void recibirDanio(int dano) {
        salud -= dano;
    }

    public void usarObjeto(Item item) {
        if (item.getTipo().equals("Poción")) {
            salud += 50; // Recupera 50 puntos de salud
        }
    }
}

