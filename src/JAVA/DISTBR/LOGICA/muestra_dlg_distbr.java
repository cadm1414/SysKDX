package JAVA.DISTBR.LOGICA;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.DISTBR.GUI.dlg_ini_serie_sector;
import java.beans.PropertyVetoException;

public class muestra_dlg_distbr {

    public void muestra_dlg_pedido_reparto() throws PropertyVetoException {
        if (go_jif_pedido != null) {
            if (go_jif_pedido.isClosed()) {
                gi_parametros_2[0] = 0;
                go_dlg_ini_serie_sector = new dlg_ini_serie_sector(null, true);
                go_dlg_ini_serie_sector.setVisible(true);
            } else if (go_jif_pedido.isIcon()) {
                go_jif_pedido.setIcon(false);
            } else if (!go_jif_pedido.isShowing()) {
                gi_parametros_2[0] = 0;
                go_dlg_ini_serie_sector = new dlg_ini_serie_sector(null, true);
                go_dlg_ini_serie_sector.setVisible(true);
            }
        } else {
            gi_parametros_2[0] = 0;
            go_dlg_ini_serie_sector = new dlg_ini_serie_sector(null, true);
            go_dlg_ini_serie_sector.setVisible(true);
        }
    }
}
