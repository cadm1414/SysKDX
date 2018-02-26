package JAVA.VENTAS.GUI;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.ANCESTRO.GUI.pnl_opciones_3;
import JAVA.ANCESTRO.LOGICA.evt_opciones_3;
import JAVA.ANCESTRO.LOGICA.recupera_valor_op;
import JAVA.CONFIG.DAO.DAO_entidad;
import JAVA.CONFIG.GUI.dlg_busq_entidad_pr;
import JAVA.CONFIG.LOGICA.cbx_moneda;
import JAVA.CONFIG.LOGICA.cbx_tabla_ayuda;
import JAVA.DISTBR.GUI.dlg_busq_programacion;
import JAVA.INVENT.LOGICA.cbx_grupo_detraccion;
import JAVA.VENTAS.BEAN.BEAN_registro_ventas;
import JAVA.VENTAS.LOGICA.cbx_igv;
import JAVA.VENTAS.LOGICA.evt_cab_nota_credito;
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
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRParameter;

public class jif_nota_credito extends javax.swing.JInternalFrame {

    pnl_opciones_3 lo_pnl_opciones_3 = new pnl_opciones_3();
    evt_opciones_3 lo_evt_opciones_3 = new evt_opciones_3();
    pnl_cab_nota_credito lo_pnl_cab_nota_credito = new pnl_cab_nota_credito();
    evt_cab_nota_credito lo_evt_cab_nota_credito = new evt_cab_nota_credito();
    pnl_grid_pedidos lo_pnl_grid_pedidos = new pnl_grid_pedidos();
    evt_grid_pedidos lo_evt_grid_pedidos = new evt_grid_pedidos();
    static boolean lb_valor_op[] = new boolean[8];
    public static DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
    DecimalFormat dFormat;
    DefaultTableModel modelo;
    cbx_moneda lo_cbx_moneda;
    cbx_grupo_detraccion lo_cbx_grupo_detraccion;
    cbx_tabla_ayuda lo_cbx_tabla_ayuda;
    cbx_igv lo_cbx_igv;
    ResultSet lq_rs;
    recupera_valor_op lo_recupera_valor_op = new recupera_valor_op();
    BEAN_registro_ventas lo_bean_registro_ventas = new BEAN_registro_ventas();
    int li_tipo_operacion, cont = 0, li_cantidad;
    double ld_tipo_cambio, ld_porcentaje_detraccion, ld_monto_minimo;
    String ls_opcion = "M A F";
    String ls_codigo, ls_codigo_operacion, ls_codigo_sucursal, ls_serie, ls_tipo_documento, ls_codigo_ref, ls_codigo_articulo, ls_tipo_documento_ref, ls_fecha_ref, ls_entidad;
    String ls_modulo = "VENTAS", ls_capa = "GUI", ls_clase = "jif_nota_credito";

    public jif_nota_credito() {
        initComponents();
        formulario();
        activa_botones();
        get_igv();
        get_moneda();
        get_grupo_detraccion();
        get_concepto();
        lo_pnl_grid_pedidos.TBL_pedidos.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "selectNextColumnCell");
    }

    private void formulario() {
        lo_pnl_opciones_3.setBounds(0, 10, 1000, 110);
        lo_pnl_cab_nota_credito.setBounds(12, 120, 1100, 265);
        lo_pnl_grid_pedidos.setBounds(13, 390, 1100, 280);

        this.add(lo_pnl_opciones_3);
        this.add(lo_pnl_cab_nota_credito);
        this.add(lo_pnl_grid_pedidos);

        ls_codigo_sucursal = gs_parametros[0];
        ls_serie = gs_parametros[2];
        ls_tipo_documento = gs_parametros[3];
        lo_pnl_cab_nota_credito.TXT_sucursal.setText(gs_parametros[1]);
        lo_pnl_cab_nota_credito.TXT_serie.setText(gs_parametros[2]);

        li_cantidad = go_dao_serie.SLT_cant_items(ls_serie, ls_codigo_sucursal, (ls_tipo_documento.equalsIgnoreCase("07")) ? 4 : 5);

        modelo = (DefaultTableModel) lo_pnl_grid_pedidos.TBL_pedidos.getModel();
        modelo.addTableModelListener(TablaListener);

        lo_evt_opciones_3.evento_click(lo_pnl_opciones_3, Listener);
        lo_evt_opciones_3.evento_press(lo_pnl_opciones_3, KeyEvnt);
        lo_evt_cab_nota_credito.evento_press(lo_pnl_cab_nota_credito, KeyEvnt);
        lo_evt_cab_nota_credito.evento_item(lo_pnl_cab_nota_credito, ItemEvent);
        lo_evt_cab_nota_credito.evento_focus(lo_pnl_cab_nota_credito, FocusEvent);
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
            go_cbx_trato_datos.recupera_valor(0, lq_rs, lo_pnl_cab_nota_credito.CBX_moneda);
        }
    }

    private void get_igv() {
        lq_rs = go_dao_igv.SLT_cbx_igv();
        if (lq_rs != null) {
            go_cbx_trato_datos.recupera_valor(15, lq_rs, lo_pnl_cab_nota_credito.CBX_igv);
        }
    }

    private void get_grupo_detraccion() {
        lq_rs = go_dao_grupo_detraccion.SLT_cbx_grupo_detraccion("1");
        if (lq_rs != null) {
            go_cbx_trato_datos.recupera_valor(10, lq_rs, lo_pnl_cab_nota_credito.CBX_codigo_detraccion);
        }
    }

    private void get_concepto() {
        lq_rs = go_dao_tabla_ayuda.SLT_cbx_tabla_ayuda("0001");
        if (lq_rs != null) {
            go_cbx_trato_datos.recupera_valor(19, lq_rs, lo_pnl_cab_nota_credito.CBX_concepto);
        }
    }

    private void get_tipo_cambio() {
        lo_cbx_moneda = (cbx_moneda) lo_pnl_cab_nota_credito.CBX_moneda.getSelectedItem();
        lo_pnl_grid_pedidos.LBL_simbolo.setText("Imp (" + lo_cbx_moneda.simbolo_moneda().trim() + ")");
        if (!lo_cbx_moneda.getID().equalsIgnoreCase("PEN")) {
            try {
                ld_tipo_cambio = go_dao_tipo_cambio.SLT_tipo_cambio_monto("0", lo_cbx_moneda.getID(), lo_pnl_cab_nota_credito.TXT_fecha_emision.getText());
                if (ld_tipo_cambio != 0) {
                    lo_pnl_cab_nota_credito.TXT_tipo_cambio.setEnabled(false);
                    lo_pnl_cab_nota_credito.TXT_tipo_cambio.setText(ld_tipo_cambio + "");
                } else if (go_fnc_mensaje.get_respuesta(0, "FECHA SIN TIPO DE CAMBIO ¿DESEA AGREGAR TIPO CAMBIO MANUAL?") == 0) {
                    lo_pnl_cab_nota_credito.TXT_tipo_cambio.setEnabled(true);
                    lo_pnl_cab_nota_credito.TXT_tipo_cambio.setText("");
                    lo_pnl_cab_nota_credito.TXT_tipo_cambio.requestFocus();
                } else {
                    lo_pnl_cab_nota_credito.TXT_tipo_cambio.setText("");
                }
            } catch (Exception e) {
            }
        } else {
            lo_pnl_cab_nota_credito.TXT_tipo_cambio.setEnabled(false);
            lo_pnl_cab_nota_credito.TXT_tipo_cambio.setText("0.000");
        }
    }

    private void get_descripcion_registro_ventas(String codigo) {
        try {
            lq_rs = go_dao_registro_ventas.SLT_datos_registro_ventas(codigo);
            if (lq_rs != null) {
                lo_evt_cab_nota_credito.setea_recupera(lo_bean_registro_ventas, lq_rs);
                lo_evt_cab_nota_credito.muestra_datos(lo_pnl_cab_nota_credito, lo_bean_registro_ventas, lo_pnl_grid_pedidos);
                lo_cbx_moneda = (cbx_moneda) lo_pnl_cab_nota_credito.CBX_moneda.getSelectedItem();
                lo_pnl_grid_pedidos.LBL_simbolo.setText("Imp (" + lo_cbx_moneda.simbolo_moneda().trim() + ")");
                ls_codigo_ref = go_dao_cuenta_corriente_rv.SLT_codigo_operacion_nc(lo_bean_registro_ventas.getCodigo_tipo_doc_ref(), lo_bean_registro_ventas.getSerie_doc_ref(), lo_bean_registro_ventas.getNumero_doc_ref());
                get_descripcion_registro_ventas_detalle(codigo);
            }
        } catch (Exception e) {
        }
    }

    private void get_descripcion_registro_ventas_detalle(String codigo) {
        if (lo_pnl_cab_nota_credito.CBX_registra_item.getSelectedIndex() == 1) {
            lo_evt_grid_pedidos.limpia_tabla(lo_pnl_grid_pedidos, li_tipo_operacion);
            lq_rs = go_dao_registro_ventas_detalle.SLT_datos_registro_ventas_detalle(codigo);
            lo_evt_grid_pedidos.recupera_detalle(lq_rs, lo_pnl_grid_pedidos, Integer.parseInt(lo_bean_registro_ventas.getEs_precio_igv()), 1);
            lo_evt_grid_pedidos.calculo_utilidad(lo_pnl_grid_pedidos);
        }
    }

    private void genera_parametros_busq() {
        gs_parametros[0] = ls_codigo_sucursal;
        gs_parametros[1] = "01/" + gs_mes + "/" + gs_periodo;
        gs_parametros[2] = gs_dia + "/" + gs_mes + "/" + gs_periodo;
        gs_parametros[3] = lo_pnl_cab_nota_credito.TXT_serie.getText().trim();
        gs_parametros[4] = ls_tipo_documento;
    }

    private void genera_parametros_busq_pr() {
        gs_parametros[0] = ls_codigo_sucursal;
        gs_parametros[1] = "01/" + gs_mes + "/" + gs_periodo;
        gs_parametros[2] = gs_dia + "/" + gs_mes + "/" + gs_periodo;
        gs_parametros[3] = "%";
    }

    private void genera_peso_neto(int fila) {
        try {
            if (Integer.parseInt(lo_pnl_grid_pedidos.TBL_pedidos.getValueAt(fila, 2).toString()) > 0 && Double.parseDouble(lo_pnl_grid_pedidos.TBL_pedidos.getValueAt(fila, 15).toString()) > 0) {
                lo_pnl_grid_pedidos.TBL_pedidos.setValueAt((Double.parseDouble(lo_pnl_grid_pedidos.TBL_pedidos.getValueAt(fila, 15).toString()) * Integer.parseInt(lo_pnl_grid_pedidos.TBL_pedidos.getValueAt(lo_pnl_grid_pedidos.TBL_pedidos.getSelectedRow(), 2).toString())), fila, 11);
            }
        } catch (Exception e) {
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

    private void limpia_parametros() {
        gs_parametros[0] = "";
        gs_parametros[1] = "";
        gs_parametros[2] = "";
        gs_parametros[3] = "";
    }

    private void evt_f5_facturacion() {
        gs_parametros[0] = ls_codigo_ref;
        gs_parametros[1] = "";

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
                    lo_pnl_grid_pedidos.TBL_pedidos.setValueAt(ls_codigo_ref, lo_pnl_grid_pedidos.TBL_pedidos.getSelectedRow(), 17);
                    lo_pnl_grid_pedidos.TBL_pedidos.setValueAt(gs_parametros[1], lo_pnl_grid_pedidos.TBL_pedidos.getSelectedRow(), 18);
                }
            } catch (Exception e) {
            }
        }
        limpia_parametros();
    }

    private void evt_f5_facturacion_pr() {
        gs_parametros[0] = ls_codigo_ref;
        gs_parametros[1] = lo_pnl_cab_nota_credito.TXT_codigo_vendedor.getText().trim();
        gs_parametros[2] = "%";
        gs_parametros[3] = "%";

        go_dlg_busq_facturacion_pr = new dlg_busq_facturacion_pr(null, true);
        go_dlg_busq_facturacion_pr.setVisible(true);
        ls_codigo_articulo = gs_parametros[0];
        ls_codigo_operacion = gs_parametros[1];
        ls_tipo_documento_ref = "PR";
        if (!ls_codigo_articulo.equalsIgnoreCase("") || ls_codigo_articulo != null) {
            try {
                lq_rs = go_dao_registro_ventas.SLT_grid_facturacion_pr(ls_codigo_ref, lo_pnl_cab_nota_credito.TXT_codigo_vendedor.getText().trim(), ls_codigo_articulo, ls_codigo_operacion);
                if (lq_rs != null) {
                    lo_pnl_grid_pedidos.TBL_pedidos.setValueAt(go_fnc_operaciones_campos.int_boolean(Integer.parseInt(lq_rs.getString(2))), lo_pnl_grid_pedidos.TBL_pedidos.getSelectedRow(), 1);
                    lo_pnl_grid_pedidos.TBL_pedidos.setValueAt(lq_rs.getInt(3), lo_pnl_grid_pedidos.TBL_pedidos.getSelectedRow(), 2);
                    lo_pnl_grid_pedidos.TBL_pedidos.setValueAt(lq_rs.getString(4), lo_pnl_grid_pedidos.TBL_pedidos.getSelectedRow(), 3);
                    lo_pnl_grid_pedidos.TBL_pedidos.setValueAt(lq_rs.getString(5), lo_pnl_grid_pedidos.TBL_pedidos.getSelectedRow(), 4);
                    lo_pnl_grid_pedidos.TBL_pedidos.setValueAt(lq_rs.getDouble(6), lo_pnl_grid_pedidos.TBL_pedidos.getSelectedRow(), 5);
                    lo_pnl_grid_pedidos.TBL_pedidos.setValueAt(lq_rs.getString(7), lo_pnl_grid_pedidos.TBL_pedidos.getSelectedRow(), 6);
                    lo_pnl_grid_pedidos.TBL_pedidos.setValueAt(go_fnc_operaciones_campos.int_boolean(Integer.parseInt(lq_rs.getString(8))), lo_pnl_grid_pedidos.TBL_pedidos.getSelectedRow(), 7);
                    lo_pnl_grid_pedidos.TBL_pedidos.setValueAt(lq_rs.getDouble(9), lo_pnl_grid_pedidos.TBL_pedidos.getSelectedRow(), 8);
                    lo_pnl_grid_pedidos.TBL_pedidos.setValueAt(lq_rs.getDouble(10), lo_pnl_grid_pedidos.TBL_pedidos.getSelectedRow(), 9);
                    lo_pnl_grid_pedidos.TBL_pedidos.setValueAt(lq_rs.getDouble(11), lo_pnl_grid_pedidos.TBL_pedidos.getSelectedRow(), 10);
                    lo_pnl_grid_pedidos.TBL_pedidos.setValueAt(lq_rs.getDouble(12), lo_pnl_grid_pedidos.TBL_pedidos.getSelectedRow(), 11);
                    lo_pnl_grid_pedidos.TBL_pedidos.setValueAt(lq_rs.getDouble(13), lo_pnl_grid_pedidos.TBL_pedidos.getSelectedRow(), 12);
                    lo_pnl_grid_pedidos.TBL_pedidos.setValueAt(lq_rs.getDouble(14), lo_pnl_grid_pedidos.TBL_pedidos.getSelectedRow(), 13);
                    lo_pnl_grid_pedidos.TBL_pedidos.setValueAt(lq_rs.getDouble(15), lo_pnl_grid_pedidos.TBL_pedidos.getSelectedRow(), 15);
                    lo_pnl_grid_pedidos.TBL_pedidos.setValueAt(lq_rs.getDouble(16), lo_pnl_grid_pedidos.TBL_pedidos.getSelectedRow(), 16);
                    lo_pnl_grid_pedidos.TBL_pedidos.setValueAt(lq_rs.getString(17), lo_pnl_grid_pedidos.TBL_pedidos.getSelectedRow(), 17);
                    lo_pnl_grid_pedidos.TBL_pedidos.setValueAt(lq_rs.getString(18), lo_pnl_grid_pedidos.TBL_pedidos.getSelectedRow(), 18);
                }
            } catch (Exception e) {
            }
        }
        limpia_parametros();
    }

    private void evt_f5_ref_documento() {
        gs_parametros[0] = "%";
        gs_parametros[1] = "01/" + gs_mes + "/" + gs_periodo;
        gs_parametros[2] = gs_dia + "/" + gs_mes + "/" + gs_periodo;
        lo_evt_grid_pedidos.limpia_tabla(lo_pnl_grid_pedidos, 0);

        lo_pnl_cab_nota_credito.TXT_codigo_entidad.setEnabled(false);
        go_dlg_busq_ref_documento = new dlg_busq_ref_documento(null, true);
        go_dlg_busq_ref_documento.setVisible(true);
        ls_codigo_ref = go_dlg_busq_ref_documento.ls_codigo;
        ls_tipo_documento_ref = gs_parametros[0];
        ls_fecha_ref = gs_parametros[1];
        if (ls_codigo_ref != null) {
            try {
                lq_rs = go_dao_registro_ventas.SLT_datos_ref_nc(0, ls_codigo_ref);
                if (lq_rs != null) {
                    lo_evt_cab_nota_credito.muestra_datos_ref(0, lq_rs, lo_pnl_cab_nota_credito);
                    lo_pnl_cab_nota_credito.TXT_observacion.requestFocus();
                }
            } catch (Exception e) {
            }
        } else {
            evt_nuevo();
            ls_codigo_ref = null;
            lo_pnl_cab_nota_credito.TXT_numero_ref.requestFocus();
        }
        limpia_parametros();
    }

    private void evt_f5_pr() {
        genera_parametros_busq_pr();
        go_dlg_busq_programacion = new dlg_busq_programacion(null, true);
        go_dlg_busq_programacion.setVisible(true);
        ls_codigo_ref = go_dlg_busq_programacion.ls_codigo;
        ls_fecha_ref =  gs_parametros[0];
        if (ls_codigo_ref != null) {
            lo_pnl_cab_nota_credito.TXT_numero_ref.setText(ls_codigo_ref.substring(6));
            lo_pnl_cab_nota_credito.TXT_serie_ref.setText(ls_codigo_ref.substring(2, 6));
            lo_pnl_cab_nota_credito.TXT_codigo_entidad.setEnabled(true);
            lo_pnl_cab_nota_credito.TXT_codigo_entidad.requestFocus();
        }
        gs_parametros[0] = "";
    }

    private void evt_f5_entidad_pr() {
        if (ls_codigo_ref != null) {
            gs_parametros[0] = ls_codigo_ref;
            gs_parametros[1] = "%";
            go_dlg_busq_entidad_pr = new dlg_busq_entidad_pr(null, true);
            go_dlg_busq_entidad_pr.setVisible(true);
            ls_entidad = go_dlg_busq_entidad_pr.ls_codigo_entidad;
            if (ls_entidad != null) {
                try {
                    lq_rs = go_dao_entidad.SLT_grid_entidad_pr(ls_codigo_ref, ls_entidad);
                    if (lq_rs != null) {
                        lo_pnl_cab_nota_credito.TXT_codigo_entidad.setText(lq_rs.getString(1));
                        lo_pnl_cab_nota_credito.TXT_razon_social.setText(lq_rs.getString(2));
                        lo_pnl_cab_nota_credito.CBX_tipo_documento_id.setSelectedIndex(1);
                        lo_pnl_cab_nota_credito.TXT_doc_id.setText(lq_rs.getString(5));
                        lo_pnl_cab_nota_credito.TXT_codigo_ubigeo.setText(lq_rs.getString(7));
                        lo_pnl_cab_nota_credito.TXT_descripcion.setText(lq_rs.getString(8));
                        lo_pnl_cab_nota_credito.TXT_codigo_vendedor.setText(lq_rs.getString(3));
                        lo_pnl_cab_nota_credito.TXT_nombre_vendedor.setText(lq_rs.getString(4));
                        lo_pnl_cab_nota_credito.TXT_codigo_pagador.setText(lq_rs.getString(1));
                        lo_pnl_cab_nota_credito.TXT_pagador.setText(lq_rs.getString(2));
                        lo_pnl_cab_nota_credito.CBX_direccion.addItem(lq_rs.getString(6));
                        lo_pnl_cab_nota_credito.CBX_direccion.setEnabled(false);
                        lo_pnl_cab_nota_credito.TXT_observacion.requestFocus();
                    }
                } catch (Exception e) {
                }
            }
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_f5_entidad_pr", "SELECCIONE PROGRAMACION");
            lo_pnl_cab_nota_credito.TXT_numero_ref.requestFocus();
        }
    }

    private void evt_nuevo() {
        ls_codigo = null;
        lo_evt_cab_nota_credito.limpia_datos(lo_pnl_cab_nota_credito, ls_tipo_documento);
        lo_evt_grid_pedidos.limpia_tabla(lo_pnl_grid_pedidos, li_tipo_operacion);
        li_tipo_operacion = 0;

        try {
            lq_rs = go_dao_registro_ventas.FNC_correlativo_registro_ventas(ls_tipo_documento, ls_serie, ls_codigo_sucursal);
            if (lq_rs.next()) {
                lo_pnl_cab_nota_credito.TXT_numero_doc.setText(lq_rs.getString(1));
                lo_pnl_cab_nota_credito.LBL_numero_doc.setText(lq_rs.getString(1));
            }
        } catch (Exception e) {
        }

        lo_evt_opciones_3.activa_btn_opciones(1, lo_pnl_opciones_3, lb_valor_op);
        lo_evt_cab_nota_credito.activa_campos(0, lo_pnl_cab_nota_credito, true, ls_tipo_documento);
        lo_evt_grid_pedidos.activa_campos(0, lo_pnl_grid_pedidos, true);

    }

    private void evt_buscar() {
        li_tipo_operacion = 2;
        genera_parametros_busq();
        go_dlg_busq_registro_ventas = new dlg_busq_registro_ventas(null, true);
        go_dlg_busq_registro_ventas.setVisible(true);
        ls_codigo = go_dlg_busq_registro_ventas.ls_codigo;
        if (ls_codigo != null) {
            ls_codigo = ls_codigo.substring(0, 2) + ls_serie + ls_codigo.substring(3, 13);
            get_descripcion_registro_ventas(ls_codigo);
            lo_evt_opciones_3.activa_btn_opciones(2, lo_pnl_opciones_3, lb_valor_op);
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_buscar", "SELECCIONE DOCUMENTO");
            lo_evt_cab_nota_credito.limpia_datos(lo_pnl_cab_nota_credito, ls_tipo_documento);
            lo_evt_grid_pedidos.limpia_tabla(lo_pnl_grid_pedidos, li_tipo_operacion);
            lo_evt_opciones_3.activa_btn_opciones(0, lo_pnl_opciones_3, lb_valor_op);
        }
    }

    private void evt_eliminar() {
        if (go_fnc_mensaje.get_respuesta(0, "¿DESEA ELIMINAR DOCUMENTO Nro " + ls_tipo_documento + " - " + lo_bean_registro_ventas.getNumero_documento() + "?") == 0) {
            try {
                if (go_dao_registro_ventas_detalle.DLT_registro_ventas_detalle(ls_codigo)) {
                    if (go_dao_registro_ventas.DLT_registro_ventas(ls_codigo)) {
                        lo_evt_opciones_3.activa_btn_opciones(0, lo_pnl_opciones_3, lb_valor_op);
                        lo_evt_cab_nota_credito.activa_campos(0, lo_pnl_cab_nota_credito, false, ls_tipo_documento);
                        lo_evt_cab_nota_credito.limpia_datos(lo_pnl_cab_nota_credito, ls_tipo_documento);
                        lo_evt_grid_pedidos.activa_campos(0, lo_pnl_grid_pedidos, false);
                        lo_evt_grid_pedidos.limpia_tabla(lo_pnl_grid_pedidos, 1);
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    private void evt_editar() {
        li_tipo_operacion = 1;
        cont = 0;
        lo_evt_opciones_3.activa_btn_opciones(3, lo_pnl_opciones_3, lb_valor_op);
        lo_evt_grid_pedidos.activa_campos(0, lo_pnl_grid_pedidos, true);
        lo_evt_cab_nota_credito.activa_campos(1, lo_pnl_cab_nota_credito, true, ls_tipo_documento);
    }

    private void evt_guardar() {
        boolean resp = false;
        lo_cbx_moneda = (cbx_moneda) lo_pnl_cab_nota_credito.CBX_moneda.getSelectedItem();
        lo_cbx_grupo_detraccion = (cbx_grupo_detraccion) lo_pnl_cab_nota_credito.CBX_codigo_detraccion.getSelectedItem();
        lo_cbx_igv = (cbx_igv) lo_pnl_cab_nota_credito.CBX_igv.getSelectedItem();
        lo_cbx_tabla_ayuda = (cbx_tabla_ayuda) lo_pnl_cab_nota_credito.CBX_concepto.getSelectedItem();

        switch (lo_pnl_cab_nota_credito.CBX_registra_item.getSelectedIndex()) {
            case 0:
                resp = true;
                break;
            case 1:
                resp = lo_evt_grid_pedidos.valida_campos(lo_pnl_grid_pedidos, li_cantidad);
                break;
        }

        switch (li_tipo_operacion) {
            case 0:
                ls_codigo = ls_tipo_documento + ls_serie + lo_pnl_cab_nota_credito.TXT_numero_doc.getText().trim();
                lo_bean_registro_ventas.setCodigo_operacion(ls_codigo);
                lo_bean_registro_ventas.setCodigo_sucursal(ls_codigo_sucursal);
                lo_bean_registro_ventas.setCodigo_tipo_doc_ref(ls_tipo_documento_ref);
                lo_bean_registro_ventas.setFecha_doc_ref(ls_fecha_ref);
                if (lo_evt_cab_nota_credito.valida_campos(lo_pnl_cab_nota_credito, lo_cbx_moneda)) {
                    try {
                        if (resp) {
                            lo_evt_cab_nota_credito.setea_campos(lo_bean_registro_ventas, lo_pnl_cab_nota_credito, lo_cbx_grupo_detraccion, lo_cbx_moneda, lo_cbx_igv, lo_cbx_tabla_ayuda, lo_pnl_grid_pedidos, ld_monto_minimo);
                            if (go_dao_registro_ventas.IST_registro_ventas(lo_bean_registro_ventas, lo_pnl_grid_pedidos.TBL_pedidos, Double.parseDouble(lo_pnl_cab_nota_credito.CBX_igv.getSelectedItem().toString()) / 100)) {
                                lo_evt_cab_nota_credito.limpia_datos(lo_pnl_cab_nota_credito, ls_tipo_documento);
                                lo_evt_cab_nota_credito.activa_campos(0, lo_pnl_cab_nota_credito, false, ls_tipo_documento);
                                lo_evt_grid_pedidos.limpia_tabla(lo_pnl_grid_pedidos, li_tipo_operacion);
                                lo_evt_grid_pedidos.activa_campos(0, lo_pnl_grid_pedidos, false);
                                lo_evt_opciones_3.activa_btn_opciones(0, lo_pnl_opciones_3, lb_valor_op);
                            }
                            if (go_fnc_mensaje.get_respuesta(0, "¿DESEA IMPRIMIR DOCUMENTO Nro  " + ls_tipo_documento + " - " + lo_bean_registro_ventas.getNumero_documento() + "?") == 0) {
                                try {
                                    evt_imprimir(lo_bean_registro_ventas.getStatus(), lo_bean_registro_ventas.getCodigo_operacion());
                                } catch (Exception e) {
                                }
                            }
                        }
                    } catch (Exception e) {
                    }
                }
                break;
            case 1:
                if (lo_evt_cab_nota_credito.verifica_cambios(lo_bean_registro_ventas, lo_pnl_cab_nota_credito, lo_cbx_grupo_detraccion, lo_cbx_moneda, lo_cbx_igv) || cont != 0) {
                    if (resp) {
                        if (lo_evt_grid_pedidos.valida_campos(lo_pnl_grid_pedidos, li_cantidad)) {
                            try {
                                lo_evt_cab_nota_credito.setea_campos(lo_bean_registro_ventas, lo_pnl_cab_nota_credito, lo_cbx_grupo_detraccion, lo_cbx_moneda, lo_cbx_igv, lo_cbx_tabla_ayuda, lo_pnl_grid_pedidos, ld_monto_minimo);
                                if (go_dao_registro_ventas_detalle.DLT_registro_ventas_detalle(ls_codigo)) {
                                    if (go_dao_registro_ventas.UPD_registro_ventas(lo_bean_registro_ventas, lo_pnl_grid_pedidos.TBL_pedidos, Double.parseDouble(lo_pnl_cab_nota_credito.CBX_igv.getSelectedItem().toString()) / 100)) {
                                        lo_evt_cab_nota_credito.limpia_datos(lo_pnl_cab_nota_credito, ls_tipo_documento);
                                        lo_evt_cab_nota_credito.activa_campos(0, lo_pnl_cab_nota_credito, false, ls_tipo_documento);
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

    private void evt_imprimir(String status, String codigo) {
        if (status.equalsIgnoreCase("1")) {
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("codigo_operacion", codigo);
            parametros.put("periodo", gs_periodo);
            parametros.put("nombre_sucursal", lo_pnl_cab_nota_credito.TXT_sucursal.getText());
            parametros.put("empresa", go_bean_general.getRazon_social());
            parametros.put("usuario", gs_datos_usuario);
            parametros.put(JRParameter.REPORT_LOCALE, Locale.ENGLISH);
            go_evt_imprime_doc_ventas.imprime_documentos(0, "rpt_formato_nc_" + go_bean_general.getRuc() + ".jasper", parametros);
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_imprimir", "DOCUMENTO NO SE PUEDE IMPRIMIR");
        }
    }

    private void evt_cancelar() {
        li_tipo_operacion = 2;
        lo_evt_cab_nota_credito.activa_campos(0, lo_pnl_cab_nota_credito, false, ls_tipo_documento);
        lo_evt_grid_pedidos.activa_campos(0, lo_pnl_grid_pedidos, false);
        lo_evt_grid_pedidos.limpia_tabla(lo_pnl_grid_pedidos, li_tipo_operacion);
        if (ls_codigo != null) {
            lo_evt_cab_nota_credito.muestra_datos(lo_pnl_cab_nota_credito, lo_bean_registro_ventas, lo_pnl_grid_pedidos);
            get_descripcion_registro_ventas_detalle(ls_codigo);
            lo_evt_opciones_3.activa_btn_opciones(2, lo_pnl_opciones_3, lb_valor_op);
        } else {
            lo_evt_cab_nota_credito.limpia_datos(lo_pnl_cab_nota_credito, ls_tipo_documento);
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
                //evt_anular();
            }
            if (ae.getSource() == lo_pnl_opciones_3.BTN_imprimir) {
                evt_imprimir(lo_bean_registro_ventas.getStatus(), lo_bean_registro_ventas.getCodigo_operacion());
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
                if (ke.getSource() == lo_pnl_cab_nota_credito.TXT_codigo_entidad) {
                    evt_f5_entidad_pr();
                }
                if (ke.getSource() == lo_pnl_cab_nota_credito.TXT_numero_ref) {
                    lo_cbx_tabla_ayuda = (cbx_tabla_ayuda) lo_pnl_cab_nota_credito.CBX_concepto.getSelectedItem();
                    if (!lo_cbx_tabla_ayuda.getID().equalsIgnoreCase("008")) {
                        evt_f5_ref_documento();
                    } else {
                        evt_f5_pr();
                    }
                }
                if (ke.getSource() == lo_pnl_cab_nota_credito.TXT_codigo_vendedor) {
                    go_activa_buscador.busq_vendedor(lo_pnl_cab_nota_credito.TXT_codigo_vendedor, lo_pnl_cab_nota_credito.TXT_nombre_vendedor);
                }
                if (ke.getSource() == lo_pnl_grid_pedidos.TBL_pedidos && lo_pnl_grid_pedidos.TBL_pedidos.getSelectedColumn() == 3) {
                    if (!lo_cbx_tabla_ayuda.getID().equalsIgnoreCase("008")) {
                        evt_f5_facturacion();
                    } else {
                        evt_f5_facturacion_pr();
                    }
                }

                if (ke.getSource() == lo_pnl_cab_nota_credito.TXT_codigo_pagador) {
                    go_activa_buscador.busq_entidad(lo_pnl_cab_nota_credito.TXT_codigo_pagador, lo_pnl_cab_nota_credito.TXT_pagador);
                    //get_forma_pago(lo_pnl_cab_nota_credito.TXT_codigo_pagador.getText());
                }
                if (ke.getSource() == lo_pnl_cab_nota_credito.TXT_codigo_ubigeo) {
                    go_activa_buscador.busq_ubigeo(lo_pnl_cab_nota_credito.TXT_codigo_ubigeo, lo_pnl_cab_nota_credito.TXT_descripcion);
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
                    //evt_anular();
                }
                if (ke.getSource() == lo_pnl_opciones_3.BTN_cancelar) {
                    evt_cancelar();
                }
                if (ke.getSource() == lo_pnl_cab_nota_credito.TXT_numero_doc) {
                    if (go_fnc_operaciones_campos.campo_blanco(lo_pnl_cab_nota_credito.TXT_numero_doc)) {
                        lo_pnl_cab_nota_credito.TXT_numero_doc.setText(go_fnc_operaciones_campos.completa_digitos(lo_pnl_cab_nota_credito.TXT_numero_doc.getText().trim(), "0", 10));
                        lo_pnl_cab_nota_credito.LBL_numero_doc.setText(lo_pnl_cab_nota_credito.TXT_numero_doc.getText());
                        lo_pnl_cab_nota_credito.TXT_fecha_emision.requestFocus();
                    }
                }
                if (ke.getSource() == lo_pnl_cab_nota_credito.TXT_fecha_emision && !lo_pnl_cab_nota_credito.TXT_fecha_emision.getText().trim().equalsIgnoreCase("/  /")) {
                    if (go_fnc_operaciones_campos.valida_fecha(lo_pnl_cab_nota_credito.TXT_fecha_emision.getText())) {
                        if (lo_pnl_cab_nota_credito.TXT_fecha_emision.getText().trim().substring(6, 10).equalsIgnoreCase(gs_periodo)) {
                            getFocusOwner().transferFocus();
                            switch (li_tipo_operacion) {
                                case 0:
                                    get_tipo_cambio();
                                    break;
                                case 1:
                                    if (!lo_bean_registro_ventas.getFecha_emision().equalsIgnoreCase(lo_pnl_cab_nota_credito.TXT_fecha_emision.getText().trim())) {
                                        get_tipo_cambio();
                                    }
                                    break;
                            }
                        } else {
                            lo_pnl_cab_nota_credito.TXT_fecha_emision.setText("");
                            go_fnc_mensaje.GET_mensaje(0, ls_modulo, ls_capa, ls_clase, "keyPressed", "FECHA NO PERTENECE AL PERIODO");
                        }
                    } else {
                        lo_pnl_cab_nota_credito.TXT_fecha_emision.setText("");
                        go_fnc_mensaje.GET_mensaje(0, ls_modulo, ls_capa, ls_clase, "keyPressed", "FORMATO DE FECHA INVALIDO");
                    }
                }
                if (ke.getSource() == lo_pnl_cab_nota_credito.TXT_observacion || ke.getSource() == lo_pnl_cab_nota_credito.CBX_concepto) {
                    getFocusOwner().transferFocus();
                }
                if (ke.getSource() == lo_pnl_cab_nota_credito.TXT_total && go_fnc_operaciones_campos.campo_blanco(lo_pnl_cab_nota_credito.TXT_total)) {
                    lo_evt_grid_pedidos.genera_importes((Double.parseDouble(lo_pnl_cab_nota_credito.CBX_igv.getSelectedItem().toString()) + 100) / 100, Double.parseDouble(lo_pnl_cab_nota_credito.TXT_total.getText()), lo_pnl_grid_pedidos);
                    lo_pnl_opciones_3.BTN_guardar.requestFocus();
                }
                if (ke.getSource() == lo_pnl_cab_nota_credito.CBX_registra_item) {
                    if (lo_pnl_cab_nota_credito.CBX_registra_item.getSelectedIndex() == 0) {
                        getFocusOwner().transferFocus();
                    } else {
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
            if (ke.getSource() == lo_pnl_cab_nota_credito.TXT_numero_doc) {
                lo_pnl_cab_nota_credito.LBL_numero_doc.setText(lo_pnl_cab_nota_credito.TXT_numero_doc.getText());
            }
            if (ke.getSource() == lo_pnl_grid_pedidos.TBL_pedidos) {
                int fila = lo_pnl_grid_pedidos.TBL_pedidos.getSelectedRow();
                genera_peso_neto(fila);
                genera_peso_bruto(fila);
                genera_importe(fila);
                lo_evt_grid_pedidos.suma_importes(lo_pnl_cab_nota_credito.CBX_afecto_igv.getSelectedIndex(), Double.parseDouble(lo_pnl_cab_nota_credito.CBX_igv.getSelectedItem().toString()) / 100, lo_pnl_cab_nota_credito.JRD_precio_igv.isSelected(), lo_pnl_grid_pedidos,"");
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
                        lo_cbx_moneda = (cbx_moneda) lo_pnl_cab_nota_credito.CBX_moneda.getSelectedItem();
                        double precio_sigv = Double.parseDouble(lo_pnl_grid_pedidos.TBL_pedidos.getValueAt(fila, 9).toString());
                        precio_sigv = (lo_pnl_cab_nota_credito.JRD_precio_igv.isSelected() == true) ? precio_sigv : (precio_sigv) / (1 + (Double.parseDouble(lo_pnl_cab_nota_credito.CBX_igv.getSelectedItem().toString()) / 100));
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
                if (ie.getSource() == lo_pnl_cab_nota_credito.CBX_registra_item && li_tipo_operacion == 0) {
                    if (lo_pnl_cab_nota_credito.CBX_registra_item.getSelectedIndex() == 0) {
                        lo_pnl_cab_nota_credito.TXT_total.setText("");
                        lo_pnl_cab_nota_credito.TXT_total.setEnabled(true);
                        lo_evt_grid_pedidos.limpia_tabla(lo_pnl_grid_pedidos, 0);
                    } else {
                        lo_pnl_cab_nota_credito.TXT_total.setText("0.00");
                        lo_pnl_cab_nota_credito.TXT_total.setEnabled(false);
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
                        lo_evt_grid_pedidos.suma_importes(lo_pnl_cab_nota_credito.CBX_afecto_igv.getSelectedIndex(), Double.parseDouble(lo_pnl_cab_nota_credito.CBX_igv.getSelectedItem().toString()) / 100, lo_pnl_cab_nota_credito.JRD_precio_igv.isSelected(), lo_pnl_grid_pedidos,"");
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

    FocusListener FocusEvent = new FocusListener() {
        @Override
        public void focusGained(java.awt.event.FocusEvent fe) {
            ((JComponent) fe.getComponent()).setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        }

        @Override
        public void focusLost(java.awt.event.FocusEvent fe) {
            ((JComponent) fe.getComponent()).setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
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
        setTitle("NOTA DE CREDITO");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/JAVA/ANCESTRO/IMAGES/formulario.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1109, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 621, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
