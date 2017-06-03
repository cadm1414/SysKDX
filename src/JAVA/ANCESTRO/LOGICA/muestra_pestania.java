package JAVA.ANCESTRO.LOGICA;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.CONFIG.REPORT.pnl_rpt_lista_sucursal;
import JAVA.CONFIG.REPORT.pnl_rpt_lista_usuario;
import java.awt.BorderLayout;
import net.sf.jasperreports.view.JRViewer;

public class muestra_pestania {

    public void rpt_lista_usuario(JRViewer jr, String nombre) {
        if (go_pnl_rpt_lista_usuario == null) {
            genera_lista_usuario(jr, nombre);
        } else if (!go_pnl_rpt_lista_usuario.isShowing()) {
            go_frm_principal.TBP_contenedor.remove(go_pnl_rpt_lista_usuario);
            genera_lista_usuario(jr, nombre);
        }
    }

    public void genera_lista_usuario(JRViewer jr, String nombre) {
        jt_panel lo_jt_panel = new jt_panel(go_frm_principal.TBP_contenedor, 0);
        go_pnl_rpt_lista_usuario = new pnl_rpt_lista_usuario();
        go_pnl_rpt_lista_usuario.removeAll();
        go_pnl_rpt_lista_usuario.setLayout(new BorderLayout());
        go_pnl_rpt_lista_usuario.add(jr, BorderLayout.CENTER);
        go_pnl_rpt_lista_usuario.setVisible(true);
        go_pnl_rpt_lista_usuario.repaint();
        go_pnl_rpt_lista_usuario.revalidate();
        go_frm_principal.TBP_contenedor.addTab(nombre, go_pnl_rpt_lista_usuario);
        go_frm_principal.TBP_contenedor.setSelectedIndex(go_frm_principal.TBP_contenedor.getTabCount() - 1);
        go_frm_principal.TBP_contenedor.setTabComponentAt(go_frm_principal.TBP_contenedor.getTabCount() - 1, lo_jt_panel);
    }

    public void rpt_lista_sucursal(JRViewer jr, String nombre) {

        if (go_pnl_rpt_lista_sucursal == null) {
            genera_lista_sucursal(jr, nombre);

        } else if (!go_pnl_rpt_lista_sucursal.isShowing()) {
            go_frm_principal.TBP_contenedor.remove(go_pnl_rpt_lista_sucursal);
            genera_lista_sucursal(jr, nombre);
        }
    }

    public void genera_lista_sucursal(JRViewer jr, String nombre) {
        jt_panel lo_jt_panel = new jt_panel(go_frm_principal.TBP_contenedor, 0);
        go_pnl_rpt_lista_sucursal = new pnl_rpt_lista_sucursal();
        go_pnl_rpt_lista_sucursal.removeAll();
        go_pnl_rpt_lista_sucursal.setLayout(new BorderLayout());
        go_pnl_rpt_lista_sucursal.add(jr, BorderLayout.CENTER);
        go_pnl_rpt_lista_sucursal.setVisible(true);
        go_pnl_rpt_lista_sucursal.repaint();
        go_pnl_rpt_lista_sucursal.revalidate();
        go_frm_principal.TBP_contenedor.addTab(nombre, go_pnl_rpt_lista_sucursal);
        go_frm_principal.TBP_contenedor.setSelectedIndex(go_frm_principal.TBP_contenedor.getTabCount() - 1);
        go_frm_principal.TBP_contenedor.setTabComponentAt(go_frm_principal.TBP_contenedor.getTabCount() - 1, lo_jt_panel);

    }

}
