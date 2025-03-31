package V;

import C.UsuarioController;

import javax.swing.*;

public class PanelUsuario extends JFrame {
    protected UsuarioController usuarioController;
    private JPanel pPrincipal;

    public PanelUsuario(UsuarioController usuarioController) {
        add(pPrincipal);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setContentPane(pPrincipal);

        this.usuarioController = usuarioController;
    }


}
