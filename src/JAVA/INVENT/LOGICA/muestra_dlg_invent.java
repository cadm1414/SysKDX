package JAVA.INVENT.LOGICA;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.INVENT.GUI.dlg_ini_almacen;
import JAVA.INVENT.GUI.dlg_rpt_stock;
import java.beans.PropertyVetoException;

public class muestra_dlg_invent {

    public void muestra_dlg_saldos_iniciales() throws PropertyVetoException {
        if (go_jif_saldos_iniciales != null) {
            if (go_jif_saldos_iniciales.isClosed()) {
                go_dlg_ini_almacen = new dlg_ini_almacen(null, true);
                go_dlg_ini_almacen.setVisible(true);
            } else if (go_jif_saldos_iniciales.isIcon()) {
                go_jif_saldos_iniciales.setIcon(false);
            } else if (!go_jif_saldos_iniciales.isShowing()) {
                go_dlg_ini_almacen = new dlg_ini_almacen(null, true);
                go_dlg_ini_almacen.setVisible(true);
            }
        } else {
            go_dlg_ini_almacen = new dlg_ini_almacen(null, true);
            go_dlg_ini_almacen.setVisible(true);
        }
    }

    public void muestra_dlg_rpt_stock() {
        if (go_pnl_rpt_lista_marca == null) {
            go_dlg_rpt_stock = new dlg_rpt_stock(null, true);
            go_dlg_rpt_stock.setVisible(true);
        } else if (!go_pnl_rpt_lista_marca.isShowing()) {
            go_dlg_rpt_stock = new dlg_rpt_stock(null, true);
            go_dlg_rpt_stock.setVisible(true);
        }
    }
}
