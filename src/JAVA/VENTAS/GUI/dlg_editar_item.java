package JAVA.VENTAS.GUI;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.ANCESTRO.GUI.pnl_aceptar_cancelar;
import JAVA.ANCESTRO.IMAGES.IMAGES_ruta_ancestro;
import JAVA.ANCESTRO.LOGICA.evt_aceptar_cancelar;
import JAVA.INVENT.GUI.dlg_busq_articulo;
import JAVA.VENTAS.LOGICA.evt_pnl_editar_item;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

public class dlg_editar_item extends javax.swing.JDialog {

    pnl_editar_item lo_pnl_editar_item = new pnl_editar_item();
    evt_pnl_editar_item lo_evt_pnl_editar_item = new evt_pnl_editar_item();
    pnl_aceptar_cancelar lo_pnl_aceptar_cancelar = new pnl_aceptar_cancelar();
    evt_aceptar_cancelar lo_evt_aceptar_cancelar = new evt_aceptar_cancelar();
    ResultSet lq_rs;
    public DefaultTableModel modelo;
    public int fila;
    double ld_tipo_cambio, ld_porcentaje_detraccion, ld_monto_minimo, ld_tara, ld_percepcion, ld_presentacion, ld_precio_min, ld_bruto, ld_neto, ld_importe;
    String ls_codigo, ls_codigo_sucursal, ls_serie, ls_codigo_vendedor, ls_nombre_vendedor, ls_codigo_articulo, ls_codigo_entidad, ls_codigo_unidad, ls_afecto_igv;
    String ls_opcion = "M A B";
    String ls_modulo = "VENTAS", ls_capa = "GUI", ls_clase = "jif_pedido";

    public dlg_editar_item(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        formulario();

    }

    private void formulario() {
        lo_pnl_editar_item.setBounds(10, 10, 700, 110);
        lo_pnl_aceptar_cancelar.setBounds(150, 110, 500, 100);

        add(lo_pnl_editar_item);
        add(lo_pnl_aceptar_cancelar);

        activa_campos();

        lo_evt_pnl_editar_item.evento_press(lo_pnl_editar_item, KeyEvnt);
        lo_evt_aceptar_cancelar.evento_click(lo_pnl_aceptar_cancelar, Listener);
        lo_evt_aceptar_cancelar.evento_press(lo_pnl_aceptar_cancelar, KeyEvnt);
    }

    public void get_datos(DefaultTableModel modelo, int fila) {
        this.modelo = modelo;
        this.fila = fila;
        llena_campos();
    }

    private void llena_campos() {
        lo_pnl_editar_item.TXT_codigo_articulo.setText(modelo.getValueAt(fila, 3).toString());
        lo_pnl_editar_item.TXT_nombre.setText(modelo.getValueAt(fila, 4).toString());
        lo_pnl_editar_item.CBX_presentacion.setSelectedIndex(((boolean) modelo.getValueAt(fila, 1) == true) ? 0 : 1);
        lo_pnl_editar_item.TXT_cantidad.setText(((boolean) modelo.getValueAt(fila, 1) == true) ? modelo.getValueAt(fila, 2).toString() : modelo.getValueAt(fila, 11).toString());
        lo_pnl_editar_item.TXT_precio.setText(modelo.getValueAt(fila, 9).toString());
        ld_presentacion = Double.parseDouble(modelo.getValueAt(fila, 15).toString());

        ld_tara = Double.parseDouble(modelo.getValueAt(fila, 5).toString());
        ls_codigo_unidad = modelo.getValueAt(fila, 6).toString();
        ls_afecto_igv = go_fnc_operaciones_campos.boolean_int((boolean) modelo.getValueAt(fila, 7)) + "";
        ld_percepcion = Double.parseDouble(modelo.getValueAt(fila, 8).toString());
        ld_precio_min = Double.parseDouble(modelo.getValueAt(fila, 16).toString());
    }

    private void activa_campos() {
        switch (gs_tipo_comercio) {
            case "0":
                lo_pnl_editar_item.TXT_codigo_articulo.setEnabled(true);
                lo_pnl_editar_item.TXT_cantidad.setEnabled(true);
                lo_pnl_editar_item.TXT_precio.setEnabled(true);
                lo_pnl_editar_item.CBX_presentacion.setEnabled(true);
                break;
            case "1":
                lo_pnl_editar_item.TXT_codigo_articulo.setEnabled(true);
                lo_pnl_editar_item.TXT_cantidad.setEnabled(true);
                break;
            case "2":
                lo_pnl_editar_item.TXT_codigo_articulo.setEnabled(true);
                lo_pnl_editar_item.TXT_cantidad.setEnabled(true);
                break;
            case "3":
                lo_pnl_editar_item.TXT_codigo_articulo.setEnabled(true);
                lo_pnl_editar_item.TXT_cantidad.setEnabled(true);
                lo_pnl_editar_item.TXT_precio.setEnabled(true);
                lo_pnl_editar_item.CBX_presentacion.setEnabled(true);
                break;
            case "4":
                lo_pnl_editar_item.TXT_codigo_articulo.setEnabled(true);
                lo_pnl_editar_item.TXT_cantidad.setEnabled(true);
                lo_pnl_editar_item.TXT_precio.setEnabled(true);
                break;
        }
    }

    private void get_descripcion_articulo(String codigo_articulo) {
        try {
            lq_rs = go_dao_articulo.SLT_datos_pedido_agil(gs_tipo_comercio, codigo_articulo);
            if (lq_rs != null) {
                lo_pnl_editar_item.TXT_nombre.setText(lq_rs.getString(2));
                lo_pnl_editar_item.TXT_precio.setText(lq_rs.getString(8));
                ld_tara = lq_rs.getDouble(3);
                ls_codigo_unidad = lq_rs.getString(4);
                ls_afecto_igv = lq_rs.getString(5);
                ld_percepcion = lq_rs.getDouble(6);
                ld_presentacion = lq_rs.getDouble(7);
                ld_precio_min = lq_rs.getDouble(9);
                lo_pnl_editar_item.CBX_presentacion.setSelectedIndex((ld_presentacion == 0) ? 1 : 0);
            } else {
                go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "get_descripcion_articulo", "PRODUCTO NO CUENTA CON PRECIO");
                lo_pnl_editar_item.TXT_codigo_articulo.setText("");
                lo_pnl_editar_item.TXT_nombre.setText("");
                lo_pnl_editar_item.TXT_precio.setText("");
                lo_pnl_editar_item.CBX_presentacion.setSelectedIndex(0);
                ld_tara = 0;
                ls_codigo_unidad = "";
                ls_afecto_igv = "";
                ld_percepcion = 0;
                ld_presentacion = 0;
                ld_precio_min = 0;
                lo_pnl_editar_item.TXT_codigo_articulo.requestFocus();
            }
        } catch (Exception e) {
        }
    }

    private boolean verifica_detalle() {
        boolean resp = false;
        if (go_fnc_operaciones_campos.cant_caracter(lo_pnl_editar_item.TXT_codigo_articulo.getText().trim(), 1, 12) && go_fnc_operaciones_campos.cant_caracter(lo_pnl_editar_item.TXT_nombre.getText().trim(), 1, 4)) {
            switch (lo_pnl_editar_item.CBX_presentacion.getSelectedIndex()) {
                case 0:
                    if (Double.parseDouble(lo_pnl_editar_item.TXT_cantidad.getText().replaceAll(",", "").trim()) % 1 == 0 || Double.parseDouble(lo_pnl_editar_item.TXT_cantidad.getText().replaceAll(",", "").trim()) > 0) {
                        if (Double.parseDouble(lo_pnl_editar_item.TXT_precio.getText().replaceAll(",", "").trim()) > 0 && Double.parseDouble(lo_pnl_editar_item.TXT_precio.getText().replaceAll(",", "").trim()) >= ld_precio_min) {
                            resp = true;
                        } else {
                            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "verifica_detalle", "VERIFICAR PRECIO");
                            lo_pnl_editar_item.TXT_precio.setText("");
                            lo_pnl_editar_item.TXT_precio.requestFocus();
                        }
                    } else {
                        go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "verifica_detalle", "VERIFICAR CANTIDAD");
                        lo_pnl_editar_item.TXT_cantidad.setText("");
                        lo_pnl_editar_item.TXT_cantidad.requestFocus();
                    }
                    break;
                case 1:
                    if (Double.parseDouble(lo_pnl_editar_item.TXT_cantidad.getText().replaceAll(",", "").trim()) > 0) {
                        if (Double.parseDouble(lo_pnl_editar_item.TXT_precio.getText().replaceAll(",", "").trim()) > 0 || Double.parseDouble(lo_pnl_editar_item.TXT_precio.getText().replaceAll(",", "").trim()) >= ld_precio_min) {
                            resp = true;
                        } else {
                            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "verifica_detalle", "VERIFICAR PRECIO");
                            lo_pnl_editar_item.TXT_precio.setText(ld_precio_min + "");
                            lo_pnl_editar_item.TXT_precio.requestFocus();
                        }
                    } else {
                        go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "verifica_detalle", "VERIFICAR CANTIDAD");
                        lo_pnl_editar_item.TXT_cantidad.setText("");
                        lo_pnl_editar_item.TXT_cantidad.requestFocus();
                    }
                    break;
            }
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "verifica_detalle", "SELECCIONE ARTICULO");
            lo_pnl_editar_item.TXT_codigo_articulo.setText("");
            lo_pnl_editar_item.TXT_nombre.setText("");
            lo_pnl_editar_item.TXT_codigo_articulo.requestFocus();
        }
        return resp;
    }

    private void evt_f5_articulo() {
        gs_parametros[0] = "1";
        go_dlg_busq_articulo = new dlg_busq_articulo(null, true);
        go_dlg_busq_articulo.setVisible(true);
        ls_codigo_articulo = go_dlg_busq_articulo.ls_codigo_articulo;
        if (ls_codigo_articulo != null) {
            get_descripcion_articulo(ls_codigo_articulo);
            lo_pnl_editar_item.TXT_codigo_articulo.setText(ls_codigo_articulo);
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_buscar", "SELECCIONE ARTICULO");
            lo_pnl_editar_item.TXT_codigo_articulo.setText("");
            lo_pnl_editar_item.TXT_nombre.setText("");
        }
    }

    private void evt_actualiza() {
        if (verifica_detalle()) {
            if (lo_pnl_editar_item.CBX_presentacion.getSelectedIndex() == 0) {
                modelo.setValueAt((int) Double.parseDouble(lo_pnl_editar_item.TXT_cantidad.getText().replaceAll(",", "").trim()), fila, 2);
                ld_neto = ld_presentacion * Double.parseDouble(lo_pnl_editar_item.TXT_cantidad.getText().replaceAll(",", "").trim());
                ld_importe = Double.parseDouble(lo_pnl_editar_item.TXT_precio.getText().replaceAll(",", "").trim()) * Double.parseDouble(lo_pnl_editar_item.TXT_cantidad.getText().replaceAll(",", "").trim());
            } else {
                modelo.setValueAt(lo_pnl_editar_item.TXT_cantidad.getText().trim(), fila, 11);
                ld_neto = Double.parseDouble(lo_pnl_editar_item.TXT_cantidad.getText().replaceAll(",", "").trim());
                ld_importe = Double.parseDouble(lo_pnl_editar_item.TXT_precio.getText().replaceAll(",", "").trim()) * ld_neto;
            }
            ld_bruto = ld_neto + ld_presentacion * ld_tara;

            modelo.setValueAt((lo_pnl_editar_item.CBX_presentacion.getSelectedIndex() == 0), fila, 1);
            modelo.setValueAt(lo_pnl_editar_item.TXT_codigo_articulo.getText().trim(), fila, 3);
            modelo.setValueAt(lo_pnl_editar_item.TXT_nombre.getText().trim(), fila, 4);

            modelo.setValueAt(ld_tara, fila, 5);
            modelo.setValueAt(ls_codigo_unidad, fila, 6);
            modelo.setValueAt(go_fnc_operaciones_campos.int_boolean(Integer.parseInt(ls_afecto_igv)), fila, 7);
            modelo.setValueAt(ld_percepcion, fila, 8);

            modelo.setValueAt(Double.parseDouble(lo_pnl_editar_item.TXT_precio.getText().replaceAll(",", "")), fila, 9);
            modelo.setValueAt(ld_bruto, fila, 10);
            modelo.setValueAt(ld_neto, fila, 11);
            modelo.setValueAt(ld_importe, fila, 12);
            modelo.setValueAt(ld_presentacion, fila, 15);

            modelo.setValueAt(ld_precio_min, fila, 16);

            dispose();
        }
    }

    ActionListener Listener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == lo_pnl_aceptar_cancelar.BTN_aceptar) {
                evt_actualiza();
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
            if (ke.getKeyCode() == KeyEvent.VK_ESCAPE) {
                dispose();
            }
            if (ke.getKeyCode() == KeyEvent.VK_F5) {
                if (ke.getSource() == lo_pnl_editar_item.TXT_codigo_articulo) {
                    evt_f5_articulo();
                }
            }
            if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                if (ke.getSource() == lo_pnl_editar_item.CBX_presentacion) {
                    getFocusOwner().transferFocus();
                }
                if (ke.getSource() == lo_pnl_editar_item.TXT_codigo_articulo && go_fnc_operaciones_campos.cant_caracter(lo_pnl_editar_item.TXT_codigo_articulo.getText().trim(), 1, 12) && go_fnc_operaciones_campos.cant_caracter(lo_pnl_editar_item.TXT_nombre.getText().trim(), 1, 4)) {
                    getFocusOwner().transferFocus();
                }
                if (ke.getSource() == lo_pnl_editar_item.TXT_cantidad && go_fnc_operaciones_campos.cant_caracter(lo_pnl_editar_item.TXT_cantidad.getText().trim(), 1, 1)) {
                    if (Double.parseDouble(lo_pnl_editar_item.TXT_cantidad.getText().replaceAll(",", "").trim()) == 0) {
                        lo_pnl_editar_item.TXT_cantidad.setText("");
                    } else {
                        getFocusOwner().transferFocus();
                    }
                }
                if (ke.getSource() == lo_pnl_editar_item.TXT_precio && go_fnc_operaciones_campos.cant_caracter(lo_pnl_editar_item.TXT_precio.getText().trim(), 1, 1)) {
                    if (Double.parseDouble(lo_pnl_editar_item.TXT_precio.getText().replaceAll(",", "").trim()) < ld_precio_min || Double.parseDouble(lo_pnl_editar_item.TXT_precio.getText().replaceAll(",", "").trim()) == 0) {
                        go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "keyPressed", "VERIFICAR PRECIO");
                        lo_pnl_editar_item.TXT_precio.setText("");
                        lo_pnl_editar_item.TXT_precio.setSelectionStart(0);
                        lo_pnl_editar_item.TXT_precio.setSelectionEnd(lo_pnl_editar_item.TXT_precio.getText().length());
                    } else {
                        getFocusOwner().transferFocus();
                    }
                }
                if (ke.getSource() == lo_pnl_aceptar_cancelar.BTN_aceptar) {
                    evt_actualiza();
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
                getImage(IMAGES_ruta_ancestro.class.getResource("editar_ico.png"));
        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("EDITAR");
        setIconImage(getIconImage());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 565, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(dlg_editar_item.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dlg_editar_item.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dlg_editar_item.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dlg_editar_item.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dlg_editar_item dialog = new dlg_editar_item(new javax.swing.JFrame(), true);
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
