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
import net.sf.jasperreports.engine.JRParameter;

public class dlg_resumen_documento extends javax.swing.JDialog {

    pnl_resumen_documento lo_pnl_resumen_documento = new pnl_resumen_documento();
    pnl_aceptar_cancelar lo_pnl_aceptar_cancelar = new pnl_aceptar_cancelar();
    evt_aceptar_cancelar lo_evt_aceptar_cancelar = new evt_aceptar_cancelar();
    ResultSet lq_rs;
    String ls_codigo, ls_nombre;
    String ls_modulo = "VENTAS", ls_capa = "GUI", ls_clase = "dlg_resumen_documento";

    public dlg_resumen_documento(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        formulario();
    }

    private void formulario() {
        lo_pnl_resumen_documento.setBounds(10, 10, 450, 100);
        lo_pnl_aceptar_cancelar.setBounds(120, 100, 200, 50);

        this.add(lo_pnl_resumen_documento);
        this.add(lo_pnl_aceptar_cancelar);

        lo_pnl_resumen_documento.TXT_codigo.addKeyListener(KeyEvnt);
        lo_pnl_resumen_documento.TXT_pedido.addKeyListener(KeyEvnt);
        lo_pnl_resumen_documento.CBX_serie.addKeyListener(KeyEvnt);
        lo_pnl_resumen_documento.CBX_tipo_doc.addKeyListener(KeyEvnt);
        lo_evt_aceptar_cancelar.evento_click(lo_pnl_aceptar_cancelar, Listener);
        lo_evt_aceptar_cancelar.evento_press(lo_pnl_aceptar_cancelar, KeyEvnt);
    }

    private void limpia_datos() {
        lo_pnl_resumen_documento.TXT_codigo.setText("");
        lo_pnl_resumen_documento.TXT_nombre.setText("");
        lo_pnl_resumen_documento.TXT_pedido.setText("");
        lo_pnl_resumen_documento.CBX_serie.removeAllItems();
        lo_pnl_resumen_documento.TXT_codigo.requestFocus();
        ls_codigo = "";
    }

    private void genera_parametros_documento() {
        gs_parametros[0] = lo_pnl_resumen_documento.TXT_codigo.getText();
        gs_parametros[1] = "01/" + gs_mes + "/" + gs_periodo;
        gs_parametros[2] = gs_dia + "/" + gs_mes + "/" + gs_periodo;
        gs_parametros[3] = lo_pnl_resumen_documento.CBX_serie.getSelectedItem().toString().trim();
        gs_parametros[4] = (lo_pnl_resumen_documento.CBX_tipo_doc.getSelectedIndex() == 0) ? "01" : "03";
    }

    private void get_descripcion_sucursal(String codigo) {
        try {
            lq_rs = go_dao_usuario_permisos.SLT_grid_almacen_x_permiso(gi_id_usuario, "2", "1", codigo);
            if (lq_rs != null) {
                lo_pnl_resumen_documento.TXT_codigo.setText(lq_rs.getString(1));
                lo_pnl_resumen_documento.TXT_nombre.setText(lq_rs.getString(2));
                get_serie(codigo);
            } else {
                go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "get_descripcion_sucursal", "USUARIO SIN PERMISOS y/o SUCURSAL NO EXISTE");
                limpia_datos();
            }
        } catch (Exception e) {
        }
    }

    private void get_serie(String codigo) {
        lo_pnl_resumen_documento.CBX_serie.removeAllItems();
        try {
            lq_rs = go_dao_serie.SLT_cbx_serie(codigo);
            if (lq_rs != null) {
                do {
                    lo_pnl_resumen_documento.CBX_serie.addItem(lq_rs.getString(1));
                } while (lq_rs.next());
            } else {
                go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "get_serie", "SUCURSAL NO CUENTA CON SERIE");
                limpia_datos();
            }
        } catch (Exception e) {
        }
    }

    private void muestra_rpt() {
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("empresa", go_bean_general.getNombre_reporte());
        parametros.put("usuario", gs_datos_usuario);
        parametros.put("nombre_sucursal", lo_pnl_resumen_documento.TXT_nombre.getText());
        parametros.put("codigo_operacion", ls_codigo);
        parametros.put("periodo", gs_periodo);
        parametros.put(JRParameter.REPORT_LOCALE, Locale.ENGLISH);

        go_muestra_reporte_ventas.reporte_pestania("rpt_resumen_documento.jasper", parametros, "RESUMEN DOCUMENTO", 5);
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

    private void evt_f5_documento() {
        genera_parametros_documento();
        go_dlg_busq_registro_ventas = new dlg_busq_registro_ventas(null, true);
        go_dlg_busq_registro_ventas.setVisible(true);
        ls_codigo = go_dlg_busq_registro_ventas.ls_codigo;
        if (ls_codigo != null) {
            ls_codigo = ls_codigo.substring(0, 2) + lo_pnl_resumen_documento.CBX_serie.getSelectedItem().toString() + ls_codigo.substring(3, 13);
            lo_pnl_resumen_documento.TXT_pedido.setText(ls_codigo.substring(6));
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_buscar", "SELECCIONE DOCUMENTO");
            lo_pnl_resumen_documento.TXT_pedido.requestFocus();
        }
    }

    private void evt_aceptar() {
        if (lo_pnl_resumen_documento.CBX_serie.getItemCount() > 0) {
            if (go_fnc_operaciones_campos.campo_blanco(lo_pnl_resumen_documento.TXT_pedido) && !ls_codigo.equalsIgnoreCase("")) {
                if (go_dao_pedido.SLT_cta_pedido_parametros(lo_pnl_resumen_documento.TXT_codigo.getText(), lo_pnl_resumen_documento.CBX_serie.getSelectedItem().toString(), lo_pnl_resumen_documento.TXT_pedido.getText()) != 0) {
                    muestra_rpt();
                    dispose();
                } else {
                    go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_aceptar", "PEDIDO NO EXISTE y/o ACCESO NO PERMITIDO");
                    lo_pnl_resumen_documento.TXT_pedido.setText("");
                    lo_pnl_resumen_documento.TXT_pedido.requestFocus();
                    ls_codigo = "";
                }
            } else {
                go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_aceptar", "SELECCIONE PEDIDO");
                lo_pnl_resumen_documento.TXT_pedido.requestFocus();
                lo_pnl_resumen_documento.TXT_pedido.setText("");
                ls_codigo = "";
            }
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
                if (ke.getSource() == lo_pnl_resumen_documento.TXT_codigo) {
                    evt_f5_sucursal();
                }
                if (ke.getSource() == lo_pnl_resumen_documento.TXT_pedido) {
                    evt_f5_documento();
                }
            }
            if (ke.getKeyCode() == KeyEvent.VK_ESCAPE) {
                dispose();
            }
            if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                if (ke.getSource() == lo_pnl_resumen_documento.TXT_codigo && go_fnc_operaciones_campos.campo_blanco(lo_pnl_resumen_documento.TXT_codigo)) {
                    lo_pnl_resumen_documento.TXT_codigo.setText(go_fnc_operaciones_campos.completa_digitos(lo_pnl_resumen_documento.TXT_codigo.getText().trim(), "0", 4));
                    getFocusOwner().transferFocus();
                    get_descripcion_sucursal(lo_pnl_resumen_documento.TXT_codigo.getText().trim());
                }
                if (ke.getSource() == lo_pnl_resumen_documento.CBX_serie || ke.getSource() == lo_pnl_resumen_documento.CBX_tipo_doc) {
                    getFocusOwner().transferFocus();
                }
                if (ke.getSource() == lo_pnl_resumen_documento.TXT_pedido && go_fnc_operaciones_campos.campo_blanco(lo_pnl_resumen_documento.TXT_pedido)) {
                    lo_pnl_resumen_documento.TXT_pedido.setText(go_fnc_operaciones_campos.completa_digitos(lo_pnl_resumen_documento.TXT_pedido.getText().trim(), "0", 10));
                    ls_codigo = ((lo_pnl_resumen_documento.CBX_tipo_doc.getSelectedIndex() == 0) ? "01" : "03") + lo_pnl_resumen_documento.CBX_serie.getSelectedItem().toString() + lo_pnl_resumen_documento.TXT_pedido.getText();
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
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 449, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dlg_resumen_documento dialog = new dlg_resumen_documento(new javax.swing.JFrame(), true);
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
