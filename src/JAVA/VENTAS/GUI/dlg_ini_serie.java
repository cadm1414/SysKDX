package JAVA.VENTAS.GUI;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.ANCESTRO.GUI.pnl_aceptar_cancelar;
import JAVA.ANCESTRO.IMAGES.IMAGES_ruta_ancestro;
import JAVA.ANCESTRO.LOGICA.evt_aceptar_cancelar;
import JAVA.CTACOB.GUI.jif_recibo_cobranza;
import JAVA.INVENT.GUI.dlg_almacen_x_permiso;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;

public class dlg_ini_serie extends javax.swing.JDialog {

    pnl_ini_serie lo_pnl_ini_serie = new pnl_ini_serie();
    pnl_aceptar_cancelar lo_pnl_aceptar_cancelar = new pnl_aceptar_cancelar();
    evt_aceptar_cancelar lo_evt_aceptar_cancelar = new evt_aceptar_cancelar();
    ResultSet lq_rs;
    String ls_codigo, ls_nombre, ls_tipo_documento;
    String ls_modulo = "VENTAS", ls_capa = "GUI", ls_clase = "dlg_ini_serie";

    public dlg_ini_serie(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        formulario();
    }

    private void formulario() {
        lo_pnl_ini_serie.setBounds(10, 10, 500, 100);
        lo_pnl_aceptar_cancelar.setBounds(100, 100, 200, 50);

        ls_tipo_documento = gs_parametros[0];

        this.add(lo_pnl_ini_serie);
        this.add(lo_pnl_aceptar_cancelar);

        lo_pnl_ini_serie.TXT_codigo.addKeyListener(KeyEvnt);
        lo_pnl_ini_serie.CBX_serie.addKeyListener(KeyEvnt);
        lo_evt_aceptar_cancelar.evento_click(lo_pnl_aceptar_cancelar, Listener);
        lo_evt_aceptar_cancelar.evento_press(lo_pnl_aceptar_cancelar, KeyEvnt);
    }

    private void limpia_datos() {
        lo_pnl_ini_serie.TXT_codigo.setText("");
        lo_pnl_ini_serie.TXT_nombre.setText("");
        lo_pnl_ini_serie.CBX_serie.removeAllItems();
        lo_pnl_ini_serie.TXT_codigo.requestFocus();
    }

    private void get_serie(String codigo) {
        lo_pnl_ini_serie.CBX_serie.removeAllItems();
        try {
            lq_rs = go_dao_serie.SLT_cbx_serie(codigo);
            if (lq_rs != null) {
                do {
                    lo_pnl_ini_serie.CBX_serie.addItem(lq_rs.getString(1));
                } while (lq_rs.next());
                if(!gs_tipo_comercio.equalsIgnoreCase("3")){
                    lo_pnl_ini_serie.CBX_serie.setSelectedItem("9999");
                }
            } else {
                go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "get_serie", "SUCURSAL NO CUENTA CON SERIE");
                limpia_datos();
            }
        } catch (Exception e) {
        }
    }

    private void get_descripcion_sucursal(String codigo) {
        try {
            lq_rs = go_dao_usuario_permisos.SLT_grid_almacen_x_permiso(gi_id_usuario, "2", "1", codigo);
            if (lq_rs != null) {
                lo_pnl_ini_serie.TXT_codigo.setText(lq_rs.getString(1));
                lo_pnl_ini_serie.TXT_nombre.setText(lq_rs.getString(2));
                gs_parametros[0] = lq_rs.getString(1);
                gs_parametros[1] = lq_rs.getString(2);
                gs_parametros[3] = ls_tipo_documento;
                get_serie(codigo);
            } else {
                go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "get_descripcion_sucursal", "USUARIO SIN PERMISOS y/o SUCURSAL NO EXISTE");
                limpia_datos();
            }
        } catch (Exception e) {
        }
    }

    private void muestra_jif() {
        if (go_fnc_operaciones_campos.campo_blanco(lo_pnl_ini_serie.TXT_codigo)) {
            switch (gi_parametros_2[0]) {
                case 0:
                    go_jif_pedido = new jif_pedido();
                    go_frm_principal.JDP_principal.add(go_jif_pedido);
                    go_jif_pedido.show();
                    break;
                case 1:
                    go_jif_factura = new jif_factura();
                    go_frm_principal.JDP_principal.add(go_jif_factura);
                    go_jif_factura.show();
                    break;
                case 2:
                    go_jif_boleta = new jif_factura();
                    go_frm_principal.JDP_principal.add(go_jif_boleta);
                    go_jif_boleta.show();
                    break;
                case 3:
                    go_jif_guia_remision = new jif_guia_remision();
                    go_frm_principal.JDP_principal.add(go_jif_guia_remision);
                    go_jif_guia_remision.show();
                    break;
                case 4:
                    go_jif_recibo_cobranza = new jif_recibo_cobranza();
                    go_frm_principal.JDP_principal.add(go_jif_recibo_cobranza);
                    go_jif_recibo_cobranza.show();
                    break;
                case 5:
                    go_jif_nota_credito = new jif_nota_credito();
                    go_frm_principal.JDP_principal.add(go_jif_nota_credito);
                    go_jif_nota_credito.show();
                    break;
            }
            gi_parametros_2[0] = 0;
            dispose();
        } else {
            limpia_datos();
        }
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
            limpia_datos();
        }
    }

    private void evt_aceptar() {
        if (lo_pnl_ini_serie.CBX_serie.getItemCount() > 0) {
            gs_parametros[2] = lo_pnl_ini_serie.CBX_serie.getSelectedItem().toString();
            get_descripcion_sucursal(lo_pnl_ini_serie.TXT_codigo.getText().trim());
            muestra_jif();
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_aceptar", "SELECCIONE SUCURSAL");
            limpia_datos();
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
                if (ke.getSource() == lo_pnl_ini_serie.TXT_codigo) {
                    evt_f5();
                }
            }
            if (ke.getKeyCode() == KeyEvent.VK_ESCAPE) {
                dispose();
            }

            if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                if (ke.getSource() == lo_pnl_ini_serie.TXT_codigo && go_fnc_operaciones_campos.cant_caracter(lo_pnl_ini_serie.TXT_codigo.getText().trim(), 1, 4)) {
                    lo_pnl_ini_serie.CBX_serie.requestFocus();
                    get_descripcion_sucursal(lo_pnl_ini_serie.TXT_codigo.getText().trim());
                }
                if (ke.getSource() == lo_pnl_ini_serie.CBX_serie) {
                    lo_pnl_aceptar_cancelar.BTN_aceptar.requestFocus();
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("PARAMETROS");
        setIconImage(getIconImage());
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 434, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 140, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dlg_ini_serie dialog = new dlg_ini_serie(new javax.swing.JFrame(), true);
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
