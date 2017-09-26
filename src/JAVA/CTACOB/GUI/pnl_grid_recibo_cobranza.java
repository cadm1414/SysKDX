
package JAVA.CTACOB.GUI;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;

public class pnl_grid_recibo_cobranza extends javax.swing.JPanel {

    public pnl_grid_recibo_cobranza() {
        initComponents();
        go_fnc_operaciones_campos.oculta_columna(TBL_cobranza, 0);
        go_fnc_operaciones_campos.oculta_columna(TBL_cobranza, 1);
    }

     @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TBL_cobranza = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        LBL_total_pago = new javax.swing.JLabel();
        LBL_simbolo = new javax.swing.JLabel();

        TBL_cobranza.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        TBL_cobranza.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "codigo_rv", "codigo_vendedor", "T.D.", "Serie Doc.", "Numero Doc.", "F. Emision", "C.M.", "Total Doc.", "Pago", "Saldo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TBL_cobranza.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(TBL_cobranza);
        if (TBL_cobranza.getColumnModel().getColumnCount() > 0) {
            TBL_cobranza.getColumnModel().getColumn(0).setResizable(false);
            TBL_cobranza.getColumnModel().getColumn(0).setPreferredWidth(0);
            TBL_cobranza.getColumnModel().getColumn(1).setResizable(false);
            TBL_cobranza.getColumnModel().getColumn(1).setPreferredWidth(0);
            TBL_cobranza.getColumnModel().getColumn(2).setResizable(false);
            TBL_cobranza.getColumnModel().getColumn(2).setPreferredWidth(1);
            TBL_cobranza.getColumnModel().getColumn(3).setResizable(false);
            TBL_cobranza.getColumnModel().getColumn(3).setPreferredWidth(6);
            TBL_cobranza.getColumnModel().getColumn(4).setResizable(false);
            TBL_cobranza.getColumnModel().getColumn(4).setPreferredWidth(30);
            TBL_cobranza.getColumnModel().getColumn(5).setResizable(false);
            TBL_cobranza.getColumnModel().getColumn(5).setPreferredWidth(15);
            TBL_cobranza.getColumnModel().getColumn(6).setResizable(false);
            TBL_cobranza.getColumnModel().getColumn(6).setPreferredWidth(1);
            TBL_cobranza.getColumnModel().getColumn(7).setResizable(false);
            TBL_cobranza.getColumnModel().getColumn(7).setPreferredWidth(30);
            TBL_cobranza.getColumnModel().getColumn(8).setResizable(false);
            TBL_cobranza.getColumnModel().getColumn(8).setPreferredWidth(30);
            TBL_cobranza.getColumnModel().getColumn(9).setResizable(false);
            TBL_cobranza.getColumnModel().getColumn(9).setPreferredWidth(30);
        }

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TOTAL PAGO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 10), new java.awt.Color(0, 153, 153))); // NOI18N

        LBL_total_pago.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        LBL_total_pago.setForeground(new java.awt.Color(255, 0, 0));
        LBL_total_pago.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LBL_total_pago.setText("0.00");

        LBL_simbolo.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        LBL_simbolo.setForeground(new java.awt.Color(255, 0, 0));
        LBL_simbolo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LBL_simbolo.setText("S/.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LBL_simbolo, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LBL_total_pago, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LBL_total_pago)
                    .addComponent(LBL_simbolo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 624, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 14, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel LBL_simbolo;
    public javax.swing.JLabel LBL_total_pago;
    public javax.swing.JTable TBL_cobranza;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
