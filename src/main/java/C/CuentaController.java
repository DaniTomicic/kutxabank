package C;

import M.Cuenta;
import M.CuentaDAO;

import java.util.List;

public class CuentaController {
    protected CuentaDAO cDAO;
    public CuentaController(CuentaDAO cDAO) {
        this.cDAO = cDAO;
    }

    public Cuenta read(String numCuenta){
        return cDAO.read(numCuenta);
    }

    public List<Cuenta> readCuentas(String dni){
        return cDAO.readCuentas(dni);
    }

}
