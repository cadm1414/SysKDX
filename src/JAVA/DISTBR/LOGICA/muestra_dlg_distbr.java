package JAVA.DISTBR.LOGICA;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.DISTBR.GUI.dlg_resumen_liquidacion;
import JAVA.VENTAS.GUI.dlg_ini_sucursal;
import java.beans.PropertyVetoException;

public class muestra_dlg_distbr {

    public void muestra_dlg_programacion(String tipo_documento, int op) throws PropertyVetoException {
        if (go_jif_programacion != null) {
            if (go_jif_programacion.isClosed()) {
                gi_parametros_2[0] = op;
                gs_parametros[0] = tipo_documento;
                go_dlg_ini_sucursal = new dlg_ini_sucursal(null, true);
                go_dlg_ini_sucursal.setVisible(true);
            } else if (go_jif_programacion.isIcon()) {
                go_jif_programacion.setIcon(false);
            } else if (!go_jif_programacion.isShowing()) {
                gi_parametros_2[0] = op;
                gs_parametros[0] = tipo_documento;
                go_dlg_ini_sucursal = new dlg_ini_sucursal(null, true);
                go_dlg_ini_sucursal.setVisible(true);
            }
        } else {
            gi_parametros_2[0] = op;
            gs_parametros[0] = tipo_documento;
            go_dlg_ini_sucursal = new dlg_ini_sucursal(null, true);
            go_dlg_ini_sucursal.setVisible(true);
        }
    }

    public void muestra_dlg_liquidacion(String tipo_documento, int op) throws PropertyVetoException {
        if (go_jif_liquidacion != null) {
            if (go_jif_liquidacion.isClosed()) {
                gi_parametros_2[0] = op;
                gs_parametros[0] = tipo_documento;
                go_dlg_ini_sucursal = new dlg_ini_sucursal(null, true);
                go_dlg_ini_sucursal.setVisible(true);
            } else if (go_jif_liquidacion.isIcon()) {
                go_jif_liquidacion.setIcon(false);
            } else if (!go_jif_liquidacion.isShowing()) {
                gi_parametros_2[0] = op;
                gs_parametros[0] = tipo_documento;
                go_dlg_ini_sucursal = new dlg_ini_sucursal(null, true);
                go_dlg_ini_sucursal.setVisible(true);
            }
        } else {
            gi_parametros_2[0] = op;
            gs_parametros[0] = tipo_documento;
            go_dlg_ini_sucursal = new dlg_ini_sucursal(null, true);
            go_dlg_ini_sucursal.setVisible(true);
        }
    }

    public void muestra_dlg_resumen_liquidacion() {
        go_dlg_resumen_liquidacion = new dlg_resumen_liquidacion(null, true);
        go_dlg_resumen_liquidacion.setVisible(true);        
    }
}
