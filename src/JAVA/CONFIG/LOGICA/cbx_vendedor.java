package JAVA.CONFIG.LOGICA;

public class cbx_vendedor {

    String codigo_vendedor, nombre;

    public cbx_vendedor(String codigo_vendedor, String nombre) {
        this.codigo_vendedor = codigo_vendedor;
        this.nombre = nombre;
    }

    public String getID() {
        return codigo_vendedor;
    }

    public String toString() {
        return nombre;
    }
}
