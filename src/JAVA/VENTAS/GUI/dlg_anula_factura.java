package JAVA.VENTAS.GUI;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.ANCESTRO.GUI.pnl_aceptar_cancelar;
import JAVA.ANCESTRO.IMAGES.IMAGES_ruta_ancestro;
import JAVA.ANCESTRO.LOGICA.evt_aceptar_cancelar;
import JAVA.CONFIG.LOGICA.cbx_tipo_documento;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;

public class dlg_anula_factura extends javax.swing.JDialog {

    pnl_datos_anula_factura lo_pnl_datos_anula_factura = new pnl_datos_anula_factura();
    pnl_aceptar_cancelar lo_pnl_aceptar_cancelar = new pnl_aceptar_cancelar();
    evt_aceptar_cancelar lo_evt_aceptar_cancelar = new evt_aceptar_cancelar();
    cbx_tipo_documento lo_cbx_tipo_documento;
    ResultSet lq_rs;
    String ls_codigo_sucursal, ls_codigo_operacion;
    String ls_modulo = "VENTAS", ls_capa = "GUI", ls_clase = "dlg_anula_factura";

    public dlg_anula_factura(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        get_tipo_documento();
        formulario();
    }

    private void formulario() {
        lo_pnl_datos_anula_factura.setBounds(10, 10, 500, 160);
        lo_pnl_aceptar_cancelar.setBounds(70, 165, 200, 100);

        this.add(lo_pnl_datos_anula_factura);
        this.add(lo_pnl_aceptar_cancelar);

        ls_codigo_sucursal = gs_parametros[0];
        lo_pnl_datos_anula_factura.TXT_sucursal.setText(gs_parametros[1]);
        go_cbx_trato_datos.selecciona_valor(12, gs_parametros[2], lo_pnl_datos_anula_factura.CBX_tipo_doc);
        lo_pnl_datos_anula_factura.TXT_serie.setText(gs_parametros[3]);
        lo_pnl_datos_anula_factura.TXT_fecha_emision.setText(gs_parametros[4]);

        gs_parametros[0] = "";
        gs_parametros[1] = "";
        gs_parametros[2] = "";
        gs_parametros[3] = "";
        gs_parametros[4] = "";

        lo_pnl_datos_anula_factura.TXT_numero_doc.addKeyListener(KeyEvnt);
        lo_pnl_datos_anula_factura.TXT_fecha_emision.addKeyListener(KeyEvnt);
        lo_pnl_datos_anula_factura.TXT_motivo.addKeyListener(KeyEvnt);
        lo_evt_aceptar_cancelar.evento_click(lo_pnl_aceptar_cancelar, Listener);
        lo_evt_aceptar_cancelar.evento_press(lo_pnl_aceptar_cancelar, KeyEvnt);
    }

    private void get_tipo_documento() {
        lq_rs = go_dao_tipo_documento.SLT_cbx_tipo_documento("2");
        if (lq_rs != null) {
            go_cbx_trato_datos.recupera_valor(12, lq_rs, lo_pnl_datos_anula_factura.CBX_tipo_doc);
        }
    }

    private boolean valido_datos() {
        boolean resp = false;
        if (go_fnc_operaciones_campos.campo_blanco(lo_pnl_datos_anula_factura.TXT_numero_doc)) {
            lo_pnl_datos_anula_factura.TXT_numero_doc.setText(go_fnc_operaciones_campos.completa_digitos(lo_pnl_datos_anula_factura.TXT_numero_doc.getText().trim(), "0", 10));
            if (go_fnc_operaciones_campos.valida_fecha(lo_pnl_datos_anula_factura.TXT_fecha_emision.getText())) {
                if (go_fnc_operaciones_campos.valida_periodo(lo_pnl_datos_anula_factura.TXT_fecha_emision.getText(), gs_periodo)) {
                    if (go_fnc_operaciones_campos.campo_blanco(lo_pnl_datos_anula_factura.TXT_motivo)) {
                        resp = true;
                    } else {
                        go_fnc_mensaje.GET_mensaje(0, ls_modulo, ls_capa, ls_clase, "valido_datos", "INGRESE MOTIVO");
                        lo_pnl_datos_anula_factura.TXT_motivo.requestFocus();
                    }
                } else {
                    go_fnc_mensaje.GET_mensaje(0, ls_modulo, ls_capa, ls_clase, "valido_datos", "FECHA NO PERTENECE AL PERIODO");
                    lo_pnl_datos_anula_factura.TXT_fecha_emision.requestFocus();
                }
            } else {
                go_fnc_mensaje.GET_mensaje(0, ls_modulo, ls_capa, ls_clase, "valido_datos", "FORMATO DE FECHA INVALIDO");
                lo_pnl_datos_anula_factura.TXT_fecha_emision.requestFocus();
            }
        } else {
            go_fnc_mensaje.GET_mensaje(0, ls_modulo, ls_capa, ls_clase, "valido_datos", "INGRESE NUMERO DOCUMENTO");
            lo_pnl_datos_anula_factura.TXT_numero_doc.requestFocus();
        }
        return resp;
    }

    private void evt_aceptar() {
        if (valido_datos()) {
            lo_cbx_tipo_documento = (cbx_tipo_documento) lo_pnl_datos_anula_factura.CBX_tipo_doc.getSelectedItem();
            ls_codigo_operacion = lo_cbx_tipo_documento.getID() + lo_pnl_datos_anula_factura.TXT_serie.getText().trim() + lo_pnl_datos_anula_factura.TXT_numero_doc.getText().trim();

            if (lo_cbx_tipo_documento.getID().equalsIgnoreCase("09")) {
                if (go_dao_guia_remision.SLT_cta_gr_x_documento(ls_codigo_sucursal, lo_cbx_tipo_documento.getID(), lo_pnl_datos_anula_factura.TXT_serie.getText(), lo_pnl_datos_anula_factura.TXT_numero_doc.getText()) == 0) {
                    String SQL = "select * from ist_guia_remision('" + ls_codigo_operacion + "','" + ls_codigo_sucursal + "','" + gs_periodo + "','" + lo_pnl_datos_anula_factura.TXT_fecha_emision.getText().trim().substring(3, 5) + "','" + lo_cbx_tipo_documento.getID() + "','" + lo_pnl_datos_anula_factura.TXT_serie.getText() + "','" + lo_pnl_datos_anula_factura.TXT_numero_doc.getText().trim() + "','" + lo_pnl_datos_anula_factura.TXT_fecha_emision.getText().trim() + "','0','0','OP00000000000000','..','0000','0000000000','PEN',0.000,'1','0001','000',0.000,'0','0','1','999999','...','1','...','','999999','...','999999','...','0001','...','EF',0,'" + lo_pnl_datos_anula_factura.TXT_motivo.getText().trim() + "','0','0001','...','...','...','...........','AAA999','...','....','000000','...','...','...','...','...','999999','....',0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,'" + gs_periodo + "')";
                    try {
                        if (go_dao_guia_remision.IST_anula_guia_remision(SQL, ls_codigo_operacion)) {
                            dispose();
                        }
                    } catch (Exception e) {
                    }
                } else {
                    go_fnc_mensaje.GET_mensaje(0, ls_modulo, ls_capa, ls_clase, "evt_aceptar", "DOCUMENTO SE ENCUENTRA REGISTRADO");
                    lo_pnl_datos_anula_factura.TXT_numero_doc.requestFocus();
                }
            } else if (go_dao_registro_ventas.SLT_cta_rv_x_documento(ls_codigo_sucursal, lo_cbx_tipo_documento.getID(), lo_pnl_datos_anula_factura.TXT_serie.getText(), lo_pnl_datos_anula_factura.TXT_numero_doc.getText()) == 0) {

                String SQL = "select * from ist_registro_ventas('" + ls_codigo_operacion + "','" + ls_codigo_sucursal + "','" + gs_periodo + "','" + lo_pnl_datos_anula_factura.TXT_fecha_emision.getText().trim().substring(3, 5) + "','" + lo_cbx_tipo_documento.getID() + "','" + lo_pnl_datos_anula_factura.TXT_serie.getText() + "','" + lo_pnl_datos_anula_factura.TXT_numero_doc.getText().trim() + "','" + lo_pnl_datos_anula_factura.TXT_fecha_emision.getText().trim() + "','" + lo_pnl_datos_anula_factura.TXT_fecha_emision.getText().trim() + "','PEN',0.000,'1','0001','000',0.000,'0','0','0','999999','....','1','........','...','999999','....','999999','......','....','....','EF',0,'" + lo_pnl_datos_anula_factura.TXT_motivo.getText().trim() + "','0',0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,'0','GR00000000000000','0','OP00000000000000','" + lo_pnl_datos_anula_factura.TXT_fecha_emision.getText() + "','..','','','0','','" + gs_periodo + "')";
                try {
                    if (go_dao_registro_ventas.IST_anula_registro_ventas(SQL, ls_codigo_operacion)) {
                        dispose();
                    }
                } catch (Exception e) {
                }
            } else {
                go_fnc_mensaje.GET_mensaje(0, ls_modulo, ls_capa, ls_clase, "evt_aceptar", "DOCUMENTO SE ENCUENTRA REGISTRADO");
                lo_pnl_datos_anula_factura.TXT_numero_doc.requestFocus();
            }
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
            if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                if (ke.getSource() == lo_pnl_datos_anula_factura.TXT_numero_doc) {
                    if (go_fnc_operaciones_campos.campo_blanco(lo_pnl_datos_anula_factura.TXT_numero_doc)) {
                        lo_pnl_datos_anula_factura.TXT_numero_doc.setText(go_fnc_operaciones_campos.completa_digitos(lo_pnl_datos_anula_factura.TXT_numero_doc.getText().trim(), "0", 10));
                        lo_pnl_datos_anula_factura.TXT_fecha_emision.requestFocus();
                    }
                }
                if (ke.getSource() == lo_pnl_datos_anula_factura.TXT_fecha_emision && !lo_pnl_datos_anula_factura.TXT_fecha_emision.getText().trim().equalsIgnoreCase("/  /")) {
                    if (go_fnc_operaciones_campos.valida_fecha(lo_pnl_datos_anula_factura.TXT_fecha_emision.getText())) {
                        if (lo_pnl_datos_anula_factura.TXT_fecha_emision.getText().trim().substring(6, 10).equalsIgnoreCase(gs_periodo)) {
                            getFocusOwner().transferFocus();
                        } else {
                            lo_pnl_datos_anula_factura.TXT_fecha_emision.setText("");
                            go_fnc_mensaje.GET_mensaje(0, ls_modulo, ls_capa, ls_clase, "keyPressed", "FECHA NO PERTENECE AL PERIODO");
                        }
                    } else {
                        lo_pnl_datos_anula_factura.TXT_fecha_emision.setText("");
                        go_fnc_mensaje.GET_mensaje(0, ls_modulo, ls_capa, ls_clase, "keyPressed", "FORMATO DE FECHA INVALIDO");
                    }
                }
                if (ke.getSource() == lo_pnl_datos_anula_factura.TXT_motivo) {
                    lo_pnl_aceptar_cancelar.BTN_aceptar.requestFocus();
                }
                if (ke.getSource() == lo_pnl_aceptar_cancelar.BTN_cancelar) {
                    dispose();
                }
                if (ke.getSource() == lo_pnl_aceptar_cancelar.BTN_aceptar) {
                    evt_aceptar();
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent ke) {
        }
    };

    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(IMAGES_ruta_ancestro.class.getResource("anular_doc.png"));
        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ANULAR");
        setIconImage(getIconImage());
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 347, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 222, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dlg_anula_factura dialog = new dlg_anula_factura(new javax.swing.JFrame(), true);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
