package JAVA.CONFIG.LOGICA;

public class cbx_rol {

    String ls_nombre_rol;
    int li_id_rol;

    public cbx_rol(int li_id_rol, String ls_nombre_rol) {
        this.li_id_rol = li_id_rol;
        this.ls_nombre_rol = ls_nombre_rol;
    }

    public int getID() {
        return li_id_rol;
    }

    public String toString() {
        return ls_nombre_rol;
    }
}
