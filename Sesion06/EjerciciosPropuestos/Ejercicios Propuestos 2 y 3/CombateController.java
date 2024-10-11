package s0602;

import javax.swing.JOptionPane;

public class CombateController {
    private Jugador jugador;
    private Enemigo enemigo;

    public CombateController(Jugador jugador, Enemigo enemigo) {
        this.jugador = jugador;
        this.enemigo = enemigo;
    }

    public void iniciarCombate() {
        while (jugador.getSalud() > 0 && enemigo.getSalud() > 0) {
            // Turno del jugador
            String accion = JOptionPane.showInputDialog("¿Quieres atacar (A) o defenderte (D)?");
            if (accion.equalsIgnoreCase("A")) {
                atacarJugador();
            } else if (accion.equalsIgnoreCase("D")) {
                defenderJugador();
            } else {
                JOptionPane.showMessageDialog(null, "Opción no válida, debes elegir A o D.");
                continue; // Volver a preguntar
            }

            // Verificar si el enemigo está vivo
            if (enemigo.getSalud() <= 0) {
                JOptionPane.showMessageDialog(null, "¡Has derrotado al " + enemigo.getNombre() + "!");
                break;
            }

            // Enemigo ataca
            atacarEnemigo();
        }

        if (jugador.getSalud() <= 0) {
            JOptionPane.showMessageDialog(null, "¡Has sido derrotado!");
        }
    }

    private void atacarJugador() {
        int dano = calcularDano(jugador);
        enemigo.recibirDanio(dano);
        JOptionPane.showMessageDialog(null, jugador.getNombre() + " ataca a " + enemigo.getNombre() + " causando " + dano + " de daño.");
    }

    private void defenderJugador() {
        JOptionPane.showMessageDialog(null, jugador.getNombre() + " se defiende y reduce el daño recibido.");
    }

    private void atacarEnemigo() {
        int dano = (int) (Math.random() * 10 + 5); // Daño aleatorio entre 5 y 15
        int danoReducido = dano; // Daño después de la defensa

        if (jugador.getDefendiendo()) { // Verificar si el jugador está defendiendo
            danoReducido = (int) (dano * 0.5); // Reducir daño a la mitad si se defiende
            jugador.setDefendiendo(false); // Resetear el estado de defensa después de recibir daño
        }

        jugador.recibirDanio(danoReducido);
        JOptionPane.showMessageDialog(null, enemigo.getNombre() + " ataca a " + jugador.getNombre() + " causando " + dano + " de daño. (Daño reducido a " + danoReducido + " por defensa.)");
    }


    private int calcularDano(Jugador jugador) {
        return jugador.getNivel() * 5; // Puedes modificar esto según los objetos equipados
    }
}
