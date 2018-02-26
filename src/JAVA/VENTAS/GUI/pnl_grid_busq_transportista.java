package JAVA.VENTAS.GUI;

import JAVA.ANCESTRO.LOGICA.evt_previous_focus;
import javax.swing.ActionMap;

public class pnl_grid_busq_transportista extends javax.swing.JPanel {

    ActionMap am;

    public pnl_grid_busq_transportista() {
        initComponents();
        am = TBL_transportista.getActionMap();
        am.put("selectPreviousColumnCell", new evt_previous_focus());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        TBL_transportista = new javax.swing.JTable();

        TBL_transportista.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        TBL_transportista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod.", "Transportista", "Empresa", "Placa", "Vehiculo", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        TBL_transportista.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(TBL_transportista);
        if (TBL_transportista.getColumnModel().getColumnCount() > 0) {
            TBL_transportista.getColumnModel().getColumn(0).setResizable(false);
            TBL_transportista.getColumnModel().getColumn(0).setPreferredWidth(0);
            TBL_transportista.getColumnModel().getColumn(1).setPreferredWidth(130);
            TBL_transportista.getColumnModel().getColumn(2).setResizable(false);
            TBL_transportista.getColumnModel().getColumn(2).setPreferredWidth(130);
            TBL_transportista.getColumnModel().getColumn(3).setResizable(false);
            TBL_transportista.getColumnModel().getColumn(3).setPreferredWidth(30);
            TBL_transportista.getColumnModel().getColumn(4).setPreferredWidth(30);
            TBL_transportista.getColumnModel().getColumn(5).setResizable(false);
            TBL_transportista.getColumnModel().getColumn(5).setPreferredWidth(30);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable TBL_transportista;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
