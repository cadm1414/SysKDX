package JAVA.CTACOB.LOGICA;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.CTACOB.GUI.dlg_rpt_saldo_cta_corriente;
import JAVA.CTACOB.GUI.dlg_rpt_tarjeta_cuenta_corriente;
import JAVA.VENTAS.GUI.dlg_ini_serie;
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

    public void muestra_dlg_rpt_tarjeta_cuenta_corriente() {
        go_dlg_rpt_tarjeta_cuenta_corriente = new dlg_rpt_tarjeta_cuenta_corriente(null, true);
        go_dlg_rpt_tarjeta_cuenta_corriente.setVisible(true);
    }
}
