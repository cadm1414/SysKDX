package JAVA.VENTAS.GUI;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.ANCESTRO.GUI.pnl_opciones_3;
import JAVA.ANCESTRO.LOGICA.evt_opciones_3;
import JAVA.ANCESTRO.LOGICA.recupera_valor_op;
import JAVA.CONFIG.GUI.dlg_busq_entidad_parametros;
import JAVA.CONFIG.GUI.dlg_busq_vendedor;
import JAVA.CONFIG.LOGICA.cbx_moneda;
import JAVA.INVENT.LOGICA.cbx_entidad_ubigeo;
import JAVA.INVENT.LOGICA.cbx_grupo_detraccion;
import JAVA.VENTAS.BEAN.BEAN_pedido;
import JAVA.VENTAS.LOGICA.cbx_igv;
import JAVA.VENTAS.LOGICA.evt_cab_pedidos;
import JAVA.VENTAS.LOGICA.evt_grid_pedidos;
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

public class jif_pedido extends javax.swing.JInternalFrame {

    pnl_opciones_3 lo_pnl_opciones_3 = new pnl_opciones_3();
    evt_opciones_3 lo_evt_opciones_3 = new evt_opciones_3();
    pnl_cab_pedidos lo_pnl_cab_pedidos = new pnl_cab_pedidos();
    evt_cab_pedidos lo_evt_cab_pedidos = new evt_cab_pedidos();
    pnl_grid_pedidos lo_pnl_grid_pedidos = new pnl_grid_pedidos();
    evt_grid_pedidos lo_evt_grid_pedidos = new evt_grid_pedidos();
    recupera_valor_op lo_recupera_valor_op = new recupera_valor_op();
    BEAN_pedido lo_bean_pedido = new BEAN_pedido();
    static boolean lb_valor_op[] = new boolean[8];
    DefaultTableModel modelo;
    cbx_moneda lo_cbx_moneda;
    cbx_grupo_detraccion lo_cbx_grupo_detraccion;
    cbx_entidad_ubigeo lo_cbx_entidad_ubigeo;
    cbx_igv lo_cbx_igv;
    ResultSet lq_rs;
    int li_tipo_operacion, cont = 0, li_cantidad;
    double ld_tipo_cambio, ld_porcentaje_detraccion, ld_monto_minimo;
    String ls_codigo, ls_codigo_sucursal, ls_serie, ls_codigo_vendedor, ls_nombre_vendedor, ls_codigo_articulo;
    String ls_opcion = "M A A";
    String ls_modulo = "VENTAS", ls_capa = "GUI", ls_clase = "jif_pedido";

    public jif_pedido() {
        initComponents();
        formulario();
        activa_botones();
        get_moneda();
        get_igv();
        get_grupo_detraccion();
        lo_pnl_grid_pedidos.TBL_pedidos.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "selectNextColumnCell");
    }

    private void formulario() {
        lo_pnl_opciones_3.setBounds(0, 10, 1000, 120);
        lo_pnl_cab_pedidos.setBounds(12, 130, 1000, 260);
        lo_pnl_grid_pedidos.setBounds(13, 390, 1000, 280);

        this.add(lo_pnl_opciones_3);
        this.add(lo_pnl_cab_pedidos);
        this.add(lo_pnl_grid_pedidos);

        ls_codigo_sucursal = gs_parametros[0];
        ls_serie = gs_parametros[2];
        lo_pnl_cab_pedidos.TXT_sucursal.setText(gs_parametros[1]);
        lo_pnl_cab_pedidos.TXT_serie.setText(gs_parametros[2]);

        gs_parametros[0] = "";
        gs_parametros[1] = "";
        gs_parametros[2] = "";

        modelo = (DefaultTableModel) lo_pnl_grid_pedidos.TBL_pedidos.getModel();
        modelo.addTableModelListener(TablaListener);

        li_cantidad = go_dao_serie.SLT_cant_items(lo_pnl_cab_pedidos.TXT_serie.getText().trim(), ls_codigo_sucursal, 0);

        lo_evt_opciones_3.evento_click(lo_pnl_opciones_3, Listener);
        lo_evt_opciones_3.evento_press(lo_pnl_opciones_3, KeyEvnt);
        lo_evt_cab_pedidos.evento_press(lo_pnl_cab_pedidos, KeyEvnt);
        lo_evt_cab_pedidos.evento_item(lo_pnl_cab_pedidos, ItemEvent);
        lo_evt_grid_pedidos.evento_item(lo_pnl_grid_pedidos, ItemEvent);
        lo_evt_grid_pedidos.evento_press(lo_pnl_grid_pedidos, KeyEvnt);
        lo_pnl_grid_pedidos.TBL_pedidos.addMouseListener(MouseEvent);
    }

    private void activa_botones() {
        lb_valor_op = lo_recupera_valor_op.recupera(ls_modulo, ls_opcion);
        lo_evt_opciones_3.activa_btn_opciones(0, lo_pnl_opciones_3, lb_valor_op);
    }

    private void get_moneda() {
        lq_rs = go_dao_moneda.SLT_moneda_x_visible("S");
        if (lq_rs != null) {
            go_cbx_trato_datos.recupera_valor(0, lq_rs, lo_pnl_cab_pedidos.CBX_moneda);
        }
    }

    private void get_igv() {
        lq_rs = go_dao_igv.SLT_cbx_igv();
        if (lq_rs != null) {
            go_cbx_trato_datos.recupera_valor(15, lq_rs, lo_pnl_cab_pedidos.CBX_igv);
        }
    }

    private void get_grupo_detraccion() {
        lq_rs = go_dao_grupo_detraccion.SLT_cbx_grupo_detraccion("1");
        if (lq_rs != null) {
            go_cbx_trato_datos.recupera_valor(10, lq_rs, lo_pnl_cab_pedidos.CBX_codigo_detraccion);
        }
    }

    private void get_tipo_cambio() {
        lo_cbx_moneda = (cbx_moneda) lo_pnl_cab_pedidos.CBX_moneda.getSelectedItem();
        lo_pnl_grid_pedidos.LBL_simbolo.setText("Imp (" + lo_cbx_moneda.simbolo_moneda().trim() + ")");
        if (!lo_cbx_moneda.getID().equalsIgnoreCase("PEN")) {
            try {
                ld_tipo_cambio = go_dao_tipo_cambio.SLT_tipo_cambio_monto("0", lo_cbx_moneda.getID(), lo_pnl_cab_pedidos.TXT_fecha_emision.getText());
                if (ld_tipo_cambio != 0) {
                    lo_pnl_cab_pedidos.TXT_tipo_cambio.setEnabled(false);
                    lo_pnl_cab_pedidos.TXT_tipo_cambio.setText(ld_tipo_cambio + "");
                } else if (go_fnc_mensaje.get_respuesta(0, "FECHA SIN TIPO DE CAMBIO ¿DESEA AGREGAR TIPO CAMBIO MANUAL?") == 0) {
                    lo_pnl_cab_pedidos.TXT_tipo_cambio.setEnabled(true);
                    lo_pnl_cab_pedidos.TXT_tipo_cambio.setText("");
                    lo_pnl_cab_pedidos.TXT_tipo_cambio.requestFocus();
                } else {
                    lo_pnl_cab_pedidos.TXT_tipo_cambio.setText("");
                }
            } catch (Exception e) {
            }
        } else {
            lo_pnl_cab_pedidos.TXT_tipo_cambio.setEnabled(false);
            lo_pnl_cab_pedidos.TXT_tipo_cambio.setText("0.000");
        }
    }

    private void get_porcentaje_detraccion() {
        lo_cbx_grupo_detraccion = (cbx_grupo_detraccion) lo_pnl_cab_pedidos.CBX_codigo_detraccion.getSelectedItem();

        try {
            lq_rs = go_dao_grupo_detraccion.SLT_grupo_detraccion_porcentaje(lo_cbx_grupo_detraccion.getID());
            if (lq_rs != null) {
                ld_porcentaje_detraccion = lq_rs.getDouble(1);
                lo_pnl_cab_pedidos.TXT_detraccion.setText(ld_porcentaje_detraccion + "");
                ld_monto_minimo = lq_rs.getDouble(2);
            }

        } catch (Exception e) {
        }
    }

    private void get_parametros(int op) {
        gs_parametros[1] = "1";
        gs_parametros[2] = "1";
        gs_parametros[3] = "%";
        gs_parametros[4] = "%";

        switch (op) {
            case 0:
                if (lo_pnl_cab_pedidos.CBX_tipo_documento_id.getSelectedIndex() == 0) {
                    gs_parametros[0] = "6";
                } else {
                    gs_parametros[0] = "1";
                }
                break;
            case 1:
                gs_parametros[0] = "%";
                break;
        }
    }

    private void get_nombre_vendedor() {
        try {
            lq_rs = go_dao_vendedor.SLT_datos_vendedor(lo_pnl_cab_pedidos.TXT_codigo_vendedor.getText().trim(), "1");
            if (lq_rs != null) {
                ls_codigo_vendedor = lq_rs.getString(1);
                ls_nombre_vendedor = lq_rs.getString(2);
                lo_pnl_cab_pedidos.TXT_codigo_vendedor.setText(ls_codigo_vendedor);
                lo_pnl_cab_pedidos.TXT_nombre_vendedor.setText(ls_nombre_vendedor);
                getFocusOwner().transferFocus();
            } else {
                go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "get_nombre_vendedor", "VENDEDOR NO EXISTE y/o BLOQUEADO");
                lo_pnl_cab_pedidos.TXT_codigo_vendedor.setText("");
                lo_pnl_cab_pedidos.TXT_nombre_vendedor.setText("");
            }
        } catch (Exception e) {
        }
    }

    private void get_descripcion_entidad(String codigo, int op) {
        String dato;
        if (lo_pnl_cab_pedidos.CBX_tipo_documento_id.getSelectedIndex() == 0) {
            dato = "6";
        } else {
            dato = "1";
        }
        try {
            lq_rs = go_dao_entidad.SLT_datos_entidad_x_facturacion(codigo, dato);
            if (lq_rs != null) {
                switch (op) {
                    case 0:
                        lo_pnl_cab_pedidos.TXT_codigo_entidad.setText(lq_rs.getString(1));
                        lo_pnl_cab_pedidos.TXT_razon_social.setText(lq_rs.getString(2));
                        lo_pnl_cab_pedidos.TXT_doc_id.setText(lq_rs.getString(3));
                        lo_pnl_cab_pedidos.JRD_domiciliado.setSelected(go_fnc_operaciones_campos.int_boolean(lq_rs.getInt(4)));
                        lo_pnl_cab_pedidos.TXT_codigo_pagador.setText(lq_rs.getString(1));
                        lo_pnl_cab_pedidos.TXT_pagador.setText(lq_rs.getString(2));
                        lo_pnl_cab_pedidos.TXT_codigo_vendedor.setText(lq_rs.getString(5));
                        lo_pnl_cab_pedidos.TXT_nombre_vendedor.setText(lq_rs.getString(6));
                        if (lq_rs.getString(7).equalsIgnoreCase("EF")) {
                            lo_pnl_cab_pedidos.CBX_forma_pago.setSelectedIndex(0);
                            lo_pnl_cab_pedidos.TXT_dias_credito.setEnabled(false);
                            lo_pnl_cab_pedidos.CBX_forma_pago.setEnabled(false);
                        } else {
                            lo_pnl_cab_pedidos.CBX_forma_pago.setSelectedIndex(1);
                            lo_pnl_cab_pedidos.TXT_dias_credito.setEnabled(true);
                            lo_pnl_cab_pedidos.CBX_forma_pago.setEnabled(true);
                        }
                        lo_pnl_cab_pedidos.TXT_dias_credito.setText(lq_rs.getString(8));
                        go_cbx_trato_datos.recupera_valor(16, lq_rs, lo_pnl_cab_pedidos.CBX_direccion);
                        lo_cbx_entidad_ubigeo = (cbx_entidad_ubigeo) lo_pnl_cab_pedidos.CBX_direccion.getSelectedItem();
                        lo_pnl_cab_pedidos.TXT_codigo_ubigeo.setText(lo_cbx_entidad_ubigeo.getID());
                        lo_pnl_cab_pedidos.TXT_descripcion.setText(lo_cbx_entidad_ubigeo.descripcion());
                        if (!lo_pnl_cab_pedidos.JRD_domiciliado.isSelected()) {
                            lo_pnl_cab_pedidos.CBX_afecto_igv.setSelectedIndex(0);
                        } else {
                            lo_pnl_cab_pedidos.CBX_afecto_igv.setSelectedIndex(1);
                        }
                        getFocusOwner().transferFocus();
                        break;
                }
            } else {
                go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_buscar", "ENTIDAD NO EXISTE y/o NO HABILITADO");
                switch (op) {
                    case 0:
                        lo_pnl_cab_pedidos.TXT_codigo_entidad.setText("");
                        lo_pnl_cab_pedidos.TXT_razon_social.setText("");
                        lo_pnl_cab_pedidos.TXT_doc_id.setText("");
                        lo_pnl_cab_pedidos.JRD_domiciliado.setSelected(false);
                        lo_pnl_cab_pedidos.CBX_direccion.removeAllItems();
                        lo_pnl_cab_pedidos.TXT_codigo_ubigeo.setText("");
                        lo_pnl_cab_pedidos.TXT_descripcion.setText("");
                        lo_pnl_cab_pedidos.CBX_forma_pago.setEnabled(false);
                        break;
                }
            }
        } catch (Exception e) {
        }
    }

    private void get_descripcion_pedido(String codigo) {
        try {
            lq_rs = go_dao_pedido.SLT_datos_pedido(codigo);
            if (lq_rs != null) {
                lo_evt_cab_pedidos.setea_recupera(lo_bean_pedido, lq_rs);
                lo_evt_cab_pedidos.muestra_datos(lo_pnl_cab_pedidos, lo_bean_pedido, lo_pnl_grid_pedidos);
                lo_cbx_moneda = (cbx_moneda) lo_pnl_cab_pedidos.CBX_moneda.getSelectedItem();
                lo_pnl_grid_pedidos.LBL_simbolo.setText("Imp (" + lo_cbx_moneda.simbolo_moneda().trim() + ")");
                get_descripcion_pedido_detalle(codigo);
            }
        } catch (Exception e) {
        }
    }

    private void get_descripcion_pedido_detalle(String codigo) {
        lo_evt_grid_pedidos.limpia_tabla(lo_pnl_grid_pedidos, li_tipo_operacion);
        lo_evt_grid_pedidos.recupera_detalle(lo_pnl_grid_pedidos, codigo, lo_bean_pedido.getEs_precio_igv());
    }

    private void limpia_parametros() {
        gs_parametros[0] = "";
        gs_parametros[1] = "";
        gs_parametros[2] = "";
        gs_parametros[3] = "";
        gs_parametros[4] = "";
        gs_parametros[5] = "";
    }

    private void genera_parametros_busq() {
        gs_parametros[0] = ls_codigo_sucursal;
        gs_parametros[1] = "01/" + gs_mes + "/" + gs_periodo;
        gs_parametros[2] = gs_dia + "/" + gs_mes + "/" + gs_periodo;
        gs_parametros[3] = lo_pnl_cab_pedidos.TXT_serie.getText().trim();
    }

    private void genera_peso_bruto(int fila) {
        try {
            double peso_bruto = (double) lo_pnl_grid_pedidos.TBL_pedidos.getValueAt(fila, 10) + ((double) lo_pnl_grid_pedidos.TBL_pedidos.getValueAt(fila, 4) * (int) lo_pnl_grid_pedidos.TBL_pedidos.getValueAt(fila, 1));
            lo_pnl_grid_pedidos.TBL_pedidos.setValueAt(peso_bruto, fila, 9);
        } catch (Exception e) {
        }
    }

    private void genera_importe(int fila) {
        try {
            double importe = (double) lo_pnl_grid_pedidos.TBL_pedidos.getValueAt(fila, 8) * (double) lo_pnl_grid_pedidos.TBL_pedidos.getValueAt(fila, 10);
            lo_pnl_grid_pedidos.TBL_pedidos.setValueAt(importe, fila, 11);
        } catch (Exception e) {
        }
    }

    private void evt_f5_entidad(int op) {
        get_parametros(op);
        go_dlg_busq_entidad_parametros = new dlg_busq_entidad_parametros(null, true);
        go_dlg_busq_entidad_parametros.setVisible(true);
        ls_codigo = go_dlg_busq_entidad_parametros.ls_codigo_entidad;
        if (ls_codigo != null) {
            get_descripcion_entidad(ls_codigo, op);
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_f5_entidad", "SELECCIONE ENTIDAD");
            lo_pnl_cab_pedidos.TXT_codigo_entidad.setText("");
        }
    }

    private void evt_f5_facturacion() {
        lo_cbx_grupo_detraccion = (cbx_grupo_detraccion) lo_pnl_cab_pedidos.CBX_codigo_detraccion.getSelectedItem();
        gs_parametros[0] = ls_codigo_sucursal;
        gs_parametros[1] = lo_pnl_cab_pedidos.CBX_doc_ref.getSelectedIndex() + "";
        gs_parametros[2] = lo_cbx_grupo_detraccion.getID();
        go_dlg_busq_facturacion = new dlg_busq_facturacion(null, true);
        go_dlg_busq_facturacion.setVisible(true);
        ls_codigo_articulo = gs_parametros[0];
        if (!ls_codigo_articulo.equalsIgnoreCase("") || ls_codigo_articulo != null) {
            try {
                lo_pnl_grid_pedidos.TBL_pedidos.setValueAt(gs_parametros[0], lo_pnl_grid_pedidos.TBL_pedidos.getSelectedRow(), 2);
                lo_pnl_grid_pedidos.TBL_pedidos.setValueAt(gs_parametros[1], lo_pnl_grid_pedidos.TBL_pedidos.getSelectedRow(), 3);
                lo_pnl_grid_pedidos.TBL_pedidos.setValueAt(Double.parseDouble(gs_parametros[2]), lo_pnl_grid_pedidos.TBL_pedidos.getSelectedRow(), 4);
                lo_pnl_grid_pedidos.TBL_pedidos.setValueAt(gs_parametros[3], lo_pnl_grid_pedidos.TBL_pedidos.getSelectedRow(), 5);
                lo_pnl_grid_pedidos.TBL_pedidos.setValueAt((gs_parametros[4].equalsIgnoreCase("true")) ? true : false, lo_pnl_grid_pedidos.TBL_pedidos.getSelectedRow(), 6);
                lo_pnl_grid_pedidos.TBL_pedidos.setValueAt(Double.parseDouble(gs_parametros[5]), lo_pnl_grid_pedidos.TBL_pedidos.getSelectedRow(), 7);
            } catch (Exception e) {
            }
        }
        limpia_parametros();
    }

    private void evt_f5_vendedor() {
        go_dlg_busq_vendedor = new dlg_busq_vendedor(null, true);
        go_dlg_busq_vendedor.setVisible(true);
        ls_codigo_vendedor = go_dlg_busq_vendedor.ls_codigo_vendedor;
        ls_nombre_vendedor = go_dlg_busq_vendedor.ls_nombre_vendedor;
        if (ls_codigo_vendedor != null) {
            lo_pnl_cab_pedidos.TXT_codigo_vendedor.setText(ls_codigo_vendedor);
            lo_pnl_cab_pedidos.TXT_nombre_vendedor.setText(ls_nombre_vendedor);
            getFocusOwner().transferFocus();
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_f5_vendedor", "SELECCIONE VENDEDOR");
            lo_pnl_cab_pedidos.TXT_codigo_vendedor.setText("");
            lo_pnl_cab_pedidos.TXT_nombre_vendedor.setText("");
        }
    }

    private void evt_nuevo() {
        ls_codigo = null;
        lo_evt_cab_pedidos.limpia_datos(lo_pnl_cab_pedidos);
        lo_evt_grid_pedidos.limpia_tabla(lo_pnl_grid_pedidos, li_tipo_operacion);
        li_tipo_operacion = 0;
        try {
            lq_rs = go_dao_pedido.FNC_correlativo_pedido("OP", ls_serie, ls_codigo_sucursal);
            if (lq_rs.next()) {
                lo_pnl_cab_pedidos.TXT_numero_doc.setText(lq_rs.getString(1));
                lo_pnl_cab_pedidos.LBL_numero_doc.setText(lq_rs.getString(1));
            }
        } catch (Exception e) {
        }

        lo_evt_opciones_3.activa_btn_opciones(1, lo_pnl_opciones_3, lb_valor_op);
        lo_evt_cab_pedidos.activa_campos(0, lo_pnl_cab_pedidos, true);
        lo_evt_grid_pedidos.activa_campos(0, lo_pnl_grid_pedidos, true);
    }

    private void evt_buscar() {
        li_tipo_operacion = 2;
        genera_parametros_busq();
        go_dlg_busq_pedido = new dlg_busq_pedido(null, true);
        go_dlg_busq_pedido.setVisible(true);
        ls_codigo = go_dlg_busq_pedido.ls_codigo;
        if (ls_codigo != null) {
            ls_codigo = ls_codigo.substring(0, 2) + ls_serie + ls_codigo.substring(3, 13);
            get_descripcion_pedido(ls_codigo);
            lo_evt_opciones_3.activa_btn_opciones(2, lo_pnl_opciones_3, lb_valor_op);
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_buscar", "SELECCIONE DOCUMENTO");
            lo_evt_cab_pedidos.limpia_datos(lo_pnl_cab_pedidos);
            lo_evt_grid_pedidos.limpia_tabla(lo_pnl_grid_pedidos, li_tipo_operacion);
            lo_evt_opciones_3.activa_btn_opciones(0, lo_pnl_opciones_3, lb_valor_op);
        }
    }

    private void evt_editar() {
        if (go_dao_pedido.FNC_verifica_pedido_facturado(ls_codigo).equalsIgnoreCase("0")) {
            li_tipo_operacion = 1;
            cont = 0;
            lo_evt_opciones_3.activa_btn_opciones(3, lo_pnl_opciones_3, lb_valor_op);
            lo_evt_cab_pedidos.activa_campos(1, lo_pnl_cab_pedidos, true);
            lo_evt_grid_pedidos.activa_campos(0, lo_pnl_grid_pedidos, true);
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_editar", "PEDIDO FACTURADO");
        }
    }

    private void evt_eliminar() {
        if (go_dao_pedido.FNC_verifica_pedido_facturado(ls_codigo).equalsIgnoreCase("0")) {
            if (go_fnc_mensaje.get_respuesta(0, "¿DESEA ELIMINAR DOCUMENTO Nro OP-" + lo_bean_pedido.getNumero_documento() + "?") == 0) {
                try {
                    if (go_dao_pedido_detalle.DLT_pedido_detalle(ls_codigo)) {
                        if (go_dao_pedido.DLT_pedido(ls_codigo)) {
                            lo_evt_opciones_3.activa_btn_opciones(0, lo_pnl_opciones_3, lb_valor_op);
                            lo_evt_cab_pedidos.activa_campos(0, lo_pnl_cab_pedidos, false);
                            lo_evt_cab_pedidos.limpia_datos(lo_pnl_cab_pedidos);
                            lo_evt_grid_pedidos.activa_campos(0, lo_pnl_grid_pedidos, false);
                            lo_evt_grid_pedidos.limpia_tabla(lo_pnl_grid_pedidos, li_tipo_operacion);
                        }
                    }
                } catch (Exception e) {
                }
            }
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_eliminar", "PEDIDO FACTURADO");
        }
    }

    private void evt_guardar() {
        lo_cbx_moneda = (cbx_moneda) lo_pnl_cab_pedidos.CBX_moneda.getSelectedItem();
        lo_cbx_grupo_detraccion = (cbx_grupo_detraccion) lo_pnl_cab_pedidos.CBX_codigo_detraccion.getSelectedItem();
        lo_cbx_entidad_ubigeo = (cbx_entidad_ubigeo) lo_pnl_cab_pedidos.CBX_direccion.getSelectedItem();
        lo_cbx_igv = (cbx_igv) lo_pnl_cab_pedidos.CBX_igv.getSelectedItem();

        switch (li_tipo_operacion) {
            case 0:
                if (lo_evt_cab_pedidos.valida_campos(lo_pnl_cab_pedidos, lo_cbx_moneda)) {
                    if (lo_evt_grid_pedidos.valida_campos(lo_pnl_grid_pedidos, li_cantidad)) {
                        try {
                            ls_codigo = "OP" + ls_serie + lo_pnl_cab_pedidos.TXT_numero_doc.getText().trim();
                            lo_bean_pedido.setCodigo_operacion(ls_codigo);
                            lo_bean_pedido.setCodigo_sucursal(ls_codigo_sucursal);
                            lo_evt_cab_pedidos.setea_campos(lo_bean_pedido, lo_pnl_cab_pedidos, lo_cbx_entidad_ubigeo, lo_cbx_grupo_detraccion, lo_cbx_moneda, lo_cbx_igv, lo_pnl_grid_pedidos, ld_monto_minimo);
                            if (go_dao_pedido.IST_pedido(lo_bean_pedido, lo_pnl_grid_pedidos.TBL_pedidos, Double.parseDouble(lo_pnl_cab_pedidos.CBX_igv.getSelectedItem().toString()) / 100)) {
                                lo_evt_cab_pedidos.limpia_datos(lo_pnl_cab_pedidos);
                                lo_evt_cab_pedidos.activa_campos(0, lo_pnl_cab_pedidos, false);
                                lo_evt_grid_pedidos.limpia_tabla(lo_pnl_grid_pedidos, li_tipo_operacion);
                                lo_evt_grid_pedidos.activa_campos(0, lo_pnl_grid_pedidos, false);
                                lo_evt_opciones_3.activa_btn_opciones(0, lo_pnl_opciones_3, lb_valor_op);
                            }
                        } catch (Exception e) {
                        }
                    }
                }
                break;
            case 1:
                if (lo_evt_cab_pedidos.verifica_cambios(lo_bean_pedido, lo_pnl_cab_pedidos, lo_cbx_entidad_ubigeo, lo_cbx_grupo_detraccion, lo_cbx_moneda, lo_cbx_igv) || cont != 0) {
                    if (lo_evt_grid_pedidos.valida_campos(lo_pnl_grid_pedidos, li_cantidad)) {
                        if (lo_evt_grid_pedidos.valida_campos(lo_pnl_grid_pedidos, li_cantidad)) {
                            try {
                                lo_evt_cab_pedidos.setea_campos(lo_bean_pedido, lo_pnl_cab_pedidos, lo_cbx_entidad_ubigeo, lo_cbx_grupo_detraccion, lo_cbx_moneda, lo_cbx_igv, lo_pnl_grid_pedidos, ld_monto_minimo);
                                if (go_dao_pedido_detalle.DLT_pedido_detalle(ls_codigo)) {
                                    if (go_dao_pedido.UPD_pedido(lo_bean_pedido, lo_pnl_grid_pedidos.TBL_pedidos, Double.parseDouble(lo_pnl_cab_pedidos.CBX_igv.getSelectedItem().toString()) / 100)) {
                                        lo_evt_cab_pedidos.limpia_datos(lo_pnl_cab_pedidos);
                                        lo_evt_cab_pedidos.activa_campos(0, lo_pnl_cab_pedidos, false);
                                        lo_evt_grid_pedidos.limpia_tabla(lo_pnl_grid_pedidos, li_tipo_operacion);
                                        lo_evt_grid_pedidos.activa_campos(0, lo_pnl_grid_pedidos, false);
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
        lo_evt_cab_pedidos.activa_campos(0, lo_pnl_cab_pedidos, false);
        lo_evt_grid_pedidos.activa_campos(0, lo_pnl_grid_pedidos, false);
        lo_evt_grid_pedidos.limpia_tabla(lo_pnl_grid_pedidos, li_tipo_operacion);
        if (ls_codigo != null) {
            lo_evt_cab_pedidos.muestra_datos(lo_pnl_cab_pedidos, lo_bean_pedido, lo_pnl_grid_pedidos);
            get_descripcion_pedido_detalle(ls_codigo);
            lo_evt_opciones_3.activa_btn_opciones(2, lo_pnl_opciones_3, lb_valor_op);
        } else {
            lo_evt_cab_pedidos.limpia_datos(lo_pnl_cab_pedidos);
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
            if (ke.getKeyCode() == KeyEvent.VK_F6 && lo_pnl_opciones_3.BTN_guardar.isEnabled()) {
                evt_guardar();
            }
            if (ke.getKeyCode() == KeyEvent.VK_F5) {
                if (ke.getSource() == lo_pnl_cab_pedidos.TXT_codigo_entidad) {
                    evt_f5_entidad(0);
                }
                if (ke.getSource() == lo_pnl_cab_pedidos.TXT_codigo_vendedor) {
                    evt_f5_vendedor();
                }
                if (ke.getSource() == lo_pnl_grid_pedidos.TBL_pedidos && lo_pnl_grid_pedidos.TBL_pedidos.getSelectedColumn() == 2) {
                    evt_f5_facturacion();
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
                if (ke.getSource() == lo_pnl_cab_pedidos.TXT_numero_doc) {
                    if (go_fnc_operaciones_campos.campo_blanco(lo_pnl_cab_pedidos.TXT_numero_doc)) {
                        lo_pnl_cab_pedidos.TXT_numero_doc.setText(go_fnc_operaciones_campos.completa_digitos(lo_pnl_cab_pedidos.TXT_numero_doc.getText().trim(), "0", 10));
                        lo_pnl_cab_pedidos.LBL_numero_doc.setText(lo_pnl_cab_pedidos.TXT_numero_doc.getText());
                        lo_pnl_cab_pedidos.TXT_fecha_emision.requestFocus();
                    }
                }
                if (ke.getSource() == lo_pnl_cab_pedidos.TXT_fecha_emision && !lo_pnl_cab_pedidos.TXT_fecha_emision.getText().trim().equalsIgnoreCase("/  /")) {
                    if (go_fnc_operaciones_campos.valida_fecha(lo_pnl_cab_pedidos.TXT_fecha_emision.getText())) {
                        if (lo_pnl_cab_pedidos.TXT_fecha_emision.getText().trim().substring(6, 10).equalsIgnoreCase(gs_periodo)) {
                            getFocusOwner().transferFocus();
                            get_tipo_cambio();
                        } else {
                            lo_pnl_cab_pedidos.TXT_fecha_emision.setText("");
                            go_fnc_mensaje.GET_mensaje(0, ls_modulo, ls_capa, ls_clase, "keyPressed", "FECHA NO PERTENECE AL PERIODO");
                        }
                    } else {
                        lo_pnl_cab_pedidos.TXT_fecha_emision.setText("");
                        go_fnc_mensaje.GET_mensaje(0, ls_modulo, ls_capa, ls_clase, "keyPressed", "FORMATO DE FECHA INVALIDO");
                    }
                }
                if (ke.getSource() == lo_pnl_cab_pedidos.TXT_dias_credito && go_fnc_operaciones_campos.campo_blanco(lo_pnl_cab_pedidos.TXT_dias_credito)) {
                    getFocusOwner().transferFocus();
                }
                if (ke.getSource() == lo_pnl_cab_pedidos.CBX_doc_ref || ke.getSource() == lo_pnl_cab_pedidos.CBX_moneda || ke.getSource() == lo_pnl_cab_pedidos.JRD_precio_igv || ke.getSource() == lo_pnl_cab_pedidos.CBX_forma_pago) {
                    getFocusOwner().transferFocus();
                }
                if (ke.getSource() == lo_pnl_cab_pedidos.TXT_tipo_cambio && go_fnc_operaciones_campos.campo_blanco(lo_pnl_cab_pedidos.TXT_tipo_cambio)) {
                    getFocusOwner().transferFocus();
                }
                if (ke.getSource() == lo_pnl_cab_pedidos.CBX_codigo_detraccion) {
                    get_porcentaje_detraccion();
                    getFocusOwner().transferFocus();
                }
                if (ke.getSource() == lo_pnl_cab_pedidos.TXT_codigo_entidad && go_fnc_operaciones_campos.cant_caracter(lo_pnl_cab_pedidos.TXT_codigo_entidad.getText().trim(), 4, 6)) {
                    get_descripcion_entidad(lo_pnl_cab_pedidos.TXT_codigo_entidad.getText().trim(), 0);
                }
                if (ke.getSource() == lo_pnl_cab_pedidos.CBX_direccion && !lo_pnl_cab_pedidos.CBX_direccion.getSelectedItem().toString().equalsIgnoreCase("")) {
                    getFocusOwner().transferFocus();
                }
                if (ke.getSource() == lo_pnl_cab_pedidos.TXT_codigo_vendedor && go_fnc_operaciones_campos.cant_caracter(lo_pnl_cab_pedidos.TXT_codigo_vendedor.getText(), 4, 4)) {
                    get_nombre_vendedor();
                }
                if (ke.getSource() == lo_pnl_cab_pedidos.TXT_observacion) {
                    lo_pnl_grid_pedidos.JRD_masivo.requestFocus();
                }
                if (ke.getSource() == lo_pnl_grid_pedidos.JRD_masivo) {
                    if (lo_pnl_grid_pedidos.TBL_pedidos.getRowCount() == 0) {
                        lo_pnl_grid_pedidos.TBL_pedidos.requestFocus();
                        lo_evt_grid_pedidos.agrega_fila(lo_pnl_grid_pedidos, -1, li_cantidad);
                    } else {
                        lo_pnl_grid_pedidos.TBL_pedidos.requestFocus();
                        lo_pnl_grid_pedidos.TBL_pedidos.changeSelection(0, 1, false, false);
                    }
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent ke) {
            if (ke.getSource() == lo_pnl_cab_pedidos.TXT_numero_doc) {
                lo_pnl_cab_pedidos.LBL_numero_doc.setText(lo_pnl_cab_pedidos.TXT_numero_doc.getText());
            }
            if (ke.getSource() == lo_pnl_grid_pedidos.TBL_pedidos) {
                int fila = lo_pnl_grid_pedidos.TBL_pedidos.getSelectedRow();
                genera_peso_bruto(fila);
                genera_importe(fila);
                lo_evt_grid_pedidos.suma_importes(lo_pnl_cab_pedidos.CBX_afecto_igv.getSelectedIndex(), Double.parseDouble(lo_pnl_cab_pedidos.CBX_igv.getSelectedItem().toString()) / 100, lo_pnl_cab_pedidos.JRD_precio_igv.isSelected(), lo_pnl_grid_pedidos);

                if (lo_pnl_grid_pedidos.TBL_pedidos.getSelectedColumn() == 2) {
                    if (lo_pnl_grid_pedidos.TBL_pedidos.getValueAt(fila, 1) == null) {
                        lo_pnl_grid_pedidos.TBL_pedidos.setValueAt(0, fila, 1);
                        lo_pnl_grid_pedidos.TBL_pedidos.changeSelection(fila, 1, false, false);
                    }
                }
                if (lo_pnl_grid_pedidos.TBL_pedidos.getSelectedColumn() == 3) {
                    if (lo_pnl_grid_pedidos.TBL_pedidos.getValueAt(fila, 2).toString().trim().equalsIgnoreCase("")) {
                        lo_pnl_grid_pedidos.TBL_pedidos.changeSelection(fila, 2, false, false);
                    } else {
                        lo_pnl_grid_pedidos.TBL_pedidos.changeSelection(fila, 8, false, false);
                        lo_pnl_grid_pedidos.TBL_pedidos.editCellAt(fila, 8);
                    }
                }
                if (lo_pnl_grid_pedidos.TBL_pedidos.getSelectedColumn() == 9) {
                    if (lo_pnl_grid_pedidos.TBL_pedidos.getValueAt(fila, 8) == null) {
                        lo_pnl_grid_pedidos.TBL_pedidos.changeSelection(fila, 8, false, false);
                    } else if ((Double) lo_pnl_grid_pedidos.TBL_pedidos.getValueAt(fila, 8) == 0) {
                        lo_pnl_grid_pedidos.TBL_pedidos.setValueAt(null, fila, 8);
                        lo_pnl_grid_pedidos.TBL_pedidos.changeSelection(fila, 8, false, false);
                    } else {
                        lo_pnl_grid_pedidos.TBL_pedidos.setValueAt(go_dao_reportes.RPT_utilidad_ponderada(ls_codigo_sucursal, lo_pnl_grid_pedidos.TBL_pedidos.getValueAt(fila, 2).toString(), Double.parseDouble(lo_pnl_grid_pedidos.TBL_pedidos.getValueAt(fila, 8).toString())), fila, 12);
                        //lo_pnl_grid_pedidos.TBL_pedidos.changeSelection(fila, 10, false, false);
                    }
                }
                if (lo_pnl_grid_pedidos.TBL_pedidos.getSelectedColumn() == 11) {
                    if (lo_pnl_grid_pedidos.TBL_pedidos.getValueAt(fila, 10) == null) {
                        lo_pnl_grid_pedidos.TBL_pedidos.changeSelection(fila, 10, false, false);
                    } else if ((Double) lo_pnl_grid_pedidos.TBL_pedidos.getValueAt(fila, 10) == 0) {
                        lo_pnl_grid_pedidos.TBL_pedidos.setValueAt(null, fila, 10);
                        lo_pnl_grid_pedidos.TBL_pedidos.changeSelection(fila, 10, false, false);
                    }
                }
                if (lo_pnl_grid_pedidos.TBL_pedidos.getSelectedColumn() == 12) {
                    lo_evt_grid_pedidos.agrega_fila(lo_pnl_grid_pedidos, fila, li_cantidad
                    );
                }
            }
        }
    };

    ItemListener ItemEvent = new ItemListener() {
        @Override
        public void itemStateChanged(java.awt.event.ItemEvent ie) {
            if (li_tipo_operacion != 2) {
                if (ie.getSource() == lo_pnl_cab_pedidos.CBX_doc_ref) {
                    lo_pnl_cab_pedidos.TXT_codigo_entidad.setText("");
                    lo_pnl_cab_pedidos.TXT_razon_social.setText("");
                    lo_pnl_cab_pedidos.TXT_doc_id.setText("");
                    lo_pnl_cab_pedidos.JRD_domiciliado.setSelected(false);
                    lo_pnl_cab_pedidos.CBX_direccion.removeAllItems();
                    lo_pnl_cab_pedidos.TXT_codigo_ubigeo.setText("");
                    lo_pnl_cab_pedidos.TXT_descripcion.setText("");
                    lo_pnl_cab_pedidos.CBX_codigo_detraccion.setSelectedIndex(0);
                    if (lo_pnl_cab_pedidos.CBX_doc_ref.getSelectedIndex() == 0) {
                        lo_pnl_cab_pedidos.CBX_tipo_documento_id.setSelectedIndex(0);
                        lo_pnl_cab_pedidos.CBX_codigo_detraccion.setEnabled(true);
                    } else {
                        lo_pnl_cab_pedidos.CBX_codigo_detraccion.setEnabled(false);
                        lo_pnl_cab_pedidos.CBX_tipo_documento_id.setSelectedIndex(1);
                    }
                }
                if (ie.getSource() == lo_pnl_cab_pedidos.CBX_moneda) {
                    get_tipo_cambio();
                }
                if (ie.getSource() == lo_pnl_cab_pedidos.CBX_codigo_detraccion) {
                    get_porcentaje_detraccion();
                    lo_evt_grid_pedidos.limpia_tabla(lo_pnl_grid_pedidos, li_tipo_operacion);
                }
                if (ie.getSource() == lo_pnl_cab_pedidos.CBX_direccion && !lo_pnl_cab_pedidos.TXT_codigo_entidad.getText().trim().equalsIgnoreCase("")) {
                    lo_cbx_entidad_ubigeo = (cbx_entidad_ubigeo) lo_pnl_cab_pedidos.CBX_direccion.getSelectedItem();
                    lo_pnl_cab_pedidos.TXT_codigo_ubigeo.setText(lo_cbx_entidad_ubigeo.getID());
                    lo_pnl_cab_pedidos.TXT_descripcion.setText(lo_cbx_entidad_ubigeo.descripcion());
                }
                if (ie.getSource() == lo_pnl_cab_pedidos.JRD_precio_igv) {
                    lo_evt_grid_pedidos.suma_importes(lo_pnl_cab_pedidos.CBX_afecto_igv.getSelectedIndex(), Double.parseDouble(lo_pnl_cab_pedidos.CBX_igv.getSelectedItem().toString()) / 100, lo_pnl_cab_pedidos.JRD_precio_igv.isSelected(), lo_pnl_grid_pedidos);
                }
                if (ie.getSource() == lo_pnl_grid_pedidos.JRD_masivo && lo_pnl_grid_pedidos.JRD_masivo.isSelected() == true) {
//                    go_dlg_busq_facturacion = new dlg_busq_facturacion(null, true);
//                    go_dlg_busq_facturacion.setVisible(true);
                }
            }
        }
    };

    MouseListener MouseEvent = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent me) {
            if (me.getSource() == lo_pnl_grid_pedidos.TBL_pedidos && lo_pnl_grid_pedidos.TBL_pedidos.isEnabled()) {
                int columna = lo_pnl_grid_pedidos.TBL_pedidos.getColumnModel().getColumnIndexAtX(me.getX());
                int fila = me.getY() / lo_pnl_grid_pedidos.TBL_pedidos.getRowHeight();
                Object value = lo_pnl_grid_pedidos.TBL_pedidos.getValueAt(fila, columna);
                if (value instanceof JButton) {
                    if (go_fnc_mensaje.get_respuesta(0, "¿DESEA ELIMINAR ITEM " + go_fnc_operaciones_campos.completa_digitos((fila + 1) + "", "0", 3) + "?") == 0) {
                        lo_evt_grid_pedidos.elimina_fila(lo_pnl_grid_pedidos, fila);
                        lo_evt_grid_pedidos.genera_item(lo_pnl_grid_pedidos);
                        lo_evt_grid_pedidos.suma_importes(lo_pnl_cab_pedidos.CBX_afecto_igv.getSelectedIndex(), Double.parseDouble(lo_pnl_cab_pedidos.CBX_igv.getSelectedItem().toString()) / 100, lo_pnl_cab_pedidos.JRD_precio_igv.isSelected(), lo_pnl_grid_pedidos);
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
        setTitle("PEDIDOS");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/JAVA/ANCESTRO/IMAGES/formulario.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1014, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 613, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
