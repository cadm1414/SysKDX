package JAVA.CONFIG.GUI;

import JAVA.ANCESTRO.GUI.frm_principal;
import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.ANCESTRO.GUI.pnl_opciones_2;
import JAVA.ANCESTRO.GUI.pnl_salir;
import JAVA.ANCESTRO.LOGICA.evt_opciones_2;
import JAVA.ANCESTRO.LOGICA.recupera_valor_op;
import JAVA.CONFIG.BEAN.BEAN_rol;
import JAVA.CONFIG.IMAGES.IMAGES_ruta_config;
import JAVA.CONFIG.LOGICA.evt_datos_rol_menu;
import JAVA.CONFIG.LOGICA.evt_grid_rol_menu;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import javax.swing.table.DefaultTableModel;

public class frm_datos_rol_menu extends javax.swing.JFrame {

    pnl_opciones_2 lo_pnl_opciones_2 = new pnl_opciones_2();
    pnl_datos_rol_menu lo_pnl_datos_rol_menu = new pnl_datos_rol_menu();
    pnl_grid_rol_menu lo_pnl_grid_rol_menu = new pnl_grid_rol_menu();
    pnl_salir lo_pnl_salir = new pnl_salir();
    static boolean lb_valor_op[] = new boolean[8];
    DefaultTableModel lo_modelo;
    recupera_valor_op lo_recupera_valor_op = new recupera_valor_op();
    evt_opciones_2 lo_evt_opciones_2 = new evt_opciones_2();
    evt_datos_rol_menu lo_evt_datos_rol_menu = new evt_datos_rol_menu();
    evt_grid_rol_menu lo_evt_grid_rol_menu = new evt_grid_rol_menu();
    BEAN_rol lo_bean_rol = new BEAN_rol();
    String ls_id_rol;
    int li_tipo_operacion;
    ResultSet lq_rs = null;
    String ls_opcion = "M B A";
    String ls_modulo = "CONFIG", ls_capa = "GUI", ls_clase = "frm_datos_rol_menu";

    public frm_datos_rol_menu() {
        initComponents();
        formulario();
        activa_botones();
    }
           
    private void formulario() {
        lo_pnl_opciones_2.setBounds(0, 0, 700, 120);
        lo_pnl_datos_rol_menu.setBounds(0, 0, 300, 60);
        lo_pnl_grid_rol_menu.setBounds(15, 70, 770, 300);
        lo_pnl_salir.setBounds(0, 0, 200, 200);

        PNL_menu_opciones.add(lo_pnl_opciones_2);
        PNL_datos_rol_menu.add(lo_pnl_datos_rol_menu);
        PNL_datos_rol_menu.add(lo_pnl_grid_rol_menu);
        PNL_salir.add(lo_pnl_salir);

        lo_evt_opciones_2.evento_click(lo_pnl_opciones_2, Listener);
        lo_evt_opciones_2.evento_press(lo_pnl_opciones_2, KeyEvnt);

        go_evt_salir.evento_click(lo_pnl_salir, Listener);
        go_evt_salir.evento_press(lo_pnl_salir, KeyEvnt);

        lo_evt_datos_rol_menu.evento_press(lo_pnl_datos_rol_menu, KeyEvnt);
    }

    private void activa_botones() {
        lb_valor_op = lo_recupera_valor_op.recupera(ls_modulo, ls_opcion);
        lo_evt_opciones_2.activa_btn_opciones(0, lo_pnl_opciones_2, lb_valor_op);
    }

    private void get_descripcion(int id_rol) {
        lo_evt_grid_rol_menu.datos_tabla(lo_pnl_grid_rol_menu, lo_modelo);
        try {
            lq_rs = go_dao_rol_menu.SLT_status_op_x_idrol(id_rol);
            if (lq_rs != null) {
                lo_evt_datos_rol_menu.setea_recupera(lo_bean_rol, lq_rs);
                lo_evt_datos_rol_menu.muestra_datos(lo_bean_rol, lo_pnl_datos_rol_menu);
                lo_evt_grid_rol_menu.muestra_datos(lo_pnl_grid_rol_menu, lq_rs);
            }
        } catch (Exception e) {

        }
    }

    private void evt_nuevo() {
        ls_id_rol = null;
        li_tipo_operacion = 0;
        lo_evt_opciones_2.activa_btn_opciones(1, lo_pnl_opciones_2, lb_valor_op);
        lo_evt_datos_rol_menu.activa_campos(0, lo_pnl_datos_rol_menu, lo_pnl_grid_rol_menu, true);
        lo_evt_datos_rol_menu.limpia_datos(lo_pnl_datos_rol_menu);
        lo_evt_grid_rol_menu.limpia_tabla(lo_pnl_grid_rol_menu);
        lo_evt_grid_rol_menu.datos_tabla(lo_pnl_grid_rol_menu, lo_modelo);
    }

    private void evt_buscar() {
        lo_evt_opciones_2.activa_btn_opciones(2, lo_pnl_opciones_2, lb_valor_op);
        lo_evt_grid_rol_menu.limpia_tabla(lo_pnl_grid_rol_menu);
        go_dlg_busq_rol = new dlg_busq_rol(null, true);
        go_dlg_busq_rol.setVisible(true);
        ls_id_rol = go_dlg_busq_rol.ls_codigo_rol;
        if (ls_id_rol != null) {
            get_descripcion(Integer.parseInt(ls_id_rol));
            lo_evt_opciones_2.activa_btn_opciones(2, lo_pnl_opciones_2, lb_valor_op);
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_buscar", "SELECCIONE ROL");
            lo_evt_datos_rol_menu.limpia_datos(lo_pnl_datos_rol_menu);
            lo_evt_opciones_2.activa_btn_opciones(0, lo_pnl_opciones_2, lb_valor_op);
        }
    }

    private void evt_editar() {
        li_tipo_operacion = 1;
        lo_evt_opciones_2.activa_btn_opciones(3, lo_pnl_opciones_2, lb_valor_op);
        lo_evt_datos_rol_menu.activa_campos(0, lo_pnl_datos_rol_menu, lo_pnl_grid_rol_menu, true);
    }

    private void evt_eliminar() {
        if (go_fnc_mensaje.get_respuesta(0, "¿DESEA ELIMINAR AL USUARIO " + lo_bean_rol.getNombre_rol() + "?") == 0) {
            if (gi_id_rol != Integer.parseInt(ls_id_rol)) {
                try {
                    if (go_dao_rol.DLT_rol(Integer.parseInt(ls_id_rol))) {
                        lo_evt_opciones_2.activa_btn_opciones(0, lo_pnl_opciones_2, lb_valor_op);
                        lo_evt_datos_rol_menu.activa_campos(0, lo_pnl_datos_rol_menu, lo_pnl_grid_rol_menu, false);
                        lo_evt_datos_rol_menu.limpia_datos(lo_pnl_datos_rol_menu);
                        lo_evt_grid_rol_menu.limpia_tabla(lo_pnl_grid_rol_menu);
                    }
                } catch (Exception e) {
                }
            } else {
                go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_eliminar", "USUARIO SE ENCUENTRA ACTIVO");
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
                if (lo_evt_datos_rol_menu.valida_campos(lo_pnl_datos_rol_menu)) {
                    try {
                        lo_evt_datos_rol_menu.setea_campos(lo_bean_rol, lo_pnl_datos_rol_menu);
                        if (go_dao_rol.IST_rol(lo_bean_rol, lo_pnl_grid_rol_menu)) {
                            lo_evt_grid_rol_menu.limpia_tabla(lo_pnl_grid_rol_menu);
                            lo_evt_datos_rol_menu.limpia_datos(lo_pnl_datos_rol_menu);
                            lo_evt_datos_rol_menu.activa_campos(0, lo_pnl_datos_rol_menu, lo_pnl_grid_rol_menu, false);
                            lo_evt_opciones_2.activa_btn_opciones(0, lo_pnl_opciones_2, lb_valor_op);
                        }
                    } catch (Exception e) {
                    }
                }
                break;
            case 1:
                if (lo_evt_datos_rol_menu.valida_campos(lo_pnl_datos_rol_menu)) {
                    try {
                        lo_evt_datos_rol_menu.setea_campos(lo_bean_rol, lo_pnl_datos_rol_menu);
                        if (go_dao_rol.UPD_rol(lo_bean_rol, lo_pnl_grid_rol_menu, Integer.parseInt(ls_id_rol))) {
                            lo_evt_grid_rol_menu.limpia_tabla(lo_pnl_grid_rol_menu);
                            lo_evt_datos_rol_menu.limpia_datos(lo_pnl_datos_rol_menu);
                            lo_evt_datos_rol_menu.activa_campos(0, lo_pnl_datos_rol_menu, lo_pnl_grid_rol_menu, false);
                            lo_evt_opciones_2.activa_btn_opciones(0, lo_pnl_opciones_2, lb_valor_op);
                        }
                    } catch (Exception e) {
                    }
                }
                break;
        }
    }

    private void evt_reporte() {
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("empresa", go_bean_general.getNombre_reporte());
        parametros.put("usuario", gs_datos_usuario);
        go_evt_muestra_reporte.reporte_frame("rpt_lista_rol.jasper", parametros);
    }

    private void evt_cancelar() {
        lo_evt_datos_rol_menu.activa_campos(0, lo_pnl_datos_rol_menu, lo_pnl_grid_rol_menu, false);
        if (ls_id_rol != null) {
            lo_evt_datos_rol_menu.muestra_datos(lo_bean_rol, lo_pnl_datos_rol_menu);
            lo_evt_grid_rol_menu.muestra_datos(lo_pnl_grid_rol_menu, lq_rs);
            lo_evt_opciones_2.activa_btn_opciones(2, lo_pnl_opciones_2, lb_valor_op);
        } else {
            lo_evt_datos_rol_menu.limpia_datos(lo_pnl_datos_rol_menu);
            lo_evt_grid_rol_menu.limpia_tabla(lo_pnl_grid_rol_menu);
            lo_evt_opciones_2.activa_btn_opciones(0, lo_pnl_opciones_2, lb_valor_op);
        }
    }

    private void evt_salir() {
        go_frm_principal = new frm_principal();
        go_evt_salir.ejecuta(go_frm_principal, this);
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
            if (ae.getSource() == lo_pnl_opciones_2.BTN_guardar) {
                evt_guardar();
            }
            if (ae.getSource() == lo_pnl_opciones_2.BTN_eliminar) {
                evt_eliminar();
            }
            if (ae.getSource() == lo_pnl_opciones_2.BTN_reporte) {
                evt_reporte();
            }
            if (ae.getSource() == lo_pnl_salir.BTN_salir) {
                evt_salir();
            }
            if (ae.getSource() == lo_pnl_opciones_2.BTN_cancelar) {
                evt_cancelar();
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
                if (ke.getSource() == lo_pnl_opciones_2.BTN_guardar) {
                    evt_guardar();
                }
                if (ke.getSource() == lo_pnl_opciones_2.BTN_eliminar) {
                    evt_eliminar();
                }
                if (ke.getSource() == lo_pnl_salir.BTN_salir) {
                    evt_salir();
                }
                if (ke.getSource() == lo_pnl_opciones_2.BTN_cancelar) {
                    evt_cancelar();
                }
                if (ke.getSource() == lo_pnl_opciones_2.BTN_reporte) {
                    evt_reporte();
                }
                if (ke.getSource() == lo_pnl_datos_rol_menu.TXT_nombre_rol) {
                    if (go_fnc_operaciones_campos.campo_blanco(lo_pnl_datos_rol_menu.TXT_nombre_rol) && go_fnc_operaciones_campos.cant_caracter(lo_pnl_datos_rol_menu.TXT_nombre_rol.getText().trim(), 1, 4)) {
                        lo_pnl_opciones_2.BTN_guardar.requestFocus();
                    }
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent ke) {

        }
    };

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(IMAGES_ruta_config.class.getResource("rol.png"));       
        return retValue;
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PNL_menu_opciones = new javax.swing.JPanel();
        PNL_datos_rol_menu = new javax.swing.JPanel();
        PNL_salir = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("ROL - ACCESO");
        setIconImage(getIconImage());

        javax.swing.GroupLayout PNL_menu_opcionesLayout = new javax.swing.GroupLayout(PNL_menu_opciones);
        PNL_menu_opciones.setLayout(PNL_menu_opcionesLayout);
        PNL_menu_opcionesLayout.setHorizontalGroup(
            PNL_menu_opcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 617, Short.MAX_VALUE)
        );
        PNL_menu_opcionesLayout.setVerticalGroup(
            PNL_menu_opcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 126, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout PNL_datos_rol_menuLayout = new javax.swing.GroupLayout(PNL_datos_rol_menu);
        PNL_datos_rol_menu.setLayout(PNL_datos_rol_menuLayout);
        PNL_datos_rol_menuLayout.setHorizontalGroup(
            PNL_datos_rol_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 809, Short.MAX_VALUE)
        );
        PNL_datos_rol_menuLayout.setVerticalGroup(
            PNL_datos_rol_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 379, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout PNL_salirLayout = new javax.swing.GroupLayout(PNL_salir);
        PNL_salir.setLayout(PNL_salirLayout);
        PNL_salirLayout.setHorizontalGroup(
            PNL_salirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        PNL_salirLayout.setVerticalGroup(
            PNL_salirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PNL_datos_rol_menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PNL_menu_opciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(PNL_salir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PNL_menu_opciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PNL_salir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PNL_datos_rol_menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        new frm_datos_rol_menu().setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PNL_datos_rol_menu;
    private javax.swing.JPanel PNL_menu_opciones;
    private javax.swing.JPanel PNL_salir;
    // End of variables declaration//GEN-END:variables
}
