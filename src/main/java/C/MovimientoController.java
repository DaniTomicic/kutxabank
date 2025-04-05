package C;

import M.Movimiento;
import M.MovimientoDAO;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

public class MovimientoController {
    private final MovimientoDAO mdao;
    public MovimientoController(MovimientoDAO mDAO) {
        this.mdao = mDAO;
    }
    public List<Movimiento> obtenerMovs(String numCuenta) {
        return mdao.read(numCuenta);
    }
    public void grabarPago(String pago,String cuentaDestino,String cuentaOrigen) {
        LocalDate hoy = LocalDate.now();
        mdao.updateMovimiento(pago,cuentaDestino,cuentaOrigen,hoy);
    }

}
