package JAVA.VENTAS.LOGICA;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.VENTAS.GUI.dlg_control_pedido;
import JAVA.VENTAS.GUI.dlg_despacho_pedido;
import JAVA.VENTAS.GUI.dlg_ini_serie;
import JAVA.VENTAS.GUI.dlg_resumen_documento;
import JAVA.VENTAS.GUI.dlg_rpt_registro_ventas;
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

    public void muestra_dlg_control_pedido() {
        go_dlg_control_pedido = new dlg_control_pedido(null, true);
        go_dlg_control_pedido.setVisible(true);
    }

    public void muestra_dlg_despacho_pedido() {
        go_dlg_despacho_pedido = new dlg_despacho_pedido(null, true);
        go_dlg_despacho_pedido.setVisible(true);
    }

    public void muestra_dlg_rpt_registro_ventas(int op) {
        gi_parametros_2[0] = op;
        go_dlg_rpt_registro_ventas = new dlg_rpt_registro_ventas(null, true);
        go_dlg_rpt_registro_ventas.setVisible(true);
    }

    public void muestra_dlg_nota_credito(String tipo_documento) throws PropertyVetoException {
        if (go_jif_nota_credito != null) {
            if (go_jif_nota_credito.isClosed()) {
                gi_parametros_2[0] = 5;
                gs_parametros[0] = tipo_documento;
                go_dlg_ini_serie = new dlg_ini_serie(null, true);
                go_dlg_ini_serie.setVisible(true);
            } else if (go_jif_nota_credito.isIcon()) {
                go_jif_nota_credito.setIcon(false);
            } else if (!go_jif_nota_credito.isShowing()) {
                gi_parametros_2[0] = 5;
                gs_parametros[0] = tipo_documento;
                go_dlg_ini_serie = new dlg_ini_serie(null, true);
                go_dlg_ini_serie.setVisible(true);
            }
        } else {
            gi_parametros_2[0] = 5;
            gs_parametros[0] = tipo_documento;
            go_dlg_ini_serie = new dlg_ini_serie(null, true);
            go_dlg_ini_serie.setVisible(true);
        }
    }

    public void muestra_dlg_resumen_documento() {
        go_dlg_resumen_documento = new dlg_resumen_documento(null, true);
        go_dlg_resumen_documento.setVisible(true);
    }

}
