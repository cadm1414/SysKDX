package JAVA.DISTBR.GUI;

import JAVA.ANCESTRO.GUI.pnl_aceptar_cancelar;
import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.ANCESTRO.IMAGES.IMAGES_ruta_ancestro;
import JAVA.ANCESTRO.LOGICA.evt_aceptar_cancelar;
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

public class dlg_busq_doc extends javax.swing.JDialog {

    pnl_busq_doc lo_pnl_busq_doc = new pnl_busq_doc();
    pnl_aceptar_cancelar lo_pnl_aceptar_cancelar = new pnl_aceptar_cancelar();
    evt_aceptar_cancelar lo_evt_aceptar_cancelar = new evt_aceptar_cancelar();
    DefaultTableModel lm_modelo;
    ResultSet lq_rs;
    String ls_codigo_sucursal;
    String ls_modulo = "DISTBR", ls_capa = "GUI", ls_clase = "dlg_busq_doc";
    int li_cont = 0;

    public dlg_busq_doc(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        formulario();
        datos_tabla();
        li_cont = 1;
    }

    private void formulario() {
        lo_pnl_busq_doc.setBounds(0, 0, 700, 300);
        lo_pnl_aceptar_cancelar.setBounds(0, 0, 200, 100);
        pnl_principal.add(lo_pnl_busq_doc);
        PNL_aceptar.add(lo_pnl_aceptar_cancelar);

        ls_codigo_sucursal = gs_parametros[0];
        gs_parametros[0] = "";

        lm_modelo = (DefaultTableModel) lo_pnl_busq_doc.TBL_datos.getModel();
        lm_modelo.addTableModelListener(TablaListener);

        lo_pnl_busq_doc.JRD_todos.addItemListener(ItemEvent);
        lo_pnl_busq_doc.TBL_datos.addKeyListener(KeyEvnt);
        lo_evt_aceptar_cancelar.evento_click(lo_pnl_aceptar_cancelar, Listener);
    }

    private void datos_tabla() {
        int a = 0;
        lm_modelo = (DefaultTableModel) lo_pnl_busq_doc.TBL_datos.getModel();
        try {
            lq_rs = go_dao_registro_ventas.SLT_datos_doc(ls_codigo_sucursal);
            if (lq_rs != null) {
                do {
                    lm_modelo.addRow(new Object[]{""});
                    lo_pnl_busq_doc.TBL_datos.setValueAt(lq_rs.getString(1), a, 0);
                    lo_pnl_busq_doc.TBL_datos.setValueAt(go_fnc_operaciones_campos.completa_digitos((a + 1) + "", "0", 3), a, 1);
                    lo_pnl_busq_doc.TBL_datos.setValueAt(lq_rs.getString(2), a, 2);
                    lo_pnl_busq_doc.TBL_datos.setValueAt(go_fnc_operaciones_campos.recupera_fecha_formato(lq_rs.getString(3)), a, 3);
                    lo_pnl_busq_doc.TBL_datos.setValueAt(lq_rs.getString(4), a, 4);
                    lo_pnl_busq_doc.TBL_datos.setValueAt(lq_rs.getString(5), a, 5);
                    lo_pnl_busq_doc.TBL_datos.setValueAt(lq_rs.getString(6), a, 6);
                    lo_pnl_busq_doc.TBL_datos.setValueAt(lq_rs.getString(7), a, 7);
                    lo_pnl_busq_doc.TBL_datos.setValueAt(lq_rs.getString(8), a, 8);
                    lo_pnl_busq_doc.TBL_datos.setValueAt(lq_rs.getString(9), a, 9);
                    lo_pnl_busq_doc.TBL_datos.setValueAt(lq_rs.getString(10), a, 10);
                    lo_pnl_busq_doc.TBL_datos.setValueAt(false, a, 11);
                    a++;
                } while (lq_rs.next());
            }
        } catch (Exception e) {
        }
    }

    public void limpia_tabla() {
        DefaultTableModel modelo = (DefaultTableModel) lo_pnl_busq_doc.TBL_datos.getModel();
        for (int i = modelo.getRowCount() - 1; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }

    public void selecciona_todo(boolean valor) {
        DefaultTableModel modelo = (DefaultTableModel) lo_pnl_busq_doc.TBL_datos.getModel();
        for (int i = 0; i < modelo.getRowCount(); i++) {
            lo_pnl_busq_doc.TBL_datos.setValueAt(valor, i, 11);
        }
    }

    public void cuenta_seleccion() {
        DefaultTableModel modelo = (DefaultTableModel) lo_pnl_busq_doc.TBL_datos.getModel();
        int cont = 0;
        for (int i = 0; i < modelo.getRowCount(); i++) {
            if ((boolean) lo_pnl_busq_doc.TBL_datos.getValueAt(i, 11)) {
                cont++;
            }
        }
        lo_pnl_busq_doc.LBL_contador.setText(cont + "");
    }

    public void limpia_seleccion() {
        DefaultTableModel modelo = (DefaultTableModel) lo_pnl_busq_doc.TBL_datos.getModel();

        for (int i = modelo.getRowCount() - 1; i >= 0; i--) {
            if (!(boolean) lo_pnl_busq_doc.TBL_datos.getValueAt(i, 11)) {
                modelo.removeRow(i);
            }
        }
    }

    private void evt_aceptar() {
        if (Integer.parseInt(lo_pnl_busq_doc.LBL_contador.getText().trim()) != 0) {
            limpia_seleccion();
            dispose();
        } else {
            lo_pnl_busq_doc.JRD_todos.requestFocus();
            go_fnc_mensaje.GET_mensaje(0, ls_modulo, ls_capa, ls_clase, "evt_aceptar", "SELECCIONE AL MENOS UN DOCUMENTO");
        }
    }

    ActionListener Listener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == lo_pnl_aceptar_cancelar.BTN_aceptar) {
                evt_aceptar();
            }
            if (ae.getSource() == lo_pnl_aceptar_cancelar.BTN_cancelar) {
                limpia_tabla();
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

        }

        @Override
        public void keyReleased(KeyEvent ke) {

        }
    };

    ItemListener ItemEvent = new ItemListener() {
        @Override
        public void itemStateChanged(java.awt.event.ItemEvent ie) {
            if (ie.getSource() == lo_pnl_busq_doc.JRD_todos) {
                if (lo_pnl_busq_doc.JRD_todos.isSelected()) {
                    selecciona_todo(true);
                } else {
                    selecciona_todo(false);
                }
                cuenta_seleccion();
            }
        }
    };

    TableModelListener TablaListener = new TableModelListener() {
        @Override
        public void tableChanged(TableModelEvent tme) {
            if (tme.getType() == TableModelEvent.UPDATE && li_cont != 0) {
                cuenta_seleccion();
            }
        }
    };

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_principal = new javax.swing.JPanel();
        PNL_aceptar = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("BUSQUEDA DOCUMENTOS");
        setResizable(false);

        javax.swing.GroupLayout pnl_principalLayout = new javax.swing.GroupLayout(pnl_principal);
        pnl_principal.setLayout(pnl_principalLayout);
        pnl_principalLayout.setHorizontalGroup(
            pnl_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 680, Short.MAX_VALUE)
        );
        pnl_principalLayout.setVerticalGroup(
            pnl_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 295, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout PNL_aceptarLayout = new javax.swing.GroupLayout(PNL_aceptar);
        PNL_aceptar.setLayout(PNL_aceptarLayout);
        PNL_aceptarLayout.setHorizontalGroup(
            PNL_aceptarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );
        PNL_aceptarLayout.setVerticalGroup(
            PNL_aceptarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_principal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PNL_aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(219, 219, 219))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_principal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(PNL_aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dlg_busq_doc dialog = new dlg_busq_doc(new javax.swing.JFrame(), true);
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
                getImage(IMAGES_ruta_ancestro.class.getResource("buscar_d.png"));
        return retValue;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PNL_aceptar;
    private javax.swing.JPanel pnl_principal;
    // End of variables declaration//GEN-END:variables
}
