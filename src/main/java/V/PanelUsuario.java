package V;

import C.VistaController;
import M.Cuenta;

import javax.swing.*;

public class PanelUsuario extends JFrame {
    private JPanel pPrincipal;
    private JPanel pCuentas;
    private JPanel pMovimientos;
    private VistaController vistaController;
    private String dni;
    private String clave;
    public PanelUsuario(VistaController vistaController,String dni,String clave) {
        this.dni = dni;
        this.clave = clave;
        this.vistaController = vistaController;
        vistaController.obtenerNumeroCuentas(pCuentas,pMovimientos);
        add(pPrincipal);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(pPrincipal);

    }

}
