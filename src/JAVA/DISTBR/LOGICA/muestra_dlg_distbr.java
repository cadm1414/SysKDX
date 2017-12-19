package JAVA.DISTBR.LOGICA;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.VENTAS.GUI.dlg_ini_sucursal;
import java.beans.PropertyVetoException;

public class muestra_dlg_distbr {    
    
    public void muestra_dlg_ini_sucursal(String tipo_documento) throws PropertyVetoException {
        if (go_jif_programacion != null) {
            if (go_jif_programacion.isClosed()) {
                gi_parametros_2[0] = 1;
                gs_parametros[0] = tipo_documento;
                go_dlg_ini_sucursal = new dlg_ini_sucursal(null, true);
                go_dlg_ini_sucursal.setVisible(true);
            } else if (go_jif_programacion.isIcon()) {
                go_jif_programacion.setIcon(false);
            } else if (!go_jif_programacion.isShowing()) {
                gi_parametros_2[0] = 1;
                gs_parametros[0] = tipo_documento;
                go_dlg_ini_sucursal = new dlg_ini_sucursal(null, true);
                go_dlg_ini_sucursal.setVisible(true);
            }
        } else {
            gi_parametros_2[0] = 1;
            gs_parametros[0] = tipo_documento;
            go_dlg_ini_sucursal = new dlg_ini_sucursal(null, true);
            go_dlg_ini_sucursal.setVisible(true);
        }
    }
}
