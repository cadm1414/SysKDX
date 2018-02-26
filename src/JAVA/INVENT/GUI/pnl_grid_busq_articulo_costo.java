package JAVA.INVENT.GUI;

import JAVA.ANCESTRO.LOGICA.evt_previous_focus;
import javax.swing.ActionMap;

public class pnl_grid_busq_articulo_costo extends javax.swing.JPanel {

    ActionMap am;

    public pnl_grid_busq_articulo_costo() {
        initComponents();

        am = TBL_articulo_costo.getActionMap();
        am.put("selectPreviousColumnCell", new evt_previous_focus());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        TBL_articulo_costo = new javax.swing.JTable();

        TBL_articulo_costo.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        TBL_articulo_costo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "UM", "Tara", "OC", "P. Produc."
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(TBL_articulo_costo);
        if (TBL_articulo_costo.getColumnModel().getColumnCount() > 0) {
            TBL_articulo_costo.getColumnModel().getColumn(0).setResizable(false);
            TBL_articulo_costo.getColumnModel().getColumn(0).setPreferredWidth(50);
            TBL_articulo_costo.getColumnModel().getColumn(1).setPreferredWidth(300);
            TBL_articulo_costo.getColumnModel().getColumn(2).setResizable(false);
            TBL_articulo_costo.getColumnModel().getColumn(2).setPreferredWidth(10);
            TBL_articulo_costo.getColumnModel().getColumn(3).setResizable(false);
            TBL_articulo_costo.getColumnModel().getColumn(3).setPreferredWidth(20);
            TBL_articulo_costo.getColumnModel().getColumn(4).setResizable(false);
            TBL_articulo_costo.getColumnModel().getColumn(4).setPreferredWidth(50);
            TBL_articulo_costo.getColumnModel().getColumn(5).setResizable(false);
            TBL_articulo_costo.getColumnModel().getColumn(5).setPreferredWidth(50);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 651, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable TBL_articulo_costo;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
