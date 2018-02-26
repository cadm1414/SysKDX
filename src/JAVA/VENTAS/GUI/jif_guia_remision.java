package JAVA.VENTAS.GUI;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.ANCESTRO.GUI.pnl_opciones_3;
import JAVA.ANCESTRO.LOGICA.evt_focus_component;
import JAVA.ANCESTRO.LOGICA.evt_opciones_3;
import JAVA.ANCESTRO.LOGICA.recupera_valor_op;
import JAVA.CONFIG.GUI.dlg_busq_entidad_parametros;
import JAVA.CONFIG.LOGICA.cbx_moneda;
import JAVA.CONFIG.LOGICA.cbx_sector_distribucion;
import JAVA.CONFIG.LOGICA.cbx_tabla_ayuda;
import JAVA.INVENT.LOGICA.cbx_entidad_ubigeo;
import JAVA.INVENT.LOGICA.cbx_grupo_detraccion;
import JAVA.UTILITARIOS.FUNCION.fnc_txt_mayuscula;
import JAVA.VENTAS.BEAN.BEAN_guia_remision;
import JAVA.VENTAS.LOGICA.cbx_igv;
import JAVA.VENTAS.LOGICA.evt_cab_guiar;
import JAVA.VENTAS.LOGICA.evt_grid_pedidos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRParameter;

public class jif_guia_remision extends javax.swing.JInternalFrame {

    pnl_opciones_3 lo_pnl_opciones_3 = new pnl_opciones_3();
    evt_opciones_3 lo_evt_opciones_3 = new evt_opciones_3();
    pnl_cab_guiar lo_pnl_cab_guiar = new pnl_cab_guiar();
    evt_cab_guiar lo_evt_cab_guiar = new evt_cab_guiar();
    pnl_grid_pedidos lo_pnl_grid_pedidos = new pnl_grid_pedidos();
    evt_grid_pedidos lo_evt_grid_pedidos = new evt_grid_pedidos();
    recupera_valor_op lo_recupera_valor_op = new recupera_valor_op();
    static boolean lb_valor_op[] = new boolean[8];
    BEAN_guia_remision lo_bean_guia_remision = new BEAN_guia_remision();
    ResultSet lq_rs;
    DefaultTableModel modelo;
    cbx_moneda lo_cbx_moneda;
    cbx_grupo_detraccion lo_cbx_grupo_detraccion;
    cbx_entidad_ubigeo lo_cbx_entidad_ubigeo;
    cbx_igv lo_cbx_igv;
    cbx_tabla_ayuda lo_cbx_tabla_ayuda;
    cbx_sector_distribucion lo_cbx_sector;
    int li_tipo_operacion, cont = 0, li_cantidad;
    double ld_tipo_cambio, ld_porcentaje_detraccion, ld_monto_minimo;
    String ls_codigo, ls_codigo_sucursal, ls_serie, ls_codigo_vendedor, ls_nombre_vendedor, ls_codigo_articulo, ls_codigo_entidad,
            ls_tipo_documento_g, ls_codigo_pedido, ls_item_seleccion[];
    String ls_codigo_transportista = "", ls_nombre_transportista = "", ls_licencia = "", ls_empresa = "", ls_ruc = "", ls_codigo_vehiculo = "", ls_marca = "", ls_civ = "",
            ls_codigo_vehiculo_v2 = "", ls_marca_v2 = "", ls_civ_v2 = "", ls_codigo_direccion = "", ls_descripcion = "", ls_punto_llegada = "", ls_codigo_ubigeo_ls = "", ls_descripcion_ubigeo = "";
    String ls_opcion = "M A C";
    String ls_modulo = "VENTAS", ls_capa = "GUI", ls_clase = "jif_guia_remision";
    JTextField editor;

    public jif_guia_remision() {
        initComponents();
        formulario();
        activa_botones();
        get_moneda();
        get_igv();
        get_grupo_detraccion();
        get_tipo_op();
        get_sector_distribucion();
        lo_pnl_grid_pedidos.TBL_pedidos.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "selectNextColumnCell");
    }

    private void formulario() {
        lo_pnl_opciones_3.setBounds(0, 10, 1000, 110);
        lo_pnl_cab_guiar.setBounds(12, 120, 1100, 265);
        lo_pnl_grid_pedidos.setBounds(13, 390, 1100, 280);

        this.add(lo_pnl_opciones_3);
        this.add(lo_pnl_cab_guiar);
        this.add(lo_pnl_grid_pedidos);

        ls_codigo_sucursal = gs_parametros[0];
        ls_serie = gs_parametros[2];
        ls_tipo_documento_g = gs_parametros[3];
        lo_pnl_cab_guiar.TXT_sucursal.setText(gs_parametros[1]);
        lo_pnl_cab_guiar.TXT_serie.setText(gs_parametros[2]);

        gs_parametros[0] = "";
        gs_parametros[1] = "";
        gs_parametros[2] = "";
        gs_parametros[3] = "";

        modelo = (DefaultTableModel) lo_pnl_grid_pedidos.TBL_pedidos.getModel();
        modelo.addTableModelListener(TablaListener);

        editor = (JTextField) lo_pnl_cab_guiar.CBX_direccion.getEditor().getEditorComponent();
        editor.addKeyListener(KeyEvnt);
        editor.addFocusListener(new evt_focus_component());
        editor.setDocument(new fnc_txt_mayuscula());

        li_cantidad = go_dao_serie.SLT_cant_items(ls_serie, ls_codigo_sucursal, 1);
        ls_item_seleccion = new String[li_cantidad];
        lo_evt_opciones_3.evento_click(lo_pnl_opciones_3, Listener);
        lo_evt_opciones_3.evento_press(lo_pnl_opciones_3, KeyEvnt);
        lo_evt_cab_guiar.evento_press(lo_pnl_cab_guiar, KeyEvnt);
        lo_evt_cab_guiar.evento_item(lo_pnl_cab_guiar, ItemEvent);
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
            go_cbx_trato_datos.recupera_valor(0, lq_rs, lo_pnl_cab_guiar.CBX_moneda);
        }
    }

    private void get_igv() {
        lq_rs = go_dao_igv.SLT_cbx_igv();
        if (lq_rs != null) {
            go_cbx_trato_datos.recupera_valor(15, lq_rs, lo_pnl_cab_guiar.CBX_igv);
        }
    }

    private void get_grupo_detraccion() {
        lq_rs = go_dao_grupo_detraccion.SLT_cbx_grupo_detraccion("1");
        if (lq_rs != null) {
            go_cbx_trato_datos.recupera_valor(10, lq_rs, lo_pnl_cab_guiar.CBX_codigo_detraccion);
        }
    }

    private void get_sector_distribucion() {
        lq_rs = go_dao_sector_distribucion.SLT_cbx_sector_distribucion();
        if (lq_rs != null) {
            go_cbx_trato_datos.recupera_valor(20, lq_rs, lo_pnl_cab_guiar.CBX_sector);
        }
    }

    private void get_tipo_cambio() {
        lo_cbx_moneda = (cbx_moneda) lo_pnl_cab_guiar.CBX_moneda.getSelectedItem();
        lo_pnl_grid_pedidos.LBL_simbolo.setText("Imp (" + lo_cbx_moneda.simbolo_moneda().trim() + ")");
        lo_pnl_cab_guiar.TXT_tipo_cambio.setEnabled(false);
        lo_pnl_cab_guiar.TXT_tipo_cambio.setText("0.000");
    }

    private void get_porcentaje_detraccion() {
        lo_cbx_grupo_detraccion = (cbx_grupo_detraccion) lo_pnl_cab_guiar.CBX_codigo_detraccion.getSelectedItem();
        try {
            lq_rs = go_dao_grupo_detraccion.SLT_grupo_detraccion_porcentaje(lo_cbx_grupo_detraccion.getID());
            if (lq_rs != null) {
                ld_porcentaje_detraccion = lq_rs.getDouble(1);
                lo_pnl_cab_guiar.TXT_detraccion.setText(ld_porcentaje_detraccion + "");
                ld_monto_minimo = lq_rs.getDouble(2);
            }
        } catch (Exception e) {
        }
    }

    private void get_tipo_op() {
        lq_rs = go_dao_tabla_ayuda.SLT_cbx_tabla_ayuda("0003");
        if (lq_rs != null) {
            go_cbx_trato_datos.recupera_valor(19, lq_rs, lo_pnl_cab_guiar.CBX_tipo_op);
        }
    }

    private void get_parametros_entidad() {
        gs_parametros[0] = (lo_pnl_cab_guiar.CBX_doc_ref.getSelectedIndex() == 0) ? "6" : "1";
        gs_parametros[1] = "1";
        gs_parametros[2] = "1";
        gs_parametros[3] = "%";
        gs_parametros[4] = "%";

    }

    private void get_datos_transportista() {
        ls_codigo_transportista = gs_parametros[0];
        ls_nombre_transportista = gs_parametros[1];
        ls_licencia = gs_parametros[2];
        ls_empresa = gs_parametros[3];
        ls_ruc = gs_parametros[4];
        ls_codigo_vehiculo = gs_parametros[5];
        ls_marca = gs_parametros[6];
        ls_civ = gs_parametros[7];
        ls_codigo_vehiculo_v2 = gs_parametros[8];
        ls_marca_v2 = gs_parametros[9];
        ls_civ_v2 = gs_parametros[10];
        ls_codigo_direccion = gs_parametros[11];
        ls_descripcion = gs_parametros[12];
        ls_punto_llegada = gs_parametros[13];
        ls_codigo_ubigeo_ls = gs_parametros[14];
        ls_descripcion_ubigeo = gs_parametros[15];
        limpia_parametros();
    }

    private void limpia_transportista() {
        ls_codigo_transportista = "";
        ls_nombre_transportista = "";
        ls_licencia = "";
        ls_empresa = "";
        ls_ruc = "";
        ls_codigo_vehiculo = "";
        ls_marca = "";
        ls_civ = "";
        ls_codigo_vehiculo_v2 = "";
        ls_marca_v2 = "";
        ls_civ_v2 = "";
        ls_codigo_direccion = "";
        ls_descripcion = "";
        ls_punto_llegada = "";
        ls_codigo_ubigeo_ls = "";
        ls_descripcion_ubigeo = "";
    }

    private void get_descripcion_entidad(String codigo) {
        String dato;
        dato = (lo_pnl_cab_guiar.CBX_tipo_documento_id.getSelectedIndex() == 0) ? "6" : "1";
        try {
            lq_rs = go_dao_entidad.SLT_datos_entidad_x_facturacion(codigo, dato);
            if (lq_rs != null) {
                lo_pnl_cab_guiar.TXT_codigo_entidad.setText(lq_rs.getString(1));
                lo_pnl_cab_guiar.TXT_razon_social.setText(lq_rs.getString(2));
                lo_pnl_cab_guiar.TXT_doc_id.setText(lq_rs.getString(3));
                lo_pnl_cab_guiar.JRD_domiciliado.setSelected(go_fnc_operaciones_campos.int_boolean(lq_rs.getInt(4)));
                lo_pnl_cab_guiar.TXT_codigo_pagador.setText(lq_rs.getString(1));
                lo_pnl_cab_guiar.TXT_pagador.setText(lq_rs.getString(2));
                lo_pnl_cab_guiar.TXT_codigo_vendedor.setText(lq_rs.getString(5));
                lo_pnl_cab_guiar.TXT_nombre_vendedor.setText(lq_rs.getString(6));
                lo_pnl_cab_guiar.TXT_dias_credito.setText(lq_rs.getString(8));
                go_cbx_trato_datos.selecciona_valor(20, lq_rs.getString(12), lo_pnl_cab_guiar.CBX_sector);

                go_cbx_trato_datos.recupera_valor(16, lq_rs, lo_pnl_cab_guiar.CBX_direccion);
                lo_cbx_entidad_ubigeo = (cbx_entidad_ubigeo) lo_pnl_cab_guiar.CBX_direccion.getSelectedItem();
                lo_pnl_cab_guiar.TXT_codigo_ubigeo.setText(lo_cbx_entidad_ubigeo.getID());
                lo_pnl_cab_guiar.TXT_descripcion.setText(lo_cbx_entidad_ubigeo.descripcion());
                lo_pnl_cab_guiar.CBX_afecto_igv.setSelectedIndex((!lo_pnl_cab_guiar.JRD_domiciliado.isSelected()) ? 0 : 1);
                get_forma_pago(lo_pnl_cab_guiar.TXT_codigo_pagador.getText().trim());

                getFocusOwner().transferFocus();
            } else {
                go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_buscar", "ENTIDAD NO EXISTE y/o NO HABILITADO");
                lo_pnl_cab_guiar.TXT_codigo_entidad.setText("");
                lo_pnl_cab_guiar.TXT_razon_social.setText("");
                lo_pnl_cab_guiar.TXT_doc_id.setText("");
                lo_pnl_cab_guiar.CBX_direccion.removeAllItems();
                lo_pnl_cab_guiar.TXT_codigo_ubigeo.setText("");
                lo_pnl_cab_guiar.TXT_descripcion.setText("");
                lo_pnl_cab_guiar.CBX_forma_pago.setEnabled(false);
            }
        } catch (Exception e) {
        }
    }

    private void get_descripcion_guiar(String codigo) {
        try {
            lq_rs = go_dao_guia_remision.SLT_datos_guia_remision(codigo);
            if (lq_rs != null) {
                lo_evt_cab_guiar.setea_recupera(lo_bean_guia_remision, lq_rs);
                lo_evt_cab_guiar.muestra_datos(lo_pnl_cab_guiar, lo_bean_guia_remision, lo_pnl_grid_pedidos);
                lo_cbx_moneda = (cbx_moneda) lo_pnl_cab_guiar.CBX_moneda.getSelectedItem();
                lo_pnl_grid_pedidos.LBL_simbolo.setText("Imp (" + lo_cbx_moneda.simbolo_moneda().trim() + ")");
                ls_codigo_pedido = lo_bean_guia_remision.getCodigo_pedido();
                ls_codigo_transportista = lo_bean_guia_remision.getCodigo_transportista();
                ls_nombre_transportista = lo_bean_guia_remision.getNombre_transportista();
                ls_licencia = lo_bean_guia_remision.getNumero_licencia();
                ls_empresa = lo_bean_guia_remision.getRazon_social_trans();
                ls_ruc = lo_bean_guia_remision.getRuc_trans();
                ls_codigo_vehiculo = lo_bean_guia_remision.getCodigo_vehiculo();
                ls_marca = lo_bean_guia_remision.getMarca();
                ls_civ = lo_bean_guia_remision.getNumero_civ();
                ls_codigo_vehiculo_v2 = lo_bean_guia_remision.getCodigo_vehiculo_2();
                ls_marca_v2 = lo_bean_guia_remision.getMarca_2();
                ls_civ_v2 = lo_bean_guia_remision.getNumero_civ_2();
                ls_codigo_direccion = lo_bean_guia_remision.getCodigo_direccion_pl();
                ls_descripcion = lo_bean_guia_remision.getNombre_direccion_pl();
                ls_punto_llegada = lo_bean_guia_remision.getPunto_llegada();
                ls_codigo_ubigeo_ls = lo_bean_guia_remision.getCodigo_ubigeo_pl();
                ls_descripcion_ubigeo = lo_bean_guia_remision.getDescripcion_ubigeo_pl();
                get_descripcion_guia_remision_detalle(codigo);
            }
        } catch (Exception e) {
        }
    }

    private void get_descripcion_guia_remision_detalle(String codigo) {
        lo_evt_grid_pedidos.limpia_tabla(lo_pnl_grid_pedidos, li_tipo_operacion);
        lq_rs = go_dao_guia_remision_detalle.SLT_datos_guia_remision_detalle(codigo);
        lo_evt_grid_pedidos.recupera_detalle(lq_rs, lo_pnl_grid_pedidos, Integer.parseInt(lo_bean_guia_remision.getEs_precio_igv()), 1);
        lo_evt_grid_pedidos.calculo_utilidad(lo_pnl_grid_pedidos);
    }

    private void get_forma_pago(String codigo) {
        try {
            lq_rs = go_dao_entidad.SLT_datos_forma_pago(codigo);
            if (lq_rs != null) {
                lo_pnl_cab_guiar.CBX_forma_pago.setSelectedIndex(lq_rs.getInt(1));
                lo_pnl_cab_guiar.TXT_dias_credito.setText(lq_rs.getInt(2) + "");
                lo_pnl_cab_guiar.CBX_forma_pago.setEnabled((lq_rs.getInt(1) == 1) ? true : false);
                lo_pnl_cab_guiar.TXT_dias_credito.setEnabled((lq_rs.getInt(1) == 1) ? true : false);
            }
        } catch (Exception e) {
        }
    }

    private void genera_peso_neto(int fila) {
        if (Integer.parseInt(lo_pnl_grid_pedidos.TBL_pedidos.getValueAt(fila, 2).toString()) > 0 && Double.parseDouble(lo_pnl_grid_pedidos.TBL_pedidos.getValueAt(fila, 15).toString()) > 0) {
            lo_pnl_grid_pedidos.TBL_pedidos.setValueAt((Double.parseDouble(lo_pnl_grid_pedidos.TBL_pedidos.getValueAt(fila, 15).toString()) * Integer.parseInt(lo_pnl_grid_pedidos.TBL_pedidos.getValueAt(lo_pnl_grid_pedidos.TBL_pedidos.getSelectedRow(), 2).toString())), fila, 11);
        }
    }

    private void genera_peso_bruto(int fila) {
        try {
            double peso_bruto = (double) lo_pnl_grid_pedidos.TBL_pedidos.getValueAt(fila, 11) + ((double) lo_pnl_grid_pedidos.TBL_pedidos.getValueAt(fila, 5) * (int) lo_pnl_grid_pedidos.TBL_pedidos.getValueAt(fila, 2));
            lo_pnl_grid_pedidos.TBL_pedidos.setValueAt(peso_bruto, fila, 10);
        } catch (Exception e) {
        }
    }

    private void genera_importe(int fila) {
        try {
            if ((boolean) lo_pnl_grid_pedidos.TBL_pedidos.getValueAt(fila, 1)) {
                double importe = (double) lo_pnl_grid_pedidos.TBL_pedidos.getValueAt(fila, 9) * (int) lo_pnl_grid_pedidos.TBL_pedidos.getValueAt(fila, 2);
                lo_pnl_grid_pedidos.TBL_pedidos.setValueAt(importe, fila, 12);
            } else {
                double importe = (double) lo_pnl_grid_pedidos.TBL_pedidos.getValueAt(fila, 9) * (double) lo_pnl_grid_pedidos.TBL_pedidos.getValueAt(fila, 11);
                lo_pnl_grid_pedidos.TBL_pedidos.setValueAt(importe, fila, 12);
            }

        } catch (Exception e) {
        }
    }

    private void genera_parametros_anula() {
        gs_parametros[0] = ls_codigo_sucursal;
        gs_parametros[1] = lo_pnl_cab_guiar.TXT_sucursal.getText().trim();
        gs_parametros[2] = "09";
        gs_parametros[3] = ls_serie;
        gs_parametros[4] = gs_dia + "/" + gs_mes + "/" + gs_periodo;
    }

    private void genera_parametros_busq() {
        gs_parametros[0] = ls_codigo_sucursal;
        gs_parametros[1] = "01/" + gs_mes + "/" + gs_periodo;
        gs_parametros[2] = gs_dia + "/" + gs_mes + "/" + gs_periodo;
        gs_parametros[3] = lo_pnl_cab_guiar.TXT_serie.getText().trim();
        gs_parametros[4] = "%";
        gs_parametros[5] = "%";
    }

    private void activa_facturacion(boolean valor) {
        lo_pnl_cab_guiar.TXT_razon_social.setEnabled(valor);
        lo_pnl_cab_guiar.TXT_doc_id.setEnabled(valor);
        lo_pnl_cab_guiar.TXT_doc_id.setEnabled(valor);
        lo_pnl_cab_guiar.CBX_direccion.setEditable(valor);
        lo_pnl_cab_guiar.TXT_codigo_ubigeo.setEnabled(valor);

        lo_pnl_cab_guiar.TXT_razon_social.setText("");
        lo_pnl_cab_guiar.TXT_doc_id.setText("");
        lo_pnl_cab_guiar.TXT_doc_id.setText("");
        lo_pnl_cab_guiar.TXT_codigo_ubigeo.setText("");
        lo_pnl_cab_guiar.TXT_descripcion.setText("");

        try {
            lo_pnl_cab_guiar.CBX_direccion.removeAllItems();
        } catch (Exception e) {
        }
    }

    private void limpia_parametros() {
        gs_parametros[0] = "";
    }

    private void evt_f5_transportista() {
        if (go_fnc_operaciones_campos.campo_blanco(lo_pnl_cab_guiar.TXT_codigo_entidad)) {
            gs_parametros[0] = lo_pnl_cab_guiar.TXT_codigo_entidad.getText().trim();
            go_dlg_datos_pl = new dlg_datos_pl(null, true);
            go_dlg_datos_pl.setVisible(true);
            get_datos_transportista();
            lo_pnl_cab_guiar.TXT_transportista.setText(ls_codigo_transportista);
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_f5_transportista", "SELECCIONE ENTIDAD");
            lo_pnl_cab_guiar.TXT_codigo_entidad.requestFocus();
        }
    }

    private void evt_f5_entidad() {
        get_parametros_entidad();
        go_dlg_busq_entidad_parametros = new dlg_busq_entidad_parametros(null, true);
        go_dlg_busq_entidad_parametros.setVisible(true);
        ls_codigo_entidad = go_dlg_busq_entidad_parametros.ls_codigo_entidad;
        if (ls_codigo_entidad != null) {
            get_descripcion_entidad(ls_codigo_entidad);
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_f5_entidad", "SELECCIONE ENTIDAD");
            lo_pnl_cab_guiar.TXT_codigo_entidad.setText("");
        }
    }

    private void evt_f5_facturacion() {
        lo_cbx_grupo_detraccion = (cbx_grupo_detraccion) lo_pnl_cab_guiar.CBX_codigo_detraccion.getSelectedItem();
        gs_parametros[0] = ls_codigo_sucursal;
        gs_parametros[1] = lo_pnl_cab_guiar.CBX_doc_ref.getSelectedIndex() + "";
        gs_parametros[2] = lo_cbx_grupo_detraccion.getID();
        go_dlg_busq_facturacion = new dlg_busq_facturacion(null, true);
        go_dlg_busq_facturacion.setVisible(true);
        ls_codigo_articulo = gs_parametros[0];
        if (!ls_codigo_articulo.equalsIgnoreCase("") || ls_codigo_articulo != null) {
            try {
                lq_rs = go_dao_precios.SLT_datos_precio_x_articulo(ls_codigo_articulo, go_fnc_operaciones_campos.boolean_int((boolean) lo_pnl_grid_pedidos.TBL_pedidos.getValueAt(lo_pnl_grid_pedidos.TBL_pedidos.getSelectedRow(), 1)) + "", gs_tipo_comercio);
                if (lq_rs != null) {
                    lo_pnl_grid_pedidos.TBL_pedidos.setValueAt(lq_rs.getString(1), lo_pnl_grid_pedidos.TBL_pedidos.getSelectedRow(), 3);
                    lo_pnl_grid_pedidos.TBL_pedidos.setValueAt(lq_rs.getString(2), lo_pnl_grid_pedidos.TBL_pedidos.getSelectedRow(), 4);
                    lo_pnl_grid_pedidos.TBL_pedidos.setValueAt(lq_rs.getDouble(3), lo_pnl_grid_pedidos.TBL_pedidos.getSelectedRow(), 5);
                    lo_pnl_grid_pedidos.TBL_pedidos.setValueAt(lq_rs.getString(4), lo_pnl_grid_pedidos.TBL_pedidos.getSelectedRow(), 6);
                    lo_pnl_grid_pedidos.TBL_pedidos.setValueAt(go_fnc_operaciones_campos.int_boolean(Integer.parseInt(lq_rs.getString(5))), lo_pnl_grid_pedidos.TBL_pedidos.getSelectedRow(), 7);
                    lo_pnl_grid_pedidos.TBL_pedidos.setValueAt(lq_rs.getDouble(6), lo_pnl_grid_pedidos.TBL_pedidos.getSelectedRow(), 8);
                    lo_pnl_grid_pedidos.TBL_pedidos.setValueAt(lq_rs.getDouble(8), lo_pnl_grid_pedidos.TBL_pedidos.getSelectedRow(), 9);
                    lo_pnl_grid_pedidos.TBL_pedidos.setValueAt(lq_rs.getDouble(7), lo_pnl_grid_pedidos.TBL_pedidos.getSelectedRow(), 15);
                    lo_pnl_grid_pedidos.TBL_pedidos.setValueAt(lq_rs.getDouble(9), lo_pnl_grid_pedidos.TBL_pedidos.getSelectedRow(), 16);
                }
            } catch (Exception e) {
            }
        }
        limpia_parametros();
    }

    private void evt_f5_seleccion_pedido() {
        lo_cbx_tabla_ayuda = (cbx_tabla_ayuda) lo_pnl_cab_guiar.CBX_tipo_op.getSelectedItem();
        gs_parametros[0] = ls_serie;
        gs_parametros[1] = ls_codigo_sucursal;
        gs_parametros[2] = "%";
        gs_parametros[3] = lo_cbx_tabla_ayuda.getID();
        gi_parametros_2[0] = li_cantidad;
        ls_item_seleccion[0] = "0";
        ls_codigo_pedido = "";
        go_dlg_datos_seleccion_pedido = new dlg_datos_seleccion_pedido(null, true);
        go_dlg_datos_seleccion_pedido.setVisible(true);
        ls_item_seleccion = go_dlg_datos_seleccion_pedido.ls_item_seleccion;
        if (!ls_item_seleccion[0].equalsIgnoreCase("0")) {
            ls_codigo_pedido = ls_item_seleccion[0];
            try {
                lq_rs = go_dao_pedido.SLT_datos_ref_factura(0, ls_codigo_pedido);
                lo_pnl_cab_guiar.TXT_pedido.setText(ls_codigo_pedido.substring(6));
                if (lq_rs != null) {
                    lo_evt_cab_guiar.activa_campos(0, lo_pnl_cab_guiar, false);
                    lo_evt_cab_guiar.muestra_datos_ref(lq_rs, ls_codigo_pedido, lo_pnl_cab_guiar, lo_pnl_grid_pedidos);
                    lq_rs = go_dao_pedido_detalle.SLT_datos_pedido_detalle_x_item(ls_item_seleccion[0], ls_item_seleccion[1]);
                    if (lq_rs != null) {
                        lo_evt_grid_pedidos.recupera_detalle(lq_rs, lo_pnl_grid_pedidos, go_fnc_operaciones_campos.boolean_int(lo_pnl_cab_guiar.JRD_precio_igv.isSelected()), 1);
                        lo_evt_grid_pedidos.suma_importes(lo_pnl_cab_guiar.CBX_afecto_igv.getSelectedIndex(), Double.parseDouble(lo_pnl_cab_guiar.CBX_igv.getSelectedItem().toString()) / 100, lo_pnl_cab_guiar.JRD_precio_igv.isSelected(), lo_pnl_grid_pedidos, "");
                        lo_evt_grid_pedidos.calculo_utilidad(lo_pnl_grid_pedidos);
                    }
                    lo_pnl_cab_guiar.CBX_tipo_op.setEnabled(true);
                    lo_pnl_cab_guiar.TXT_numero_doc.setEnabled(true);
                    lo_pnl_cab_guiar.TXT_pedido.setEnabled(true);
                    lo_pnl_cab_guiar.TXT_fecha_emision.setEnabled(true);
                    lo_pnl_cab_guiar.TXT_serie_doc_ref.setEnabled(true);
                    lo_pnl_cab_guiar.TXT_doc_ref.setEnabled(true);
                    lo_pnl_cab_guiar.TXT_observacion.setEnabled(true);
                    lo_pnl_cab_guiar.TXT_transportista.setEnabled(true);
                    lo_pnl_cab_guiar.TXT_dias_credito.setEnabled(false);
                    lo_pnl_cab_guiar.TXT_serie_doc_ref.requestFocus();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void evt_f5_seleccion_pr() {
        lo_cbx_tabla_ayuda = (cbx_tabla_ayuda) lo_pnl_cab_guiar.CBX_tipo_op.getSelectedItem();
        gs_parametros[0] = ls_serie;
        gs_parametros[1] = ls_codigo_sucursal;
        gs_parametros[2] = "%";
        gs_parametros[3] = lo_cbx_tabla_ayuda.getID();
        gi_parametros_2[0] = li_cantidad;
        ls_item_seleccion[0] = "0";
        ls_codigo_pedido = "";
        go_dlg_datos_seleccion_pedido = new dlg_datos_seleccion_pedido(null, true);
        go_dlg_datos_seleccion_pedido.setVisible(true);
        ls_item_seleccion = go_dlg_datos_seleccion_pedido.ls_item_seleccion;
        if (!ls_item_seleccion[0].equalsIgnoreCase("0")) {
            ls_codigo_pedido = ls_item_seleccion[0];
            lo_pnl_cab_guiar.TXT_pedido.setText(ls_item_seleccion[0].substring(6));
            try {
                lq_rs = go_dao_programacion_detalle.SLT_datos_pr_detalle_x_item(ls_item_seleccion[0], ls_item_seleccion[1]);
                if (lq_rs != null) {
                    lo_evt_grid_pedidos.recupera_detalle_pr(lq_rs, lo_pnl_grid_pedidos);
                    for (int i = 0; i < lo_pnl_grid_pedidos.TBL_pedidos.getRowCount(); i++) {
                        genera_importe(i);
                    }
                    lo_evt_grid_pedidos.suma_importes(lo_pnl_cab_guiar.CBX_afecto_igv.getSelectedIndex(), Double.parseDouble(lo_pnl_cab_guiar.CBX_igv.getSelectedItem().toString()) / 100, lo_pnl_cab_guiar.JRD_precio_igv.isSelected(), lo_pnl_grid_pedidos, "");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void evt_nuevo() {
        ls_codigo = null;
        ls_codigo_pedido = "OP00000000000000";
        ls_codigo_transportista = "";
        ls_codigo_vehiculo = "";
        limpia_transportista();
        lo_evt_cab_guiar.limpia_datos(lo_pnl_cab_guiar);
        lo_evt_grid_pedidos.limpia_tabla(lo_pnl_grid_pedidos, li_tipo_operacion);
        li_tipo_operacion = 0;
        try {
            lq_rs = go_dao_guia_remision.FNC_correlativo_guia_remision(ls_tipo_documento_g, ls_serie, ls_codigo_sucursal);
            if (lq_rs.next()) {
                lo_pnl_cab_guiar.TXT_numero_doc.setText(lq_rs.getString(1));
                lo_pnl_cab_guiar.LBL_numero_doc.setText(lq_rs.getString(1));
            }
        } catch (Exception e) {
        }

        lo_evt_opciones_3.activa_btn_opciones(1, lo_pnl_opciones_3, lb_valor_op);
        lo_evt_cab_guiar.activa_campos(0, lo_pnl_cab_guiar, true);
        lo_evt_grid_pedidos.activa_campos(0, lo_pnl_grid_pedidos, true);
    }

    private void evt_buscar() {
        li_tipo_operacion = 2;
        genera_parametros_busq();
        go_dlg_busq_guia_remision = new dlg_busq_guia_remision(null, true);
        go_dlg_busq_guia_remision.setVisible(true);
        ls_codigo = go_dlg_busq_guia_remision.ls_codigo;
        if (ls_codigo != null) {
            ls_codigo = ls_codigo.substring(0, 2) + ls_serie + ls_codigo.substring(3, 13);
            get_descripcion_guiar(ls_codigo);
            lo_evt_opciones_3.activa_btn_opciones(2, lo_pnl_opciones_3, lb_valor_op);
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_buscar", "SELECCIONE DOCUMENTO");
            lo_evt_cab_guiar.limpia_datos(lo_pnl_cab_guiar);
            lo_evt_grid_pedidos.limpia_tabla(lo_pnl_grid_pedidos, li_tipo_operacion);
            lo_evt_opciones_3.activa_btn_opciones(0, lo_pnl_opciones_3, lb_valor_op);
        }
    }

    private void evt_eliminar() {
        if (go_dao_guia_remision_detalle.FNC_verifica_guia_facturado(ls_codigo) == 0) {
            if (go_fnc_mensaje.get_respuesta(0, "¿DESEA ELIMINAR DOCUMENTO Nro  09  - " + lo_bean_guia_remision.getNumero_documento() + "?") == 0) {
                try {
                    if (go_dao_guia_remision_detalle.DLT_guia_remision_detalle(ls_codigo)) {
                        if (go_dao_guia_remision.DLT_guia_remision(ls_codigo)) {
                            lo_evt_opciones_3.activa_btn_opciones(0, lo_pnl_opciones_3, lb_valor_op);
                            lo_evt_cab_guiar.activa_campos(0, lo_pnl_cab_guiar, false);
                            lo_evt_cab_guiar.limpia_datos(lo_pnl_cab_guiar);
                            lo_evt_grid_pedidos.activa_campos(0, lo_pnl_grid_pedidos, false);
                            lo_evt_grid_pedidos.limpia_tabla(lo_pnl_grid_pedidos, 1);
                        }
                    }
                } catch (Exception e) {
                }
            }
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_eliminar", "GUIA TIENE ITEMS FACTURADOS");
        }
    }

    private void evt_editar() {
        if (go_dao_guia_remision_detalle.FNC_verifica_guia_facturado(ls_codigo) == 0) {
            li_tipo_operacion = 1;
            cont = 0;
            lo_evt_opciones_3.activa_btn_opciones(3, lo_pnl_opciones_3, lb_valor_op);
            lo_evt_grid_pedidos.activa_campos(0, lo_pnl_grid_pedidos, true);
            if (lo_pnl_cab_guiar.CBX_es_pedido.getSelectedIndex() == 0) {
                lo_evt_cab_guiar.activa_campos(1, lo_pnl_cab_guiar, true);
            } else {
                lo_evt_cab_guiar.activa_campos(2, lo_pnl_cab_guiar, true);
            }
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_editar", "GUIA TIENE ITEMS FACTURADOS");
        }
    }

    private void evt_guardar() {
        lo_cbx_moneda = (cbx_moneda) lo_pnl_cab_guiar.CBX_moneda.getSelectedItem();
        lo_cbx_grupo_detraccion = (cbx_grupo_detraccion) lo_pnl_cab_guiar.CBX_codigo_detraccion.getSelectedItem();
        lo_cbx_igv = (cbx_igv) lo_pnl_cab_guiar.CBX_igv.getSelectedItem();
        lo_cbx_tabla_ayuda = (cbx_tabla_ayuda) lo_pnl_cab_guiar.CBX_tipo_op.getSelectedItem();
        lo_cbx_sector = (cbx_sector_distribucion) lo_pnl_cab_guiar.CBX_sector.getSelectedItem();

        lo_bean_guia_remision.setCodigo_sucursal(ls_codigo_sucursal);
        lo_bean_guia_remision.setCodigo_pedido(ls_codigo_pedido);
        lo_bean_guia_remision.setCodigo_transportista(ls_codigo_transportista);
        lo_bean_guia_remision.setNombre_transportista(ls_nombre_transportista);
        lo_bean_guia_remision.setNumero_licencia(ls_licencia);
        lo_bean_guia_remision.setRazon_social_trans(ls_empresa);
        lo_bean_guia_remision.setRuc_trans(ls_ruc);
        lo_bean_guia_remision.setCodigo_vehiculo(ls_codigo_vehiculo);
        lo_bean_guia_remision.setMarca(ls_marca);
        lo_bean_guia_remision.setNumero_civ(ls_civ);
        lo_bean_guia_remision.setCodigo_vehiculo_2(ls_codigo_vehiculo_v2);
        lo_bean_guia_remision.setMarca_2(ls_marca_v2);
        lo_bean_guia_remision.setNumero_civ_2(ls_civ_v2);
        lo_bean_guia_remision.setCodigo_direccion_pl(ls_codigo_direccion);
        lo_bean_guia_remision.setNombre_direccion_pl(ls_descripcion);
        lo_bean_guia_remision.setPunto_llegada(ls_punto_llegada);
        lo_bean_guia_remision.setCodigo_ubigeo_pl(ls_codigo_ubigeo_ls);
        lo_bean_guia_remision.setDescripcion_ubigeo_pl(ls_descripcion_ubigeo);

        switch (li_tipo_operacion) {
            case 0:
                if (lo_evt_cab_guiar.valida_campos(lo_pnl_cab_guiar, lo_cbx_moneda, ls_codigo_transportista, ls_codigo_direccion)) {
                    if (lo_evt_grid_pedidos.valida_campos(lo_pnl_grid_pedidos, li_cantidad)) {
                        try {
                            ls_codigo = "09" + ls_serie + lo_pnl_cab_guiar.TXT_numero_doc.getText().trim();
                            lo_bean_guia_remision.setCodigo_operacion(ls_codigo);
                            lo_evt_cab_guiar.setea_campos(lo_bean_guia_remision, lo_pnl_cab_guiar, lo_cbx_grupo_detraccion, lo_cbx_moneda, lo_cbx_igv, lo_cbx_tabla_ayuda, lo_cbx_sector, lo_pnl_grid_pedidos, ld_monto_minimo);
                            if (go_dao_guia_remision.IST_guia_remision(lo_bean_guia_remision, lo_pnl_grid_pedidos.TBL_pedidos, Double.parseDouble(lo_pnl_cab_guiar.CBX_igv.getSelectedItem().toString()) / 100)) {
                                lo_evt_cab_guiar.limpia_datos(lo_pnl_cab_guiar);
                                lo_evt_cab_guiar.activa_campos(0, lo_pnl_cab_guiar, false);
                                lo_evt_grid_pedidos.limpia_tabla(lo_pnl_grid_pedidos, li_tipo_operacion);
                                lo_evt_grid_pedidos.activa_campos(0, lo_pnl_grid_pedidos, false);
                                lo_evt_opciones_3.activa_btn_opciones(0, lo_pnl_opciones_3, lb_valor_op);
                                if (go_fnc_mensaje.get_respuesta(0, "¿DESEA IMPRIMIR DOCUMENTO Nro  09  - " + lo_bean_guia_remision.getNumero_documento() + "?") == 0) {
                                    try {
                                        evt_imprimir(lo_bean_guia_remision.getStatus(), lo_bean_guia_remision.getCodigo_operacion());
                                    } catch (Exception e) {
                                        //System.out.println("1 "+e.getMessage());
                                    }
                                }
                            }
                        } catch (Exception e) {
                            //System.out.println("2 "+e.getMessage());
                        }
                    }
                }
                break;
            case 1:
                if (lo_evt_cab_guiar.verifica_cambios(lo_bean_guia_remision, lo_pnl_cab_guiar, lo_cbx_grupo_detraccion, lo_cbx_moneda, lo_cbx_igv, lo_cbx_sector) || cont != 0) {
                    if (lo_evt_grid_pedidos.valida_campos(lo_pnl_grid_pedidos, li_cantidad)) {
                        if (lo_evt_grid_pedidos.valida_campos(lo_pnl_grid_pedidos, li_cantidad)) {
                            try {
                                lo_evt_cab_guiar.setea_campos(lo_bean_guia_remision, lo_pnl_cab_guiar, lo_cbx_grupo_detraccion, lo_cbx_moneda, lo_cbx_igv, lo_cbx_tabla_ayuda, lo_cbx_sector, lo_pnl_grid_pedidos, ld_monto_minimo);
                                if (go_dao_guia_remision_detalle.DLT_guia_remision_detalle(ls_codigo)) {
                                    if (go_dao_guia_remision.UPD_guia_remision(lo_bean_guia_remision, lo_pnl_grid_pedidos.TBL_pedidos, Double.parseDouble(lo_pnl_cab_guiar.CBX_igv.getSelectedItem().toString()) / 100)) {
                                        lo_evt_cab_guiar.limpia_datos(lo_pnl_cab_guiar);
                                        lo_evt_cab_guiar.activa_campos(0, lo_pnl_cab_guiar, false);
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

    private void evt_anular() {
        genera_parametros_anula();
        go_dlg_anula_factura = new dlg_anula_factura(null, true);
        go_dlg_anula_factura.setVisible(true);
    }

    private void evt_imprimir(String status, String codigo) {
        if (status.equalsIgnoreCase("1")) {
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("codigo_operacion", codigo);
            parametros.put("periodo", gs_periodo);
            parametros.put(JRParameter.REPORT_LOCALE, Locale.ENGLISH);
            go_evt_imprime_doc_ventas.imprime_documentos(0, "rpt_formato_guiar_" + ls_serie + "_" + go_bean_general.getRuc() + ".jasper", parametros);
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_imprimir", "DOCUMENTO NO SE PUEDE IMPRIMIR");
        }
    }

    private void evt_cancelar() {
        li_tipo_operacion = 2;
        lo_evt_cab_guiar.activa_campos(0, lo_pnl_cab_guiar, false);
        lo_evt_grid_pedidos.activa_campos(0, lo_pnl_grid_pedidos, false);
        lo_evt_grid_pedidos.limpia_tabla(lo_pnl_grid_pedidos, li_tipo_operacion);
        if (ls_codigo != null) {
            lo_evt_cab_guiar.muestra_datos(lo_pnl_cab_guiar, lo_bean_guia_remision, lo_pnl_grid_pedidos);
            get_descripcion_guiar(ls_codigo);
            lo_evt_opciones_3.activa_btn_opciones(2, lo_pnl_opciones_3, lb_valor_op);
        } else {
            lo_evt_cab_guiar.limpia_datos(lo_pnl_cab_guiar);
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
            if (ae.getSource() == lo_pnl_opciones_3.BTN_anular) {
                evt_anular();
            }
            if (ae.getSource() == lo_pnl_opciones_3.BTN_imprimir) {
                evt_imprimir(lo_bean_guia_remision.getStatus(), lo_bean_guia_remision.getCodigo_operacion());
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
                if (ke.getSource() == lo_pnl_cab_guiar.TXT_codigo_entidad) {
                    evt_f5_entidad();
                }
                if (ke.getSource() == lo_pnl_cab_guiar.TXT_transportista) {
                    evt_f5_transportista();
                }
                if (ke.getSource() == lo_pnl_cab_guiar.TXT_pedido) {
                    lo_cbx_tabla_ayuda = (cbx_tabla_ayuda) lo_pnl_cab_guiar.CBX_tipo_op.getSelectedItem();
                    if (!lo_cbx_tabla_ayuda.getID().equalsIgnoreCase("05")) {
                        evt_f5_seleccion_pedido();
                    } else {
                        evt_f5_seleccion_pr();
                    }
                }
                if (ke.getSource() == lo_pnl_cab_guiar.TXT_codigo_vendedor) {
                    go_activa_buscador.busq_vendedor(lo_pnl_cab_guiar.TXT_codigo_vendedor, lo_pnl_cab_guiar.TXT_nombre_vendedor);
                }
                if (ke.getSource() == lo_pnl_grid_pedidos.TBL_pedidos && lo_pnl_grid_pedidos.TBL_pedidos.getSelectedColumn() == 3) {
                    evt_f5_facturacion();
                }
                if (ke.getSource() == lo_pnl_cab_guiar.TXT_codigo_pagador) {
                    go_activa_buscador.busq_entidad(lo_pnl_cab_guiar.TXT_codigo_pagador, lo_pnl_cab_guiar.TXT_pagador);
                    get_forma_pago(lo_pnl_cab_guiar.TXT_codigo_pagador.getText());
                }
                if (ke.getSource() == lo_pnl_cab_guiar.TXT_codigo_ubigeo) {
                    go_activa_buscador.busq_ubigeo(lo_pnl_cab_guiar.TXT_codigo_ubigeo, lo_pnl_cab_guiar.TXT_descripcion);
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
                if (ke.getSource() == lo_pnl_opciones_3.BTN_anular) {
                    evt_anular();
                }
                if (ke.getSource() == lo_pnl_opciones_3.BTN_cancelar) {
                    evt_cancelar();
                }
                if (ke.getSource() == lo_pnl_opciones_3.BTN_imprimir) {
                    evt_imprimir(lo_bean_guia_remision.getStatus(), lo_bean_guia_remision.getCodigo_operacion());
                }
                if (ke.getSource() == lo_pnl_cab_guiar.TXT_numero_doc) {
                    if (go_fnc_operaciones_campos.campo_blanco(lo_pnl_cab_guiar.TXT_numero_doc)) {
                        lo_pnl_cab_guiar.TXT_numero_doc.setText(go_fnc_operaciones_campos.completa_digitos(lo_pnl_cab_guiar.TXT_numero_doc.getText().trim(), "0", 10));
                        lo_pnl_cab_guiar.LBL_numero_doc.setText(lo_pnl_cab_guiar.TXT_numero_doc.getText());
                        getFocusOwner().transferFocus();
                    }
                }
                if (ke.getSource() == lo_pnl_cab_guiar.CBX_forma_pago || ke.getSource() == lo_pnl_cab_guiar.CBX_tipo_op || ke.getSource() == lo_pnl_cab_guiar.CBX_doc_ref || ke.getSource() == lo_pnl_cab_guiar.CBX_moneda || ke.getSource() == lo_pnl_cab_guiar.CBX_codigo_detraccion || ke.getSource() == lo_pnl_cab_guiar.JRD_precio_igv) {
                    getFocusOwner().transferFocus();
                }
                if (ke.getSource() == lo_pnl_cab_guiar.TXT_pedido && go_fnc_operaciones_campos.cant_caracter(lo_pnl_cab_guiar.TXT_pedido.getText().trim(), 4, 10)) {
                    getFocusOwner().transferFocus();
                }
                if (ke.getSource() == lo_pnl_cab_guiar.TXT_fecha_emision && !lo_pnl_cab_guiar.TXT_fecha_emision.getText().trim().equalsIgnoreCase("/  /")) {
                    if (go_fnc_operaciones_campos.valida_fecha(lo_pnl_cab_guiar.TXT_fecha_emision.getText())) {
                        if (go_fnc_operaciones_campos.valida_periodo(lo_pnl_cab_guiar.TXT_fecha_emision.getText(), gs_periodo)) {
                            getFocusOwner().transferFocus();
                        } else {
                            lo_pnl_cab_guiar.TXT_fecha_emision.setText("");
                            go_fnc_mensaje.GET_mensaje(0, ls_modulo, ls_capa, ls_clase, "keyPressed", "FECHA NO PERTENECE AL PERIODO");
                        }
                    } else {
                        lo_pnl_cab_guiar.TXT_fecha_emision.setText("");
                        go_fnc_mensaje.GET_mensaje(0, ls_modulo, ls_capa, ls_clase, "keyPressed", "FORMATO DE FECHA INVALIDO");
                    }
                }
                if (ke.getSource() == lo_pnl_cab_guiar.TXT_serie_doc_ref) {
                    if (go_fnc_operaciones_campos.campo_blanco(lo_pnl_cab_guiar.TXT_serie_doc_ref)) {
                        lo_pnl_cab_guiar.TXT_serie_doc_ref.setText(go_fnc_operaciones_campos.completa_digitos(lo_pnl_cab_guiar.TXT_serie_doc_ref.getText().trim(), "0", 4));
                        getFocusOwner().transferFocus();
                    }
                }
                if (ke.getSource() == lo_pnl_cab_guiar.TXT_doc_ref) {
                    if (go_fnc_operaciones_campos.campo_blanco(lo_pnl_cab_guiar.TXT_doc_ref)) {
                        lo_pnl_cab_guiar.TXT_doc_ref.setText(go_fnc_operaciones_campos.completa_digitos(lo_pnl_cab_guiar.TXT_doc_ref.getText().trim(), "0", 10));
                        getFocusOwner().transferFocus();
                    }
                }
                if (ke.getSource() == editor && go_fnc_operaciones_campos.cant_caracter(editor.getText().trim(), 1, 4)) {
                    getFocusOwner().transferFocus();
                }
                if (ke.getSource() == lo_pnl_cab_guiar.TXT_codigo_entidad && go_fnc_operaciones_campos.cant_caracter(lo_pnl_cab_guiar.TXT_codigo_entidad.getText().trim(), 4, 6)) {
                    if (li_tipo_operacion != 1) {
                        if (lo_pnl_cab_guiar.TXT_codigo_entidad.getText().trim().equalsIgnoreCase("999999")) {
                            activa_facturacion(true);
                            lo_pnl_cab_guiar.TXT_codigo_pagador.setText("999999");
                            lo_pnl_cab_guiar.TXT_pagador.setText("...");
                            get_forma_pago("999999");
                            lo_pnl_cab_guiar.TXT_razon_social.requestFocus();
                        } else {
                            activa_facturacion(false);
                            get_descripcion_entidad(lo_pnl_cab_guiar.TXT_codigo_entidad.getText().trim());
                        }
                    } else {
                        getFocusOwner().transferFocus();
                    }
                }
                if (ke.getSource() == lo_pnl_cab_guiar.TXT_razon_social && go_fnc_operaciones_campos.cant_caracter(lo_pnl_cab_guiar.TXT_razon_social.getText().trim(), 1, 4)) {
                    getFocusOwner().transferFocus();
                }
                if (ke.getSource() == lo_pnl_cab_guiar.TXT_doc_id) {
                    if (lo_evt_cab_guiar.valida_tipo_documento(lo_pnl_cab_guiar.CBX_tipo_documento_id.getSelectedIndex(), lo_pnl_cab_guiar.TXT_doc_id.getText().trim())) {
                        getFocusOwner().transferFocus();
                    } else {
                        go_fnc_mensaje.GET_mensaje(0, ls_modulo, ls_capa, ls_clase, "keyPressed", "DOCUMENTO DE IDENTIDAD INCORRECTO");
                        lo_pnl_cab_guiar.CBX_tipo_documento_id.requestFocus();
                    }
                }
                if (ke.getSource() == lo_pnl_cab_guiar.CBX_direccion && !lo_pnl_cab_guiar.CBX_direccion.getSelectedItem().toString().equalsIgnoreCase("")) {
                    getFocusOwner().transferFocus();
                }
                if (ke.getSource() == lo_pnl_cab_guiar.CBX_sector) {
                    getFocusOwner().transferFocus();
                }
                if (ke.getSource() == lo_pnl_cab_guiar.TXT_codigo_ubigeo && go_fnc_operaciones_campos.cant_caracter(lo_pnl_cab_guiar.TXT_codigo_ubigeo.getText().trim(), 4, 6)) {
                    go_activa_buscador.get_descripcion_ubigeo(lo_pnl_cab_guiar.TXT_codigo_ubigeo.getText().trim(), lo_pnl_cab_guiar.TXT_codigo_ubigeo, lo_pnl_cab_guiar.TXT_descripcion);
                }
                if (ke.getSource() == lo_pnl_cab_guiar.TXT_codigo_pagador && go_fnc_operaciones_campos.cant_caracter(lo_pnl_cab_guiar.TXT_codigo_pagador.getText().trim(), 4, 6)) {
                    go_activa_buscador.get_descripcion_entidad(lo_pnl_cab_guiar.TXT_codigo_pagador.getText().trim(), lo_pnl_cab_guiar.TXT_codigo_pagador, lo_pnl_cab_guiar.TXT_pagador);
                    get_forma_pago(lo_pnl_cab_guiar.TXT_codigo_pagador.getText());
                }
                if (ke.getSource() == lo_pnl_cab_guiar.TXT_codigo_vendedor && go_fnc_operaciones_campos.cant_caracter(lo_pnl_cab_guiar.TXT_codigo_vendedor.getText().trim(), 4, 4)) {
                    go_activa_buscador.get_descripcion_vendedor(lo_pnl_cab_guiar.TXT_codigo_vendedor.getText().trim(), lo_pnl_cab_guiar.TXT_codigo_vendedor, lo_pnl_cab_guiar.TXT_nombre_vendedor);
                }
                if (ke.getSource() == lo_pnl_cab_guiar.TXT_dias_credito && go_fnc_operaciones_campos.campo_blanco(lo_pnl_cab_guiar.TXT_dias_credito)) {
                    getFocusOwner().transferFocus();
                }
                if (ke.getSource() == lo_pnl_cab_guiar.TXT_tipo_cambio && go_fnc_operaciones_campos.campo_blanco(lo_pnl_cab_guiar.TXT_tipo_cambio)) {
                    getFocusOwner().transferFocus();
                }
                if (ke.getSource() == lo_pnl_cab_guiar.TXT_observacion) {
                    getFocusOwner().transferFocus();
                }
                if (ke.getSource() == lo_pnl_cab_guiar.CBX_es_pedido) {
                    getFocusOwner().transferFocus();
                }
                if (ke.getSource() == lo_pnl_cab_guiar.TXT_transportista) {
                    if (!ls_codigo_direccion.equalsIgnoreCase("") && !ls_codigo_transportista.equalsIgnoreCase("")) {
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
        }

        @Override
        public void keyReleased(KeyEvent ke) {
            if (ke.getSource() == lo_pnl_cab_guiar.TXT_numero_doc) {
                lo_pnl_cab_guiar.LBL_numero_doc.setText(lo_pnl_cab_guiar.TXT_numero_doc.getText());
            }
            if (ke.getSource() == lo_pnl_grid_pedidos.TBL_pedidos) {
                int fila = lo_pnl_grid_pedidos.TBL_pedidos.getSelectedRow();
                genera_peso_neto(fila);
                genera_peso_bruto(fila);
                genera_importe(fila);
                lo_evt_grid_pedidos.suma_importes(lo_pnl_cab_guiar.CBX_afecto_igv.getSelectedIndex(), Double.parseDouble(lo_pnl_cab_guiar.CBX_igv.getSelectedItem().toString()) / 100, lo_pnl_cab_guiar.JRD_precio_igv.isSelected(), lo_pnl_grid_pedidos, "");
                lo_evt_grid_pedidos.calculo_utilidad(lo_pnl_grid_pedidos);

                if (lo_pnl_grid_pedidos.TBL_pedidos.getSelectedColumn() == 3) {
                    if (lo_pnl_grid_pedidos.TBL_pedidos.getValueAt(fila, 2) == null) {
                        lo_pnl_grid_pedidos.TBL_pedidos.setValueAt(0, fila, 2);
                        lo_pnl_grid_pedidos.TBL_pedidos.changeSelection(fila, 2, false, false);
                    }
                }
                if (lo_pnl_grid_pedidos.TBL_pedidos.getSelectedColumn() == 4) {
                    if (lo_pnl_grid_pedidos.TBL_pedidos.getValueAt(fila, 3).toString().trim().equalsIgnoreCase("")) {
                        lo_pnl_grid_pedidos.TBL_pedidos.changeSelection(fila, 3, false, false);
                    } else {
                        lo_pnl_grid_pedidos.TBL_pedidos.changeSelection(fila, 9, false, false);
                    }
                }
                if (lo_pnl_grid_pedidos.TBL_pedidos.getSelectedColumn() == 10) {
                    if (lo_pnl_grid_pedidos.TBL_pedidos.getValueAt(fila, 9) == null) {
                        lo_pnl_grid_pedidos.TBL_pedidos.changeSelection(fila, 9, false, false);
                    } else if ((Double) lo_pnl_grid_pedidos.TBL_pedidos.getValueAt(fila, 9) == 0 || (Double) lo_pnl_grid_pedidos.TBL_pedidos.getValueAt(fila, 9) < (Double) lo_pnl_grid_pedidos.TBL_pedidos.getValueAt(fila, 16)) {
                        lo_pnl_grid_pedidos.TBL_pedidos.setValueAt(null, fila, 9);
                        lo_pnl_grid_pedidos.TBL_pedidos.changeSelection(fila, 9, false, false);
                    } else {
                        lo_cbx_moneda = (cbx_moneda) lo_pnl_cab_guiar.CBX_moneda.getSelectedItem();
                        double precio_sigv = Double.parseDouble(lo_pnl_grid_pedidos.TBL_pedidos.getValueAt(fila, 9).toString());
                        precio_sigv = (lo_pnl_cab_guiar.JRD_precio_igv.isSelected() == true) ? precio_sigv : (precio_sigv) / (1 + (Double.parseDouble(lo_pnl_cab_guiar.CBX_igv.getSelectedItem().toString()) / 100));
                        lo_pnl_grid_pedidos.TBL_pedidos.setValueAt(go_dao_reportes.RPT_utilidad_ponderada(ls_codigo_sucursal, lo_pnl_grid_pedidos.TBL_pedidos.getValueAt(fila, 3).toString(), precio_sigv, lo_cbx_moneda.getID(), (ls_codigo == null) ? "%" : ls_codigo), fila, 13);
                        //lo_pnl_grid_pedidos.TBL_pedidos.changeSelection(fila, 10, false, false);
                    }
                }
                if (lo_pnl_grid_pedidos.TBL_pedidos.getSelectedColumn() == 12) {
                    if (lo_pnl_grid_pedidos.TBL_pedidos.getValueAt(fila, 11) == null) {
                        lo_pnl_grid_pedidos.TBL_pedidos.changeSelection(fila, 11, false, false);
                    } else if ((Double) lo_pnl_grid_pedidos.TBL_pedidos.getValueAt(fila, 11) == 0) {
                        lo_pnl_grid_pedidos.TBL_pedidos.setValueAt(null, fila, 11);
                        lo_pnl_grid_pedidos.TBL_pedidos.changeSelection(fila, 11, false, false);
                    }
                }
                if (lo_pnl_grid_pedidos.TBL_pedidos.getSelectedColumn() == 13) {
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
                if (ie.getSource() == lo_pnl_cab_guiar.CBX_doc_ref) {
                    lo_pnl_cab_guiar.TXT_codigo_entidad.setText("");
                    lo_pnl_cab_guiar.TXT_razon_social.setText("");
                    lo_pnl_cab_guiar.TXT_doc_id.setText("");
                    lo_pnl_cab_guiar.JRD_domiciliado.setSelected(false);
                    lo_pnl_cab_guiar.CBX_direccion.removeAllItems();
                    lo_pnl_cab_guiar.TXT_codigo_ubigeo.setText("");
                    lo_pnl_cab_guiar.TXT_descripcion.setText("");
                    lo_pnl_cab_guiar.CBX_codigo_detraccion.setSelectedIndex(0);
                    if (lo_pnl_cab_guiar.CBX_doc_ref.getSelectedIndex() == 0) {
                        lo_pnl_cab_guiar.CBX_tipo_documento_id.setSelectedIndex(0);
                        lo_pnl_cab_guiar.CBX_codigo_detraccion.setEnabled(true);
                    } else {
                        lo_pnl_cab_guiar.CBX_codigo_detraccion.setEnabled(false);
                        lo_pnl_cab_guiar.CBX_tipo_documento_id.setSelectedIndex(1);
                    }
                }
                if (ie.getSource() == lo_pnl_cab_guiar.CBX_moneda) {
                    get_tipo_cambio();
                }
                if (ie.getSource() == lo_pnl_cab_guiar.CBX_es_pedido && li_tipo_operacion == 0) {
                    switch (lo_pnl_cab_guiar.CBX_es_pedido.getSelectedIndex()) {
                        case 0:
                            lo_pnl_cab_guiar.TXT_pedido.setEnabled(false);
                            lo_pnl_cab_guiar.TXT_pedido.setText("0000000000");
                            break;
                        case 1:
                            lo_pnl_cab_guiar.TXT_pedido.setEnabled(true);
                            lo_pnl_cab_guiar.TXT_pedido.setText("");
                            break;
                    }
                }
                if (ie.getSource() == lo_pnl_cab_guiar.CBX_codigo_detraccion) {
                    get_porcentaje_detraccion();
                    lo_evt_grid_pedidos.limpia_tabla(lo_pnl_grid_pedidos, li_tipo_operacion);
                }
                if (ie.getSource() == lo_pnl_cab_guiar.CBX_direccion && !lo_pnl_cab_guiar.TXT_codigo_entidad.getText().trim().equalsIgnoreCase("")) {
                    if (!lo_pnl_cab_guiar.TXT_codigo_entidad.getText().trim().equalsIgnoreCase("999999")) {
                        lo_cbx_entidad_ubigeo = (cbx_entidad_ubigeo) lo_pnl_cab_guiar.CBX_direccion.getSelectedItem();
                        lo_pnl_cab_guiar.TXT_codigo_ubigeo.setText(lo_cbx_entidad_ubigeo.getID());
                        lo_pnl_cab_guiar.TXT_descripcion.setText(lo_cbx_entidad_ubigeo.descripcion());
                    }
                }
                if (ie.getSource() == lo_pnl_cab_guiar.CBX_forma_pago) {
                    if (lo_pnl_cab_guiar.CBX_forma_pago.getSelectedIndex() == 0) {
                        lo_pnl_cab_guiar.TXT_dias_credito.setText("0");
                        lo_pnl_cab_guiar.TXT_dias_credito.setEnabled(false);
                    } else {
                        lo_pnl_cab_guiar.TXT_dias_credito.setEnabled(true);
                    }
                }
                if (ie.getSource() == lo_pnl_cab_guiar.JRD_precio_igv) {
                    lo_evt_grid_pedidos.suma_importes(lo_pnl_cab_guiar.CBX_afecto_igv.getSelectedIndex(), Double.parseDouble(lo_pnl_cab_guiar.CBX_igv.getSelectedItem().toString()) / 100, lo_pnl_cab_guiar.JRD_precio_igv.isSelected(), lo_pnl_grid_pedidos, "");
                    lo_evt_grid_pedidos.calculo_utilidad(lo_pnl_grid_pedidos);
                }
                if (ie.getSource() == lo_pnl_cab_guiar.CBX_tipo_op) {
                    lo_cbx_tabla_ayuda = (cbx_tabla_ayuda) lo_pnl_cab_guiar.CBX_tipo_op.getSelectedItem();
                    switch (lo_cbx_tabla_ayuda.getID()) {
                        case "03":

                            break;
                    }
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
                        lo_evt_grid_pedidos.suma_importes(lo_pnl_cab_guiar.CBX_afecto_igv.getSelectedIndex(), Double.parseDouble(lo_pnl_cab_guiar.CBX_igv.getSelectedItem().toString()) / 100, lo_pnl_cab_guiar.JRD_precio_igv.isSelected(), lo_pnl_grid_pedidos, "");
                        lo_evt_grid_pedidos.calculo_utilidad(lo_pnl_grid_pedidos);
                    }
                }
                if (columna == 1) {
                    lo_evt_grid_pedidos.limpia_fila(lo_pnl_grid_pedidos, fila);
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
        setTitle("GUIA REMISION");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/JAVA/ANCESTRO/IMAGES/formulario.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1109, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 617, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
