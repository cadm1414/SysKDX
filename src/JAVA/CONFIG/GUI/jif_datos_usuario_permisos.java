package JAVA.CONFIG.GUI;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.ANCESTRO.GUI.pnl_opciones_2;
import JAVA.ANCESTRO.LOGICA.evt_opciones_2;
import JAVA.ANCESTRO.LOGICA.recupera_valor_op;
import JAVA.CONFIG.BEAN.BEAN_usuario_permisos;
import JAVA.CONFIG.LOGICA.evt_datos_usuario_permisos;
import JAVA.CONFIG.LOGICA.evt_grid_usuario_permisos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

public class jif_datos_usuario_permisos extends javax.swing.JInternalFrame {

    pnl_opciones_2 lo_pnl_opciones_2 = new pnl_opciones_2();
    pnl_datos_usuario_permisos lo_pnl_datos_usuario_permisos = new pnl_datos_usuario_permisos();
    pnl_grid_usuario_permisos lo_pnl_grid_usuario_permisos = new pnl_grid_usuario_permisos();
    evt_opciones_2 lo_evt_opciones_2 = new evt_opciones_2();
    evt_datos_usuario_permisos lo_evt_datos_usuario_permisos = new evt_datos_usuario_permisos();
    evt_grid_usuario_permisos lo_evt_grid_usuario_permisos = new evt_grid_usuario_permisos();
    recupera_valor_op lo_recupera_valor_op = new recupera_valor_op();
    BEAN_usuario_permisos lo_bean_usuario_permisos = new BEAN_usuario_permisos();
    static boolean lb_valor_op[] = new boolean[8];
    DefaultTableModel lo_modelo;
    ResultSet lq_rs;
    int li_tipo_operacion = 0;
    String ls_id_usuario;
    String ls_opcion = "M B C";
    String ls_modulo = "CONFIG", ls_capa = "GUI", ls_clase = "jif_datos_usuario_permisos";

    public jif_datos_usuario_permisos() {
        initComponents();
        formulario();
        activa_botones();
    }

    private void formulario() {
        lo_pnl_opciones_2.setBounds(0, 0, 655, 120);
        lo_pnl_datos_usuario_permisos.setBounds(12, 130, 320, 70);
        lo_pnl_grid_usuario_permisos.setBounds(12, 200, 300, 250);

        this.add(lo_pnl_opciones_2);
        this.add(lo_pnl_datos_usuario_permisos);
        this.add(lo_pnl_grid_usuario_permisos);

        lo_evt_opciones_2.evento_click(lo_pnl_opciones_2, Listener);
        lo_evt_opciones_2.evento_press(lo_pnl_opciones_2, KeyEvnt);

        lo_evt_datos_usuario_permisos.evento_press(lo_pnl_datos_usuario_permisos, KeyEvnt);
    }

    private void activa_botones() {
        lb_valor_op = lo_recupera_valor_op.recupera(ls_modulo, ls_opcion);
        lo_evt_opciones_2.activa_btn_opciones(0, lo_pnl_opciones_2, lb_valor_op);
    }

    private void evt_f5() {
        go_dlg_busq_usuario = new dlg_busq_usuario(null, true);
        go_dlg_busq_usuario.setVisible(true);
        ls_id_usuario = go_dlg_busq_usuario.ls_codigo_usuario;

        if (ls_id_usuario != null) {
            lo_pnl_datos_usuario_permisos.TXT_id_usuario.setText(ls_id_usuario);
            get_descripcion_usuario();
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_f5", "SELECCIONE USUARIO");
            lo_pnl_datos_usuario_permisos.TXT_id_usuario.setText("");
            lo_pnl_datos_usuario_permisos.TXT_usuario.setText("");
        }
    }

    private void get_descripcion_usuario() {
        ls_id_usuario = lo_pnl_datos_usuario_permisos.TXT_id_usuario.getText().trim();
        try {
            lq_rs = go_dao_usuario.SLT_datos_usuario(Integer.parseInt(ls_id_usuario));
            if (lq_rs != null) {
                switch (li_tipo_operacion) {
                    case 0:
                        if (go_dao_usuario_permisos.SLT_cta_usuario_permisos(Integer.parseInt(ls_id_usuario)) > 0) {
                            ls_id_usuario = null;
                            lo_evt_datos_usuario_permisos.limpia_datos(lo_pnl_datos_usuario_permisos);
                            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "get_descripcion_usuario", "USUARIO TIENE PERMISOS REGISTRADOS");
                        } else {
                            lo_evt_datos_usuario_permisos.setea_recupera(lo_bean_usuario_permisos, lq_rs);
                            lo_evt_datos_usuario_permisos.muestra_datos(lo_bean_usuario_permisos, lo_pnl_datos_usuario_permisos);
                            getFocusOwner().transferFocus();
                        }
                        break;
                    case 1:
                        lo_evt_datos_usuario_permisos.setea_recupera(lo_bean_usuario_permisos, lq_rs);
                        lo_evt_datos_usuario_permisos.muestra_datos(lo_bean_usuario_permisos, lo_pnl_datos_usuario_permisos);
                        getFocusOwner().transferFocus();
                        break;
                }

            } else {
                ls_id_usuario = null;
                lo_evt_datos_usuario_permisos.limpia_datos(lo_pnl_datos_usuario_permisos);
                go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "get_descripcion_usuario", "USUARIO NO EXISTE");
            }
        } catch (Exception e) {
        }
    }

    private void get_detalle_permisos() {
        lo_evt_grid_usuario_permisos.limpia_tabla(lo_pnl_grid_usuario_permisos);
        lo_evt_grid_usuario_permisos.datos_tabla(lo_pnl_grid_usuario_permisos, lo_modelo);
        try {
            lq_rs = go_dao_usuario_permisos.SLT_usuario_permisos_x_idusuario(Integer.parseInt(ls_id_usuario));
            if (lq_rs != null) {
                lo_evt_grid_usuario_permisos.muestra_datos(lo_pnl_grid_usuario_permisos, lq_rs);
            }
        } catch (Exception e) {
        }
    }

    private void evt_nuevo() {
        li_tipo_operacion = 0;
        ls_id_usuario = null;
        lo_evt_opciones_2.activa_btn_opciones(1, lo_pnl_opciones_2, lb_valor_op);
        lo_evt_datos_usuario_permisos.activa_campos(0, lo_pnl_datos_usuario_permisos, true);
        lo_evt_datos_usuario_permisos.limpia_datos(lo_pnl_datos_usuario_permisos);
        lo_evt_grid_usuario_permisos.activa_campos(0, lo_pnl_grid_usuario_permisos, true);
        lo_evt_grid_usuario_permisos.limpia_tabla(lo_pnl_grid_usuario_permisos);
        lo_evt_grid_usuario_permisos.datos_tabla(lo_pnl_grid_usuario_permisos, lo_modelo);
    }

    private void evt_editar() {
        li_tipo_operacion = 1;
        lo_evt_opciones_2.activa_btn_opciones(3, lo_pnl_opciones_2, lb_valor_op);
        lo_evt_grid_usuario_permisos.activa_campos(0, lo_pnl_grid_usuario_permisos, true);
    }

    private void evt_buscar() {
        li_tipo_operacion = 1;
        evt_f5();        
        if (ls_id_usuario != null) {
            lo_evt_opciones_2.activa_btn_opciones(2, lo_pnl_opciones_2, lb_valor_op);
            get_detalle_permisos();
        }
    }

    private void evt_eliminar() {
        if (go_fnc_mensaje.get_respuesta(0, "¿DESEA ELIMINAR LOS ACCESOS AL USUARIO " + lo_bean_usuario_permisos.getNombre_usuario() + "?") == 0) {
            try {
                if (go_dao_usuario_permisos.DLT_usuario_permisos(Integer.parseInt(ls_id_usuario))) {
                    lo_evt_opciones_2.activa_btn_opciones(0, lo_pnl_opciones_2, lb_valor_op);
                    lo_evt_datos_usuario_permisos.activa_campos(0, lo_pnl_datos_usuario_permisos, false);
                    lo_evt_datos_usuario_permisos.limpia_datos(lo_pnl_datos_usuario_permisos);
                    lo_evt_grid_usuario_permisos.activa_campos(0, lo_pnl_grid_usuario_permisos, false);
                    lo_evt_grid_usuario_permisos.limpia_tabla(lo_pnl_grid_usuario_permisos);
                }
            } catch (Exception e) {
            }
        }
    }

    private void evt_guardar() {
        lo_evt_opciones_2.activa_btn_opciones(5, lo_pnl_opciones_2, lb_valor_op);
        if (lo_evt_datos_usuario_permisos.valida_campos(lo_pnl_datos_usuario_permisos)) {
            try {
                lo_evt_datos_usuario_permisos.setea_campos(lo_bean_usuario_permisos, lo_pnl_datos_usuario_permisos);
                if (go_dao_usuario_permisos.IST_usuario_permisos(lo_bean_usuario_permisos, lo_pnl_grid_usuario_permisos)) {
                    lo_evt_datos_usuario_permisos.limpia_datos(lo_pnl_datos_usuario_permisos);
                    lo_evt_datos_usuario_permisos.activa_campos(0, lo_pnl_datos_usuario_permisos, false);
                    lo_evt_grid_usuario_permisos.activa_campos(0, lo_pnl_grid_usuario_permisos, false);
                    lo_evt_grid_usuario_permisos.limpia_tabla(lo_pnl_grid_usuario_permisos);
                    lo_evt_opciones_2.activa_btn_opciones(0, lo_pnl_opciones_2, lb_valor_op);
                }
            } catch (Exception e) {
            }
        }
    }

    private void evt_cancelar() {
        lo_evt_datos_usuario_permisos.activa_campos(0, lo_pnl_datos_usuario_permisos, false);
        lo_evt_grid_usuario_permisos.activa_campos(0, lo_pnl_grid_usuario_permisos, false);
        lo_evt_grid_usuario_permisos.limpia_tabla(lo_pnl_grid_usuario_permisos);
        if (ls_id_usuario != null) {
            lo_evt_datos_usuario_permisos.muestra_datos(lo_bean_usuario_permisos, lo_pnl_datos_usuario_permisos);
            get_descripcion_usuario();
            get_detalle_permisos();
            lo_evt_opciones_2.activa_btn_opciones(2, lo_pnl_opciones_2, lb_valor_op);
        } else {
            lo_evt_datos_usuario_permisos.limpia_datos(lo_pnl_datos_usuario_permisos);
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
                if (ke.getSource() == lo_pnl_datos_usuario_permisos.TXT_id_usuario) {
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
                    //evt_reporte();
                }
                if (ke.getSource() == lo_pnl_datos_usuario_permisos.TXT_id_usuario && go_fnc_operaciones_campos.campo_blanco(lo_pnl_datos_usuario_permisos.TXT_id_usuario)) {
                    get_descripcion_usuario();
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
        setTitle("Usuario - Permisos");

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
