
package JAVA.VENTAS.LOGICA;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.VENTAS.GUI.dlg_ini_serie;
import java.beans.PropertyVetoException;

public class muestra_dlg_ventas {
    
    /*
        0 = pedido
     */
    public void muestra_dlg_pedido() throws PropertyVetoException {
        if (go_jif_pedido != null) {
            if (go_jif_pedido.isClosed()) {
                gi_parametros_2[0] = 0;
                go_dlg_ini_serie = new dlg_ini_serie(null, true);
                go_dlg_ini_serie.setVisible(true);                
            } else if (go_jif_pedido.isIcon()) {
                go_jif_pedido.setIcon(false);
            } else if (!go_jif_pedido.isShowing()) {
                gi_parametros_2[0] = 0;
                go_dlg_ini_serie = new dlg_ini_serie(null, true);
                go_dlg_ini_serie.setVisible(true);                
            }
        } else {
            gi_parametros_2[0] = 0;
            go_dlg_ini_serie = new dlg_ini_serie(null, true);
            go_dlg_ini_serie.setVisible(true);            
        }
    }
    
    public void muestra_dlg_factura() throws PropertyVetoException {
        if (go_jif_factura != null) {
            if (go_jif_factura.isClosed()) {
                gi_parametros_2[0] = 1;
                go_dlg_ini_serie = new dlg_ini_serie(null, true);
                go_dlg_ini_serie.setVisible(true);                
            } else if (go_jif_factura.isIcon()) {
                go_jif_factura.setIcon(false);
            } else if (!go_jif_factura.isShowing()) {
                gi_parametros_2[0] = 1;
                go_dlg_ini_serie = new dlg_ini_serie(null, true);
                go_dlg_ini_serie.setVisible(true);                
            }
        } else {
            gi_parametros_2[0] = 1;
            go_dlg_ini_serie = new dlg_ini_serie(null, true);
            go_dlg_ini_serie.setVisible(true);            
        }
    }
    
}
