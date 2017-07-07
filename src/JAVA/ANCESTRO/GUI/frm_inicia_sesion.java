package JAVA.ANCESTRO.GUI;

import JAVA.ANCESTRO.BEAN.BEAN_periodo_empresa;
import JAVA.ANCESTRO.IMAGES.IMAGES_ruta_ancestro;
import JAVA.ANCESTRO.LOGICA.cbx_empresa;
import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.CONFIG.BEAN.BEAN_usuario;
import JAVA.CONFIG.GUI.frm_datos_general;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import javax.swing.DefaultComboBoxModel;

public class frm_inicia_sesion extends javax.swing.JFrame {

    pnl_aceptar_cancelar lo_pnl_aceptar_cancelar = new pnl_aceptar_cancelar();
    pnl_inicia_sesion lo_pnl_inicia_sesion = new pnl_inicia_sesion();
    BEAN_periodo_empresa lo_bean_periodo_empresa = new BEAN_periodo_empresa();
    BEAN_usuario lo_bean_usuario = new BEAN_usuario();
    ResultSet lq_rs = null;
    DefaultComboBoxModel lo_model_empresa = null;
    cbx_empresa lo_cbx_empresa = null;
    String ls_usuario, ls_clave;
    String ls_modulo = "ANCESTRO", ls_capa = "GUI", ls_clase = "frm_inicia_sesion";

    public frm_inicia_sesion() {        
        initComponents();
        formulario();
        get_empresa();
    }

    private void formulario() {
        lo_pnl_aceptar_cancelar.setBounds(30, 0, 200, 50);
        lo_pnl_inicia_sesion.setBounds(0, 10, 260, 140);
        PNL_aceptar_cancelar.add(lo_pnl_aceptar_cancelar);
        PNL_datos_sesion.add(lo_pnl_inicia_sesion);

        lo_pnl_aceptar_cancelar.BTN_aceptar.addActionListener(listener);
        lo_pnl_aceptar_cancelar.BTN_cancelar.addActionListener(listener);
        lo_pnl_inicia_sesion.CBX_empresa.addActionListener(listener);

        lo_pnl_inicia_sesion.CBX_empresa.addKeyListener(KeyEvnt);
        lo_pnl_inicia_sesion.CBX_periodo.addKeyListener(KeyEvnt);
        lo_pnl_inicia_sesion.TXT_usuario.addKeyListener(KeyEvnt);
        lo_pnl_inicia_sesion.TXT_clave.addKeyListener(KeyEvnt);
        lo_pnl_aceptar_cancelar.BTN_aceptar.addKeyListener(KeyEvnt);
        lo_pnl_aceptar_cancelar.BTN_cancelar.addKeyListener(KeyEvnt);
    }

    private void get_empresa() {
        lq_rs = go_dao_registro_empresa.SLT_datos();
        if (lq_rs != null) {
            try {
                lo_model_empresa = new DefaultComboBoxModel();
                do {
                    lo_model_empresa.addElement(new cbx_empresa(lq_rs.getInt(1), lq_rs.getString(3), lq_rs.getString(2)));
                } while (lq_rs.next());
                lo_pnl_inicia_sesion.CBX_empresa.setModel(lo_model_empresa);
                get_anio();
            } catch (Exception e) {
            }
        }
    }

    private void get_anio() {
        lo_pnl_inicia_sesion.CBX_periodo.removeAllItems();
        lo_cbx_empresa = (cbx_empresa) lo_pnl_inicia_sesion.CBX_empresa.getSelectedItem();
        gi_codigo_empresa = lo_cbx_empresa.getID();

        lo_bean_periodo_empresa.setCodigo_empresa(gi_codigo_empresa);
        lq_rs = go_dao_periodo_empresa.SLT_datos_x_empresa(lo_bean_periodo_empresa);

        if (lq_rs != null) {
            try {
                do {
                    lo_pnl_inicia_sesion.CBX_periodo.addItem(lq_rs.getString(1));
                } while (lq_rs.next());
            } catch (Exception e) {
            }
        }
    }

    ActionListener listener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == lo_pnl_aceptar_cancelar.BTN_aceptar) {
                evt_aceptar();
            }
            if (ae.getSource() == lo_pnl_aceptar_cancelar.BTN_cancelar) {
                go_fnc_cierra_sistema.cierra_sistema();
            }
            if (ae.getSource() == lo_pnl_inicia_sesion.CBX_empresa) {
                get_anio();
            }
        }
    };

    KeyListener KeyEvnt = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent ke) {
        }

        @Override
        public void keyPressed(KeyEvent ke) {
            if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                if (ke.getSource() == lo_pnl_inicia_sesion.CBX_empresa) {
                    get_anio();
                    lo_pnl_inicia_sesion.CBX_periodo.requestFocus();
                }
                if (ke.getSource() == lo_pnl_inicia_sesion.CBX_periodo) {
                    lo_pnl_inicia_sesion.TXT_usuario.requestFocus();
                }
                if (ke.getSource() == lo_pnl_inicia_sesion.TXT_usuario && go_fnc_operaciones_campos.campo_blanco(lo_pnl_inicia_sesion.TXT_usuario)) {
                    lo_pnl_inicia_sesion.TXT_clave.requestFocus();
                }
                if (ke.getSource() == lo_pnl_inicia_sesion.TXT_clave && go_fnc_operaciones_campos.campo_blanco(lo_pnl_inicia_sesion.TXT_clave)) {
                    lo_pnl_aceptar_cancelar.BTN_aceptar.requestFocus();
                }
                if (ke.getSource() == lo_pnl_aceptar_cancelar.BTN_aceptar) {
                    evt_aceptar();
                }
                if (ke.getSource() == lo_pnl_aceptar_cancelar.BTN_cancelar) {
                    go_fnc_cierra_sistema.cierra_sistema();
                }
            }
            if (ke.getKeyCode() == KeyEvent.VK_ESCAPE) {
                go_fnc_cierra_sistema.cierra_sistema();
            }
        }

        @Override
        public void keyReleased(KeyEvent ke) {
        }
    };

    private void evt_aceptar() {
        gs_periodo = lo_pnl_inicia_sesion.CBX_periodo.getSelectedItem().toString();
        gs_base_datos = lo_cbx_empresa.base_datos();

        if (go_fnc_operaciones_campos.campo_blanco(lo_pnl_inicia_sesion.TXT_usuario)) {
            if (go_fnc_operaciones_campos.campo_blanco(lo_pnl_inicia_sesion.TXT_clave)) {

                ls_usuario = go_fnc_operaciones_campos.get_campo_str(lo_pnl_inicia_sesion.TXT_usuario);
                ls_clave = go_fnc_operaciones_campos.get_campo_str(lo_pnl_inicia_sesion.TXT_clave);
                ls_clave = go_fnc_operaciones_campos.encriptar(ls_clave);

                lo_bean_usuario.setNombre_usuario(ls_usuario);
                lo_bean_usuario.setClave_usuario(ls_clave);

                lq_rs = go_dao_usuario.SLT_login_usuario(lo_bean_usuario);

                /*  NO EXISTE USUARIO = 0
                    EXISTE USUARIO = 1
                    EXISTE PERO NO ESTA ACTIVO = 2
                    EXISRE PERO NO TIENE EMPRESA = 3*/
                try {
                    switch (lq_rs.getInt(1)) {
                        case 0:
                            limpia_campos();
                            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_aceptar", "USUARIO y/o CONTRASEÑA INCORRECTOS");
                            break;
                        case 1:
                            this.dispose();

                            gi_id_usuario = lq_rs.getInt(2);
                            gs_nombre_usuario = lq_rs.getString(3);
                            gs_datos_usuario = lq_rs.getString(4);
                            gi_id_rol = lq_rs.getInt(5);
                            gs_nombre_rol = lq_rs.getString(7);

                            go_frm_principal = new frm_principal();
                            go_frm_principal.setVisible(true);

                            break;
                        case 2:
                            limpia_campos();
                            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_aceptar", "USUARIO BLOQUEADO");
                            break;
                        case 3:
                            this.dispose();

                            gi_id_usuario = lq_rs.getInt(2);
                            gs_nombre_usuario = lq_rs.getString(3);
                            gs_datos_usuario = lq_rs.getString(4);
                            gi_id_rol = lq_rs.getInt(5);
                            gs_nombre_rol = lq_rs.getString(7);

                            go_frm_datos_general = new frm_datos_general();
                            go_frm_datos_general.setVisible(true);
                            break;
                    }

                } catch (Exception e) {
                    go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_aceptar", e.getMessage());
                }

            } else {
                go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_aceptar", "INGRESE CONTRASEÑA");
                go_fnc_operaciones_campos.get_focus(lo_pnl_inicia_sesion.TXT_clave);
            }
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_aceptar", "INGRESE USUARIO");
            go_fnc_operaciones_campos.get_focus(lo_pnl_inicia_sesion.TXT_usuario);
        }
    }

    private void limpia_campos() {
        go_fnc_operaciones_campos.set_campo_vacio(lo_pnl_inicia_sesion.TXT_clave);
        go_fnc_operaciones_campos.set_campo_vacio(lo_pnl_inicia_sesion.TXT_usuario);
        go_fnc_operaciones_campos.get_focus(lo_pnl_inicia_sesion.TXT_usuario);
    }
    
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(IMAGES_ruta_ancestro.class.getResource("login.png"));       
        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PNL_aceptar_cancelar = new javax.swing.JPanel();
        PNL_datos_sesion = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setIconImage(getIconImage());
        setResizable(false);

        PNL_aceptar_cancelar.setPreferredSize(new java.awt.Dimension(184, 45));

        javax.swing.GroupLayout PNL_aceptar_cancelarLayout = new javax.swing.GroupLayout(PNL_aceptar_cancelar);
        PNL_aceptar_cancelar.setLayout(PNL_aceptar_cancelarLayout);
        PNL_aceptar_cancelarLayout.setHorizontalGroup(
            PNL_aceptar_cancelarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 278, Short.MAX_VALUE)
        );
        PNL_aceptar_cancelarLayout.setVerticalGroup(
            PNL_aceptar_cancelarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 58, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout PNL_datos_sesionLayout = new javax.swing.GroupLayout(PNL_datos_sesion);
        PNL_datos_sesion.setLayout(PNL_datos_sesionLayout);
        PNL_datos_sesionLayout.setHorizontalGroup(
            PNL_datos_sesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 278, Short.MAX_VALUE)
        );
        PNL_datos_sesionLayout.setVerticalGroup(
            PNL_datos_sesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 142, Short.MAX_VALUE)
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/JAVA/ANCESTRO/IMAGES/inicio.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 278, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(14, 14, 14)
                    .addComponent(jLabel1)
                    .addContainerGap(14, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 272, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jLabel11.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(153, 153, 153));
        jLabel11.setText("Designed and Created by CaDm - Copyright © Todos los Derechos Reservados");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 153));
        jLabel2.setText("BIENVENIDO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PNL_aceptar_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PNL_datos_sesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PNL_datos_sesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(PNL_aceptar_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jLabel11)
                .addGap(0, 15, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        new frm_inicia_sesion().setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PNL_aceptar_cancelar;
    private javax.swing.JPanel PNL_datos_sesion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
