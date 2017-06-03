package JAVA.ANCESTRO.LOGICA;

public class cbx_empresa {

    int li_codigo_empresa;
    String ls_nombre_empresa, ls_base_datos;

    public cbx_empresa(int li_codigo_empresa, String ls_base_datos, String ls_nombre_empresa) {
        this.li_codigo_empresa = li_codigo_empresa;
        this.ls_base_datos = ls_base_datos;
        this.ls_nombre_empresa = ls_nombre_empresa;
    }

    public int getID() {
        return li_codigo_empresa;
    }

    public String base_datos() {
        return ls_base_datos;
    }

    public String toString() {
        return ls_nombre_empresa;
    }
}
