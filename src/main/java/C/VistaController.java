package C;

import M.Usuario;
import V.Login;
import V.PestanaPrincipal;

import javax.swing.*;

public class VistaController {
    private final ModeloController modeloController;
    private Usuario cliente;

    public VistaController(ModeloController modeloController) {
        this.modeloController = modeloController;

        PestanaPrincipal principal = new PestanaPrincipal(this);
        principal.setVisible(true);
    }

    public void setLogin() {
        Login login = new Login(this);
        login.setVisible(true);
    }

    public boolean comprobarContrasenna(String clave) {
        return cliente.getClave().equals(clave);
    }
    public boolean buscarUsuario(String dni) {
        cliente = modeloController.getUsuario(dni);
        return cliente != null;
    }


}
