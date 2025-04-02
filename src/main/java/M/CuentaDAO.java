package M;

import BD.BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public List<Cuenta> readCuentas(String nif) {
        sql = "SELECT c.num_cuenta, c.saldo FROM cuentas c, cuentas_clientes cc WHERE cc.dni = ? AND cc.num_cuenta = c.num_cuenta";
        List<Cuenta> cuentas = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nif);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cuenta cuenta = new Cuenta();
                cuenta.setNumCuenta(rs.getString("num_cuenta"));
                cuenta.setSaldo(rs.getFloat("saldo"));
                cuentas.add(cuenta);
            }
        }catch (SQLException e){
            System.out.println("ERROR EN READ CUENTAS:" +e.getMessage());
        }
        return cuentas;
    }

}
