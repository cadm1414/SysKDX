package JAVA.CONFIG.LOGICA;

public class cbx_tabla_ayuda {

    String codigo, descripcion;

    public cbx_tabla_ayuda(String codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public String getID() {
        return codigo;
    }

    public String toString() {
        return descripcion;
    }
}
