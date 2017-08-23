package JAVA.INVENT.LOGICA;

public class cbx_entidad_ubigeo {

    String ls_codigo_ubigeo, ls_direccion, ls_descripcion;

    public cbx_entidad_ubigeo(String ls_codigo_ubigeo, String ls_direccion, String ls_descripcion) {
        this.ls_codigo_ubigeo = ls_codigo_ubigeo;
        this.ls_direccion = ls_direccion;
        this.ls_descripcion = ls_descripcion;
    }

    public String getID() {
        return ls_codigo_ubigeo;
    }

    public String descripcion() {
        return ls_descripcion;
    }

    public String toString() {
        return ls_direccion;
    }
}
