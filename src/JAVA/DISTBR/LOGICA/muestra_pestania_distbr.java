package JAVA.DISTBR.LOGICA;

import JAVA.ANCESTRO.LOGICA.jt_panel;
import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.DISTBR.REPORT.pnl_rpt_despacho_preliminar;
import JAVA.DISTBR.REPORT.pnl_rpt_resumen_liquidacion;
import java.awt.BorderLayout;
import net.sf.jasperreports.view.JRViewer;

public class muestra_pestania_distbr {

    public void rpt_resumen_liquidacion(JRViewer jr, String nombre) {
        go_frm_principal.TBP_contenedor.remove(go_pnl_rpt_resumen_liquidacion);
        jt_panel lo_jt_panel = new jt_panel(go_frm_principal.TBP_contenedor, 0);
        go_pnl_rpt_resumen_liquidacion = new pnl_rpt_resumen_liquidacion();
        go_pnl_rpt_resumen_liquidacion.removeAll();
        go_pnl_rpt_resumen_liquidacion.setLayout(new BorderLayout());
        go_pnl_rpt_resumen_liquidacion.add(jr, BorderLayout.CENTER);
        go_pnl_rpt_resumen_liquidacion.setVisible(true);
        go_pnl_rpt_resumen_liquidacion.repaint();
        go_pnl_rpt_resumen_liquidacion.revalidate();
        go_frm_principal.TBP_contenedor.addTab(nombre, go_pnl_rpt_resumen_liquidacion);
        go_frm_principal.TBP_contenedor.setSelectedIndex(go_frm_principal.TBP_contenedor.getTabCount() - 1);
        go_frm_principal.TBP_contenedor.setTabComponentAt(go_frm_principal.TBP_contenedor.getTabCount() - 1, lo_jt_panel);
    }

    public void rpt_despacho_preliminar(JRViewer jr, String nombre) {
        go_frm_principal.TBP_contenedor.remove(go_pnl_rpt_despacho_preliminar);
        jt_panel lo_jt_panel = new jt_panel(go_frm_principal.TBP_contenedor, 0);
        go_pnl_rpt_despacho_preliminar = new pnl_rpt_despacho_preliminar();
        go_pnl_rpt_despacho_preliminar.removeAll();
        go_pnl_rpt_despacho_preliminar.setLayout(new BorderLayout());
        go_pnl_rpt_despacho_preliminar.add(jr, BorderLayout.CENTER);
        go_pnl_rpt_despacho_preliminar.setVisible(true);
        go_pnl_rpt_despacho_preliminar.repaint();
        go_pnl_rpt_despacho_preliminar.revalidate();
        go_frm_principal.TBP_contenedor.addTab(nombre, go_pnl_rpt_despacho_preliminar);
        go_frm_principal.TBP_contenedor.setSelectedIndex(go_frm_principal.TBP_contenedor.getTabCount() - 1);
        go_frm_principal.TBP_contenedor.setTabComponentAt(go_frm_principal.TBP_contenedor.getTabCount() - 1, lo_jt_panel);
    }
}
