package actividad3;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class MarcoBotonOpcion extends JFrame {
    private final JTextField campoTexto; // muestra los cambios en el tipo de letra
    private final Font tipoLetraSimple; // texto simple
    private final Font tipoLetraNegrita; // texto en negrita
    private final Font tipoLetraCursiva; // texto en cursiva
    private final Font tipoLetraNegritaCursiva; // texto en negrita y cursiva
    private final JRadioButton simpleJRadioButton; // selecciona texto simple
    private final JRadioButton negritaJRadioButton; // selecciona texto en negrita
    private final JRadioButton cursivaJRadioButton; // selecciona texto en cursiva
    private final JRadioButton negritaCursivaJRadioButton; // negrita y cursiva
    private final ButtonGroup grupoOpciones; // contiene los botones de opción

    // Constructor de MarcoBotonOpcion que agrega los objetos JRadioButton a JFrame
    public MarcoBotonOpcion() {
        super("Ayala Arce Sergio Daniel , Herrera Ramos Edwin Jose");
        setLayout(new FlowLayout());

        campoTexto = new JTextField("Observe el cambio en el estilo del tipo de letra", 25);
        add(campoTexto); // agrega campoTexto a JFrame

        // Crea los botones de opción
        simpleJRadioButton = new JRadioButton("Simple", true);
        negritaJRadioButton = new JRadioButton("Negrita", false);
        cursivaJRadioButton = new JRadioButton("Cursiva", false);
        negritaCursivaJRadioButton = new JRadioButton("Negrita/Cursiva", false);

        add(simpleJRadioButton); // agrega botón simple a JFrame
        add(negritaJRadioButton); // agrega botón negrita a JFrame
        add(cursivaJRadioButton); // agrega botón cursiva a JFrame
        add(negritaCursivaJRadioButton); // agrega botón negrita y cursiva a JFrame

        // Crea una relación lógica entre los objetos JRadioButton
        grupoOpciones = new ButtonGroup();
        grupoOpciones.add(simpleJRadioButton);
        grupoOpciones.add(negritaJRadioButton);
        grupoOpciones.add(cursivaJRadioButton);
        grupoOpciones.add(negritaCursivaJRadioButton);

        // Crea objetos tipo de letra
        tipoLetraSimple = new Font("Serif", Font.PLAIN, 14);
        tipoLetraNegrita = new Font("Serif", Font.BOLD, 14);
        tipoLetraCursiva = new Font("Serif", Font.ITALIC, 14);
        tipoLetraNegritaCursiva = new Font("Serif", Font.BOLD + Font.ITALIC, 14);
        campoTexto.setFont(tipoLetraSimple);

        // Registra eventos para los objetos JRadioButton
        simpleJRadioButton.addItemListener(new ManejadorBotonOpcion(tipoLetraSimple));
        negritaJRadioButton.addItemListener(new ManejadorBotonOpcion(tipoLetraNegrita));
        cursivaJRadioButton.addItemListener(new ManejadorBotonOpcion(tipoLetraCursiva));
        negritaCursivaJRadioButton.addItemListener(new ManejadorBotonOpcion(tipoLetraNegritaCursiva));
    }

    // Clase interna privada para manejar eventos de botones de opción
    private class ManejadorBotonOpcion implements ItemListener {
        private final Font tipoLetra; // tipo de letra asociado con este componente de escucha

        public ManejadorBotonOpcion(Font f) {
            tipoLetra = f;
        }

        // Maneja los eventos de botones de opción
        @Override
        public void itemStateChanged(ItemEvent evento) {
            campoTexto.setFont(tipoLetra);
        }
    }
}
