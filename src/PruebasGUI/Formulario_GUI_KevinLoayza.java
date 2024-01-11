package PruebasGUI;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        model = new DefaultTableModel();
        crear_tabla();
        configuracion_botones();
    }

    private void crear_tabla() {
        numero_id.setText(String.valueOf(contadorID)); // Mostramos el ID actual

        model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column != 0;
            }
        };

        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Apellidos");
        model.addColumn("DNI");
        model.addColumn("Email");
        model.addColumn("Contraseña");

        showTable.setModel(model);
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer() {
            @Override
            protected void setValue(Object value) {
                if (value instanceof String) {
                    setText("\u2022\u2022\u2022\u2022\u2022\u2022");
                } else {
                    super.setValue(value);
                }
            }
        };
        showTable.getColumnModel().getColumn(5).setCellRenderer(renderer);
    }

    private void configuracion_botones() {

        boton_nuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                limpiar();
            }
        });

        boton_anadir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!barra_nombre.getText().isEmpty() && !barra_apellidos.getText().isEmpty() && !barra_email.getText().isEmpty() && !barra_contrasena.getText().isEmpty()) {
                    String[] fila = {
                            numero_id.getText(),
                            barra_nombre.getText(),
                            barra_apellidos.getText(),
                            barra_dni.getText(),
                            barra_email.getText(),
                            barra_contrasena.getText()
                    };
                    model.addRow(fila);
                    contadorID++;
                    numero_id.setText(String.valueOf(contadorID));
                } else {
                    JOptionPane.showMessageDialog(Formulario_GUI_KevinLoayza.this, "Por favor, rellene los campos obligatorios.");
                }

                limpiar();
            }
        });

        boton_modificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int seleccionar_fila = showTable.getSelectedRow();

                if (seleccionar_fila != -1 && !barra_nombre.getText().isEmpty() && !barra_apellidos.getText().isEmpty() && !barra_email.getText().isEmpty() && !barra_contrasena.getText().isEmpty()) {
                    showTable.setValueAt(barra_nombre.getText(), seleccionar_fila, 1);
                    showTable.setValueAt(barra_apellidos.getText(), seleccionar_fila, 2);
                    showTable.setValueAt(barra_dni.getText(), seleccionar_fila, 3);
                    showTable.setValueAt(barra_email.getText(), seleccionar_fila, 4);
                    showTable.setValueAt(barra_contrasena.getText(), seleccionar_fila, 5);

                } else {
                    JOptionPane.showMessageDialog(Formulario_GUI_KevinLoayza.this, "Por favor, seleccione una fila y rellene los campos obligatorios.");
                }
            }
        });

        boton_eliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int seleccionar_fila = showTable.getSelectedRow();

                if (seleccionar_fila >= 0) {
                    DefaultTableModel model = (DefaultTableModel) showTable.getModel();
                    model.removeRow(seleccionar_fila);
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, seleccione una fila para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private void limpiar() {
        barra_nombre.setText("");
        barra_apellidos.setText("");
        barra_dni.setText("");
        barra_email.setText("");
        barra_contrasena.setText("");
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
