package C;

import M.Cuenta;
import M.Movimiento;
import M.Usuario;
import V.Menu;
import V.PanelUsuario;

import javax.swing.*;
import java.util.List;

public class VistaController {
    private final ModeloController modeloController;
    private PanelUsuario panelUsuario;
    private Usuario cliente;
    public VistaController(ModeloController modeloController) {
        this.modeloController = modeloController;

        Menu menu = new Menu(this);
        menu.setVisible(true);

    }

    public boolean getUsuario(String dni) {
        return modeloController.getUsuario(dni);
    }
    public boolean getClave(String clave){
        return modeloController.getClave(clave);
    }

    public void obtenerNumeroCuentas(JPanel pCuentas,JPanel pMovimientos) {
        cliente = modeloController.getCliente();
        ButtonGroup bg = new ButtonGroup();
        pCuentas.removeAll();

        for (int i=0; i < modeloController.getCuentas(cliente).size(); i++) {
            JRadioButton radioButton = new JRadioButton(cliente.getCuentas().get(i).getNumCuenta());
            int finalX = i;
            //aqui la verdad algo un poco perdido
            radioButton.addActionListener(e ->
                    mostrarMovs(finalX,pMovimientos)
            );

            bg.add(radioButton);
            pCuentas.add(radioButton);
        }
        pCuentas.revalidate();
        pCuentas.repaint();
        pCuentas.setVisible(true);
    }
    public void mostrarMovs(int x,JPanel pMovimientos) {
        JLabel[] etiquetas = {panelUsuario.getlMov1(),panelUsuario.getlMov2(),panelUsuario.getlMov3(),panelUsuario.getlMov4(),panelUsuario.getlMov5()};

        for (JLabel r : etiquetas) {
            r.setText("");
        }
        panelUsuario.getSaldo().setText("");

        Cuenta c = cliente.getCuentas().get(x);
        if (c.getMovimientos().size() >= 5){
            List<Movimiento> cinco = c.getMovimientos().subList(Math.max(c.getMovimientos().size() -5,0), c.getMovimientos().size());
            for (int i = 0; i < 5; i++) {
                etiquetas[i].setText(cinco.get(i).toString());
            }
        }else {
            for (int i = 0; i < c.getMovimientos().size(); i++) {
                etiquetas[1].setText(c.getMovimientos().get(i).toString());
            }
        }
        panelUsuario.getSaldo().setText(String.valueOf(c.getSaldo()));
        pMovimientos.setVisible(true);
    }
}
