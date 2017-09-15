package JAVA.INVENT.GUI;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.ANCESTRO.GUI.pnl_opciones_3;
import JAVA.ANCESTRO.LOGICA.evt_opciones_3;
import JAVA.ANCESTRO.LOGICA.recupera_valor_op;
import JAVA.CONFIG.GUI.dlg_tipo_movimiento_parametros;
import JAVA.CONFIG.LOGICA.cbx_tipo_documento;
import JAVA.INVENT.BEAN.BEAN_kardex;
import JAVA.INVENT.LOGICA.evt_cab_guia_ingreso;
import JAVA.INVENT.LOGICA.evt_grid_guia_ingreso;
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
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

public class jif_guia_ingreso extends javax.swing.JInternalFrame {

    pnl_opciones_3 lo_pnl_opciones_3 = new pnl_opciones_3();
    evt_opciones_3 lo_evt_opciones_3 = new evt_opciones_3();
    pnl_cab_guia_ingreso lo_pnl_cab_guia_ingreso = new pnl_cab_guia_ingreso();
    evt_cab_guia_ingreso lo_evt_cab_guia_ingreso = new evt_cab_guia_ingreso();
    pnl_grid_guia_ingreso lo_pnl_grid_guia_ingreso = new pnl_grid_guia_ingreso();
    evt_grid_guia_ingreso lo_evt_grid_guia_ingreso = new evt_grid_guia_ingreso();
    recupera_valor_op lo_recupera_valor_op = new recupera_valor_op();
    cbx_tipo_documento lo_cbx_tipo_documento, lo_cbx_tipo_documento_ref;
    BEAN_kardex lo_bean_kardex = new BEAN_kardex();
    static boolean lb_valor_op[] = new boolean[8];
    DefaultTableModel modelo;
    ResultSet lq_rs;
    int li_tipo_operacion, cont = 0;
    String ls_codigo, ls_codigo_almacen, ls_codigo_movimiento, ls_codigo_articulo, ls_periodo_produccion, ls_oc;
    String ls_opcion = "M A A B";
    String ls_modulo = "INVENT", ls_capa = "GUI", ls_clase = "jif_guia_ingreso";

    public jif_guia_ingreso() {
        initComponents();
        formulario();
        activa_botones();
        get_tipo_documento();
        get_tipo_documento_ref();
        lo_pnl_grid_guia_ingreso.TBL_guia_ingreso.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "selectNextColumnCell");
    }

    private void formulario() {
        lo_pnl_opciones_3.setBounds(0, 10, 1000, 120);
        lo_pnl_cab_guia_ingreso.setBounds(12, 130, 700, 210);
        lo_pnl_grid_guia_ingreso.setBounds(15, 345, 1000, 500);

        this.add(lo_pnl_opciones_3);
        this.add(lo_pnl_cab_guia_ingreso);
        this.add(lo_pnl_grid_guia_ingreso);

        ls_codigo_almacen = gs_parametros[0];
        lo_pnl_cab_guia_ingreso.TXT_nombre_almacen.setText(gs_parametros[1]);

        gs_parametros[0] = "";
        gs_parametros[1] = "";

        modelo = (DefaultTableModel) lo_pnl_grid_guia_ingreso.TBL_guia_ingreso.getModel();
        modelo.addTableModelListener(TablaListener);

        lo_evt_opciones_3.evento_click(lo_pnl_opciones_3, Listener);
        lo_evt_opciones_3.evento_press(lo_pnl_opciones_3, KeyEvnt);
        lo_evt_cab_guia_ingreso.evento_press(lo_pnl_cab_guia_ingreso, KeyEvnt);
        lo_evt_grid_guia_ingreso.evento_press(lo_pnl_grid_guia_ingreso, KeyEvnt);
        lo_pnl_grid_guia_ingreso.TBL_guia_ingreso.addMouseListener(MouseEvent);
    }

    private void activa_botones() {
        lb_valor_op = lo_recupera_valor_op.recupera(ls_modulo, ls_opcion);
        lo_evt_opciones_3.activa_btn_opciones(0, lo_pnl_opciones_3, lb_valor_op);
    }

    private void get_tipo_documento() {
        lq_rs = go_dao_tipo_documento.SLT_cbx_tipo_documento("1");
        if (lq_rs != null) {
            go_cbx_trato_datos.recupera_valor(12, lq_rs, lo_pnl_cab_guia_ingreso.CBX_tipo_doc);
        }
    }

    private void get_tipo_documento_ref() {
        lq_rs = go_dao_tipo_documento.SLT_cbx_tipo_documento("%");
        if (lq_rs != null) {
            go_cbx_trato_datos.recupera_valor(12, lq_rs, lo_pnl_cab_guia_ingreso.CBX_tipo_doc_ref);
        }
        go_cbx_trato_datos.selecciona_valor(12, "01", lo_pnl_cab_guia_ingreso.CBX_tipo_doc_ref);
    }

    private void get_descripcion_tipo_movimiento(String codigo) {
        try {
            lq_rs = go_dao_tipo_movimiento.SLT_grid_tipo_movimiento_parametros("1", "0", "%", "1", "1", codigo);
            if (lq_rs != null) {
                lo_pnl_cab_guia_ingreso.TXT_codigo_movimiento.setText(lq_rs.getString(1));
                lo_pnl_cab_guia_ingreso.TXT_nombre_movimiento.setText(lq_rs.getString(2));
            } else {
                go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "get_descripcion_tipo_movimiento", "TIPO MOVIMIENTO NO EXISTE y/o NO SE ENCUENTRA ACTIVO");
                lo_pnl_cab_guia_ingreso.TXT_codigo_movimiento.setText("");
                lo_pnl_cab_guia_ingreso.TXT_nombre_movimiento.setText("");
                lo_pnl_cab_guia_ingreso.TXT_codigo_movimiento.requestFocus();
            }
        } catch (Exception e) {
        }
    }

    private void get_descripcion_articulo(String codigo) {
        try {
            lq_rs = go_dao_articulo.SLT_datos_articulo_x_articulo(codigo);
            if (lq_rs != null) {
                lo_pnl_grid_guia_ingreso.TBL_guia_ingreso.setValueAt(lq_rs.getString(1), lo_pnl_grid_guia_ingreso.TBL_guia_ingreso.getSelectedRow(), 3);
                lo_pnl_grid_guia_ingreso.TBL_guia_ingreso.setValueAt(lq_rs.getString(2), lo_pnl_grid_guia_ingreso.TBL_guia_ingreso.getSelectedRow(), 4);
                lo_pnl_grid_guia_ingreso.TBL_guia_ingreso.setValueAt(lq_rs.getDouble(3), lo_pnl_grid_guia_ingreso.TBL_guia_ingreso.getSelectedRow(), 9);
            }
        } catch (Exception e) {
        }
    }

    private void get_descripcion_kardex(String codigo) {
        try {
            lq_rs = go_dao_kardex.SLT_datos_kardex(codigo);
            if (lq_rs != null) {
                lo_evt_cab_guia_ingreso.setea_recupera(lo_bean_kardex, lq_rs);
                lo_evt_cab_guia_ingreso.muestra_datos(lo_pnl_cab_guia_ingreso, lo_bean_kardex);
                get_descripcion_kardex_detalle(codigo);
            }
        } catch (Exception e) {
        }
    }

    private void get_descripcion_kardex_detalle(String codigo) {
        lo_evt_grid_guia_ingreso.limpia_tabla(lo_pnl_grid_guia_ingreso);
        lo_evt_grid_guia_ingreso.recupera_detalle(lo_pnl_grid_guia_ingreso, codigo);
    }

    private void genera_peso_neto(int fila) {
        try {
            double peso_neto = (double) lo_pnl_grid_guia_ingreso.TBL_guia_ingreso.getValueAt(fila, 8) - ((double) lo_pnl_grid_guia_ingreso.TBL_guia_ingreso.getValueAt(fila, 9) * (int) lo_pnl_grid_guia_ingreso.TBL_guia_ingreso.getValueAt(fila, 7));
            lo_pnl_grid_guia_ingreso.TBL_guia_ingreso.setValueAt(peso_neto, fila, 10);
        } catch (Exception e) {
        }
    }

    private void genera_parametros_busq() {
        gs_parametros[0] = ls_codigo_almacen;
        gs_parametros[1] = "01/" + gs_mes + "/" + gs_periodo;
        gs_parametros[2] = gs_dia + "/" + gs_mes + "/" + gs_periodo;
        gs_parametros[3] = "%";
        gs_parametros[4] = "1";
        gs_parametros[5] = "0";
    }

    private void evt_f5_tipo_movimiento() {
        gs_parametros[0] = "1";
        gs_parametros[1] = "0";
        gs_parametros[2] = "%";
        gs_parametros[3] = "1";
        gs_parametros[4] = "1";
        gs_parametros[5] = "%";
        go_dlg_tipo_movimiento_parametros = new dlg_tipo_movimiento_parametros(null, true);
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
            lo_pnl_grid_guia_ingreso.TBL_guia_ingreso.setValueAt(ls_codigo_articulo, lo_pnl_grid_guia_ingreso.TBL_guia_ingreso.getSelectedRow(), 2);
            lo_pnl_grid_guia_ingreso.TBL_guia_ingreso.setValueAt(ls_oc, lo_pnl_grid_guia_ingreso.TBL_guia_ingreso.getSelectedRow(), 5);
            lo_pnl_grid_guia_ingreso.TBL_guia_ingreso.setValueAt(ls_periodo_produccion, lo_pnl_grid_guia_ingreso.TBL_guia_ingreso.getSelectedRow(), 6);
            get_descripcion_articulo(ls_codigo_articulo);
        } else {
            lo_pnl_grid_guia_ingreso.TBL_guia_ingreso.setValueAt("", lo_pnl_grid_guia_ingreso.TBL_guia_ingreso.getSelectedRow(), 2);
            lo_pnl_grid_guia_ingreso.TBL_guia_ingreso.setValueAt("", lo_pnl_grid_guia_ingreso.TBL_guia_ingreso.getSelectedRow(), 5);
            lo_pnl_grid_guia_ingreso.TBL_guia_ingreso.setValueAt("", lo_pnl_grid_guia_ingreso.TBL_guia_ingreso.getSelectedRow(), 6);
            lo_pnl_grid_guia_ingreso.TBL_guia_ingreso.setValueAt("", lo_pnl_grid_guia_ingreso.TBL_guia_ingreso.getSelectedRow(), 3);
            lo_pnl_grid_guia_ingreso.TBL_guia_ingreso.setValueAt("", lo_pnl_grid_guia_ingreso.TBL_guia_ingreso.getSelectedRow(), 4);
            lo_pnl_grid_guia_ingreso.TBL_guia_ingreso.setValueAt(0.0, lo_pnl_grid_guia_ingreso.TBL_guia_ingreso.getSelectedRow(), 9);
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_buscar", "SELECCIONE ARTICULO COSTO");
        }
    }

    private void evt_nuevo() {
        ls_codigo = null;
        go_cbx_trato_datos.selecciona_valor(12, "01", lo_pnl_cab_guia_ingreso.CBX_tipo_doc_ref);
        lo_evt_cab_guia_ingreso.limpia_datos(lo_pnl_cab_guia_ingreso);
        lo_evt_grid_guia_ingreso.limpia_tabla(lo_pnl_grid_guia_ingreso);
        li_tipo_operacion = 0;

        try {
            lq_rs = go_dao_kardex.FNC_correlativo_guia_almacen("GI", ls_codigo_almacen, "1", ls_codigo_almacen);
            if (lq_rs.next()) {
                lo_pnl_cab_guia_ingreso.TXT_numero.setText(lq_rs.getString(1));
                lo_pnl_cab_guia_ingreso.LBL_numero_doc.setText(lq_rs.getString(1));
            }
        } catch (Exception e) {
        }
        lo_evt_opciones_3.activa_btn_opciones(1, lo_pnl_opciones_3, lb_valor_op);
        lo_evt_cab_guia_ingreso.activa_campos(0, lo_pnl_cab_guia_ingreso, true);
        lo_evt_grid_guia_ingreso.activa_campos(0, lo_pnl_grid_guia_ingreso, true);
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
            get_descripcion_tipo_movimiento(lo_pnl_cab_guia_ingreso.TXT_codigo_movimiento.getText().trim());
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_buscar", "SELECCIONE DOCUMENTO");
            lo_evt_cab_guia_ingreso.limpia_datos(lo_pnl_cab_guia_ingreso);
            lo_evt_grid_guia_ingreso.limpia_tabla(lo_pnl_grid_guia_ingreso);
            lo_evt_opciones_3.activa_btn_opciones(0, lo_pnl_opciones_3, lb_valor_op);
        }
    }

    private void evt_guardar() {
        lo_cbx_tipo_documento = (cbx_tipo_documento) lo_pnl_cab_guia_ingreso.CBX_tipo_doc.getSelectedItem();
        lo_cbx_tipo_documento_ref = (cbx_tipo_documento) lo_pnl_cab_guia_ingreso.CBX_tipo_doc_ref.getSelectedItem();
        //elimina_ult_fila();
        /*
        NUEVO = 0
        EDITAR = 1
         */

        switch (li_tipo_operacion) {
            case 0:
                if (lo_evt_cab_guia_ingreso.valida_campos(lo_pnl_cab_guia_ingreso, ls_codigo_almacen,li_tipo_operacion)) {
                    if (lo_evt_grid_guia_ingreso.valida_campos(lo_pnl_grid_guia_ingreso, lo_pnl_cab_guia_ingreso.TXT_lote.getText().trim())) {
                        try {
                            ls_codigo = lo_cbx_tipo_documento.getID() + ls_codigo_almacen + lo_pnl_cab_guia_ingreso.TXT_numero.getText().trim();
                            lo_bean_kardex.setCodigo_operacion(ls_codigo);
                            lo_bean_kardex.setCodigo_almacen(ls_codigo_almacen);
                            lo_bean_kardex.setSerie_documento(ls_codigo_almacen);
                            lo_evt_cab_guia_ingreso.setea_campos(lo_bean_kardex, lo_pnl_cab_guia_ingreso, lo_cbx_tipo_documento, lo_cbx_tipo_documento_ref);
                            if (go_dao_kardex.IST_kardex(lo_bean_kardex, lo_pnl_grid_guia_ingreso.TBL_guia_ingreso)) {
                                lo_evt_cab_guia_ingreso.limpia_datos(lo_pnl_cab_guia_ingreso);
                                lo_evt_cab_guia_ingreso.activa_campos(0, lo_pnl_cab_guia_ingreso, false);
                                lo_evt_grid_guia_ingreso.limpia_tabla(lo_pnl_grid_guia_ingreso);
                                lo_evt_grid_guia_ingreso.activa_campos(0, lo_pnl_grid_guia_ingreso, false);
                                lo_evt_opciones_3.activa_btn_opciones(0, lo_pnl_opciones_3, lb_valor_op);
                            }
                        } catch (Exception e) {
                        }
                    }
                }
                break;
            case 1:
                if (lo_evt_cab_guia_ingreso.verifica_cambios(lo_bean_kardex, lo_pnl_cab_guia_ingreso, lo_cbx_tipo_documento_ref) || cont != 0) {
                    if (lo_evt_cab_guia_ingreso.valida_campos(lo_pnl_cab_guia_ingreso,ls_codigo_almacen,li_tipo_operacion)) {
                        if (lo_evt_grid_guia_ingreso.valida_campos(lo_pnl_grid_guia_ingreso,lo_pnl_cab_guia_ingreso.TXT_lote.getText().trim())) {
                            try {
                                lo_evt_cab_guia_ingreso.setea_campos(lo_bean_kardex, lo_pnl_cab_guia_ingreso, lo_cbx_tipo_documento, lo_cbx_tipo_documento_ref);
                                if (go_dao_kardex_detalle.DLT_kardex_detalle(ls_codigo)) {
                                    if (go_dao_kardex.UPD_kardex(lo_bean_kardex, lo_pnl_grid_guia_ingreso.TBL_guia_ingreso)) {
                                        lo_evt_cab_guia_ingreso.limpia_datos(lo_pnl_cab_guia_ingreso);
                                        lo_evt_cab_guia_ingreso.activa_campos(0, lo_pnl_cab_guia_ingreso, false);
                                        lo_evt_grid_guia_ingreso.limpia_tabla(lo_pnl_grid_guia_ingreso);
                                        lo_evt_grid_guia_ingreso.activa_campos(0, lo_pnl_grid_guia_ingreso, false);
                                        lo_evt_opciones_3.activa_btn_opciones(0, lo_pnl_opciones_3, lb_valor_op);
                                    }
                                }
                            } catch (Exception e) {
                            }
                        }
                    }
                } else {
                    go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_guardar", "NO SE A REALIZADO CAMBIOS");
                }
                break;
        }
    }

    private void evt_editar() {
        li_tipo_operacion = 1;
        cont = 0;
        lo_evt_opciones_3.activa_btn_opciones(3, lo_pnl_opciones_3, lb_valor_op);
        lo_evt_cab_guia_ingreso.activa_campos(1, lo_pnl_cab_guia_ingreso, true);
        lo_evt_grid_guia_ingreso.activa_campos(0, lo_pnl_grid_guia_ingreso, true);
    }

    private void evt_eliminar() {
        if (go_fnc_mensaje.get_respuesta(0, "¿DESEA ELIMINAR DOCUMENTO Nro " + lo_bean_kardex.getCodigo_documento() + "-" + lo_bean_kardex.getNumero_documento() + "?") == 0) {
            try {
                if (go_dao_kardex_detalle.DLT_kardex_detalle(ls_codigo)) {
                    if (go_dao_kardex.DLT_kardex(ls_codigo)) {
                        lo_evt_opciones_3.activa_btn_opciones(0, lo_pnl_opciones_3, lb_valor_op);
                        lo_evt_cab_guia_ingreso.activa_campos(0, lo_pnl_cab_guia_ingreso, false);
                        lo_evt_cab_guia_ingreso.limpia_datos(lo_pnl_cab_guia_ingreso);
                        lo_evt_grid_guia_ingreso.activa_campos(0, lo_pnl_grid_guia_ingreso, false);
                        lo_evt_grid_guia_ingreso.limpia_tabla(lo_pnl_grid_guia_ingreso);
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    private void evt_cancelar() {
        li_tipo_operacion = 2;
        lo_evt_cab_guia_ingreso.activa_campos(0, lo_pnl_cab_guia_ingreso, false);
        lo_evt_grid_guia_ingreso.activa_campos(0, lo_pnl_grid_guia_ingreso, false);
        lo_evt_grid_guia_ingreso.limpia_tabla(lo_pnl_grid_guia_ingreso);
        if (ls_codigo != null) {
            lo_evt_cab_guia_ingreso.muestra_datos(lo_pnl_cab_guia_ingreso, lo_bean_kardex);
            get_descripcion_kardex_detalle(ls_codigo);
            lo_evt_opciones_3.activa_btn_opciones(2, lo_pnl_opciones_3, lb_valor_op);
        } else {
            lo_evt_cab_guia_ingreso.limpia_datos(lo_pnl_cab_guia_ingreso);
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
            if (ae.getSource() == lo_pnl_opciones_3.BTN_guardar) {
                evt_guardar();
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
            if (ke.getKeyCode() == KeyEvent.VK_F4 && lo_pnl_opciones_3.BTN_eliminar.isEnabled()) {
                evt_eliminar();
            }
            if (ke.getKeyCode() == KeyEvent.VK_ESCAPE && lo_pnl_opciones_3.BTN_cancelar.isEnabled()) {
                evt_cancelar();
            }
            if (ke.getKeyCode() == KeyEvent.VK_F5) {
                if (ke.getSource() == lo_pnl_cab_guia_ingreso.TXT_codigo_movimiento) {
                    evt_f5_tipo_movimiento();
                }
                if (lo_pnl_grid_guia_ingreso.TBL_guia_ingreso.getSelectedColumn() == 2) {
                    evt_f5_articulo_costo();
                }
            }
            if (ke.getKeyCode() == KeyEvent.VK_F6 && lo_pnl_opciones_3.BTN_guardar.isEnabled()) {
                evt_guardar();
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
                if (ke.getSource() == lo_pnl_opciones_3.BTN_guardar) {
                    evt_guardar();
                }
                if (ke.getSource() == lo_pnl_opciones_3.BTN_cancelar) {
                    evt_cancelar();
                    
                }
                if (ke.getSource() == lo_pnl_cab_guia_ingreso.TXT_codigo_movimiento && go_fnc_operaciones_campos.campo_blanco(lo_pnl_cab_guia_ingreso.TXT_codigo_movimiento)) {
                    lo_pnl_cab_guia_ingreso.TXT_codigo_movimiento.setText(go_fnc_operaciones_campos.completa_digitos(lo_pnl_cab_guia_ingreso.TXT_codigo_movimiento.getText().trim(), "0", 2));
                    if (li_tipo_operacion == 1) {
                        lo_pnl_cab_guia_ingreso.CBX_tipo_doc_ref.requestFocus();
                    } else {
                        lo_pnl_cab_guia_ingreso.TXT_numero.requestFocus();
                    }
                    get_descripcion_tipo_movimiento(lo_pnl_cab_guia_ingreso.TXT_codigo_movimiento.getText().trim());
                }
                if (ke.getSource() == lo_pnl_cab_guia_ingreso.TXT_numero) {
                    if (go_fnc_operaciones_campos.campo_blanco(lo_pnl_cab_guia_ingreso.TXT_numero)) {
                        lo_pnl_cab_guia_ingreso.TXT_numero.setText(go_fnc_operaciones_campos.completa_digitos(lo_pnl_cab_guia_ingreso.TXT_numero.getText().trim(), "0", 10));
                        lo_pnl_cab_guia_ingreso.LBL_numero_doc.setText(lo_pnl_cab_guia_ingreso.TXT_numero.getText());
                        lo_pnl_cab_guia_ingreso.CBX_tipo_doc_ref.requestFocus();
                    }
                }
                if (ke.getSource() == lo_pnl_cab_guia_ingreso.CBX_tipo_doc_ref) {
                    lo_pnl_cab_guia_ingreso.TXT_serie_ref.requestFocus();
                }
                if (ke.getSource() == lo_pnl_cab_guia_ingreso.TXT_serie_ref) {
                    if (go_fnc_operaciones_campos.campo_blanco(lo_pnl_cab_guia_ingreso.TXT_serie_ref)) {
                        lo_pnl_cab_guia_ingreso.TXT_serie_ref.setText(go_fnc_operaciones_campos.completa_digitos(lo_pnl_cab_guia_ingreso.TXT_serie_ref.getText().trim(), "0", 4));
                        lo_pnl_cab_guia_ingreso.TXT_numero_ref.requestFocus();
                    }
                }
                if (ke.getSource() == lo_pnl_cab_guia_ingreso.TXT_numero_ref) {
                    if (go_fnc_operaciones_campos.campo_blanco(lo_pnl_cab_guia_ingreso.TXT_numero_ref)) {
                        lo_pnl_cab_guia_ingreso.TXT_numero_ref.setText(go_fnc_operaciones_campos.completa_digitos(lo_pnl_cab_guia_ingreso.TXT_numero_ref.getText().trim(), "0", 10));
                        lo_pnl_cab_guia_ingreso.TXT_fecha_emision.requestFocus();
                    }
                }
                if (ke.getSource() == lo_pnl_cab_guia_ingreso.TXT_fecha_emision && !lo_pnl_cab_guia_ingreso.TXT_fecha_emision.getText().trim().equalsIgnoreCase("/  /")) {
                    if (go_fnc_operaciones_campos.valida_fecha(lo_pnl_cab_guia_ingreso.TXT_fecha_emision.getText())) {
                        if (lo_pnl_cab_guia_ingreso.TXT_fecha_emision.getText().trim().substring(6, 10).equalsIgnoreCase(gs_periodo)) {
                            getFocusOwner().transferFocus();
                        } else {
                            lo_pnl_cab_guia_ingreso.TXT_fecha_emision.setText("");
                            go_fnc_mensaje.GET_mensaje(0, ls_modulo, ls_capa, ls_clase, "keyPressed", "FECHA NO PERTENECE AL PERIODO");
                        }
                    } else {
                        lo_pnl_cab_guia_ingreso.TXT_fecha_emision.setText("");
                        go_fnc_mensaje.GET_mensaje(0, ls_modulo, ls_capa, ls_clase, "keyPressed", "FORMATO DE FECHA INVALIDO");
                    }
                }
                if (ke.getSource() == lo_pnl_cab_guia_ingreso.TXT_lote) {
                    if (go_fnc_operaciones_campos.campo_blanco(lo_pnl_cab_guia_ingreso.TXT_lote)) {
                        lo_pnl_cab_guia_ingreso.TXT_lote.setText(go_fnc_operaciones_campos.completa_digitos(lo_pnl_cab_guia_ingreso.TXT_lote.getText().trim(), "0", 6));
                        if (go_dao_kardex_detalle.FNC_verifica_lote(ls_codigo_almacen, lo_pnl_cab_guia_ingreso.TXT_lote.getText().trim()) == 0 || li_tipo_operacion == 1) {
                            lo_pnl_cab_guia_ingreso.TXT_observacion.requestFocus();
                        } else {
                            go_fnc_mensaje.GET_mensaje(0, ls_modulo, ls_capa, ls_clase, "keyPressed", "LOTE REGISTRADO");
                            lo_pnl_cab_guia_ingreso.TXT_lote.setText("");
                        }
                        lo_evt_grid_guia_ingreso.actualiza_lote(lo_pnl_grid_guia_ingreso, lo_pnl_cab_guia_ingreso.TXT_lote.getText().trim());
                    }
                }
                if (ke.getSource() == lo_pnl_cab_guia_ingreso.TXT_observacion) {
                    if (lo_pnl_grid_guia_ingreso.TBL_guia_ingreso.getRowCount() == 0) {
                        lo_pnl_grid_guia_ingreso.TBL_guia_ingreso.requestFocus();
                        lo_evt_grid_guia_ingreso.agrega_fila(lo_pnl_grid_guia_ingreso, -1, lo_pnl_cab_guia_ingreso.TXT_lote.getText().trim());
                    } else {
                        lo_pnl_grid_guia_ingreso.TBL_guia_ingreso.requestFocus();
                        lo_evt_grid_guia_ingreso.actualiza_lote(lo_pnl_grid_guia_ingreso, lo_pnl_cab_guia_ingreso.TXT_lote.getText().trim());
                        lo_pnl_grid_guia_ingreso.TBL_guia_ingreso.changeSelection(0, 2, false, false);
                    }
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent ke) {
            if (ke.getSource() == lo_pnl_cab_guia_ingreso.TXT_numero) {
                lo_pnl_cab_guia_ingreso.LBL_numero_doc.setText(lo_pnl_cab_guia_ingreso.TXT_numero.getText());
            }
            if (ke.getSource() == lo_pnl_grid_guia_ingreso.TBL_guia_ingreso) {
                if (ke.getKeyCode() == KeyEvent.VK_ENTER || ke.getKeyCode() == KeyEvent.VK_TAB) {
                    int fila = lo_pnl_grid_guia_ingreso.TBL_guia_ingreso.getSelectedRow();
                    genera_peso_neto(fila);

                    if (lo_pnl_grid_guia_ingreso.TBL_guia_ingreso.getSelectedColumn() == 2) {
                        if (lo_pnl_grid_guia_ingreso.TBL_guia_ingreso.getValueAt(fila, 1).toString().trim().equalsIgnoreCase("")) {
                            lo_pnl_grid_guia_ingreso.TBL_guia_ingreso.changeSelection(fila, 1, false, false);
                            lo_pnl_grid_guia_ingreso.TBL_guia_ingreso.editCellAt(fila, 1);
                        } else {
                            String lote = go_fnc_operaciones_campos.completa_digitos(lo_pnl_grid_guia_ingreso.TBL_guia_ingreso.getValueAt(fila, 1) + "", "0", 6);
                            lo_pnl_grid_guia_ingreso.TBL_guia_ingreso.setValueAt(lote, fila, 1);
                        }
                    }

                    if (lo_pnl_grid_guia_ingreso.TBL_guia_ingreso.getSelectedColumn() == 3) {
                        if (lo_pnl_grid_guia_ingreso.TBL_guia_ingreso.getValueAt(fila, 2).toString().trim().equalsIgnoreCase("")) {
                            lo_pnl_grid_guia_ingreso.TBL_guia_ingreso.changeSelection(fila, 2, false, false);
                        } else {
                            lo_pnl_grid_guia_ingreso.TBL_guia_ingreso.changeSelection(fila, 7, false, false);
                            lo_pnl_grid_guia_ingreso.TBL_guia_ingreso.editCellAt(fila, 7);
                        }
                    }
                    if (lo_pnl_grid_guia_ingreso.TBL_guia_ingreso.getSelectedColumn() == 8) {
                        if (lo_pnl_grid_guia_ingreso.TBL_guia_ingreso.getValueAt(fila, 7) == null) {
                            lo_pnl_grid_guia_ingreso.TBL_guia_ingreso.setValueAt(0, fila, 7);
                            //lo_pnl_grid_guia_ingreso.TBL_guia_ingreso.changeSelection(fila, 7, false, false);
                        }
                    }
                    if (lo_pnl_grid_guia_ingreso.TBL_guia_ingreso.getSelectedColumn() == 9) {
                        if (lo_pnl_grid_guia_ingreso.TBL_guia_ingreso.getValueAt(fila, 8) == null) {
                            lo_pnl_grid_guia_ingreso.TBL_guia_ingreso.changeSelection(fila, 8, false, false);
                        } else if ((Double) lo_pnl_grid_guia_ingreso.TBL_guia_ingreso.getValueAt(fila, 8) == 0) {
                            lo_pnl_grid_guia_ingreso.TBL_guia_ingreso.setValueAt(null, fila, 8);
                            lo_pnl_grid_guia_ingreso.TBL_guia_ingreso.changeSelection(fila, 8, false, false);
                        }
                    }
                    if (lo_pnl_grid_guia_ingreso.TBL_guia_ingreso.getSelectedColumn() == 10) {
                        lo_evt_grid_guia_ingreso.agrega_fila(lo_pnl_grid_guia_ingreso, fila, lo_pnl_cab_guia_ingreso.TXT_lote.getText().trim());
                    }
                }
            }
        }
    };

    MouseListener MouseEvent = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent me) {
            if (me.getSource() == lo_pnl_grid_guia_ingreso.TBL_guia_ingreso && lo_pnl_grid_guia_ingreso.TBL_guia_ingreso.isEnabled()) {
                int columna = lo_pnl_grid_guia_ingreso.TBL_guia_ingreso.getColumnModel().getColumnIndexAtX(me.getX());
                int fila = me.getY() / lo_pnl_grid_guia_ingreso.TBL_guia_ingreso.getRowHeight();
                Object value = lo_pnl_grid_guia_ingreso.TBL_guia_ingreso.getValueAt(fila, columna);
                if (value instanceof JButton) {
                    if (go_fnc_mensaje.get_respuesta(0, "¿DESEA ELIMINAR ITEM " + go_fnc_operaciones_campos.completa_digitos((fila + 1) + "", "0", 3) + "?") == 0) {
                        lo_evt_grid_guia_ingreso.elimina_fila(lo_pnl_grid_guia_ingreso, fila);
                        lo_evt_grid_guia_ingreso.genera_item(lo_pnl_grid_guia_ingreso);
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

    TableModelListener TablaListener = new TableModelListener() {

        @Override
        public void tableChanged(TableModelEvent tme) {
            if (tme.getType() == TableModelEvent.UPDATE && li_tipo_operacion == 1) {
                cont++;
            }
        }
    };

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setClosable(true);
        setIconifiable(true);
        setTitle("INGRESO MERCADERIA");
        setToolTipText("");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/JAVA/ANCESTRO/IMAGES/formulario.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 920, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 558, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
