package C;

import M.Cuenta;
import M.Usuario;
import V.Menu;
import V.PanelUsuario;
import M.Usuario

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaController {
    private final ModeloController modeloController;
    private PanelUsuario panelUsuario;
    private Usuario cliente;
    public VistaController(ModeloController modeloController) {
        this.modeloController = modeloController;

        Menu menu = new Menu(this);
        menu.setVisible(true);

    }

    public Usuario getUsuario(String dni, String clave) {
        return modeloController.getUsuario(dni, clave);
    }

    public void obtenerNumeroCuentas(JPanel pCuentas,JPanel pMovimientos) {
        Usuario u = modeloController.getCliente();
        ButtonGroup bg = new ButtonGroup();
        pCuentas.removeAll();

        for (int i=0; i < modeloController.getCuentas(u).size(); i++) {
            JRadioButton radioButton = new JRadioButton(u.getCuentas().get(i).getNumCuenta());
            int finalX = i;
            radioButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    mostrarMovs(finalX,pMovimientos);
                }
            });

            bg.add(radioButton);
            pCuentas.add(radioButton);
        }
        pCuentas.revalidate();
        pCuentas.repaint();
        pCuentas.setVisible(true);
    }
    public void mostrarMovs(int x,JPanel pMovimientos) {
        JLabel[] etiquetas = {panelUsuario.getm1(),panelUsuario.getm2(),panelUsuario.getm3(),panelUsuario.getm3(),panelUsuario.etm4(),panelUsuario.getm5()};
        for (int i=0; i < etiquetas.length; i++) {
            etiquetas[i].setText("");
        }
        panelUsuario.getpSaldo().setText("");

        Cuenta c = cliente.getCuentas().get(x);
        pMovimientos.removeAll();

    }
}
