package JAVA.INVENT.GUI;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.ANCESTRO.GUI.pnl_opciones_2;
import JAVA.ANCESTRO.LOGICA.evt_opciones_2;
import JAVA.ANCESTRO.LOGICA.recupera_valor_op;
import JAVA.INVENT.BEAN.BEAN_producto;
import JAVA.INVENT.LOGICA.evt_datos_producto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

public class jif_datos_producto extends javax.swing.JInternalFrame {

    pnl_opciones_2 lo_pnl_opciones_2 = new pnl_opciones_2();
    evt_opciones_2 lo_evt_opciones_2 = new evt_opciones_2();
    evt_datos_producto lo_evt_datos_producto = new evt_datos_producto();
    pnl_datos_producto lo_pnl_datos_producto = new pnl_datos_producto();
    recupera_valor_op lo_recupera_valor_op = new recupera_valor_op();
    BEAN_producto lo_bean_producto = new BEAN_producto();
    static boolean lb_valor_op[] = new boolean[8];
    ResultSet lq_rs = null;
    int li_tipo_operacion;
    String ls_codigo;
    String ls_opcion = "M C A";
    String ls_modulo = "INVENT", ls_capa = "GUI", ls_clase = "jif_datos_producto";

    public jif_datos_producto() {
        initComponents();
        formulario();
        activa_botones();
    }

    private void formulario() {
        lo_pnl_opciones_2.setBounds(0, 0, 655, 120);
        lo_pnl_datos_producto.setBounds(12, 130, 500, 350);

        this.add(lo_pnl_opciones_2);
        this.add(lo_pnl_datos_producto);

        lo_evt_opciones_2.evento_click(lo_pnl_opciones_2, Listener);
        lo_evt_opciones_2.evento_press(lo_pnl_opciones_2, KeyEvnt);
        
        lo_evt_datos_producto.evento_press(lo_pnl_datos_producto, KeyEvnt);
    }

    private void activa_botones() {
        lb_valor_op = lo_recupera_valor_op.recupera(ls_modulo, ls_opcion);
        lo_evt_opciones_2.activa_btn_opciones(0, lo_pnl_opciones_2, lb_valor_op);
    }

    private void get_descripcion_prducto(String codigo) {
        try {
            lq_rs = go_dao_producto.SLT_datos_producto(codigo);
            if (lq_rs != null) {
                lo_evt_datos_producto.setea_recupera(lo_bean_producto, lq_rs);
                lo_evt_datos_producto.muestra_datos(lo_pnl_datos_producto, lo_bean_producto);
            }
        } catch (Exception e) {
        }
    }

    private void evt_nuevo() {
        ls_codigo = null;
        lo_evt_datos_producto.limpia_datos(lo_pnl_datos_producto);

        try {
            lq_rs = go_dao_producto.FNC_codigo_producto();
            if (lq_rs.next()) {
                lo_pnl_datos_producto.TXT_codigo.setText(lq_rs.getString(1));
            }
        } catch (Exception e) {
        }
        li_tipo_operacion = 0;
        lo_evt_opciones_2.activa_btn_opciones(1, lo_pnl_opciones_2, lb_valor_op);
        lo_evt_datos_producto.activa_campos(0, lo_pnl_datos_producto, true);
    }

    private void evt_buscar() {
        go_dlg_busq_producto = new dlg_busq_producto(null, true);
        go_dlg_busq_producto.setVisible(true);
        ls_codigo = go_dlg_busq_producto.ls_codigo_producto;
        if (ls_codigo != null) {
            get_descripcion_prducto(ls_codigo);
            lo_evt_opciones_2.activa_btn_opciones(2, lo_pnl_opciones_2, lb_valor_op);
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_buscar", "SELECCIONE PRODUCTO");
            lo_evt_datos_producto.limpia_datos(lo_pnl_datos_producto);
            lo_evt_opciones_2.activa_btn_opciones(0, lo_pnl_opciones_2, lb_valor_op);
        }
    }

    private void evt_editar() {
        li_tipo_operacion = 1;
        lo_evt_opciones_2.activa_btn_opciones(3, lo_pnl_opciones_2, lb_valor_op);
        lo_evt_datos_producto.activa_campos(0, lo_pnl_datos_producto, true);
    }

    private void evt_eliminar() {
        if (go_fnc_mensaje.get_respuesta(0, "¿DESEA ELIMINAR PRODUCTO " + lo_bean_producto.getNombre_producto() + "?") == 0) {
            try {
                if (go_dao_producto.DLT_producto(ls_codigo)) {
                    lo_evt_opciones_2.activa_btn_opciones(0, lo_pnl_opciones_2, lb_valor_op);
                    lo_evt_datos_producto.activa_campos(0, lo_pnl_datos_producto, false);
                    lo_evt_datos_producto.limpia_datos(lo_pnl_datos_producto);
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
                if (lo_evt_datos_producto.valida_campos(lo_pnl_datos_producto)) {
                    try {
                        lo_evt_datos_producto.setea_campos(lo_bean_producto, lo_pnl_datos_producto);
                        if (go_dao_producto.IST_producto(lo_bean_producto)) {
                            lo_evt_datos_producto.limpia_datos(lo_pnl_datos_producto);
                            lo_evt_datos_producto.activa_campos(0, lo_pnl_datos_producto, false);
                            lo_evt_opciones_2.activa_btn_opciones(0, lo_pnl_opciones_2, lb_valor_op);
                        }
                    } catch (Exception e) {
                    }
                }
                break;
            case 1:
                if (lo_evt_datos_producto.verifica_cambios(lo_bean_producto, lo_pnl_datos_producto)) {
                    if (lo_evt_datos_producto.valida_campos(lo_pnl_datos_producto)) {
                        try {
                            lo_evt_datos_producto.setea_campos(lo_bean_producto, lo_pnl_datos_producto);
                            if (go_dao_producto.UPD_producto(lo_bean_producto)) {
                                lo_evt_datos_producto.limpia_datos(lo_pnl_datos_producto);
                                lo_evt_datos_producto.activa_campos(0, lo_pnl_datos_producto, false);
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
        lo_evt_datos_producto.activa_campos(0, lo_pnl_datos_producto, false);
        if (ls_codigo != null) {
            lo_evt_datos_producto.muestra_datos(lo_pnl_datos_producto, lo_bean_producto);
            lo_evt_opciones_2.activa_btn_opciones(2, lo_pnl_opciones_2, lb_valor_op);
        } else {
            lo_evt_datos_producto.limpia_datos(lo_pnl_datos_producto);
            lo_evt_opciones_2.activa_btn_opciones(0, lo_pnl_opciones_2, lb_valor_op);
        }
    }
    
    public void evt_reporte() {
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("empresa", go_bean_general.getNombre_reporte());
        parametros.put("usuario", gs_datos_usuario);
        go_muestra_reporte_invent.reporte_pestania("rpt_lista_producto.jasper", parametros, "Producto", 1);
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
                if (ke.getSource() == lo_pnl_datos_producto.TXT_nombre && go_fnc_operaciones_campos.cant_caracter(lo_pnl_datos_producto.TXT_nombre.getText().trim(), 1, 3)) {
                    lo_pnl_datos_producto.CBX_clase.requestFocus();
                }
                if (ke.getSource() == lo_pnl_datos_producto.CBX_clase) {
                    lo_pnl_datos_producto.TXT_dias.requestFocus();
                }
                if (ke.getSource() == lo_pnl_datos_producto.TXT_dias) {
                    if(!go_fnc_operaciones_campos.campo_blanco(lo_pnl_datos_producto.TXT_dias)){
                        lo_pnl_datos_producto.TXT_dias.setText("0");
                    }
                    lo_pnl_datos_producto.CBX_detraccion.requestFocus();
                }
                if (ke.getSource() == lo_pnl_datos_producto.CBX_detraccion) {
                    lo_pnl_datos_producto.CBX_percepcion.requestFocus();
                }
                if (ke.getSource() == lo_pnl_datos_producto.CBX_percepcion) {
                    lo_pnl_datos_producto.CBX_estado.requestFocus();
                }
                if (ke.getSource() == lo_pnl_datos_producto.CBX_estado) {
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
        setTitle("PRODUCTO");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/JAVA/INVENT/IMAGES/producto.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 644, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 435, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
