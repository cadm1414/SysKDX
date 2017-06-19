package JAVA.INVENT.GUI;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.ANCESTRO.GUI.pnl_opciones_2;
import JAVA.ANCESTRO.LOGICA.evt_opciones_2;
import JAVA.ANCESTRO.LOGICA.recupera_valor_op;
import JAVA.INVENT.BEAN.BEAN_subfamilia;
import JAVA.INVENT.LOGICA.cbx_familia;
import JAVA.INVENT.LOGICA.evt_datos_subfamilia;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

public class jif_datos_subfamilia extends javax.swing.JInternalFrame {

    pnl_opciones_2 lo_pnl_opciones_2 = new pnl_opciones_2();
    pnl_datos_subfamilia lo_pnl_datos_subfamilia = new pnl_datos_subfamilia();
    evt_opciones_2 lo_evt_opciones_2 = new evt_opciones_2();
    evt_datos_subfamilia lo_evt_datos_subfamilia = new evt_datos_subfamilia();
    recupera_valor_op lo_recupera_valor_op = new recupera_valor_op();
    BEAN_subfamilia lo_bean_subfamilia = new BEAN_subfamilia();
    static boolean lb_valor_op[] = new boolean[8];
    cbx_familia lo_cbx_familia;
    ResultSet lq_rs = null;
    int li_tipo_operacion;
    String ls_codigo;
    String ls_opcion = "M C D";
    String ls_modulo = "INVENT", ls_capa = "GUI", ls_clase = "jif_datos_subfamilia";

    public jif_datos_subfamilia() {
        initComponents();
        formulario();
        activa_botones();
        get_familia();
    }

    private void formulario() {
        lo_pnl_opciones_2.setBounds(0, 0, 655, 120);
        lo_pnl_datos_subfamilia.setBounds(12, 130, 500, 350);

        this.add(lo_pnl_opciones_2);
        this.add(lo_pnl_datos_subfamilia);

        lo_evt_opciones_2.evento_click(lo_pnl_opciones_2, Listener);
        lo_evt_opciones_2.evento_press(lo_pnl_opciones_2, KeyEvnt);

        lo_evt_datos_subfamilia.evento_press(lo_pnl_datos_subfamilia, KeyEvnt);
    }

    private void activa_botones() {
        lb_valor_op = lo_recupera_valor_op.recupera(ls_modulo, ls_opcion);
        lo_evt_opciones_2.activa_btn_opciones(0, lo_pnl_opciones_2, lb_valor_op);
    }

    private void get_familia() {
        lq_rs = go_dao_familia.SLT_cbx_familia();
        if (lq_rs != null) {
            go_cbx_trato_datos.recupera_valor(5, lq_rs, lo_pnl_datos_subfamilia.CBX_familia);
        }
    }

    private void get_descripcion_subfamilia(String codigo) {
        try {
            lq_rs = go_dao_subfamilia.SLT_datos_subfamilia(codigo);
            if (lq_rs != null) {
                lo_evt_datos_subfamilia.setea_recupera(lo_bean_subfamilia, lq_rs);
                lo_evt_datos_subfamilia.muestra_datos(lo_pnl_datos_subfamilia, lo_bean_subfamilia);
            }
        } catch (Exception e) {
        }
    }

    private void evt_nuevo() {
        ls_codigo = null;
        lo_evt_datos_subfamilia.limpia_datos(lo_pnl_datos_subfamilia);

        try {
            lq_rs = go_dao_subfamilia.FNC_codigo_subfamilia();
            if (lq_rs.next()) {
                lo_pnl_datos_subfamilia.TXT_codigo.setText(lq_rs.getString(1));
            }
        } catch (Exception e) {
        }
        li_tipo_operacion = 0;
        lo_evt_opciones_2.activa_btn_opciones(1, lo_pnl_opciones_2, lb_valor_op);
        lo_evt_datos_subfamilia.activa_campos(0, lo_pnl_datos_subfamilia, true);
    }

    private void evt_buscar() {
        go_dlg_busq_subfamilia = new dlg_busq_subfamilia(null, true);
        go_dlg_busq_subfamilia.setVisible(true);
        ls_codigo = go_dlg_busq_subfamilia.ls_codigo_subfamilia;
        if (ls_codigo != null) {
            get_descripcion_subfamilia(ls_codigo);
            lo_evt_opciones_2.activa_btn_opciones(2, lo_pnl_opciones_2, lb_valor_op);
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_buscar", "SELECCIONE SUBFAMILIA");
            lo_evt_datos_subfamilia.limpia_datos(lo_pnl_datos_subfamilia);
            lo_evt_opciones_2.activa_btn_opciones(0, lo_pnl_opciones_2, lb_valor_op);
        }
    }

    private void evt_editar() {
        li_tipo_operacion = 1;
        lo_evt_opciones_2.activa_btn_opciones(3, lo_pnl_opciones_2, lb_valor_op);
        lo_evt_datos_subfamilia.activa_campos(0, lo_pnl_datos_subfamilia, true);
    }

    private void evt_eliminar() {
        if (go_fnc_mensaje.get_respuesta(0, "¿DESEA ELIMINAR SUBFAMILIA " + lo_bean_subfamilia.getNombre_subfamilia() + "?") == 0) {
            try {
                if (go_dao_subfamilia.DLT_subfamilia(ls_codigo)) {
                    lo_evt_opciones_2.activa_btn_opciones(0, lo_pnl_opciones_2, lb_valor_op);
                    lo_evt_datos_subfamilia.activa_campos(0, lo_pnl_datos_subfamilia, false);
                    lo_evt_datos_subfamilia.limpia_datos(lo_pnl_datos_subfamilia);
                }
            } catch (Exception e) {
            }
        }
    }

    private void evt_guardar() {
        lo_evt_opciones_2.activa_btn_opciones(5, lo_pnl_opciones_2, lb_valor_op);
        lo_cbx_familia = (cbx_familia) lo_pnl_datos_subfamilia.CBX_familia.getSelectedItem();
        /*
        NUEVO = 0
        EDITAR = 1
         */
        switch (li_tipo_operacion) {
            case 0:
                if (lo_evt_datos_subfamilia.valida_campos(lo_pnl_datos_subfamilia)) {
                    try {
                        lo_evt_datos_subfamilia.setea_campos(lo_bean_subfamilia, lo_pnl_datos_subfamilia, lo_cbx_familia);
                        if (go_dao_subfamilia.IST_subfamilia(lo_bean_subfamilia)) {
                            lo_evt_datos_subfamilia.limpia_datos(lo_pnl_datos_subfamilia);
                            lo_evt_datos_subfamilia.activa_campos(0, lo_pnl_datos_subfamilia, false);
                            lo_evt_opciones_2.activa_btn_opciones(0, lo_pnl_opciones_2, lb_valor_op);
                        }
                    } catch (Exception e) {
                    }
                }
                break;
            case 1:
                if (lo_evt_datos_subfamilia.verifica_cambios(lo_bean_subfamilia, lo_pnl_datos_subfamilia,lo_cbx_familia)) {
                    if (lo_evt_datos_subfamilia.valida_campos(lo_pnl_datos_subfamilia)) {
                        try {
                            lo_evt_datos_subfamilia.setea_campos(lo_bean_subfamilia, lo_pnl_datos_subfamilia,lo_cbx_familia);
                            if (go_dao_subfamilia.UPD_subfamilia(lo_bean_subfamilia)) {
                                lo_evt_datos_subfamilia.limpia_datos(lo_pnl_datos_subfamilia);
                                lo_evt_datos_subfamilia.activa_campos(0, lo_pnl_datos_subfamilia, false);
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
        lo_evt_datos_subfamilia.activa_campos(0, lo_pnl_datos_subfamilia, false);
        if (ls_codigo != null) {
            lo_evt_datos_subfamilia.muestra_datos(lo_pnl_datos_subfamilia, lo_bean_subfamilia);
            lo_evt_opciones_2.activa_btn_opciones(2, lo_pnl_opciones_2, lb_valor_op);
        } else {
            lo_evt_datos_subfamilia.limpia_datos(lo_pnl_datos_subfamilia);
            lo_evt_opciones_2.activa_btn_opciones(0, lo_pnl_opciones_2, lb_valor_op);
        }
    }
    
    public void evt_reporte() {
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("empresa", go_bean_general.getNombre_reporte());
        parametros.put("usuario", gs_datos_usuario);
        go_muestra_reporte_invent.reporte_pestania("rpt_lista_subfamilia.jasper", parametros, "Subfamilia", 3);
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
                if (ke.getSource() == lo_pnl_datos_subfamilia.TXT_nombre && go_fnc_operaciones_campos.cant_caracter(lo_pnl_datos_subfamilia.TXT_nombre.getText().trim(), 1, 3)) {
                    lo_pnl_datos_subfamilia.CBX_familia.requestFocus();
                }
                if (ke.getSource() == lo_pnl_datos_subfamilia.CBX_familia) {
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
        setTitle("SUBFAMILIA");
        setToolTipText("");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/JAVA/INVENT/IMAGES/subfamilia.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 639, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 274, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
