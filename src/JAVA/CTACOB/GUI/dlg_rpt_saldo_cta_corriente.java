package JAVA.CTACOB.GUI;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.ANCESTRO.GUI.pnl_aceptar_cancelar;
import JAVA.ANCESTRO.IMAGES.IMAGES_ruta_ancestro;
import JAVA.ANCESTRO.LOGICA.evt_aceptar_cancelar;
import JAVA.INVENT.GUI.dlg_almacen_x_permiso;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.swing.JTextField;
import net.sf.jasperreports.engine.JRParameter;

public class dlg_rpt_saldo_cta_corriente extends javax.swing.JDialog {

    pnl_rpt_saldo_cta_corriente lo_pnl_rpt_saldo_cta_corriente = new pnl_rpt_saldo_cta_corriente();
    pnl_aceptar_cancelar lo_pnl_aceptar_cancelar = new pnl_aceptar_cancelar();
    evt_aceptar_cancelar lo_evt_aceptar_cancelar = new evt_aceptar_cancelar();
    ResultSet lq_rs;
    String ls_codigo, ls_nombre;
    String ls_modulo = "CTACOB", ls_capa = "GUI", ls_clase = "dlg_rpt_saldo_cta_corriente";

    public dlg_rpt_saldo_cta_corriente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        formulario();
    }

    private void formulario() {
        lo_pnl_rpt_saldo_cta_corriente.setBounds(10, 10, 450, 135);
        lo_pnl_aceptar_cancelar.setBounds(120, 135, 200, 50);

        this.add(lo_pnl_rpt_saldo_cta_corriente);
        this.add(lo_pnl_aceptar_cancelar);

        lo_pnl_rpt_saldo_cta_corriente.TXT_fecha_ini.setText("01" + "01" + gs_periodo);
        lo_pnl_rpt_saldo_cta_corriente.TXT_fecha_fin.setText(gs_dia + gs_mes + gs_periodo);

        lo_pnl_rpt_saldo_cta_corriente.CBX_filtro.addItemListener(ItemEvent);
        lo_pnl_rpt_saldo_cta_corriente.CBX_filtro.addKeyListener(KeyEvnt);
        lo_pnl_rpt_saldo_cta_corriente.CBX_tipo.addKeyListener(KeyEvnt);
        lo_pnl_rpt_saldo_cta_corriente.TXT_codigo.addKeyListener(KeyEvnt);
        lo_pnl_rpt_saldo_cta_corriente.TXT_codigo_vc.addKeyListener(KeyEvnt);
        lo_pnl_rpt_saldo_cta_corriente.TXT_fecha_fin.addKeyListener(KeyEvnt);
        lo_evt_aceptar_cancelar.evento_click(lo_pnl_aceptar_cancelar, Listener);
        lo_evt_aceptar_cancelar.evento_press(lo_pnl_aceptar_cancelar, KeyEvnt);
    }

    private void get_descripcion_sucursal(String codigo) {
        try {
            lq_rs = go_dao_usuario_permisos.SLT_grid_almacen_x_permiso(gi_id_usuario, "2", "1", codigo);
            if (lq_rs != null) {
                lo_pnl_rpt_saldo_cta_corriente.TXT_codigo.setText(lq_rs.getString(1));
                lo_pnl_rpt_saldo_cta_corriente.TXT_nombre.setText(lq_rs.getString(2));
            } else {
                go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "get_descripcion_sucursal", "USUARIO SIN PERMISOS y/o SUCURSAL NO EXISTE");
                lo_pnl_rpt_saldo_cta_corriente.TXT_codigo.setText("");
                lo_pnl_rpt_saldo_cta_corriente.TXT_nombre.setText("");
                lo_pnl_rpt_saldo_cta_corriente.TXT_codigo.requestFocus();
            }
        } catch (Exception e) {
        }
    }

    private boolean valida_fecha(JTextField fecha) {
        boolean resp = false;
        if (go_fnc_operaciones_campos.valida_fecha(fecha.getText())) {
            if (fecha.getText().trim().substring(6, 10).equalsIgnoreCase(gs_periodo)) {
                resp = true;
            } else {
                fecha.setText("");
                go_fnc_mensaje.GET_mensaje(0, ls_modulo, ls_capa, ls_clase, "keyPressed", "FECHA NO PERTENECE AL PERIODO");
            }
        } else {
            fecha.setText("");
            go_fnc_mensaje.GET_mensaje(0, ls_modulo, ls_capa, ls_clase, "keyPressed", "FORMATO DE FECHA INVALIDO");
        }
        return resp;
    }

    private boolean valida_campos() {
        boolean resp = false;
        if (go_fnc_operaciones_campos.campo_blanco(lo_pnl_rpt_saldo_cta_corriente.TXT_codigo) && go_fnc_operaciones_campos.campo_blanco(lo_pnl_rpt_saldo_cta_corriente.TXT_nombre)) {
            if (valida_fecha(lo_pnl_rpt_saldo_cta_corriente.TXT_fecha_fin)) {
                resp = true;
            }
        } else {
            go_fnc_mensaje.GET_mensaje(0, ls_modulo, ls_capa, ls_clase, "valida_campos", "INGRESE SUCURSAL");
            lo_pnl_rpt_saldo_cta_corriente.TXT_codigo.requestFocus();
        }
        return resp;
    }

    private void muestra_rpt() {
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("empresa", go_bean_general.getNombre_reporte());
        parametros.put("usuario", gs_datos_usuario);
        parametros.put("sucursal", lo_pnl_rpt_saldo_cta_corriente.TXT_codigo.getText());
        parametros.put("fecha_ini", go_fnc_operaciones_campos.formarto_date(lo_pnl_rpt_saldo_cta_corriente.TXT_fecha_ini.getText()));
        parametros.put("fecha_fin", go_fnc_operaciones_campos.formarto_date(lo_pnl_rpt_saldo_cta_corriente.TXT_fecha_fin.getText()));
        parametros.put("periodo", gs_periodo);
        parametros.put("nombre_sucursal", lo_pnl_rpt_saldo_cta_corriente.TXT_nombre.getText().trim());
        parametros.put("codigo_pagador", (lo_pnl_rpt_saldo_cta_corriente.CBX_filtro.getSelectedIndex() == 1) ? lo_pnl_rpt_saldo_cta_corriente.TXT_codigo_vc.getText().trim() : "%");
        parametros.put("codigo_vendedor", (lo_pnl_rpt_saldo_cta_corriente.CBX_filtro.getSelectedIndex() == 2) ? lo_pnl_rpt_saldo_cta_corriente.TXT_codigo_vc.getText().trim() : "%");
        parametros.put("tipo", lo_pnl_rpt_saldo_cta_corriente.CBX_tipo.getSelectedIndex()+"");
        parametros.put("fecha_vence", (lo_pnl_rpt_saldo_cta_corriente.CBX_tipo.getSelectedIndex()==0)?go_fnc_operaciones_campos.formarto_date("01/01/2099"):go_fnc_operaciones_campos.formarto_date(lo_pnl_rpt_saldo_cta_corriente.TXT_fecha_fin.getText()));
        parametros.put(JRParameter.REPORT_LOCALE, Locale.ENGLISH);

        go_muestra_reporte_ctacob.reporte_pestania("rpt_saldo_cta_corriente.jasper", parametros, "SALDO CTA CORRIENTE", 0);

    }

    private void evt_f5() {
        gs_parametros[0] = "2";
        go_dlg_almacen_x_permiso = new dlg_almacen_x_permiso(null, true);
        go_dlg_almacen_x_permiso.setVisible(true);
        ls_codigo = go_dlg_almacen_x_permiso.ls_codigo_almacen;
        gs_parametros[0] = "";
        if (ls_codigo != null) {
            get_descripcion_sucursal(ls_codigo);
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_f5", "SELECCIONE SUCURSAL");
        }
    }

    private void evt_aceptar() {
        if (valida_campos()) {
            muestra_rpt();
            dispose();
        }
    }

    ActionListener Listener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == lo_pnl_aceptar_cancelar.BTN_cancelar) {
                dispose();
            }
            if (ae.getSource() == lo_pnl_aceptar_cancelar.BTN_aceptar) {
                evt_aceptar();
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
                if (ke.getSource() == lo_pnl_rpt_saldo_cta_corriente.TXT_codigo) {
                    evt_f5();
                }
                if (ke.getSource() == lo_pnl_rpt_saldo_cta_corriente.TXT_codigo_vc) {
                    switch (lo_pnl_rpt_saldo_cta_corriente.CBX_filtro.getSelectedIndex()) {
                        case 1:
                            go_activa_buscador.busq_entidad(lo_pnl_rpt_saldo_cta_corriente.TXT_codigo_vc, lo_pnl_rpt_saldo_cta_corriente.TXT_nombre_vc);
                            break;
                        case 2:
                            go_activa_buscador.busq_vendedor(lo_pnl_rpt_saldo_cta_corriente.TXT_codigo_vc, lo_pnl_rpt_saldo_cta_corriente.TXT_nombre_vc);
                            break;
                    }
                }
            }
            if (ke.getKeyCode() == KeyEvent.VK_ESCAPE) {
                dispose();
            }
            if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                if (ke.getSource() == lo_pnl_rpt_saldo_cta_corriente.TXT_codigo && go_fnc_operaciones_campos.campo_blanco(lo_pnl_rpt_saldo_cta_corriente.TXT_codigo)) {
                    lo_pnl_rpt_saldo_cta_corriente.TXT_codigo.setText(go_fnc_operaciones_campos.completa_digitos(lo_pnl_rpt_saldo_cta_corriente.TXT_codigo.getText().trim(), "0", 4));
                    getFocusOwner().transferFocus();
                    get_descripcion_sucursal(lo_pnl_rpt_saldo_cta_corriente.TXT_codigo.getText().trim());
                }
                if (ke.getSource() == lo_pnl_rpt_saldo_cta_corriente.TXT_fecha_fin && !lo_pnl_rpt_saldo_cta_corriente.TXT_fecha_fin.getText().trim().equalsIgnoreCase("/  /")) {
                    if (valida_fecha(lo_pnl_rpt_saldo_cta_corriente.TXT_fecha_fin)) {
                        getFocusOwner().transferFocus();
                    }
                }
                if (ke.getSource() == lo_pnl_rpt_saldo_cta_corriente.CBX_filtro) {
                    getFocusOwner().transferFocus();
                }
                if (ke.getSource() == lo_pnl_rpt_saldo_cta_corriente.TXT_codigo_vc) {
                    getFocusOwner().transferFocus();
                    switch (lo_pnl_rpt_saldo_cta_corriente.CBX_filtro.getSelectedIndex()) {
                        case 1:
                            if (go_fnc_operaciones_campos.cant_caracter(lo_pnl_rpt_saldo_cta_corriente.TXT_codigo_vc.getText().trim(), 4, 6)) {
                                go_activa_buscador.get_descripcion_entidad(lo_pnl_rpt_saldo_cta_corriente.TXT_codigo_vc.getText().trim(), lo_pnl_rpt_saldo_cta_corriente.TXT_codigo_vc, lo_pnl_rpt_saldo_cta_corriente.TXT_nombre_vc);
                            }
                            break;
                        case 2:
                            if (go_fnc_operaciones_campos.cant_caracter(lo_pnl_rpt_saldo_cta_corriente.TXT_codigo_vc.getText().trim(), 4, 4)) {
                                go_activa_buscador.get_descripcion_vendedor(lo_pnl_rpt_saldo_cta_corriente.TXT_codigo_vc.getText().trim(), lo_pnl_rpt_saldo_cta_corriente.TXT_codigo_vc, lo_pnl_rpt_saldo_cta_corriente.TXT_nombre_vc);
                            }
                            break;
                    }
                }
                if(ke.getSource() == lo_pnl_rpt_saldo_cta_corriente.CBX_tipo){
                    getFocusOwner().transferFocus();
                }
                if (ke.getSource() == lo_pnl_aceptar_cancelar.BTN_aceptar) {
                    evt_aceptar();
                }
                if (ke.getSource() == lo_pnl_aceptar_cancelar.BTN_cancelar) {
                    dispose();
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent ke) {

        }

    };

    ItemListener ItemEvent = new ItemListener() {
        @Override
        public void itemStateChanged(java.awt.event.ItemEvent ie) {
            if (ie.getSource() == lo_pnl_rpt_saldo_cta_corriente.CBX_filtro) {
                if (lo_pnl_rpt_saldo_cta_corriente.CBX_filtro.getSelectedIndex() == 0) {
                    lo_pnl_rpt_saldo_cta_corriente.TXT_codigo_vc.setText("");
                    lo_pnl_rpt_saldo_cta_corriente.TXT_nombre_vc.setText("");
                    lo_pnl_rpt_saldo_cta_corriente.TXT_codigo_vc.setEnabled(false);
                } else {
                    lo_pnl_rpt_saldo_cta_corriente.TXT_codigo_vc.setText("");
                    lo_pnl_rpt_saldo_cta_corriente.TXT_nombre_vc.setText("");
                    lo_pnl_rpt_saldo_cta_corriente.TXT_codigo_vc.setEnabled(true);
                }
            }
        }
    };

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("PARAMETROS");
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dlg_rpt_saldo_cta_corriente dialog = new dlg_rpt_saldo_cta_corriente(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(IMAGES_ruta_ancestro.class.getResource("parametros.png"));
        return retValue;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
