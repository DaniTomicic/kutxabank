package M;

import BD.BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAO {
    protected Connection con;
    private String sql;
    public UsuarioDAO(BD bd) {
        this.con = bd.getConnection();
    }

    public Usuario read(String dni,String clave) {
        sql = "select * from usuarios where dni=? and clave=?";
        Usuario u = new Usuario();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, dni);
            ps.setString(2, clave);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                u.setDni(rs.getString("dni"));
                u.setClave(rs.getString("clave"));
                u.setNombre(rs.getString("nombre"));
            }
        }catch (Exception e) {
            System.out.println("ERROR EN READ USUARIO: " + e.getMessage());
        }
        return u;
    }
}
