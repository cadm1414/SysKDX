package JAVA.CTACOB.GUI;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;

public class pnl_grid_busq_recibo_cobranza extends javax.swing.JPanel {

    public pnl_grid_busq_recibo_cobranza() {
        initComponents();
        go_fnc_operaciones_campos.oculta_columna(TBL_recibo_cobranza, 3);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        TBL_recibo_cobranza = new javax.swing.JTable();

        TBL_recibo_cobranza.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        TBL_recibo_cobranza.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "F. Emision", "Numero Doc.", "Estado", "codigo_op"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
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
        jScrollPane2.setViewportView(TBL_recibo_cobranza);
        if (TBL_recibo_cobranza.getColumnModel().getColumnCount() > 0) {
            TBL_recibo_cobranza.getColumnModel().getColumn(0).setResizable(false);
            TBL_recibo_cobranza.getColumnModel().getColumn(0).setPreferredWidth(25);
            TBL_recibo_cobranza.getColumnModel().getColumn(1).setResizable(false);
            TBL_recibo_cobranza.getColumnModel().getColumn(1).setPreferredWidth(100);
            TBL_recibo_cobranza.getColumnModel().getColumn(2).setResizable(false);
            TBL_recibo_cobranza.getColumnModel().getColumn(2).setPreferredWidth(50);
            TBL_recibo_cobranza.getColumnModel().getColumn(3).setResizable(false);
            TBL_recibo_cobranza.getColumnModel().getColumn(3).setPreferredWidth(0);
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
    public javax.swing.JTable TBL_recibo_cobranza;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
