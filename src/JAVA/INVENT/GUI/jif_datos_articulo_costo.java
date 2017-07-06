package JAVA.INVENT.GUI;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.ANCESTRO.GUI.pnl_opciones_2;
import JAVA.ANCESTRO.LOGICA.evt_opciones_2;
import JAVA.ANCESTRO.LOGICA.recupera_valor_op;
import JAVA.INVENT.BEAN.BEAN_articulo_costo;
import JAVA.INVENT.LOGICA.evt_datos_articulo_costo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;

public class jif_datos_articulo_costo extends javax.swing.JInternalFrame {

    pnl_opciones_2 lo_pnl_opciones_2 = new pnl_opciones_2();
    evt_opciones_2 lo_evt_opciones_2 = new evt_opciones_2();
    recupera_valor_op lo_recupera_valor_op = new recupera_valor_op();
    evt_datos_articulo_costo lo_evt_datos_articulo_costo = new evt_datos_articulo_costo();
    pnl_datos_articulo_costo lo_pnl_datos_articulo_costo = new pnl_datos_articulo_costo();
    BEAN_articulo_costo lo_bean_articulo_costo = new BEAN_articulo_costo();
    static boolean lb_valor_op[] = new boolean[8];
    ResultSet lq_rs = null;
    int li_tipo_operacion;
    String ls_codigo, ls_codigo_articulo, ls_oc, ls_periodo_produccion, ls_item_orden;
    String ls_opcion = "M C F";
    String ls_modulo = "INVENT", ls_capa = "GUI", ls_clase = "jif_datos_articulo_costo";

    public jif_datos_articulo_costo() {
        initComponents();
        formulario();
        activa_botones();
        get_tipo_procedencia();
    }

    private void formulario() {
        lo_pnl_opciones_2.setBounds(0, 0, 655, 120);
        lo_pnl_datos_articulo_costo.setBounds(12, 130, 550, 350);

        this.add(lo_pnl_opciones_2);
        this.add(lo_pnl_datos_articulo_costo);

        lo_evt_opciones_2.evento_click(lo_pnl_opciones_2, Listener);
        lo_evt_opciones_2.evento_press(lo_pnl_opciones_2, KeyEvnt);

        lo_evt_datos_articulo_costo.evento_press(lo_pnl_datos_articulo_costo, KeyEvnt);
        lo_evt_datos_articulo_costo.evento_item(lo_pnl_datos_articulo_costo, ItemEvent);
        lo_evt_datos_articulo_costo.evento_focus(lo_pnl_datos_articulo_costo, FocusEvent);
    }

    private void activa_botones() {
        lb_valor_op = lo_recupera_valor_op.recupera(ls_modulo, ls_opcion);
        lo_evt_opciones_2.activa_btn_opciones(0, lo_pnl_opciones_2, lb_valor_op);
    }

    private void activa_campos() {
        if (lo_pnl_datos_articulo_costo.CBX_procedencia.getSelectedIndex() == 1) {
            if (li_tipo_operacion != 1) {
                lo_pnl_datos_articulo_costo.CBX_mes.setSelectedIndex(1);
            }
            lo_pnl_datos_articulo_costo.CBX_mes.setEnabled(true);
            lo_pnl_datos_articulo_costo.TXT_anio.setEnabled(true);
        } else {
            lo_pnl_datos_articulo_costo.CBX_mes.setSelectedIndex(0);
            lo_pnl_datos_articulo_costo.CBX_mes.setEnabled(false);
            lo_pnl_datos_articulo_costo.TXT_anio.setEnabled(false);
        }
    }

    private void get_tipo_procedencia() {
        lo_pnl_datos_articulo_costo.CBX_tipo_procedencia.removeAllItems();
        int op = lo_pnl_datos_articulo_costo.CBX_procedencia.getSelectedIndex();
        switch (op) {
            case 0:
                lo_pnl_datos_articulo_costo.CBX_tipo_procedencia.addItem("NACIONAL");
                lo_pnl_datos_articulo_costo.CBX_tipo_procedencia.addItem("IMPORTADA");
                break;
            case 1:
                lo_pnl_datos_articulo_costo.CBX_tipo_procedencia.addItem("MEZCLA");
                break;
            case 2:
                lo_pnl_datos_articulo_costo.CBX_tipo_procedencia.addItem("OTROS");
                break;
        }
    }

    private void get_descripcion_articulo(String codigo) {
        try {
            lq_rs = go_dao_articulo.SLT_datos_articulo(codigo);
            if (lq_rs != null) {
                lo_pnl_datos_articulo_costo.TXT_nombre.setText(lq_rs.getString(2));
            } else {
                go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "get_descripcion_articulo", "ARTICULO NO EXISTE");
                lo_pnl_datos_articulo_costo.TXT_codigo_articulo.setText("");
                lo_pnl_datos_articulo_costo.TXT_nombre.setText("");
                lo_pnl_datos_articulo_costo.TXT_codigo_articulo.requestFocus();
            }
        } catch (Exception e) {
        }
    }

    private void get_descripcion_articulo_costo(String codigo_orden, String codigo_articulo, String periodo_produccion) {
        try {
            lq_rs = go_dao_articulo_costo.SLT_datos_articulo_costo(codigo_orden, codigo_articulo, periodo_produccion);
            if (lq_rs != null) {
                lo_evt_datos_articulo_costo.setea_recupera(lo_bean_articulo_costo, lq_rs);
                lo_evt_datos_articulo_costo.muestra_datos(lo_pnl_datos_articulo_costo, lo_bean_articulo_costo);
            }
        } catch (Exception e) {
        }
    }

    private void genera_codigo_orden() {
        ls_codigo = lo_pnl_datos_articulo_costo.TXT_periodo.getText().trim() + lo_pnl_datos_articulo_costo.CBX_procedencia.getSelectedIndex() + lo_pnl_datos_articulo_costo.CBX_tipo_procedencia.getSelectedIndex() + lo_pnl_datos_articulo_costo.TXT_numero.getText().trim();
    }

    private void evt_f5_articulo() {
        go_dlg_busq_articulo = new dlg_busq_articulo(null, true);
        go_dlg_busq_articulo.setVisible(true);
        ls_codigo_articulo = go_dlg_busq_articulo.ls_codigo_articulo;
        if (ls_codigo_articulo != null) {
            get_descripcion_articulo(ls_codigo_articulo);
            lo_pnl_datos_articulo_costo.TXT_codigo_articulo.setText(ls_codigo_articulo);
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_buscar", "SELECCIONE ARTICULO");
            lo_evt_datos_articulo_costo.limpia_datos(lo_pnl_datos_articulo_costo);
        }
    }

    private void evt_nuevo() {
        ls_codigo = null;
        lo_evt_datos_articulo_costo.limpia_datos(lo_pnl_datos_articulo_costo);
        li_tipo_operacion = 0;
        lo_evt_opciones_2.activa_btn_opciones(1, lo_pnl_opciones_2, lb_valor_op);
        lo_evt_datos_articulo_costo.activa_campos(0, lo_pnl_datos_articulo_costo, true);
        activa_campos();
    }

    private void evt_buscar() {
        li_tipo_operacion = 2;
        go_dlg_busq_articulo_costo = new dlg_busq_articulo_costo(null, true);
        go_dlg_busq_articulo_costo.setVisible(true);
        ls_codigo_articulo = go_dlg_busq_articulo_costo.ls_codigo_articulo;
        ls_oc = go_dlg_busq_articulo_costo.ls_oc;
        ls_periodo_produccion = go_dlg_busq_articulo_costo.ls_periodo_produccion;        
        if (ls_periodo_produccion != null) {
            ls_codigo = ls_oc.substring(8, 12) + ls_oc.substring(0, 2) + ls_oc.substring(3, 7);
            get_descripcion_articulo_costo(ls_codigo, ls_codigo_articulo, ls_periodo_produccion);
            lo_evt_opciones_2.activa_btn_opciones(2, lo_pnl_opciones_2, lb_valor_op);
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_buscar", "SELECCIONE ARTICULO COSTO");
            lo_evt_datos_articulo_costo.limpia_datos(lo_pnl_datos_articulo_costo);
            lo_evt_opciones_2.activa_btn_opciones(0, lo_pnl_opciones_2, lb_valor_op);
        }
    }

    private void evt_editar() {
        li_tipo_operacion = 1;
        lo_evt_opciones_2.activa_btn_opciones(3, lo_pnl_opciones_2, lb_valor_op);
        lo_evt_datos_articulo_costo.activa_campos(1, lo_pnl_datos_articulo_costo, true);
        activa_campos();
    }

    private void evt_eliminar() {
        if (go_fnc_mensaje.get_respuesta(0, "¿DESEA ELIMINAR ARTICULO COSTO Nro " + lo_bean_articulo_costo.getNumero() + "/" + lo_bean_articulo_costo.getPeriodo() + "?") == 0) {
            try {
                if (go_dao_articulo_costo.DLT_articulo_costo(lo_bean_articulo_costo)) {
                    lo_evt_opciones_2.activa_btn_opciones(0, lo_pnl_opciones_2, lb_valor_op);
                    lo_evt_datos_articulo_costo.activa_campos(0, lo_pnl_datos_articulo_costo, false);
                    lo_evt_datos_articulo_costo.limpia_datos(lo_pnl_datos_articulo_costo);
                }
            } catch (Exception e) {
            }
        }
    }

    private void evt_guardar() {
        switch (li_tipo_operacion) {
            case 0:
                if (lo_evt_datos_articulo_costo.valida_campos(lo_pnl_datos_articulo_costo)) {
                    genera_codigo_orden();
                    ls_codigo_articulo = lo_pnl_datos_articulo_costo.TXT_codigo_articulo.getText().trim();
                    ls_periodo_produccion = go_fnc_operaciones_campos.completa_digitos(lo_pnl_datos_articulo_costo.CBX_mes.getSelectedIndex() + "", "0", 2) + "-" + lo_pnl_datos_articulo_costo.TXT_anio.getText().trim();
                    ls_item_orden = go_dao_articulo_costo.FNC_genera_item_orden(ls_codigo, ls_codigo_articulo, ls_periodo_produccion);
                    try {
                        if (!ls_item_orden.equalsIgnoreCase("000")) {
                            lo_bean_articulo_costo.setCodigo_orden(ls_codigo);
                            lo_bean_articulo_costo.setItem_orden(ls_item_orden);
                            lo_evt_datos_articulo_costo.setea_campos(lo_bean_articulo_costo, lo_pnl_datos_articulo_costo);
                            if (go_dao_articulo_costo.IST_articulo_costo(lo_bean_articulo_costo)) {
                                lo_evt_datos_articulo_costo.limpia_datos(lo_pnl_datos_articulo_costo);
                                lo_evt_datos_articulo_costo.activa_campos(0, lo_pnl_datos_articulo_costo, false);
                                lo_evt_opciones_2.activa_btn_opciones(0, lo_pnl_opciones_2, lb_valor_op);
                            }
                        } else {
                            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_guardar", "ARTICULO COSTO YA EXISTE");
                        }
                    } catch (Exception e) {
                    }
                }
                break;
            case 1:
                if (lo_evt_datos_articulo_costo.verifica_cambios(lo_bean_articulo_costo, lo_pnl_datos_articulo_costo)) {
                    if (lo_evt_datos_articulo_costo.valida_campos(lo_pnl_datos_articulo_costo)) {
                        try {
                            ls_periodo_produccion = lo_bean_articulo_costo.getPeriodo_produccion();
                            lo_evt_datos_articulo_costo.setea_campos(lo_bean_articulo_costo, lo_pnl_datos_articulo_costo);
                            if (go_dao_articulo_costo.UPD_articulo_costo(lo_bean_articulo_costo, ls_periodo_produccion)) {
                                lo_evt_datos_articulo_costo.limpia_datos(lo_pnl_datos_articulo_costo);
                                lo_evt_datos_articulo_costo.activa_campos(0, lo_pnl_datos_articulo_costo, false);
                                lo_evt_opciones_2.activa_btn_opciones(0, lo_pnl_opciones_2, lb_valor_op);
                            }
                        } catch (Exception e) {
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
        lo_evt_datos_articulo_costo.activa_campos(0, lo_pnl_datos_articulo_costo, false);
        if (ls_codigo != null) {
            lo_evt_datos_articulo_costo.muestra_datos(lo_pnl_datos_articulo_costo, lo_bean_articulo_costo);
            lo_evt_opciones_2.activa_btn_opciones(2, lo_pnl_opciones_2, lb_valor_op);
        } else {
            lo_evt_datos_articulo_costo.limpia_datos(lo_pnl_datos_articulo_costo);
            lo_evt_opciones_2.activa_btn_opciones(0, lo_pnl_opciones_2, lb_valor_op);
        }
    }

    ActionListener Listener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == lo_pnl_opciones_2.BTN_nuevo) {
                evt_nuevo();
            }
            if (ae.getSource() == lo_pnl_opciones_2.BTN_buscar) {
                evt_buscar();
            }
            if (ae.getSource() == lo_pnl_opciones_2.BTN_editar) {
                evt_editar();
            }
            if (ae.getSource() == lo_pnl_opciones_2.BTN_eliminar) {
                evt_eliminar();
            }
            if (ae.getSource() == lo_pnl_opciones_2.BTN_guardar) {
                evt_guardar();
            }
            if (ae.getSource() == lo_pnl_opciones_2.BTN_cancelar) {
                evt_cancelar();
            }
            if (ae.getSource() == lo_pnl_opciones_2.BTN_reporte) {
                //evt_reporte();
            }
        }
    };

    KeyListener KeyEvnt = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent ke) {

        }

        @Override
        public void keyPressed(KeyEvent ke) {
            if (ke.getKeyCode() == KeyEvent.VK_F5) {
                if (ke.getSource() == lo_pnl_datos_articulo_costo.TXT_codigo_articulo) {
                    evt_f5_articulo();
                }
            }
            if (ke.getKeyCode() == KeyEvent.VK_F1 && lo_pnl_opciones_2.BTN_nuevo.isEnabled()) {
                evt_nuevo();
            }
            if (ke.getKeyCode() == KeyEvent.VK_F2 && lo_pnl_opciones_2.BTN_buscar.isEnabled()) {
                evt_buscar();
            }
            if (ke.getKeyCode() == KeyEvent.VK_F3 && lo_pnl_opciones_2.BTN_editar.isEnabled()) {
                evt_editar();
            }
            if (ke.getKeyCode() == KeyEvent.VK_F4 && lo_pnl_opciones_2.BTN_eliminar.isEnabled()) {
                evt_eliminar();
            }
            if (ke.getKeyCode() == KeyEvent.VK_F6 && lo_pnl_opciones_2.BTN_guardar.isEnabled()) {
                evt_guardar();
            }
            if (ke.getKeyCode() == KeyEvent.VK_ESCAPE && lo_pnl_opciones_2.BTN_cancelar.isEnabled()) {
                evt_cancelar();
            }
            if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                if (ke.getSource() == lo_pnl_opciones_2.BTN_nuevo) {
                    evt_nuevo();
                }
                if (ke.getSource() == lo_pnl_opciones_2.BTN_buscar) {
                    evt_buscar();
                }
                if (ke.getSource() == lo_pnl_opciones_2.BTN_editar) {
                    evt_editar();
                }
                if (ke.getSource() == lo_pnl_opciones_2.BTN_eliminar) {
                    evt_eliminar();
                }
                if (ke.getSource() == lo_pnl_opciones_2.BTN_guardar) {
                    evt_guardar();
                }
                if (ke.getSource() == lo_pnl_opciones_2.BTN_cancelar) {
                    evt_cancelar();
                }
                if (ke.getSource() == lo_pnl_opciones_2.BTN_reporte) {
                    //evt_reporte();
                }
                if (ke.getSource() == lo_pnl_datos_articulo_costo.TXT_codigo_articulo && go_fnc_operaciones_campos.cant_caracter(lo_pnl_datos_articulo_costo.TXT_codigo_articulo.getText().trim(), 1, 12)) {
                    lo_pnl_datos_articulo_costo.CBX_procedencia.requestFocus();
                    get_descripcion_articulo(lo_pnl_datos_articulo_costo.TXT_codigo_articulo.getText().trim());
                }
                if (ke.getSource() == lo_pnl_datos_articulo_costo.CBX_procedencia) {
                    get_tipo_procedencia();
                    lo_pnl_datos_articulo_costo.CBX_tipo_procedencia.requestFocus();
                }
                if (ke.getSource() == lo_pnl_datos_articulo_costo.CBX_tipo_procedencia) {
                    lo_pnl_datos_articulo_costo.TXT_numero.requestFocus();
                }
                if (ke.getSource() == lo_pnl_datos_articulo_costo.TXT_numero && go_fnc_operaciones_campos.campo_blanco(lo_pnl_datos_articulo_costo.TXT_numero)) {
                    lo_pnl_datos_articulo_costo.TXT_numero.setText(go_fnc_operaciones_campos.completa_digitos(lo_pnl_datos_articulo_costo.TXT_numero.getText().trim(), "0", 4));
                    lo_pnl_datos_articulo_costo.TXT_periodo.requestFocus();
                }
                if (ke.getSource() == lo_pnl_datos_articulo_costo.TXT_periodo && go_fnc_operaciones_campos.cant_caracter(lo_pnl_datos_articulo_costo.TXT_periodo.getText().trim(), 1, 4)) {
                    lo_pnl_datos_articulo_costo.TXT_costo.requestFocus();
                }
                if (ke.getSource() == lo_pnl_datos_articulo_costo.TXT_costo) {
                    if (!go_fnc_operaciones_campos.campo_blanco(lo_pnl_datos_articulo_costo.TXT_costo)) {
                        lo_pnl_datos_articulo_costo.TXT_costo.setText("0.00000");
                    }
                    if (lo_pnl_datos_articulo_costo.CBX_mes.isEnabled()) {
                        lo_pnl_datos_articulo_costo.CBX_mes.requestFocus();
                    } else {
                        lo_pnl_datos_articulo_costo.TXT_codigo_entidad.requestFocus();
                    }
                }
                if (ke.getSource() == lo_pnl_datos_articulo_costo.CBX_mes) {
                    lo_pnl_datos_articulo_costo.TXT_anio.requestFocus();
                }
                if (ke.getSource() == lo_pnl_datos_articulo_costo.TXT_anio && go_fnc_operaciones_campos.cant_caracter(lo_pnl_datos_articulo_costo.TXT_periodo.getText().trim(), 1, 4)) {
                    lo_pnl_datos_articulo_costo.TXT_codigo_entidad.requestFocus();
                }
                if (ke.getSource() == lo_pnl_datos_articulo_costo.TXT_codigo_entidad && go_fnc_operaciones_campos.cant_caracter(lo_pnl_datos_articulo_costo.TXT_codigo_entidad.getText().trim(), 1, 6)) {
                    lo_pnl_datos_articulo_costo.TXT_fecha_ingreso.requestFocus();
                }
                if (ke.getSource() == lo_pnl_datos_articulo_costo.TXT_fecha_ingreso && !lo_pnl_datos_articulo_costo.TXT_fecha_ingreso.getText().trim().equalsIgnoreCase("/  /")) {
                    if (go_fnc_operaciones_campos.valida_fecha(lo_pnl_datos_articulo_costo.TXT_fecha_ingreso.getText())) {
                        getFocusOwner().transferFocus();
                    } else {
                        lo_pnl_datos_articulo_costo.TXT_fecha_ingreso.setText("");
                        go_fnc_mensaje.GET_mensaje(0, ls_modulo, ls_capa, ls_clase, "keyPressed", "FORMATO DE FECHA INVALIDO ");
                    }
                }
                if (ke.getSource() == lo_pnl_datos_articulo_costo.TXT_fecha_produccion && !lo_pnl_datos_articulo_costo.TXT_fecha_produccion.getText().trim().equalsIgnoreCase("/  /")) {
                    if (go_fnc_operaciones_campos.valida_fecha(lo_pnl_datos_articulo_costo.TXT_fecha_produccion.getText())) {
                        getFocusOwner().transferFocus();
                    } else {
                        lo_pnl_datos_articulo_costo.TXT_fecha_produccion.setText("");
                        go_fnc_mensaje.GET_mensaje(0, ls_modulo, ls_capa, ls_clase, "keyPressed", "FORMATO DE FECHA INVALIDO ");
                    }
                }
                if (ke.getSource() == lo_pnl_datos_articulo_costo.TXT_fecha_vencimiento && !lo_pnl_datos_articulo_costo.TXT_fecha_vencimiento.getText().trim().equalsIgnoreCase("/  /")) {
                    if (go_fnc_operaciones_campos.valida_fecha(lo_pnl_datos_articulo_costo.TXT_fecha_vencimiento.getText())) {
                        getFocusOwner().transferFocus();
                    } else {
                        lo_pnl_datos_articulo_costo.TXT_fecha_vencimiento.setText("");
                        go_fnc_mensaje.GET_mensaje(0, ls_modulo, ls_capa, ls_clase, "keyPressed", "FORMATO DE FECHA INVALIDO ");
                    }
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
                if (ie.getSource() == lo_pnl_datos_articulo_costo.CBX_procedencia) {
                    get_tipo_procedencia();
                    activa_campos();
                }
            }
        }
    };

    FocusListener FocusEvent = new FocusListener() {
        @Override
        public void focusGained(java.awt.event.FocusEvent fe) {
        }

        @Override
        public void focusLost(java.awt.event.FocusEvent fe) {
            if (fe.getSource() == lo_pnl_datos_articulo_costo.TXT_codigo_articulo) {
                //get_descripcion_articulo(lo_pnl_datos_articulo_costo.txt_codigo_articulo.getText().trim());
            }
        }
    };

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setClosable(true);
        setIconifiable(true);
        setTitle("ARTICULO");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/JAVA/INVENT/IMAGES/costo.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 642, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 372, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
