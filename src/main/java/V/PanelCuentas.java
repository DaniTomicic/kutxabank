package V;

import C.VistaController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelCuentas extends JFrame {


    private JPanel pPrincipal;
    private JPanel pCuentas;
    private JPanel pMovimientos;
    private JMenuBar menuBar;
    private JMenu Cuentas;
    private JMenuItem mMovimientos;
    private JMenuItem mConsultas;
    private JButton bMostrarCuentas;
    private JLabel mov1;
    private JLabel mov2;
    private JLabel mov3;
    private JLabel mov4;
    private JLabel mov5;
    private javax.swing.JLabel JLabel;
    private JLabel jSaldo;

    public PanelCuentas(VistaController vistaController) {
        setContentPane(pPrincipal);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600,600);
        setLocationRelativeTo(this.getParent());

        //paneles ocultos para que no den errores de ventanas mutantes
        pCuentas.setVisible(false); pMovimientos.setVisible(false);

        bMostrarCuentas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vistaController.setCuentasBanco(pCuentas,pMovimientos);
                //paso ambos por que necesito la cuenta para obtener los movimientos y viceversa
            }
        });

        //estos AL hacen lo mismo solo que uno ejecuta codigo y el otro lo llama
        mConsultas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bMostrarCuentas.doClick();
            }
        });

        mMovimientos.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               vistaController.setMovimientos(pMovimientos,pCuentas);
           }
        });
    }
    //para hacer un array con los JLabel e ir añadiendoles texto

    public javax.swing.JLabel getMov1() {
        return mov1;
    }

    public javax.swing.JLabel getMov2() {
        return mov2;
    }

    public javax.swing.JLabel getMov3() {
        return mov3;
    }

    public javax.swing.JLabel getMov4() {
        return mov4;
    }

    public javax.swing.JLabel getMov5() {
        return mov5;
    }

    public javax.swing.JLabel getjSaldo() {
        return jSaldo;
    }
}
