package JAVA.VENTAS.GUI;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.ANCESTRO.GUI.pnl_opciones_3;
import JAVA.ANCESTRO.LOGICA.evt_focus_component;
import JAVA.ANCESTRO.LOGICA.evt_opciones_3;
import JAVA.ANCESTRO.LOGICA.recupera_valor_op;
import JAVA.CONFIG.GUI.dlg_busq_entidad_parametros;
import JAVA.CONFIG.LOGICA.cbx_sector_distribucion;
import JAVA.INVENT.GUI.dlg_busq_articulo;
import JAVA.INVENT.LOGICA.cbx_entidad_ubigeo;
import JAVA.UTILITARIOS.FUNCION.fnc_txt_mayuscula;
import JAVA.VENTAS.BEAN.BEAN_pedido;
import JAVA.VENTAS.LOGICA.evt_cab_pedidos_agil;
import JAVA.VENTAS.LOGICA.evt_grid_pedidos_agil;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRParameter;

public class jif_pedido_agil extends javax.swing.JInternalFrame {

    pnl_opciones_3 lo_pnl_opciones_3 = new pnl_opciones_3();
    evt_opciones_3 lo_evt_opciones_3 = new evt_opciones_3();
    pnl_cab_pedidos_agil lo_pnl_cab_pedidos_agil = new pnl_cab_pedidos_agil();
    evt_cab_pedidos_agil lo_evt_cab_pedidos_agil = new evt_cab_pedidos_agil();
    pnl_grid_pedidos_agil lo_pnl_grid_pedidos_agil = new pnl_grid_pedidos_agil();
    evt_grid_pedidos_agil lo_evt_grid_pedidos_agil = new evt_grid_pedidos_agil();
    recupera_valor_op lo_recupera_valor_op = new recupera_valor_op();
    BEAN_pedido lo_bean_pedido = new BEAN_pedido();
    static boolean lb_valor_op[] = new boolean[8];
    cbx_entidad_ubigeo lo_cbx_entidad_ubigeo;
    cbx_sector_distribucion lo_cbx_sector;
    DefaultTableModel modelo;
    ResultSet lq_rs;
    int li_tipo_operacion, cont = 0, li_cantidad;
    double ld_tipo_cambio, ld_porcentaje_detraccion, ld_monto_minimo, ld_tara, ld_percepcion, ld_presentacion, ld_precio_min, ld_bruto, ld_neto, ld_importe;
    String ls_codigo, ls_codigo_sucursal, ls_serie, ls_codigo_vendedor, ls_nombre_vendedor, ls_codigo_articulo, ls_codigo_entidad, ls_codigo_unidad, ls_afecto_igv;
    String ls_opcion = "M A B";
    String ls_modulo = "VENTAS", ls_capa = "GUI", ls_clase = "jif_pedido";
    JTextField editor;

    public jif_pedido_agil() {
        initComponents();
        formulario();
        activa_botones();
        get_sector_distribucion();
    }

    private void formulario() {
        lo_pnl_opciones_3.setBounds(0, 10, 1000, 110);
        lo_pnl_cab_pedidos_agil.setBounds(12, 120, 545, 500);
        lo_pnl_grid_pedidos_agil.setBounds(555, 126, 600, 600);

        this.add(lo_pnl_opciones_3);
        this.add(lo_pnl_cab_pedidos_agil);
        this.add(lo_pnl_grid_pedidos_agil);

        ls_codigo_sucursal = gs_parametros[0];
        ls_serie = gs_parametros[2];
        lo_pnl_cab_pedidos_agil.TXT_sucursal.setText(gs_parametros[1]);
        lo_pnl_cab_pedidos_agil.TXT_serie.setText(gs_parametros[2]);

        gs_parametros[0] = "";
        gs_parametros[1] = "";
        gs_parametros[2] = "";

        modelo = (DefaultTableModel) lo_pnl_grid_pedidos_agil.TBL_pedidos.getModel();
        //modelo.addTableModelListener(TablaListener);

        li_cantidad = go_dao_serie.SLT_cant_items(ls_serie, ls_codigo_sucursal, 0);

        editor = (JTextField) lo_pnl_cab_pedidos_agil.CBX_direccion.getEditor().getEditorComponent();
        editor.addKeyListener(KeyEvnt);
        editor.addFocusListener(new evt_focus_component());
        editor.setDocument(new fnc_txt_mayuscula());

        lo_evt_opciones_3.evento_click(lo_pnl_opciones_3, Listener);
        lo_evt_opciones_3.evento_press(lo_pnl_opciones_3, KeyEvnt);
        lo_evt_cab_pedidos_agil.evento_press(lo_pnl_cab_pedidos_agil, KeyEvnt);
        lo_evt_cab_pedidos_agil.evento_item(lo_pnl_cab_pedidos_agil, ItemEvent);
        lo_evt_grid_pedidos_agil.evento_press(lo_pnl_grid_pedidos_agil, KeyEvnt);
        lo_evt_grid_pedidos_agil.mouse_click(lo_pnl_grid_pedidos_agil, MouseEvnt);
        lo_evt_cab_pedidos_agil.evento_click(lo_pnl_cab_pedidos_agil, Listener);
        //lo_pnl_grid_pedidos_agil.TBL_pedidos.addMouseListener(MouseEvent);
    }

    private void activa_botones() {
        lb_valor_op = lo_recupera_valor_op.recupera(ls_modulo, ls_opcion);
        lo_evt_opciones_3.activa_btn_opciones(0, lo_pnl_opciones_3, lb_valor_op);
    }

    private void get_sector_distribucion() {
        lq_rs = go_dao_sector_distribucion.SLT_cbx_sector_distribucion();
        if (lq_rs != null) {
            go_cbx_trato_datos.recupera_valor(20, lq_rs, lo_pnl_cab_pedidos_agil.CBX_sector);
        }
    }

    private void get_parametros_entidad() {
        gs_parametros[1] = "1";
        gs_parametros[2] = "1";
        gs_parametros[3] = "%";
        gs_parametros[4] = "%";
        gs_parametros[0] = (lo_pnl_cab_pedidos_agil.CBX_tipo_documento_id.getSelectedIndex() == 0) ? "6" : "1";
    }

    private void get_descripcion_entidad(String codigo) {
        String dato;
        dato = (lo_pnl_cab_pedidos_agil.CBX_tipo_documento_id.getSelectedIndex() == 0) ? "6" : "1";
        try {
            lq_rs = go_dao_entidad.SLT_datos_entidad_x_facturacion(codigo, dato);
            if (lq_rs != null) {

                lo_pnl_cab_pedidos_agil.TXT_codigo_entidad.setText(lq_rs.getString(1));
                lo_pnl_cab_pedidos_agil.TXT_razon_social.setText(lq_rs.getString(2));
                lo_pnl_cab_pedidos_agil.TXT_doc_id.setText(lq_rs.getString(3));
                lo_pnl_cab_pedidos_agil.JRD_domiciliado.setSelected(go_fnc_operaciones_campos.int_boolean(lq_rs.getInt(4)));

                go_cbx_trato_datos.selecciona_valor(20, lq_rs.getString(12), lo_pnl_cab_pedidos_agil.CBX_sector);

                go_cbx_trato_datos.recupera_valor(16, lq_rs, lo_pnl_cab_pedidos_agil.CBX_direccion);
                lo_cbx_entidad_ubigeo = (cbx_entidad_ubigeo) lo_pnl_cab_pedidos_agil.CBX_direccion.getSelectedItem();
                lo_pnl_cab_pedidos_agil.TXT_codigo_ubigeo.setText(lo_cbx_entidad_ubigeo.getID());
                lo_pnl_cab_pedidos_agil.TXT_descripcion.setText(lo_cbx_entidad_ubigeo.descripcion());

                if (!gs_tipo_comercio.equalsIgnoreCase("4")) {
                    get_forma_pago(lo_pnl_cab_pedidos_agil.TXT_codigo_entidad.getText().trim());
                } else {
                    get_forma_pago(gs_entidad_usuario);
                }

                getFocusOwner().transferFocus();
            } else {
                go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_buscar", "ENTIDAD NO EXISTE y/o NO HABILITADO");
                lo_pnl_cab_pedidos_agil.TXT_codigo_entidad.setText("");
                lo_pnl_cab_pedidos_agil.TXT_razon_social.setText("");
                lo_pnl_cab_pedidos_agil.TXT_doc_id.setText("");
                lo_pnl_cab_pedidos_agil.CBX_direccion.removeAllItems();
                lo_pnl_cab_pedidos_agil.TXT_codigo_ubigeo.setText("");
                lo_pnl_cab_pedidos_agil.TXT_descripcion.setText("");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void get_descripcion_articulo(String codigo_articulo) {
        try {
            lq_rs = go_dao_articulo.SLT_datos_pedido_agil(gs_tipo_comercio, codigo_articulo);
            if (lq_rs != null) {
                lo_pnl_cab_pedidos_agil.TXT_nombre.setText(lq_rs.getString(2));
                lo_pnl_cab_pedidos_agil.TXT_precio.setText(lq_rs.getString(8));
                ld_tara = lq_rs.getDouble(3);
                ls_codigo_unidad = lq_rs.getString(4);
                ls_afecto_igv = lq_rs.getString(5);
                ld_percepcion = lq_rs.getDouble(6);
                ld_presentacion = lq_rs.getDouble(7);
                ld_precio_min = lq_rs.getDouble(9);
                lo_pnl_cab_pedidos_agil.CBX_presentacion.setSelectedIndex((ld_presentacion == 0) ? 1 : 0);
            } else {
                go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "get_descripcion_articulo", "PRODUCTO NO CUENTA CON PRECIO");
                lo_pnl_cab_pedidos_agil.TXT_codigo_articulo.setText("");
                lo_pnl_cab_pedidos_agil.TXT_nombre.setText("");
                lo_pnl_cab_pedidos_agil.TXT_precio.setText("");
                lo_pnl_cab_pedidos_agil.CBX_presentacion.setSelectedIndex(0);
                ld_tara = 0;
                ls_codigo_unidad = "";
                ls_afecto_igv = "";
                ld_percepcion = 0;
                ld_presentacion = 0;
                ld_precio_min = 0;
                lo_pnl_cab_pedidos_agil.TXT_codigo_articulo.requestFocus();
            }
        } catch (Exception e) {
        }
    }

    private void get_forma_pago(String codigo) {
        try {
            lq_rs = go_dao_entidad.SLT_datos_forma_pago(codigo);
            if (lq_rs != null) {
                lo_pnl_cab_pedidos_agil.CBX_forma_pago.setSelectedIndex(lq_rs.getInt(1));
                lo_pnl_cab_pedidos_agil.CBX_forma_pago.setEnabled((lq_rs.getInt(1) == 1));
            } else {
                lo_pnl_cab_pedidos_agil.CBX_forma_pago.setSelectedIndex(0);
                lo_pnl_cab_pedidos_agil.CBX_forma_pago.setEnabled(false);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private void activa_facturacion(boolean valor) {
        lo_pnl_cab_pedidos_agil.TXT_razon_social.setEnabled(valor);
        lo_pnl_cab_pedidos_agil.TXT_doc_id.setEnabled(valor);
        lo_pnl_cab_pedidos_agil.TXT_doc_id.setEnabled(valor);
        lo_pnl_cab_pedidos_agil.CBX_direccion.setEditable(valor);
        lo_pnl_cab_pedidos_agil.CBX_direccion.setEnabled(valor);
        lo_pnl_cab_pedidos_agil.TXT_codigo_ubigeo.setEnabled(valor);

        lo_pnl_cab_pedidos_agil.TXT_razon_social.setText("");
        lo_pnl_cab_pedidos_agil.TXT_doc_id.setText("");
        lo_pnl_cab_pedidos_agil.TXT_doc_id.setText("");
        lo_pnl_cab_pedidos_agil.TXT_codigo_ubigeo.setText("");
        lo_pnl_cab_pedidos_agil.TXT_descripcion.setText("");

        try {
            lo_pnl_cab_pedidos_agil.CBX_direccion.removeAllItems();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private boolean verifica_detalle() {
        boolean resp = false;
        if (go_fnc_operaciones_campos.cant_caracter(lo_pnl_cab_pedidos_agil.TXT_codigo_articulo.getText().trim(), 1, 12) && go_fnc_operaciones_campos.cant_caracter(lo_pnl_cab_pedidos_agil.TXT_nombre.getText().trim(), 1, 4)) {
            switch (lo_pnl_cab_pedidos_agil.CBX_presentacion.getSelectedIndex()) {
                case 0:
                    if (Double.parseDouble(lo_pnl_cab_pedidos_agil.TXT_cantidad.getText().replaceAll(",", "").trim()) % 1 == 0 || Double.parseDouble(lo_pnl_cab_pedidos_agil.TXT_cantidad.getText().replaceAll(",", "").trim()) > 0) {
                        if (Double.parseDouble(lo_pnl_cab_pedidos_agil.TXT_precio.getText().replaceAll(",", "").trim()) > 0 && Double.parseDouble(lo_pnl_cab_pedidos_agil.TXT_precio.getText().replaceAll(",", "").trim()) >= ld_precio_min) {
                            resp = true;
                        } else {
                            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "verifica_detalle", "VERIFICAR PRECIO");
                            lo_pnl_cab_pedidos_agil.TXT_precio.setText("");
                            lo_pnl_cab_pedidos_agil.TXT_precio.requestFocus();
                        }
                    } else {
                        go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "verifica_detalle", "VERIFICAR CANTIDAD");
                        lo_pnl_cab_pedidos_agil.TXT_cantidad.setText("");
                        lo_pnl_cab_pedidos_agil.TXT_cantidad.requestFocus();
                    }
                    break;
                case 1:
                    if (Double.parseDouble(lo_pnl_cab_pedidos_agil.TXT_cantidad.getText().replaceAll(",", "").trim()) > 0) {
                        if (Double.parseDouble(lo_pnl_cab_pedidos_agil.TXT_precio.getText().replaceAll(",", "").trim()) > 0 || Double.parseDouble(lo_pnl_cab_pedidos_agil.TXT_precio.getText().replaceAll(",", "").trim()) >= ld_precio_min) {
                            resp = true;
                        } else {
                            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "verifica_detalle", "VERIFICAR PRECIO");
                            lo_pnl_cab_pedidos_agil.TXT_precio.setText(ld_precio_min + "");
                            lo_pnl_cab_pedidos_agil.TXT_precio.requestFocus();
                        }
                    } else {
                        go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "verifica_detalle", "VERIFICAR CANTIDAD");
                        lo_pnl_cab_pedidos_agil.TXT_cantidad.setText("");
                        lo_pnl_cab_pedidos_agil.TXT_cantidad.requestFocus();
                    }
                    break;
            }
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "verifica_detalle", "SELECCIONE ARTICULO");
            lo_pnl_cab_pedidos_agil.TXT_codigo_articulo.setText("");
            lo_pnl_cab_pedidos_agil.TXT_nombre.setText("");
            lo_pnl_cab_pedidos_agil.TXT_codigo_articulo.requestFocus();
        }
        return resp;
    }

    private void evt_f5_entidad() {
        get_parametros_entidad();
        activa_facturacion(false);
        go_dlg_busq_entidad_parametros = new dlg_busq_entidad_parametros(null, true);
        go_dlg_busq_entidad_parametros.setVisible(true);
        ls_codigo_entidad = go_dlg_busq_entidad_parametros.ls_codigo_entidad;
        if (ls_codigo_entidad != null) {
            get_descripcion_entidad(ls_codigo_entidad);
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_f5_entidad", "SELECCIONE ENTIDAD");
            lo_pnl_cab_pedidos_agil.TXT_codigo_entidad.setText("");
        }
    }

    private void evt_f5_articulo() {
        gs_parametros[0] = "1";
        go_dlg_busq_articulo = new dlg_busq_articulo(null, true);
        go_dlg_busq_articulo.setVisible(true);
        ls_codigo_articulo = go_dlg_busq_articulo.ls_codigo_articulo;
        if (ls_codigo_articulo != null) {
            get_descripcion_articulo(ls_codigo_articulo);
            lo_pnl_cab_pedidos_agil.TXT_codigo_articulo.setText(ls_codigo_articulo);
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_buscar", "SELECCIONE ARTICULO");
            lo_pnl_cab_pedidos_agil.TXT_codigo_articulo.setText("");
            lo_pnl_cab_pedidos_agil.TXT_nombre.setText("");
        }
    }

    private void evt_agrega_detalle() {
        if (verifica_detalle()) {
            int fila = lo_pnl_grid_pedidos_agil.TBL_pedidos.getRowCount() - 1;
            boolean valor = lo_evt_grid_pedidos_agil.agrega_fila(lo_pnl_grid_pedidos_agil, fila, li_cantidad);
            fila = lo_pnl_grid_pedidos_agil.TBL_pedidos.getRowCount() - 1;

            if (valor) {
                if (lo_pnl_cab_pedidos_agil.CBX_presentacion.getSelectedIndex() == 0) {
                    lo_pnl_grid_pedidos_agil.TBL_pedidos.setValueAt((int) Double.parseDouble(lo_pnl_cab_pedidos_agil.TXT_cantidad.getText().replaceAll(",", "").trim()), fila, 2);
                    ld_neto = ld_presentacion * Double.parseDouble(lo_pnl_cab_pedidos_agil.TXT_cantidad.getText().replaceAll(",", "").trim());
                    ld_importe = Double.parseDouble(lo_pnl_cab_pedidos_agil.TXT_precio.getText().replaceAll(",", "").trim()) * Double.parseDouble(lo_pnl_cab_pedidos_agil.TXT_cantidad.getText().replaceAll(",", "").trim());
                } else {
                    lo_pnl_grid_pedidos_agil.TBL_pedidos.setValueAt(lo_pnl_cab_pedidos_agil.TXT_cantidad.getText().trim(), fila, 11);
                    ld_neto = Double.parseDouble(lo_pnl_cab_pedidos_agil.TXT_cantidad.getText().replaceAll(",", "").trim());
                    ld_importe = Double.parseDouble(lo_pnl_cab_pedidos_agil.TXT_precio.getText().replaceAll(",", "").trim()) * ld_neto;
                }
                ld_bruto = ld_neto + ld_presentacion * ld_tara;

                lo_pnl_grid_pedidos_agil.TBL_pedidos.setValueAt((lo_pnl_cab_pedidos_agil.CBX_presentacion.getSelectedIndex() == 0), fila, 1);
                lo_pnl_grid_pedidos_agil.TBL_pedidos.setValueAt(lo_pnl_cab_pedidos_agil.TXT_codigo_articulo.getText().trim(), fila, 3);
                lo_pnl_grid_pedidos_agil.TBL_pedidos.setValueAt(lo_pnl_cab_pedidos_agil.TXT_nombre.getText().trim(), fila, 4);
                lo_pnl_grid_pedidos_agil.TBL_pedidos.setValueAt(ld_tara, fila, 5);
                lo_pnl_grid_pedidos_agil.TBL_pedidos.setValueAt(ls_codigo_unidad, fila, 6);
                lo_pnl_grid_pedidos_agil.TBL_pedidos.setValueAt(go_fnc_operaciones_campos.int_boolean(Integer.parseInt(ls_afecto_igv)), fila, 7);
                lo_pnl_grid_pedidos_agil.TBL_pedidos.setValueAt(ld_percepcion, fila, 8);
                lo_pnl_grid_pedidos_agil.TBL_pedidos.setValueAt(Double.parseDouble(lo_pnl_cab_pedidos_agil.TXT_precio.getText().replaceAll(",", "")), fila, 9);
                lo_pnl_grid_pedidos_agil.TBL_pedidos.setValueAt(ld_bruto, fila, 10);
                lo_pnl_grid_pedidos_agil.TBL_pedidos.setValueAt(ld_neto, fila, 11);
                lo_pnl_grid_pedidos_agil.TBL_pedidos.setValueAt(ld_importe, fila, 12);
                lo_pnl_grid_pedidos_agil.TBL_pedidos.setValueAt(ld_presentacion, fila, 15);
                lo_pnl_grid_pedidos_agil.TBL_pedidos.setValueAt(ld_precio_min, fila, 16);

                lo_evt_grid_pedidos_agil.suma_importes(1, 0.18, false, lo_pnl_grid_pedidos_agil, "03");

                lo_pnl_cab_pedidos_agil.TXT_codigo_articulo.setText("");
                lo_pnl_cab_pedidos_agil.TXT_cantidad.setText("");
                lo_pnl_cab_pedidos_agil.TXT_precio.setText("");
                lo_pnl_cab_pedidos_agil.TXT_nombre.setText("");
                lo_pnl_cab_pedidos_agil.CBX_presentacion.setSelectedIndex(0);
            }
            lo_pnl_cab_pedidos_agil.TXT_codigo_articulo.requestFocus();
        }
    }

    private void evt_nuevo() {
        ls_codigo = null;
        lo_evt_cab_pedidos_agil.limpia_datos(lo_pnl_cab_pedidos_agil);
        lo_evt_grid_pedidos_agil.limpia_tabla(lo_pnl_grid_pedidos_agil, li_tipo_operacion);
        li_tipo_operacion = 0;
        try {
            lq_rs = go_dao_pedido.FNC_correlativo_pedido("OP", ls_serie, ls_codigo_sucursal);
            if (lq_rs.next()) {
                lo_pnl_cab_pedidos_agil.TXT_numero_doc.setText(lq_rs.getString(1));
                lo_pnl_cab_pedidos_agil.LBL_numero_doc.setText(lq_rs.getString(1));
            }
        } catch (Exception e) {
        }

        switch (gs_tipo_comercio) {
            case "0":
                lo_evt_cab_pedidos_agil.activa_campos(0, lo_pnl_cab_pedidos_agil, true);
                break;
            case "1":
                lo_pnl_cab_pedidos_agil.CBX_doc_ref.setSelectedIndex(1);
                get_descripcion_entidad(gs_entidad_usuario);
                lo_pnl_cab_pedidos_agil.TXT_observacion.setEnabled(true);
                lo_pnl_cab_pedidos_agil.TXT_fecha_emision.setEnabled(true);
                lo_pnl_cab_pedidos_agil.TXT_codigo_articulo.setEnabled(true);
                lo_pnl_cab_pedidos_agil.TXT_cantidad.setEnabled(true);
                lo_pnl_cab_pedidos_agil.BTN_agregar.setEnabled(true);
                lo_pnl_cab_pedidos_agil.TXT_observacion.requestFocus();
                break;
            case "2":
                go_fnc_operaciones_campos.ancho_columna(lo_pnl_grid_pedidos_agil.TBL_pedidos, 13, 0);
                lo_pnl_cab_pedidos_agil.CBX_doc_ref.setSelectedIndex(1);
                get_descripcion_entidad(gs_entidad_usuario);
                lo_pnl_cab_pedidos_agil.TXT_codigo_articulo.setEnabled(true);
                lo_pnl_cab_pedidos_agil.TXT_cantidad.setEnabled(true);
                lo_pnl_cab_pedidos_agil.BTN_agregar.setEnabled(true);
                lo_pnl_cab_pedidos_agil.TXT_observacion.setEnabled(true);
                lo_pnl_cab_pedidos_agil.TXT_fecha_emision.setEnabled(true);
                lo_pnl_cab_pedidos_agil.TXT_observacion.requestFocus();
                break;
            case "3":
                lo_evt_cab_pedidos_agil.activa_campos(0, lo_pnl_cab_pedidos_agil, true);
                break;
            case "4":
                lo_pnl_cab_pedidos_agil.TXT_observacion.setEnabled(true);
                lo_pnl_cab_pedidos_agil.TXT_fecha_emision.setEnabled(true);
                lo_pnl_cab_pedidos_agil.CBX_doc_ref.setEnabled(true);
                lo_pnl_cab_pedidos_agil.TXT_codigo_entidad.setEnabled(true);
                lo_pnl_cab_pedidos_agil.CBX_sector.setEnabled(true);
                lo_pnl_cab_pedidos_agil.CBX_doc_ref.setSelectedIndex(1);
                lo_pnl_cab_pedidos_agil.TXT_codigo_articulo.setEnabled(true);
                lo_pnl_cab_pedidos_agil.TXT_cantidad.setEnabled(true);
                lo_pnl_cab_pedidos_agil.TXT_precio.setEnabled(true);
                lo_pnl_cab_pedidos_agil.BTN_agregar.setEnabled(true);
                lo_pnl_cab_pedidos_agil.TXT_codigo_entidad.requestFocus();
                break;
        }

        lo_evt_opciones_3.activa_btn_opciones(1, lo_pnl_opciones_3, lb_valor_op);
        lo_evt_grid_pedidos_agil.activa_campos(0, lo_pnl_grid_pedidos_agil, true);
    }

    private void evt_guardar() {
        lo_cbx_sector = (cbx_sector_distribucion) lo_pnl_cab_pedidos_agil.CBX_sector.getSelectedItem();

        switch (li_tipo_operacion) {
            case 0:
                if (lo_evt_cab_pedidos_agil.valida_campos(lo_pnl_cab_pedidos_agil)) {
                    if (lo_pnl_grid_pedidos_agil.TBL_pedidos.getRowCount() > 0) {
                        try {
                            ls_codigo = "OP" + ls_serie + lo_pnl_cab_pedidos_agil.TXT_numero_doc.getText().trim();
                            lo_bean_pedido.setCodigo_operacion(ls_codigo);
                            lo_bean_pedido.setCodigo_sucursal(ls_codigo_sucursal);

                            switch (gs_tipo_comercio) {
                                case "0":
                                    lq_rs = go_dao_entidad.SLT_datos_entidad_x_facturacion(lo_pnl_cab_pedidos_agil.TXT_codigo_entidad.getText().trim(), "%");
                                    lo_bean_pedido.setCodigo_pagador(lo_pnl_cab_pedidos_agil.TXT_codigo_entidad.getText().trim());
                                    lo_bean_pedido.setNombre_pagador(lo_pnl_cab_pedidos_agil.TXT_razon_social.getText().trim());
                                    lo_bean_pedido.setCodigo_vendedor(lq_rs.getString(5));
                                    lo_bean_pedido.setNombre_vendedor(lq_rs.getString(6));
                                    break;
                                case "1":
                                    lq_rs = go_dao_entidad.SLT_datos_entidad_x_facturacion(lo_pnl_cab_pedidos_agil.TXT_codigo_entidad.getText().trim(), "%");
                                    lo_bean_pedido.setCodigo_pagador(lo_pnl_cab_pedidos_agil.TXT_codigo_entidad.getText().trim());
                                    lo_bean_pedido.setNombre_pagador(lo_pnl_cab_pedidos_agil.TXT_razon_social.getText().trim());
                                    lo_bean_pedido.setCodigo_vendedor(lq_rs.getString(5));
                                    lo_bean_pedido.setNombre_vendedor(lq_rs.getString(6));
                                    break;
                                case "2":
                                    lq_rs = go_dao_entidad.SLT_datos_entidad_x_facturacion(lo_pnl_cab_pedidos_agil.TXT_codigo_entidad.getText().trim(), "%");
                                    lo_bean_pedido.setCodigo_pagador(lo_pnl_cab_pedidos_agil.TXT_codigo_entidad.getText().trim());
                                    lo_bean_pedido.setNombre_pagador(lo_pnl_cab_pedidos_agil.TXT_razon_social.getText().trim());
                                    lo_bean_pedido.setCodigo_vendedor(lq_rs.getString(5));
                                    lo_bean_pedido.setNombre_vendedor(lq_rs.getString(6));
                                    break;
                                case "3":
                                    lq_rs = go_dao_entidad.SLT_datos_entidad_x_facturacion(lo_pnl_cab_pedidos_agil.TXT_codigo_entidad.getText().trim(), "%");
                                    lo_bean_pedido.setCodigo_pagador(lo_pnl_cab_pedidos_agil.TXT_codigo_entidad.getText().trim());
                                    lo_bean_pedido.setNombre_pagador(lo_pnl_cab_pedidos_agil.TXT_razon_social.getText().trim());
                                    lo_bean_pedido.setCodigo_vendedor(lq_rs.getString(5));
                                    lo_bean_pedido.setNombre_vendedor(lq_rs.getString(6));
                                    break;
                                case "4":
                                    lq_rs = go_dao_entidad.SLT_datos_entidad_x_facturacion(gs_entidad_usuario, "%");
                                    lo_bean_pedido.setCodigo_pagador(gs_entidad_usuario);
                                    lo_bean_pedido.setNombre_pagador(lq_rs.getString(2));
                                    lo_bean_pedido.setCodigo_vendedor(gs_vendedor_usuario);
                                    lq_rs = go_dao_vendedor.SLT_datos_vendedor(gs_vendedor_usuario, "1");
                                    lo_bean_pedido.setNombre_vendedor(lq_rs.getString(2));
                                    break;
                            }
                            lo_evt_cab_pedidos_agil.setea_campos(lo_bean_pedido, lo_pnl_cab_pedidos_agil, lo_cbx_sector, lo_pnl_grid_pedidos_agil);
                            if (go_dao_pedido.IST_pedido(lo_bean_pedido, lo_pnl_grid_pedidos_agil.TBL_pedidos, 0.18)) {
                                lo_evt_cab_pedidos_agil.limpia_datos(lo_pnl_cab_pedidos_agil);
                                lo_evt_cab_pedidos_agil.activa_campos(0, lo_pnl_cab_pedidos_agil, false);
                                lo_evt_grid_pedidos_agil.limpia_tabla(lo_pnl_grid_pedidos_agil, li_tipo_operacion);
                                lo_evt_grid_pedidos_agil.activa_campos(0, lo_pnl_grid_pedidos_agil, false);
                                lo_evt_opciones_3.activa_btn_opciones(0, lo_pnl_opciones_3, lb_valor_op);
                                if (go_fnc_mensaje.get_respuesta(0, "¿DESEA IMPRIMIR DOCUMENTO Nro  OP  - " + lo_bean_pedido.getNumero_documento() + "?") == 0) {
                                    try {
                                        evt_imprimir(lo_bean_pedido.getStatus(), lo_bean_pedido.getCodigo_operacion());
                                    } catch (Exception e) {
                                    }
                                }
                            }
                        } catch (Exception e) {
                        }
                    } else {
                        go_fnc_mensaje.GET_mensaje(0, ls_modulo, ls_capa, ls_clase, "evt_guardar", "DOCUMENTO SIN DETALLE");
                        lo_pnl_cab_pedidos_agil.TXT_codigo_articulo.requestFocus();
                    }
                }
                break;
            case 1:
                break;
        }
    }
    
    private void evt_cancelar() {
        li_tipo_operacion = 2;
        lo_evt_cab_pedidos_agil.activa_campos(0, lo_pnl_cab_pedidos_agil, false);
        lo_evt_grid_pedidos_agil.activa_campos(0, lo_pnl_grid_pedidos_agil, false);
        lo_evt_grid_pedidos_agil.limpia_tabla(lo_pnl_grid_pedidos_agil, li_tipo_operacion);
        if (ls_codigo != null) {
            //lo_evt_cab_pedidos.muestra_datos(lo_pnl_cab_pedidos, lo_bean_pedido, lo_pnl_grid_pedidos);
            //get_descripcion_pedido_detalle(ls_codigo);
            lo_evt_opciones_3.activa_btn_opciones(2, lo_pnl_opciones_3, lb_valor_op);
        } else {
            lo_evt_cab_pedidos_agil.limpia_datos(lo_pnl_cab_pedidos_agil);
            lo_evt_opciones_3.activa_btn_opciones(0, lo_pnl_opciones_3, lb_valor_op);
        }
    }

    private void evt_imprimir(String status, String codigo) {
        if (status.equalsIgnoreCase("1")) {
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("codigo_operacion", codigo);
            parametros.put("periodo", gs_periodo);
            parametros.put("nombre_sucursal", lo_pnl_cab_pedidos_agil.TXT_sucursal.getText());
            parametros.put("empresa", go_bean_general.getRazon_social());
            parametros.put("usuario", gs_datos_usuario);
            parametros.put(JRParameter.REPORT_LOCALE, Locale.ENGLISH);
            go_evt_imprime_doc_ventas.imprime_documentos(0, "rpt_formato_pedido_" + ls_serie + "_" + go_bean_general.getRuc() + ".jasper", parametros);
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_imprimir", "DOCUMENTO NO SE PUEDE IMPRIMIR");
        }
    }

    ActionListener Listener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == lo_pnl_opciones_3.BTN_nuevo) {
                evt_nuevo();
            }
            if (ae.getSource() == lo_pnl_opciones_3.BTN_buscar) {
                //evt_buscar();
            }
            if (ae.getSource() == lo_pnl_opciones_3.BTN_editar) {
                //evt_editar();
            }
            if (ae.getSource() == lo_pnl_opciones_3.BTN_eliminar) {
                //evt_eliminar();
            }
            if (ae.getSource() == lo_pnl_opciones_3.BTN_cancelar) {
                evt_cancelar();
            }
            if (ae.getSource() == lo_pnl_opciones_3.BTN_guardar) {
                evt_guardar();
            }
            if (ae.getSource() == lo_pnl_opciones_3.BTN_imprimir) {
                evt_imprimir(lo_bean_pedido.getStatus(), lo_bean_pedido.getCodigo_operacion());
            }
            if (ae.getSource() == lo_pnl_cab_pedidos_agil.BTN_agregar) {
                evt_agrega_detalle();
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
                //evt_buscar();
            }
            if (ke.getKeyCode() == KeyEvent.VK_F3 && lo_pnl_opciones_3.BTN_editar.isEnabled()) {
                //evt_editar();
            }
            if (ke.getKeyCode() == KeyEvent.VK_F4 && lo_pnl_opciones_3.BTN_eliminar.isEnabled()) {
                //evt_eliminar();
            }
            if (ke.getKeyCode() == KeyEvent.VK_ESCAPE && lo_pnl_opciones_3.BTN_cancelar.isEnabled()) {
                evt_cancelar();
            }
            if (ke.getKeyCode() == KeyEvent.VK_F6 && lo_pnl_opciones_3.BTN_guardar.isEnabled()) {
                evt_guardar();
            }
            if (ke.getKeyCode() == KeyEvent.VK_DELETE && ke.getSource() == lo_pnl_grid_pedidos_agil.TBL_pedidos) {
                if (go_fnc_mensaje.get_respuesta(0, "¿DESEA ELIMINAR ITEM " + lo_pnl_grid_pedidos_agil.TBL_pedidos.getValueAt(lo_pnl_grid_pedidos_agil.TBL_pedidos.getSelectedRow(), 0)) == 0) {
                    if (ke.getSource() == lo_pnl_grid_pedidos_agil.TBL_pedidos) {
                        int fila = lo_pnl_grid_pedidos_agil.TBL_pedidos.getSelectedRow();
                        lo_evt_grid_pedidos_agil.elimina_fila(lo_pnl_grid_pedidos_agil, fila);
                        lo_evt_grid_pedidos_agil.genera_item(lo_pnl_grid_pedidos_agil);
                        lo_evt_grid_pedidos_agil.suma_importes(1, 0.18, false, lo_pnl_grid_pedidos_agil, "03");
                        lo_pnl_cab_pedidos_agil.TXT_codigo_articulo.requestFocus();
                    }
                }
            }
            if (ke.getKeyCode() == KeyEvent.VK_F5) {
                if (ke.getSource() == lo_pnl_cab_pedidos_agil.TXT_codigo_entidad) {
                    evt_f5_entidad();
                }
                if (ke.getSource() == lo_pnl_cab_pedidos_agil.TXT_codigo_ubigeo) {
                    go_activa_buscador.busq_ubigeo(lo_pnl_cab_pedidos_agil.TXT_codigo_ubigeo, lo_pnl_cab_pedidos_agil.TXT_descripcion);
                }
                if (ke.getSource() == lo_pnl_cab_pedidos_agil.TXT_codigo_articulo) {
                    evt_f5_articulo();
                }
            }
            if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                if (ke.getSource() == lo_pnl_opciones_3.BTN_nuevo) {
                    evt_nuevo();
                }
                if (ke.getSource() == lo_pnl_opciones_3.BTN_buscar) {
                    //evt_buscar();
                }
                if (ke.getSource() == lo_pnl_opciones_3.BTN_editar) {
                    //evt_editar();
                }
                if (ke.getSource() == lo_pnl_opciones_3.BTN_eliminar) {
                    //evt_eliminar();
                }
                if (ke.getSource() == lo_pnl_opciones_3.BTN_guardar) {
                    evt_guardar();
                }
                if (ke.getSource() == lo_pnl_opciones_3.BTN_cancelar) {
                    evt_cancelar();
                }
                if (ke.getSource() == lo_pnl_opciones_3.BTN_imprimir) {
                    evt_imprimir(lo_bean_pedido.getStatus(), lo_bean_pedido.getCodigo_operacion());
                }
                if (ke.getSource() == lo_pnl_cab_pedidos_agil.TXT_numero_doc) {
                    if (go_fnc_operaciones_campos.campo_blanco(lo_pnl_cab_pedidos_agil.TXT_numero_doc)) {
                        lo_pnl_cab_pedidos_agil.TXT_numero_doc.setText(go_fnc_operaciones_campos.completa_digitos(lo_pnl_cab_pedidos_agil.TXT_numero_doc.getText().trim(), "0", 10));
                        lo_pnl_cab_pedidos_agil.LBL_numero_doc.setText(lo_pnl_cab_pedidos_agil.TXT_numero_doc.getText());
                        lo_pnl_cab_pedidos_agil.TXT_fecha_emision.requestFocus();
                    }
                }
                if (ke.getSource() == lo_pnl_cab_pedidos_agil.TXT_fecha_emision && !lo_pnl_cab_pedidos_agil.TXT_fecha_emision.getText().trim().equalsIgnoreCase("/  /")) {
                    if (go_fnc_operaciones_campos.valida_fecha(lo_pnl_cab_pedidos_agil.TXT_fecha_emision.getText())) {
                        if (lo_pnl_cab_pedidos_agil.TXT_fecha_emision.getText().trim().substring(6, 10).equalsIgnoreCase(gs_periodo)) {
                            getFocusOwner().transferFocus();
                        } else {
                            lo_pnl_cab_pedidos_agil.TXT_fecha_emision.setText("");
                            go_fnc_mensaje.GET_mensaje(0, ls_modulo, ls_capa, ls_clase, "keyPressed", "FECHA NO PERTENECE AL PERIODO");
                        }
                    } else {
                        lo_pnl_cab_pedidos_agil.TXT_fecha_emision.setText("");
                        go_fnc_mensaje.GET_mensaje(0, ls_modulo, ls_capa, ls_clase, "keyPressed", "FORMATO DE FECHA INVALIDO");
                    }
                }
                if (ke.getSource() == lo_pnl_cab_pedidos_agil.CBX_doc_ref || ke.getSource() == lo_pnl_cab_pedidos_agil.CBX_sector || ke.getSource() == lo_pnl_cab_pedidos_agil.TXT_observacion || ke.getSource() == lo_pnl_cab_pedidos_agil.CBX_presentacion || ke.getSource() == lo_pnl_cab_pedidos_agil.CBX_forma_pago) {
                    getFocusOwner().transferFocus();
                }
                if (ke.getSource() == editor && go_fnc_operaciones_campos.cant_caracter(editor.getText().trim(), 1, 4)) {
                    getFocusOwner().transferFocus();
                }
                if (ke.getSource() == lo_pnl_cab_pedidos_agil.TXT_codigo_entidad && go_fnc_operaciones_campos.cant_caracter(lo_pnl_cab_pedidos_agil.TXT_codigo_entidad.getText().trim(), 4, 6)) {
                    if (li_tipo_operacion != 1) {
                        if (lo_pnl_cab_pedidos_agil.TXT_codigo_entidad.getText().trim().equalsIgnoreCase("999999")) {
                            activa_facturacion(true);
                            lo_pnl_cab_pedidos_agil.TXT_razon_social.requestFocus();
                        } else {
                            activa_facturacion(false);
                            get_descripcion_entidad(lo_pnl_cab_pedidos_agil.TXT_codigo_entidad.getText().trim());
                        }
                    } else {
                        getFocusOwner().transferFocus();
                    }
                }
                if (ke.getSource() == lo_pnl_cab_pedidos_agil.TXT_razon_social && go_fnc_operaciones_campos.cant_caracter(lo_pnl_cab_pedidos_agil.TXT_razon_social.getText().trim(), 1, 4)) {
                    getFocusOwner().transferFocus();
                }
                if (ke.getSource() == lo_pnl_cab_pedidos_agil.TXT_doc_id) {
                    if (lo_evt_cab_pedidos_agil.valida_tipo_documento(lo_pnl_cab_pedidos_agil.CBX_tipo_documento_id.getSelectedIndex(), lo_pnl_cab_pedidos_agil.TXT_doc_id.getText().trim())) {
                        getFocusOwner().transferFocus();
                    } else {
                        go_fnc_mensaje.GET_mensaje(0, ls_modulo, ls_capa, ls_clase, "keyPressed", "DOCUMENTO DE IDENTIDAD INCORRECTO");
                        lo_pnl_cab_pedidos_agil.CBX_tipo_documento_id.requestFocus();
                    }
                }
                if (ke.getSource() == lo_pnl_cab_pedidos_agil.CBX_direccion && !lo_pnl_cab_pedidos_agil.CBX_direccion.getSelectedItem().toString().equalsIgnoreCase("")) {
                    getFocusOwner().transferFocus();
                }
                if (ke.getSource() == lo_pnl_cab_pedidos_agil.TXT_codigo_ubigeo && go_fnc_operaciones_campos.cant_caracter(lo_pnl_cab_pedidos_agil.TXT_codigo_ubigeo.getText().trim(), 4, 6)) {
                    go_activa_buscador.get_descripcion_ubigeo(lo_pnl_cab_pedidos_agil.TXT_codigo_ubigeo.getText().trim(), lo_pnl_cab_pedidos_agil.TXT_codigo_ubigeo, lo_pnl_cab_pedidos_agil.TXT_descripcion);
                }
                if (ke.getSource() == lo_pnl_cab_pedidos_agil.TXT_codigo_articulo && go_fnc_operaciones_campos.cant_caracter(lo_pnl_cab_pedidos_agil.TXT_codigo_articulo.getText().trim(), 1, 12) && go_fnc_operaciones_campos.cant_caracter(lo_pnl_cab_pedidos_agil.TXT_nombre.getText().trim(), 1, 4)) {
                    getFocusOwner().transferFocus();
                }
                if (ke.getSource() == lo_pnl_cab_pedidos_agil.TXT_cantidad && go_fnc_operaciones_campos.cant_caracter(lo_pnl_cab_pedidos_agil.TXT_cantidad.getText().trim(), 1, 1)) {
                    if (Double.parseDouble(lo_pnl_cab_pedidos_agil.TXT_cantidad.getText().replaceAll(",", "").trim()) == 0) {
                        lo_pnl_cab_pedidos_agil.TXT_cantidad.setText("");
                    } else {
                        getFocusOwner().transferFocus();
                    }
                }
                if (ke.getSource() == lo_pnl_cab_pedidos_agil.TXT_precio && go_fnc_operaciones_campos.cant_caracter(lo_pnl_cab_pedidos_agil.TXT_precio.getText().trim(), 1, 1)) {
                    if (Double.parseDouble(lo_pnl_cab_pedidos_agil.TXT_precio.getText().replaceAll(",", "").trim()) < ld_precio_min || Double.parseDouble(lo_pnl_cab_pedidos_agil.TXT_precio.getText().replaceAll(",", "").trim()) == 0) {
                        go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "keyPressed", "VERIFICAR PRECIO");
                        lo_pnl_cab_pedidos_agil.TXT_precio.setText("");
                        lo_pnl_cab_pedidos_agil.TXT_precio.setSelectionStart(0);
                        lo_pnl_cab_pedidos_agil.TXT_precio.setSelectionEnd(lo_pnl_cab_pedidos_agil.TXT_precio.getText().length());
                    } else {
                        getFocusOwner().transferFocus();
                    }
                }
                if (ke.getSource() == lo_pnl_cab_pedidos_agil.BTN_agregar) {
                    evt_agrega_detalle();
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
            if (ie.getSource() == lo_pnl_cab_pedidos_agil.CBX_doc_ref) {
                lo_pnl_cab_pedidos_agil.TXT_codigo_entidad.setText("");
                lo_pnl_cab_pedidos_agil.TXT_razon_social.setText("");
                lo_pnl_cab_pedidos_agil.TXT_doc_id.setText("");
                lo_pnl_cab_pedidos_agil.CBX_direccion.removeAllItems();
                lo_pnl_cab_pedidos_agil.TXT_codigo_ubigeo.setText("");
                lo_pnl_cab_pedidos_agil.TXT_descripcion.setText("");

                if (lo_pnl_cab_pedidos_agil.CBX_doc_ref.getSelectedIndex() == 0) {
                    lo_pnl_cab_pedidos_agil.CBX_tipo_documento_id.setSelectedIndex(0);
                } else {
                    lo_pnl_cab_pedidos_agil.CBX_tipo_documento_id.setSelectedIndex(1);
                }
            }
        }
    };

    MouseListener MouseEvnt = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent me) {
            if (me.getSource() == lo_pnl_grid_pedidos_agil.TBL_pedidos && me.getClickCount() == 2) {
                int fila = lo_pnl_grid_pedidos_agil.TBL_pedidos.getSelectedRow();
                go_dlg_editar_item = new dlg_editar_item(null, true);
                go_dlg_editar_item.get_datos(modelo, fila);
                go_dlg_editar_item.setVisible(true);
                lo_evt_grid_pedidos_agil.suma_importes(1, 0.18, false, lo_pnl_grid_pedidos_agil, "03");
                lo_pnl_cab_pedidos_agil.TXT_codigo_articulo.requestFocus();
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
        setTitle("PEDIDO");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/JAVA/ANCESTRO/IMAGES/formulario.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1084, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 602, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
