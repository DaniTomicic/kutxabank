package V;

import C.VistaController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Menu extends JFrame {
    private JPanel pPrincipal;
    private JButton bAcceso;
    private VistaController vistaController;

    public Menu(VistaController vistaController) {
        this.vistaController = vistaController;
        add(pPrincipal);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        bAcceso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login login = new Login(vistaController);
                login.setVisible(true);
                dispose();
            }
        });
    }
}
