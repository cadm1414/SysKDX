package JAVA.VENTAS.GUI;

import JAVA.ANCESTRO.LOGICA.evt_previous_focus;
import javax.swing.ActionMap;

public class pnl_grid_busq_pedido extends javax.swing.JPanel {

    ActionMap am;

    public pnl_grid_busq_pedido() {
        initComponents();
        am = TBL_pedidos.getActionMap();
        am.put("selectPreviousColumnCell", new evt_previous_focus());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        TBL_pedidos = new javax.swing.JTable();

        TBL_pedidos.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        TBL_pedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "F. Emision", "Numero Doc.", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(TBL_pedidos);
        if (TBL_pedidos.getColumnModel().getColumnCount() > 0) {
            TBL_pedidos.getColumnModel().getColumn(0).setResizable(false);
            TBL_pedidos.getColumnModel().getColumn(0).setPreferredWidth(25);
            TBL_pedidos.getColumnModel().getColumn(1).setResizable(false);
            TBL_pedidos.getColumnModel().getColumn(1).setPreferredWidth(100);
            TBL_pedidos.getColumnModel().getColumn(2).setResizable(false);
            TBL_pedidos.getColumnModel().getColumn(2).setPreferredWidth(50);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable TBL_pedidos;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
