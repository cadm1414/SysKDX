package JAVA.CONFIG.GUI;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.ANCESTRO.GUI.pnl_opciones_2;
import JAVA.ANCESTRO.LOGICA.evt_opciones_2;
import JAVA.ANCESTRO.LOGICA.recupera_valor_op;
import JAVA.CONFIG.BEAN.BEAN_unidad_medida;
import JAVA.CONFIG.LOGICA.cbx_tabla_sunat;
import JAVA.CONFIG.LOGICA.evt_datos_unidad_medida;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

public class jif_datos_unidad_medida extends javax.swing.JInternalFrame {

    pnl_opciones_2 lo_pnl_opciones_2 = new pnl_opciones_2();
    evt_opciones_2 lo_evt_opciones_2 = new evt_opciones_2();
    pnl_datos_unidad_medida lo_pnl_datos_unidad_medida = new pnl_datos_unidad_medida();
    evt_datos_unidad_medida lo_evt_datos_unidad_medida = new evt_datos_unidad_medida();
    recupera_valor_op lo_recupera_valor_op = new recupera_valor_op();
    BEAN_unidad_medida lo_bean_unidad_medida = new BEAN_unidad_medida();
    static boolean lb_valor_op[] = new boolean[8];
    cbx_tabla_sunat lo_cbx_tabla_sunat;
    ResultSet lq_rs = null;
    int li_tipo_operacion;
    String ls_codigo;
    String ls_opcion = "M C E";
    String ls_modulo = "CONFIG", ls_capa = "GUI", ls_clase = "jif_datos_unidad_medida";

    public jif_datos_unidad_medida() {
        initComponents();
        formulario();
        activa_botones();
        get_tabla_sunat();
    }

    private void formulario() {
        lo_pnl_opciones_2.setBounds(0, 0, 655, 120);
        lo_pnl_datos_unidad_medida.setBounds(12, 130, 500, 350);

        this.add(lo_pnl_opciones_2);
        this.add(lo_pnl_datos_unidad_medida);

        lo_evt_opciones_2.evento_click(lo_pnl_opciones_2, Listener);
        lo_evt_opciones_2.evento_press(lo_pnl_opciones_2, KeyEvnt);
        
        lo_evt_datos_unidad_medida.evento_press(lo_pnl_datos_unidad_medida, KeyEvnt);
    }

    private void activa_botones() {
        lb_valor_op = lo_recupera_valor_op.recupera(ls_modulo, ls_opcion);
        lo_evt_opciones_2.activa_btn_opciones(0, lo_pnl_opciones_2, lb_valor_op);
    }

    private void get_tabla_sunat() {

        lq_rs = go_dao_tabla_sunat.SLT_cbx_tabla_sunat("006");
        if (lq_rs != null) {
            go_cbx_trato_datos.recupera_valor(4, lq_rs, lo_pnl_datos_unidad_medida.CBX_codigo_sunat);
        }
    }

    private void get_descripcion_unidad_medida(String codigo) {
        try {
            lq_rs = go_dao_unidad_medida.SLT_datos_unidad_medida(codigo);
            if (lq_rs != null) {
                lo_evt_datos_unidad_medida.setea_recupera(lo_bean_unidad_medida, lq_rs);
                lo_evt_datos_unidad_medida.muestra_datos(lo_pnl_datos_unidad_medida, lo_bean_unidad_medida);
            }
        } catch (Exception e) {
        }
    }

    private void evt_nuevo() {
        ls_codigo = null;
        lo_evt_datos_unidad_medida.limpia_datos(lo_pnl_datos_unidad_medida);

        try {
            lq_rs = go_dao_unidad_medida.FNC_codigo_unidad_medida();
            if (lq_rs.next()) {
                lo_pnl_datos_unidad_medida.TXT_codigo.setText(lq_rs.getString(1));
            }
        } catch (Exception e) {
        }
        li_tipo_operacion = 0;
        lo_evt_opciones_2.activa_btn_opciones(1, lo_pnl_opciones_2, lb_valor_op);
        lo_evt_datos_unidad_medida.activa_campos(0, lo_pnl_datos_unidad_medida, true);
    }

    private void evt_buscar() {
        go_dlg_busq_unidad_medida = new dlg_busq_unidad_medida(null, true);
        go_dlg_busq_unidad_medida.setVisible(true);
        ls_codigo = go_dlg_busq_unidad_medida.ls_codigo_unidad;
        if (ls_codigo != null) {
            get_descripcion_unidad_medida(ls_codigo);
            lo_evt_opciones_2.activa_btn_opciones(2, lo_pnl_opciones_2, lb_valor_op);
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_buscar", "SELECCIONE UNIDA MEDIDA");
            lo_evt_datos_unidad_medida.limpia_datos(lo_pnl_datos_unidad_medida);
            lo_evt_opciones_2.activa_btn_opciones(0, lo_pnl_opciones_2, lb_valor_op);
        }
    }

    private void evt_editar() {
        li_tipo_operacion = 1;
        lo_evt_opciones_2.activa_btn_opciones(3, lo_pnl_opciones_2, lb_valor_op);
        lo_evt_datos_unidad_medida.activa_campos(0, lo_pnl_datos_unidad_medida, true);
    }

    private void evt_eliminar() {
        if (go_fnc_mensaje.get_respuesta(0, "¿DESEA ELIMINAR UNIDAD DE MEDIDA " + lo_bean_unidad_medida.getNombre_unidad() + "?") == 0) {
            try {
                if (go_dao_unidad_medida.DLT_unidad_medida(ls_codigo)) {
                    lo_evt_opciones_2.activa_btn_opciones(0, lo_pnl_opciones_2, lb_valor_op);
                    lo_evt_datos_unidad_medida.activa_campos(0, lo_pnl_datos_unidad_medida, false);
                    lo_evt_datos_unidad_medida.limpia_datos(lo_pnl_datos_unidad_medida);
                }
            } catch (Exception e) {
            }
        }
    }

    private void evt_guardar() {
        lo_cbx_tabla_sunat = (cbx_tabla_sunat) lo_pnl_datos_unidad_medida.CBX_codigo_sunat.getSelectedItem();
        /*
        NUEVO = 0
        EDITAR = 1
         */
        switch (li_tipo_operacion) {
            case 0:
                if (lo_evt_datos_unidad_medida.valida_campos(lo_pnl_datos_unidad_medida)) {
                    try {
                        lo_evt_datos_unidad_medida.setea_campos(lo_bean_unidad_medida, lo_pnl_datos_unidad_medida, lo_cbx_tabla_sunat);
                        if (go_dao_unidad_medida.IST_unidad_medida(lo_bean_unidad_medida)) {
                            lo_evt_datos_unidad_medida.limpia_datos(lo_pnl_datos_unidad_medida);
                            lo_evt_datos_unidad_medida.activa_campos(0, lo_pnl_datos_unidad_medida, false);
                            lo_evt_opciones_2.activa_btn_opciones(0, lo_pnl_opciones_2, lb_valor_op);
                        }
                    } catch (Exception e) {
                    }
                }
                break;
            case 1:
                if (lo_evt_datos_unidad_medida.verifica_cambios(lo_bean_unidad_medida, lo_pnl_datos_unidad_medida,lo_cbx_tabla_sunat)) {
                    if (lo_evt_datos_unidad_medida.valida_campos(lo_pnl_datos_unidad_medida)) {
                        try {
                            lo_evt_datos_unidad_medida.setea_campos(lo_bean_unidad_medida, lo_pnl_datos_unidad_medida,lo_cbx_tabla_sunat);
                            if (go_dao_unidad_medida.UPD_unidad_medida(lo_bean_unidad_medida)) {
                                lo_evt_datos_unidad_medida.limpia_datos(lo_pnl_datos_unidad_medida);
                                lo_evt_datos_unidad_medida.activa_campos(0, lo_pnl_datos_unidad_medida, false);
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
        lo_evt_datos_unidad_medida.activa_campos(0, lo_pnl_datos_unidad_medida, false);
        if (ls_codigo != null) {
            lo_evt_datos_unidad_medida.muestra_datos(lo_pnl_datos_unidad_medida, lo_bean_unidad_medida);
            lo_evt_opciones_2.activa_btn_opciones(2, lo_pnl_opciones_2, lb_valor_op);
        } else {
            lo_evt_datos_unidad_medida.limpia_datos(lo_pnl_datos_unidad_medida);
            lo_evt_opciones_2.activa_btn_opciones(0, lo_pnl_opciones_2, lb_valor_op);
        }
    }
    
    public void evt_reporte() {
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("empresa", go_bean_general.getNombre_reporte());
        parametros.put("usuario", gs_datos_usuario);
        go_evt_muestra_reporte.reporte_pestania("rpt_lista_unidad_medida.jasper", parametros, "Unidad Medida", 5);
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
                if (ke.getSource() == lo_pnl_datos_unidad_medida.TXT_nombre && go_fnc_operaciones_campos.cant_caracter(lo_pnl_datos_unidad_medida.TXT_nombre.getText().trim(), 1, 3)) {
                    lo_pnl_datos_unidad_medida.TXT_simbolo.requestFocus();
                }
                if (ke.getSource() == lo_pnl_datos_unidad_medida.TXT_simbolo && go_fnc_operaciones_campos.cant_caracter(lo_pnl_datos_unidad_medida.TXT_simbolo.getText().trim(), 1, 1)) {
                    lo_pnl_datos_unidad_medida.CBX_codigo_sunat.requestFocus();
                }
                if (ke.getSource() == lo_pnl_datos_unidad_medida.CBX_codigo_sunat) {
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
        setTitle("UNIDAD DE MEDIDA");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/JAVA/CONFIG/IMAGES/medida.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 633, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 292, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
