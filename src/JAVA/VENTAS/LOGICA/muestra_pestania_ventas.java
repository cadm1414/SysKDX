package JAVA.VENTAS.LOGICA;

import JAVA.ANCESTRO.LOGICA.jt_panel;
import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.VENTAS.GUI.pnl_rpt_ventas_x_vendedor;
import JAVA.VENTAS.REPORT.pnl_rpt_control_pedido;
import JAVA.VENTAS.REPORT.pnl_rpt_control_pedido_pendiente;
import JAVA.VENTAS.REPORT.pnl_rpt_correlativo_doc;
import JAVA.VENTAS.REPORT.pnl_rpt_despacho_pedido;
import JAVA.VENTAS.REPORT.pnl_rpt_diferencia_pedido;
import JAVA.VENTAS.REPORT.pnl_rpt_diferencia_precios;
import JAVA.VENTAS.REPORT.pnl_rpt_registro_ventas;
import JAVA.VENTAS.REPORT.pnl_rpt_resumen_documento;
import JAVA.VENTAS.REPORT.pnl_rpt_ventas_formas_pago;
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

    public void rpt_despacho_pedido(JRViewer jr, String nombre) {
        go_frm_principal.TBP_contenedor.remove(go_pnl_rpt_despacho_pedido);
        jt_panel lo_jt_panel = new jt_panel(go_frm_principal.TBP_contenedor, 0);
        go_pnl_rpt_despacho_pedido = new pnl_rpt_despacho_pedido();
        go_pnl_rpt_despacho_pedido.removeAll();
        go_pnl_rpt_despacho_pedido.setLayout(new BorderLayout());
        go_pnl_rpt_despacho_pedido.add(jr, BorderLayout.CENTER);
        go_pnl_rpt_despacho_pedido.setVisible(true);
        go_pnl_rpt_despacho_pedido.repaint();
        go_pnl_rpt_despacho_pedido.revalidate();
        go_frm_principal.TBP_contenedor.addTab(nombre, go_pnl_rpt_despacho_pedido);
        go_frm_principal.TBP_contenedor.setSelectedIndex(go_frm_principal.TBP_contenedor.getTabCount() - 1);
        go_frm_principal.TBP_contenedor.setTabComponentAt(go_frm_principal.TBP_contenedor.getTabCount() - 1, lo_jt_panel);
    }

    public void rpt_registro_ventas(JRViewer jr, String nombre) {
        go_frm_principal.TBP_contenedor.remove(go_pnl_rpt_registro_ventas);
        jt_panel lo_jt_panel = new jt_panel(go_frm_principal.TBP_contenedor, 0);
        go_pnl_rpt_registro_ventas = new pnl_rpt_registro_ventas();
        go_pnl_rpt_registro_ventas.removeAll();
        go_pnl_rpt_registro_ventas.setLayout(new BorderLayout());
        go_pnl_rpt_registro_ventas.add(jr, BorderLayout.CENTER);
        go_pnl_rpt_registro_ventas.setVisible(true);
        go_pnl_rpt_registro_ventas.repaint();
        go_pnl_rpt_registro_ventas.revalidate();
        go_frm_principal.TBP_contenedor.addTab(nombre, go_pnl_rpt_registro_ventas);
        go_frm_principal.TBP_contenedor.setSelectedIndex(go_frm_principal.TBP_contenedor.getTabCount() - 1);
        go_frm_principal.TBP_contenedor.setTabComponentAt(go_frm_principal.TBP_contenedor.getTabCount() - 1, lo_jt_panel);
    }

    public void rpt_resumen_documento(JRViewer jr, String nombre) {
        go_frm_principal.TBP_contenedor.remove(go_pnl_rpt_resumen_documento);
        jt_panel lo_jt_panel = new jt_panel(go_frm_principal.TBP_contenedor, 0);
        go_pnl_rpt_resumen_documento = new pnl_rpt_resumen_documento();
        go_pnl_rpt_resumen_documento.removeAll();
        go_pnl_rpt_resumen_documento.setLayout(new BorderLayout());
        go_pnl_rpt_resumen_documento.add(jr, BorderLayout.CENTER);
        go_pnl_rpt_resumen_documento.setVisible(true);
        go_pnl_rpt_resumen_documento.repaint();
        go_pnl_rpt_resumen_documento.revalidate();
        go_frm_principal.TBP_contenedor.addTab(nombre, go_pnl_rpt_resumen_documento);
        go_frm_principal.TBP_contenedor.setSelectedIndex(go_frm_principal.TBP_contenedor.getTabCount() - 1);
        go_frm_principal.TBP_contenedor.setTabComponentAt(go_frm_principal.TBP_contenedor.getTabCount() - 1, lo_jt_panel);
    }

    public void rpt_correlativo_doc(JRViewer jr, String nombre) {
        go_frm_principal.TBP_contenedor.remove(go_pnl_rpt_correlativo_doc);
        jt_panel lo_jt_panel = new jt_panel(go_frm_principal.TBP_contenedor, 0);
        go_pnl_rpt_correlativo_doc = new pnl_rpt_correlativo_doc();
        go_pnl_rpt_correlativo_doc.removeAll();
        go_pnl_rpt_correlativo_doc.setLayout(new BorderLayout());
        go_pnl_rpt_correlativo_doc.add(jr, BorderLayout.CENTER);
        go_pnl_rpt_correlativo_doc.setVisible(true);
        go_pnl_rpt_correlativo_doc.repaint();
        go_pnl_rpt_correlativo_doc.revalidate();
        go_frm_principal.TBP_contenedor.addTab(nombre, go_pnl_rpt_correlativo_doc);
        go_frm_principal.TBP_contenedor.setSelectedIndex(go_frm_principal.TBP_contenedor.getTabCount() - 1);
        go_frm_principal.TBP_contenedor.setTabComponentAt(go_frm_principal.TBP_contenedor.getTabCount() - 1, lo_jt_panel);
    }

    public void rpt_ventas_x_vendedor(JRViewer jr, String nombre) {
        go_frm_principal.TBP_contenedor.remove(go_pnl_rpt_ventas_x_vendedor);
        jt_panel lo_jt_panel = new jt_panel(go_frm_principal.TBP_contenedor, 0);
        go_pnl_rpt_ventas_x_vendedor = new pnl_rpt_ventas_x_vendedor();
        go_pnl_rpt_ventas_x_vendedor.removeAll();
        go_pnl_rpt_ventas_x_vendedor.setLayout(new BorderLayout());
        go_pnl_rpt_ventas_x_vendedor.add(jr, BorderLayout.CENTER);
        go_pnl_rpt_ventas_x_vendedor.setVisible(true);
        go_pnl_rpt_ventas_x_vendedor.repaint();
        go_pnl_rpt_ventas_x_vendedor.revalidate();
        go_frm_principal.TBP_contenedor.addTab(nombre, go_pnl_rpt_ventas_x_vendedor);
        go_frm_principal.TBP_contenedor.setSelectedIndex(go_frm_principal.TBP_contenedor.getTabCount() - 1);
        go_frm_principal.TBP_contenedor.setTabComponentAt(go_frm_principal.TBP_contenedor.getTabCount() - 1, lo_jt_panel);
    }

    public void rpt_diferencia_precios(JRViewer jr, String nombre) {
        go_frm_principal.TBP_contenedor.remove(go_pnl_rpt_diferencia_precios);
        jt_panel lo_jt_panel = new jt_panel(go_frm_principal.TBP_contenedor, 0);
        go_pnl_rpt_diferencia_precios = new pnl_rpt_diferencia_precios();
        go_pnl_rpt_diferencia_precios.removeAll();
        go_pnl_rpt_diferencia_precios.setLayout(new BorderLayout());
        go_pnl_rpt_diferencia_precios.add(jr, BorderLayout.CENTER);
        go_pnl_rpt_diferencia_precios.setVisible(true);
        go_pnl_rpt_diferencia_precios.repaint();
        go_pnl_rpt_diferencia_precios.revalidate();
        go_frm_principal.TBP_contenedor.addTab(nombre, go_pnl_rpt_diferencia_precios);
        go_frm_principal.TBP_contenedor.setSelectedIndex(go_frm_principal.TBP_contenedor.getTabCount() - 1);
        go_frm_principal.TBP_contenedor.setTabComponentAt(go_frm_principal.TBP_contenedor.getTabCount() - 1, lo_jt_panel);
    }

    public void rpt_ventas_forma_pago(JRViewer jr, String nombre) {
        go_frm_principal.TBP_contenedor.remove(go_pnl_rpt_ventas_formas_pago);
        jt_panel lo_jt_panel = new jt_panel(go_frm_principal.TBP_contenedor, 0);
        go_pnl_rpt_ventas_formas_pago = new pnl_rpt_ventas_formas_pago();
        go_pnl_rpt_ventas_formas_pago.removeAll();
        go_pnl_rpt_ventas_formas_pago.setLayout(new BorderLayout());
        go_pnl_rpt_ventas_formas_pago.add(jr, BorderLayout.CENTER);
        go_pnl_rpt_ventas_formas_pago.setVisible(true);
        go_pnl_rpt_ventas_formas_pago.repaint();
        go_pnl_rpt_ventas_formas_pago.revalidate();
        go_frm_principal.TBP_contenedor.addTab(nombre, go_pnl_rpt_ventas_formas_pago);
        go_frm_principal.TBP_contenedor.setSelectedIndex(go_frm_principal.TBP_contenedor.getTabCount() - 1);
        go_frm_principal.TBP_contenedor.setTabComponentAt(go_frm_principal.TBP_contenedor.getTabCount() - 1, lo_jt_panel);
    }
}
