package C;

import M.Cuenta;
import M.Movimiento;
import M.Usuario;
import V.Login;
import V.PanelCuentas;
import V.PestanaPrincipal;

import javax.swing.*;
import java.util.List;
import java.util.Map;

public class VistaController {
    private final ModeloController modeloController;
    private PanelCuentas panelCuentas;
    public VistaController(ModeloController modeloController) {
        this.modeloController = modeloController;

        PestanaPrincipal principal = new PestanaPrincipal(this);
        principal.setVisible(true);
    }

    private Usuario cliente;

    public void setLogin() {
        Login login = new Login(this);
        login.setVisible(true);
    }
    public void setPanelCuentas(){
        this.panelCuentas = new PanelCuentas(this);
        panelCuentas.setVisible(true);
    }

    public boolean comprobarContrasenna(String clave) {
        return cliente.getClave().equals(clave);
    }
    public boolean buscarUsuario(String dni) {
        cliente = modeloController.getUsuario(dni);
        return cliente != null;
    }

    public void setCuentasBanco(JPanel pCuentas,JPanel pMovimientos){
        pCuentas.removeAll();
        ButtonGroup bg = new ButtonGroup();
        List<Cuenta> cuentasUsuario = cliente.getCuentas();

        for (int i = 0; i < cuentasUsuario.size(); i++) {
                int finali = i;
            //poner en RadioButton cuentas y aplicarlas al mismo ButtonGroup
            JRadioButton radioButton = new JRadioButton(cuentasUsuario.get(i).getNumCuenta());
            radioButton.addActionListener(e -> {
                mostrasMovimientos(finali,pMovimientos);
            });
            bg.add(radioButton);
            pCuentas.add(radioButton);
        }
        pCuentas.revalidate(); pCuentas.repaint();
        pCuentas.setVisible(true);
    }

    private void mostrasMovimientos(int nCuenta, JPanel pMovimientos) {
        JLabel[] posiciones = {panelCuentas.getMov1(),panelCuentas.getMov2(),panelCuentas.getMov3(),panelCuentas.getMov4(),panelCuentas.getMov5()};

        Cuenta cuenta = cliente.getCuentas().get(nCuenta);
        if(cuenta.getMovimientos().size() > 5){
            List<Movimiento> movimientos = cuenta.getMovimientos().subList(Math.max(cuenta.getMovimientos().size() - 5, 0), cuenta.getMovimientos().size());
            for (int i = 0; i < 5; i++){
                posiciones[i].setText(movimientos.get(i).toString());
            }
        }else {
            for (int i = 0; i < cuenta.getMovimientos().size(); i++){
                posiciones[i].setText(cuenta.getMovimientos().get(i).toString());

            }

        }
        //el saldo total:
        panelCuentas.getjSaldo().setText(String.valueOf(cuenta.getSaldo()));
        pMovimientos.revalidate(); pMovimientos.repaint();
        pMovimientos.setVisible(true);
    }


}
