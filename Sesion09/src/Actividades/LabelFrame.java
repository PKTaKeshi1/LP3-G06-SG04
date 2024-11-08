package Sesion09.src.Actividades;

import java.awt.FlowLayout; // especifica cómo se van a ordenar los componentes
import javax.swing.Icon; // proporciona las características básicas de una ventana
import javax.swing.ImageIcon; // muestra texto e imágenes
import javax.swing.JFrame; // constantes comunes utilizadas con Swing
import javax.swing.JLabel; // interfaz utilizada para manipular imágenes
import javax.swing.SwingConstants; // carga las imágenes 

public class LabelFrame extends JFrame  
{ 
    private JLabel etiqueta1; // JLabel sólo con texto 
    private JLabel etiqueta2; // JLabel construida con texto y un icono 
    private JLabel etiqueta3; // JLabel con texto adicional e icono 15 
 
    // El constructor de LabelFrame agrega objetos JLabel a JFrame 
    public LabelFrame() 
    { 
        // Constructor de JLabel con un argumento String 
        super("Prueba de JLabel"); 
        setLayout(new FlowLayout()); // establece el esquema del marco 
 
        // Constructor de JLabel con un argumento String 
        etiqueta1 = new JLabel("Etiqueta con texto"); 
        etiqueta1.setToolTipText("Esta es etiqueta1"); 
        add(etiqueta1); // agrega etiqueta1 a JFrame 
  
        // Constructor de JLabel con argumentos de cadena, Icono y alineación 
        Icon insecto = new ImageIcon(getClass().getResource( "insecto1.png")); 
        etiqueta2 = new JLabel("Etiqueta con texto e icono", insecto,  
                               SwingConstants.LEFT); 
        etiqueta2.setToolTipText("Esta es etiqueta2"); 
        add(etiqueta2); // agrega etiqueta2 a JFrame 
 
        etiqueta3 = new JLabel(); // constructor de JLabel sin argumentos 
        etiqueta3.setText("Etiqueta con icono y texto en la parte inferior"); 
        etiqueta3.setIcon(insecto); // agrega icono a JLabel 
        etiqueta3.setHorizontalTextPosition(SwingConstants.CENTER); 
        etiqueta3.setVerticalTextPosition(SwingConstants.BOTTOM); 
        etiqueta3.setToolTipText("Esta es etiqueta3"); 
        add(etiqueta3); // agrega etiqueta3 a JFrame 
    } 
} // fin de la clase LabelFrame