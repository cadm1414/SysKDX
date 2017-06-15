package JAVA.CONFIG.LOGICA;

public class cbx_tabla_sunat {

    String codigo_sunat, descripcion;

    public cbx_tabla_sunat(String codigo_sunat, String descripcion) {
        this.codigo_sunat = codigo_sunat;
        this.descripcion = descripcion;
    }

    public String getID() {
        return codigo_sunat;
    }

    public String toString() {
        return descripcion;
    }
}
