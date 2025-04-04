package V;

import C.VistaController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PestanaPrincipal extends JFrame{
    private VistaController vistaController;
    private JPanel pPrincipal;
    private JButton bAcceder;

    public PestanaPrincipal(VistaController vistaController){
        setContentPane(pPrincipal);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,400);
        setLocationRelativeTo(this.getParent());

        this.vistaController = vistaController;


        bAcceder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                vistaController.setLogin();
            }
        });
    }
}
