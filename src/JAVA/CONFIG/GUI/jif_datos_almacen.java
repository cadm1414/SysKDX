package JAVA.CONFIG.GUI;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.ANCESTRO.GUI.pnl_opciones_2;
import JAVA.CONFIG.LOGICA.cbx_sucursal;
import JAVA.ANCESTRO.LOGICA.evt_opciones_2;
import JAVA.ANCESTRO.LOGICA.recupera_valor_op;
import JAVA.CONFIG.BEAN.BEAN_almacen;
import JAVA.CONFIG.LOGICA.evt_datos_almacen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

public class jif_datos_almacen extends javax.swing.JInternalFrame {

    pnl_opciones_2 lo_pnl_opciones_2 = new pnl_opciones_2();
    pnl_datos_almacen lo_pnl_datos_almacen = new pnl_datos_almacen();
    evt_opciones_2 lo_evt_opciones_2 = new evt_opciones_2();
    recupera_valor_op lo_recupera_valor_op = new recupera_valor_op();
    evt_datos_almacen lo_evt_datos_almacen = new evt_datos_almacen();
    BEAN_almacen lo_bean_almacen = new BEAN_almacen();
    cbx_sucursal lo_cbx_sucursal;
    static boolean lb_valor_op[] = new boolean[8];
    ResultSet lq_rs = null;
    int li_tipo_operacion;
    String ls_codigo, ls_codigo_ubigeo;
    String ls_opcion = "M C C";
    String ls_modulo = "CONFIG", ls_capa = "GUI", ls_clase = "jif_datos_almacen";

    public jif_datos_almacen() {
        initComponents();
        formulario();
        activa_botones();
        get_sucursal();
    }

    private void formulario() {
        lo_pnl_opciones_2.setBounds(0, 0, 655, 120);
        lo_pnl_datos_almacen.setBounds(12, 130, 500, 350);

        this.add(lo_pnl_opciones_2);
        this.add(lo_pnl_datos_almacen);

        lo_evt_opciones_2.evento_click(lo_pnl_opciones_2, Listener);
        lo_evt_opciones_2.evento_press(lo_pnl_opciones_2, KeyEvnt);
        lo_evt_datos_almacen.evento_press(lo_pnl_datos_almacen, KeyEvnt);
    }

    private void activa_botones() {
        lb_valor_op = lo_recupera_valor_op.recupera(ls_modulo, ls_opcion);
        lo_evt_opciones_2.activa_btn_opciones(0, lo_pnl_opciones_2, lb_valor_op);
    }

    private void get_sucursal() {
        lq_rs = go_dao_sucursal.SLT_cbx_sucursal("1");
        if (lq_rs != null) {
            go_cbx_trato_datos.recupera_valor(2, lq_rs, lo_pnl_datos_almacen.CBX_sucursal);
        }
    }

    private void evt_f5() {
        go_dlg_busq_ubigeo = new dlg_busq_ubigeo(null, true);
        go_dlg_busq_ubigeo.setVisible(true);
        ls_codigo_ubigeo = go_dlg_busq_ubigeo.ls_codigo_ubigeo;

        if (ls_codigo_ubigeo != null) {
            lo_pnl_datos_almacen.TXT_ubigeo.setText(ls_codigo_ubigeo);
            get_descripcion_ubigeo();
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_f5", "SELECCIONE UBIGEO");
            lo_pnl_datos_almacen.TXT_ubigeo.setText("");
            lo_pnl_datos_almacen.TXT_descripcion.setText("");
        }
    }

    private void get_descripcion_ubigeo() {
        ls_codigo_ubigeo = lo_pnl_datos_almacen.TXT_ubigeo.getText().trim();

        try {
            lq_rs = go_dao_ubigeo.SLT_descripcion_ubigeo_x_codigo(ls_codigo_ubigeo);
            if (lq_rs != null) {
                lo_pnl_datos_almacen.TXT_descripcion.setText(lq_rs.getString(1));
                getFocusOwner().transferFocus();
            } else {
                lo_pnl_datos_almacen.TXT_ubigeo.setText("");
                lo_pnl_datos_almacen.TXT_descripcion.setText("");
            }
        } catch (Exception e) {
        }
    }

    private void get_descripcion_almacen(String codigo) {
        try {
            lq_rs = go_dao_almacen.SLT_datos_almacen(codigo);
            if (lq_rs != null) {
                lo_evt_datos_almacen.setea_recupera(lo_bean_almacen, lq_rs);
                lo_evt_datos_almacen.muestra_datos(lo_pnl_datos_almacen, lo_bean_almacen);
            }
        } catch (Exception e) {
        }
    }

    private void evt_nuevo() {
        ls_codigo = null;
        lo_evt_datos_almacen.limpia_datos(lo_pnl_datos_almacen);

        try {
            lq_rs = go_dao_almacen.FNC_codigo_almacen();
            if (lq_rs.next()) {
                lo_pnl_datos_almacen.TXT_codigo_almacen.setText(lq_rs.getString(1));
            }
        } catch (Exception e) {
        }
        li_tipo_operacion = 0;
        lo_evt_opciones_2.activa_btn_opciones(1, lo_pnl_opciones_2, lb_valor_op);
        lo_evt_datos_almacen.activa_campos(0, lo_pnl_datos_almacen, true);
    }

    private void evt_buscar() {
        go_dlg_busq_almacen = new dlg_busq_almacen(null, true);
        go_dlg_busq_almacen.setVisible(true);
        ls_codigo = go_dlg_busq_almacen.ls_codigo_almacen;
        if (ls_codigo != null) {
            get_descripcion_almacen(ls_codigo);
            lo_evt_opciones_2.activa_btn_opciones(2, lo_pnl_opciones_2, lb_valor_op);
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_buscar", "SELECCIONE ALMACEN");
            lo_evt_datos_almacen.limpia_datos(lo_pnl_datos_almacen);
            lo_evt_opciones_2.activa_btn_opciones(0, lo_pnl_opciones_2, lb_valor_op);
        }
    }

    private void evt_editar() {
        li_tipo_operacion = 1;
        lo_evt_opciones_2.activa_btn_opciones(3, lo_pnl_opciones_2, lb_valor_op);
        lo_evt_datos_almacen.activa_campos(0, lo_pnl_datos_almacen, true);
    }

    private void evt_eliminar() {
        if (go_fnc_mensaje.get_respuesta(0, "¿DESEA ELIMINAR ALMACEN " + lo_bean_almacen.getNombre() + "?") == 0) {
            try {

                if (go_dao_almacen.DLT_almacen(ls_codigo)) {
                    lo_evt_opciones_2.activa_btn_opciones(0, lo_pnl_opciones_2, lb_valor_op);
                    lo_evt_datos_almacen.activa_campos(0, lo_pnl_datos_almacen, false);
                    lo_evt_datos_almacen.limpia_datos(lo_pnl_datos_almacen);
                }
            } catch (Exception e) {
            }
        }
    }

    private void evt_guardar() {
        lo_cbx_sucursal = (cbx_sucursal) lo_pnl_datos_almacen.CBX_sucursal.getSelectedItem();
        /*
        NUEVO = 0
        EDITAR = 1
         */
        switch (li_tipo_operacion) {
            case 0:
                if (lo_evt_datos_almacen.valida_campos(lo_pnl_datos_almacen)) {
                    try {
                        lo_evt_datos_almacen.setea_campos(lo_bean_almacen, lo_pnl_datos_almacen, lo_cbx_sucursal);
                        if (go_dao_almacen.IST_almacen(lo_bean_almacen)) {
                            lo_evt_datos_almacen.limpia_datos(lo_pnl_datos_almacen);
                            lo_evt_datos_almacen.activa_campos(0, lo_pnl_datos_almacen, false);
                            lo_evt_opciones_2.activa_btn_opciones(0, lo_pnl_opciones_2, lb_valor_op);
                        }
                    } catch (Exception e) {
                    }
                }
                break;
            case 1:
                if (lo_evt_datos_almacen.verifica_cambios(lo_bean_almacen, lo_pnl_datos_almacen, lo_cbx_sucursal)) {
                    if (lo_evt_datos_almacen.valida_campos(lo_pnl_datos_almacen)) {
                        try {
                            lo_evt_datos_almacen.setea_campos(lo_bean_almacen, lo_pnl_datos_almacen, lo_cbx_sucursal);
                            if (go_dao_almacen.UPD_almacen(lo_bean_almacen)) {
                                lo_evt_datos_almacen.limpia_datos(lo_pnl_datos_almacen);
                                lo_evt_datos_almacen.activa_campos(0, lo_pnl_datos_almacen, false);
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
        lo_evt_datos_almacen.activa_campos(0, lo_pnl_datos_almacen, false);
        if (ls_codigo != null) {
            lo_evt_datos_almacen.muestra_datos(lo_pnl_datos_almacen, lo_bean_almacen);
            lo_evt_opciones_2.activa_btn_opciones(2, lo_pnl_opciones_2, lb_valor_op);
        } else {
            lo_evt_datos_almacen.limpia_datos(lo_pnl_datos_almacen);
            lo_evt_opciones_2.activa_btn_opciones(0, lo_pnl_opciones_2, lb_valor_op);
        }
    }

    private void evt_reporte() {
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("empresa", go_bean_general.getNombre_reporte());
        parametros.put("usuario", gs_datos_usuario);
        go_evt_muestra_reporte.reporte_pestania("rpt_lista_almacen.jasper", parametros, "Almacen", 2);
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
                if (ke.getSource() == lo_pnl_datos_almacen.TXT_ubigeo) {
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
                if (ke.getSource() == lo_pnl_datos_almacen.TXT_codigo_almacen && go_fnc_operaciones_campos.cant_caracter(lo_pnl_datos_almacen.TXT_codigo_almacen.getText().trim(), 1, 4)) {
                    lo_pnl_datos_almacen.TXT_nombre_almacen.requestFocus();
                }
                if (ke.getSource() == lo_pnl_datos_almacen.TXT_nombre_almacen && go_fnc_operaciones_campos.cant_caracter(lo_pnl_datos_almacen.TXT_nombre_almacen.getText().trim(), 1, 4)) {
                    lo_pnl_datos_almacen.TXT_direccion_almacen.requestFocus();
                }
                if (ke.getSource() == lo_pnl_datos_almacen.TXT_direccion_almacen) {
                    lo_pnl_datos_almacen.CBX_estado.requestFocus();
                }
                if (ke.getSource() == lo_pnl_datos_almacen.CBX_estado) {
                    lo_pnl_datos_almacen.CBX_tipo_almacen.requestFocus();
                }
                if (ke.getSource() == lo_pnl_datos_almacen.CBX_tipo_almacen) {
                    lo_pnl_datos_almacen.CBX_sucursal.requestFocus();
                }
                if (ke.getSource() == lo_pnl_datos_almacen.CBX_sucursal) {
                    lo_pnl_datos_almacen.TXT_ubigeo.requestFocus();
                }
                if (ke.getSource() == lo_pnl_datos_almacen.TXT_ubigeo && go_fnc_operaciones_campos.campo_blanco(lo_pnl_datos_almacen.TXT_ubigeo)) {
                    get_descripcion_ubigeo();
                }
                if (ke.getSource() == lo_pnl_datos_almacen.TXT_nota) {
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
        setTitle("Registro Almacen");
        setToolTipText("");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/JAVA/CONFIG/IMAGES/almacen.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 645, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 403, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
