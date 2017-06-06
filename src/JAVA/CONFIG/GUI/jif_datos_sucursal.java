package JAVA.CONFIG.GUI;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.ANCESTRO.GUI.pnl_opciones_2;
import JAVA.ANCESTRO.LOGICA.evt_opciones_2;
import JAVA.ANCESTRO.LOGICA.recupera_valor_op;
import JAVA.CONFIG.BEAN.BEAN_sucursal;
import JAVA.CONFIG.LOGICA.evt_datos_sucursal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

public class jif_datos_sucursal extends javax.swing.JInternalFrame {

    pnl_opciones_2 lo_pnl_opciones_2 = new pnl_opciones_2();
    pnl_datos_sucursal lo_pnl_datos_sucursal = new pnl_datos_sucursal();
    evt_datos_sucursal lo_evt_datos_sucursal = new evt_datos_sucursal();
    recupera_valor_op lo_recupera_valor_op = new recupera_valor_op();
    evt_opciones_2 lo_evt_opciones_2 = new evt_opciones_2();
    BEAN_sucursal lo_bean_sucursal = new BEAN_sucursal();
    static boolean lb_valor_op[] = new boolean[8];
    String ls_codigo;
    String ls_codigo_ubigeo;
    int li_tipo_operacion;
    String ls_opcion = "M C B";
    String ls_modulo = "CONFIG", ls_capa = "GUI", ls_clase = "jif_datos_sucursal";
    ResultSet lq_rs = null;

    public jif_datos_sucursal() {
        initComponents();
        formulario();
        activa_botones();
    }

    private void formulario() {
        lo_pnl_opciones_2.setBounds(0, 0, 655, 120);
        lo_pnl_datos_sucursal.setBounds(12, 130, 500, 250);

        this.add(lo_pnl_opciones_2);
        this.add(lo_pnl_datos_sucursal);

        lo_evt_opciones_2.evento_click(lo_pnl_opciones_2, Listener);
        lo_evt_opciones_2.evento_press(lo_pnl_opciones_2, KeyEvnt);

        lo_evt_datos_sucursal.evento_press(lo_pnl_datos_sucursal, KeyEvnt);
    }

    private void activa_botones() {
        lb_valor_op = lo_recupera_valor_op.recupera(ls_modulo, ls_opcion);
        lo_evt_opciones_2.activa_btn_opciones(0, lo_pnl_opciones_2, lb_valor_op);
    }

    private void get_descripcion_sucursal(String codigo) {
        try {
            lq_rs = go_dao_sucursal.SLT_datos_sucursal(codigo);
            if (lq_rs != null) {
                lo_evt_datos_sucursal.setea_recupera(lo_bean_sucursal, lq_rs);
                lo_evt_datos_sucursal.muestra_datos(lo_pnl_datos_sucursal, lo_bean_sucursal);
            }
        } catch (Exception e) {
        }
    }

    private void evt_f5() {
        go_dlg_busq_ubigeo = new dlg_busq_ubigeo(null, true);
        go_dlg_busq_ubigeo.setVisible(true);
        ls_codigo_ubigeo = go_dlg_busq_ubigeo.ls_codigo_ubigeo;

        if (ls_codigo_ubigeo != null) {
            lo_pnl_datos_sucursal.TXT_ubigeo.setText(ls_codigo_ubigeo);
            get_descripcion_ubigeo();
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_f5", "SELECCIONE UBIGEO");
            lo_pnl_datos_sucursal.TXT_ubigeo.setText("");
            lo_pnl_datos_sucursal.TXT_descripcion.setText("");
        }
    }

    private void get_descripcion_ubigeo() {
        ls_codigo_ubigeo = lo_pnl_datos_sucursal.TXT_ubigeo.getText().trim();

        try {
            lq_rs = go_dao_ubigeo.SLT_descripcion_ubigeo_x_codigo(ls_codigo_ubigeo);
            if (lq_rs != null) {
                lo_pnl_datos_sucursal.TXT_descripcion.setText(lq_rs.getString(1));
                getFocusOwner().transferFocus();
            } else {
                lo_pnl_datos_sucursal.TXT_ubigeo.setText("");
                lo_pnl_datos_sucursal.TXT_descripcion.setText("");
            }
        } catch (Exception e) {
        }
    }

    private void evt_nuevo() {
        ls_codigo = null;
        lo_evt_datos_sucursal.limpia_datos(lo_pnl_datos_sucursal);

        try {
            lq_rs = go_dao_sucursal.FNC_codigo_sucursal();
            if (lq_rs.next()) {
                lo_pnl_datos_sucursal.TXT_codigo.setText(lq_rs.getString(1));
            }
        } catch (Exception e) {
        }
        li_tipo_operacion = 0;
        lo_evt_opciones_2.activa_btn_opciones(1, lo_pnl_opciones_2, lb_valor_op);
        lo_evt_datos_sucursal.activa_campos(0, lo_pnl_datos_sucursal, true);
    }

    public void evt_buscar() {
        go_dlg_busq_sucursal = new dlg_busq_sucursal(null, true);
        go_dlg_busq_sucursal.setVisible(true);
        ls_codigo = go_dlg_busq_sucursal.ls_codigo_sucursal;
        if (ls_codigo != null) {
            get_descripcion_sucursal(ls_codigo);
            lo_evt_opciones_2.activa_btn_opciones(2, lo_pnl_opciones_2, lb_valor_op);
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_buscar", "SELECCIONE SUCURSAL");
            lo_evt_datos_sucursal.limpia_datos(lo_pnl_datos_sucursal);
            lo_evt_opciones_2.activa_btn_opciones(0, lo_pnl_opciones_2, lb_valor_op);
        }
    }

    private void evt_editar() {
        li_tipo_operacion = 1;
        lo_evt_opciones_2.activa_btn_opciones(3, lo_pnl_opciones_2, lb_valor_op);
        lo_evt_datos_sucursal.activa_campos(0, lo_pnl_datos_sucursal, true);
    }

    private void evt_eliminar() {
        if (go_fnc_mensaje.get_respuesta(0, "¿DESEA ELIMINAR SUCURSAL " + lo_bean_sucursal.getNombre() + "?") == 0) {
            try {

                if (go_dao_sucursal.DLT_sucursal(ls_codigo)) {
                    lo_evt_opciones_2.activa_btn_opciones(0, lo_pnl_opciones_2, lb_valor_op);
                    lo_evt_datos_sucursal.activa_campos(0, lo_pnl_datos_sucursal, false);
                    lo_evt_datos_sucursal.limpia_datos(lo_pnl_datos_sucursal);
                }
            } catch (Exception e) {
            }
        }
    }

    private void evt_guardar() {
        lo_evt_opciones_2.activa_btn_opciones(5, lo_pnl_opciones_2, lb_valor_op);
        /*
        NUEVO = 0
        EDITAR = 1
         */
        switch (li_tipo_operacion) {
            case 0:
                if (lo_evt_datos_sucursal.valida_campos(lo_pnl_datos_sucursal)) {
                    try {
                        lo_evt_datos_sucursal.setea_campos(lo_bean_sucursal, lo_pnl_datos_sucursal);
                        if (go_dao_sucursal.IST_sucursal(lo_bean_sucursal)) {
                            lo_evt_datos_sucursal.limpia_datos(lo_pnl_datos_sucursal);
                            lo_evt_datos_sucursal.activa_campos(0, lo_pnl_datos_sucursal, false);
                            lo_evt_opciones_2.activa_btn_opciones(0, lo_pnl_opciones_2, lb_valor_op);
                        }
                    } catch (Exception e) {
                    }
                }
                break;
            case 1:
                if (lo_evt_datos_sucursal.verifica_cambios(lo_bean_sucursal, lo_pnl_datos_sucursal)) {
                    if (lo_evt_datos_sucursal.valida_campos(lo_pnl_datos_sucursal)) {
                        try {
                            lo_evt_datos_sucursal.setea_campos(lo_bean_sucursal, lo_pnl_datos_sucursal);
                            if (go_dao_sucursal.UPD_sucursal(lo_bean_sucursal)) {
                                lo_evt_datos_sucursal.limpia_datos(lo_pnl_datos_sucursal);
                                lo_evt_datos_sucursal.activa_campos(0, lo_pnl_datos_sucursal, false);
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
        lo_evt_datos_sucursal.activa_campos(0, lo_pnl_datos_sucursal, false);
        if (ls_codigo != null) {
            lo_evt_datos_sucursal.muestra_datos(lo_pnl_datos_sucursal, lo_bean_sucursal);
            lo_evt_opciones_2.activa_btn_opciones(2, lo_pnl_opciones_2, lb_valor_op);
        } else {
            lo_evt_datos_sucursal.limpia_datos(lo_pnl_datos_sucursal);
            lo_evt_opciones_2.activa_btn_opciones(0, lo_pnl_opciones_2, lb_valor_op);
        }
    }
    
    public void evt_reporte(){
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("empresa", go_bean_general.getNombre_reporte());
        parametros.put("usuario", gs_datos_usuario);
        go_evt_muestra_reporte.reporte_pestania("rpt_lista_sucursal.jasper", parametros,"Sucursal",1);       
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
            if (ke.getKeyCode() == KeyEvent.VK_F5) {
                if (ke.getSource() == lo_pnl_datos_sucursal.TXT_ubigeo) {
                    evt_f5();
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
                    evt_reporte();
                }
                if (ke.getSource() == lo_pnl_datos_sucursal.TXT_codigo && go_fnc_operaciones_campos.cant_caracter(lo_pnl_datos_sucursal.TXT_codigo.getText().trim(), 1, 4)) {
                    lo_pnl_datos_sucursal.TXT_nombre.requestFocus();
                }
                if (ke.getSource() == lo_pnl_datos_sucursal.TXT_nombre && go_fnc_operaciones_campos.cant_caracter(lo_pnl_datos_sucursal.TXT_nombre.getText().trim(), 1, 4)) {
                    lo_pnl_datos_sucursal.TXT_direccion.requestFocus();
                }
                if (ke.getSource() == lo_pnl_datos_sucursal.TXT_direccion) {
                    lo_pnl_datos_sucursal.CBX_estado.requestFocus();
                }
                if (ke.getSource() == lo_pnl_datos_sucursal.CBX_estado) {
                    lo_pnl_datos_sucursal.TXT_ubigeo.requestFocus();
                }
                if (ke.getSource() == lo_pnl_datos_sucursal.TXT_ubigeo && go_fnc_operaciones_campos.campo_blanco(lo_pnl_datos_sucursal.TXT_ubigeo)) {
                    get_descripcion_ubigeo();
                }
                if (ke.getSource() == lo_pnl_datos_sucursal.TXT_nota) {
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
        setTitle("Registro Sucursal");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 652, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 364, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
