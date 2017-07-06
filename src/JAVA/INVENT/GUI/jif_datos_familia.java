package JAVA.INVENT.GUI;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.ANCESTRO.GUI.pnl_opciones_2;
import JAVA.ANCESTRO.LOGICA.evt_opciones_2;
import JAVA.ANCESTRO.LOGICA.recupera_valor_op;
import JAVA.INVENT.BEAN.BEAN_familia;
import JAVA.INVENT.LOGICA.evt_datos_familia;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

public class jif_datos_familia extends javax.swing.JInternalFrame {

    pnl_opciones_2 lo_pnl_opciones_2 = new pnl_opciones_2();
    pnl_datos_familia lo_pnl_datos_familia = new pnl_datos_familia();
    evt_opciones_2 lo_evt_opciones_2 = new evt_opciones_2();
    evt_datos_familia lo_evt_datos_familia = new evt_datos_familia();
    recupera_valor_op lo_recupera_valor_op = new recupera_valor_op();
    BEAN_familia lo_bean_familia = new BEAN_familia();
    static boolean lb_valor_op[] = new boolean[8];
    ResultSet lq_rs = null;
    int li_tipo_operacion;
    String ls_codigo;
    String ls_opcion = "M C C";
    String ls_modulo = "INVENT", ls_capa = "GUI", ls_clase = "jif_datos_familia";

    public jif_datos_familia() {
        initComponents();
        formulario();
        activa_botones();
    }

    private void formulario() {
        lo_pnl_opciones_2.setBounds(0, 0, 655, 120);
        lo_pnl_datos_familia.setBounds(12, 130, 500, 350);

        this.add(lo_pnl_opciones_2);
        this.add(lo_pnl_datos_familia);

        lo_evt_opciones_2.evento_click(lo_pnl_opciones_2, Listener);
        lo_evt_opciones_2.evento_press(lo_pnl_opciones_2, KeyEvnt);
        
        lo_evt_datos_familia.evento_press(lo_pnl_datos_familia, KeyEvnt);
    }

    private void activa_botones() {
        lb_valor_op = lo_recupera_valor_op.recupera(ls_modulo, ls_opcion);
        lo_evt_opciones_2.activa_btn_opciones(0, lo_pnl_opciones_2, lb_valor_op);
    }

    private void get_descripcion_familia(String codigo) {
        try {
            lq_rs = go_dao_familia.SLT_datos_familia(codigo);
            if (lq_rs != null) {
                lo_evt_datos_familia.setea_recupera(lo_bean_familia, lq_rs);
                lo_evt_datos_familia.muestra_datos(lo_pnl_datos_familia, lo_bean_familia);
            }
        } catch (Exception e) {
        }
    }

    private void evt_nuevo() {
        ls_codigo = null;
        lo_evt_datos_familia.limpia_datos(lo_pnl_datos_familia);

        try {
            lq_rs = go_dao_familia.FNC_codigo_familia();
            if (lq_rs.next()) {
                lo_pnl_datos_familia.TXT_codigo.setText(lq_rs.getString(1));
            }
        } catch (Exception e) {
        }
        li_tipo_operacion = 0;
        lo_evt_opciones_2.activa_btn_opciones(1, lo_pnl_opciones_2, lb_valor_op);
        lo_evt_datos_familia.activa_campos(0, lo_pnl_datos_familia, true);
    }

    private void evt_buscar() {
        go_dlg_busq_familia = new dlg_busq_familia(null, true);
        go_dlg_busq_familia.setVisible(true);
        ls_codigo = go_dlg_busq_familia.ls_codigo_familia;
        if (ls_codigo != null) {
            get_descripcion_familia(ls_codigo);
            lo_evt_opciones_2.activa_btn_opciones(2, lo_pnl_opciones_2, lb_valor_op);
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_buscar", "SELECCIONE FAMILIA");
            lo_evt_datos_familia.limpia_datos(lo_pnl_datos_familia);
            lo_evt_opciones_2.activa_btn_opciones(0, lo_pnl_opciones_2, lb_valor_op);
        }
    }

    private void evt_editar() {
        li_tipo_operacion = 1;
        lo_evt_opciones_2.activa_btn_opciones(3, lo_pnl_opciones_2, lb_valor_op);
        lo_evt_datos_familia.activa_campos(0, lo_pnl_datos_familia, true);
    }

    private void evt_eliminar() {
        if (go_fnc_mensaje.get_respuesta(0, "¿DESEA ELIMINAR FAMILIA " + lo_bean_familia.getNombre_familia() + "?") == 0) {
            try {
                if (go_dao_familia.DLT_familia(ls_codigo)) {
                    lo_evt_opciones_2.activa_btn_opciones(0, lo_pnl_opciones_2, lb_valor_op);
                    lo_evt_datos_familia.activa_campos(0, lo_pnl_datos_familia, false);
                    lo_evt_datos_familia.limpia_datos(lo_pnl_datos_familia);
                }
            } catch (Exception e) {
            }
        }
    }

    private void evt_guardar() {
        /*
        NUEVO = 0
        EDITAR = 1
         */
        switch (li_tipo_operacion) {
            case 0:
                if (lo_evt_datos_familia.valida_campos(lo_pnl_datos_familia)) {
                    try {
                        lo_evt_datos_familia.setea_campos(lo_bean_familia, lo_pnl_datos_familia);
                        if (go_dao_familia.IST_familia(lo_bean_familia)) {
                            lo_evt_datos_familia.limpia_datos(lo_pnl_datos_familia);
                            lo_evt_datos_familia.activa_campos(0, lo_pnl_datos_familia, false);
                            lo_evt_opciones_2.activa_btn_opciones(0, lo_pnl_opciones_2, lb_valor_op);
                        }
                    } catch (Exception e) {
                    }
                }
                break;
            case 1:
                if (lo_evt_datos_familia.verifica_cambios(lo_bean_familia, lo_pnl_datos_familia)) {
                    if (lo_evt_datos_familia.valida_campos(lo_pnl_datos_familia)) {
                        try {
                            lo_evt_datos_familia.setea_campos(lo_bean_familia, lo_pnl_datos_familia);
                            if (go_dao_familia.UPD_familia(lo_bean_familia)) {
                                lo_evt_datos_familia.limpia_datos(lo_pnl_datos_familia);
                                lo_evt_datos_familia.activa_campos(0, lo_pnl_datos_familia, false);
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
        lo_evt_datos_familia.activa_campos(0, lo_pnl_datos_familia, false);
        if (ls_codigo != null) {
            lo_evt_datos_familia.muestra_datos(lo_pnl_datos_familia, lo_bean_familia);
            lo_evt_opciones_2.activa_btn_opciones(2, lo_pnl_opciones_2, lb_valor_op);
        } else {
            lo_evt_datos_familia.limpia_datos(lo_pnl_datos_familia);
            lo_evt_opciones_2.activa_btn_opciones(0, lo_pnl_opciones_2, lb_valor_op);
        }
    }
    
    public void evt_reporte() {
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("empresa", go_bean_general.getNombre_reporte());
        parametros.put("usuario", gs_datos_usuario);
        go_muestra_reporte_invent.reporte_pestania("rpt_lista_familia.jasper", parametros, "Familia", 2);
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
                if(ke.getSource() == lo_pnl_datos_familia.TXT_nombre && go_fnc_operaciones_campos.cant_caracter(lo_pnl_datos_familia.TXT_nombre.getText().trim(), 1, 3)){
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
        setTitle("FAMILIA");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/JAVA/INVENT/IMAGES/familia.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 253, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
