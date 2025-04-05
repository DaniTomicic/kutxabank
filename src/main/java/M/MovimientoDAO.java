package M;

import BD.BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MovimientoDAO {
    private Connection connection;
    private String sql;
    public MovimientoDAO(BD bd) {
        connection = bd.getConnection();
    }

    public List<Movimiento> read(String numCuenta) {
        List<Movimiento> movimientos = new ArrayList<>();
        sql = "SELECT * FROM movimientos WHERE num_cuenta = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, numCuenta);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Movimiento movimiento = new Movimiento();
                movimiento.setCodigo(rs.getString("id"));
                movimiento.setDescripcion(rs.getString("descripcion"));
                movimiento.setFecha(rs.getString("fecha"));
                movimiento.setImporte(rs.getFloat("importe"));
                movimientos.add(movimiento);
            }
        }catch (Exception e) {
            System.out.println("!ERROR EN READ MOVIMIENTO: " +  e.getMessage());
        }
        return movimientos;
    }

    public void updateMovimiento(String pago, String cuentaDestino, String cuentaOrigen, LocalDate hoy){
        sql ="INSERT INTO movimientos(id,descripcion,fecha,importe,num_cuenta) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,generarID());
            ps.setString(2,cuentaDestino);
            ps.setDate(3,parsearFecha(hoy));
            ps.setString(4,pago);
            ps.setString(5,cuentaOrigen);
            ps.executeUpdate();

        }catch (Exception e) {
            System.out.println("!ERROR EN UPDATE MOVIMIENTO: " +  e.getMessage());
        }
    }
    private java.sql.Date parsearFecha(LocalDate hoy) {
        return java.sql.Date.valueOf(hoy);
    }
    private int generarID() {
        sql = "SELECT MAX(id) FROM movimientos ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int max = rs.getInt(1);
                return rs.wasNull() ? 1 : max + 1;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 1;
    }
}
