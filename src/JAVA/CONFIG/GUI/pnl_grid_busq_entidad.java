package JAVA.CONFIG.GUI;
public class pnl_grid_busq_entidad extends javax.swing.JPanel {

    public pnl_grid_busq_entidad() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TBL_entidad = new javax.swing.JTable(){
            public boolean isCellEditable(int row,int colum){
                return false;
            }
        };

        TBL_entidad.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        TBL_entidad.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Razon Social", "Doc. ID", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TBL_entidad.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(TBL_entidad);
        if (TBL_entidad.getColumnModel().getColumnCount() > 0) {
            TBL_entidad.getColumnModel().getColumn(0).setResizable(false);
            TBL_entidad.getColumnModel().getColumn(0).setPreferredWidth(20);
            TBL_entidad.getColumnModel().getColumn(1).setResizable(false);
            TBL_entidad.getColumnModel().getColumn(1).setPreferredWidth(180);
            TBL_entidad.getColumnModel().getColumn(2).setResizable(false);
            TBL_entidad.getColumnModel().getColumn(2).setPreferredWidth(25);
            TBL_entidad.getColumnModel().getColumn(3).setResizable(false);
            TBL_entidad.getColumnModel().getColumn(3).setPreferredWidth(10);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable TBL_entidad;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
