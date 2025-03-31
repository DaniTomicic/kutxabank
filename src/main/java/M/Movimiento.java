package M;

public class Movimiento {
    String codigo;
    String descripcion;
    String fecha;
    float importe;
    Cuenta cuenta;

    public Movimiento(String codigo, String descripcion, String fecha, float importe, Cuenta cuenta) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.importe = importe;
        this.cuenta = cuenta;
    }

    public Movimiento() {}

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public String toString() {
        return importe + " " + descripcion + " " + fecha;
    }
}
