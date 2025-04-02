package C;

import M.Movimiento;
import M.MovimientoDAO;

import java.util.List;

public class MovimientoController {
    private MovimientoDAO mdao;
    public MovimientoController(MovimientoDAO mDAO) {
        this.mdao = mDAO;
    }
    public List<Movimiento> obtenerMovs(String numCuenta) {
        return mdao.read(numCuenta);
    }

}
