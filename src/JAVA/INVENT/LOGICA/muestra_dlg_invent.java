package JAVA.INVENT.LOGICA;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.INVENT.GUI.dlg_ini_almacen;
import JAVA.INVENT.GUI.dlg_rpt_stock;
import java.beans.PropertyVetoException;

public class muestra_dlg_invent {

    /*
        0 = SALDOS INICIALES
        1 = GUIA DE INGRESO
     */
    public void muestra_dlg_saldos_iniciales() throws PropertyVetoException {
        if (go_jif_saldos_iniciales != null) {
            if (go_jif_saldos_iniciales.isClosed()) {
                gi_parametros_2[0] = 0;
                go_dlg_ini_almacen = new dlg_ini_almacen(null, true);
                go_dlg_ini_almacen.setVisible(true);                
            } else if (go_jif_saldos_iniciales.isIcon()) {
                go_jif_saldos_iniciales.setIcon(false);
            } else if (!go_jif_saldos_iniciales.isShowing()) {
                gi_parametros_2[0] = 0;
                go_dlg_ini_almacen = new dlg_ini_almacen(null, true);
                go_dlg_ini_almacen.setVisible(true);                
            }
        } else {
            gi_parametros_2[0] = 0;
            go_dlg_ini_almacen = new dlg_ini_almacen(null, true);
            go_dlg_ini_almacen.setVisible(true);            
        }
    }

    public void muestra_dlg_guia_ingreso() throws PropertyVetoException {
        if (go_jif_guia_ingreso != null) {
            if (go_jif_guia_ingreso.isClosed()) {
                gi_parametros_2[0] = 1;
                go_dlg_ini_almacen = new dlg_ini_almacen(null, true);
                go_dlg_ini_almacen.setVisible(true);                
            } else if (go_jif_guia_ingreso.isIcon()) {
                go_jif_guia_ingreso.setIcon(false);
            } else if (!go_jif_guia_ingreso.isShowing()) {
                gi_parametros_2[0] = 1;
                go_dlg_ini_almacen = new dlg_ini_almacen(null, true);
                go_dlg_ini_almacen.setVisible(true);                
            }
        } else {
            gi_parametros_2[0] = 1;
            go_dlg_ini_almacen = new dlg_ini_almacen(null, true);
            go_dlg_ini_almacen.setVisible(true);
            
        }
    }

    public void muestra_dlg_rpt_stock() {
        go_dlg_rpt_stock = new dlg_rpt_stock(null, true);
        go_dlg_rpt_stock.setVisible(true);
    }

}
