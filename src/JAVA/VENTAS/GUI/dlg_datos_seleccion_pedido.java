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

public class dlg_datos_seleccion_pedido extends javax.swing.JDialog {

    pnl_datos_seleccion_pedido lo_pnl_datos_seleccion_pedido = new pnl_datos_seleccion_pedido();
    pnl_aceptar_cancelar lo_pnl_aceptar_cancelar = new pnl_aceptar_cancelar();
    evt_aceptar_cancelar lo_evt_aceptar_cancelar = new evt_aceptar_cancelar();
    ResultSet lq_rs;
    int cont = 0, li_tipo_operacion, li_item;
    DefaultTableModel modelo;
    String ls_codigo_pedido, ls_espedido, ls_serie, ls_codigo_sucursal, ls_codigo_documento;
    String ls_modulo = "VENTAS", ls_capa = "GUI", ls_clase = "dlg_datos_seleccion_pedido";
    public String ls_item_seleccion[];

    public dlg_datos_seleccion_pedido(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        formulario();
    }

    private void formulario() {
        lo_pnl_datos_seleccion_pedido.setBounds(0, 10, 700, 330);
        lo_pnl_aceptar_cancelar.setBounds(230, 340, 250, 150);

        this.add(lo_pnl_datos_seleccion_pedido);
        this.add(lo_pnl_aceptar_cancelar);

        ls_serie = gs_parametros[0];
        ls_codigo_sucursal = gs_parametros[1];
        ls_codigo_documento = gs_parametros[2];
        li_item = gi_parametros_2[0];
        ls_item_seleccion = new String[li_item + 1];
        ls_item_seleccion[0] = "0";

        gs_parametros[0] = "";
        gs_parametros[1] = "";
        gs_parametros[2] = "";
        gi_parametros_2[3] = 0;

        modelo = (DefaultTableModel) lo_pnl_datos_seleccion_pedido.TBL_detalle_pedido.getModel();
        modelo.addTableModelListener(TablaListener);

        lo_pnl_datos_seleccion_pedido.TXT_pedido.addKeyListener(KeyEvnt);
        lo_pnl_datos_seleccion_pedido.JRD_todos.addItemListener(ItemEvent);
        lo_evt_aceptar_cancelar.evento_click(lo_pnl_aceptar_cancelar, Listener);

    }

    private void limpia_tabla() {
        for (int i = modelo.getRowCount() - 1; i >= 0; i--) {
            modelo.removeRow(i);
        }
        li_tipo_operacion = 0;
    }

    private void genera_parametros_pedido() {
        gs_parametros[0] = ls_codigo_sucursal;
        gs_parametros[1] = "01/" + gs_mes + "/" + gs_periodo;
        gs_parametros[2] = gs_dia + "/" + gs_mes + "/" + gs_periodo;
        gs_parametros[3] = ls_serie;
        gs_parametros[4] = "0";
        gs_parametros[5] = ls_codigo_documento;
    }

    private void cuenta_seleccion() {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            if ((boolean) lo_pnl_datos_seleccion_pedido.TBL_detalle_pedido.getValueAt(i, 6)) {
                cont++;
                if (li_item < cont) {
                    lo_pnl_datos_seleccion_pedido.TBL_detalle_pedido.setValueAt(false, lo_pnl_datos_seleccion_pedido.TBL_detalle_pedido.getSelectedRow(), 6);
                }
            }
        }
        lo_pnl_datos_seleccion_pedido.LBL_total.setText(cont + "");
    }

    private void selecciona_todo(int op, boolean valor) {
        switch (op) {
            case 0:
                for (int i = 0; i < modelo.getRowCount(); i++) {
                    if (Integer.parseInt(lo_pnl_datos_seleccion_pedido.LBL_total.getText()) < li_item) {
                        if (!((boolean) lo_pnl_datos_seleccion_pedido.TBL_detalle_pedido.getValueAt(i, 6))) {
                            lo_pnl_datos_seleccion_pedido.TBL_detalle_pedido.setValueAt(valor, i, 6);
                        }
                    }
                }
                break;
            case 1:
                for (int i = 0; i < modelo.getRowCount(); i++) {
                    lo_pnl_datos_seleccion_pedido.TBL_detalle_pedido.setValueAt(valor, i, 6);
                }
                break;
        }

    }

    private void muestra_datos_ref(String codigo) {
        int a = 0;
        limpia_tabla();
        lo_pnl_datos_seleccion_pedido.LBL_total.setText("0");
        lo_pnl_datos_seleccion_pedido.JRD_todos.setSelected(false);

        lo_pnl_datos_seleccion_pedido.TBL_detalle_pedido.setDefaultRenderer(Double.class, new formato_grid_pedido());
        try {
            lq_rs = go_dao_pedido_detalle.SLT_grid_pedido_pendiente(codigo);
            if (lq_rs != null) {
                li_tipo_operacion = 1;
                lo_pnl_datos_seleccion_pedido.TXT_pedido.setText(codigo.substring(6));
                do {
                    modelo.addRow(new Object[]{"", "", "", null, null, null, false});
                    lo_pnl_datos_seleccion_pedido.TBL_detalle_pedido.setValueAt(lq_rs.getString(1), a, 0);
                    lo_pnl_datos_seleccion_pedido.TBL_detalle_pedido.setValueAt(lq_rs.getString(2), a, 1);
                    lo_pnl_datos_seleccion_pedido.TBL_detalle_pedido.setValueAt(lq_rs.getString(3), a, 2);
                    lo_pnl_datos_seleccion_pedido.TBL_detalle_pedido.setValueAt(lq_rs.getInt(4), a, 3);
                    lo_pnl_datos_seleccion_pedido.TBL_detalle_pedido.setValueAt(lq_rs.getDouble(5), a, 4);
                    lo_pnl_datos_seleccion_pedido.TBL_detalle_pedido.setValueAt(lq_rs.getDouble(6), a, 5);
                    lo_pnl_datos_seleccion_pedido.TBL_detalle_pedido.setValueAt(go_fnc_operaciones_campos.int_boolean(lq_rs.getInt(7)), a, 6);
                    a++;
                } while (lq_rs.next());
                getFocusOwner().transferFocus();
            } else {
                go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "muestra_datos_ref", "PEDIDO NO EXISTE y/o ES FACTURADO");
                ls_item_seleccion[0] = "0";
                lo_pnl_datos_seleccion_pedido.TXT_pedido.setText("");
                lo_pnl_datos_seleccion_pedido.TXT_pedido.requestFocus();
            }
        } catch (Exception e) {
        }
    }

    private void evt_f5_pedido() {
        genera_parametros_pedido();
        go_dlg_busq_pedido = new dlg_busq_pedido(null, true);
        go_dlg_busq_pedido.setVisible(true);
        ls_codigo_pedido = go_dlg_busq_pedido.ls_codigo;
        if (ls_codigo_pedido != null) {
            ls_espedido = "1";
            ls_codigo_pedido = ls_codigo_pedido.substring(0, 2) + ls_serie + ls_codigo_pedido.substring(3, 13);
            muestra_datos_ref(ls_codigo_pedido);
        }

    }

    private void evt_aceptar() {
        int a = 1;
        ls_item_seleccion[0] = ls_codigo_pedido;
        if (Integer.parseInt(lo_pnl_datos_seleccion_pedido.LBL_total.getText()) != 0) {
            for (int i = 0; i < modelo.getRowCount(); i++) {
                if ((boolean) lo_pnl_datos_seleccion_pedido.TBL_detalle_pedido.getValueAt(i, 6)) {
                    ls_item_seleccion[a] = lo_pnl_datos_seleccion_pedido.TBL_detalle_pedido.getValueAt(i, 0).toString();
                    a++;
                }
            }
            for (int i = a; i < ls_item_seleccion.length; i++) {
                ls_item_seleccion[i] = "";
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
                ls_item_seleccion[0] = "0";
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
                if (ke.getSource() == lo_pnl_datos_seleccion_pedido.TXT_pedido) {
                    evt_f5_pedido();
                }
            }
            if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                if (ke.getSource() == lo_pnl_datos_seleccion_pedido.TXT_pedido && go_fnc_operaciones_campos.campo_blanco(lo_pnl_datos_seleccion_pedido.TXT_pedido)) {
                    lo_pnl_datos_seleccion_pedido.TXT_pedido.setText(go_fnc_operaciones_campos.completa_digitos(lo_pnl_datos_seleccion_pedido.TXT_pedido.getText().trim(), "0", 10));
                    ls_codigo_pedido = "OP" + ls_serie + lo_pnl_datos_seleccion_pedido.TXT_pedido.getText().trim();
                    muestra_datos_ref(ls_codigo_pedido);
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
            if (ie.getSource() == lo_pnl_datos_seleccion_pedido.JRD_todos) {
                if (lo_pnl_datos_seleccion_pedido.JRD_todos.isSelected()) {
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
                dlg_datos_seleccion_pedido dialog = new dlg_datos_seleccion_pedido(new javax.swing.JFrame(), true);
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
