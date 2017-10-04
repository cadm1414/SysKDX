package JAVA.VENTAS.GUI;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.ANCESTRO.GUI.pnl_aceptar_cancelar;
import JAVA.ANCESTRO.IMAGES.IMAGES_ruta_ancestro;
import JAVA.ANCESTRO.LOGICA.evt_aceptar_cancelar;
import JAVA.VENTAS.LOGICA.formato_grid_pedido;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

public class dlg_datos_seleccion_guiar extends javax.swing.JDialog {

    pnl_datos_seleccion_guiar lo_pnl_datos_seleccion_guiar = new pnl_datos_seleccion_guiar();
    pnl_aceptar_cancelar lo_pnl_aceptar_cancelar = new pnl_aceptar_cancelar();
    evt_aceptar_cancelar lo_evt_aceptar_cancelar = new evt_aceptar_cancelar();
    ResultSet lq_rs;
    int cont = 0, li_tipo_operacion, li_item;
    DefaultTableModel modelo;
    String ls_codigo_guia, ls_esguia, ls_serie, ls_codigo_sucursal, ls_codigo_documento_ref, ls_numero_doc, ls_co_guias = "";
    String ls_modulo = "VENTAS", ls_capa = "GUI", ls_clase = "dlg_datos_seleccion_guiar";
    public String ls_item_seleccion[][];

    public dlg_datos_seleccion_guiar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        formulario();
    }

    private void formulario() {
        lo_pnl_datos_seleccion_guiar.setBounds(0, 10, 700, 330);
        lo_pnl_aceptar_cancelar.setBounds(230, 340, 250, 150);

        this.add(lo_pnl_datos_seleccion_guiar);
        this.add(lo_pnl_aceptar_cancelar);

        ls_serie = gs_parametros[0];
        ls_codigo_sucursal = "%";
        ls_codigo_documento_ref = gs_parametros[2];
        ls_numero_doc = gs_parametros[3];
        li_item = gi_parametros_2[0];

        ls_item_seleccion = new String[li_item + 1][2];
        ls_item_seleccion[0][0] = "0";

        lo_pnl_datos_seleccion_guiar.LBL_numero_doc.setText(ls_numero_doc);
        lo_pnl_datos_seleccion_guiar.TXT_serie_guia.setText(ls_serie);

        gs_parametros[0] = "";
        gs_parametros[1] = "";
        gs_parametros[2] = "";
        gs_parametros[3] = "";
        gi_parametros_2[3] = 0;

        modelo = (DefaultTableModel) lo_pnl_datos_seleccion_guiar.TBL_detalle_guiar.getModel();
        modelo.addTableModelListener(TablaListener);

        lo_pnl_datos_seleccion_guiar.TXT_serie_guia.addKeyListener(KeyEvnt);
        lo_pnl_datos_seleccion_guiar.TXT_guia.addKeyListener(KeyEvnt);
        lo_pnl_datos_seleccion_guiar.JRD_todos.addItemListener(ItemEvent);
        lo_evt_aceptar_cancelar.evento_click(lo_pnl_aceptar_cancelar, Listener);

    }

    private void limpia_tabla() {
        for (int i = modelo.getRowCount() - 1; i >= 0; i--) {
            modelo.removeRow(i);
        }
        li_tipo_operacion = 0;
    }

    private void genera_parametros_guia() {
        gs_parametros[0] = ls_codigo_sucursal;
        gs_parametros[1] = "01/" + gs_mes + "/" + gs_periodo;
        gs_parametros[2] = gs_dia + "/" + gs_mes + "/" + gs_periodo;
        gs_parametros[3] = lo_pnl_datos_seleccion_guiar.TXT_serie_guia.getText().trim();
        gs_parametros[4] = "0";
        gs_parametros[5] = ls_codigo_documento_ref;
    }

    private void cuenta_seleccion() {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            if ((boolean) lo_pnl_datos_seleccion_guiar.TBL_detalle_guiar.getValueAt(i, 7)) {
                cont++;
                if (li_item < cont) {
                    lo_pnl_datos_seleccion_guiar.TBL_detalle_guiar.setValueAt(false, lo_pnl_datos_seleccion_guiar.TBL_detalle_guiar.getSelectedRow(), 7);
                }
            }
        }
        lo_pnl_datos_seleccion_guiar.LBL_total.setText(cont + "");
    }

    private void selecciona_todo(int op, boolean valor) {
        switch (op) {
            case 0:
                for (int i = 0; i < modelo.getRowCount(); i++) {
                    if (Integer.parseInt(lo_pnl_datos_seleccion_guiar.LBL_total.getText()) < li_item) {
                        if (!((boolean) lo_pnl_datos_seleccion_guiar.TBL_detalle_guiar.getValueAt(i, 7))) {
                            lo_pnl_datos_seleccion_guiar.TBL_detalle_guiar.setValueAt(valor, i, 7);
                        }
                    }
                }
                break;
            case 1:
                for (int i = 0; i < modelo.getRowCount(); i++) {
                    lo_pnl_datos_seleccion_guiar.TBL_detalle_guiar.setValueAt(valor, i, 7);
                }
                break;
        }
    }

    private void muestra_datos_ref(String codigo) {
        if (ls_co_guias.indexOf(codigo) < 0) {
            int a;
            lo_pnl_datos_seleccion_guiar.LBL_total.setText("0");
            lo_pnl_datos_seleccion_guiar.JRD_todos.setSelected(false);

            lo_pnl_datos_seleccion_guiar.TBL_detalle_guiar.setDefaultRenderer(Double.class, new formato_grid_pedido());
            try {
                lq_rs = go_dao_guia_remision_detalle.SLT_grid_guia_pendiente(codigo, ls_codigo_documento_ref);
                if (lq_rs != null) {
                    if (ls_numero_doc.equalsIgnoreCase(lq_rs.getString(1))) {
                        if (lo_pnl_datos_seleccion_guiar.TBL_detalle_guiar.getRowCount() > 0) {
                            if (go_fnc_mensaje.get_respuesta(0, "¿DESEA AGREGAR ITEMS?") == 1) {
                                limpia_tabla();
                                ls_co_guias = lq_rs.getString(2);
                            } else {
                                ls_co_guias = ls_co_guias + "," + lq_rs.getString(2);
                            }
                        } else {
                            ls_co_guias = lq_rs.getString(2);
                        }
                    } else {
                        if (go_fnc_mensaje.get_respuesta(0, "NUMERO DE DOCUMENTO DE REFERENCIA DISTINTOS \n ¿DESEA REMPLAZARLO?") == 0) {
                            lo_pnl_datos_seleccion_guiar.LBL_numero_doc.setText(lq_rs.getString(1));
                            limpia_tabla();
                            ls_co_guias = lq_rs.getString(2);
                        }
                    }
                    a = lo_pnl_datos_seleccion_guiar.TBL_detalle_guiar.getRowCount();
                    lo_pnl_datos_seleccion_guiar.TXT_guia.setText(codigo.substring(6));
                    do {
                        modelo.addRow(new Object[]{"", "", "", "", null, null, null, false});
                        lo_pnl_datos_seleccion_guiar.TBL_detalle_guiar.setValueAt(lq_rs.getString(2), a, 0);
                        lo_pnl_datos_seleccion_guiar.TBL_detalle_guiar.setValueAt(lq_rs.getString(3), a, 1);
                        lo_pnl_datos_seleccion_guiar.TBL_detalle_guiar.setValueAt(lq_rs.getString(4), a, 2);
                        lo_pnl_datos_seleccion_guiar.TBL_detalle_guiar.setValueAt(lq_rs.getString(5), a, 3);
                        lo_pnl_datos_seleccion_guiar.TBL_detalle_guiar.setValueAt(lq_rs.getInt(6), a, 4);
                        lo_pnl_datos_seleccion_guiar.TBL_detalle_guiar.setValueAt(lq_rs.getDouble(7), a, 5);
                        lo_pnl_datos_seleccion_guiar.TBL_detalle_guiar.setValueAt(lq_rs.getDouble(8), a, 6);
                        lo_pnl_datos_seleccion_guiar.TBL_detalle_guiar.setValueAt(go_fnc_operaciones_campos.int_boolean(lq_rs.getInt(9)), a, 7);
                        a++;
                    } while (lq_rs.next());
                    li_tipo_operacion = 1;
                    getFocusOwner().transferFocus();
                } else {
                    go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "muestra_datos_ref", "GUIA NO EXISTE y/o ES FACTURADO");
                    ls_item_seleccion[0][0] = "0";
                    lo_pnl_datos_seleccion_guiar.TXT_guia.setText("");
                    lo_pnl_datos_seleccion_guiar.TXT_guia.requestFocus();
                }
            } catch (Exception e) {
            }
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "muestra_datos_ref", "GUIA YA FUE SELECCIONADA");
        }
    }

    private void evt_f5_guia() {
        genera_parametros_guia();
        go_dlg_busq_guia_remision = new dlg_busq_guia_remision(null, true);
        go_dlg_busq_guia_remision.setVisible(true);
        ls_codigo_guia = go_dlg_busq_guia_remision.ls_codigo;
        if (ls_codigo_guia != null) {
            ls_esguia = "1";
            ls_codigo_guia = ls_codigo_guia.substring(0, 2) + lo_pnl_datos_seleccion_guiar.TXT_serie_guia.getText() + ls_codigo_guia.substring(3, 13);
            muestra_datos_ref(ls_codigo_guia);
        }
    }

    private void evt_aceptar() {
        int a = 1;
        ls_item_seleccion[0][0] = "1";
        ls_item_seleccion[0][1] = lo_pnl_datos_seleccion_guiar.LBL_numero_doc.getText().trim().substring(5);
        if (Integer.parseInt(lo_pnl_datos_seleccion_guiar.LBL_total.getText()) != 0) {
            for (int i = 0; i < modelo.getRowCount(); i++) {
                if ((boolean) lo_pnl_datos_seleccion_guiar.TBL_detalle_guiar.getValueAt(i, 7)) {
                    ls_item_seleccion[a][0] = lo_pnl_datos_seleccion_guiar.TBL_detalle_guiar.getValueAt(i, 0).toString();
                    ls_item_seleccion[a][1] = lo_pnl_datos_seleccion_guiar.TBL_detalle_guiar.getValueAt(i, 1).toString();
                    a++;
                }
            }
            for (int i = a; i < ls_item_seleccion.length; i++) {
                ls_item_seleccion[i][0] = "";
                ls_item_seleccion[i][1] = "";
            }
            dispose();
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_aceptar", "DEBE SELECCIONAR ALMENOS UN ITEM");
        }
    }

    ActionListener Listener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == lo_pnl_aceptar_cancelar.BTN_aceptar) {
                evt_aceptar();
            }
            if (ae.getSource() == lo_pnl_aceptar_cancelar.BTN_cancelar) {
                ls_item_seleccion[0][0] = "0";
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
                if (ke.getSource() == lo_pnl_datos_seleccion_guiar.TXT_guia) {
                    evt_f5_guia();
                }
            }
            if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                if (ke.getSource() == lo_pnl_datos_seleccion_guiar.TXT_serie_guia && go_fnc_operaciones_campos.campo_blanco(lo_pnl_datos_seleccion_guiar.TXT_serie_guia)) {
                    lo_pnl_datos_seleccion_guiar.TXT_serie_guia.setText(go_fnc_operaciones_campos.completa_digitos(lo_pnl_datos_seleccion_guiar.TXT_serie_guia.getText().trim(), "0", 4));
                    getFocusOwner().transferFocus();
                }
                if (ke.getSource() == lo_pnl_datos_seleccion_guiar.TXT_guia && go_fnc_operaciones_campos.campo_blanco(lo_pnl_datos_seleccion_guiar.TXT_guia)) {
                    lo_pnl_datos_seleccion_guiar.TXT_guia.setText(go_fnc_operaciones_campos.completa_digitos(lo_pnl_datos_seleccion_guiar.TXT_guia.getText().trim(), "0", 10));
                    ls_codigo_guia = "09" + lo_pnl_datos_seleccion_guiar.TXT_serie_guia.getText() + lo_pnl_datos_seleccion_guiar.TXT_guia.getText().trim();
                    muestra_datos_ref(ls_codigo_guia);
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
            if (ie.getSource() == lo_pnl_datos_seleccion_guiar.JRD_todos) {
                if (lo_pnl_datos_seleccion_guiar.JRD_todos.isSelected()) {
                    selecciona_todo(0, true);
                } else {
                    selecciona_todo(1, false);
                }
            }
        }
    };

    TableModelListener TablaListener = new TableModelListener() {

        @Override
        public void tableChanged(TableModelEvent tme) {
            if (tme.getType() == TableModelEvent.UPDATE && li_tipo_operacion == 1) {
                cont = 0;
                cuenta_seleccion();
            }
        }
    };

    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(IMAGES_ruta_ancestro.class.getResource("formulario.png"));
        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SELECCION PEDIDO");
        setIconImage(getIconImage());
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 661, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 391, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dlg_datos_seleccion_guiar dialog = new dlg_datos_seleccion_guiar(new javax.swing.JFrame(), true);
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
