package JAVA.VENTAS.GUI;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.ANCESTRO.GUI.pnl_opciones_3;
import JAVA.ANCESTRO.LOGICA.evt_opciones_3;
import JAVA.ANCESTRO.LOGICA.recupera_valor_op;
import JAVA.CONFIG.GUI.dlg_busq_entidad_parametros;
import JAVA.CONFIG.LOGICA.cbx_moneda;
import JAVA.INVENT.LOGICA.cbx_entidad_ubigeo;
import JAVA.INVENT.LOGICA.cbx_grupo_detraccion;
import JAVA.VENTAS.LOGICA.cbx_igv;
import JAVA.VENTAS.LOGICA.evt_cab_guiar;
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
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

public class jif_guia_remision extends javax.swing.JInternalFrame {

    pnl_opciones_3 lo_pnl_opciones_3 = new pnl_opciones_3();
    evt_opciones_3 lo_evt_opciones_3 = new evt_opciones_3();
    pnl_cab_guiar lo_pnl_cab_guiar = new pnl_cab_guiar();
    evt_cab_guiar lo_evt_cab_guiar = new evt_cab_guiar();
    pnl_grid_pedidos lo_pnl_grid_pedidos = new pnl_grid_pedidos();
    evt_grid_pedidos lo_evt_grid_pedidos = new evt_grid_pedidos();
    recupera_valor_op lo_recupera_valor_op = new recupera_valor_op();
    static boolean lb_valor_op[] = new boolean[8];
    ResultSet lq_rs;
    DefaultTableModel modelo;
    cbx_moneda lo_cbx_moneda;
    cbx_grupo_detraccion lo_cbx_grupo_detraccion;
    cbx_entidad_ubigeo lo_cbx_entidad_ubigeo;
    cbx_igv lo_cbx_igv;
    int li_tipo_operacion, cont = 0, li_cantidad;
    double ld_tipo_cambio, ld_porcentaje_detraccion, ld_monto_minimo;
    String ls_codigo, ls_codigo_sucursal, ls_serie, ls_codigo_vendedor, ls_nombre_vendedor, ls_codigo_articulo, ls_codigo_entidad,
            ls_tipo_documento_g, ls_espedido = "0", ls_codigo_pedido;
    String ls_opcion = "M A C";
    String ls_modulo = "VENTAS", ls_capa = "GUI", ls_clase = "jif_guia_remision";

    public jif_guia_remision() {
        initComponents();
        formulario();
        activa_botones();
        get_moneda();
        get_igv();
        get_grupo_detraccion();
    }

    private void formulario() {
        lo_pnl_opciones_3.setBounds(0, 10, 1000, 120);
        lo_pnl_cab_guiar.setBounds(12, 130, 1000, 260);
        lo_pnl_grid_pedidos.setBounds(13, 390, 1000, 280);

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

        li_cantidad = go_dao_serie.SLT_cant_items(ls_serie, ls_codigo_sucursal, 0);

        lo_evt_opciones_3.evento_click(lo_pnl_opciones_3, Listener);
        lo_evt_opciones_3.evento_press(lo_pnl_opciones_3, KeyEvnt);
        lo_evt_cab_guiar.evento_press(lo_pnl_cab_guiar, KeyEvnt);
        lo_evt_cab_guiar.evento_item(lo_pnl_cab_guiar, ItemEvent);
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

    private void get_parametros_entidad(int op) {
        gs_parametros[0] = (lo_pnl_cab_guiar.CBX_doc_ref.getSelectedIndex() == 0) ? "6" : "1";
        gs_parametros[1] = "1";
        gs_parametros[2] = "1";
        gs_parametros[3] = "%";
        gs_parametros[4] = "%";

        switch (op) {
            case 0:
                break;
            case 1:
                gs_parametros[0] = "%";
                break;
        }
    }

    private void get_nombre_vendedor() {
        try {
            lq_rs = go_dao_vendedor.SLT_datos_vendedor(lo_pnl_cab_guiar.TXT_codigo_vendedor.getText().trim(), "1");
            if (lq_rs != null) {
                ls_codigo_vendedor = lq_rs.getString(1);
                ls_nombre_vendedor = lq_rs.getString(2);
                lo_pnl_cab_guiar.TXT_codigo_vendedor.setText(ls_codigo_vendedor);
                lo_pnl_cab_guiar.TXT_nombre_vendedor.setText(ls_nombre_vendedor);
                getFocusOwner().transferFocus();
            } else {
                go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "get_nombre_vendedor", "VENDEDOR NO EXISTE y/o BLOQUEADO");
                lo_pnl_cab_guiar.TXT_codigo_vendedor.setText("");
                lo_pnl_cab_guiar.TXT_nombre_vendedor.setText("");
            }
        } catch (Exception e) {
        }
    }

    private void get_descripcion_entidad(String codigo, int op) {
        try {
            lq_rs = go_dao_entidad.SLT_datos_entidad_x_facturacion(codigo, (lo_pnl_cab_guiar.CBX_doc_ref.getSelectedIndex() == 0) ? "6" : "1");
            if (lq_rs != null) {
                switch (op) {
                    case 0:
                        lo_pnl_cab_guiar.TXT_codigo_entidad.setText(lq_rs.getString(1));
                        lo_pnl_cab_guiar.TXT_razon_social.setText(lq_rs.getString(2));
                        lo_pnl_cab_guiar.TXT_doc_id.setText(lq_rs.getString(3));
                        lo_pnl_cab_guiar.JRD_domiciliado.setSelected(go_fnc_operaciones_campos.int_boolean(lq_rs.getInt(4)));
                        lo_pnl_cab_guiar.TXT_codigo_pagador.setText(lq_rs.getString(1));
                        lo_pnl_cab_guiar.TXT_pagador.setText(lq_rs.getString(2));
                        lo_pnl_cab_guiar.TXT_codigo_vendedor.setText(lq_rs.getString(5));
                        lo_pnl_cab_guiar.TXT_nombre_vendedor.setText(lq_rs.getString(6));
                        if (lq_rs.getString(7).equalsIgnoreCase("EF")) {
                            lo_pnl_cab_guiar.CBX_forma_pago.setSelectedIndex(0);
                            lo_pnl_cab_guiar.TXT_dias_credito.setEnabled(false);
                            lo_pnl_cab_guiar.CBX_forma_pago.setEnabled(false);
                        } else {
                            lo_pnl_cab_guiar.CBX_forma_pago.setSelectedIndex(1);
                            lo_pnl_cab_guiar.TXT_dias_credito.setEnabled(true);
                            lo_pnl_cab_guiar.CBX_forma_pago.setEnabled(true);
                        }
                        lo_pnl_cab_guiar.TXT_dias_credito.setText(lq_rs.getString(8));
                        go_cbx_trato_datos.recupera_valor(16, lq_rs, lo_pnl_cab_guiar.CBX_direccion);
                        lo_cbx_entidad_ubigeo = (cbx_entidad_ubigeo) lo_pnl_cab_guiar.CBX_direccion.getSelectedItem();
                        lo_pnl_cab_guiar.TXT_codigo_ubigeo.setText(lo_cbx_entidad_ubigeo.getID());
                        lo_pnl_cab_guiar.TXT_descripcion.setText(lo_cbx_entidad_ubigeo.descripcion());
                        if (!lo_pnl_cab_guiar.JRD_domiciliado.isSelected()) {
                            lo_pnl_cab_guiar.CBX_afecto_igv.setSelectedIndex(0);
                        } else {
                            lo_pnl_cab_guiar.CBX_afecto_igv.setSelectedIndex(1);
                        }
                        getFocusOwner().transferFocus();
                        break;
                }
            } else {
                go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_buscar", "ENTIDAD NO EXISTE y/o NO HABILITADO");
                switch (op) {
                    case 0:
                        lo_pnl_cab_guiar.TXT_codigo_entidad.setText("");
                        lo_pnl_cab_guiar.TXT_razon_social.setText("");
                        lo_pnl_cab_guiar.TXT_doc_id.setText("");
                        lo_pnl_cab_guiar.JRD_domiciliado.setSelected(false);
                        lo_pnl_cab_guiar.CBX_direccion.removeAllItems();
                        lo_pnl_cab_guiar.TXT_codigo_ubigeo.setText("");
                        lo_pnl_cab_guiar.TXT_descripcion.setText("");
                        lo_pnl_cab_guiar.CBX_forma_pago.setEnabled(false);
                        break;
                }
            }
        } catch (Exception e) {
        }
    }

    private void evt_f5_transportista() {
        if (go_fnc_operaciones_campos.campo_blanco(lo_pnl_cab_guiar.TXT_codigo_entidad)) {
            gs_parametros[0] = lo_pnl_cab_guiar.TXT_codigo_entidad.getText().trim();
            go_dlg_datos_pl = new dlg_datos_pl(null, true);            
            go_dlg_datos_pl.setVisible(true);            
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_f5_transportista", "SELECCIONE ENTIDAD");
            lo_pnl_cab_guiar.TXT_codigo_entidad.requestFocus();
        }
    }

    private void evt_f5_entidad(int op) {
        get_parametros_entidad(op);
        go_dlg_busq_entidad_parametros = new dlg_busq_entidad_parametros(null, true);
        go_dlg_busq_entidad_parametros.setVisible(true);
        ls_codigo_entidad = go_dlg_busq_entidad_parametros.ls_codigo_entidad;
        if (ls_codigo_entidad != null) {
            get_descripcion_entidad(ls_codigo_entidad, op);
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_f5_entidad", "SELECCIONE ENTIDAD");
            lo_pnl_cab_guiar.TXT_codigo_entidad.setText("");
        }
    }

    private void evt_nuevo() {
        ls_codigo = null;
        ls_codigo_pedido = "OP00000000000000";
        ls_espedido = "0";
        lo_evt_cab_guiar.limpia_datos(lo_pnl_cab_guiar);
        lo_evt_grid_pedidos.limpia_tabla(lo_pnl_grid_pedidos, li_tipo_operacion);
        li_tipo_operacion = 0;
        try {
            lq_rs = go_dao_registro_ventas.FNC_correlativo_registro_ventas(ls_tipo_documento_g, ls_serie, ls_codigo_sucursal);
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

    ActionListener Listener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == lo_pnl_opciones_3.BTN_nuevo) {
                evt_nuevo();
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
            if (ke.getKeyCode() == KeyEvent.VK_F5) {
                if (ke.getSource() == lo_pnl_cab_guiar.TXT_codigo_entidad) {
                    evt_f5_entidad(0);
                }
                if (ke.getSource() == lo_pnl_cab_guiar.TXT_transportista) {
                    evt_f5_transportista();
                }
            }

            if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                if (ke.getSource() == lo_pnl_opciones_3.BTN_nuevo) {
                    evt_nuevo();
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
                if (ke.getSource() == lo_pnl_cab_guiar.TXT_pedido) {
                    lo_pnl_cab_guiar.TXT_pedido.setText(go_fnc_operaciones_campos.completa_digitos(lo_pnl_cab_guiar.TXT_pedido.getText().trim(), "0", 10));
                    if (lo_pnl_cab_guiar.TXT_pedido.getText().trim().equalsIgnoreCase("0000000000")) {
                        getFocusOwner().transferFocus();
                    } else {
                        String cp = "OP" + ls_serie + lo_pnl_cab_guiar.TXT_pedido.getText().trim();
                        if (!ls_codigo_pedido.equalsIgnoreCase(cp)) {
                            //muestra_datos_ref(0, cp);
                        } else {
                            getFocusOwner().transferFocus();
                        }
                    }
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
                if (ke.getSource() == lo_pnl_cab_guiar.TXT_codigo_entidad && go_fnc_operaciones_campos.cant_caracter(lo_pnl_cab_guiar.TXT_codigo_entidad.getText().trim(), 4, 6)) {
                    get_descripcion_entidad(lo_pnl_cab_guiar.TXT_codigo_entidad.getText().trim(), 0);
                }
                if (ke.getSource() == lo_pnl_cab_guiar.CBX_direccion && !lo_pnl_cab_guiar.CBX_direccion.getSelectedItem().toString().equalsIgnoreCase("")) {
                    getFocusOwner().transferFocus();
                }
                if (ke.getSource() == lo_pnl_cab_guiar.TXT_codigo_vendedor && go_fnc_operaciones_campos.cant_caracter(lo_pnl_cab_guiar.TXT_codigo_vendedor.getText(), 4, 4)) {
                    get_nombre_vendedor();
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
            }
        }

        @Override
        public void keyReleased(KeyEvent ke) {

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
                if (ie.getSource() == lo_pnl_cab_guiar.CBX_codigo_detraccion) {
                    get_porcentaje_detraccion();
                    lo_evt_grid_pedidos.limpia_tabla(lo_pnl_grid_pedidos, li_tipo_operacion);
                }
                if (ie.getSource() == lo_pnl_cab_guiar.CBX_forma_pago) {
                    if (lo_pnl_cab_guiar.CBX_forma_pago.getSelectedIndex() == 0) {
                        lo_pnl_cab_guiar.TXT_dias_credito.setText("0");
                        lo_pnl_cab_guiar.TXT_dias_credito.setEnabled(false);
                    } else {
                        lo_pnl_cab_guiar.TXT_dias_credito.setEnabled(true);
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
                        lo_evt_grid_pedidos.suma_importes(lo_pnl_cab_guiar.CBX_afecto_igv.getSelectedIndex(), Double.parseDouble(lo_pnl_cab_guiar.CBX_igv.getSelectedItem().toString()) / 100, lo_pnl_cab_guiar.JRD_precio_igv.isSelected(), lo_pnl_grid_pedidos);
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
        setTitle("GUIA REMISION");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/JAVA/ANCESTRO/IMAGES/formulario.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1014, Short.MAX_VALUE)
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
