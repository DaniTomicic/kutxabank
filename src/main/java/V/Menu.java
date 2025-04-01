package V;

import C.CuentaController;
import C.UsuarioController;
import M.Cuenta;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {
    private JPanel pPrincipal;
    private JButton bAcceso;



    public Menu(UsuarioController usuarioController, CuentaController cuentaController) {
        add(pPrincipal);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        bAcceso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login login = new Login(usuarioController,cuentaController);
                login.setVisible(true);
                dispose();
            }
        });
    }
}
