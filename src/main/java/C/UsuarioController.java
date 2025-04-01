package C;

import M.Usuario;
import M.UsuarioDAO;

public class UsuarioController {
    protected UsuarioDAO usuarioDAO;
    protected Usuario usuario;

    public UsuarioController(UsuarioDAO uDAO) {
        this.usuarioDAO = uDAO;
    }

    public Usuario read(String dni, String clave){
        usuario = usuarioDAO.read(dni,clave);
        return usuario;
    }


}
