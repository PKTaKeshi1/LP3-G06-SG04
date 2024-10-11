package s0602;

public class Enemigo {
    private String nombre;
    private int salud;
    private int nivel;

    public Enemigo(String nombre, int salud, int nivel) {
        this.nombre = nombre;
        this.salud = salud;
        this.nivel = nivel;
    }

    public String getNombre() {
        return nombre;
    }

    public int getSalud() {
        return salud;
    }

    public void recibirDanio(int dano) {
        salud -= dano;
    }
}
