package JAVA.INVENT.GUI;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.ANCESTRO.GUI.pnl_aceptar_cancelar;
import JAVA.ANCESTRO.IMAGES.IMAGES_ruta_ancestro;
import JAVA.ANCESTRO.LOGICA.evt_aceptar_cancelar;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;

public class dlg_ini_almacen extends javax.swing.JDialog {

    pnl_ini_almacen lo_pnl_ini_almacen = new pnl_ini_almacen();
    pnl_aceptar_cancelar lo_pnl_aceptar_cancelar = new pnl_aceptar_cancelar();
    evt_aceptar_cancelar lo_evt_aceptar_cancelar = new evt_aceptar_cancelar();
    ResultSet lq_rs;
    String ls_codigo, ls_nombre;
    String ls_modulo = "INVENT", ls_capa = "GUI", ls_clase = "dlg_ini_almacen";

    public dlg_ini_almacen(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        formulario();
    }

    private void formulario() {
        lo_pnl_ini_almacen.setBounds(10, 10, 500, 70);
        lo_pnl_aceptar_cancelar.setBounds(100, 70, 200, 50);

        this.add(lo_pnl_ini_almacen);
        this.add(lo_pnl_aceptar_cancelar);

        lo_pnl_ini_almacen.TXT_codigo.addKeyListener(KeyEvnt);
        lo_evt_aceptar_cancelar.evento_click(lo_pnl_aceptar_cancelar, Listener);
        lo_evt_aceptar_cancelar.evento_press(lo_pnl_aceptar_cancelar, KeyEvnt);
    }

    private void limpia_datos() {
        lo_pnl_ini_almacen.TXT_codigo.setText("");
        lo_pnl_ini_almacen.TXT_nombre.setText("");
        lo_pnl_ini_almacen.TXT_codigo.requestFocus();
    }

    private void get_descripcion_almacen(String codigo) {
        try {
            lq_rs = go_dao_usuario_permisos.SLT_grid_almacen_x_permiso(gi_id_usuario, "1", "1", codigo);
            if (lq_rs != null) {
                lo_pnl_ini_almacen.TXT_codigo.setText(lq_rs.getString(1));
                lo_pnl_ini_almacen.TXT_nombre.setText(lq_rs.getString(2));
                gs_parametros[0]=lq_rs.getString(1);
                gs_parametros[1]=lq_rs.getString(2);
            } else {
                go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "get_descripcion_almacen", "USUARIO SIN PERMISOS y/o ALMACEN NO EXISTE");
                limpia_datos();
            }
        } catch (Exception e) {
        }
    }

    private void muestra_jif() {
        if (go_fnc_operaciones_campos.campo_blanco(lo_pnl_ini_almacen.TXT_codigo)) {
            go_jif_saldos_iniciales = new jif_saldos_iniciales();
            go_frm_principal.JDP_principal.add(go_jif_saldos_iniciales);
            go_jif_saldos_iniciales.show();
            dispose();
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "muestra_jif", "INGRESE CODIGO");
            limpia_datos();
        }
    }

    private void evt_f5() {
        go_dlg_almacen_x_permiso = new dlg_almacen_x_permiso(null, true);
        go_dlg_almacen_x_permiso.setVisible(true);
        ls_codigo = go_dlg_almacen_x_permiso.ls_codigo_almacen;
        if (ls_codigo != null) {
            get_descripcion_almacen(ls_codigo);
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_f5", "SELECCIONE ALMACEN");
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
                muestra_jif();
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
                if (ke.getSource() == lo_pnl_ini_almacen.TXT_codigo) {
                    evt_f5();
                }
            }            
            if(ke.getKeyCode() == KeyEvent.VK_ESCAPE){
                dispose();
            }

            if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                if (ke.getSource() == lo_pnl_ini_almacen.TXT_codigo && go_fnc_operaciones_campos.cant_caracter(lo_pnl_ini_almacen.TXT_codigo.getText().trim(), 1, 4)) {
                    lo_pnl_aceptar_cancelar.BTN_aceptar.requestFocus();
                    get_descripcion_almacen(lo_pnl_ini_almacen.TXT_codigo.getText().trim());
                }
                if (ke.getSource() == lo_pnl_aceptar_cancelar.BTN_aceptar) {
                    muestra_jif();
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
            .addGap(0, 124, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dlg_ini_almacen dialog = new dlg_ini_almacen(new javax.swing.JFrame(), true);
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
