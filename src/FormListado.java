import javax.swing.*;
import java.util.ArrayList;

public class FormListado extends JFrame {

    private JPanel panelPrincipal;
    private JList<Usuario> lstUsuarios;
    private JButton btnVerDetalle;

    private ArrayList<Usuario> usuarios;
    private DefaultListModel<Usuario> modelo = new DefaultListModel<>();

    public FormListado(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;

        setTitle("BookUsers · Listado");
        setContentPane(panelPrincipal);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);

        for (Usuario u : usuarios) {
            modelo.addElement(u);
        }
        lstUsuarios.setModel(modelo);

        btnVerDetalle.addActionListener(e -> verDetalle());
    }

    private void verDetalle() {
        int indice = lstUsuarios.getSelectedIndex();
        if (indice == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un usuario de la lista.");
            return;
        }
        Usuario seleccionado = modelo.getElementAt(indice);
        // Aquí se abrirá FormDetalle (siguiente paso)
    }
}