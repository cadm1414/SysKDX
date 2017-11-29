package JAVA.VENTAS.GUI;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.ANCESTRO.GUI.pnl_aceptar_cancelar;
import JAVA.ANCESTRO.IMAGES.IMAGES_ruta_ancestro;
import JAVA.ANCESTRO.LOGICA.evt_aceptar_cancelar;
import JAVA.INVENT.GUI.dlg_almacen_x_permiso;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.swing.JTextField;
import net.sf.jasperreports.engine.JRParameter;

public class dlg_ini_sucursal extends javax.swing.JDialog {

    pnl_ini_sucursal lo_pnl_ini_sucursal = new pnl_ini_sucursal();
    pnl_aceptar_cancelar lo_pnl_aceptar_cancelar = new pnl_aceptar_cancelar();
    evt_aceptar_cancelar lo_evt_aceptar_cancelar = new evt_aceptar_cancelar();
    ResultSet lq_rs;
    int op;
    String ls_codigo, ls_nombre;
    String ls_modulo = "VENTAS", ls_capa = "GUI", ls_clase = "dlg_control_pedido";

    public dlg_ini_sucursal(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        formulario();
    }

    private void formulario() {
        lo_pnl_ini_sucursal.setBounds(10, 10, 450, 70);
        lo_pnl_aceptar_cancelar.setBounds(120, 70, 200, 50);

        this.add(lo_pnl_ini_sucursal);
        this.add(lo_pnl_aceptar_cancelar);

        op = gi_parametros_2[0];
        gi_parametros_2[0] = 0;

        lo_pnl_ini_sucursal.TXT_codigo.addKeyListener(KeyEvnt);
        lo_evt_aceptar_cancelar.evento_click(lo_pnl_aceptar_cancelar, Listener);
        lo_evt_aceptar_cancelar.evento_press(lo_pnl_aceptar_cancelar, KeyEvnt);
    }

    private void get_descripcion_sucursal(String codigo) {
        try {
            lq_rs = go_dao_usuario_permisos.SLT_grid_almacen_x_permiso(gi_id_usuario, "2", "1", codigo);
            if (lq_rs != null) {
                lo_pnl_ini_sucursal.TXT_codigo.setText(lq_rs.getString(1));
                lo_pnl_ini_sucursal.TXT_nombre.setText(lq_rs.getString(2));
            } else {
                go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "get_descripcion_sucursal", "USUARIO SIN PERMISOS y/o SUCURSAL NO EXISTE");
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
        if (go_fnc_operaciones_campos.campo_blanco(lo_pnl_ini_sucursal.TXT_codigo) && go_fnc_operaciones_campos.campo_blanco(lo_pnl_ini_sucursal.TXT_nombre)) {
            resp = true;
        } else {
            go_fnc_mensaje.GET_mensaje(0, ls_modulo, ls_capa, ls_clase, "valida_campos", "INGRESE SUCURSAL");
            lo_pnl_ini_sucursal.TXT_codigo.requestFocus();
        }
        return resp;
    }

    private void muestra_rpt() {
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("empresa", go_bean_general.getNombre_reporte());
        parametros.put("usuario", gs_datos_usuario);
        parametros.put("codigo_sucursal", lo_pnl_ini_sucursal.TXT_codigo.getText());
        parametros.put("periodo", gs_periodo);
        parametros.put("nombre_sucursal", lo_pnl_ini_sucursal.TXT_nombre.getText().trim());
        parametros.put(JRParameter.REPORT_LOCALE, Locale.ENGLISH);
        switch (op) {
            case 0:
                go_muestra_reporte_ventas.reporte_pestania("rpt_correlativo_doc.jasper", parametros, "CORRELATIVO DOCUMENTOS", 6);
                break;
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
                if (ke.getSource() == lo_pnl_ini_sucursal.TXT_codigo) {
                    evt_f5();
                }
            }
            if (ke.getKeyCode() == KeyEvent.VK_ESCAPE) {
                dispose();
            }
            if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                if (ke.getSource() == lo_pnl_ini_sucursal.TXT_codigo && go_fnc_operaciones_campos.campo_blanco(lo_pnl_ini_sucursal.TXT_codigo)) {
                    lo_pnl_ini_sucursal.TXT_codigo.setText(go_fnc_operaciones_campos.completa_digitos(lo_pnl_ini_sucursal.TXT_codigo.getText().trim(), "0", 4));
                    getFocusOwner().transferFocus();
                    get_descripcion_sucursal(lo_pnl_ini_sucursal.TXT_codigo.getText().trim());
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
            .addGap(0, 455, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dlg_ini_sucursal dialog = new dlg_ini_sucursal(new javax.swing.JFrame(), true);
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
