
package JAVA.CTACOB.LOGICA;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.CTACOB.GUI.dlg_rpt_saldo_cta_corriente;

public class muestra_dlg_ctacob {
    public void muestra_dlg_rpt_saldo_cta_corriente() {
        go_dlg_rpt_saldo_cta_corriente = new dlg_rpt_saldo_cta_corriente(null, true);
        go_dlg_rpt_saldo_cta_corriente.setVisible(true);
    }
}
