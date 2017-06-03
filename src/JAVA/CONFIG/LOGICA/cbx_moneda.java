package JAVA.CONFIG.LOGICA;

public class cbx_moneda {

    String ls_codigo_moneda, ls_nombre_moneda, ls_simbolo_moneda;

    public cbx_moneda(String ls_codigo_moneda, String ls_nombre_moneda, String ls_simbolo_moneda) {
        this.ls_codigo_moneda = ls_codigo_moneda;
        this.ls_nombre_moneda = ls_nombre_moneda;
        this.ls_simbolo_moneda = ls_simbolo_moneda;
    }

    public String getID() {
        return ls_codigo_moneda;
    }

    public String simbolo_moneda() {
        return ls_simbolo_moneda;
    }

    public String toString() {
        return ls_nombre_moneda;
    }
}
