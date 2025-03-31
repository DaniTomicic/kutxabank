package M;

import BD.BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CuentaDAO {
    Connection con;
    String sql;
    public CuentaDAO(BD bd) {
        con = bd.getConnection();
    }

    public Cuenta read(String numCuenta) {
        Cuenta cuenta = new Cuenta();
        sql = "select * from cuentas where num_cuenta = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, numCuenta);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cuenta.setNumCuenta(rs.getString("num_cuenta"));
                cuenta.setSaldo(rs.getFloat("saldo"));
            }
        }catch (SQLException e){
            System.out.println("ERROR EN READ :" +e.getMessage());
        }
        return cuenta;
    }
}
