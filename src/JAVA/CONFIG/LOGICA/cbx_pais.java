package JAVA.CONFIG.LOGICA;

public class cbx_pais {

    String codigo_pais, nombre;

    public cbx_pais(String codigo_pais, String nombre) {
        this.codigo_pais = codigo_pais;
        this.nombre = nombre;
    }

    public String getID() {
        return codigo_pais;
    }

    public String toString() {
        return nombre;
    }
}
