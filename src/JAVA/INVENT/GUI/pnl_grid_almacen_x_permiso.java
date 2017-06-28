package JAVA.INVENT.GUI;

public class pnl_grid_almacen_x_permiso extends javax.swing.JPanel {

    public pnl_grid_almacen_x_permiso() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        TBL_almacen_acceso = new javax.swing.JTable();

        TBL_almacen_acceso.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        TBL_almacen_acceso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre"
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
        jScrollPane2.setViewportView(TBL_almacen_acceso);
        if (TBL_almacen_acceso.getColumnModel().getColumnCount() > 0) {
            TBL_almacen_acceso.getColumnModel().getColumn(0).setResizable(false);
            TBL_almacen_acceso.getColumnModel().getColumn(0).setPreferredWidth(10);
            TBL_almacen_acceso.getColumnModel().getColumn(1).setResizable(false);
            TBL_almacen_acceso.getColumnModel().getColumn(1).setPreferredWidth(180);
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
    public javax.swing.JTable TBL_almacen_acceso;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
