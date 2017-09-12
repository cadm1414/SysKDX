package JAVA.INVENT.LOGICA;

import JAVA.ANCESTRO.LOGICA.jt_panel;
import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.INVENT.REPORT.pnl_rpt_lista_familia;
import JAVA.INVENT.REPORT.pnl_rpt_lista_marca;
import JAVA.INVENT.REPORT.pnl_rpt_lista_producto;
import JAVA.INVENT.REPORT.pnl_rpt_lista_subfamilia;
import JAVA.INVENT.REPORT.pnl_rpt_stock_futuro;
import JAVA.INVENT.REPORT.pnl_rpt_stock_normal;
import JAVA.INVENT.REPORT.pnl_rpt_stock_valorizado;
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
    
    public void rpt_lista_producto(JRViewer jr, String nombre) {
        if (go_pnl_rpt_lista_producto == null) {
            genera_lista_producto(jr, nombre);
        } else if (!go_pnl_rpt_lista_producto.isShowing()) {
            go_frm_principal.TBP_contenedor.remove(go_pnl_rpt_lista_producto);
            genera_lista_producto(jr, nombre);
        }
    }

    public void genera_lista_producto(JRViewer jr, String nombre) {
        jt_panel lo_jt_panel = new jt_panel(go_frm_principal.TBP_contenedor, 0);
        go_pnl_rpt_lista_producto = new pnl_rpt_lista_producto();
        go_pnl_rpt_lista_producto.removeAll();
        go_pnl_rpt_lista_producto.setLayout(new BorderLayout());
        go_pnl_rpt_lista_producto.add(jr, BorderLayout.CENTER);
        go_pnl_rpt_lista_producto.setVisible(true);
        go_pnl_rpt_lista_producto.repaint();
        go_pnl_rpt_lista_producto.revalidate();
        go_frm_principal.TBP_contenedor.addTab(nombre, go_pnl_rpt_lista_producto);
        go_frm_principal.TBP_contenedor.setSelectedIndex(go_frm_principal.TBP_contenedor.getTabCount() - 1);
        go_frm_principal.TBP_contenedor.setTabComponentAt(go_frm_principal.TBP_contenedor.getTabCount() - 1, lo_jt_panel);
    }
    
    public void rpt_lista_familia(JRViewer jr, String nombre) {
        if (go_pnl_rpt_lista_familia== null) {
            genera_lista_familia(jr, nombre);
        } else if (!go_pnl_rpt_lista_familia.isShowing()) {
            go_frm_principal.TBP_contenedor.remove(go_pnl_rpt_lista_familia);
            genera_lista_familia(jr, nombre);
        }
    }

    public void genera_lista_familia(JRViewer jr, String nombre) {
        jt_panel lo_jt_panel = new jt_panel(go_frm_principal.TBP_contenedor, 0);
        go_pnl_rpt_lista_familia = new pnl_rpt_lista_familia();
        go_pnl_rpt_lista_familia.removeAll();
        go_pnl_rpt_lista_familia.setLayout(new BorderLayout());
        go_pnl_rpt_lista_familia.add(jr, BorderLayout.CENTER);
        go_pnl_rpt_lista_familia.setVisible(true);
        go_pnl_rpt_lista_familia.repaint();
        go_pnl_rpt_lista_familia.revalidate();
        go_frm_principal.TBP_contenedor.addTab(nombre, go_pnl_rpt_lista_familia);
        go_frm_principal.TBP_contenedor.setSelectedIndex(go_frm_principal.TBP_contenedor.getTabCount() - 1);
        go_frm_principal.TBP_contenedor.setTabComponentAt(go_frm_principal.TBP_contenedor.getTabCount() - 1, lo_jt_panel);
    }
    
    public void rpt_lista_subfamilia(JRViewer jr, String nombre) {
        if (go_pnl_rpt_lista_subfamilia== null) {
            genera_lista_subfamilia(jr, nombre);
        } else if (!go_pnl_rpt_lista_subfamilia.isShowing()) {
            go_frm_principal.TBP_contenedor.remove(go_pnl_rpt_lista_subfamilia);
            genera_lista_subfamilia(jr, nombre);
        }
    }

    public void genera_lista_subfamilia(JRViewer jr, String nombre) {
        jt_panel lo_jt_panel = new jt_panel(go_frm_principal.TBP_contenedor, 0);
        go_pnl_rpt_lista_subfamilia = new pnl_rpt_lista_subfamilia();
        go_pnl_rpt_lista_subfamilia.removeAll();
        go_pnl_rpt_lista_subfamilia.setLayout(new BorderLayout());
        go_pnl_rpt_lista_subfamilia.add(jr, BorderLayout.CENTER);
        go_pnl_rpt_lista_subfamilia.setVisible(true);
        go_pnl_rpt_lista_subfamilia.repaint();
        go_pnl_rpt_lista_subfamilia.revalidate();
        go_frm_principal.TBP_contenedor.addTab(nombre, go_pnl_rpt_lista_subfamilia);
        go_frm_principal.TBP_contenedor.setSelectedIndex(go_frm_principal.TBP_contenedor.getTabCount() - 1);
        go_frm_principal.TBP_contenedor.setTabComponentAt(go_frm_principal.TBP_contenedor.getTabCount() - 1, lo_jt_panel);
    }
    
    public void rpt_stock_normal(JRViewer jr, String nombre) {
        go_frm_principal.TBP_contenedor.remove(go_pnl_rpt_stock_normal);        
        jt_panel lo_jt_panel = new jt_panel(go_frm_principal.TBP_contenedor, 0);
        go_pnl_rpt_stock_normal = new pnl_rpt_stock_normal();
        go_pnl_rpt_stock_normal.removeAll();
        go_pnl_rpt_stock_normal.setLayout(new BorderLayout());
        go_pnl_rpt_stock_normal.add(jr, BorderLayout.CENTER);
        go_pnl_rpt_stock_normal.setVisible(true);
        go_pnl_rpt_stock_normal.repaint();
        go_pnl_rpt_stock_normal.revalidate();
        go_frm_principal.TBP_contenedor.addTab(nombre, go_pnl_rpt_stock_normal);
        go_frm_principal.TBP_contenedor.setSelectedIndex(go_frm_principal.TBP_contenedor.getTabCount() - 1);
        go_frm_principal.TBP_contenedor.setTabComponentAt(go_frm_principal.TBP_contenedor.getTabCount() - 1, lo_jt_panel);
    }
    
    public void rpt_stock_valorizado(JRViewer jr, String nombre) {
        go_frm_principal.TBP_contenedor.remove(go_pnl_rpt_stock_valorizado);        
        jt_panel lo_jt_panel = new jt_panel(go_frm_principal.TBP_contenedor, 0);
        go_pnl_rpt_stock_valorizado = new pnl_rpt_stock_valorizado();
        go_pnl_rpt_stock_valorizado.removeAll();
        go_pnl_rpt_stock_valorizado.setLayout(new BorderLayout());
        go_pnl_rpt_stock_valorizado.add(jr, BorderLayout.CENTER);
        go_pnl_rpt_stock_valorizado.setVisible(true);
        go_pnl_rpt_stock_valorizado.repaint();
        go_pnl_rpt_stock_valorizado.revalidate();
        go_frm_principal.TBP_contenedor.addTab(nombre, go_pnl_rpt_stock_valorizado);
        go_frm_principal.TBP_contenedor.setSelectedIndex(go_frm_principal.TBP_contenedor.getTabCount() - 1);
        go_frm_principal.TBP_contenedor.setTabComponentAt(go_frm_principal.TBP_contenedor.getTabCount() - 1, lo_jt_panel);
    }
    
    public void rpt_stock_futuro(JRViewer jr, String nombre) {
        go_frm_principal.TBP_contenedor.remove(go_pnl_rpt_stock_futuro);        
        jt_panel lo_jt_panel = new jt_panel(go_frm_principal.TBP_contenedor, 0);
        go_pnl_rpt_stock_futuro = new pnl_rpt_stock_futuro();
        go_pnl_rpt_stock_futuro.removeAll();
        go_pnl_rpt_stock_futuro.setLayout(new BorderLayout());
        go_pnl_rpt_stock_futuro.add(jr, BorderLayout.CENTER);
        go_pnl_rpt_stock_futuro.setVisible(true);
        go_pnl_rpt_stock_futuro.repaint();
        go_pnl_rpt_stock_futuro.revalidate();
        go_frm_principal.TBP_contenedor.addTab(nombre, go_pnl_rpt_stock_futuro);
        go_frm_principal.TBP_contenedor.setSelectedIndex(go_frm_principal.TBP_contenedor.getTabCount() - 1);
        go_frm_principal.TBP_contenedor.setTabComponentAt(go_frm_principal.TBP_contenedor.getTabCount() - 1, lo_jt_panel);
    }

}
