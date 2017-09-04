package JAVA.VENTAS.GUI;

public class pnl_grid_busq_registro_ventas extends javax.swing.JPanel {

    public pnl_grid_busq_registro_ventas() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        TBL_registro_ventas = new javax.swing.JTable();

        TBL_registro_ventas.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        TBL_registro_ventas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(TBL_registro_ventas);
        if (TBL_registro_ventas.getColumnModel().getColumnCount() > 0) {
            TBL_registro_ventas.getColumnModel().getColumn(0).setResizable(false);
            TBL_registro_ventas.getColumnModel().getColumn(0).setPreferredWidth(25);
            TBL_registro_ventas.getColumnModel().getColumn(1).setResizable(false);
            TBL_registro_ventas.getColumnModel().getColumn(1).setPreferredWidth(100);
            TBL_registro_ventas.getColumnModel().getColumn(2).setResizable(false);
            TBL_registro_ventas.getColumnModel().getColumn(2).setPreferredWidth(50);
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
    public javax.swing.JTable TBL_registro_ventas;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
