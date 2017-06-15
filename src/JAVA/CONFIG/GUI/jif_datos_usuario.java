package JAVA.CONFIG.GUI;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.ANCESTRO.GUI.pnl_opciones_2;
import JAVA.ANCESTRO.LOGICA.evt_opciones_2;
import JAVA.ANCESTRO.LOGICA.recupera_valor_op;
import JAVA.CONFIG.BEAN.BEAN_usuario;
import JAVA.CONFIG.IMAGES.IMAGES_ruta_config;
import JAVA.CONFIG.LOGICA.cbx_rol;
import JAVA.CONFIG.LOGICA.evt_datos_usuario;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

public class jif_datos_usuario extends javax.swing.JInternalFrame {

    pnl_opciones_2 lo_pnl_opciones_2 = new pnl_opciones_2();
    pnl_datos_usuario lo_pnl_datos_usuario = new pnl_datos_usuario();
    recupera_valor_op lo_recupera_valor_op = new recupera_valor_op();
    evt_opciones_2 lo_evt_opciones_2 = new evt_opciones_2();
    evt_datos_usuario lo_evt_datos_usuario = new evt_datos_usuario();
    BEAN_usuario lo_bean_usuario = new BEAN_usuario();
    static boolean lb_valor_op[] = new boolean[8];
    cbx_rol lo_cbx_rol;
    int li_tipo_operacion;
    String ls_id_usuario;
    String ls_opcion = "M B B";
    String ls_modulo = "CONFIG", ls_capa = "GUI", ls_clase = "jif_datos_usuario";
    ResultSet lq_rs;

    public jif_datos_usuario() {
        initComponents();
        formulario();
        activa_botones();
        get_rol();
    }

    private void formulario() {
        lo_pnl_opciones_2.setBounds(0, 0, 655, 120);
        lo_pnl_datos_usuario.setBounds(12, 130, 350, 250);

        this.add(lo_pnl_opciones_2);
        this.add(lo_pnl_datos_usuario);

        lo_evt_opciones_2.evento_click(lo_pnl_opciones_2, Listener);
        lo_evt_opciones_2.evento_press(lo_pnl_opciones_2, KeyEvnt);

        lo_evt_datos_usuario.evento_press(lo_pnl_datos_usuario, KeyEvnt);
    }

    private void activa_botones() {
        lb_valor_op = lo_recupera_valor_op.recupera(ls_modulo, ls_opcion);
        lo_evt_opciones_2.activa_btn_opciones(0, lo_pnl_opciones_2, lb_valor_op);
    }

    private void get_descripcion(int id_usuario) {
        try {
            lq_rs = go_dao_usuario.SLT_datos_usuario(id_usuario);
            if (lq_rs != null) {
                lo_evt_datos_usuario.setea_recupera(lo_bean_usuario, lq_rs);
                lo_evt_datos_usuario.muestra_datos(lo_pnl_datos_usuario, lo_bean_usuario);
            }
        } catch (Exception e) {
        }
    }

    private void get_rol() {
        lq_rs = go_dao_rol.SLT_datos_rol();
        if (lq_rs != null) {
            go_cbx_trato_datos.recupera_valor(1, lq_rs, lo_pnl_datos_usuario.CBX_rol);
        }
    }

    private void evt_nuevo() {
        ls_id_usuario = null;
        li_tipo_operacion = 0;
        lo_evt_datos_usuario.limpia_datos(lo_pnl_datos_usuario);
        lo_evt_opciones_2.activa_btn_opciones(1, lo_pnl_opciones_2, lb_valor_op);
        lo_evt_datos_usuario.activa_campos(0, lo_pnl_datos_usuario, true);
    }

    private void evt_buscar() {
        go_dlg_busq_usuario = new dlg_busq_usuario(null, true);
        go_dlg_busq_usuario.setVisible(true);
        ls_id_usuario = go_dlg_busq_usuario.ls_codigo_usuario;
        if (ls_id_usuario != null) {
            get_descripcion(Integer.parseInt(ls_id_usuario));
            lo_evt_opciones_2.activa_btn_opciones(2, lo_pnl_opciones_2, lb_valor_op);
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_buscar", "SELECCIONE USUARIO");
            lo_evt_datos_usuario.limpia_datos(lo_pnl_datos_usuario);
            lo_evt_opciones_2.activa_btn_opciones(0, lo_pnl_opciones_2, lb_valor_op);
        }
    }

    private void evt_editar() {
        li_tipo_operacion = 1;
        lo_evt_opciones_2.activa_btn_opciones(3, lo_pnl_opciones_2, lb_valor_op);
        lo_evt_datos_usuario.activa_campos(0, lo_pnl_datos_usuario, true);
    }

    private void evt_eliminar() {
        if (go_fnc_mensaje.get_respuesta(0, "¿DESEA ELIMINAR AL USUARIO " + lo_bean_usuario.getNombre_usuario() + "?") == 0) {
            if (gi_id_usuario != Integer.parseInt(ls_id_usuario)) {
                try {
                    if (go_dao_usuario.DLT_usuario(Integer.parseInt(ls_id_usuario))) {
                        lo_evt_opciones_2.activa_btn_opciones(0, lo_pnl_opciones_2, lb_valor_op);
                        lo_evt_datos_usuario.activa_campos(0, lo_pnl_datos_usuario, false);
                        lo_evt_datos_usuario.limpia_datos(lo_pnl_datos_usuario);
                    }
                } catch (Exception e) {
                }
            } else {
                go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_eliminar", "USUARIO SE ENCUENTRA ACTIVO");
            }
        }
    }

    public void evt_guardar() {
        lo_evt_opciones_2.activa_btn_opciones(5, lo_pnl_opciones_2, lb_valor_op);
        lo_cbx_rol = (cbx_rol) lo_pnl_datos_usuario.CBX_rol.getSelectedItem();
        /*
        NUEVO = 0
        EDITAR = 1
         */
        switch (li_tipo_operacion) {
            case 0:
                if (lo_evt_datos_usuario.valida_campos(lo_pnl_datos_usuario)) {
                    try {
                        lo_evt_datos_usuario.setea_campos(lo_bean_usuario, lo_pnl_datos_usuario, lo_cbx_rol);
                        if (go_dao_usuario.IST_usuario(lo_bean_usuario)) {
                            lo_evt_datos_usuario.limpia_datos(lo_pnl_datos_usuario);
                            lo_evt_datos_usuario.activa_campos(0, lo_pnl_datos_usuario, false);
                            lo_evt_opciones_2.activa_btn_opciones(0, lo_pnl_opciones_2, lb_valor_op);
                        }
                    } catch (Exception e) {
                    }
                }
                break;
            case 1:                
                if (lo_evt_datos_usuario.verifica_cambios(lo_bean_usuario, lo_pnl_datos_usuario, lo_cbx_rol)) {
                    if (lo_evt_datos_usuario.valida_campos(lo_pnl_datos_usuario)) {
                        try {
                            lo_evt_datos_usuario.setea_campos(lo_bean_usuario, lo_pnl_datos_usuario, lo_cbx_rol);
                            if (go_dao_usuario.UPD_usuario(lo_bean_usuario, Integer.parseInt(ls_id_usuario))) {
                                lo_evt_datos_usuario.limpia_datos(lo_pnl_datos_usuario);
                                lo_evt_datos_usuario.activa_campos(0, lo_pnl_datos_usuario, false);
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
        lo_evt_datos_usuario.activa_campos(0, lo_pnl_datos_usuario, false);
        if (ls_id_usuario != null) {
            lo_evt_datos_usuario.muestra_datos(lo_pnl_datos_usuario, lo_bean_usuario);
            lo_evt_opciones_2.activa_btn_opciones(2, lo_pnl_opciones_2, lb_valor_op);
        } else {
            lo_evt_datos_usuario.limpia_datos(lo_pnl_datos_usuario);
            lo_evt_opciones_2.activa_btn_opciones(0, lo_pnl_opciones_2, lb_valor_op);
        }
    }
    
    public void evt_reporte(){
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("empresa", go_bean_general.getNombre_reporte());
        parametros.put("usuario", gs_datos_usuario);
        go_evt_muestra_reporte.reporte_pestania("rpt_lista_usuario.jasper", parametros,"Usuarios",0);       
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
                if (ke.getSource() == lo_pnl_datos_usuario.TXT_datos && go_fnc_operaciones_campos.cant_caracter(lo_pnl_datos_usuario.TXT_datos.getText().trim(), 1, 4)) {
                    lo_pnl_datos_usuario.TXT_usuario.requestFocus();
                }
                if (ke.getSource() == lo_pnl_datos_usuario.TXT_usuario && go_fnc_operaciones_campos.cant_caracter(lo_pnl_datos_usuario.TXT_usuario.getText().trim(), 1, 4)) {
                    lo_pnl_datos_usuario.TXT_pass.requestFocus();
                }
                if (ke.getSource() == lo_pnl_datos_usuario.TXT_pass && go_fnc_operaciones_campos.cant_caracter(lo_pnl_datos_usuario.TXT_pass.getText().trim(), 1, 4)) {
                    lo_pnl_datos_usuario.CBX_rol.requestFocus();
                }
                if (ke.getSource() == lo_pnl_datos_usuario.CBX_rol) {
                    lo_pnl_datos_usuario.CBX_estado.requestFocus();
                }
                if (ke.getSource() == lo_pnl_datos_usuario.CBX_estado) {
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
        setTitle("Registro Usuario");
        setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/JAVA/CONFIG/IMAGES/usuario.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 644, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 335, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
