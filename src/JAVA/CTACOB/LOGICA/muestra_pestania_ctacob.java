package JAVA.CTACOB.LOGICA;

import JAVA.ANCESTRO.LOGICA.jt_panel;
import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.CTACOB.REPORT.pnl_rpt_saldo_cta_corriente;
import java.awt.BorderLayout;
import net.sf.jasperreports.view.JRViewer;

public class muestra_pestania_ctacob {

    public void rpt_saldo_cta_corriente(JRViewer jr, String nombre) {
        go_frm_principal.TBP_contenedor.remove(go_pnl_rpt_saldo_cta_corriente);
        jt_panel lo_jt_panel = new jt_panel(go_frm_principal.TBP_contenedor, 0);
        go_pnl_rpt_saldo_cta_corriente = new pnl_rpt_saldo_cta_corriente();
        go_pnl_rpt_saldo_cta_corriente.removeAll();
        go_pnl_rpt_saldo_cta_corriente.setLayout(new BorderLayout());
        go_pnl_rpt_saldo_cta_corriente.add(jr, BorderLayout.CENTER);
        go_pnl_rpt_saldo_cta_corriente.setVisible(true);
        go_pnl_rpt_saldo_cta_corriente.repaint();
        go_pnl_rpt_saldo_cta_corriente.revalidate();
        go_frm_principal.TBP_contenedor.addTab(nombre, go_pnl_rpt_saldo_cta_corriente);
        go_frm_principal.TBP_contenedor.setSelectedIndex(go_frm_principal.TBP_contenedor.getTabCount() - 1);
        go_frm_principal.TBP_contenedor.setTabComponentAt(go_frm_principal.TBP_contenedor.getTabCount() - 1, lo_jt_panel);
    }
}
