package C;

import M.Usuario;
import M.UsuarioDAO;

public class UsuarioController {
    protected UsuarioDAO usuarioDAO;
    public UsuarioController(UsuarioDAO uDAO) {
        this.usuarioDAO = uDAO;
    }
    public Usuario read(String dni, String clave){
        return usuarioDAO.read(dni,clave);
    }
}
