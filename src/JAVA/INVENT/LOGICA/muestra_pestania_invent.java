package JAVA.INVENT.LOGICA;

import JAVA.ANCESTRO.LOGICA.jt_panel;
import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.INVENT.REPORT.pnl_rpt_lista_marca;
import java.awt.BorderLayout;
import net.sf.jasperreports.view.JRViewer;

public class muestra_pestania_invent {

    public void rpt_lista_marca(JRViewer jr, String nombre) {
        if (go_pnl_rpt_lista_marca == null) {
            genera_lista_marca(jr, nombre);
        } else if (!go_pnl_rpt_lista_marca.isShowing()) {
            go_frm_principal.TBP_contenedor.remove(go_pnl_rpt_lista_marca);
            genera_lista_marca(jr, nombre);
        }
    }

    public void genera_lista_marca(JRViewer jr, String nombre) {
        jt_panel lo_jt_panel = new jt_panel(go_frm_principal.TBP_contenedor, 0);
        go_pnl_rpt_lista_marca = new pnl_rpt_lista_marca();
        go_pnl_rpt_lista_marca.removeAll();
        go_pnl_rpt_lista_marca.setLayout(new BorderLayout());
        go_pnl_rpt_lista_marca.add(jr, BorderLayout.CENTER);
        go_pnl_rpt_lista_marca.setVisible(true);
        go_pnl_rpt_lista_marca.repaint();
        go_pnl_rpt_lista_marca.revalidate();
        go_frm_principal.TBP_contenedor.addTab(nombre, go_pnl_rpt_lista_marca);
        go_frm_principal.TBP_contenedor.setSelectedIndex(go_frm_principal.TBP_contenedor.getTabCount() - 1);
        go_frm_principal.TBP_contenedor.setTabComponentAt(go_frm_principal.TBP_contenedor.getTabCount() - 1, lo_jt_panel);
    }

}
