package C;

import BD.BD;
import M.*;

import javax.swing.*;


public class ModeloController {
    private CuentaController cuentaController;
    private MovimientoController movimientoController;
    private UsuarioController usuarioController;

    private Usuario usuario;
    public ModeloController() {
        try {
            BD bd = new BD();
            CuentaDAO cDAO = new CuentaDAO(bd);
            cuentaController = new CuentaController(cDAO);

            MovimientoDAO mDAO = new MovimientoDAO(bd);
            movimientoController = new MovimientoController(mDAO);

            UsuarioDAO uDAO = new UsuarioDAO(bd);
            usuarioController = new UsuarioController(uDAO);
        }catch (Exception e) {
            System.out.println("ERROR EN MODELO CONTROLLER: " + e.getMessage());
        }
    }

    public void setVista(VistaController vistaController) {
    }

    public Usuario getUsuario(String dni) {
        usuario = usuarioController.read(dni);
        if (usuario != null) {
            usuario.setCuentas(cuentaController.readCuentas(usuario.getDni()));
            //obtengo cuentas

            for (Cuenta cuenta : usuario.getCuentas()) {
                cuenta.setMovimiento(movimientoController.obtenerMovs(cuenta.getNumCuenta()));
                //por cada cuenta, los movimientos
            }
        }
        return usuario;
    }
    public boolean hacerPago(String tfPago, String tfCuenta,int nCuenta){
        //parsear importe a numero
        double pago = Double.parseDouble(tfPago.trim());

        if ( pago < getCliente().getCuentas().get(nCuenta).getSaldo()){
            return cuentaController.hacerPago(String.valueOf(pago),usuario.getCuentas().get(nCuenta).getNumCuenta());
        }else {
            JOptionPane.showMessageDialog(null,
                    "Fondos insuficientes. Saldo actual: " + cuentaController.read(tfCuenta).getSaldo(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    public void grabarPago(String pago, String cuentaDestino,int cuentaOrigen){
        movimientoController.grabarPago(pago,cuentaDestino,usuario.getCuentas().get(cuentaOrigen).getNumCuenta());
    }

    public boolean getClave(String clave) {
        return usuario.getClave().equals(clave);
    }

    public Usuario getCliente() {
        return usuarioController.getUsuario();
    }

}
