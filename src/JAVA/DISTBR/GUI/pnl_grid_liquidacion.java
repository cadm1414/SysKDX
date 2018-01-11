package JAVA.DISTBR.GUI;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;

public class pnl_grid_liquidacion extends javax.swing.JPanel {

    public pnl_grid_liquidacion() {
        initComponents();
        go_fnc_operaciones_campos.ancho_columna(TBL_liquidacion, 0, 0);
        go_fnc_operaciones_campos.ancho_columna(TBL_liquidacion, 2, 0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TBL_liquidacion = new javax.swing.JTable();

        TBL_liquidacion.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        TBL_liquidacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "codigo_op", "Item", "codigo_op_ref", "Documento", "Razon Social", "Total Doc.", "E/C", "Dp.", "Acuenta", "Dsc/Rdn", "Importe", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, true, true, true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TBL_liquidacion.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(TBL_liquidacion);
        if (TBL_liquidacion.getColumnModel().getColumnCount() > 0) {
            TBL_liquidacion.getColumnModel().getColumn(0).setResizable(false);
            TBL_liquidacion.getColumnModel().getColumn(0).setPreferredWidth(0);
            TBL_liquidacion.getColumnModel().getColumn(1).setResizable(false);
            TBL_liquidacion.getColumnModel().getColumn(1).setPreferredWidth(0);
            TBL_liquidacion.getColumnModel().getColumn(2).setResizable(false);
            TBL_liquidacion.getColumnModel().getColumn(2).setPreferredWidth(0);
            TBL_liquidacion.getColumnModel().getColumn(3).setResizable(false);
            TBL_liquidacion.getColumnModel().getColumn(3).setPreferredWidth(35);
            TBL_liquidacion.getColumnModel().getColumn(4).setPreferredWidth(200);
            TBL_liquidacion.getColumnModel().getColumn(5).setResizable(false);
            TBL_liquidacion.getColumnModel().getColumn(5).setPreferredWidth(20);
            TBL_liquidacion.getColumnModel().getColumn(6).setResizable(false);
            TBL_liquidacion.getColumnModel().getColumn(6).setPreferredWidth(5);
            TBL_liquidacion.getColumnModel().getColumn(7).setResizable(false);
            TBL_liquidacion.getColumnModel().getColumn(7).setPreferredWidth(5);
            TBL_liquidacion.getColumnModel().getColumn(8).setResizable(false);
            TBL_liquidacion.getColumnModel().getColumn(8).setPreferredWidth(20);
            TBL_liquidacion.getColumnModel().getColumn(9).setResizable(false);
            TBL_liquidacion.getColumnModel().getColumn(9).setPreferredWidth(20);
            TBL_liquidacion.getColumnModel().getColumn(10).setResizable(false);
            TBL_liquidacion.getColumnModel().getColumn(10).setPreferredWidth(20);
            TBL_liquidacion.getColumnModel().getColumn(11).setResizable(false);
            TBL_liquidacion.getColumnModel().getColumn(11).setPreferredWidth(0);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 138, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 24, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable TBL_liquidacion;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
