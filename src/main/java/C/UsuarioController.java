package C;

import M.Usuario;
import M.UsuarioDAO;

public class UsuarioController {
    protected UsuarioDAO usuarioDAO;
    protected Usuario usuario;

    public UsuarioController(UsuarioDAO uDAO) {
        this.usuarioDAO = uDAO;
    }

    public Usuario read(String dni){
        usuario = usuarioDAO.read(dni);
        return usuario;
    }
    public Usuario getUsuario(){
        return usuario;
    }

}
