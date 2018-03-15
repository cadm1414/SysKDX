package JAVA.DISTBR.GUI;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.CONFIG.LOGICA.cbx_sector_distribucion;
import JAVA.CONFIG.LOGICA.cbx_vendedor;
import JAVA.DISTBR.LOGICA.evt_datos_preliminar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRParameter;

public class jif_preliminar extends javax.swing.JInternalFrame {

    pnl_datos_preliminar lo_pnl_datos_preliminar = new pnl_datos_preliminar();
    evt_datos_preliminar lo_evt_datos_preliminar = new evt_datos_preliminar();
    ResultSet lq_rs;
    DefaultTableModel modelo;
    cbx_vendedor lo_cbx_vendedor;
    cbx_sector_distribucion lo_cbx_sector;
    String ls_codigo_vendedor, ls_codigo_sector, ls_codigo, ls_pedidos;
    String ls_modulo = "DISTBR", ls_capa = "GUI", ls_clase = "jif_preliminar";
    int li_cont = 1;

    public jif_preliminar() {
        initComponents();
        formulario();
    }

    private void formulario() {
        lo_pnl_datos_preliminar.setBounds(0, 0, 1000, 1000);
        this.add(lo_pnl_datos_preliminar);

        get_cbx_codigo(lo_pnl_datos_preliminar.CBX_tipo_busqueda.getSelectedIndex());
        get_detalle();

        modelo = (DefaultTableModel) lo_pnl_datos_preliminar.TBL_pedido.getModel();
        modelo.addTableModelListener(TablaListener);

        lo_pnl_datos_preliminar.TXT_fecha_reparto.setText(gs_dia + gs_mes + gs_periodo);

        lo_evt_datos_preliminar.evento_click(lo_pnl_datos_preliminar, Listener);
        lo_evt_datos_preliminar.evento_item(lo_pnl_datos_preliminar, ItemEvent);
        lo_evt_datos_preliminar.evento_press(lo_pnl_datos_preliminar, KeyEvnt);
    }

    private void get_cbx_codigo(int op) {
        /*
        0 = VENDEDOR
        1 = SECTOR
         */
        switch (op) {
            case 0:
                lq_rs = go_dao_vendedor.SLT_cbx_vendedor();
                if (lq_rs != null) {
                    go_cbx_trato_datos.recupera_valor(14, lq_rs, lo_pnl_datos_preliminar.CBX_codigo);
                }
                break;
            case 1:
                lq_rs = go_dao_sector_distribucion.SLT_cbx_sector_distribucion();
                if (lq_rs != null) {
                    go_cbx_trato_datos.recupera_valor(20, lq_rs, lo_pnl_datos_preliminar.CBX_codigo);
                }
                break;
        }
    }

    private void get_detalle() {
        switch (lo_pnl_datos_preliminar.CBX_tipo_busqueda.getSelectedIndex()) {
            case 0:
                lo_cbx_vendedor = (cbx_vendedor) lo_pnl_datos_preliminar.CBX_codigo.getSelectedItem();
                ls_codigo_vendedor = lo_cbx_vendedor.getID();
                ls_codigo_sector = "%";
                break;
            case 1:
                lo_cbx_sector = (cbx_sector_distribucion) lo_pnl_datos_preliminar.CBX_codigo.getSelectedItem();
                ls_codigo_sector = lo_cbx_sector.getID();
                ls_codigo_vendedor = "%";
                break;
            case 2:
                ls_codigo_sector = "%";
                ls_codigo_vendedor = "%";
                break;
        }

        lo_pnl_datos_preliminar.JRD_todos.setSelected(false);
        lo_evt_datos_preliminar.limpia_tabla(lo_pnl_datos_preliminar);
        lo_evt_datos_preliminar.recupera_detalle(ls_codigo_vendedor, ls_codigo_sector, lo_pnl_datos_preliminar);
    }

    private boolean valida_fecha(JTextField fecha) {
        boolean resp = false;
        if (go_fnc_operaciones_campos.valida_fecha(fecha.getText())) {
            resp = true;
        } else {
            fecha.setText("");
            go_fnc_mensaje.GET_mensaje(0, ls_modulo, ls_capa, ls_clase, "keyPressed", "FORMATO DE FECHA INVALIDO");
        }
        return resp;
    }

    private void evt_imprimir() {
        if (valida_fecha(lo_pnl_datos_preliminar.TXT_fecha_reparto)) {
            if (Integer.parseInt(lo_pnl_datos_preliminar.LBL_contador.getText()) > 0) {

                ls_codigo = lo_evt_datos_preliminar.genera_codigo(lo_pnl_datos_preliminar);
                ls_pedidos = lo_evt_datos_preliminar.genera_pedidos(lo_pnl_datos_preliminar);

                Map<String, Object> parametros = new HashMap<>();
                parametros.put("codigo_operacion", ls_codigo);
                parametros.put("periodo", gs_periodo);
                parametros.put("usuario", gs_datos_usuario);
                parametros.put("empresa", go_bean_general.getNombre_reporte());
                parametros.put("operacion", lo_pnl_datos_preliminar.CBX_tipo_busqueda.getSelectedIndex() + "");
                parametros.put("pedidos", ls_pedidos);
                parametros.put("cantidad_pedidos", lo_pnl_datos_preliminar.LBL_contador.getText().trim());
                parametros.put("fecha_reparto", lo_pnl_datos_preliminar.TXT_fecha_reparto.getText().trim());
                parametros.put(JRParameter.REPORT_LOCALE, Locale.ENGLISH);
                go_muestra_reporte_distbr.reporte_pestania("rpt_despacho_preliminar.jasper", parametros, "PRELIMINAR", 1);
                //go_evt_imprime_doc_distbr.imprime_documentos(0, "rpt_despacho_preliminar.jasper", parametros);
                if (go_fnc_mensaje.get_respuesta(0, "¿DESEA GENERAR BOLETAS DE LOS PEDIDOS SELECCIONADOS?") == 0) {
                    try {
                        go_dao_registro_ventas.FNC_genera_rv_masivo(ls_codigo, lo_pnl_datos_preliminar.TXT_fecha_reparto.getText().trim());
                    } catch (Exception e) {
                        go_fnc_mensaje.GET_mensaje(0, ls_modulo, ls_capa, ls_clase, "evt_imprimir", e.getMessage());
                    }
                }
            } else {
                lo_pnl_datos_preliminar.JRD_todos.requestFocus();
                go_fnc_mensaje.GET_mensaje(0, ls_modulo, ls_capa, ls_clase, "evt_imprimir", "SELECCIONE AL MENOS UN PEDIDO");
            }
        } else {
            lo_pnl_datos_preliminar.TXT_fecha_reparto.requestFocus();
        }
    }

    ActionListener Listener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == lo_pnl_datos_preliminar.BTN_imprimir) {
                evt_imprimir();
            }
        }
    };

    KeyListener KeyEvnt = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent ke) {

        }

        @Override
        public void keyPressed(KeyEvent ke) {
            if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                if (ke.getSource() == lo_pnl_datos_preliminar.CBX_codigo || ke.getSource() == lo_pnl_datos_preliminar.CBX_tipo_busqueda || ke.getSource() == lo_pnl_datos_preliminar.JRD_todos) {
                    getFocusOwner().transferFocus();
                }
                if (ke.getSource() == lo_pnl_datos_preliminar.TXT_fecha_reparto && !lo_pnl_datos_preliminar.TXT_fecha_reparto.getText().trim().equalsIgnoreCase("/  /")) {
                    if (valida_fecha(lo_pnl_datos_preliminar.TXT_fecha_reparto)) {
                        getFocusOwner().transferFocus();
                    }
                }
                if (ke.getSource() == lo_pnl_datos_preliminar.BTN_imprimir) {
                    evt_imprimir();
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent ke) {

        }

    };

    ItemListener ItemEvent = new ItemListener() {
        @Override
        public void itemStateChanged(java.awt.event.ItemEvent ie) {
            li_cont = 0;
            if (ie.getSource() == lo_pnl_datos_preliminar.CBX_tipo_busqueda) {
                lo_evt_datos_preliminar.limpia_tabla(lo_pnl_datos_preliminar);
                get_cbx_codigo(lo_pnl_datos_preliminar.CBX_tipo_busqueda.getSelectedIndex());
                get_detalle();
                lo_pnl_datos_preliminar.CBX_codigo.setEnabled((lo_pnl_datos_preliminar.CBX_tipo_busqueda.getSelectedIndex() != 2) ? true : false);
            }
            if (ie.getSource() == lo_pnl_datos_preliminar.CBX_codigo) {
                get_detalle();
            }
            if (ie.getSource() == lo_pnl_datos_preliminar.JRD_todos) {
                if (lo_pnl_datos_preliminar.JRD_todos.isSelected()) {
                    lo_evt_datos_preliminar.selecciona_todo(true, lo_pnl_datos_preliminar);
                } else {
                    lo_evt_datos_preliminar.selecciona_todo(false, lo_pnl_datos_preliminar);
                }
                lo_evt_datos_preliminar.cuenta_seleccion(lo_pnl_datos_preliminar);
            }
            li_cont = 1;
        }
    };

    TableModelListener TablaListener = new TableModelListener() {
        @Override
        public void tableChanged(TableModelEvent tme) {
            if (tme.getType() == TableModelEvent.UPDATE && li_cont != 0) {
                lo_evt_datos_preliminar.cuenta_seleccion(lo_pnl_datos_preliminar);
            }
        }
    };

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setClosable(true);
        setIconifiable(true);
        setTitle("PRELIMINAR REPARTO");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/JAVA/ANCESTRO/IMAGES/formulario.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 864, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 413, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
