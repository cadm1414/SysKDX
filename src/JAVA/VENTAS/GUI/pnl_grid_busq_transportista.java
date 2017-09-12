package JAVA.VENTAS.GUI;


public class pnl_grid_busq_transportista extends javax.swing.JPanel {

    public pnl_grid_busq_transportista() {
        initComponents();
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
                "Codigo", "Transportista", "Empresa", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(TBL_transportista);
        if (TBL_transportista.getColumnModel().getColumnCount() > 0) {
            TBL_transportista.getColumnModel().getColumn(0).setResizable(false);
            TBL_transportista.getColumnModel().getColumn(0).setPreferredWidth(1);
            TBL_transportista.getColumnModel().getColumn(1).setResizable(false);
            TBL_transportista.getColumnModel().getColumn(1).setPreferredWidth(130);
            TBL_transportista.getColumnModel().getColumn(2).setResizable(false);
            TBL_transportista.getColumnModel().getColumn(2).setPreferredWidth(130);
            TBL_transportista.getColumnModel().getColumn(3).setResizable(false);
            TBL_transportista.getColumnModel().getColumn(3).setPreferredWidth(30);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable TBL_transportista;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
