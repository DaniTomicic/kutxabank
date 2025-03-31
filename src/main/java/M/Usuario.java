package M;

import java.util.List;

public class Usuario {
    private String dni;
    private String clave;
    private String nombre;
    private List<Cuenta> cuentas;



    public Usuario(String dni, String clave) {
        this.dni = dni;
        this.clave = clave;
    }
    public  Usuario() {}

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(Cuenta cuenta) {
        this.cuentas.add(cuenta);
    }
    @Override
    public String toString() {
        return dni + " ";
    }
}
