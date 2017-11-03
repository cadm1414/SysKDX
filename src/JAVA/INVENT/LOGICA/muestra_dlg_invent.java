package JAVA.INVENT.LOGICA;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.INVENT.GUI.dlg_ini_almacen;
import JAVA.INVENT.GUI.dlg_rpt_kardex_mercaderia;
import JAVA.INVENT.GUI.dlg_rpt_producto_x_movimiento;
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
    
    public void muestra_dlg_guia_salida() throws PropertyVetoException {
        if (go_jif_guia_salida != null) {
            if (go_jif_guia_salida.isClosed()) {
                gi_parametros_2[0] = 2;
                go_dlg_ini_almacen = new dlg_ini_almacen(null, true);
                go_dlg_ini_almacen.setVisible(true);                
            } else if (go_jif_guia_salida.isIcon()) {
                go_jif_guia_salida.setIcon(false);
            } else if (!go_jif_guia_salida.isShowing()) {
                gi_parametros_2[0] = 2;
                go_dlg_ini_almacen = new dlg_ini_almacen(null, true);
                go_dlg_ini_almacen.setVisible(true);                
            }
        } else {
            gi_parametros_2[0] = 2;
            go_dlg_ini_almacen = new dlg_ini_almacen(null, true);
            go_dlg_ini_almacen.setVisible(true);
            
        }
    }

    public void muestra_dlg_rpt_stock() {
        go_dlg_rpt_stock = new dlg_rpt_stock(null, true);
        go_dlg_rpt_stock.setVisible(true);
    }
    
    public void muestra_dlg_rpt_kardex_mercaderia() {
        go_dlg_rpt_kardex_mercaderia = new dlg_rpt_kardex_mercaderia(null, true);
        go_dlg_rpt_kardex_mercaderia.setVisible(true);
    }
    
    public void muestra_dlg_rpt_producto_x_movimiento() {
        go_dlg_rpt_producto_x_movimiento = new dlg_rpt_producto_x_movimiento(null, true);
        go_dlg_rpt_producto_x_movimiento.setVisible(true);
    }

}
