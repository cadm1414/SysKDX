package JAVA.INVENT.GUI;

import JAVA.ANCESTRO.GUI.pnl_opciones_3;
import JAVA.ANCESTRO.LOGICA.evt_opciones_3;
import JAVA.ANCESTRO.LOGICA.recupera_valor_op;
import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.CONFIG.GUI.dlg_tipo_movimiento_parametros;
import JAVA.CONFIG.LOGICA.cbx_tipo_documento;
import JAVA.INVENT.BEAN.BEAN_kardex;
import JAVA.INVENT.LOGICA.evt_cab_saldos_iniciales;
import JAVA.INVENT.LOGICA.evt_grid_saldos_iniciales;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.KeyStroke;

public class jif_saldos_iniciales extends javax.swing.JInternalFrame {

    pnl_grid_saldos_iniciales lo_pnl_grid_saldos_iniciales = new pnl_grid_saldos_iniciales();
    pnl_opciones_3 lo_pnl_opciones_3 = new pnl_opciones_3();
    pnl_cab_saldos_iniciales lo_pnl_cab_saldos_iniciales = new pnl_cab_saldos_iniciales();
    evt_opciones_3 lo_evt_opciones_3 = new evt_opciones_3();
    evt_grid_saldos_iniciales lo_evt_grid_saldos_iniciales = new evt_grid_saldos_iniciales();
    evt_cab_saldos_iniciales lo_evt_cab_saldos_iniciales = new evt_cab_saldos_iniciales();
    BEAN_kardex lo_bean_kardex = new BEAN_kardex();
    recupera_valor_op lo_recupera_valor_op = new recupera_valor_op();
    static boolean lb_valor_op[] = new boolean[8];
    cbx_tipo_documento lo_cbx_tipo_documento;
    ResultSet lq_rs;
    int li_tipo_operacion;
    String ls_codigo, ls_codigo_almacen, ls_codigo_movimiento, ls_codigo_articulo, ls_periodo_produccion, ls_oc;
    String ls_opcion = "M A A A";
    String ls_modulo = "INVENT", ls_capa = "GUI", ls_clase = "jif_saldos_iniciales";

    public jif_saldos_iniciales() {
        initComponents();
        formulario();
        activa_botones();
        get_tipo_documento();
        get_tipo_documento_ref();
        lo_pnl_grid_saldos_iniciales.TBL_saldos_iniciales.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "selectNextColumnCell");
    }

    private void formulario() {
        lo_pnl_opciones_3.setBounds(0, 10, 1000, 120);
        lo_pnl_cab_saldos_iniciales.setBounds(12, 130, 700, 210);
        lo_pnl_grid_saldos_iniciales.setBounds(15, 345, 1000, 500);

        this.add(lo_pnl_opciones_3);
        this.add(lo_pnl_cab_saldos_iniciales);
        this.add(lo_pnl_grid_saldos_iniciales);

        ls_codigo_almacen = gs_parametros[0];
        lo_pnl_cab_saldos_iniciales.TXT_nombre_almacen.setText(gs_parametros[1]);

        gs_parametros[0] = "";
        gs_parametros[1] = "";

        get_descripcion_tipo_movimiento("00");

        lo_evt_opciones_3.evento_click(lo_pnl_opciones_3, Listener);
        lo_evt_opciones_3.evento_press(lo_pnl_opciones_3, KeyEvnt);
        lo_evt_grid_saldos_iniciales.evento_press(lo_pnl_grid_saldos_iniciales, KeyEvnt);
        lo_evt_cab_saldos_iniciales.evento_press(lo_pnl_cab_saldos_iniciales, KeyEvnt);
        lo_pnl_grid_saldos_iniciales.TBL_saldos_iniciales.addMouseListener(MouseEvent);
    }

    private void activa_botones() {
        lb_valor_op = lo_recupera_valor_op.recupera(ls_modulo, ls_opcion);
        lo_evt_opciones_3.activa_btn_opciones(0, lo_pnl_opciones_3, lb_valor_op);
    }

    private void get_tipo_documento() {
        lq_rs = go_dao_tipo_documento.SLT_cbx_tipo_documento("1");
        if (lq_rs != null) {
            go_cbx_trato_datos.recupera_valor(12, lq_rs, lo_pnl_cab_saldos_iniciales.CBX_tipo_doc);
        }
    }

    private void get_tipo_documento_ref() {
        lq_rs = go_dao_tipo_documento.SLT_cbx_tipo_documento("%");
        if (lq_rs != null) {
            go_cbx_trato_datos.recupera_valor(12, lq_rs, lo_pnl_cab_saldos_iniciales.CBX_tipo_doc_ref);
        }
        go_cbx_trato_datos.selecciona_valor(12, "GI", lo_pnl_cab_saldos_iniciales.CBX_tipo_doc_ref);
    }

    private void get_descripcion_tipo_movimiento(String codigo) {
        try {
            lq_rs = go_dao_tipo_movimiento.SLT_grid_tipo_movimiento_parametros("1", "0", "3", "1", "1", codigo);
            if (lq_rs != null) {
                lo_pnl_cab_saldos_iniciales.TXT_codigo_movimiento.setText(lq_rs.getString(1));
                lo_pnl_cab_saldos_iniciales.TXT_nombre_movimiento.setText(lq_rs.getString(2));
            } else {
                go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "get_descripcion_tipo_movimiento", "TIPO MOVIMIENTO NO EXISTE y/o NO SE ENCUENTRA ACTIVO");
            }
        } catch (Exception e) {
        }
    }

    private void get_descripcion_articulo(String codigo) {
        try {
            lq_rs = go_dao_articulo.SLT_datos_articulo_x_articulo(codigo);
            if (lq_rs != null) {
                lo_pnl_grid_saldos_iniciales.TBL_saldos_iniciales.setValueAt(lq_rs.getString(1), lo_pnl_grid_saldos_iniciales.TBL_saldos_iniciales.getSelectedRow(), 3);
                lo_pnl_grid_saldos_iniciales.TBL_saldos_iniciales.setValueAt(lq_rs.getString(2), lo_pnl_grid_saldos_iniciales.TBL_saldos_iniciales.getSelectedRow(), 4);
                lo_pnl_grid_saldos_iniciales.TBL_saldos_iniciales.setValueAt(lq_rs.getDouble(3), lo_pnl_grid_saldos_iniciales.TBL_saldos_iniciales.getSelectedRow(), 9);
            }
        } catch (Exception e) {
        }
    }

    private void get_descripcion_kardex(String codigo) {
        try {
            lq_rs = go_dao_kardex.SLT_datos_kardex(codigo);
            if (lq_rs != null) {
                lo_evt_cab_saldos_iniciales.setea_recupera(lo_bean_kardex, lq_rs);
                lo_evt_cab_saldos_iniciales.muestra_datos(lo_pnl_cab_saldos_iniciales, lo_bean_kardex);
                get_descripcion_kardex_detalle(codigo);
            }
        } catch (Exception e) {
        }
    }

    private void get_descripcion_kardex_detalle(String codigo) {
        lo_evt_grid_saldos_iniciales.limpia_tabla(lo_pnl_grid_saldos_iniciales);
        lo_evt_grid_saldos_iniciales.recupera_detalle(lo_pnl_grid_saldos_iniciales, codigo);
    }

    private void genera_peso_neto(int fila) {
        try {
            double peso_neto = (double) lo_pnl_grid_saldos_iniciales.TBL_saldos_iniciales.getValueAt(fila, 8) - ((double) lo_pnl_grid_saldos_iniciales.TBL_saldos_iniciales.getValueAt(fila, 9) * (int) lo_pnl_grid_saldos_iniciales.TBL_saldos_iniciales.getValueAt(fila, 7));
            lo_pnl_grid_saldos_iniciales.TBL_saldos_iniciales.setValueAt(peso_neto, fila, 10);
        } catch (Exception e) {
        }
    }

    private void genera_parametros_busq() {
        gs_parametros[0] = ls_codigo_almacen;
        gs_parametros[1] = "01/01/" + gs_periodo;
        gs_parametros[2] = "01/01/" + gs_periodo;
        gs_parametros[3] = "00";
        gs_parametros[4] = "1";
        gs_parametros[5] = "0";
    }

    private void evt_f5() {
        go_dlg_tipo_movimiento_parametros = new dlg_tipo_movimiento_parametros(null, true);
        go_dlg_tipo_movimiento_parametros.ls_tipo_movimiento = "1";
        go_dlg_tipo_movimiento_parametros.ls_es_transferencia = "0";
        go_dlg_tipo_movimiento_parametros.ls_tipo_almacen = "3";
        go_dlg_tipo_movimiento_parametros.ls_es_visible = "1";
        go_dlg_tipo_movimiento_parametros.ls_status = "1";
        go_dlg_tipo_movimiento_parametros.ls_codigo_movimiento_p = "%";
        go_dlg_tipo_movimiento_parametros.setVisible(true);
        ls_codigo_movimiento = go_dlg_tipo_movimiento_parametros.ls_codigo_movimiento;
        if (ls_codigo_movimiento != null) {
            get_descripcion_tipo_movimiento(ls_codigo_movimiento);
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_f5", "SELECCIONE MOVIMIENTO");
        }
    }

    private void evt_f5_articulo_costo() {
        go_dlg_busq_articulo_costo = new dlg_busq_articulo_costo(null, true);
        go_dlg_busq_articulo_costo.setVisible(true);
        ls_codigo_articulo = go_dlg_busq_articulo_costo.ls_codigo_articulo;
        ls_oc = go_dlg_busq_articulo_costo.ls_oc;
        ls_periodo_produccion = go_dlg_busq_articulo_costo.ls_periodo_produccion;
        if (ls_periodo_produccion != null) {
            lo_pnl_grid_saldos_iniciales.TBL_saldos_iniciales.setValueAt(ls_codigo_articulo, lo_pnl_grid_saldos_iniciales.TBL_saldos_iniciales.getSelectedRow(), 2);
            lo_pnl_grid_saldos_iniciales.TBL_saldos_iniciales.setValueAt(ls_oc, lo_pnl_grid_saldos_iniciales.TBL_saldos_iniciales.getSelectedRow(), 5);
            lo_pnl_grid_saldos_iniciales.TBL_saldos_iniciales.setValueAt(ls_periodo_produccion, lo_pnl_grid_saldos_iniciales.TBL_saldos_iniciales.getSelectedRow(), 6);
            get_descripcion_articulo(ls_codigo_articulo);
        } else {
            lo_pnl_grid_saldos_iniciales.TBL_saldos_iniciales.setValueAt("", lo_pnl_grid_saldos_iniciales.TBL_saldos_iniciales.getSelectedRow(), 2);
            lo_pnl_grid_saldos_iniciales.TBL_saldos_iniciales.setValueAt("", lo_pnl_grid_saldos_iniciales.TBL_saldos_iniciales.getSelectedRow(), 5);
            lo_pnl_grid_saldos_iniciales.TBL_saldos_iniciales.setValueAt("", lo_pnl_grid_saldos_iniciales.TBL_saldos_iniciales.getSelectedRow(), 6);
            lo_pnl_grid_saldos_iniciales.TBL_saldos_iniciales.setValueAt("", lo_pnl_grid_saldos_iniciales.TBL_saldos_iniciales.getSelectedRow(), 3);
            lo_pnl_grid_saldos_iniciales.TBL_saldos_iniciales.setValueAt("", lo_pnl_grid_saldos_iniciales.TBL_saldos_iniciales.getSelectedRow(), 4);
            lo_pnl_grid_saldos_iniciales.TBL_saldos_iniciales.setValueAt(0.0, lo_pnl_grid_saldos_iniciales.TBL_saldos_iniciales.getSelectedRow(), 9);
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_buscar", "SELECCIONE ARTICULO COSTO");
        }
    }

    private void evt_nuevo() {
        ls_codigo = null;
        lo_evt_cab_saldos_iniciales.limpia_datos(lo_pnl_cab_saldos_iniciales);
        lo_evt_grid_saldos_iniciales.limpia_tabla(lo_pnl_grid_saldos_iniciales);
        li_tipo_operacion = 0;

        try {
            lq_rs = go_dao_kardex.FNC_correlativo_guia_almacen("GI", "", "1", ls_codigo_almacen);
            if (lq_rs.next()) {
                lo_pnl_cab_saldos_iniciales.TXT_numero.setText(lq_rs.getString(1));
                lo_pnl_cab_saldos_iniciales.LBL_numero_doc.setText(lq_rs.getString(1));
            }
        } catch (Exception e) {
        }

        lo_evt_opciones_3.activa_btn_opciones(1, lo_pnl_opciones_3, lb_valor_op);
        lo_evt_cab_saldos_iniciales.activa_campos(0, lo_pnl_cab_saldos_iniciales, true);
        lo_evt_grid_saldos_iniciales.activa_campos(0, lo_pnl_grid_saldos_iniciales, true);
    }

    private void evt_buscar() {
        li_tipo_operacion = 2;
        genera_parametros_busq();
        go_dlg_busq_kardex = new dlg_busq_kardex(null, true);
        go_dlg_busq_kardex.setVisible(true);
        ls_codigo = go_dlg_busq_kardex.ls_codigo;
        if (ls_codigo != null) {
            ls_codigo = ls_codigo.substring(0, 2) + ls_codigo_almacen + ls_codigo.substring(3, 13);
            get_descripcion_kardex(ls_codigo);
            lo_evt_opciones_3.activa_btn_opciones(2, lo_pnl_opciones_3, lb_valor_op);
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_buscar", "SELECCIONE DOCUMENTO");
            lo_evt_cab_saldos_iniciales.limpia_datos(lo_pnl_cab_saldos_iniciales);
            lo_evt_grid_saldos_iniciales.limpia_tabla(lo_pnl_grid_saldos_iniciales);
            lo_evt_opciones_3.activa_btn_opciones(0, lo_pnl_opciones_3, lb_valor_op);
        }
    }

    private void evt_editar() {
        li_tipo_operacion = 1;
        lo_evt_opciones_3.activa_btn_opciones(3, lo_pnl_opciones_3, lb_valor_op);
        lo_evt_cab_saldos_iniciales.activa_campos(1, lo_pnl_cab_saldos_iniciales, true);
        lo_evt_grid_saldos_iniciales.activa_campos(0, lo_pnl_grid_saldos_iniciales, true);
    }

    private void evt_eliminar() {
        if (go_fnc_mensaje.get_respuesta(0, "¿DESEA ELIMINAR DOCUMENTO Nro " + lo_bean_kardex.getCodigo_documento() + "-" + lo_bean_kardex.getNumero_documento() + "?") == 0) {
            try {
                if (go_dao_kardex_detalle.DLT_kardex_detalle(ls_codigo)) {
                    if (go_dao_kardex.DLT_kardex(ls_codigo)) {
                        lo_evt_opciones_3.activa_btn_opciones(0, lo_pnl_opciones_3, lb_valor_op);
                        lo_evt_cab_saldos_iniciales.activa_campos(0, lo_pnl_cab_saldos_iniciales, false);
                        lo_evt_cab_saldos_iniciales.limpia_datos(lo_pnl_cab_saldos_iniciales);
                        lo_evt_grid_saldos_iniciales.activa_campos(0, lo_pnl_grid_saldos_iniciales, false);
                        lo_evt_grid_saldos_iniciales.limpia_tabla(lo_pnl_grid_saldos_iniciales);
                    }
                }
            } catch (Exception e) {
            }
        }
    }
    
    private void evt_cancelar() {
        li_tipo_operacion = 2;
        lo_evt_cab_saldos_iniciales.activa_campos(0, lo_pnl_cab_saldos_iniciales, false); 
        lo_evt_grid_saldos_iniciales.activa_campos(0, lo_pnl_grid_saldos_iniciales, false);
         lo_evt_grid_saldos_iniciales.limpia_tabla(lo_pnl_grid_saldos_iniciales);
        if (ls_codigo != null) {
            lo_evt_cab_saldos_iniciales.muestra_datos(lo_pnl_cab_saldos_iniciales, lo_bean_kardex);           
            get_descripcion_kardex_detalle(ls_codigo);            
            lo_evt_opciones_3.activa_btn_opciones(2, lo_pnl_opciones_3, lb_valor_op);
        } else {
            lo_evt_cab_saldos_iniciales.limpia_datos(lo_pnl_cab_saldos_iniciales);
            lo_evt_opciones_3.activa_btn_opciones(0, lo_pnl_opciones_3, lb_valor_op);
        }
    }

    ActionListener Listener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == lo_pnl_opciones_3.BTN_nuevo) {
                evt_nuevo();
            }
            if (ae.getSource() == lo_pnl_opciones_3.BTN_buscar) {
                evt_buscar();
            }
            if (ae.getSource() == lo_pnl_opciones_3.BTN_editar) {
                evt_editar();
            }
            if (ae.getSource() == lo_pnl_opciones_3.BTN_eliminar) {
                evt_eliminar();
            }
            if (ae.getSource() == lo_pnl_opciones_3.BTN_cancelar) {
                evt_cancelar();
            }
        }
    };

    KeyListener KeyEvnt = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent ke) {

        }

        @Override
        public void keyPressed(KeyEvent ke) {
            if (ke.getKeyCode() == KeyEvent.VK_F1 && lo_pnl_opciones_3.BTN_nuevo.isEnabled()) {
                evt_nuevo();
            }
            if (ke.getKeyCode() == KeyEvent.VK_F2 && lo_pnl_opciones_3.BTN_buscar.isEnabled()) {
                evt_buscar();
            }
            if (ke.getKeyCode() == KeyEvent.VK_F3 && lo_pnl_opciones_3.BTN_editar.isEnabled()) {
                evt_editar();
            }
            if (ke.getKeyCode() == KeyEvent.VK_F3 && lo_pnl_opciones_3.BTN_eliminar.isEnabled()) {
                evt_eliminar();
            }
            if (ke.getKeyCode() == KeyEvent.VK_ESCAPE && lo_pnl_opciones_3.BTN_cancelar.isEnabled()) {
                evt_cancelar();
            }
            if (ke.getKeyCode() == KeyEvent.VK_F5 && lo_pnl_grid_saldos_iniciales.TBL_saldos_iniciales.getSelectedColumn() == 2) {
                evt_f5_articulo_costo();
            }
            if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                if (ke.getSource() == lo_pnl_opciones_3.BTN_nuevo) {
                    evt_nuevo();
                }
                if (ke.getSource() == lo_pnl_opciones_3.BTN_buscar) {
                    evt_buscar();
                }
                if (ke.getSource() == lo_pnl_opciones_3.BTN_editar) {
                    evt_editar();
                }
                if (ke.getSource() == lo_pnl_opciones_3.BTN_eliminar) {
                    evt_eliminar();
                }
                if (ke.getSource() == lo_pnl_opciones_3.BTN_cancelar) {
                    evt_cancelar();
                }
                if (ke.getSource() == lo_pnl_cab_saldos_iniciales.TXT_numero) {
                    if (go_fnc_operaciones_campos.campo_blanco(lo_pnl_cab_saldos_iniciales.TXT_numero)) {
                        lo_pnl_cab_saldos_iniciales.TXT_numero.setText(go_fnc_operaciones_campos.completa_digitos(lo_pnl_cab_saldos_iniciales.TXT_numero.getText().trim(), "0", 10));
                        lo_pnl_cab_saldos_iniciales.LBL_numero_doc.setText(lo_pnl_cab_saldos_iniciales.TXT_numero.getText());
                        lo_pnl_cab_saldos_iniciales.CBX_tipo_doc_ref.requestFocus();
                    }
                }
                if (ke.getSource() == lo_pnl_cab_saldos_iniciales.CBX_tipo_doc_ref) {
                    lo_pnl_cab_saldos_iniciales.TXT_numero_ref.requestFocus();
                }
                if (ke.getSource() == lo_pnl_cab_saldos_iniciales.TXT_numero_ref) {
                    if (go_fnc_operaciones_campos.campo_blanco(lo_pnl_cab_saldos_iniciales.TXT_numero_ref)) {
                        lo_pnl_cab_saldos_iniciales.TXT_numero_ref.setText(go_fnc_operaciones_campos.completa_digitos(lo_pnl_cab_saldos_iniciales.TXT_numero_ref.getText().trim(), "0", 10));
                        lo_pnl_cab_saldos_iniciales.TXT_fecha_emision.requestFocus();
                    }
                }
                if (ke.getSource() == lo_pnl_cab_saldos_iniciales.TXT_fecha_emision && !lo_pnl_cab_saldos_iniciales.TXT_fecha_emision.getText().trim().equalsIgnoreCase("/  /")) {
                    if (go_fnc_operaciones_campos.valida_fecha(lo_pnl_cab_saldos_iniciales.TXT_fecha_emision.getText())) {
                        if (lo_pnl_cab_saldos_iniciales.TXT_fecha_emision.getText().trim().substring(6, 10).equalsIgnoreCase(gs_periodo)) {
                            getFocusOwner().transferFocus();
                        } else {
                            lo_pnl_cab_saldos_iniciales.TXT_fecha_emision.setText("");
                            go_fnc_mensaje.GET_mensaje(0, ls_modulo, ls_capa, ls_clase, "keyPressed", "FECHA NO PERTENECE AL PERIODO");
                        }
                    } else {
                        lo_pnl_cab_saldos_iniciales.TXT_fecha_emision.setText("");
                        go_fnc_mensaje.GET_mensaje(0, ls_modulo, ls_capa, ls_clase, "keyPressed", "FORMATO DE FECHA INVALIDO");
                    }
                }
                if (ke.getSource() == lo_pnl_cab_saldos_iniciales.TXT_observacion) {
                    if (lo_pnl_grid_saldos_iniciales.TBL_saldos_iniciales.getRowCount() == 0) {
                        lo_pnl_grid_saldos_iniciales.TBL_saldos_iniciales.requestFocus();
                        lo_evt_grid_saldos_iniciales.agrega_fila(lo_pnl_grid_saldos_iniciales, -1);
                    } else {
                        lo_pnl_grid_saldos_iniciales.TBL_saldos_iniciales.requestFocus();
                        lo_pnl_grid_saldos_iniciales.TBL_saldos_iniciales.changeSelection(0, 1, false, false);
                    }
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent ke) {
            if (ke.getSource() == lo_pnl_cab_saldos_iniciales.TXT_numero) {
                lo_pnl_cab_saldos_iniciales.LBL_numero_doc.setText(lo_pnl_cab_saldos_iniciales.TXT_numero.getText());
            }
            if (ke.getSource() == lo_pnl_grid_saldos_iniciales.TBL_saldos_iniciales) {
                if (ke.getKeyCode() == KeyEvent.VK_ENTER || ke.getKeyCode() == KeyEvent.VK_TAB) {
                    int fila = lo_pnl_grid_saldos_iniciales.TBL_saldos_iniciales.getSelectedRow();
                    genera_peso_neto(fila);

                    if (lo_pnl_grid_saldos_iniciales.TBL_saldos_iniciales.getSelectedColumn() == 2) {
                        if (lo_pnl_grid_saldos_iniciales.TBL_saldos_iniciales.getValueAt(fila, 1).toString().trim().equalsIgnoreCase("")) {
                            lo_pnl_grid_saldos_iniciales.TBL_saldos_iniciales.changeSelection(fila, 1, false, false);
                            lo_pnl_grid_saldos_iniciales.TBL_saldos_iniciales.editCellAt(fila, 1);
                        } else {
                            String lote = go_fnc_operaciones_campos.completa_digitos(lo_pnl_grid_saldos_iniciales.TBL_saldos_iniciales.getValueAt(fila, 1) + "", "0", 6);
                            lo_pnl_grid_saldos_iniciales.TBL_saldos_iniciales.setValueAt(lote, fila, 1);
                        }
                    }
                    if (lo_pnl_grid_saldos_iniciales.TBL_saldos_iniciales.getSelectedColumn() == 3) {
                        if (lo_pnl_grid_saldos_iniciales.TBL_saldos_iniciales.getValueAt(fila, 2).toString().trim().equalsIgnoreCase("")) {
                            lo_pnl_grid_saldos_iniciales.TBL_saldos_iniciales.changeSelection(fila, 2, false, false);
                        } else {
                            lo_pnl_grid_saldos_iniciales.TBL_saldos_iniciales.changeSelection(fila, 7, false, false);
                            lo_pnl_grid_saldos_iniciales.TBL_saldos_iniciales.editCellAt(fila, 7);
                        }
                    }
                    if (lo_pnl_grid_saldos_iniciales.TBL_saldos_iniciales.getSelectedColumn() == 8) {
                        if (lo_pnl_grid_saldos_iniciales.TBL_saldos_iniciales.getValueAt(fila, 7) == null) {
                            lo_pnl_grid_saldos_iniciales.TBL_saldos_iniciales.setValueAt(0, fila, 7);
                            lo_pnl_grid_saldos_iniciales.TBL_saldos_iniciales.changeSelection(fila, 7, false, false);
                        }
                    }
                    if (lo_pnl_grid_saldos_iniciales.TBL_saldos_iniciales.getSelectedColumn() == 9) {
                        if (lo_pnl_grid_saldos_iniciales.TBL_saldos_iniciales.getValueAt(fila, 8) == null) {
                            lo_pnl_grid_saldos_iniciales.TBL_saldos_iniciales.changeSelection(fila, 8, false, false);
                        } else if ((Double) lo_pnl_grid_saldos_iniciales.TBL_saldos_iniciales.getValueAt(fila, 8) == 0) {
                            lo_pnl_grid_saldos_iniciales.TBL_saldos_iniciales.changeSelection(fila, 8, false, false);
                        }
                    }
                    if (lo_pnl_grid_saldos_iniciales.TBL_saldos_iniciales.getSelectedColumn() == 10) {
                        lo_evt_grid_saldos_iniciales.agrega_fila(lo_pnl_grid_saldos_iniciales, fila);
                    }
                }
            }
        }
    };

    MouseListener MouseEvent = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent me) {
            if (me.getSource() == lo_pnl_grid_saldos_iniciales.TBL_saldos_iniciales && lo_pnl_grid_saldos_iniciales.TBL_saldos_iniciales.isEnabled()) {
                int columna = lo_pnl_grid_saldos_iniciales.TBL_saldos_iniciales.getColumnModel().getColumnIndexAtX(me.getX());
                int fila = me.getY() / lo_pnl_grid_saldos_iniciales.TBL_saldos_iniciales.getRowHeight();
                Object value = lo_pnl_grid_saldos_iniciales.TBL_saldos_iniciales.getValueAt(fila, columna);
                if (value instanceof JButton) {
                    if (go_fnc_mensaje.get_respuesta(0, "¿DESEA ELIMINAR ITEM " + go_fnc_operaciones_campos.completa_digitos((fila + 1) + "", "0", 3) + "?") == 0) {
                        lo_evt_grid_saldos_iniciales.elimina_fila(lo_pnl_grid_saldos_iniciales, fila);
                        lo_evt_grid_saldos_iniciales.genera_item(lo_pnl_grid_saldos_iniciales);
                    }
                }
            }
        }

        @Override
        public void mousePressed(MouseEvent me) {
        }

        @Override
        public void mouseReleased(MouseEvent me) {
        }

        @Override
        public void mouseEntered(MouseEvent me) {
        }

        @Override
        public void mouseExited(MouseEvent me) {
        }
    };

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setClosable(true);
        setIconifiable(true);
        setTitle("SALDOS INICIALES");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/JAVA/ANCESTRO/IMAGES/formulario.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 920, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 554, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
