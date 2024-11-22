package EjerciciosPropuestos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Clase Producto que actúa como modelo de datos
class Producto {
    private String nombre;
    private double precio;
    private int cantidadStock;
    private String categoria;

    // Constructor de Producto
    public Producto(String nombre, double precio, int cantidadStock, String categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadStock = cantidadStock;
        this.categoria = categoria;
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(int cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "<html>Nombre: " + nombre + "<br>Precio: $" + precio + "<br>Cantidad en Stock: " + cantidadStock + "<br>Categoría: " + categoria + "</html>";
    }
}

// Clase principal para la interfaz de usuario
public class GestionProductoApp extends JFrame {
    private Producto producto;
    private JTextField nombreField, precioField, cantidadField, categoriaField;
    private JLabel infoProductoLabel;

    public GestionProductoApp() {
        // Inicializar un producto con datos predeterminados
        producto = new Producto("Producto de ejemplo", 0.0, 0, "Sin categoría");

        setTitle("Gestión de Producto");
        setSize(400, 325);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear panel principal
        JPanel panelPrincipal = new JPanel(new GridLayout(6, 2, 10, 10));

        // Campos para ingresar información del producto
        panelPrincipal.add(new JLabel("Nombre:"));
        nombreField = new JTextField();
        panelPrincipal.add(nombreField);

        panelPrincipal.add(new JLabel("Precio:"));
        precioField = new JTextField();
        panelPrincipal.add(precioField);
        panelPrincipal.add(new JLabel("Cantidad en Stock:"));
        cantidadField = new JTextField();
        panelPrincipal.add(cantidadField);

        panelPrincipal.add(new JLabel("Categoría:"));
        categoriaField = new JTextField();
        panelPrincipal.add(categoriaField);

        // Botón para actualizar producto
        JButton actualizarButton = new JButton("Actualizar Producto");
        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarProducto();
            }
        });

        panelPrincipal.add(actualizarButton);

        // Etiqueta para mostrar la información actualizada del producto
        infoProductoLabel = new JLabel();
        infoProductoLabel.setVerticalAlignment(SwingConstants.TOP);
        actualizarInfoProducto();

        // Añadir paneles al frame
        add(panelPrincipal, BorderLayout.NORTH);
        add(infoProductoLabel, BorderLayout.CENTER);
    }

    private void actualizarProducto() {
        try {
            String nombre = nombreField.getText();
            double precio = Double.parseDouble(precioField.getText());
            int cantidad = Integer.parseInt(cantidadField.getText());
            String categoria = categoriaField.getText();

            // Actualizar el objeto producto con los datos ingresados
            producto.setNombre(nombre);
            producto.setPrecio(precio);
            producto.setCantidadStock(cantidad);
            producto.setCategoria(categoria);

            // Actualizar la etiqueta con la nueva información
            actualizarInfoProducto();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un valor numérico válido para precio y cantidad.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void actualizarInfoProducto() {
        infoProductoLabel.setText(producto.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GestionProductoApp app = new GestionProductoApp();
            app.setVisible(true);
        });
    }
}
