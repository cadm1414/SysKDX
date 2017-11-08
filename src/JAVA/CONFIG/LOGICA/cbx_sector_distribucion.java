package JAVA.CONFIG.LOGICA;

public class cbx_sector_distribucion {

    String codigo, descripcion;

    public cbx_sector_distribucion(String codigo, String descripcion) {
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
