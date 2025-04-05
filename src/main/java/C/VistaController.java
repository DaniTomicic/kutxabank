package C;

import M.Cuenta;
import M.Movimiento;
import M.Usuario;
import V.Login;
import V.PanelCuentas;
import V.PestanaPrincipal;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public void setMovimientos(JPanel pMovimientos,JPanel pCuentas) {
        pCuentas.removeAll();
        ButtonGroup bg = new ButtonGroup();
        List<Cuenta> cuentasUsuario = cliente.getCuentas();
        int i = 0;
        for (Cuenta cuenta : cuentasUsuario) {
            //poner en RadioButton cuentas y aplicarlas al mismo ButtonGroup
            JRadioButton radioButton = new JRadioButton(cuenta.getNumCuenta());
            int finalI = i;
            radioButton.addActionListener(e -> {
                mostrarPanel(pMovimientos, finalI);
            });
            i++;
            bg.add(radioButton);
            pCuentas.add(radioButton);
        }
        pCuentas.revalidate(); pCuentas.repaint();
        pCuentas.setVisible(true);
    }
    private void mostrarPanel(JPanel pMovimiento,int numCuenta) {
        pMovimiento.removeAll();
        String[] s={"Transferencia","Pago de recibo"};
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.CENTER;
        JComboBox comboBox = new JComboBox(s);
        JTextField tfCuentaDestino = new JTextField(15);
        JTextField tfImporte = new JTextField(15);
        JButton bAceptar = new JButton("Aceptar");
            gbc.gridx = 0; gbc.gridy = 0;
            pMovimiento.add(comboBox,gbc);
            pMovimiento.add(new JLabel("Tipo: "),gbc);
            gbc.gridy++;
            pMovimiento.add(new JLabel("Cuenta de destino: "),gbc);
            gbc.gridx++;
            pMovimiento.add(tfCuentaDestino,gbc);
            gbc.gridx--;
            gbc.gridy++;
            pMovimiento.add(new JLabel("Importe: "),gbc);
            gbc.gridx++;
            pMovimiento.add(tfImporte,gbc);
            gbc.gridx--;
            gbc.gridy++;
            bAceptar.addActionListener(e -> {
                if (tfImporte.getText().isEmpty() || tfCuentaDestino.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(pMovimiento, "Los campos tienen que estar llenos");
                }else {
                    //obtener el tipo de mov y en base a eso el patron
                    if (comboBox.getItemAt(comboBox.getSelectedIndex()).equals("Transferencia")) {
                        movimientoTransferencia(tfImporte,tfCuentaDestino);
                    }else {
                        movimientoPago(tfImporte,tfCuentaDestino,numCuenta);
                    }
                }
            });
        pMovimiento.add(bAceptar,gbc);


        pMovimiento.repaint(); pMovimiento.revalidate();
        pMovimiento.setVisible(true);
    }
    private void movimientoPago(JTextField tfImporte,JTextField tfCuentaDestino,int numCuenta) {
        Pattern patron = Pattern.compile("^[0-9]{8}-[A-Z]{2}$");
        Matcher matcher = patron.matcher(tfCuentaDestino.getText().trim());
        if (matcher.matches()) {
            if (modeloController.hacerPago(tfImporte.getText(),tfCuentaDestino.getText(),numCuenta)){
                JOptionPane.showMessageDialog(panelCuentas,"Ingreso realiado correctamente");
                modeloController.grabarPago(tfImporte.getText(),tfCuentaDestino.getText(),numCuenta);
                tfImporte.setText(""); tfCuentaDestino.setText("");
            }else {
                JOptionPane.showMessageDialog(panelCuentas,"Algo ha ido mal al hacer el pago");
                tfImporte.setText(""); tfCuentaDestino.setText("");
            }
        }else {
            JOptionPane.showMessageDialog(panelCuentas, "Cuenta de destino invalida, EJ: 11111111-AA");
            tfCuentaDestino.setText("");
        }
    }
    private void movimientoTransferencia(JTextField tfImporte,JTextField tfCuentaDestino) {}

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


}
