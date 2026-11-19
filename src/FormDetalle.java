import javax.swing.*;
import java.awt.Image;
import java.io.File;

public class FormDetalle extends JFrame {

    private JPanel panelPrincipal;
    private JLabel lblFoto;
    private JTextArea txtInfo;
    private JButton btnGenerarPdf;

    private Usuario usuario;

    public FormDetalle(Usuario usuario) {
        this.usuario = usuario;

        setTitle("BookUsers · Detalle");
        setContentPane(panelPrincipal);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(450, 550);
        setLocationRelativeTo(null);

        mostrarFoto();
        mostrarInfo();
    }

    private void mostrarFoto() {
        String ruta = usuario.getRutaFoto();
        if (ruta == null || ruta.isEmpty() || !new File(ruta).exists()) {
            lblFoto.setText("Sin foto");
            return;
        }
        ImageIcon icono = new ImageIcon(ruta);
        Image escalada = icono.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        lblFoto.setText("");
        lblFoto.setIcon(new ImageIcon(escalada));
    }

    private void mostrarInfo() {
        txtInfo.setEditable(false);
        txtInfo.setText(
                "ID: " + usuario.getId() + "\n"
                        + "Tipo de identificación: " + usuario.getTipoIdentificacion() + "\n"
                        + "Número de identificación: " + usuario.getNumeroIdentificacion() + "\n"
                        + "Primer nombre: " + usuario.getPrimerNombre() + "\n"
                        + "Segundo nombre: " + usuario.getSegundoNombre() + "\n"
                        + "Primer apellido: " + usuario.getPrimerApellido() + "\n"
                        + "Segundo apellido: " + usuario.getSegundoApellido() + "\n"
                        + "Username: " + usuario.getUsername() + "\n"
                        + "Teléfono: " + usuario.getTelefono() + "\n"
                        + "Correo: " + usuario.getCorreo()
        );
    }
}