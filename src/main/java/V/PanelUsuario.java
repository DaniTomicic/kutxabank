package V;

import C.VistaController;

import javax.swing.*;

public class PanelUsuario extends JFrame {
    private JPanel pPrincipal;
    private JPanel pCuentas = new JPanel();
    private JPanel pMovimientos = new JPanel();
    private JMenuBar menu = new JMenuBar();
    private JMenu mCuentas = new JMenu();
    private JMenu mServicios = new JMenu();
    private JMenuItem mConsultas = new JMenuItem();
    private JMenuItem mMovimientos = new JMenuItem();
    private JLabel lMov1 = new JLabel();
    private JLabel lMov2 = new JLabel();
    private JLabel lMov3 = new JLabel();
    private JLabel lMov4 = new JLabel();
    private JLabel lMov5 = new JLabel();
    private JLabel jSaldo;
    private VistaController vistaController;

    public PanelUsuario(VistaController vistaController) {
        this.vistaController = vistaController;

        vistaController.obtenerNumeroCuentas(pCuentas,pMovimientos);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(pPrincipal);
    }

    public JLabel getlMov1() {
        return lMov1;
    }

    public JLabel getlMov2() {
        return lMov2;
    }

    public JLabel getlMov3() {
        return lMov3;
    }

    public JLabel getlMov4() {
        return lMov4;
    }

    public JLabel getlMov5() {
        return lMov5;
    }
    public JLabel getSaldo(){
        return jSaldo;
    }
}
