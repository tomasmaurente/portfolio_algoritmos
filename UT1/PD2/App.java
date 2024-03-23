import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class App {

    private JFrame frame;
    private JPanel panel_top;
    private JPanel panel_options;
    private JPanel panel_bottom;
    private JTextField textField;
    private JButton button;
    private JLabel text;
    private JLabel text_word_amount;

    public App() {

        frame = new JFrame();
    
        // Configurar el frame
        frame.setTitle("Saludo App");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(0, 1));
        
        // Agregar componentes al panel
        panel_top = new JPanel();
        panel_top.setBorder(BorderFactory.createEmptyBorder(30,30, 30, 30));
        panel_top.setLayout(new FlowLayout());

        // Agregar componentes al panel
        panel_options = new JPanel();
        panel_options.setLayout(new GridLayout(0, 1));

        // Agregar componentes al panel
        panel_bottom = new JPanel();
        panel_bottom.setBorder(BorderFactory.createEmptyBorder(0,30, 30, 30));
        panel_bottom.setLayout(new FlowLayout());
        panel_bottom.add(panel_options);


        // Agregar paneles al frame
        frame.add(panel_top, BorderLayout.CENTER);
        frame.add(panel_bottom, BorderLayout.CENTER);

        text = new JLabel("Ingrese su nombre: ");
        // defino posicion y tamano 
        text.setBounds(10,30,260,20);
        panel_top.add(text);
        
        textField = new JTextField();
        // defino posicion
        textField.setBounds(10,50,260,20);
        // defino tamano
        textField.setPreferredSize(new Dimension(100, 20));
        panel_top.add(textField);

        button = new JButton("Saludar");
        // defino posicion y tamano 
        button.setBounds(80,90,100,20);
        // Agregar un listener al botón
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombre = textField.getText();
                JOptionPane.showMessageDialog(null, "¡Hola, " + nombre + "!");
            }
        });
        
        panel_top.add(button, BorderFactory.createEmptyBorder(30,30, 30, 30));

        // Crear botones de radio
        JRadioButton radioButton1 = new JRadioButton("Opción 1");
        JRadioButton radioButton2 = new JRadioButton("Opción 2");
        JRadioButton radioButton3 = new JRadioButton("Opción 3");
        
        // Crear un ButtonGroup
        ButtonGroup group = new ButtonGroup();
        
        // Agregar los botones de radio al grupo
        group.add(radioButton1);
        group.add(radioButton2);
        group.add(radioButton3);
        
        // Agregar los botones de radio al panel de opciones
        panel_options.add(radioButton1);
        panel_options.add(radioButton2);
        panel_options.add(radioButton3);

        text_word_amount = new JLabel("la cantidad de palabras es: ");
        // defino posicion y tamano 
        text.setBounds(10,30,260,20);
        panel_bottom.add(text_word_amount);

        
        frame.setVisible(true);

    }

    
    public static void main(String[] args) {
        
        new App();
    
    }
}