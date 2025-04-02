package V;

import C.ModeloController;
import C.VistaController;

import javax.lang.model.element.ModuleElement;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Login extends JDialog {
    private JPanel contentPane;
    private JPanel pPrincipal;
    private JTextField tfDNI;
    private JTextField tfPassword;
    private JPanel pNumero;
    private VistaController vistaController;

    public Login(VistaController vistaController) {
        setTitle("Login");
        setSize(400, 500);
        setModal(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.vistaController = vistaController;

        // Panel principal con BorderLayout
        pPrincipal = new JPanel(new BorderLayout());
        setContentPane(pPrincipal);

        // Panel de campos de texto
        JPanel pCampos = new JPanel(new GridLayout(2, 2, 5, 5));
        tfDNI = new JTextField();
        tfPassword = new JPasswordField();
        pCampos.add(new JLabel("NIF:"));
        pCampos.add(tfDNI);
        pCampos.add(new JLabel("Clave:"));
        pCampos.add(tfPassword);
        pPrincipal.add(pCampos, BorderLayout.NORTH);

        // Panel para los números
        pNumero = new JPanel(new GridLayout(3, 3, 5, 5));
        generarNumeros();
        pPrincipal.add(pNumero, BorderLayout.CENTER);

        // Panel de botones
        JPanel pBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JButton okButton = new JButton("Acceder");
        pBotones.add(okButton);
        pPrincipal.add(pBotones, BorderLayout.SOUTH);

        //teclado
        tfDNI.addActionListener(e -> tfPassword.requestFocus());
        tfPassword.addActionListener(e -> onOK());

        //boton
        okButton.addActionListener(e -> onOK());
    }

    private void onOK() {
        String dni = tfDNI.getText();
        String clave = tfPassword.getText();
        //validar usuario a DAO

        if (vistaController.getUsuario(dni,clave)==null){
            JOptionPane.showMessageDialog(this, "Usuario no encontrado");
        }else {
            PanelUsuario panelUsuario = new PanelUsuario(vistaController,dni,clave);
            panelUsuario.setVisible(true);
            dispose();
        }
    }

    private void generarNumeros() {
        pNumero.removeAll();
        List<String> numeros = new ArrayList<>();

        for (int i = 1; i <= 9; i++) {
            numeros.add(String.valueOf(i));
        }
        Collections.shuffle(numeros);

        for (String numero : numeros) {
            JButton button = new JButton(numero);
            button.addActionListener(e -> tfPassword.setText(tfPassword.getText() + numero));
            pNumero.add(button);
        }
        pNumero.revalidate();pNumero.repaint();
    }
}
