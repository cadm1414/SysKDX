package JAVA.VENTAS.LOGICA;

public class cbx_igv {
    
    String ls_codigo,ls_monto;
    
    public cbx_igv(String codigo,String monto){
        this.ls_codigo = codigo;
        this.ls_monto = monto;
    }
    
    public String getID() {
        return ls_codigo;
    }

    public String toString() {
        return ls_monto;
    }

}
