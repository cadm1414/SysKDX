package JAVA.CONFIG.GUI;

import JAVA.ANCESTRO.GUI.frm_principal;
import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.ANCESTRO.GUI.pnl_opciones_1;
import JAVA.ANCESTRO.GUI.pnl_salir;
import JAVA.ANCESTRO.LOGICA.evt_opciones_1;
import JAVA.ANCESTRO.LOGICA.recupera_valor_op;
import JAVA.CONFIG.LOGICA.cbx_moneda;
import JAVA.CONFIG.LOGICA.evt_datos_general;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;

public class frm_datos_general extends javax.swing.JFrame {

    pnl_opciones_1 lo_pnl_opciones_1 = new pnl_opciones_1();
    pnl_salir lo_pnl_salir = new pnl_salir();
    pnl_datos_general lo_pnl_datos_general = new pnl_datos_general();
    recupera_valor_op lo_recupera_valor_op = new recupera_valor_op();
    evt_opciones_1 lo_evt_opciones_1 = new evt_opciones_1();
    evt_datos_general lo_evt_datos_general = new evt_datos_general();
    static boolean lb_valor_op[] = new boolean[8];
    cbx_moneda lo_cbx_moneda;
    ResultSet lq_rs = null;
    String ls_codigo_ubigeo;
    String ls_opcion = "M A A";
    String ls_modulo = "CONFIG", ls_capa = "GUI", ls_clase = "frm_datos_general";

    public frm_datos_general() {
        initComponents();
        formulario();
        get_moneda();
        activa_botones();
        completa_campos();
    }

    private void formulario() {
        lo_pnl_opciones_1.setBounds(0, 0, 400, 130);
        lo_pnl_salir.setBounds(0, 0, 150, 130);
        lo_pnl_datos_general.setBounds(0, 0, 500, 500);

        PNL_opciones.add(lo_pnl_opciones_1);
        PNL_salir.add(lo_pnl_salir);
        PNL_datos.add(lo_pnl_datos_general);
        
        lo_evt_opciones_1.evento_click(lo_pnl_opciones_1, Listener);
        lo_evt_opciones_1.evento_press(lo_pnl_opciones_1, KeyEvnt);

        go_evt_salir.evento_click(lo_pnl_salir, Listener); 
        go_evt_salir.evento_press(lo_pnl_salir, KeyEvnt);
        
        lo_evt_datos_general.evento_press(lo_pnl_datos_general, KeyEvnt);

    }

    private void get_moneda() {
        lq_rs = go_dao_moneda.SLT_moneda_x_visible("S");
        if (lq_rs != null) {
            go_cbx_trato_datos.recupera_valor(0, lq_rs, lo_pnl_datos_general.CBX_moneda);
        }
    }

    private void activa_botones() {
        lb_valor_op = lo_recupera_valor_op.recupera(ls_modulo, ls_opcion);
        lo_evt_opciones_1.activa_btn_opciones(0, lo_pnl_opciones_1, lb_valor_op);
    }

    private void completa_campos() {
        try {
            if (go_dao_general.SLT_cta_datos_general() != 0) {
                go_evt_datos_general.muestra_datos(lo_pnl_datos_general);
            }
        } catch (Exception e) {
        }
    }

    private void evt_salir() {
        try {
            if (go_dao_general.SLT_cta_datos_general() != 0) {
                go_frm_principal = new frm_principal();
                go_evt_salir.ejecuta(go_frm_principal, this);
            } else {
                go_fnc_mensaje.GET_mensaje(0, ls_modulo, ls_capa, ls_clase, "evt_salir", "DEBE REGISTRAR DATOS DE LA EMPRESA");
            }
        } catch (Exception e) {
        }
    }

    private void evt_editar() {
        lo_evt_datos_general.activa_bloquea_campos(lo_pnl_datos_general, true);
        lo_evt_datos_general.evt_control(0, lo_pnl_datos_general);
        lo_evt_opciones_1.activa_btn_opciones(1, lo_pnl_opciones_1, lb_valor_op);
    }

    private void evt_cancelar() {
        go_dao_general.SLT_datos();
        lo_evt_datos_general.muestra_datos(lo_pnl_datos_general);
        lo_evt_datos_general.activa_bloquea_campos(lo_pnl_datos_general, false);
        lo_evt_opciones_1.activa_btn_opciones(0, lo_pnl_opciones_1, lb_valor_op);
    }

    public void evt_f5() {
        go_dlg_busq_ubigeo = new dlg_busq_ubigeo(null, true);
        go_dlg_busq_ubigeo.setVisible(true);
        ls_codigo_ubigeo = go_dlg_busq_ubigeo.ls_codigo_ubigeo;

        if (ls_codigo_ubigeo != null) {
            lo_pnl_datos_general.TXT_ubigeo.setText(ls_codigo_ubigeo);
            get_descripcion();
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_f5", "SELECCIONE UBIGEO");
            lo_pnl_datos_general.TXT_ubigeo.setText("");
            lo_pnl_datos_general.TXT_descripcion.setText("");
        }
    }

    public void evt_guardar() {
        try {
            if (lo_evt_datos_general.valida_campos(lo_pnl_datos_general)) {
                lo_cbx_moneda = (cbx_moneda) lo_pnl_datos_general.CBX_moneda.getSelectedItem();
                if (lo_pnl_datos_general.TXT_ruc.isEnabled()) {

                    lo_evt_datos_general.setea_campos(lo_pnl_datos_general, lo_cbx_moneda);
                    go_dao_general.IST_general();

                } else if (lo_evt_datos_general.verifica_cambios(lo_pnl_datos_general, lo_cbx_moneda)) {
                    lo_evt_datos_general.setea_campos(lo_pnl_datos_general, lo_cbx_moneda);
                    go_dao_general.UPD_general();
                } else {
                    go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_guardar", "NO SE A REALIZADO CAMBIOS");
                }
                
                go_dao_general.SLT_datos();
                lo_evt_datos_general.muestra_datos(lo_pnl_datos_general);
                lo_evt_datos_general.activa_bloquea_campos(lo_pnl_datos_general, false);
                lo_evt_opciones_1.activa_btn_opciones(0, lo_pnl_opciones_1, lb_valor_op);

            }
        } catch (Exception e) {
        }
    }

    private void get_descripcion() {
        ls_codigo_ubigeo = lo_pnl_datos_general.TXT_ubigeo.getText().trim();

        try {
            lq_rs = go_dao_ubigeo.SLT_descripcion_ubigeo_x_codigo(ls_codigo_ubigeo);
            if (lq_rs != null) {
                lo_pnl_datos_general.TXT_descripcion.setText(lq_rs.getString(1));
                getFocusOwner().transferFocus();
            } else {
                lo_pnl_datos_general.TXT_ubigeo.setText("");
                lo_pnl_datos_general.TXT_descripcion.setText("");
            }
        } catch (Exception e) {
        }
    }

    ActionListener Listener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == lo_pnl_salir.BTN_salir) {
                evt_salir();
            }
            if (ae.getSource() == lo_pnl_opciones_1.BTN_editar) {
                evt_editar();
            }
            if (ae.getSource() == lo_pnl_opciones_1.BTN_cancelar) {
                evt_cancelar();
            }
            if (ae.getSource() == lo_pnl_opciones_1.BTN_guardar) {
                evt_guardar();
            }
        }
    };

    KeyListener KeyEvnt = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent ke) {

        }

        @Override
        public void keyPressed(KeyEvent ke) {
            if (ke.getKeyCode() == KeyEvent.VK_F3 && lo_pnl_opciones_1.BTN_editar.isEnabled()) {
                evt_editar();
            }
            if (ke.getKeyCode() == KeyEvent.VK_ESCAPE && lo_pnl_opciones_1.BTN_cancelar.isEnabled()) {
                evt_cancelar();
            }
            if (ke.getKeyCode() == KeyEvent.VK_F5) {
                if (ke.getSource() == lo_pnl_datos_general.TXT_ubigeo) {
                    evt_f5();
                }
            }
            if (ke.getKeyCode() == KeyEvent.VK_F6 && lo_pnl_opciones_1.BTN_guardar.isEnabled()) {
                evt_guardar();
            }

            if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                if (ke.getSource() == lo_pnl_opciones_1.BTN_editar) {
                    evt_editar();
                }
                if (ke.getSource() == lo_pnl_opciones_1.BTN_cancelar) {
                    evt_cancelar();
                }
                if (ke.getSource() == lo_pnl_opciones_1.BTN_guardar) {
                    evt_guardar();
                }
                if (ke.getSource() == lo_pnl_salir.BTN_salir) {
                    evt_salir();
                }
                if (ke.getSource() == lo_pnl_datos_general.TXT_ruc && go_fnc_operaciones_campos.cant_caracter(lo_pnl_datos_general.TXT_ruc.getText().trim(), 3,3)) {
                    lo_pnl_datos_general.TXT_razon_social.requestFocus();
                }
                if (ke.getSource() == lo_pnl_datos_general.TXT_razon_social && go_fnc_operaciones_campos.cant_caracter(lo_pnl_datos_general.TXT_razon_social.getText().trim(), 1, 4)) {
                    lo_pnl_datos_general.TXT_giro.requestFocus();
                }
                if (ke.getSource() == lo_pnl_datos_general.TXT_giro || ke.getSource() == lo_pnl_datos_general.TXT_direccion || ke.getSource() == lo_pnl_datos_general.TXT_telf || ke.getSource() == lo_pnl_datos_general.TXT_fax || ke.getSource() == lo_pnl_datos_general.TXT_email || ke.getSource() == lo_pnl_datos_general.TXT_website) {
                    getFocusOwner().transferFocus();
                }
                if (ke.getSource() == lo_pnl_datos_general.TXT_ubigeo && go_fnc_operaciones_campos.campo_blanco(lo_pnl_datos_general.TXT_ubigeo)) {
                    get_descripcion();
                }
                if (ke.getSource() == lo_pnl_datos_general.TXT_fecha_actividad && !lo_pnl_datos_general.TXT_fecha_actividad.getText().trim().equalsIgnoreCase("/  /")) {
                    if (go_fnc_operaciones_campos.valida_fecha(lo_pnl_datos_general.TXT_fecha_actividad.getText())) {
                        getFocusOwner().transferFocus();
                    } else {
                        lo_pnl_datos_general.TXT_fecha_actividad.setText("");
                        go_fnc_mensaje.GET_mensaje(0, ls_modulo, ls_capa, ls_clase, "keyPressed", "FORMATO DE FECHA INVALIDO ");
                    }
                }
                if (ke.getSource() == lo_pnl_datos_general.CBX_moneda) {
                    lo_pnl_opciones_1.BTN_guardar.requestFocus();
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

        PNL_opciones = new javax.swing.JPanel();
        PNL_datos = new javax.swing.JPanel();
        PNL_salir = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("DATOS GENERAL");
        setResizable(false);

        javax.swing.GroupLayout PNL_opcionesLayout = new javax.swing.GroupLayout(PNL_opciones);
        PNL_opciones.setLayout(PNL_opcionesLayout);
        PNL_opcionesLayout.setHorizontalGroup(
            PNL_opcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );
        PNL_opcionesLayout.setVerticalGroup(
            PNL_opcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout PNL_datosLayout = new javax.swing.GroupLayout(PNL_datos);
        PNL_datos.setLayout(PNL_datosLayout);
        PNL_datosLayout.setHorizontalGroup(
            PNL_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        PNL_datosLayout.setVerticalGroup(
            PNL_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 362, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout PNL_salirLayout = new javax.swing.GroupLayout(PNL_salir);
        PNL_salir.setLayout(PNL_salirLayout);
        PNL_salirLayout.setHorizontalGroup(
            PNL_salirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 171, Short.MAX_VALUE)
        );
        PNL_salirLayout.setVerticalGroup(
            PNL_salirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 112, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PNL_datos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PNL_opciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PNL_salir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 41, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PNL_salir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PNL_opciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PNL_datos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        new frm_datos_general().setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PNL_datos;
    private javax.swing.JPanel PNL_opciones;
    private javax.swing.JPanel PNL_salir;
    // End of variables declaration//GEN-END:variables
}
