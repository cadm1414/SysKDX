package JAVA.INVENT.LOGICA;

public class cbx_producto {

    String ls_codigo, ls_nombre;

    public cbx_producto(String codigo, String nombre) {
        this.ls_codigo = codigo;
        this.ls_nombre = nombre;
    }

    public String getID() {
        return ls_codigo;
    }

    public String toString() {
        return ls_nombre;
    }
}
