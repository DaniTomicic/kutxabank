package V;

import C.UsuarioController;
import M.Cuenta;
import M.Usuario;

import javax.swing.*;

public class PanelUsuario extends JFrame {
    protected UsuarioController usuarioController;
    private JPanel pPrincipal;
    private JPanel pCuentas;
    private JPanel pMovimientos;

    public PanelUsuario(UsuarioController usuarioController) {
        add(pPrincipal);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setContentPane(pPrincipal);

        this.usuarioController= usuarioController;

        obtenerNumerosCuentas();
    }

    private void obtenerNumerosCuentas() {
        pCuentas.removeAll();
        ButtonGroup bg = new ButtonGroup();
        /*
        for (Cuenta u : usuario.getCuentas()){
            JRadioButton jrbCuenta = new JRadioButton(u.toString());
            bg.add(jrbCuenta);
            pCuentas.add(jrbCuenta);
        }pCuentas.repaint(); pCuentas.revalidate();

         */
    }


}
