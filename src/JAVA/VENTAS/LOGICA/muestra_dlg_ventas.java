
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
    
    public void muestra_dlg_factura(String tipo_documento) throws PropertyVetoException {
        if (go_jif_factura != null) {
            if (go_jif_factura.isClosed()) {
                gi_parametros_2[0] = 1;
                gs_parametros[0] = tipo_documento;
                go_dlg_ini_serie = new dlg_ini_serie(null, true);
                go_dlg_ini_serie.setVisible(true);                
            } else if (go_jif_factura.isIcon()) {
                go_jif_factura.setIcon(false);
            } else if (!go_jif_factura.isShowing()) {
                gi_parametros_2[0] = 1;
                gs_parametros[0] = tipo_documento;
                go_dlg_ini_serie = new dlg_ini_serie(null, true);
                go_dlg_ini_serie.setVisible(true);                
            }
        } else {
            gi_parametros_2[0] = 1;
            gs_parametros[0] = tipo_documento;
            go_dlg_ini_serie = new dlg_ini_serie(null, true);
            go_dlg_ini_serie.setVisible(true);            
        }
    }
    
    public void muestra_dlg_boleta(String tipo_documento) throws PropertyVetoException {
        if (go_jif_boleta != null) {
            if (go_jif_boleta.isClosed()) {
                gi_parametros_2[0] = 2;
                gs_parametros[0] = tipo_documento;
                go_dlg_ini_serie = new dlg_ini_serie(null, true);
                go_dlg_ini_serie.setVisible(true);                
            } else if (go_jif_boleta.isIcon()) {
                go_jif_boleta.setIcon(false);
            } else if (!go_jif_boleta.isShowing()) {
                gi_parametros_2[0] = 2;
                gs_parametros[0] = tipo_documento;
                go_dlg_ini_serie = new dlg_ini_serie(null, true);
                go_dlg_ini_serie.setVisible(true);                
            }
        } else {
            gi_parametros_2[0] = 2;
            gs_parametros[0] = tipo_documento;
            go_dlg_ini_serie = new dlg_ini_serie(null, true);
            go_dlg_ini_serie.setVisible(true);            
        }
    }
    
    public void muestra_dlg_guia_remision(String tipo_documento) throws PropertyVetoException {
        if (go_jif_guia_remision != null) {
            if (go_jif_guia_remision.isClosed()) {
                gi_parametros_2[0] = 3;
                gs_parametros[0] = tipo_documento;
                go_dlg_ini_serie = new dlg_ini_serie(null, true);
                go_dlg_ini_serie.setVisible(true);                
            } else if (go_jif_guia_remision.isIcon()) {
                go_jif_guia_remision.setIcon(false);
            } else if (!go_jif_guia_remision.isShowing()) {
                gi_parametros_2[0] = 3;
                gs_parametros[0] = tipo_documento;
                go_dlg_ini_serie = new dlg_ini_serie(null, true);
                go_dlg_ini_serie.setVisible(true);                
            }
        } else {
            gi_parametros_2[0] = 3;
            gs_parametros[0] = tipo_documento;
            go_dlg_ini_serie = new dlg_ini_serie(null, true);
            go_dlg_ini_serie.setVisible(true);            
        }
    }
    
}
