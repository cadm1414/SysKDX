package JAVA.CONFIG.LOGICA;

import JAVA.CONFIG.GUI.frm_datos_general;
import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.CONFIG.GUI.frm_datos_rol_menu;
import java.beans.PropertyVetoException;

public class opciones_menu {

    /*RETORNA TIPO DE FORMULARIO
        F = Jframe
        I = Jinternal
     */
    public String selecciona_formulario(int index, String dato) throws PropertyVetoException {
        String resp = "";
        String codigo_modulo = gs_codigo_modulo[index];

        switch (codigo_modulo) {
            case "ANCEST":
                break;
            case "CONFIG":
                if (dato.equalsIgnoreCase("EMPRESA")) {
                    go_frm_datos_general = new frm_datos_general();
                    go_frm_datos_general.setVisible(true);
                    resp = "F";
                }
                if (dato.equalsIgnoreCase("ROL")) {
                    go_frm_datos_rol_menu = new frm_datos_rol_menu();
                    go_frm_datos_rol_menu.setVisible(true);
                    resp = "F";
                }
                if (dato.equalsIgnoreCase("USUARIO")) {                    
                    go_muestra_jif.muestra_jif_usuario();
                    resp = "I";
                }
                if(dato.equalsIgnoreCase("SUCURSAL")){
                    go_muestra_jif.muestra_jif_sucursal();
                    resp = "I";
                }
                if(dato.equalsIgnoreCase("ALMACEN")){
                    go_muestra_jif.muestra_jif_almacen();
                    resp = "I";
                }
                if(dato.equalsIgnoreCase("PERMISOS")){
                    go_muestra_jif.muestra_jif_usuario_permisos();
                    resp = "I";
                }
                if(dato.equalsIgnoreCase("TIPO MOVIMIENTO")){
                    go_muestra_jif.muestra_jif_tipo_movimiento();
                    resp = "I";
                }
                break;
        }
        return resp;
    }
}
