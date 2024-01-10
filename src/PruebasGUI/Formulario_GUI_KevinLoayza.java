package PruebasGUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Formulario_GUI_KevinLoayza extends JFrame {

    int idc;

    private JPanel mainpanel;
    private JPanel panel_izquierdo;
    private JPanel panel_derecho;
    private JTextField barra_nombre;
    private JTextField barra_apellidos;
    private JTextField barra_dni;
    private JTextField barra_email;

    private int contadorID = 1;

    private JLabel titulo;
    private JButton boton_nuevo;
    private JButton boton_anadir;
    private JButton boton_modificar;
    private JPanel panel_botones;
    private JPanel panel_formulario;
    private JPanel panel_titulo;
    private JLabel titulo_nombre;
    private JLabel titulo_apellidos;
    private JLabel titulo_dni;
    private JLabel titulo_email;
    private JLabel titulo_contrasena;
    private JPasswordField barra_contrasena;
    private JLabel titulo_id;
    private JTextField numero_id;
    private JButton boton_eliminar;
    private JPanel panel_tabla;
    private JTable showTable;
    private DefaultTableModel model;

    private String id;
    private String nombre;
    private String apellidos;
    private String dni;
    private String email;
    private char[] contrasena;


    public Formulario_GUI_KevinLoayza() {


    }


    public static void main(String[] args) {
        Formulario_GUI_KevinLoayza formulario = new Formulario_GUI_KevinLoayza();
        formulario.setContentPane(formulario.mainpanel);
        formulario.setTitle("Formulario");
        formulario.setSize(900, 550);
        formulario.setVisible(true);
        formulario.setLocationRelativeTo(null);
        formulario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }



}
