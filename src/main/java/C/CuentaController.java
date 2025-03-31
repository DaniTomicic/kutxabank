package C;

import M.Cuenta;
import M.CuentaDAO;

public class CuentaController {
    protected CuentaDAO cDAO;
    public CuentaController(CuentaDAO cDAO) {
        this.cDAO = cDAO;
    }

    public Cuenta read(String numCuenta){
        return cDAO.read(numCuenta);
    }

}
