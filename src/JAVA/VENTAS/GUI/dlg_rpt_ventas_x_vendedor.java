package JAVA.VENTAS.GUI;

import JAVA.ANCESTRO.GUI.pnl_aceptar_cancelar;
import JAVA.ANCESTRO.LOGICA.evt_aceptar_cancelar;
import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.INVENT.GUI.dlg_almacen_x_permiso;
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

public class dlg_rpt_ventas_x_vendedor extends javax.swing.JDialog {

    pnl_rpt_ventas_x_vendedor lo_pnl_rpt_ventas_x_vendedor = new pnl_rpt_ventas_x_vendedor();
    pnl_aceptar_cancelar lo_pnl_aceptar_cancelar = new pnl_aceptar_cancelar();
    evt_aceptar_cancelar lo_evt_aceptar_cancelar = new evt_aceptar_cancelar();
    ResultSet lq_rs;
    String ls_codigo;
    String ls_modulo = "VENTAS", ls_capa = "GUI", ls_clase = "dlg_rpt_ventas_x_vendedor";

    public dlg_rpt_ventas_x_vendedor(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        formulario();
        get_vendedor();
    }

    private void formulario() {
        lo_pnl_rpt_ventas_x_vendedor.setBounds(10, 10, 450, 100);
        lo_pnl_aceptar_cancelar.setBounds(120, 110, 200, 50);

        this.add(lo_pnl_rpt_ventas_x_vendedor);
        this.add(lo_pnl_aceptar_cancelar);

        lo_pnl_rpt_ventas_x_vendedor.TXT_fecha_ini.setText(gs_dia + gs_mes + gs_periodo);
        lo_pnl_rpt_ventas_x_vendedor.TXT_fecha_fin.setText(gs_dia + gs_mes + gs_periodo);

        lo_pnl_rpt_ventas_x_vendedor.TXT_codigo.addKeyListener(KeyEvnt);
        lo_pnl_rpt_ventas_x_vendedor.TXT_codigo_vendedor.addKeyListener(KeyEvnt);
        lo_pnl_rpt_ventas_x_vendedor.TXT_fecha_ini.addKeyListener(KeyEvnt);
        lo_pnl_rpt_ventas_x_vendedor.TXT_fecha_fin.addKeyListener(KeyEvnt);
        lo_evt_aceptar_cancelar.evento_click(lo_pnl_aceptar_cancelar, Listener);
        lo_evt_aceptar_cancelar.evento_press(lo_pnl_aceptar_cancelar, KeyEvnt);
    }

    private void get_descripcion_sucursal(String codigo) {
        try {
            lq_rs = go_dao_usuario_permisos.SLT_grid_almacen_x_permiso(gi_id_usuario, "2", "1", codigo);
            if (lq_rs != null) {
                lo_pnl_rpt_ventas_x_vendedor.TXT_codigo.setText(lq_rs.getString(1));
                lo_pnl_rpt_ventas_x_vendedor.TXT_nombre.setText(lq_rs.getString(2));
            } else {
                go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "get_descripcion_sucursal", "USUARIO SIN PERMISOS y/o SUCURSAL NO EXISTE");
                lo_pnl_rpt_ventas_x_vendedor.TXT_codigo.setText("");
                lo_pnl_rpt_ventas_x_vendedor.TXT_nombre.setText("");
                lo_pnl_rpt_ventas_x_vendedor.TXT_codigo.requestFocus();
            }
        } catch (Exception e) {
        }
    }

    private void get_vendedor() {
        if (!gs_vendedor_usuario.equalsIgnoreCase("%")) {
            lo_pnl_rpt_ventas_x_vendedor.TXT_codigo_vendedor.setEnabled(false);
            lo_pnl_rpt_ventas_x_vendedor.TXT_codigo_vendedor.setText(gs_vendedor_usuario);
            go_activa_buscador.get_descripcion_vendedor(lo_pnl_rpt_ventas_x_vendedor.TXT_codigo_vendedor.getText().trim(), lo_pnl_rpt_ventas_x_vendedor.TXT_codigo_vendedor, lo_pnl_rpt_ventas_x_vendedor.TXT_nombre_vendedor);
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

    private void evt_f5_sucursal() {
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

    private boolean valida_campos() {
        boolean resp = false;
        if (go_fnc_operaciones_campos.campo_blanco(lo_pnl_rpt_ventas_x_vendedor.TXT_codigo) && go_fnc_operaciones_campos.campo_blanco(lo_pnl_rpt_ventas_x_vendedor.TXT_nombre)) {
            if (valida_fecha(lo_pnl_rpt_ventas_x_vendedor.TXT_fecha_fin) && valida_fecha(lo_pnl_rpt_ventas_x_vendedor.TXT_fecha_ini)) {
                resp = true;
            }
        } else {
            go_fnc_mensaje.GET_mensaje(0, ls_modulo, ls_capa, ls_clase, "valida_campos", "INGRESE SUCURSAL");
            lo_pnl_rpt_ventas_x_vendedor.TXT_codigo.requestFocus();
        }
        return resp;
    }

    private void muestra_rpt() {
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("empresa", go_bean_general.getNombre_reporte());
        parametros.put("usuario", gs_datos_usuario);
        parametros.put("nombre_almacen", lo_pnl_rpt_ventas_x_vendedor.TXT_nombre.getText().trim());
        parametros.put("nombre_vendedor", lo_pnl_rpt_ventas_x_vendedor.TXT_nombre_vendedor.getText().trim());
        parametros.put("codigo_sucursal", lo_pnl_rpt_ventas_x_vendedor.TXT_codigo.getText());
        parametros.put("codigo_vendedor", lo_pnl_rpt_ventas_x_vendedor.TXT_codigo_vendedor.getText());
        parametros.put("fecha_ini", go_fnc_operaciones_campos.formarto_date(lo_pnl_rpt_ventas_x_vendedor.TXT_fecha_ini.getText()));
        parametros.put("fecha_fin", go_fnc_operaciones_campos.formarto_date(lo_pnl_rpt_ventas_x_vendedor.TXT_fecha_fin.getText()));
        parametros.put("periodo", gs_periodo);
        parametros.put(JRParameter.REPORT_LOCALE, Locale.ENGLISH);

        go_muestra_reporte_ventas.reporte_pestania("rpt_pedido_x_vendedor.jasper", parametros, "VENTAS x VENDEDOR", 7);

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
            if (ke.getKeyCode() == KeyEvent.VK_ESCAPE) {
                dispose();
            }
            if (ke.getKeyCode() == KeyEvent.VK_F5) {
                if (ke.getSource() == lo_pnl_rpt_ventas_x_vendedor.TXT_codigo) {
                    evt_f5_sucursal();
                }
                if (ke.getSource() == lo_pnl_rpt_ventas_x_vendedor.TXT_codigo_vendedor) {
                    go_activa_buscador.busq_vendedor(lo_pnl_rpt_ventas_x_vendedor.TXT_codigo_vendedor, lo_pnl_rpt_ventas_x_vendedor.TXT_nombre_vendedor);
                }
            }
            if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                if (ke.getSource() == lo_pnl_rpt_ventas_x_vendedor.TXT_codigo) {
                    if (ke.getSource() == lo_pnl_rpt_ventas_x_vendedor.TXT_codigo && go_fnc_operaciones_campos.campo_blanco(lo_pnl_rpt_ventas_x_vendedor.TXT_codigo)) {
                        lo_pnl_rpt_ventas_x_vendedor.TXT_codigo.setText(go_fnc_operaciones_campos.completa_digitos(lo_pnl_rpt_ventas_x_vendedor.TXT_codigo.getText().trim(), "0", 4));
                        getFocusOwner().transferFocus();
                        get_descripcion_sucursal(lo_pnl_rpt_ventas_x_vendedor.TXT_codigo.getText().trim());
                    }
                }
                if (ke.getSource() == lo_pnl_rpt_ventas_x_vendedor.TXT_codigo_vendedor && go_fnc_operaciones_campos.cant_caracter(lo_pnl_rpt_ventas_x_vendedor.TXT_codigo_vendedor.getText().trim(), 4, 4)) {
                    go_activa_buscador.get_descripcion_vendedor(lo_pnl_rpt_ventas_x_vendedor.TXT_codigo_vendedor.getText().trim(), lo_pnl_rpt_ventas_x_vendedor.TXT_codigo_vendedor, lo_pnl_rpt_ventas_x_vendedor.TXT_nombre_vendedor);
                }
                if (ke.getSource() == lo_pnl_rpt_ventas_x_vendedor.TXT_fecha_ini && !lo_pnl_rpt_ventas_x_vendedor.TXT_fecha_ini.getText().trim().equalsIgnoreCase("/  /")) {
                    if (valida_fecha(lo_pnl_rpt_ventas_x_vendedor.TXT_fecha_ini)) {
                        getFocusOwner().transferFocus();
                    }
                }
                if (ke.getSource() == lo_pnl_rpt_ventas_x_vendedor.TXT_fecha_fin && !lo_pnl_rpt_ventas_x_vendedor.TXT_fecha_fin.getText().trim().equalsIgnoreCase("/  /")) {
                    if (valida_fecha(lo_pnl_rpt_ventas_x_vendedor.TXT_fecha_fin)) {
                        getFocusOwner().transferFocus();
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
            .addGap(0, 455, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 155, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dlg_rpt_ventas_x_vendedor dialog = new dlg_rpt_ventas_x_vendedor(new javax.swing.JFrame(), true);
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
