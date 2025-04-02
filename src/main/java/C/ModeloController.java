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

    public Usuario getUsuario(String dni, String clave) {
        return usuarioController.read(dni, clave);
    }

    public Usuario getCliente() {
        return usuarioController.getUsuario();
    }

    public List<Cuenta> getCuentas(Usuario usuario) {
        return cuentaController.readCuentas(usuario.getDni());
    }
}
