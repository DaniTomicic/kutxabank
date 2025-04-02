package M;

import BD.BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
}
