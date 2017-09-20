package JAVA.VENTAS.LOGICA;

import JAVA.ANCESTRO.LOGICA.jt_panel;
import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.VENTAS.REPORT.pnl_rpt_control_pedido;
import JAVA.VENTAS.REPORT.pnl_rpt_control_pedido_pendiente;
import JAVA.VENTAS.REPORT.pnl_rpt_diferencia_pedido;
import java.awt.BorderLayout;
import net.sf.jasperreports.view.JRViewer;

public class muestra_pestania_ventas {

    public void rpt_control_pedido(JRViewer jr, String nombre) {
        go_frm_principal.TBP_contenedor.remove(go_pnl_rpt_control_pedido);
        jt_panel lo_jt_panel = new jt_panel(go_frm_principal.TBP_contenedor, 0);
        go_pnl_rpt_control_pedido = new pnl_rpt_control_pedido();
        go_pnl_rpt_control_pedido.removeAll();
        go_pnl_rpt_control_pedido.setLayout(new BorderLayout());
        go_pnl_rpt_control_pedido.add(jr, BorderLayout.CENTER);
        go_pnl_rpt_control_pedido.setVisible(true);
        go_pnl_rpt_control_pedido.repaint();
        go_pnl_rpt_control_pedido.revalidate();
        go_frm_principal.TBP_contenedor.addTab(nombre, go_pnl_rpt_control_pedido);
        go_frm_principal.TBP_contenedor.setSelectedIndex(go_frm_principal.TBP_contenedor.getTabCount() - 1);
        go_frm_principal.TBP_contenedor.setTabComponentAt(go_frm_principal.TBP_contenedor.getTabCount() - 1, lo_jt_panel);
    }
    
    public void rpt_control_pedido_pendiente(JRViewer jr, String nombre) {
        go_frm_principal.TBP_contenedor.remove(go_pnl_rpt_control_pedido_pendiente);
        jt_panel lo_jt_panel = new jt_panel(go_frm_principal.TBP_contenedor, 0);
        go_pnl_rpt_control_pedido_pendiente = new pnl_rpt_control_pedido_pendiente();
        go_pnl_rpt_control_pedido_pendiente.removeAll();
        go_pnl_rpt_control_pedido_pendiente.setLayout(new BorderLayout());
        go_pnl_rpt_control_pedido_pendiente.add(jr, BorderLayout.CENTER);
        go_pnl_rpt_control_pedido_pendiente.setVisible(true);
        go_pnl_rpt_control_pedido_pendiente.repaint();
        go_pnl_rpt_control_pedido_pendiente.revalidate();
        go_frm_principal.TBP_contenedor.addTab(nombre, go_pnl_rpt_control_pedido_pendiente);
        go_frm_principal.TBP_contenedor.setSelectedIndex(go_frm_principal.TBP_contenedor.getTabCount() - 1);
        go_frm_principal.TBP_contenedor.setTabComponentAt(go_frm_principal.TBP_contenedor.getTabCount() - 1, lo_jt_panel);
    }
    
    public void rpt_diferencia_pedido(JRViewer jr, String nombre) {
        go_frm_principal.TBP_contenedor.remove(go_pnl_rpt_diferencia_pedido);
        jt_panel lo_jt_panel = new jt_panel(go_frm_principal.TBP_contenedor, 0);
        go_pnl_rpt_diferencia_pedido = new pnl_rpt_diferencia_pedido();
        go_pnl_rpt_diferencia_pedido.removeAll();
        go_pnl_rpt_diferencia_pedido.setLayout(new BorderLayout());
        go_pnl_rpt_diferencia_pedido.add(jr, BorderLayout.CENTER);
        go_pnl_rpt_diferencia_pedido.setVisible(true);
        go_pnl_rpt_diferencia_pedido.repaint();
        go_pnl_rpt_diferencia_pedido.revalidate();
        go_frm_principal.TBP_contenedor.addTab(nombre, go_pnl_rpt_diferencia_pedido);
        go_frm_principal.TBP_contenedor.setSelectedIndex(go_frm_principal.TBP_contenedor.getTabCount() - 1);
        go_frm_principal.TBP_contenedor.setTabComponentAt(go_frm_principal.TBP_contenedor.getTabCount() - 1, lo_jt_panel);
    }
}
