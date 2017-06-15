package JAVA.CONFIG.GUI;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.ANCESTRO.GUI.pnl_opciones_2;
import JAVA.ANCESTRO.LOGICA.evt_opciones_2;
import JAVA.ANCESTRO.LOGICA.recupera_valor_op;
import JAVA.CONFIG.BEAN.BEAN_tipo_movimiento;
import JAVA.CONFIG.LOGICA.cbx_almacen;
import JAVA.CONFIG.LOGICA.cbx_tabla_sunat;
import JAVA.CONFIG.LOGICA.evt_datos_tipo_movimiento;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

public class jif_datos_tipo_movimiento extends javax.swing.JInternalFrame {

    pnl_opciones_2 lo_pnl_opciones_2 = new pnl_opciones_2();
    pnl_datos_tipo_movimiento lo_pnl_datos_tipo_movimiento = new pnl_datos_tipo_movimiento();
    evt_opciones_2 lo_evt_opciones_2 = new evt_opciones_2();
    recupera_valor_op lo_recupera_valor_op = new recupera_valor_op();
    evt_datos_tipo_movimiento lo_evt_datos_tipo_movimiento = new evt_datos_tipo_movimiento();
    BEAN_tipo_movimiento lo_bean_tipo_movimiento = new BEAN_tipo_movimiento();
    cbx_almacen lo_cbx_almacen;
    cbx_tabla_sunat lo_cbx_tabla_sunat;
    static boolean lb_valor_op[] = new boolean[8];
    ResultSet lq_rs = null;
    String ls_codigo;
    int li_tipo_operacion;
    String ls_opcion = "M C D";
    String ls_modulo = "CONFIG", ls_capa = "GUI", ls_clase = "jif_datos_tipo_movimiento";

    public jif_datos_tipo_movimiento() {
        initComponents();
        formulario();
        activa_botones();
        get_almacen();
        get_tabla_sunat();
    }

    private void formulario() {
        lo_pnl_opciones_2.setBounds(0, 0, 655, 120);
        lo_pnl_datos_tipo_movimiento.setBounds(12, 130, 500, 300);

        this.add(lo_pnl_opciones_2);
        this.add(lo_pnl_datos_tipo_movimiento);

        lo_evt_opciones_2.evento_click(lo_pnl_opciones_2, Listener);
        lo_evt_opciones_2.evento_press(lo_pnl_opciones_2, KeyEvnt);
        lo_evt_datos_tipo_movimiento.evento_press(lo_pnl_datos_tipo_movimiento, KeyEvnt);
    }

    private void activa_botones() {
        lb_valor_op = lo_recupera_valor_op.recupera(ls_modulo, ls_opcion);
        lo_evt_opciones_2.activa_btn_opciones(0, lo_pnl_opciones_2, lb_valor_op);
    }

    private void get_almacen() {

        lq_rs = go_dao_almacen.SLT_cbx_almacen("1");
        if (lq_rs != null) {
            go_cbx_trato_datos.recupera_valor(3, lq_rs, lo_pnl_datos_tipo_movimiento.CBX_almacen);
        }
    }

    private void get_tabla_sunat() {

        lq_rs = go_dao_tabla_sunat.SLT_cbx_tabla_sunat("012");
        if (lq_rs != null) {
            go_cbx_trato_datos.recupera_valor(4, lq_rs, lo_pnl_datos_tipo_movimiento.CBX_codigo_sunat);
        }
    }

    private void get_descripcion_tipo_movimiento(String codigo) {
        try {
            lq_rs = go_dao_tipo_movimiento.SLT_datos_tipo_movimiento(codigo);
            if (lq_rs != null) {
                lo_evt_datos_tipo_movimiento.setea_recupera(lo_bean_tipo_movimiento, lq_rs);
                lo_evt_datos_tipo_movimiento.muestra_datos(lo_pnl_datos_tipo_movimiento, lo_bean_tipo_movimiento);
            }
        } catch (Exception e) {
        }
    }

    private void evt_nuevo() {
        ls_codigo = null;
        lo_evt_datos_tipo_movimiento.limpia_datos(lo_pnl_datos_tipo_movimiento);
        li_tipo_operacion = 0;
        lo_evt_opciones_2.activa_btn_opciones(1, lo_pnl_opciones_2, lb_valor_op);
        lo_evt_datos_tipo_movimiento.activa_campos(0, lo_pnl_datos_tipo_movimiento, true);
    }

    private void evt_buscar() {
        go_dlg_busq_tipo_movimiento = new dlg_busq_tipo_movimiento(null, true);
        go_dlg_busq_tipo_movimiento.setVisible(true);
        ls_codigo = go_dlg_busq_tipo_movimiento.ls_codigo_tipo_movimiento;
        if (ls_codigo != null) {
            get_descripcion_tipo_movimiento(ls_codigo);
            lo_evt_opciones_2.activa_btn_opciones(2, lo_pnl_opciones_2, lb_valor_op);
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_buscar", "SELECCIONE TIPO MOVIMIENTO");
            lo_evt_datos_tipo_movimiento.limpia_datos(lo_pnl_datos_tipo_movimiento);
            lo_evt_opciones_2.activa_btn_opciones(0, lo_pnl_opciones_2, lb_valor_op);
        }
    }

    private void evt_editar() {
        li_tipo_operacion = 1;
        lo_evt_opciones_2.activa_btn_opciones(3, lo_pnl_opciones_2, lb_valor_op);
        lo_evt_datos_tipo_movimiento.activa_campos(1, lo_pnl_datos_tipo_movimiento, true);
    }

    private void evt_eliminar() {
        if (go_fnc_mensaje.get_respuesta(0, "¿DESEA ELIMINAR TIPO MOVIMIENTO " + lo_bean_tipo_movimiento.getDescripcion() + "?") == 0) {
            try {
                if (go_dao_tipo_movimiento.DLT_tipo_movimiento(ls_codigo)) {
                    lo_evt_opciones_2.activa_btn_opciones(0, lo_pnl_opciones_2, lb_valor_op);
                    lo_evt_datos_tipo_movimiento.activa_campos(0, lo_pnl_datos_tipo_movimiento, false);
                    lo_evt_datos_tipo_movimiento.limpia_datos(lo_pnl_datos_tipo_movimiento);
                }
            } catch (Exception e) {
            }
        }
    }

    private void evt_guardar() {
        lo_evt_opciones_2.activa_btn_opciones(5, lo_pnl_opciones_2, lb_valor_op);
        lo_cbx_almacen = (cbx_almacen) lo_pnl_datos_tipo_movimiento.CBX_almacen.getSelectedItem();
        lo_cbx_tabla_sunat = (cbx_tabla_sunat) lo_pnl_datos_tipo_movimiento.CBX_codigo_sunat.getSelectedItem();
        /*
        NUEVO = 0
        EDITAR = 1
         */
        switch (li_tipo_operacion) {
            case 0:
                if (lo_evt_datos_tipo_movimiento.valida_campos(lo_pnl_datos_tipo_movimiento)) {
                    try {
                        lo_evt_datos_tipo_movimiento.setea_campos(lo_bean_tipo_movimiento, lo_pnl_datos_tipo_movimiento, lo_cbx_almacen,lo_cbx_tabla_sunat);
                        if (go_dao_tipo_movimiento.IST_tipo_movimiento(lo_bean_tipo_movimiento)) {
                            lo_evt_datos_tipo_movimiento.limpia_datos(lo_pnl_datos_tipo_movimiento);
                            lo_evt_datos_tipo_movimiento.activa_campos(0, lo_pnl_datos_tipo_movimiento, false);
                            lo_evt_opciones_2.activa_btn_opciones(0, lo_pnl_opciones_2, lb_valor_op);
                        }
                    } catch (Exception e) {
                    }
                }
                break;
            case 1:
                if (lo_evt_datos_tipo_movimiento.verifica_cambios(lo_bean_tipo_movimiento, lo_pnl_datos_tipo_movimiento, lo_cbx_almacen,lo_cbx_tabla_sunat)) {
                    if (lo_evt_datos_tipo_movimiento.valida_campos(lo_pnl_datos_tipo_movimiento)) {
                        try {
                            lo_evt_datos_tipo_movimiento.setea_campos(lo_bean_tipo_movimiento, lo_pnl_datos_tipo_movimiento, lo_cbx_almacen,lo_cbx_tabla_sunat);
                            if (go_dao_tipo_movimiento.UPD_tipo_movimiento(lo_bean_tipo_movimiento)) {
                                lo_evt_datos_tipo_movimiento.limpia_datos(lo_pnl_datos_tipo_movimiento);
                                lo_evt_datos_tipo_movimiento.activa_campos(0, lo_pnl_datos_tipo_movimiento, false);
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
        lo_evt_datos_tipo_movimiento.activa_campos(0, lo_pnl_datos_tipo_movimiento, false);
        if (ls_codigo != null) {
            lo_evt_datos_tipo_movimiento.muestra_datos(lo_pnl_datos_tipo_movimiento, lo_bean_tipo_movimiento);
            lo_evt_opciones_2.activa_btn_opciones(2, lo_pnl_opciones_2, lb_valor_op);
        } else {
            lo_evt_datos_tipo_movimiento.limpia_datos(lo_pnl_datos_tipo_movimiento);
            lo_evt_opciones_2.activa_btn_opciones(0, lo_pnl_opciones_2, lb_valor_op);
        }
    }
    
    private void evt_reporte() {
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("empresa", go_bean_general.getNombre_reporte());
        parametros.put("usuario", gs_datos_usuario);
        go_evt_muestra_reporte.reporte_pestania("rpt_lista_tipo_movimiento.jasper", parametros, "Tipo Movimiento", 4);
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
                evt_reporte();
            }
        }
    };

    KeyListener KeyEvnt = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent ke) {

        }

        @Override
        public void keyPressed(KeyEvent ke) {

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
                    evt_reporte();
                }
                if (ke.getSource() == lo_pnl_datos_tipo_movimiento.TXT_codigo && go_fnc_operaciones_campos.campo_blanco(lo_pnl_datos_tipo_movimiento.TXT_codigo)) {
                    lo_pnl_datos_tipo_movimiento.TXT_codigo.setText(go_fnc_operaciones_campos.completa_digitos(go_fnc_operaciones_campos.get_campo_str(lo_pnl_datos_tipo_movimiento.TXT_codigo), "0", 2));
                    lo_pnl_datos_tipo_movimiento.TXT_nombre.requestFocus();
                }
                if (ke.getSource() == lo_pnl_datos_tipo_movimiento.TXT_nombre && go_fnc_operaciones_campos.cant_caracter(lo_pnl_datos_tipo_movimiento.TXT_nombre.getText().trim(), 1, 4)) {
                    lo_pnl_datos_tipo_movimiento.CBX_tipo_movimiento.requestFocus();
                }
                if (ke.getSource() == lo_pnl_datos_tipo_movimiento.CBX_tipo_movimiento) {
                    lo_pnl_datos_tipo_movimiento.CBX_es_transferencia.requestFocus();
                }
                if (ke.getSource() == lo_pnl_datos_tipo_movimiento.CBX_es_transferencia) {
                    lo_pnl_datos_tipo_movimiento.CBX_almacen.requestFocus();
                }
                if (ke.getSource() == lo_pnl_datos_tipo_movimiento.CBX_almacen) {
                    lo_pnl_datos_tipo_movimiento.CBX_tipo_almacen.requestFocus();
                }
                if (ke.getSource() == lo_pnl_datos_tipo_movimiento.CBX_tipo_almacen) {
                    lo_pnl_datos_tipo_movimiento.CBX_estado.requestFocus();
                }
                if (ke.getSource() == lo_pnl_datos_tipo_movimiento.CBX_estado) {
                    lo_pnl_datos_tipo_movimiento.CBX_codigo_sunat.requestFocus();
                }
                if (ke.getSource() == lo_pnl_datos_tipo_movimiento.CBX_codigo_sunat) {
                    lo_pnl_opciones_2.BTN_guardar.requestFocus();
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent ke) {

        }
    };

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setClosable(true);
        setIconifiable(true);
        setTitle("Tipo Movimiento");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 654, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 451, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
