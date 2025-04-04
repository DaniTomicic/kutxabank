package C;

import BD.BD;
import M.*;


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

    public boolean getClave(String clave) {
        return usuario.getClave().equals(clave);
    }

    public Usuario getCliente() {
        return usuarioController.getUsuario();
    }

}
