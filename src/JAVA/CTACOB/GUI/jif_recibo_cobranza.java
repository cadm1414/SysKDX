package JAVA.CTACOB.GUI;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.ANCESTRO.GUI.pnl_opciones_3;
import JAVA.ANCESTRO.LOGICA.evt_opciones_3;
import JAVA.ANCESTRO.LOGICA.recupera_valor_op;
import JAVA.CONFIG.LOGICA.cbx_moneda;
import JAVA.CTACOB.BEAN.BEAN_recibo_cobranza;
import JAVA.CTACOB.LOGICA.cbx_banco;
import JAVA.CTACOB.LOGICA.evt_cab_recibo_cobranza;
import JAVA.CTACOB.LOGICA.evt_grid_recibo_cobranza;
import JAVA.DISTBR.GUI.dlg_busq_programacion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
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

public class jif_recibo_cobranza extends javax.swing.JInternalFrame {

    pnl_opciones_3 lo_pnl_opciones_3 = new pnl_opciones_3();
    evt_opciones_3 lo_evt_opciones_3 = new evt_opciones_3();
    pnl_cab_recibo_cobranza lo_pnl_cab_recibo_cobranza = new pnl_cab_recibo_cobranza();
    evt_cab_recibo_cobranza lo_evt_cab_recibo_cobranza = new evt_cab_recibo_cobranza();
    pnl_grid_recibo_cobranza lo_pnl_grid_recibo_cobranza = new pnl_grid_recibo_cobranza();
    evt_grid_recibo_cobranza lo_evt_grid_recibo_cobranza = new evt_grid_recibo_cobranza();
    recupera_valor_op lo_recupera_valor_op = new recupera_valor_op();
    BEAN_recibo_cobranza lo_bean_recibo_cobranza = new BEAN_recibo_cobranza();
    static boolean lb_valor_op[] = new boolean[8];
    DefaultTableModel modelo, modelo_retorno;
    ResultSet lq_rs;
    cbx_moneda lo_cbx_moneda;
    cbx_banco lo_cbx_banco;
    int li_tipo_operacion, li_cantidad, cont = 0;
    double ld_tipo_cambio;
    String ls_codigo_sucursal, ls_serie, ls_codigo,ls_codigo_pr,ls_fecha_ref;
    String ls_opcion = "M A A";
    String ls_modulo = "CTACOB", ls_capa = "GUI", ls_clase = "jif_recibo_cobranza";

    public jif_recibo_cobranza() {
        initComponents();
        formulario();
        activa_botones();
        get_moneda();
        get_banco();
        lo_pnl_grid_recibo_cobranza.TBL_cobranza.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "selectNextColumnCell");
    }

    private void formulario() {
        lo_pnl_opciones_3.setBounds(0, 10, 1000, 120);
        lo_pnl_cab_recibo_cobranza.setBounds(12, 130, 1000, 240);
        lo_pnl_grid_recibo_cobranza.setBounds(15, 370, 1000, 280);

        this.add(lo_pnl_opciones_3);
        this.add(lo_pnl_cab_recibo_cobranza);
        this.add(lo_pnl_grid_recibo_cobranza);

        ls_codigo_sucursal = gs_parametros[0];
        ls_serie = gs_parametros[2];
        lo_pnl_cab_recibo_cobranza.TXT_sucursal.setText(gs_parametros[1]);
        lo_pnl_cab_recibo_cobranza.TXT_serie.setText(gs_parametros[2]);

        gs_parametros[0] = "";
        gs_parametros[1] = "";
        gs_parametros[2] = "";

        li_cantidad = go_dao_serie.SLT_cant_items(ls_serie, ls_codigo_sucursal, 6);
        modelo = (DefaultTableModel) lo_pnl_grid_recibo_cobranza.TBL_cobranza.getModel();
        modelo.addTableModelListener(TablaListener);

        lo_evt_cab_recibo_cobranza.evento_press(lo_pnl_cab_recibo_cobranza, KeyEvnt);
        lo_evt_cab_recibo_cobranza.evento_item(lo_pnl_cab_recibo_cobranza, ItemEvent);
        lo_evt_opciones_3.evento_click(lo_pnl_opciones_3, Listener);
        lo_evt_opciones_3.evento_press(lo_pnl_opciones_3, KeyEvnt);
        lo_evt_grid_recibo_cobranza.evento_press(lo_pnl_grid_recibo_cobranza, KeyEvnt);
        lo_pnl_grid_recibo_cobranza.TBL_cobranza.addMouseListener(MouseEvent);
    }

    private void activa_botones() {
        lb_valor_op = lo_recupera_valor_op.recupera(ls_modulo, ls_opcion);
        lo_evt_opciones_3.activa_btn_opciones(0, lo_pnl_opciones_3, lb_valor_op);
    }

    private void get_banco() {
        lq_rs = go_dao_banco.SLT_cbx_moneda();
        if (lq_rs != null) {
            go_cbx_trato_datos.recupera_valor(17, lq_rs, lo_pnl_cab_recibo_cobranza.CBX_banco);
        }
    }

    private void get_moneda() {
        lq_rs = go_dao_moneda.SLT_moneda_x_visible("S");
        if (lq_rs != null) {
            go_cbx_trato_datos.recupera_valor(0, lq_rs, lo_pnl_cab_recibo_cobranza.CBX_moneda);
        }
    }

    private void get_tipo_cambio() {
        lo_cbx_moneda = (cbx_moneda) lo_pnl_cab_recibo_cobranza.CBX_moneda.getSelectedItem();
        lo_pnl_grid_recibo_cobranza.LBL_simbolo.setText(lo_cbx_moneda.simbolo_moneda().trim());
        try {
            ld_tipo_cambio = go_dao_tipo_cambio.SLT_tipo_cambio_monto("0", "USD", lo_pnl_cab_recibo_cobranza.TXT_fecha_emision.getText());
            lo_pnl_cab_recibo_cobranza.TXT_tipo_cambio.setText(ld_tipo_cambio + "");
        } catch (Exception e) {
        }
    }

    private void get_descripcion_recibo_cobranza(String codigo) {
        try {
            lq_rs = go_dao_recibo_cobranza.SLT_datos_recibo_cobranza(codigo);
            if (lq_rs != null) {
                lo_evt_cab_recibo_cobranza.setea_recupera(lo_bean_recibo_cobranza, lq_rs);
                lo_evt_cab_recibo_cobranza.muestra_datos(lo_pnl_cab_recibo_cobranza, lo_bean_recibo_cobranza, lo_pnl_grid_recibo_cobranza);
                lo_cbx_moneda = (cbx_moneda) lo_pnl_cab_recibo_cobranza.CBX_moneda.getSelectedItem();
                lo_pnl_grid_recibo_cobranza.LBL_simbolo.setText(lo_cbx_moneda.simbolo_moneda().trim());
                get_descripcion_recibo_cobranza_detalle(codigo);
            }
        } catch (Exception e) {
        }
    }

    private void get_descripcion_recibo_cobranza_detalle(String codigo) {
        lo_evt_grid_recibo_cobranza.limpia_tabla(lo_pnl_grid_recibo_cobranza, li_tipo_operacion);
        lq_rs = go_dao_recibo_cobranza_detalle.SLT_datos_recibo_cobranza_detalle(codigo);
        lo_evt_grid_recibo_cobranza.recupera_detalle(lq_rs, lo_pnl_grid_recibo_cobranza);
    }

    private void genera_saldo(int fila) {
        try {
            double saldo = (double) lo_pnl_grid_recibo_cobranza.TBL_cobranza.getValueAt(fila, 8) - (double) lo_pnl_grid_recibo_cobranza.TBL_cobranza.getValueAt(fila, 9);
            lo_pnl_grid_recibo_cobranza.TBL_cobranza.setValueAt(saldo, fila, 10);
        } catch (Exception e) {
        }
    }

    private void genera_parametros_busq() {
        gs_parametros[0] = ls_codigo_sucursal;
        gs_parametros[1] = "01/" + gs_mes + "/" + gs_periodo;
        gs_parametros[2] = gs_dia + "/" + gs_mes + "/" + gs_periodo;
    }
    
    private void genera_parametros_busq_pr() {
        gs_parametros[0] = ls_codigo_sucursal;
        gs_parametros[1] = "01/" + gs_mes + "/" + gs_periodo;
        gs_parametros[2] = gs_dia + "/" + gs_mes + "/" + gs_periodo;
        gs_parametros[3] = "%";
    }

    private void evt_f5_entidad() {
        go_activa_buscador.busq_entidad(lo_pnl_cab_recibo_cobranza.TXT_codigo_pagador, lo_pnl_cab_recibo_cobranza.TXT_nombre_pagador);
    }

    private void evt_f5_saldos() {
        if (go_fnc_operaciones_campos.cant_caracter(lo_pnl_cab_recibo_cobranza.TXT_codigo_pagador.getText().trim(), 4, 6) && go_fnc_operaciones_campos.campo_blanco(lo_pnl_cab_recibo_cobranza.TXT_codigo_pagador)) {
            gs_parametros[0] = ls_codigo_sucursal;
            gs_parametros[1] = lo_pnl_cab_recibo_cobranza.TXT_codigo_pagador.getText().trim();
            gs_parametros[2] = "31/12/" + gs_periodo;
            gi_parametros_2[0] = li_cantidad;
            go_dlg_datos_seleccion_saldos = new dlg_datos_seleccion_saldos(null, true);
            go_dlg_datos_seleccion_saldos.setVisible(true);
            modelo_retorno = go_dlg_datos_seleccion_saldos.modelo;
            if (modelo_retorno.getRowCount() > 0) {
                for (int x = 0; x < modelo_retorno.getRowCount(); x++) {
                    modelo.setValueAt(modelo_retorno.getValueAt(x, 0).toString(), x, 0);
                    modelo.setValueAt(modelo_retorno.getValueAt(x, 1).toString(), x, 1);
                    modelo.setValueAt(modelo_retorno.getValueAt(x, 2).toString(), x, 3);
                    modelo.setValueAt(modelo_retorno.getValueAt(x, 3).toString(), x, 4);
                    modelo.setValueAt(modelo_retorno.getValueAt(x, 4).toString(), x, 5);
                    modelo.setValueAt(modelo_retorno.getValueAt(x, 5).toString(), x, 6);
                    modelo.setValueAt(modelo_retorno.getValueAt(x, 6).toString(), x, 7);
                    modelo.setValueAt(Double.parseDouble(modelo_retorno.getValueAt(x, 7).toString()), x, 8);
                    if (x + 1 < modelo_retorno.getRowCount()) {
                        lo_evt_grid_recibo_cobranza.agrega_fila(lo_pnl_grid_recibo_cobranza, lo_pnl_grid_recibo_cobranza.TBL_cobranza.getSelectedRow(), li_cantidad);
                    }
                }
                lo_pnl_grid_recibo_cobranza.TBL_cobranza.changeSelection(0, 9, false, false);
            }
        } else {
            lo_pnl_cab_recibo_cobranza.TXT_codigo_pagador.setText("");
            lo_pnl_cab_recibo_cobranza.TXT_nombre_pagador.setText("");
            go_fnc_mensaje.GET_mensaje(0, ls_modulo, ls_capa, ls_clase, "evt_f5_saldos", "INGRESE CLIENTE");
            lo_pnl_cab_recibo_cobranza.TXT_codigo_pagador.requestFocus();
        }
    }
    
    private void evt_f5_pr() {
        genera_parametros_busq_pr();
        go_dlg_busq_programacion = new dlg_busq_programacion(null, true);
        go_dlg_busq_programacion.setVisible(true);
        ls_codigo_pr = go_dlg_busq_programacion.ls_codigo;
        ls_fecha_ref =  gs_parametros[0];
        if (ls_codigo_pr != null) {
            lo_pnl_cab_recibo_cobranza.TXT_numero_op.setText(ls_codigo_pr);
            lo_pnl_cab_recibo_cobranza.TXT_fecha_op.setText(ls_fecha_ref);            
        }
        gs_parametros[0] = "";
    }

    private void evt_nuevo() {
        ls_codigo = null;
        lo_evt_cab_recibo_cobranza.limpia_datos(lo_pnl_cab_recibo_cobranza);
        lo_evt_grid_recibo_cobranza.limpia_tabla(lo_pnl_grid_recibo_cobranza, li_tipo_operacion);
        get_tipo_cambio();
        li_tipo_operacion = 0;
        try {
            lq_rs = go_dao_recibo_cobranza.FNC_correlativo_recibo_cobranza("RC", ls_serie, ls_codigo_sucursal);
            if (lq_rs.next()) {
                lo_pnl_cab_recibo_cobranza.TXT_numero_doc.setText(lq_rs.getString(1));
                lo_pnl_cab_recibo_cobranza.LBL_numero_doc.setText(lq_rs.getString(1));
            }
        } catch (Exception e) {
        }

        lo_evt_cab_recibo_cobranza.activa_campos(0, lo_pnl_cab_recibo_cobranza, true);
        lo_evt_opciones_3.activa_btn_opciones(1, lo_pnl_opciones_3, lb_valor_op);
        lo_evt_grid_recibo_cobranza.activa_campos(0, lo_pnl_grid_recibo_cobranza, true);
    }

    private void evt_buscar() {
        li_tipo_operacion = 2;
        genera_parametros_busq();
        go_dlg_busq_recibo_cobranza = new dlg_busq_recibo_cobranza(null, true);
        go_dlg_busq_recibo_cobranza.setVisible(true);
        ls_codigo = go_dlg_busq_recibo_cobranza.ls_codigo;
        if (ls_codigo != null) {
            get_descripcion_recibo_cobranza(ls_codigo);
            lo_evt_opciones_3.activa_btn_opciones(2, lo_pnl_opciones_3, lb_valor_op);
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_buscar", "SELECCIONE DOCUMENTO");
            lo_evt_cab_recibo_cobranza.limpia_datos(lo_pnl_cab_recibo_cobranza);
            lo_evt_grid_recibo_cobranza.limpia_tabla(lo_pnl_grid_recibo_cobranza, li_tipo_operacion);
            lo_evt_opciones_3.activa_btn_opciones(0, lo_pnl_opciones_3, lb_valor_op);
        }
    }

    private void evt_editar() {
        li_tipo_operacion = 1;
        cont = 0;
        lo_evt_opciones_3.activa_btn_opciones(3, lo_pnl_opciones_3, lb_valor_op);
        lo_evt_cab_recibo_cobranza.activa_campos(1, lo_pnl_cab_recibo_cobranza, true);
        lo_evt_grid_recibo_cobranza.activa_campos(0, lo_pnl_grid_recibo_cobranza, true);
    }

    private void evt_eliminar() {
        if (go_fnc_mensaje.get_respuesta(0, "¿DESEA ELIMINAR DOCUMENTO Nro RC-" + lo_bean_recibo_cobranza.getNumero_documento() + "?") == 0) {
            try {
                if (go_dao_recibo_cobranza_detalle.DLT_recibo_cobranza_detalle(ls_codigo)) {
                    if (go_dao_recibo_cobranza.DLT_recibo_cobranza(ls_codigo)) {
                        lo_evt_opciones_3.activa_btn_opciones(0, lo_pnl_opciones_3, lb_valor_op);
                        lo_evt_cab_recibo_cobranza.activa_campos(0, lo_pnl_cab_recibo_cobranza, false);
                        lo_evt_cab_recibo_cobranza.limpia_datos(lo_pnl_cab_recibo_cobranza);
                        lo_evt_grid_recibo_cobranza.activa_campos(0, lo_pnl_grid_recibo_cobranza, false);
                        lo_evt_grid_recibo_cobranza.limpia_tabla(lo_pnl_grid_recibo_cobranza, li_tipo_operacion);
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    private void evt_guardar() {
        lo_cbx_moneda = (cbx_moneda) lo_pnl_cab_recibo_cobranza.CBX_moneda.getSelectedItem();
        lo_cbx_banco = (cbx_banco) lo_pnl_cab_recibo_cobranza.CBX_banco.getSelectedItem();
        switch (li_tipo_operacion) {
            case 0:
                if (lo_evt_cab_recibo_cobranza.valida_campos(lo_pnl_cab_recibo_cobranza, lo_cbx_moneda)) {
                    if (lo_evt_grid_recibo_cobranza.valida_campos(lo_pnl_grid_recibo_cobranza, li_cantidad)) {
                        try {
                            ls_codigo = "RC" + ls_codigo_sucursal + lo_pnl_cab_recibo_cobranza.TXT_numero_doc.getText().trim();
                            lo_bean_recibo_cobranza.setCodigo_operacion(ls_codigo);
                            lo_bean_recibo_cobranza.setCodigo_sucursal(ls_codigo_sucursal);
                            lo_evt_cab_recibo_cobranza.setea_campos(lo_bean_recibo_cobranza, lo_pnl_cab_recibo_cobranza, lo_cbx_moneda, lo_cbx_banco, lo_pnl_grid_recibo_cobranza);
                            if (go_dao_recibo_cobranza.IST_recibo_cobranza(lo_bean_recibo_cobranza, lo_pnl_grid_recibo_cobranza.TBL_cobranza)) {
                                lo_evt_cab_recibo_cobranza.limpia_datos(lo_pnl_cab_recibo_cobranza);
                                lo_evt_cab_recibo_cobranza.activa_campos(0, lo_pnl_cab_recibo_cobranza, false);
                                lo_evt_grid_recibo_cobranza.limpia_tabla(lo_pnl_grid_recibo_cobranza, li_tipo_operacion);
                                lo_evt_grid_recibo_cobranza.activa_campos(0, lo_pnl_grid_recibo_cobranza, false);
                                lo_evt_opciones_3.activa_btn_opciones(0, lo_pnl_opciones_3, lb_valor_op);
                            }
                        } catch (Exception e) {
                        }
                    }
                }
                break;
            case 1:
                if (lo_evt_cab_recibo_cobranza.verifica_cambios(lo_bean_recibo_cobranza, lo_pnl_cab_recibo_cobranza, lo_cbx_moneda, lo_cbx_banco) || cont != 0) {
                    if (lo_evt_cab_recibo_cobranza.valida_campos(lo_pnl_cab_recibo_cobranza, lo_cbx_moneda)) {
                        if (lo_evt_grid_recibo_cobranza.valida_campos(lo_pnl_grid_recibo_cobranza, li_cantidad)) {
                            try {
                                lo_evt_cab_recibo_cobranza.setea_campos(lo_bean_recibo_cobranza, lo_pnl_cab_recibo_cobranza, lo_cbx_moneda, lo_cbx_banco, lo_pnl_grid_recibo_cobranza);
                                if (go_dao_recibo_cobranza_detalle.DLT_recibo_cobranza_detalle(ls_codigo)) {
                                    if (go_dao_recibo_cobranza.UPD_recibo_cobranza(lo_bean_recibo_cobranza, lo_pnl_grid_recibo_cobranza.TBL_cobranza)) {
                                        lo_evt_cab_recibo_cobranza.limpia_datos(lo_pnl_cab_recibo_cobranza);
                                        lo_evt_cab_recibo_cobranza.activa_campos(0, lo_pnl_cab_recibo_cobranza, false);
                                        lo_evt_grid_recibo_cobranza.limpia_tabla(lo_pnl_grid_recibo_cobranza, li_tipo_operacion);
                                        lo_evt_grid_recibo_cobranza.activa_campos(0, lo_pnl_grid_recibo_cobranza, false);
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

    private void evt_cancelar() {
        li_tipo_operacion = 2;
        lo_evt_cab_recibo_cobranza.activa_campos(0, lo_pnl_cab_recibo_cobranza, false);
        lo_evt_grid_recibo_cobranza.activa_campos(0, lo_pnl_grid_recibo_cobranza, false);
        lo_evt_grid_recibo_cobranza.limpia_tabla(lo_pnl_grid_recibo_cobranza, li_tipo_operacion);
        if (ls_codigo != null) {
            lo_evt_cab_recibo_cobranza.muestra_datos(lo_pnl_cab_recibo_cobranza, lo_bean_recibo_cobranza, lo_pnl_grid_recibo_cobranza);
            get_descripcion_recibo_cobranza_detalle(ls_codigo);
            lo_evt_opciones_3.activa_btn_opciones(2, lo_pnl_opciones_3, lb_valor_op);
        } else {
            lo_evt_cab_recibo_cobranza.limpia_datos(lo_pnl_cab_recibo_cobranza);
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
            if (ae.getSource() == lo_pnl_opciones_3.BTN_imprimir) {
                //evt_imprimir(lo_bean_pedido.getStatus(), lo_bean_pedido.getCodigo_operacion());
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
            if (ke.getKeyCode() == KeyEvent.VK_F6 && lo_pnl_opciones_3.BTN_guardar.isEnabled()) {
                evt_guardar();
            }
            if (ke.getKeyCode() == KeyEvent.VK_F5) {
                if (ke.getSource() == lo_pnl_cab_recibo_cobranza.TXT_codigo_pagador) {
                    evt_f5_entidad();
                }
                if (ke.getSource() == lo_pnl_grid_recibo_cobranza.TBL_cobranza && lo_pnl_grid_recibo_cobranza.TBL_cobranza.getSelectedColumn() == 3) {
                    evt_f5_saldos();
                }
                if(ke.getSource() == lo_pnl_cab_recibo_cobranza.TXT_numero_op && lo_pnl_cab_recibo_cobranza.CBX_forma_pago.getSelectedIndex()==3){
                    evt_f5_pr();
                }
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
                if (ke.getSource() == lo_pnl_opciones_3.BTN_imprimir) {
                    //evt_imprimir(lo_bean_pedido.getStatus(), lo_bean_pedido.getCodigo_operacion());
                }
                if (ke.getSource() == lo_pnl_cab_recibo_cobranza.TXT_numero_doc) {
                    if (go_fnc_operaciones_campos.campo_blanco(lo_pnl_cab_recibo_cobranza.TXT_numero_doc)) {
                        lo_pnl_cab_recibo_cobranza.TXT_numero_doc.setText(go_fnc_operaciones_campos.completa_digitos(lo_pnl_cab_recibo_cobranza.TXT_numero_doc.getText().trim(), "0", 10));
                        lo_pnl_cab_recibo_cobranza.LBL_numero_doc.setText(lo_pnl_cab_recibo_cobranza.TXT_numero_doc.getText());
                        lo_pnl_cab_recibo_cobranza.TXT_fecha_emision.requestFocus();
                    }
                }
                if (ke.getSource() == lo_pnl_cab_recibo_cobranza.TXT_fecha_emision && !lo_pnl_cab_recibo_cobranza.TXT_fecha_emision.getText().trim().equalsIgnoreCase("/  /")) {
                    if (go_fnc_operaciones_campos.valida_fecha(lo_pnl_cab_recibo_cobranza.TXT_fecha_emision.getText())) {
                        if (go_fnc_operaciones_campos.valida_periodo(lo_pnl_cab_recibo_cobranza.TXT_fecha_emision.getText(), gs_periodo)) {
                            get_tipo_cambio();
                            getFocusOwner().transferFocus();
                        } else {
                            lo_pnl_cab_recibo_cobranza.TXT_fecha_emision.setText("");
                            go_fnc_mensaje.GET_mensaje(0, ls_modulo, ls_capa, ls_clase, "keyPressed", "FECHA NO PERTENECE AL PERIODO");
                        }
                    } else {
                        lo_pnl_cab_recibo_cobranza.TXT_fecha_emision.setText("");
                        go_fnc_mensaje.GET_mensaje(0, ls_modulo, ls_capa, ls_clase, "keyPressed", "FORMATO DE FECHA INVALIDO");
                    }
                }
                if (ke.getSource() == lo_pnl_cab_recibo_cobranza.CBX_moneda) {
                    lo_pnl_cab_recibo_cobranza.TXT_codigo_pagador.requestFocus();
                }
                if (ke.getSource() == lo_pnl_cab_recibo_cobranza.TXT_tipo_cambio && go_fnc_operaciones_campos.campo_blanco(lo_pnl_cab_recibo_cobranza.TXT_tipo_cambio)) {
                    getFocusOwner().transferFocus();
                }
                if (ke.getSource() == lo_pnl_cab_recibo_cobranza.TXT_codigo_pagador && go_fnc_operaciones_campos.cant_caracter(lo_pnl_cab_recibo_cobranza.TXT_codigo_pagador.getText().trim(), 4, 6)) {
                    getFocusOwner().transferFocus();
                    go_activa_buscador.get_descripcion_entidad(lo_pnl_cab_recibo_cobranza.TXT_codigo_pagador.getText().trim(), lo_pnl_cab_recibo_cobranza.TXT_codigo_pagador, lo_pnl_cab_recibo_cobranza.TXT_nombre_pagador);
                }
                if (ke.getSource() == lo_pnl_cab_recibo_cobranza.CBX_forma_pago || ke.getSource() == lo_pnl_cab_recibo_cobranza.CBX_banco || ke.getSource() == lo_pnl_cab_recibo_cobranza.TXT_observacion) {
                    getFocusOwner().transferFocus();
                }
                if (ke.getSource() == lo_pnl_cab_recibo_cobranza.TXT_numero_op) {
                    if (go_fnc_operaciones_campos.campo_blanco(lo_pnl_cab_recibo_cobranza.TXT_numero_op)) {
                        lo_pnl_cab_recibo_cobranza.TXT_numero_op.setText(go_fnc_operaciones_campos.completa_digitos(lo_pnl_cab_recibo_cobranza.TXT_numero_op.getText().trim(), "0", 12));
                        getFocusOwner().transferFocus();
                    }
                }
                if (ke.getSource() == lo_pnl_cab_recibo_cobranza.TXT_fecha_op && !lo_pnl_cab_recibo_cobranza.TXT_fecha_op.getText().trim().equalsIgnoreCase("/  /")) {
                    if (go_fnc_operaciones_campos.valida_fecha(lo_pnl_cab_recibo_cobranza.TXT_fecha_op.getText())) {
                        getFocusOwner().transferFocus();
                    } else {
                        lo_pnl_cab_recibo_cobranza.TXT_fecha_op.setText("");
                        go_fnc_mensaje.GET_mensaje(0, ls_modulo, ls_capa, ls_clase, "keyPressed", "FORMATO DE FECHA INVALIDO");
                    }
                }
                if (ke.getSource() == lo_pnl_cab_recibo_cobranza.JRD_rendido) {
                    if (lo_pnl_grid_recibo_cobranza.TBL_cobranza.getRowCount() == 0) {
                        lo_pnl_grid_recibo_cobranza.TBL_cobranza.requestFocus();
                        lo_evt_grid_recibo_cobranza.agrega_fila(lo_pnl_grid_recibo_cobranza, -1, li_cantidad);
                    } else {
                        lo_pnl_grid_recibo_cobranza.TBL_cobranza.requestFocus();
                        lo_pnl_grid_recibo_cobranza.TBL_cobranza.changeSelection(0, 1, false, false);
                    }
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent ke) {
            if (ke.getSource() == lo_pnl_cab_recibo_cobranza.TXT_numero_doc) {
                lo_pnl_cab_recibo_cobranza.LBL_numero_doc.setText(lo_pnl_cab_recibo_cobranza.TXT_numero_doc.getText());
            }
            if (ke.getSource() == lo_pnl_grid_recibo_cobranza.TBL_cobranza) {
                int fila = lo_pnl_grid_recibo_cobranza.TBL_cobranza.getSelectedRow();
                lo_evt_grid_recibo_cobranza.suma_importes(lo_pnl_grid_recibo_cobranza);
                genera_saldo(fila);

                if (lo_pnl_grid_recibo_cobranza.TBL_cobranza.getSelectedColumn() == 4) {
                    if (lo_pnl_grid_recibo_cobranza.TBL_cobranza.getValueAt(fila, 3).toString().trim().equalsIgnoreCase("")) {
                        lo_pnl_grid_recibo_cobranza.TBL_cobranza.changeSelection(fila, 3, false, false);
                    } else {
                        lo_pnl_grid_recibo_cobranza.TBL_cobranza.changeSelection(fila, 9, false, false);
                    }
                }

                if (lo_pnl_grid_recibo_cobranza.TBL_cobranza.getSelectedColumn() == 10) {
                    if ((Double) lo_pnl_grid_recibo_cobranza.TBL_cobranza.getValueAt(fila, 9) == 0.00) {
                        lo_pnl_grid_recibo_cobranza.TBL_cobranza.setValueAt(0.00, fila, 9);
                        lo_pnl_grid_recibo_cobranza.TBL_cobranza.changeSelection(fila, 9, false, false);
                    }
                }

                if (lo_pnl_grid_recibo_cobranza.TBL_cobranza.getSelectedColumn() == 11) {
                    lo_evt_grid_recibo_cobranza.agrega_fila(lo_pnl_grid_recibo_cobranza, fila, li_cantidad);
                }
            }
        }
    };

    ItemListener ItemEvent = new ItemListener() {
        @Override
        public void itemStateChanged(java.awt.event.ItemEvent ie) {
            if (li_tipo_operacion != 2) {
                if (ie.getSource() == lo_pnl_cab_recibo_cobranza.CBX_moneda) {
                    get_tipo_cambio();
                }
                if (ie.getSource() == lo_pnl_cab_recibo_cobranza.CBX_forma_pago) {
                    switch (lo_pnl_cab_recibo_cobranza.CBX_forma_pago.getSelectedIndex()) {
                        case 0:
                            lo_pnl_cab_recibo_cobranza.CBX_banco.setEnabled(false);
                            lo_pnl_cab_recibo_cobranza.TXT_numero_op.setEnabled(false);
                            lo_pnl_cab_recibo_cobranza.TXT_fecha_op.setEnabled(false);
                            lo_pnl_cab_recibo_cobranza.TXT_numero_op.setText("0000000000000000");
                            break;
                        case 3:
                            lo_pnl_cab_recibo_cobranza.CBX_banco.setEnabled(false);
                            lo_pnl_cab_recibo_cobranza.TXT_numero_op.setEnabled(true);
                            lo_pnl_cab_recibo_cobranza.TXT_fecha_op.setEnabled(true);
                            lo_pnl_cab_recibo_cobranza.TXT_numero_op.setText("");
                            break;
                        default:
                            lo_pnl_cab_recibo_cobranza.CBX_banco.setEnabled(true);
                            lo_pnl_cab_recibo_cobranza.TXT_numero_op.setEnabled(true);
                            lo_pnl_cab_recibo_cobranza.TXT_fecha_op.setEnabled(true);
                            lo_pnl_cab_recibo_cobranza.TXT_numero_op.setText("");
                    }
                }
            }
        }
    };

    MouseListener MouseEvent = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent me) {
            if (me.getSource() == lo_pnl_grid_recibo_cobranza.TBL_cobranza && lo_pnl_grid_recibo_cobranza.TBL_cobranza.isEnabled()) {
                int columna = lo_pnl_grid_recibo_cobranza.TBL_cobranza.getColumnModel().getColumnIndexAtX(me.getX());
                int fila = me.getY() / lo_pnl_grid_recibo_cobranza.TBL_cobranza.getRowHeight();
                Object value = lo_pnl_grid_recibo_cobranza.TBL_cobranza.getValueAt(fila, columna);
                if (value instanceof JButton) {
                    if (go_fnc_mensaje.get_respuesta(0, "¿DESEA ELIMINAR ITEM " + go_fnc_operaciones_campos.completa_digitos((fila + 1) + "", "0", 3) + "?") == 0) {
                        lo_evt_grid_recibo_cobranza.elimina_fila(lo_pnl_grid_recibo_cobranza, fila);
                        lo_evt_grid_recibo_cobranza.genera_item(lo_pnl_grid_recibo_cobranza);
                        lo_evt_grid_recibo_cobranza.suma_importes(lo_pnl_grid_recibo_cobranza);
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
        setTitle("RECIBO DE COBRANZA");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/JAVA/ANCESTRO/IMAGES/formulario.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 881, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 583, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
