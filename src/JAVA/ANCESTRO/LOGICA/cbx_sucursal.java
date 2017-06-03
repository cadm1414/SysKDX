package JAVA.ANCESTRO.LOGICA;

public class cbx_sucursal {
    
    String ls_codigo,ls_nombre;
    
    public cbx_sucursal(String codigo,String nombre){
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
