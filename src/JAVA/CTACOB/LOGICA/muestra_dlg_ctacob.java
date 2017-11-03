package JAVA.CTACOB.LOGICA;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.CTACOB.GUI.dlg_rpt_saldo_cta_corriente;
import JAVA.CTACOB.GUI.dlg_rpt_tarjeta_cuenta_corriente;
import JAVA.VENTAS.GUI.dlg_ini_serie;
import JAVA.VENTAS.GUI.dlg_rpt_registro_ventas;
import java.beans.PropertyVetoException;

public class muestra_dlg_ctacob {

    public void muestra_dlg_rpt_saldo_cta_corriente() {
        go_dlg_rpt_saldo_cta_corriente = new dlg_rpt_saldo_cta_corriente(null, true);
        go_dlg_rpt_saldo_cta_corriente.setVisible(true);
    }

    public void muestra_dlg_recibo_cobranza(String tipo_documento) throws PropertyVetoException {
        if (go_jif_recibo_cobranza != null) {
            if (go_jif_recibo_cobranza.isClosed()) {
                gi_parametros_2[0] = 4;
                gs_parametros[0] = tipo_documento;
                go_dlg_ini_serie = new dlg_ini_serie(null, true);
                go_dlg_ini_serie.setVisible(true);
            } else if (go_jif_recibo_cobranza.isIcon()) {
                go_jif_recibo_cobranza.setIcon(false);
            } else if (!go_jif_recibo_cobranza.isShowing()) {
                gi_parametros_2[0] = 4;
                gs_parametros[0] = tipo_documento;
                go_dlg_ini_serie = new dlg_ini_serie(null, true);
                go_dlg_ini_serie.setVisible(true);
            }
        } else {
            gi_parametros_2[0] = 4;
            gs_parametros[0] = tipo_documento;
            go_dlg_ini_serie = new dlg_ini_serie(null, true);
            go_dlg_ini_serie.setVisible(true);
        }
    }

    public void muestra_dlg_rpt_tarjeta_cuenta_corriente(int op) {
        gi_parametros_2[0] = op;
        go_dlg_rpt_tarjeta_cuenta_corriente = new dlg_rpt_tarjeta_cuenta_corriente(null, true);
        go_dlg_rpt_tarjeta_cuenta_corriente.setVisible(true);
    }

    public void muestra_dlg_rpt_listado_cobranzas(int op) {
        gi_parametros_2[0] = op;
        go_dlg_rpt_registro_ventas = new dlg_rpt_registro_ventas(null, true);
        go_dlg_rpt_registro_ventas.setVisible(true);
    }
}
