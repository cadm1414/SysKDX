package JAVA.CONFIG.LOGICA;

public class cbx_tipo_comercio {

    String codigo_comercio, nombre;

    public cbx_tipo_comercio(String codigo_comercio, String nombre) {
        this.codigo_comercio = codigo_comercio;
        this.nombre = nombre;
    }

    public String getID() {
        return codigo_comercio;
    }

    public String toString() {
        return nombre;
    }
}
