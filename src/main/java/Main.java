import BD.BD;
import C.CuentaController;
import C.MovimientoController;
import C.UsuarioController;
import M.*;
import V.Menu;

public class Main {

    public static void main(String[] args) {declararVar();}
    public static void declararVar() {
        BD bd = new BD();
        CuentaDAO cDAO = new CuentaDAO(bd);
        MovimientoDAO mDAO = new MovimientoDAO(bd);
        UsuarioDAO uDAO = new UsuarioDAO(bd);
        CuentaController cuentaController = new CuentaController(cDAO);
        MovimientoController movimientoController = new MovimientoController(mDAO);
        UsuarioController usuarioController = new UsuarioController(uDAO);
        Menu menu = new Menu(usuarioController,cuentaController);
    }
}
