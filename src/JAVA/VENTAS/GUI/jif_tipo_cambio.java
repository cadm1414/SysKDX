package JAVA.VENTAS.GUI;

import JAVA.ANCESTRO.LOGICA.recupera_valor_op;
import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.CONFIG.LOGICA.cbx_moneda;
import JAVA.VENTAS.LOGICA.evt_datos_tipo_cambio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

public class jif_tipo_cambio extends javax.swing.JInternalFrame {

    pnl_datos_tipo_cambio lo_pnl_datos_tipo_cambio = new pnl_datos_tipo_cambio();
    evt_datos_tipo_cambio lo_evt_datos_tipo_cambio = new evt_datos_tipo_cambio();
    recupera_valor_op lo_recupera_valor_op = new recupera_valor_op();
    static boolean lb_valor_op[] = new boolean[8];
    DefaultTableModel modelo;
    cbx_moneda lo_cbx_moneda;
    ResultSet lq_rs;
    int cont = 0;
    String ls_opcion = "M C A";
    String ls_modulo = "VENTAS", ls_capa = "GUI", ls_clase = "jif_tipo_cambio";

    public jif_tipo_cambio() {
        initComponents();
        formulario();
        get_moneda();
        activa_botones();
        lo_pnl_datos_tipo_cambio.TBL_tipo_cambio.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "selectNextColumnCell");
    }

    private void formulario() {
        lo_pnl_datos_tipo_cambio.setBounds(10, 10, 300, 600);

        this.add(lo_pnl_datos_tipo_cambio);

        modelo = (DefaultTableModel) lo_pnl_datos_tipo_cambio.TBL_tipo_cambio.getModel();
        modelo.addTableModelListener(TablaListener);

        lo_pnl_datos_tipo_cambio.CBX_mes.setSelectedIndex(Integer.parseInt(gs_mes) - 1);
        lo_evt_datos_tipo_cambio.evento_item(lo_pnl_datos_tipo_cambio, ItemEvent);
        lo_evt_datos_tipo_cambio.evento_press(lo_pnl_datos_tipo_cambio, KeyEvnt);
        lo_evt_datos_tipo_cambio.evento_click(lo_pnl_datos_tipo_cambio, Listener);
    }

    private void activa_botones() {
        lb_valor_op = lo_recupera_valor_op.recupera(ls_modulo, ls_opcion);
        lo_evt_datos_tipo_cambio.activa_campos(0, lo_pnl_datos_tipo_cambio, true, lb_valor_op);
    }

    private void get_moneda() {
        lq_rs = go_dao_moneda.SLT_moneda_x_visible("S");
        if (lq_rs != null) {
            go_cbx_trato_datos.recupera_valor(0, lq_rs, lo_pnl_datos_tipo_cambio.CBX_moneda);
        }
        go_cbx_trato_datos.selecciona_valor(0, "USD", lo_pnl_datos_tipo_cambio.CBX_moneda);
    }

    private void evt_guardar() {
        lo_cbx_moneda = (cbx_moneda) lo_pnl_datos_tipo_cambio.CBX_moneda.getSelectedItem();
        if (cont > 0) {
            try {                
                go_dao_tipo_cambio.UPD_tipo_cambio(lo_pnl_datos_tipo_cambio.TBL_tipo_cambio, lo_cbx_moneda.getID());
                lo_evt_datos_tipo_cambio.limpia_tabla(lo_pnl_datos_tipo_cambio);
                lo_evt_datos_tipo_cambio.recupera_detalle(lo_pnl_datos_tipo_cambio.CBX_mes.getSelectedIndex() + 1, lo_cbx_moneda.getID(), lo_pnl_datos_tipo_cambio);
                
                cont =0;                
            } catch (Exception e) {
            }
        } else {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "evt_guardar", "NO SE A REALIZADO CAMBIOS");
            lo_pnl_datos_tipo_cambio.CBX_moneda.requestFocus();
        }
    }

    ActionListener Listener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == lo_pnl_datos_tipo_cambio.BTN_guardar) {
                evt_guardar();
            }
        }
    };

    KeyListener KeyEvnt = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent ke) {

        }

        @Override
        public void keyPressed(KeyEvent ke) {
            if (ke.getKeyCode() == KeyEvent.VK_F6 && lo_pnl_datos_tipo_cambio.BTN_guardar.isEnabled()) {
                evt_guardar();
            }
            if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                if (ke.getSource() == lo_pnl_datos_tipo_cambio.CBX_moneda) {
                    lo_pnl_datos_tipo_cambio.CBX_mes.requestFocus();
                }
                if (ke.getSource() == lo_pnl_datos_tipo_cambio.CBX_mes) {
                    if (lo_pnl_datos_tipo_cambio.TBL_tipo_cambio.getRowCount() > 0) {
                        lo_pnl_datos_tipo_cambio.TBL_tipo_cambio.changeSelection(0, 1, false, false);
                    }
                }
                if (ke.getSource() == lo_pnl_datos_tipo_cambio.BTN_guardar) {
                    evt_guardar();
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent ke) {
            if (ke.getSource() == lo_pnl_datos_tipo_cambio.TBL_tipo_cambio) {
                int fila = lo_pnl_datos_tipo_cambio.TBL_tipo_cambio.getSelectedRow();
                if (lo_pnl_datos_tipo_cambio.TBL_tipo_cambio.getSelectedColumn() == 2) {
                    lo_pnl_datos_tipo_cambio.TBL_tipo_cambio.changeSelection(fila + 1, 1, false, false);
                }
            }
        }

    };

    ItemListener ItemEvent = new ItemListener() {
        @Override
        public void itemStateChanged(java.awt.event.ItemEvent ie) {
            lo_cbx_moneda = (cbx_moneda) lo_pnl_datos_tipo_cambio.CBX_moneda.getSelectedItem();
            lo_evt_datos_tipo_cambio.limpia_tabla(lo_pnl_datos_tipo_cambio);
            lo_evt_datos_tipo_cambio.recupera_detalle(lo_pnl_datos_tipo_cambio.CBX_mes.getSelectedIndex() + 1, lo_cbx_moneda.getID(), lo_pnl_datos_tipo_cambio);
            cont = 0;
        }
    };

    TableModelListener TablaListener = new TableModelListener() {
        @Override
        public void tableChanged(TableModelEvent tme) {
            if (tme.getType() == TableModelEvent.UPDATE) {
                cont++;
            }
        }
    };

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setClosable(true);
        setIconifiable(true);
        setTitle("TIPO DE CAMBIO");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/JAVA/VENTAS/IMAGES/dolar.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 488, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 613, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
