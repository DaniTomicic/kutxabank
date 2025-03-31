package M;


import java.util.HashSet;
import java.util.Set;

public class Cuenta {
    String numCuenta;
    String tipoMovimiento;
    float saldo;
    Set<Usuario> usuarios;

    public Cuenta(String numCuenta, String tipoMovimiento, float saldo) {
        this.numCuenta = numCuenta;
        this.tipoMovimiento = tipoMovimiento;
        this.saldo = saldo;
        this.usuarios = new HashSet<>() {
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

    public Set<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuario usuarios) {
        this.usuarios.add(usuarios);
    }

    @Override
    public String toString() {
        return numCuenta + " " + saldo;
    }
}
