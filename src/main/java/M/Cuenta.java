package M;


import java.util.ArrayList;
import java.util.List;

public class Cuenta {
    private String numCuenta;
    private String tipoMovimiento;
    private float saldo;
    private List<Movimiento> movimientos;


    public Cuenta(String numCuenta, String tipoMovimiento, float saldo) {
        this.numCuenta = numCuenta;
        this.tipoMovimiento = tipoMovimiento;
        this.saldo = saldo;
        this.movimientos = new ArrayList<>() {
        };
    }

    public Cuenta() {}

    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public List<Movimiento> getMovimientos() {
        return movimientos;
    }

    public void setMovimiento(List<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }

    @Override
    public String toString() {
        return numCuenta + " " + saldo;
    }
}
