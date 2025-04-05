package C;

import M.Cuenta;
import M.CuentaDAO;

import java.util.List;

public class CuentaController {
    protected CuentaDAO cDAO;
    protected Cuenta cuenta;
    public CuentaController(CuentaDAO cDAO) {
        this.cDAO = cDAO;
    }

    public Cuenta read(String numCuenta){
        cuenta = cDAO.read(numCuenta);
        return cuenta;
    }

    public List<Cuenta> readCuentas(String dni){
        return cDAO.readCuentas(dni);
    }
    public boolean hacerPago(String pago,String cuenta){
        return cDAO.updateSaldo(pago,cuenta);
    }
    public Cuenta obtenerCuenta(){
        return cuenta;
    }

}
