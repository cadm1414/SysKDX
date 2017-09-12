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
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import net.sf.jasperreports.engine.JRParameter;

public class dlg_rpt_stock extends javax.swing.JDialog {

    pnl_rpt_stock lo_pnl_rpt_stock = new pnl_rpt_stock();
    pnl_aceptar_cancelar lo_pnl_aceptar_cancelar = new pnl_aceptar_cancelar();
    evt_aceptar_cancelar lo_evt_aceptar_cancelar = new evt_aceptar_cancelar();
    ResultSet lq_rs;
    String ls_codigo, ls_nombre;
    String ls_modulo = "INVENT", ls_capa = "GUI", ls_clase = "dlg_rpt_stock";

    public dlg_rpt_stock(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        formulario();
    }

    private void formulario() {
        lo_pnl_rpt_stock.setBounds(10, 10, 500, 130);
        lo_pnl_aceptar_cancelar.setBounds(100, 130, 200, 50);

        this.add(lo_pnl_rpt_stock);
        this.add(lo_pnl_aceptar_cancelar);

        lo_pnl_rpt_stock.TXT_fecha_fin.setText(gs_dia + gs_mes + gs_periodo);

        lo_pnl_rpt_stock.TXT_codigo.addKeyListener(KeyEvnt);
        lo_pnl_rpt_stock.CBX_tipo.addKeyListener(KeyEvnt);
        lo_pnl_rpt_stock.TXT_fecha_fin.addKeyListener(KeyEvnt);

        lo_evt_aceptar_cancelar.evento_click(lo_pnl_aceptar_cancelar, Listener);
        lo_evt_aceptar_cancelar.evento_press(lo_pnl_aceptar_cancelar, KeyEvnt);
    }

    private void limpia_datos() {
        lo_pnl_rpt_stock.TXT_codigo.setText("");
        lo_pnl_rpt_stock.TXT_nombre.setText("");
        lo_pnl_rpt_stock.TXT_codigo.requestFocus();
    }

    private void get_descripcion_almacen(String codigo) {
        try {
            lq_rs = go_dao_usuario_permisos.SLT_grid_almacen_x_permiso(gi_id_usuario, "1", "1", codigo);
            if (lq_rs != null) {
                lo_pnl_rpt_stock.TXT_codigo.setText(lq_rs.getString(1));
                lo_pnl_rpt_stock.TXT_nombre.setText(lq_rs.getString(2));
            } else {
                go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "get_descripcion_almacen", "USUARIO SIN PERMISOS y/o ALMACEN NO EXISTE");
                limpia_datos();
            }
        } catch (Exception e) {
        }
    }

    private void muestra_rpt() {
        if (go_fnc_operaciones_campos.campo_blanco(lo_pnl_rpt_stock.TXT_codigo)) {
            if (go_fnc_operaciones_campos.valida_fecha(lo_pnl_rpt_stock.TXT_fecha_fin.getText())) {
                if (lo_pnl_rpt_stock.TXT_fecha_fin.getText().trim().substring(6, 10).equalsIgnoreCase(gs_periodo)) {
                    Map<String, Object> parametros = new HashMap<>();
                    parametros.put("empresa", go_bean_general.getNombre_reporte());
                    parametros.put("usuario", gs_datos_usuario);
                    parametros.put("almacen", lo_pnl_rpt_stock.TXT_codigo.getText());
                    parametros.put("fecha_ini", go_fnc_operaciones_campos.formarto_date("01/01/" + gs_periodo));
                    parametros.put("fecha_fin", go_fnc_operaciones_campos.formarto_date(lo_pnl_rpt_stock.TXT_fecha_fin.getText()));
                    parametros.put("periodo", gs_periodo);
                    parametros.put("nombre_almacen", lo_pnl_rpt_stock.TXT_nombre.getText().trim());
                    parametros.put(JRParameter.REPORT_LOCALE, Locale.ENGLISH);
                    switch (lo_pnl_rpt_stock.CBX_tipo.getSelectedIndex()) {
                        case 0:
                            go_muestra_reporte_invent.reporte_pestania("rpt_stock_simplificado.jasper", parametros, "STOCK ALMACEN SIMPLIFICADO", 7);
                            break;
                        case 1:
                            go_muestra_reporte_invent.reporte_pestania("rpt_stock_futuro.jasper", parametros, "STOCK ALMACEN PEDIDOS", 6);
                            break;
                        case 2:
                            go_muestra_reporte_invent.reporte_pestania("rpt_stock_normal.jasper", parametros, "STOCK ALMACEN", 4);
                            break;
                        case 3:
                            go_muestra_reporte_invent.reporte_pestania("rpt_stock_valorizado.jasper", parametros, "STOCK ALMACEN VALORIZADO", 5);
                            break;
                    }
                    dispose();
                } else {
                    go_fnc_mensaje.GET_mensaje(0, ls_modulo, ls_capa, ls_clase, "keyPressed", "FECHA NO PERTENECE AL PERIODO");
                    lo_pnl_rpt_stock.TXT_fecha_fin.setText("");
                    lo_pnl_rpt_stock.TXT_fecha_fin.requestFocus();
                }
            } else {
                go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "muestra_jif", "FORMATO DE FECHA INVALIDO");
                lo_pnl_rpt_stock.TXT_fecha_fin.setText("");
                lo_pnl_rpt_stock.TXT_fecha_fin.requestFocus();
            }
        } else {
            limpia_datos();
        }
    }

    private void evt_f5() {
        gs_parametros[0] = "1";
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
                get_descripcion_almacen(lo_pnl_rpt_stock.TXT_codigo.getText().trim());
                muestra_rpt();
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
                if (ke.getSource() == lo_pnl_rpt_stock.TXT_codigo) {
                    evt_f5();
                }
            }
            if (ke.getKeyCode() == KeyEvent.VK_ESCAPE) {
                dispose();
            }

            if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                if (ke.getSource() == lo_pnl_rpt_stock.TXT_codigo && go_fnc_operaciones_campos.cant_caracter(lo_pnl_rpt_stock.TXT_codigo.getText().trim(), 1, 4)) {
                    lo_pnl_rpt_stock.CBX_tipo.requestFocus();
                    get_descripcion_almacen(lo_pnl_rpt_stock.TXT_codigo.getText().trim());
                }
                if (ke.getSource() == lo_pnl_rpt_stock.CBX_tipo) {
                    lo_pnl_rpt_stock.TXT_fecha_fin.requestFocus();
                }
                if (ke.getSource() == lo_pnl_rpt_stock.TXT_fecha_fin && !lo_pnl_rpt_stock.TXT_fecha_fin.getText().trim().equalsIgnoreCase("/  /")) {
                    if (go_fnc_operaciones_campos.valida_fecha(lo_pnl_rpt_stock.TXT_fecha_fin.getText())) {
                        if (lo_pnl_rpt_stock.TXT_fecha_fin.getText().trim().substring(6, 10).equalsIgnoreCase(gs_periodo)) {
                            getFocusOwner().transferFocus();
                        } else {
                            lo_pnl_rpt_stock.TXT_fecha_fin.setText("");
                            go_fnc_mensaje.GET_mensaje(0, ls_modulo, ls_capa, ls_clase, "keyPressed", "FECHA NO PERTENECE AL PERIODO");
                        }
                    } else {
                        lo_pnl_rpt_stock.TXT_fecha_fin.setText("");
                        go_fnc_mensaje.GET_mensaje(0, ls_modulo, ls_capa, ls_clase, "keyPressed", "FORMATO DE FECHA INVALIDO ");
                    }
                }
                if (ke.getSource() == lo_pnl_aceptar_cancelar.BTN_aceptar) {
                    get_descripcion_almacen(lo_pnl_rpt_stock.TXT_codigo.getText().trim());
                    muestra_rpt();
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
            .addGap(0, 441, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 182, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dlg_rpt_stock dialog = new dlg_rpt_stock(new javax.swing.JFrame(), true);
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

    public Image
            getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(IMAGES_ruta_ancestro.class
                        .getResource("parametros.png"));
        return retValue;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
