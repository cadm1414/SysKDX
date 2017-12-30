package JAVA.DISTBR.GUI;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;

public class pnl_grid_busq_programacion extends javax.swing.JPanel {

    public pnl_grid_busq_programacion() {
        initComponents();
        go_fnc_operaciones_campos.ancho_columna(TBL_programacion, 0, 0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        TBL_programacion = new javax.swing.JTable();

        TBL_programacion.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        TBL_programacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "codigo", "F. Emision", "Numero Doc.", "Estado"
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
        jScrollPane2.setViewportView(TBL_programacion);
        if (TBL_programacion.getColumnModel().getColumnCount() > 0) {
            TBL_programacion.getColumnModel().getColumn(0).setResizable(false);
            TBL_programacion.getColumnModel().getColumn(0).setPreferredWidth(0);
            TBL_programacion.getColumnModel().getColumn(1).setResizable(false);
            TBL_programacion.getColumnModel().getColumn(1).setPreferredWidth(25);
            TBL_programacion.getColumnModel().getColumn(2).setResizable(false);
            TBL_programacion.getColumnModel().getColumn(2).setPreferredWidth(100);
            TBL_programacion.getColumnModel().getColumn(3).setResizable(false);
            TBL_programacion.getColumnModel().getColumn(3).setPreferredWidth(50);
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
    public javax.swing.JTable TBL_programacion;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
