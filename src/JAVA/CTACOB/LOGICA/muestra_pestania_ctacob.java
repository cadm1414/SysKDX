package JAVA.CTACOB.LOGICA;

import JAVA.ANCESTRO.LOGICA.jt_panel;
import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.CTACOB.REPORT.pnl_rpt_estado_cuenta;
import JAVA.CTACOB.REPORT.pnl_rpt_listado_cobranzas;
import JAVA.CTACOB.REPORT.pnl_rpt_saldo_cta_corriente;
import JAVA.CTACOB.REPORT.pnl_rpt_tarjeta_cuenta_corriente;
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
    
    public void rpt_tarjeta_cuenta_corriente(JRViewer jr, String nombre) {
        go_frm_principal.TBP_contenedor.remove(go_pnl_rpt_tarjeta_cuenta_corriente);
        jt_panel lo_jt_panel = new jt_panel(go_frm_principal.TBP_contenedor, 0);
        go_pnl_rpt_tarjeta_cuenta_corriente = new pnl_rpt_tarjeta_cuenta_corriente();
        go_pnl_rpt_tarjeta_cuenta_corriente.removeAll();
        go_pnl_rpt_tarjeta_cuenta_corriente.setLayout(new BorderLayout());
        go_pnl_rpt_tarjeta_cuenta_corriente.add(jr, BorderLayout.CENTER);
        go_pnl_rpt_tarjeta_cuenta_corriente.setVisible(true);
        go_pnl_rpt_tarjeta_cuenta_corriente.repaint();
        go_pnl_rpt_tarjeta_cuenta_corriente.revalidate();
        go_frm_principal.TBP_contenedor.addTab(nombre, go_pnl_rpt_tarjeta_cuenta_corriente);
        go_frm_principal.TBP_contenedor.setSelectedIndex(go_frm_principal.TBP_contenedor.getTabCount() - 1);
        go_frm_principal.TBP_contenedor.setTabComponentAt(go_frm_principal.TBP_contenedor.getTabCount() - 1, lo_jt_panel);
    }
    
    public void rpt_estado_cuenta(JRViewer jr, String nombre) {
        go_frm_principal.TBP_contenedor.remove(go_pnl_rpt_estado_cuenta);
        jt_panel lo_jt_panel = new jt_panel(go_frm_principal.TBP_contenedor, 0);
        go_pnl_rpt_estado_cuenta = new pnl_rpt_estado_cuenta();
        go_pnl_rpt_estado_cuenta.removeAll();
        go_pnl_rpt_estado_cuenta.setLayout(new BorderLayout());
        go_pnl_rpt_estado_cuenta.add(jr, BorderLayout.CENTER);
        go_pnl_rpt_estado_cuenta.setVisible(true);
        go_pnl_rpt_estado_cuenta.repaint();
        go_pnl_rpt_estado_cuenta.revalidate();
        go_frm_principal.TBP_contenedor.addTab(nombre, go_pnl_rpt_estado_cuenta);
        go_frm_principal.TBP_contenedor.setSelectedIndex(go_frm_principal.TBP_contenedor.getTabCount() - 1);
        go_frm_principal.TBP_contenedor.setTabComponentAt(go_frm_principal.TBP_contenedor.getTabCount() - 1, lo_jt_panel);
    }
    
    public void rpt_listado_cobranzas(JRViewer jr, String nombre) {
        go_frm_principal.TBP_contenedor.remove(go_pnl_rpt_listado_cobranzas);
        jt_panel lo_jt_panel = new jt_panel(go_frm_principal.TBP_contenedor, 0);
        go_pnl_rpt_listado_cobranzas = new pnl_rpt_listado_cobranzas();
        go_pnl_rpt_listado_cobranzas.removeAll();
        go_pnl_rpt_listado_cobranzas.setLayout(new BorderLayout());
        go_pnl_rpt_listado_cobranzas.add(jr, BorderLayout.CENTER);
        go_pnl_rpt_listado_cobranzas.setVisible(true);
        go_pnl_rpt_listado_cobranzas.repaint();
        go_pnl_rpt_listado_cobranzas.revalidate();
        go_frm_principal.TBP_contenedor.addTab(nombre, go_pnl_rpt_listado_cobranzas);
        go_frm_principal.TBP_contenedor.setSelectedIndex(go_frm_principal.TBP_contenedor.getTabCount() - 1);
        go_frm_principal.TBP_contenedor.setTabComponentAt(go_frm_principal.TBP_contenedor.getTabCount() - 1, lo_jt_panel);
    }
}
