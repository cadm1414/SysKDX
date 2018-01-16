package JAVA.DISTBR.GUI;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.ANCESTRO.GUI.pnl_opciones_3;
import JAVA.ANCESTRO.LOGICA.evt_opciones_3;
import JAVA.ANCESTRO.LOGICA.recupera_valor_op;
import JAVA.DISTBR.BEAN.BEAN_liquidacion;
import JAVA.DISTBR.LOGICA.evt_cab_liquidacion;
import JAVA.DISTBR.LOGICA.evt_grid_liquidacion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

public class jif_liquidacion extends javax.swing.JInternalFrame {

    pnl_opciones_3 lo_pnl_opciones_3 = new pnl_opciones_3();
    evt_opciones_3 lo_evt_opciones_3 = new evt_opciones_3();
    pnl_cab_liquidacion lo_pnl_cab_liquidacion = new pnl_cab_liquidacion();
    evt_cab_liquidacion lo_evt_cab_liquidacion = new evt_cab_liquidacion();
    pnl_grid_liquidacion lo_pnl_grid_liquidacion = new pnl_grid_liquidacion();
    evt_grid_liquidacion lo_evt_grid_liquidacion = new evt_grid_liquidacion();
    BEAN_liquidacion lo_bean_liquidacion = new BEAN_liquidacion();
    recupera_valor_op lo_recupera_valor_op = new recupera_valor_op();
    static boolean lb_valor_op[] = new boolean[8];
    ResultSet lq_rs;
    DefaultTableModel modelo, modelo_retorna;
    int li_tipo_operacion, cont = 0, li_cantidad;
    String ls_codigo, ls_codigo_sucursal, ls_serie, ls_codigo_programacion;
    String ls_modulo = "DISTBR", ls_capa = "GUI", ls_clase = "jif_liquidacion";
    String ls_opcion = "M A B";

    public jif_liquidacion() {
        initComponents();
        formulario();
        activa_botones();
        lo_pnl_grid_liquidacion.TBL_liquidacion.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(title).getKeyStroke(KeyEvent.VK_ENTER, 0), "selectNextColumnCell");
    }

    private void formulario() {
        lo_pnl_opciones_3.setBounds(0, 10, 1000, 110);
        lo_pnl_cab_liquidacion.setBounds(12, 120, 1100, 135);
        lo_pnl_grid_liquidacion.setBounds(13, 255, 1100, 350);

        this.add(lo_pnl_opciones_3);
        this.add(lo_pnl_cab_liquidacion);
        this.add(lo_pnl_grid_liquidacion);

        ls_codigo_sucursal = gs_parametros[0];
        ls_serie = ls_codigo_sucursal;

        lo_pnl_cab_liquidacion.TXT_sucursal.setText(gs_parametros[1]);
        gs_parametros[0] = "";
        gs_parametros[1] = "";

        modelo = (DefaultTableModel) lo_pnl_grid_liquidacion.TBL_liquidacion.getModel();
        modelo.addTableModelListener(TablaListener);

        lo_evt_opciones_3.evento_click(lo_pnl_opciones_3, Listener);
        lo_evt_opciones_3.evento_press(lo_pnl_opciones_3, KeyEvnt);
        lo_evt_cab_liquidacion.evento_press(lo_pnl_cab_liquidacion, KeyEvnt);
        lo_evt_cab_liquidacion.evento_focus(lo_pnl_cab_liquidacion, FocusEvent);
        lo_evt_grid_liquidacion.evento_press(lo_pnl_grid_liquidacion, KeyEvnt);
        lo_pnl_grid_liquidacion.TBL_liquidacion.addMouseListener(MouseEvent);
    }

    private void activa_botones() {
        lb_valor_op = lo_recupera_valor_op.recupera(ls_modulo, ls_opcion);
        lo_evt_opciones_3.activa_btn_opciones(0, lo_pnl_opciones_3, lb_valor_op);
    }

    private void get_descripcion_liquidacion(String codigo) {
        try {
            lq_rs = go_dao_liquidacion.SLT_datos_liquidacion(codigo);
            if (lq_rs != null) {
                lo_evt_cab_liquidacion.setea_recupera(lo_bean_liquidacion, lq_rs);
                lo_evt_cab_liquidacion.muestra_datos(lo_pnl_cab_liquidacion, lo_bean_liquidacion, lo_pnl_grid_liquidacion);
                get_descripcion_liquidacion_detalle(codigo);
            }
        } catch (Exception e) {
        }
    }

    private void get_descripcion_liquidacion_detalle(String codigo) {
        lo_evt_grid_liquidacion.limpia_tabla(lo_pnl_grid_liquidacion, li_tipo_operacion);
        lq_rs = go_dao_liquidacion_detalle.SLT_datos_liquidacion_detalle(codigo);
        lo_evt_grid_liquidacion.recupera_detalle(lq_rs, lo_pnl_grid_liquidacion);
    }

    private void genera_importe(int fila) {
        try {
            double importe = (double) lo_pnl_grid_liquidacion.TBL_liquidacion.getValueAt(fila, 5) - (double) lo_pnl_grid_liquidacion.TBL_liquidacion.getValueAt(fila, 8) - (double) lo_pnl_grid_liquidacion.TBL_liquidacion.getValueAt(fila, 9);
            lo_pnl_grid_liquidacion.TBL_liquidacion.setValueAt(importe, fila, 10);
        } catch (Exception e) {
        }
    }

    private void genera_parametros_busq_pr() {
        gs_parametros[0] = ls_codigo_sucursal;
        gs_parametros[1] = "01/" + gs_mes + "/" + gs_periodo;
        gs_parametros[2] = gs_dia + "/" + gs_mes + "/" + gs_periodo;
        gs_parametros[3] = "0";
    }

    private void genera_parametros_busq() {
        gs_parametros[0] = ls_codigo_sucursal;
        gs_parametros[1] = "01/" + gs_mes + "/" + gs_periodo;
        gs_parametros[2] = gs_dia + "/" + gs_mes + "/" + gs_periodo;
        gs_parametros[3] = "%";
    }

    private void evt_f5_pr() {
        genera_parametros_busq_pr();
        go_dlg_busq_programacion = new dlg_busq_programacion(null, true);
        go_dlg_busq_programacion.setVisible(true);
        ls_codigo_programacion = go_dlg_busq_programacion.ls_codigo;
        if (ls_codigo_programacion != null) {
            lo_pnl_cab_liquidacion.TXT_programacion.setText(ls_codigo_programacion.substring(6));
            try {
                lo_evt_grid_liquidacion.limpia_tabla(lo_pnl_grid_liquidacion, li_tipo_operacion);
                lq_rs = go_dao_programacion.SLT_grid_datos_pr(ls_codigo_programacion);
                if (lq_rs != null) {
                    int a = 0;
                    do {
                        lo_evt_grid_liquidacion.agrega_fila(lo_pnl_grid_liquidacion, a - 1);
                        lo_pnl_grid_liquidacion.TBL_liquidacion.setValueAt(lq_rs.getString(1), a, 0);
                        lo_pnl_grid_liquidacion.TBL_liquidacion.setValueAt(lq_rs.getString(2), a, 2);
                        lo_pnl_grid_liquidacion.TBL_liquidacion.setValueAt(lq_rs.getString(3), a, 3);
                        lo_pnl_grid_liquidacion.TBL_liquidacion.setValueAt(lq_rs.getString(4), a, 4);
                        lo_pnl_grid_liquidacion.TBL_liquidacion.setValueAt(lq_rs.getDouble(5), a, 5);
                        lo_pnl_grid_liquidacion.TBL_liquidacion.setValueAt(lq_rs.getDouble(5), a, 8);
                        a++;
                    } while (lq_rs.next());
                    lo_pnl_grid_liquidacion.TBL_liquidacion.requestFocus();
                    lo_pnl_grid_liquidacion.TBL_liquidacion.changeSelection(0, 8, false, false);
                }
            } catch (Exception e) {
            }
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_buscar", "SELECCIONE DOCUMENTO");
        }
    }

    private void evt_nuevo() {
        ls_codigo = null;
        lo_evt_cab_liquidacion.limpia_datos(lo_pnl_cab_liquidacion);
        lo_evt_grid_liquidacion.limpia_tabla(lo_pnl_grid_liquidacion, li_tipo_operacion);
        li_tipo_operacion = 0;

        try {
            lq_rs = go_dao_liquidacion.FNC_correlativo_liquidacion(ls_codigo_sucursal);
            if (lq_rs.next()) {
                lo_pnl_cab_liquidacion.TXT_numero.setText(lq_rs.getString(1));
                lo_pnl_cab_liquidacion.LBL_numero_doc.setText(lq_rs.getString(1));
            }
        } catch (Exception e) {
        }

        lo_evt_opciones_3.activa_btn_opciones(1, lo_pnl_opciones_3, lb_valor_op);
        lo_evt_cab_liquidacion.activa_campos(0, lo_pnl_cab_liquidacion, true);
        lo_evt_grid_liquidacion.activa_campos(0, lo_pnl_grid_liquidacion, true);
    }

    private void evt_buscar() {
        li_tipo_operacion = 2;
        genera_parametros_busq();
        go_dlg_busq_liquidacion = new dlg_busq_liquidacion(null, true);
        go_dlg_busq_liquidacion.setVisible(true);
        ls_codigo = go_dlg_busq_liquidacion.ls_codigo;
        if (ls_codigo != null) {
            get_descripcion_liquidacion(ls_codigo);
            lo_evt_opciones_3.activa_btn_opciones(2, lo_pnl_opciones_3, lb_valor_op);
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_buscar", "SELECCIONE DOCUMENTO");
            lo_evt_cab_liquidacion.limpia_datos(lo_pnl_cab_liquidacion);
            lo_evt_grid_liquidacion.limpia_tabla(lo_pnl_grid_liquidacion, li_tipo_operacion);
            lo_evt_opciones_3.activa_btn_opciones(0, lo_pnl_opciones_3, lb_valor_op);
        }
    }

    private void evt_eliminar() {
        //if (go_dao_pedido.FNC_verifica_pedido_facturado(ls_codigo).equalsIgnoreCase("0")) {
        if (go_fnc_mensaje.get_respuesta(0, "¿DESEA ELIMINAR DOCUMENTO Nro LQ - " + lo_bean_liquidacion.getNumero_documento() + "?") == 0) {
            try {
                if (go_dao_liquidacion_detalle.DLT_liquidacion_detalle(ls_codigo)) {
                    if (go_dao_liquidacion.DLT_liquidacion(ls_codigo)) {
                        lo_evt_opciones_3.activa_btn_opciones(0, lo_pnl_opciones_3, lb_valor_op);
                        lo_evt_cab_liquidacion.activa_campos(0, lo_pnl_cab_liquidacion, false);
                        lo_evt_cab_liquidacion.limpia_datos(lo_pnl_cab_liquidacion);
                        lo_evt_grid_liquidacion.activa_campos(0, lo_pnl_grid_liquidacion, false);
                        lo_evt_grid_liquidacion.limpia_tabla(lo_pnl_grid_liquidacion, 0);
                    }
                }
            } catch (Exception e) {
            }
        }
//        } else {
//            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_eliminar", "PEDIDO FACTURADO");
//        }
    }

    private void evt_guardar() {
        switch (li_tipo_operacion) {
            case 0:
                if (lo_evt_cab_liquidacion.valida_campos(lo_pnl_cab_liquidacion)) {
                    if (lo_evt_grid_liquidacion.valida_campos(lo_pnl_grid_liquidacion)) {
                        try {
                            ls_codigo = "LQ" + ls_serie + lo_pnl_cab_liquidacion.TXT_numero.getText().trim();
                            lo_bean_liquidacion.setCodigo_operacion(ls_codigo);
                            lo_bean_liquidacion.setCodigo_sucursal(ls_codigo_sucursal);
                            lo_bean_liquidacion.setCodigo_programacion(ls_codigo_programacion);
                            lo_evt_cab_liquidacion.setea_campos(lo_bean_liquidacion, lo_pnl_cab_liquidacion, lo_pnl_grid_liquidacion);
                            if (go_dao_liquidacion.IST_liquidacion(lo_bean_liquidacion, lo_pnl_grid_liquidacion.TBL_liquidacion)) {
                                lo_evt_cab_liquidacion.limpia_datos(lo_pnl_cab_liquidacion);
                                lo_evt_cab_liquidacion.activa_campos(0, lo_pnl_cab_liquidacion, false);
                                lo_evt_grid_liquidacion.limpia_tabla(lo_pnl_grid_liquidacion, li_tipo_operacion);
                                lo_evt_grid_liquidacion.activa_campos(0, lo_pnl_grid_liquidacion, false);
                                lo_evt_opciones_3.activa_btn_opciones(0, lo_pnl_opciones_3, lb_valor_op);
                            }
                        } catch (Exception e) {
                        }
                    }
                }
                break;
        }
    }

    private void evt_cancelar() {
        li_tipo_operacion = 2;
        lo_evt_cab_liquidacion.activa_campos(0, lo_pnl_cab_liquidacion, false);
        lo_evt_grid_liquidacion.activa_campos(0, lo_pnl_grid_liquidacion, false);
        lo_evt_grid_liquidacion.limpia_tabla(lo_pnl_grid_liquidacion, li_tipo_operacion);
        if (ls_codigo != null) {
            lo_evt_cab_liquidacion.muestra_datos(lo_pnl_cab_liquidacion, lo_bean_liquidacion, lo_pnl_grid_liquidacion);
            get_descripcion_liquidacion_detalle(ls_codigo);
            lo_evt_opciones_3.activa_btn_opciones(2, lo_pnl_opciones_3, lb_valor_op);
        } else {
            lo_evt_cab_liquidacion.limpia_datos(lo_pnl_cab_liquidacion);
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
                //evt_editar();
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
                // evt_imprimir(lo_bean_programacion.getStatus(), lo_bean_programacion.getCodigo_programacion());
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
                //evt_editar();
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
                if (ke.getSource() == lo_pnl_cab_liquidacion.TXT_programacion) {
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
                    //   evt_editar();
                }
                if (ke.getSource() == lo_pnl_opciones_3.BTN_eliminar) {
                    evt_eliminar();
                }
                if (ke.getSource() == lo_pnl_opciones_3.BTN_guardar) {
                    evt_guardar();
                }
                if (ke.getSource() == lo_pnl_opciones_3.BTN_anular) {
                    //   evt_anular();
                }
                if (ke.getSource() == lo_pnl_opciones_3.BTN_cancelar) {
                    evt_cancelar();
                }
                if (ke.getSource() == lo_pnl_opciones_3.BTN_imprimir) {
                    //evt_imprimir(lo_bean_programacion.getStatus(), lo_bean_programacion.getCodigo_programacion());
                }
                if (ke.getSource() == lo_pnl_cab_liquidacion.TXT_numero) {
                    if (go_fnc_operaciones_campos.campo_blanco(lo_pnl_cab_liquidacion.TXT_numero)) {
                        lo_pnl_cab_liquidacion.TXT_numero.setText(go_fnc_operaciones_campos.completa_digitos(lo_pnl_cab_liquidacion.TXT_numero.getText().trim(), "0", 10));
                        lo_pnl_cab_liquidacion.LBL_numero_doc.setText(lo_pnl_cab_liquidacion.TXT_numero.getText());
                        lo_pnl_cab_liquidacion.TXT_fecha_emision.requestFocus();
                    }
                }
                if (ke.getSource() == lo_pnl_cab_liquidacion.TXT_fecha_emision && !lo_pnl_cab_liquidacion.TXT_fecha_emision.getText().trim().equalsIgnoreCase("/  /")) {
                    if (go_fnc_operaciones_campos.valida_fecha(lo_pnl_cab_liquidacion.TXT_fecha_emision.getText())) {
                        if (lo_pnl_cab_liquidacion.TXT_fecha_emision.getText().trim().substring(6, 10).equalsIgnoreCase(gs_periodo)) {
                            getFocusOwner().transferFocus();
                        } else {
                            lo_pnl_cab_liquidacion.TXT_fecha_emision.setText("");
                            go_fnc_mensaje.GET_mensaje(0, ls_modulo, ls_capa, ls_clase, "keyPressed", "FECHA NO PERTENECE AL PERIODO");
                        }
                    } else {
                        lo_pnl_cab_liquidacion.TXT_fecha_emision.setText("");
                        go_fnc_mensaje.GET_mensaje(0, ls_modulo, ls_capa, ls_clase, "keyPressed", "FORMATO DE FECHA INVALIDO");
                    }
                }
                if (ke.getSource() == lo_pnl_cab_liquidacion.TXT_programacion && go_fnc_operaciones_campos.cant_caracter(lo_pnl_cab_liquidacion.TXT_programacion.getText().trim(), 4, 10)) {
                    getFocusOwner().transferFocus();
                }
                if (ke.getSource() == lo_pnl_cab_liquidacion.TXT_observacion) {
                    if (lo_pnl_grid_liquidacion.TBL_liquidacion.getRowCount() == 0) {
                        lo_pnl_grid_liquidacion.TBL_liquidacion.requestFocus();
                        lo_evt_grid_liquidacion.agrega_fila(lo_pnl_grid_liquidacion, -1);
                    } else {
                        lo_pnl_grid_liquidacion.TBL_liquidacion.requestFocus();
                        lo_pnl_grid_liquidacion.TBL_liquidacion.changeSelection(0, 2, false, false);
                    }
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent ke) {
            if (ke.getSource() == lo_pnl_cab_liquidacion.TXT_numero) {
                lo_pnl_cab_liquidacion.LBL_numero_doc.setText(lo_pnl_cab_liquidacion.TXT_numero.getText());
            }
            if (ke.getSource() == lo_pnl_grid_liquidacion.TBL_liquidacion) {
                int fila = lo_pnl_grid_liquidacion.TBL_liquidacion.getSelectedRow();
                lo_evt_grid_liquidacion.suma_importes(lo_pnl_grid_liquidacion);
                genera_importe(fila);
            }
            if (lo_pnl_grid_liquidacion.TBL_liquidacion.getSelectedColumn() == 10) {
                int fila = lo_pnl_grid_liquidacion.TBL_liquidacion.getSelectedRow();
                if (fila < lo_pnl_grid_liquidacion.TBL_liquidacion.getRowCount()) {
                    lo_pnl_grid_liquidacion.TBL_liquidacion.changeSelection(fila + 1, 8, false, false);
                } else {
                    lo_pnl_grid_liquidacion.TBL_liquidacion.changeSelection(fila - 1, 8, false, false);
                }
            }
        }
    };

    MouseListener MouseEvent = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent me) {
            if (me.getSource() == lo_pnl_grid_liquidacion.TBL_liquidacion && lo_pnl_grid_liquidacion.TBL_liquidacion.isEnabled()) {
                int columna = lo_pnl_grid_liquidacion.TBL_liquidacion.getColumnModel().getColumnIndexAtX(me.getX());
                int fila = me.getY() / lo_pnl_grid_liquidacion.TBL_liquidacion.getRowHeight();
                Object value = lo_pnl_grid_liquidacion.TBL_liquidacion.getValueAt(fila, columna);
                if (value instanceof JButton) {
                    if (go_fnc_mensaje.get_respuesta(0, "¿DESEA ELIMINAR ITEM " + go_fnc_operaciones_campos.completa_digitos((fila + 1) + "", "0", 3) + "?") == 0) {
                        lo_evt_grid_liquidacion.elimina_fila(lo_pnl_grid_liquidacion, fila);
                        lo_evt_grid_liquidacion.genera_item(lo_pnl_grid_liquidacion);
                    }
                }
                if (columna == 6) {
                    if ((boolean) lo_pnl_grid_liquidacion.TBL_liquidacion.getValueAt(fila, 6)) {
                        lo_pnl_grid_liquidacion.TBL_liquidacion.setValueAt(Double.parseDouble(lo_pnl_grid_liquidacion.TBL_liquidacion.getValueAt(fila, 5).toString()), fila, 8);
                    } else {
                        lo_pnl_grid_liquidacion.TBL_liquidacion.setValueAt(0.00, fila, 8);
                    }
                    genera_importe(fila);
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
        setTitle("LIQUIDACION");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/JAVA/ANCESTRO/IMAGES/formulario.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 719, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 573, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
