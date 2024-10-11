package s0602;

import javax.swing.JOptionPane;
import java.util.List;

public class InventarioView {
    public void mostrarInventario(List<Item> items) {
        StringBuilder sb = new StringBuilder("Inventario:\n");
        for (Item item : items) {
            sb.append(item).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    public void mostrarDetallesItem(Item item) {
        if (item != null) {
            JOptionPane.showMessageDialog(null, "Detalles del item: \n" + item.getDescripcion());
        } else {
            mostrarMensaje("Item no encontrado.");
        }
    }
}
