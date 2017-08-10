package JAVA.INVENT.GUI;

public class pnl_grid_guia_salida extends javax.swing.JPanel {

    public pnl_grid_guia_salida() {
        initComponents();        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TBL_guia_salida = new javax.swing.JTable();

        TBL_guia_salida.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        TBL_guia_salida.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Lote", "C. Articulo", "Nombre", "U.M.", "N. Compra", "P. Produccion", "Bulto", "P. Bruto", "Tara", "P. Neto", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false, false, false, true, true, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TBL_guia_salida.setCellSelectionEnabled(true);
        TBL_guia_salida.setEnabled(false);
        TBL_guia_salida.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(TBL_guia_salida);
        if (TBL_guia_salida.getColumnModel().getColumnCount() > 0) {
            TBL_guia_salida.getColumnModel().getColumn(0).setResizable(false);
            TBL_guia_salida.getColumnModel().getColumn(0).setPreferredWidth(5);
            TBL_guia_salida.getColumnModel().getColumn(1).setResizable(false);
            TBL_guia_salida.getColumnModel().getColumn(1).setPreferredWidth(15);
            TBL_guia_salida.getColumnModel().getColumn(2).setResizable(false);
            TBL_guia_salida.getColumnModel().getColumn(2).setPreferredWidth(40);
            TBL_guia_salida.getColumnModel().getColumn(3).setResizable(false);
            TBL_guia_salida.getColumnModel().getColumn(3).setPreferredWidth(210);
            TBL_guia_salida.getColumnModel().getColumn(4).setResizable(false);
            TBL_guia_salida.getColumnModel().getColumn(4).setPreferredWidth(5);
            TBL_guia_salida.getColumnModel().getColumn(5).setResizable(false);
            TBL_guia_salida.getColumnModel().getColumn(5).setPreferredWidth(50);
            TBL_guia_salida.getColumnModel().getColumn(6).setResizable(false);
            TBL_guia_salida.getColumnModel().getColumn(6).setPreferredWidth(20);
            TBL_guia_salida.getColumnModel().getColumn(7).setResizable(false);
            TBL_guia_salida.getColumnModel().getColumn(7).setPreferredWidth(15);
            TBL_guia_salida.getColumnModel().getColumn(8).setResizable(false);
            TBL_guia_salida.getColumnModel().getColumn(8).setPreferredWidth(30);
            TBL_guia_salida.getColumnModel().getColumn(9).setResizable(false);
            TBL_guia_salida.getColumnModel().getColumn(9).setPreferredWidth(10);
            TBL_guia_salida.getColumnModel().getColumn(10).setResizable(false);
            TBL_guia_salida.getColumnModel().getColumn(10).setPreferredWidth(30);
            TBL_guia_salida.getColumnModel().getColumn(11).setResizable(false);
            TBL_guia_salida.getColumnModel().getColumn(11).setPreferredWidth(1);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 875, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 53, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable TBL_guia_salida;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
