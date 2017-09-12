package JAVA.VENTAS.GUI;

import JAVA.ANCESTRO.GUI.pnl_aceptar_cancelar;
import JAVA.ANCESTRO.LOGICA.evt_aceptar_cancelar;
import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.CONFIG.DAO.DAO_entidad_direccion;
import JAVA.VENTAS.IMAGES.VENTAS_ruta_images;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;

public class dlg_datos_pl extends javax.swing.JDialog {

    pnl_datos_pl lo_pnl_datos_pl = new pnl_datos_pl();
    pnl_aceptar_cancelar lo_pnl_aceptar_cancelar = new pnl_aceptar_cancelar();
    evt_aceptar_cancelar lo_evt_aceptar_cancelar = new evt_aceptar_cancelar();
    ResultSet lq_rs;
    String ls_codigo_entidad, ls_codigo_direccion, ls_codigo_transportista;
    String ls_modulo = "VENTAS", ls_capa = "GUI", ls_clase = "dlg_datos_pl";

    public dlg_datos_pl(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        formulario();
    }

    private void formulario() {
        lo_pnl_datos_pl.setBounds(10, 10, 700, 240);
        lo_pnl_aceptar_cancelar.setBounds(200, 240, 200, 200);

        this.add(lo_pnl_datos_pl);
        this.add(lo_pnl_aceptar_cancelar);

        ls_codigo_entidad = gs_parametros[0];
        gs_parametros[0] = "";
        if (go_dao_transportista.SLT_cta_transportista() == 1) {
            get_transportista("%");
        }

        lo_pnl_datos_pl.TXT_codigo_transportista.addKeyListener(KeyEvnt);
        lo_pnl_datos_pl.TXT_codigo_direccion.addKeyListener(KeyEvnt);
        lo_pnl_datos_pl.TXT_descripcion_pl.addKeyListener(KeyEvnt);
        lo_pnl_datos_pl.TXT_direccion.addKeyListener(KeyEvnt);
        lo_pnl_datos_pl.TXT_codigo_ubigeo.addKeyListener(KeyEvnt);
        lo_evt_aceptar_cancelar.evento_click(lo_pnl_aceptar_cancelar, Listener);
        lo_evt_aceptar_cancelar.evento_press(lo_pnl_aceptar_cancelar, KeyEvnt);

    }

    public void get_transportista(String codigo) {
        try {
            lq_rs = go_dao_transportista.SLT_datos_pl(codigo);
            if (lq_rs != null) {
                lo_pnl_datos_pl.TXT_codigo_transportista.setText(lq_rs.getString(1));
                lo_pnl_datos_pl.TXT_nombre_transportista.setText(lq_rs.getString(2));
                lo_pnl_datos_pl.TXT_licencia.setText(lq_rs.getString(3));
                lo_pnl_datos_pl.TXT_empresa.setText(lq_rs.getString(4));
                lo_pnl_datos_pl.TXT_ruc_empresa.setText(lq_rs.getString(5));
                lo_pnl_datos_pl.TXT_codigo_vehiculo.setText(lq_rs.getString(6));
                lo_pnl_datos_pl.TXT_marca.setText(lq_rs.getString(7));
                lo_pnl_datos_pl.TXT_civ.setText(lq_rs.getString(8));
                lo_pnl_datos_pl.TXT_codigo_vehiculo_v2.setText(lq_rs.getString(9));
                lo_pnl_datos_pl.TXT_marca_v2.setText(lq_rs.getString(10));
                lo_pnl_datos_pl.TXT_civ_v2.setText(lq_rs.getString(11));
                getFocusOwner().transferFocus();
            } else {
                go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "get_transportista", "TRANSPORTISTA NO EXISTE");
                lo_pnl_datos_pl.TXT_codigo_transportista.requestFocus();
                limpia_transportista();
            }
        } catch (Exception e) {
        }
    }

    private void get_datos_direccion(String codigo) {
        try {
            lq_rs = go_dao_entidad_direccion.SLT_datos_entidad_direccion(ls_codigo_entidad, codigo);
            if (lq_rs != null) {
                activo_campos_direccion(false);
                lo_pnl_datos_pl.TXT_codigo_direccion.setText(codigo);
                lo_pnl_datos_pl.TXT_descripcion_pl.setText(lq_rs.getString(3));
                lo_pnl_datos_pl.TXT_direccion.setText(lq_rs.getString(4));
                lo_pnl_datos_pl.TXT_codigo_ubigeo.setText(lq_rs.getString(5));
                lo_pnl_datos_pl.TXT_descripcion_ubigeo.setText(lq_rs.getString(6));
                lo_pnl_aceptar_cancelar.BTN_aceptar.requestFocus();
            }
        } catch (Exception e) {
        }
    }

    private void activo_campos_direccion(boolean valor) {
        lo_pnl_datos_pl.TXT_descripcion_pl.setEnabled(valor);
        lo_pnl_datos_pl.TXT_direccion.setEnabled(valor);
        lo_pnl_datos_pl.TXT_codigo_ubigeo.setEnabled(valor);
    }

    private void limpia_transportista() {
        lo_pnl_datos_pl.TXT_codigo_transportista.setText("");
        lo_pnl_datos_pl.TXT_nombre_transportista.setText("");
        lo_pnl_datos_pl.TXT_licencia.setText("");
        lo_pnl_datos_pl.TXT_ruc_empresa.setText("");
        lo_pnl_datos_pl.TXT_empresa.setText("");
        lo_pnl_datos_pl.TXT_codigo_vehiculo.setText("");
        lo_pnl_datos_pl.TXT_codigo_vehiculo_v2.setText("");
        lo_pnl_datos_pl.TXT_marca.setText("");
        lo_pnl_datos_pl.TXT_marca_v2.setText("");
        lo_pnl_datos_pl.TXT_civ.setText("");
        lo_pnl_datos_pl.TXT_civ_v2.setText("");
    }

    private boolean valida_campos() {
        boolean resp = true;
        if (go_fnc_operaciones_campos.campo_blanco(lo_pnl_datos_pl.TXT_codigo_transportista) && go_fnc_operaciones_campos.campo_blanco(lo_pnl_datos_pl.TXT_licencia)) {
            if (go_fnc_operaciones_campos.campo_blanco(lo_pnl_datos_pl.TXT_codigo_direccion) && go_fnc_operaciones_campos.campo_blanco(lo_pnl_datos_pl.TXT_direccion) && go_fnc_operaciones_campos.campo_blanco(lo_pnl_datos_pl.TXT_codigo_ubigeo)) {
                resp = true;
            } else {
                go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "SELECCIONE DIRECCION");
                lo_pnl_datos_pl.TXT_codigo_direccion.requestFocus();
            }
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "valida_campos", "SELECCIONE TRANSPORTISTA");
            lo_pnl_datos_pl.TXT_codigo_transportista.requestFocus();
        }
        return resp;
    }

    private void evt_f5_direccion() {
        gs_parametros[0] = ls_codigo_entidad;
        go_dlg_busq_entidad_direccion = new dlg_busq_entidad_direccion(null, true);
        go_dlg_busq_entidad_direccion.setVisible(true);
        ls_codigo_direccion = go_dlg_busq_entidad_direccion.ls_codigo_direccion;
        if (ls_codigo_direccion != null) {
            get_datos_direccion(ls_codigo_direccion);
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_f5_direccion", "SELECCIONE DIRECCION");
            lo_pnl_datos_pl.TXT_codigo_direccion.requestFocus();
            lo_pnl_datos_pl.TXT_codigo_direccion.setText("");
            lo_pnl_datos_pl.TXT_descripcion_pl.setText("");
            lo_pnl_datos_pl.TXT_direccion.setText("");
            lo_pnl_datos_pl.TXT_codigo_ubigeo.setText("");
            lo_pnl_datos_pl.TXT_descripcion_ubigeo.setText("");
        }
    }

    private void evt_f5_transportista() {
        go_dlg_busq_transportista = new dlg_busq_transportista(null, true);
        go_dlg_busq_transportista.setVisible(true);
        ls_codigo_transportista = go_dlg_busq_transportista.ls_codigo_transportista;
        if (ls_codigo_transportista != null) {
            get_transportista(ls_codigo_transportista);
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_f5_transportista", "SELECCIONE TRANSPORTISTA");
            lo_pnl_datos_pl.TXT_codigo_transportista.requestFocus();
            limpia_transportista();
        }
    }

    private void evt_f5_ubigeo() {
        go_activa_buscador.busq_ubigeo(lo_pnl_datos_pl.TXT_codigo_ubigeo, lo_pnl_datos_pl.TXT_descripcion_ubigeo);
    }

    private void evt_aceptar() {
        if (valida_campos() == true) {
            
        }
    }

    ActionListener Listener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == lo_pnl_aceptar_cancelar.BTN_aceptar) {
                evt_aceptar();
            }
            if (ae.getSource() == lo_pnl_aceptar_cancelar.BTN_cancelar) {
                dispose();
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
                if (ke.getSource() == lo_pnl_datos_pl.TXT_codigo_direccion) {
                    evt_f5_direccion();
                }
                if (ke.getSource() == lo_pnl_datos_pl.TXT_codigo_transportista) {
                    evt_f5_transportista();
                }
                if (ke.getSource() == lo_pnl_datos_pl.TXT_codigo_ubigeo) {
                    evt_f5_ubigeo();
                }
            }
            if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                if (ke.getSource() == lo_pnl_datos_pl.TXT_codigo_transportista && go_fnc_operaciones_campos.campo_blanco(lo_pnl_datos_pl.TXT_codigo_transportista)) {
                    lo_pnl_datos_pl.TXT_codigo_transportista.setText(go_fnc_operaciones_campos.completa_digitos(lo_pnl_datos_pl.TXT_codigo_transportista.getText().trim(), "0", 4));
                    get_transportista(lo_pnl_datos_pl.TXT_codigo_transportista.getText().trim());
                }
                if (ke.getSource() == lo_pnl_datos_pl.TXT_codigo_direccion && go_fnc_operaciones_campos.campo_blanco(lo_pnl_datos_pl.TXT_codigo_direccion)) {
                    lo_pnl_datos_pl.TXT_codigo_direccion.setText(go_fnc_operaciones_campos.completa_digitos(lo_pnl_datos_pl.TXT_codigo_direccion.getText().trim(), "0", 3));
                    if (lo_pnl_datos_pl.TXT_codigo_direccion.getText().trim().equalsIgnoreCase("999")) {
                        activo_campos_direccion(true);
                        lo_pnl_datos_pl.TXT_descripcion_pl.setText("");
                        lo_pnl_datos_pl.TXT_direccion.setText("");
                        lo_pnl_datos_pl.TXT_codigo_ubigeo.setText("");
                        lo_pnl_datos_pl.TXT_descripcion_ubigeo.setText("");
                        getFocusOwner().transferFocus();
                    } else {
                        get_datos_direccion(lo_pnl_datos_pl.TXT_codigo_direccion.getText().trim());
                    }
                }
                if (ke.getSource() == lo_pnl_datos_pl.TXT_descripcion_pl) {
                    getFocusOwner().transferFocus();
                }
                if (ke.getSource() == lo_pnl_datos_pl.TXT_direccion && go_fnc_operaciones_campos.cant_caracter(lo_pnl_datos_pl.TXT_direccion.getText().trim(), 1, 4)) {
                    getFocusOwner().transferFocus();
                }
                if (ke.getSource() == lo_pnl_datos_pl.TXT_codigo_ubigeo && go_fnc_operaciones_campos.cant_caracter(lo_pnl_datos_pl.TXT_codigo_ubigeo.getText().trim(), 4, 6)) {
                    if (go_activa_buscador.get_descripcion_ubigeo(lo_pnl_datos_pl.TXT_codigo_ubigeo.getText().trim(), lo_pnl_datos_pl.TXT_codigo_ubigeo, lo_pnl_datos_pl.TXT_descripcion_ubigeo)) {
                        lo_pnl_aceptar_cancelar.BTN_aceptar.requestFocus();
                    }
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

    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(VENTAS_ruta_images.class.getResource("camion.png"));
        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("DATOS TRANSPORTE");
        setIconImage(getIconImage());
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 588, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dlg_datos_pl dialog = new dlg_datos_pl(new javax.swing.JFrame(), true);
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
