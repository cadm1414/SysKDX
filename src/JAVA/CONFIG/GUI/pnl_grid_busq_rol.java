package JAVA.CONFIG.GUI;

import JAVA.ANCESTRO.LOGICA.evt_previous_focus;
import javax.swing.ActionMap;

public class pnl_grid_busq_rol extends javax.swing.JPanel {

    ActionMap am;

    public pnl_grid_busq_rol() {
        initComponents();
        am = TBL_rol.getActionMap();
        am.put("selectPreviousColumnCell", new evt_previous_focus());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TBL_rol = new javax.swing.JTable();

        TBL_rol.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        TBL_rol.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre Rol"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TBL_rol.getTableHeader().setResizingAllowed(false);
        jScrollPane1.setViewportView(TBL_rol);
        if (TBL_rol.getColumnModel().getColumnCount() > 0) {
            TBL_rol.getColumnModel().getColumn(0).setResizable(false);
            TBL_rol.getColumnModel().getColumn(0).setPreferredWidth(10);
            TBL_rol.getColumnModel().getColumn(1).setResizable(false);
            TBL_rol.getColumnModel().getColumn(1).setPreferredWidth(250);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable TBL_rol;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
