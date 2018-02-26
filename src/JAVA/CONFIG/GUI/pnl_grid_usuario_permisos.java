package JAVA.CONFIG.GUI;

import JAVA.ANCESTRO.LOGICA.evt_previous_focus;
import javax.swing.ActionMap;

public class pnl_grid_usuario_permisos extends javax.swing.JPanel {

    ActionMap am;

    public pnl_grid_usuario_permisos() {
        initComponents();
        am = TBL_usuario_permisos.getActionMap();
        am.put("selectPreviousColumnCell", new evt_previous_focus());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        TBL_usuario_permisos = new javax.swing.JTable();

        TBL_usuario_permisos.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        TBL_usuario_permisos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Tipo", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TBL_usuario_permisos.setEnabled(false);
        jScrollPane2.setViewportView(TBL_usuario_permisos);
        if (TBL_usuario_permisos.getColumnModel().getColumnCount() > 0) {
            TBL_usuario_permisos.getColumnModel().getColumn(0).setResizable(false);
            TBL_usuario_permisos.getColumnModel().getColumn(0).setPreferredWidth(20);
            TBL_usuario_permisos.getColumnModel().getColumn(1).setResizable(false);
            TBL_usuario_permisos.getColumnModel().getColumn(1).setPreferredWidth(130);
            TBL_usuario_permisos.getColumnModel().getColumn(2).setResizable(false);
            TBL_usuario_permisos.getColumnModel().getColumn(2).setPreferredWidth(40);
            TBL_usuario_permisos.getColumnModel().getColumn(3).setResizable(false);
            TBL_usuario_permisos.getColumnModel().getColumn(3).setPreferredWidth(5);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable TBL_usuario_permisos;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
