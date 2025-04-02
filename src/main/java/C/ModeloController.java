package C;

import BD.BD;
import M.*;

import java.util.List;

public class ModeloController {
    private CuentaController cuentaController;
    private MovimientoController movimientoController;
    private UsuarioController usuarioController;
    private CuentaDAO cDAO;
    private MovimientoDAO mDAO;
    private UsuarioDAO uDAO;
    private VistaController vistaController;
    private Usuario usuario;

    public ModeloController() {
        try {
            BD bd = new BD();
            cDAO = new CuentaDAO(bd);
            cuentaController = new CuentaController(cDAO);

            mDAO = new MovimientoDAO(bd);
            movimientoController = new MovimientoController(mDAO);

            uDAO = new UsuarioDAO(bd);
            usuarioController = new UsuarioController(uDAO);
        }catch (Exception e) {
            System.out.println("ERROR EN MODELO CONTROLLER: " + e.getMessage());
        }
    }

    public void setVista(VistaController vistaController) {
        this.vistaController = vistaController;
    }
    public VistaController getVista() {
        return vistaController;
    }

    public boolean getUsuario(String dni) {
        usuario = usuarioController.read(dni);
        if (usuario != null) {
            usuario.setCuentas(cuentaController.readCuentas(usuario.getDni()));
            //obtengo cuentas

            for (Cuenta cuenta : usuario.getCuentas()) {
                cuenta.setMovimiento(movimientoController.obtenerMovs(cuenta.getNumCuenta()));
                //por cada cuenta, los movimientos
            }
        }
        return usuario != null;
    }

    public boolean getClave(String clave) {
        return usuario.getClave().equals(clave);
    }

    public Usuario getCliente() {
        return usuarioController.getUsuario();
    }

    public List<Cuenta> getCuentas(Usuario usuario) {
        return cuentaController.readCuentas(usuario.getDni());
    }
}
